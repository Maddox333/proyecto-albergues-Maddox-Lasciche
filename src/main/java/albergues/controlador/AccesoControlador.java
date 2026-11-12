package albergues.controlador;

import albergues.modelo.ReglaNegocioException;
import albergues.modelo.Usuario;
import albergues.vista.MK12Acceso;
import albergues.vista.ValidacionForma;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.util.Map;

/** AccesoControlador (DDA, sección 3.4): atiende el evento «Ingresar» de MK-12 (CU-01). */
public class AccesoControlador implements HttpHandler {
    @Override
    public void handle(HttpExchange ex) throws IOException {
        Peticion p = new Peticion(ex);
        if (p.ruta().equals("/salir")) {
            Sesiones.cerrar(p);
            ex.getResponseHeaders().add("Set-Cookie", Sesiones.COOKIE + "=; Max-Age=0; Path=/; HttpOnly");
            p.redirigir("/acceso");
            return;
        }
        if (!p.esPost()) {
            String m = "sesion".equals(p.get("motivo")) ? "Inicie sesión para usar el sistema." : null;   // CA-01.4
            p.html(200, MK12Acceso.render("", Map.of(), m));
            return;
        }
        Map<String, String> d = p.mapa();
        Map<String, String> err = ValidacionForma.obligatorios(d, "nombreUsuario", "clave");                // RN-06, CA-01.3
        if (!err.isEmpty()) { p.html(400, MK12Acceso.render(d.get("nombreUsuario"), err, null)); return; }
        try {
            Usuario u = Usuario.autenticar(d.get("nombreUsuario"), d.get("clave"));                      // CA-01.1, CA-01.2, CA-01.5
            ex.getResponseHeaders().add("Set-Cookie", Sesiones.COOKIE + "=" + Sesiones.abrir(u) + "; Path=/; HttpOnly; SameSite=Strict");
            p.redirigir("/censo/hogar");
        } catch (ReglaNegocioException e) {
            p.html(401, MK12Acceso.render(d.get("nombreUsuario"), Map.of(), e.getMessage()));
        }
    }
}
