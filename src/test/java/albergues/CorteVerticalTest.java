package albergues;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.net.httpserver.HttpServer;
import java.net.CookieManager;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Corte vertical completo por HTTP: pantalla → controlador → modelo → base de datos (MK-12, MK-01, MK-02). */
class CorteVerticalTest {
    private HttpServer servidor;
    private String base;
    private HttpClient cliente;

    @BeforeEach void iniciar() throws Exception {
        BaseDatosPrueba.nueva();
        servidor = Aplicacion.iniciar(0);
        base = "http://localhost:" + servidor.getAddress().getPort();
        cliente = HttpClient.newBuilder().cookieHandler(new CookieManager()).followRedirects(HttpClient.Redirect.NEVER).build();
    }

    @AfterEach void detener() { servidor.stop(0); }

    private HttpResponse<String> get(String ruta) throws Exception {
        return cliente.send(HttpRequest.newBuilder(URI.create(base + ruta)).GET().build(), HttpResponse.BodyHandlers.ofString());
    }

    private HttpResponse<String> post(String ruta, Map<String, String> datos) throws Exception {
        String cuerpo = datos.entrySet().stream()
            .map(e -> URLEncoder.encode(e.getKey(), StandardCharsets.UTF_8) + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
            .collect(Collectors.joining("&"));
        return cliente.send(HttpRequest.newBuilder(URI.create(base + ruta)).header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString(cuerpo)).build(), HttpResponse.BodyHandlers.ofString());
    }

    private String destino(HttpResponse<String> r) { return r.headers().firstValue("Location").orElse(""); }

    @Test @DisplayName("CA-01.4 · RN-01: sin sesión no se muestra información y se pide autenticación")
    void sinSesion() throws Exception {
        HttpResponse<String> r = get("/censo/hogar?tipo=CC&numero=1035441982");
        assertEquals(303, r.statusCode());
        assertTrue(destino(r).startsWith("/acceso"));
    }

    @Test @DisplayName("CU-03 → CU-04 → CU-06 → CU-07: registrar hogar, integrante, duplicado y consulta")
    void recorridoCompleto() throws Exception {
        assertEquals(401, post("/acceso", Map.of("nombreUsuario", "lrestrepo", "clave", "otra")).statusCode());          // CA-01.2
        assertEquals(303, post("/acceso", Map.of("nombreUsuario", "lrestrepo", "clave", BaseDatosPrueba.CLAVE)).statusCode()); // CA-01.1

        HttpResponse<String> h = post("/censo/hogar", Map.of("direccion", "Calle 56 # 17-20", "barrio", "Villatina", "municipio", "Medellín", "telefonoContacto", ""));
        assertEquals(303, h.statusCode());                                                                                  // CA-04.1
        String idHogar = destino(h).replaceAll(".*idHogar=(\\d+).*", "$1");

        Map<String, String> laura = Map.of("idHogar", idHogar, "tipoDocumento", "CC", "numeroDocumento", "1035441982",
            "nombres", "Laura", "apellidos", "Gómez", "fechaNacimiento", "1988-03-14", "condiciones", "GESTANTE");
        HttpResponse<String> mal = post("/censo/integrante", Map.of("idHogar", idHogar, "tipoDocumento", "CC", "numeroDocumento", "10A54",
            "nombres", "Laura", "apellidos", "Gómez", "fechaNacimiento", "1988-03-14"));
        assertEquals(400, mal.statusCode());                                                                                // CA-05.3
        assertTrue(mal.body().contains("La cédula solo admite entre 6 y 11 dígitos."));

        HttpResponse<String> ok = post("/censo/integrante", laura);
        assertEquals(303, ok.statusCode());                                                                                 // CA-05.1
        HttpResponse<String> ficha = get(destino(ok));
        assertTrue(ficha.body().contains("El hogar tiene 1 integrante."));
        assertTrue(ficha.body().contains("Gestante"));                                                                      // CA-07.1

        HttpResponse<String> dup = post("/censo/integrante", laura);
        assertEquals(409, dup.statusCode());                                                                                // CA-06.2
        assertTrue(dup.body().contains("ya está registrado en este hogar"));

        HttpResponse<String> vacio = get("/censo/hogar?tipo=CC&numero=99999999");
        assertTrue(vacio.body().contains("No se encontró ningún hogar con CC 99999999."));                                  // CA-08.2
    }

    @Test @DisplayName("RN-05: el Coordinador consulta hogares pero no registra en el censo")
    void permisosPorRol() throws Exception {
        post("/acceso", Map.of("nombreUsuario", "arios", "clave", BaseDatosPrueba.CLAVE));
        assertEquals(200, get("/censo/hogar").statusCode());
        assertEquals(403, post("/censo/hogar", Map.of("direccion", "x", "barrio", "y", "municipio", "z")).statusCode());
    }
}
