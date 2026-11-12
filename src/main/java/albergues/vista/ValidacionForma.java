package albergues.vista;

import albergues.modelo.CondicionDiferencial;
import albergues.modelo.TipoDocumento;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Validación de forma en la vista (decisión DA-05): datos obligatorios (RN-06), formato del documento
 * según su tipo (RN-08) y condiciones de la lista (RN-10). No consulta la base de datos, por lo que
 * también puede ejecutarse sin conexión. Devuelve, por campo, el mensaje que la pantalla señala.
 */
public final class ValidacionForma {
    private ValidacionForma() { }

    /** RN-06: señala cada dato obligatorio vacío (CA-04.2, CA-05.2, CA-08.3, CA-01.3). */
    public static Map<String, String> obligatorios(Map<String, String> datos, String... campos) {
        Map<String, String> err = new LinkedHashMap<>();
        for (String c : campos) {
            String v = datos.get(c);
            if (v == null || v.isBlank()) err.put(c, "Este dato es obligatorio.");
        }
        return err;
    }

    /** RN-08: RC, TI, CC y CE solo admiten dígitos (6 a 11); PA y PPT admiten letras y dígitos (6 a 15). */
    public static String formatoDocumento(TipoDocumento tipo, String numero) {
        String n = numero == null ? "" : numero.trim();
        return switch (tipo) {
            case RC -> n.matches("\\d{6,11}") ? null : "El registro civil solo admite entre 6 y 11 dígitos.";
            case TI -> n.matches("\\d{6,11}") ? null : "La tarjeta de identidad solo admite entre 6 y 11 dígitos.";
            case CC -> n.matches("\\d{6,11}") ? null : "La cédula solo admite entre 6 y 11 dígitos.";
            case CE -> n.matches("\\d{6,11}") ? null : "La cédula de extranjería solo admite entre 6 y 11 dígitos.";
            case PA -> n.matches("[A-Za-z0-9]{6,15}") ? null : "El pasaporte solo admite letras y dígitos, entre 6 y 15.";
            case PPT -> n.matches("[A-Za-z0-9]{6,15}") ? null : "El permiso por protección temporal solo admite letras y dígitos, entre 6 y 15.";
        };
    }

    /** Convierte el tipo de documento; null si no pertenece a la lista. */
    public static TipoDocumento tipoDocumento(String v) {
        try { return v == null ? null : TipoDocumento.valueOf(v.trim()); } catch (IllegalArgumentException e) { return null; }
    }

    /** RN-10: solo valores de la lista; si alguno no pertenece, se rechaza todo (CA-07.3). */
    public static List<CondicionDiferencial> condiciones(List<String> valores) {
        List<CondicionDiferencial> out = new ArrayList<>();
        for (String v : valores) {
            try { out.add(CondicionDiferencial.valueOf(v)); }
            catch (IllegalArgumentException e) { return null; }
        }
        return out;
    }

    /** Valida el formulario de integrante de MK-02 (RN-06, RN-08). */
    public static Map<String, String> integrante(Map<String, String> d) {
        Map<String, String> err = obligatorios(d, "tipoDocumento", "numeroDocumento", "nombres", "apellidos", "fechaNacimiento");
        TipoDocumento t = tipoDocumento(d.get("tipoDocumento"));
        if (!err.containsKey("tipoDocumento") && t == null) err.put("tipoDocumento", "Seleccione un tipo de documento de la lista.");
        if (t != null && !err.containsKey("numeroDocumento")) {
            String f = formatoDocumento(t, d.get("numeroDocumento"));
            if (f != null) err.put("numeroDocumento", f);
        }
        if (!err.containsKey("fechaNacimiento")) {
            try {
                if (LocalDate.parse(d.get("fechaNacimiento").trim()).isAfter(LocalDate.now()))
                    err.put("fechaNacimiento", "La fecha de nacimiento no puede ser posterior a hoy.");
            } catch (DateTimeParseException e) { err.put("fechaNacimiento", "Use el formato AAAA-MM-DD."); }
        }
        return err;
    }

    /** Valida el formulario de hogar de MK-01 (RN-06). El teléfono es opcional. */
    public static Map<String, String> hogar(Map<String, String> d) {
        Map<String, String> err = obligatorios(d, "direccion", "barrio", "municipio");
        String tel = d.get("telefonoContacto");
        if (tel != null && !tel.isBlank() && !tel.trim().matches("\\d{7,10}"))
            err.put("telefonoContacto", "El teléfono admite entre 7 y 10 dígitos.");
        return err;
    }
}
