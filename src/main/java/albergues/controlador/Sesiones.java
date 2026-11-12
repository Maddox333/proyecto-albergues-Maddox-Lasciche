package albergues.controlador;

import albergues.modelo.Usuario;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Filtro de sesión y permisos (decisión DA-06): ningún evento se atiende sin una sesión de un usuario
 * activo (RN-01, CA-01.4) ni sin el permiso de su rol (RN-05).
 */
final class Sesiones {
    static final String COOKIE = "ALBERGUES_SESION";
    private static final Map<String, Usuario> ACTIVAS = new ConcurrentHashMap<>();
    private static final SecureRandom RND = new SecureRandom();

    private Sesiones() { }

    static String abrir(Usuario u) {
        byte[] b = new byte[24]; RND.nextBytes(b);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(b);
        ACTIVAS.put(token, u);
        return token;
    }

    static Usuario usuario(Peticion p) { String t = p.cookie(COOKIE); return t == null ? null : ACTIVAS.get(t); }

    static void cerrar(Peticion p) { String t = p.cookie(COOKIE); if (t != null) ACTIVAS.remove(t); }

    /** Devuelve el usuario si puede usar la función; si no, responde y devuelve null. */
    static Usuario exigir(Peticion p, String funcion) throws java.io.IOException {
        Usuario u = usuario(p);
        if (u == null) { p.redirigir("/acceso?motivo=sesion"); return null; }            // RN-01, CA-01.4
        if (!u.tienePermiso(funcion)) {                                                   // RN-05
            p.html(403, albergues.vista.Html.pagina("—", "Acceso no autorizado", u.getNombreCompleto(), u.getRol().name(), false, false,
                albergues.vista.Html.alerta("Su rol no tiene permiso para esta función.")));
            return null;
        }
        return u;
    }
}
