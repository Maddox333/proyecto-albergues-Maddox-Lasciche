package albergues;

import albergues.controlador.AccesoControlador;
import albergues.controlador.CensoControlador;
import albergues.vista.Html;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * Punto de entrada: servidor de aplicaciones de la vista física del DDA (sección 3.4.3).
 * Registra los controladores del primer corte vertical. Puerto: propiedad albergues.puerto (8080 por defecto).
 */
public final class Aplicacion {
    private Aplicacion() { }

    public static HttpServer iniciar(int puerto) throws IOException {
        HttpServer s = HttpServer.create(new InetSocketAddress(puerto), 0);
        AccesoControlador acceso = new AccesoControlador();
        s.createContext("/acceso", acceso);
        s.createContext("/salir", acceso);
        s.createContext("/censo/", new CensoControlador());
        s.createContext("/estilos.css", ex -> {
            byte[] b = Html.CSS.getBytes(StandardCharsets.UTF_8);
            ex.getResponseHeaders().set("Content-Type", "text/css; charset=utf-8");
            ex.sendResponseHeaders(200, b.length); ex.getResponseBody().write(b); ex.close();
        });
        s.createContext("/", ex -> { ex.getResponseHeaders().set("Location", "/acceso"); ex.sendResponseHeaders(303, -1); ex.close(); });
        s.start();
        return s;
    }

    public static void main(String[] args) throws IOException {
        int puerto = Integer.parseInt(System.getProperty("albergues.puerto", "8080"));
        iniciar(puerto);
        System.out.println("Sistema de albergues en http://localhost:" + puerto + "/");
    }
}
