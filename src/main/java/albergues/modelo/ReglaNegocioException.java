package albergues.modelo;

/** Rechazo de una operación por una regla de negocio. Lleva el código de la regla (RN-xx) para la trazabilidad. */
public class ReglaNegocioException extends RuntimeException {
    private final String regla;
    public ReglaNegocioException(String regla, String mensaje) { super(mensaje); this.regla = regla; }
    public String getRegla() { return regla; }
}
