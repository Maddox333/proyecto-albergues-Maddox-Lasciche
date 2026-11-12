package albergues.controlador;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Lectura de los parámetros de una petición (consulta o formulario) y escritura de la respuesta. */
final class Peticion {
    final HttpExchange ex;
    final Map<String, List<String>> params = new LinkedHashMap<>();

    Peticion(HttpExchange ex) throws IOException {
        this.ex = ex;
        leer(ex.getRequestURI().getRawQuery());
        if ("POST".equals(ex.getRequestMethod()))
            leer(new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
    }

    private void leer(String raw) {
        if (raw == null || raw.isEmpty()) return;
        for (String par : raw.split("&")) {
            int i = par.indexOf('=');
            String k = URLDecoder.decode(i < 0 ? par : par.substring(0, i), StandardCharsets.UTF_8);
            String v = i < 0 ? "" : URLDecoder.decode(par.substring(i + 1), StandardCharsets.UTF_8);
            params.computeIfAbsent(k, x -> new ArrayList<>()).add(v);
        }
    }

    String get(String k) { List<String> v = params.get(k); return v == null ? null : v.get(0); }
    List<String> todos(String k) { return params.getOrDefault(k, List.of()); }

    Map<String, String> mapa() {
        Map<String, String> m = new HashMap<>();
        params.forEach((k, v) -> m.put(k, v.get(0)));
        return m;
    }

    boolean esPost() { return "POST".equals(ex.getRequestMethod()); }
    String ruta() { return ex.getRequestURI().getPath(); }

    String cookie(String nombre) {
        for (String h : ex.getRequestHeaders().getOrDefault("Cookie", List.of()))
            for (String c : h.split(";")) {
                String[] p = c.trim().split("=", 2);
                if (p.length == 2 && p[0].equals(nombre)) return p[1];
            }
        return null;
    }

    void html(int estado, String cuerpo) throws IOException {
        byte[] b = cuerpo.getBytes(StandardCharsets.UTF_8);
        ex.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
        ex.sendResponseHeaders(estado, b.length);
        ex.getResponseBody().write(b);
        ex.close();
    }

    void redirigir(String destino) throws IOException {
        ex.getResponseHeaders().set("Location", destino);
        ex.sendResponseHeaders(303, -1);
        ex.close();
    }
}
