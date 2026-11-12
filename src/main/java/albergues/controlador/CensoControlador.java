package albergues.controlador;

import albergues.modelo.AsignacionAlbergue;
import albergues.modelo.CondicionDiferencial;
import albergues.modelo.Hogar;
import albergues.modelo.Integrante;
import albergues.modelo.ReglaNegocioException;
import albergues.modelo.TipoDocumento;
import albergues.modelo.Usuario;
import albergues.vista.MK01Hogar;
import albergues.vista.MK02Integrante;
import albergues.vista.ValidacionForma;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CensoControlador (DDA, sección 3.4). Primer corte vertical:
 * CU-03 registrar hogar, CU-07 consultar hogar, CU-04 registrar integrante (incluye CU-06, extendido por CU-05).
 * Cada invocación al modelo usa solo métodos del diagrama de clases; los comentarios citan el mensaje de DS-04.
 */
public class CensoControlador implements HttpHandler {

    @Override
    public void handle(HttpExchange ex) throws IOException {
        Peticion p = new Peticion(ex);
        String ruta = p.ruta();
        try {
            if (ruta.equals("/censo/hogar") && !p.esPost()) consultarHogar(p);
            else if (ruta.equals("/censo/hogar/nuevo")) formularioHogar(p);
            else if (ruta.equals("/censo/hogar") && p.esPost()) registrarHogar(p);
            else if (ruta.equals("/censo/integrante") && !p.esPost()) formularioIntegrante(p);
            else if (ruta.equals("/censo/integrante") && p.esPost()) registrarIntegrante(p);
            else p.html(404, "No encontrado");
        } catch (RuntimeException e) {
            p.html(500, albergues.vista.Html.pagina("—", "Error", null, null, false, false,
                albergues.vista.Html.alerta("No fue posible completar la operación: " + e.getMessage())));
        }
    }

    private static String q(String s) { return URLEncoder.encode(s == null ? "" : s, StandardCharsets.UTF_8); }

    /** CU-07 · MK-01 «Buscar» → Hogar.buscarPorDocumento() (CA-08.1 a CA-08.3). */
    private void consultarHogar(Peticion p) throws IOException {
        Usuario u = Sesiones.exigir(p, "CONSULTAR_HOGAR"); if (u == null) return;
        boolean registra = u.tienePermiso("CENSO");
        String tipo = p.get("tipo"), numero = p.get("numero");
        Map<String, String> err = new HashMap<>();
        if (tipo == null && numero == null) {
            p.html(200, MK01Hogar.consulta(u.getNombreCompleto(), u.getRol().name(), registra, null, null, err, null, p.get("ok"), null, null, 0));
            return;
        }
        Map<String, String> d = new HashMap<>(); d.put("tipo", tipo); d.put("numero", numero);
        err.putAll(ValidacionForma.obligatorios(d, "tipo", "numero"));                                    // RN-06, CA-08.3
        TipoDocumento t = ValidacionForma.tipoDocumento(tipo);
        if (err.isEmpty() && t == null) err.put("tipo", "Seleccione un tipo de documento de la lista.");
        if (!err.isEmpty()) {
            p.html(400, MK01Hogar.consulta(u.getNombreCompleto(), u.getRol().name(), registra, tipo, numero, err, null, null, null, null, 0));
            return;
        }
        Hogar h = Hogar.buscarPorDocumento(t, numero);
        if (h == null) {                                                                                  // CA-08.2
            p.html(404, MK01Hogar.consulta(u.getNombreCompleto(), u.getRol().name(), registra, tipo, numero, err,
                "No se encontró ningún hogar con " + t + " " + numero.trim() + ".", null, null, null, 0));
            return;
        }
        p.html(200, MK01Hogar.consulta(u.getNombreCompleto(), u.getRol().name(), registra, tipo, numero, err, null, p.get("ok"),
            h, AsignacionAlbergue.albergueActual(h.getIdHogar()), h.totalIntegrantes()));
    }

    private void formularioHogar(Peticion p) throws IOException {
        Usuario u = Sesiones.exigir(p, "CENSO"); if (u == null) return;
        p.html(200, MK01Hogar.nuevo(u.getNombreCompleto(), u.getRol().name(), new HashMap<>(), new HashMap<>()));
    }

    /** CU-03 · MK-01 «Guardar» → Hogar.crear() (CA-04.1, CA-04.2). */
    private void registrarHogar(Peticion p) throws IOException {
        Usuario u = Sesiones.exigir(p, "CENSO"); if (u == null) return;
        Map<String, String> d = p.mapa();
        Map<String, String> err = ValidacionForma.hogar(d);                                               // RN-06
        if (!err.isEmpty()) { p.html(400, MK01Hogar.nuevo(u.getNombreCompleto(), u.getRol().name(), d, err)); return; }
        Hogar h = new Hogar();
        h.setDireccion(d.get("direccion").trim()); h.setBarrio(d.get("barrio").trim()); h.setMunicipio(d.get("municipio").trim());
        h.setTelefonoContacto(d.get("telefonoContacto")); h.setUsuarioRegistro(u);                         // RNF-03: usuario responsable
        Hogar.crear(h);
        p.redirigir("/censo/integrante?idHogar=" + h.getIdHogar() + "&ok=" + q("Hogar registrado correctamente. Agregue sus integrantes."));
    }

    private void formularioIntegrante(Peticion p) throws IOException {
        Usuario u = Sesiones.exigir(p, "CENSO"); if (u == null) return;
        int idHogar = Integer.parseInt(p.get("idHogar"));
        p.html(200, MK02Integrante.render(u.getNombreCompleto(), u.getRol().name(), idHogar, p.mapa(), List.of(), Map.of(), null, p.get("ok")));
    }

    /** CU-04 · MK-02 «Guardar». Sigue el diagrama de secuencia DS-04 (sección 3.5). */
    private void registrarIntegrante(Peticion p) throws IOException {
        Usuario u = Sesiones.exigir(p, "CENSO"); if (u == null) return;
        Map<String, String> d = p.mapa();
        int idHogar = Integer.parseInt(d.get("idHogar"));
        List<String> marcadas = p.todos("condiciones");
        String nombre = u.getNombreCompleto(), rol = u.getRol().name();

        // Nota de DS-04: la vista valida obligatorios y formato [RN-06, RN-08] (FA-01, FA-02)
        Map<String, String> err = ValidacionForma.integrante(d);
        List<CondicionDiferencial> condiciones = ValidacionForma.condiciones(marcadas);                    // RN-10, CA-07.3
        if (condiciones == null) err.put("condiciones", "Seleccione solo condiciones de la lista.");
        if (!err.isEmpty()) { p.html(400, MK02Integrante.render(nombre, rol, idHogar, d, marcadas, err, null, null)); return; }

        TipoDocumento tipo = TipoDocumento.valueOf(d.get("tipoDocumento"));
        String numero = d.get("numeroDocumento").trim();
        // DS-04: existeDocumento(tipo, numero)  [CU-06, RN-07]
        if (Integrante.existeDocumento(tipo, numero)) {
            // DS-04: buscarPorDocumento(tipo, numero) para informar el hogar donde figura (FA-03, FA-04)
            Hogar donde = Hogar.buscarPorDocumento(tipo, numero);
            String alerta = donde == null
                ? "El documento " + tipo + " " + numero + " ya está registrado en el censo."
                : donde.getIdHogar() == idHogar
                    ? "El documento " + tipo + " " + numero + " ya está registrado en este hogar."                                   // FA-04, CA-06.2
                    : "El documento " + tipo + " " + numero + " ya está registrado en el hogar N.º " + donde.getIdHogar()
                      + " (" + donde.getDireccion() + ", " + donde.getBarrio() + ").";                                               // FA-03, CA-06.1
            p.html(409, MK02Integrante.render(nombre, rol, idHogar, d, marcadas, Map.of(), alerta, null));
            return;
        }
        Integrante i = new Integrante();
        Hogar h = new Hogar(); h.setIdHogar(idHogar);
        i.setHogar(h); i.setTipoDocumento(tipo); i.setNumeroDocumento(numero);
        i.setNombres(d.get("nombres")); i.setApellidos(d.get("apellidos")); i.setFechaNacimiento(LocalDate.parse(d.get("fechaNacimiento").trim()));
        try {
            Integrante.crear(i);                                                       // DS-04: crear(i) [RN-09]
        } catch (ReglaNegocioException e) {
            p.html(409, MK02Integrante.render(nombre, rol, idHogar, d, marcadas, Map.of(), e.getMessage(), null));
            return;
        }
        if (!condiciones.isEmpty()) i.asignarCondiciones(condiciones);                // DS-04 opt (CU-05): asignarCondiciones(condiciones)
        int total = h.totalIntegrantes();                                              // DS-04: totalIntegrantes()
        p.redirigir("/censo/hogar?tipo=" + q(tipo.name()) + "&numero=" + q(numero)
            + "&ok=" + q("Integrante registrado. El hogar tiene " + total + (total == 1 ? " integrante." : " integrantes.")));   // CA-05.1
    }
}
