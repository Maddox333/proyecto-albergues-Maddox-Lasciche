package albergues;

import albergues.persistencia.Claves;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Base de datos de prueba: H2 en memoria en modo MySQL, creada con el mismo script de la raíz del
 * repositorio (albergues_ddl.sql). Cada prueba usa una base nueva, así no dependen unas de otras.
 */
public final class BaseDatosPrueba {
    private static final AtomicInteger N = new AtomicInteger();
    public static final String CLAVE = "Albergues2026";
    private static final String HASH = Claves.hash(CLAVE);

    private BaseDatosPrueba() { }

    public static void nueva() throws Exception {
        String url = "jdbc:h2:mem:albergues" + N.incrementAndGet() + ";MODE=MySQL;DATABASE_TO_UPPER=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;DB_CLOSE_DELAY=-1";
        System.setProperty("albergues.db.url", url);
        System.setProperty("albergues.db.usuario", "sa");
        System.setProperty("albergues.db.clave", "");
        // Se quitan los comentarios antes de separar las sentencias por punto y coma.
        String ddl = Files.readString(Path.of("albergues_ddl.sql")).lines()
            .map(l -> l.replaceAll("\\s*--.*$", ""))
            .filter(l -> !l.isBlank())
            .reduce("", (x, y) -> x + "\n" + y);
        try (Connection c = DriverManager.getConnection(url, "sa", ""); Statement s = c.createStatement()) {
            for (String st : ddl.split(";")) {
                String limpio = st.trim();
                if (limpio.isEmpty() || limpio.startsWith("CREATE DATABASE") || limpio.startsWith("USE ")) continue;
                s.execute(limpio);
            }
            s.execute("INSERT INTO ALBERGUE (nombre, direccion, municipio, capacidad_maxima) VALUES ('Coliseo Villatina', 'Calle 56 # 17-20', 'Medellín', 120)");
            s.execute("INSERT INTO USUARIO (nombre_completo, nombre_usuario, clave_hash, rol) VALUES ('Laura Restrepo', 'lrestrepo', '" + HASH + "', 'FUNCIONARIO')");
            s.execute("INSERT INTO USUARIO (nombre_completo, nombre_usuario, clave_hash, rol, id_albergue) VALUES ('Andrés Ríos', 'arios', '" + HASH + "', 'COORDINADOR', 1)");
            s.execute("INSERT INTO USUARIO (nombre_completo, nombre_usuario, clave_hash, rol, activo) VALUES ('Usuario Inactivo', 'inactivo', '" + HASH + "', 'FUNCIONARIO', FALSE)");
        }
    }
}
