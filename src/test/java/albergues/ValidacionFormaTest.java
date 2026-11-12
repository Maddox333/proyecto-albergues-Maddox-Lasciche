package albergues;

import static org.junit.jupiter.api.Assertions.*;

import albergues.modelo.TipoDocumento;
import albergues.vista.ValidacionForma;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Validación de forma de la vista (DA-05): RN-06, RN-08 y RN-10. */
class ValidacionFormaTest {

    private Map<String, String> integranteValido() {
        Map<String, String> d = new HashMap<>();
        d.put("tipoDocumento", "CC"); d.put("numeroDocumento", "1035441982"); d.put("nombres", "Laura");
        d.put("apellidos", "Gómez"); d.put("fechaNacimiento", "1988-03-14");
        return d;
    }

    @Test @DisplayName("CA-05.2 · RN-06: se señala el dato obligatorio faltante")
    void datoObligatorioFaltante() {
        Map<String, String> d = integranteValido(); d.put("apellidos", " ");
        Map<String, String> err = ValidacionForma.integrante(d);
        assertEquals(1, err.size());
        assertTrue(err.containsKey("apellidos"));
    }

    @Test @DisplayName("CA-05.3 · RN-08: «10A54» con tipo CC se rechaza con el mensaje de la cédula")
    void formatoCedula() {
        Map<String, String> d = integranteValido(); d.put("numeroDocumento", "10A54");
        assertEquals("La cédula solo admite entre 6 y 11 dígitos.", ValidacionForma.integrante(d).get("numeroDocumento"));
    }

    @Test @DisplayName("RN-08: pasaporte y PPT admiten letras y dígitos; RC, TI, CC y CE solo dígitos")
    void formatosPorTipo() {
        assertNull(ValidacionForma.formatoDocumento(TipoDocumento.PA, "AB123456"));
        assertNull(ValidacionForma.formatoDocumento(TipoDocumento.PPT, "PPT1234567"));
        assertNotNull(ValidacionForma.formatoDocumento(TipoDocumento.TI, "TI12345"));
        assertNotNull(ValidacionForma.formatoDocumento(TipoDocumento.CC, "12345"));
        assertNull(ValidacionForma.formatoDocumento(TipoDocumento.CC, "71654320"));
    }

    @Test @DisplayName("CA-07.3 · RN-10: una condición fuera de la lista rechaza toda la selección")
    void condicionFueraDeLista() {
        assertNull(ValidacionForma.condiciones(List.of("GESTANTE", "DESPLAZADO")));
        assertEquals(2, ValidacionForma.condiciones(List.of("GESTANTE", "NINO")).size());
    }

    @Test @DisplayName("CA-04.2 · RN-06: hogar sin dirección, barrio o municipio")
    void hogarObligatorios() {
        Map<String, String> d = new HashMap<>(); d.put("direccion", "Calle 56"); d.put("barrio", ""); d.put("municipio", "Medellín");
        assertEquals(Map.of("barrio", "Este dato es obligatorio."), ValidacionForma.hogar(d));
    }
}
