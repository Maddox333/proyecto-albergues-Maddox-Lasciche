package albergues.vista;

import java.util.Map;

/** MK-12 · Inicio de sesión (CU-01; HU-01). Botón «Ingresar» → Usuario.autenticar(). */
public final class MK12Acceso {
    private MK12Acceso() { }

    public static String render(String usuario, Map<String, String> errores, String mensaje) {
        String cuerpo = Html.alerta(mensaje)
            + "<form class=\"box\" method=\"post\" action=\"/acceso\" style=\"max-width:420px\">"
            + "<div class=\"row\">" + Html.campo("nombreUsuario", "Nombre de usuario", usuario, errores.get("nombreUsuario"), "autocomplete=\"username\"") + "</div>"
            + "<div class=\"row\">" + Html.campo("clave", "Clave", "", errores.get("clave"), "type=\"password\" autocomplete=\"current-password\"") + "</div>"
            + "<button class=\"btn p\" type=\"submit\">Ingresar</button></form>";
        return Html.pagina("MK-12", "Iniciar sesión", null, null, false, false, cuerpo);
    }
}
