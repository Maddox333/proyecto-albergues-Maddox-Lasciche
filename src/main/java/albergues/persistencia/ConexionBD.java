package albergues.persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Capa de persistencia (DDA, sección 3.4): abre las conexiones con la base de datos MySQL.
 * La configuración se lee de albergues.properties y puede reemplazarse con propiedades del sistema
 * (albergues.db.url, albergues.db.usuario, albergues.db.clave), como hacen las pruebas con H2.
 */
public final class ConexionBD {
    private static final Properties CONF = new Properties();
    static {
        try (InputStream in = ConexionBD.class.getResourceAsStream("/albergues.properties")) {
            if (in != null) CONF.load(in);
        } catch (Exception e) { throw new IllegalStateException("No se pudo leer albergues.properties", e); }
    }

    private ConexionBD() { }

    private static String valor(String clave) {
        String env = System.getenv(clave.toUpperCase().replace('.', '_'));
        return System.getProperty(clave, env != null ? env : CONF.getProperty(clave, ""));
    }

    /** Abre una conexión nueva; quien la abre la cierra (try-with-resources). */
    public static Connection abrir() throws SQLException {
        return DriverManager.getConnection(valor("albergues.db.url"), valor("albergues.db.usuario"), valor("albergues.db.clave"));
    }
}
