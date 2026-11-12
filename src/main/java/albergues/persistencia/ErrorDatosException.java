package albergues.persistencia;

/** Falla técnica de acceso a datos (no es un rechazo de negocio). */
public class ErrorDatosException extends RuntimeException {
    public ErrorDatosException(Throwable causa) { super("Error de acceso a la base de datos: " + causa.getMessage(), causa); }
}
