package albergues;

import static org.junit.jupiter.api.Assertions.*;

import albergues.modelo.CondicionDiferencial;
import albergues.modelo.Hogar;
import albergues.modelo.Integrante;
import albergues.modelo.ReglaNegocioException;
import albergues.modelo.TipoDocumento;
import albergues.modelo.Usuario;
import albergues.persistencia.ConexionBD;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** CU-03, CU-04, CU-05, CU-06 y CU-07: métodos de Hogar e Integrante contra la base de datos. */
class CensoTest {
    private Usuario funcionario;

    @BeforeEach void base() throws Exception {
        BaseDatosPrueba.nueva();
        funcionario = Usuario.autenticar("lrestrepo", BaseDatosPrueba.CLAVE);
    }

    private Hogar hogar(String direccion) {
        Hogar h = new Hogar();
        h.setDireccion(direccion); h.setBarrio("Villatina"); h.setMunicipio("Medellín"); h.setUsuarioRegistro(funcionario);
        Hogar.crear(h);
        return h;
    }

    private Integrante integrante(Hogar h, TipoDocumento t, String numero) {
        Integrante i = new Integrante();
        i.setHogar(h); i.setTipoDocumento(t); i.setNumeroDocumento(numero);
        i.setNombres("Laura"); i.setApellidos("Gómez"); i.setFechaNacimiento(LocalDate.of(1988, 3, 14));
        return i;
    }

    @Test @DisplayName("CA-04.1 · RNF-03: el hogar queda activo, con identificador, fecha y usuario")
    void registrarHogar() throws Exception {
        Hogar h = hogar("Calle 56 # 17-20");
        assertTrue(h.getIdHogar() > 0);
        assertTrue(h.isActivo());
        assertNotNull(h.getFechaRegistro());
        try (Connection c = ConexionBD.abrir(); Statement s = c.createStatement();
             var rs = s.executeQuery("SELECT id_usuario_registro FROM HOGAR WHERE id_hogar = " + h.getIdHogar())) {
            rs.next(); assertEquals(funcionario.getIdUsuario(), rs.getInt(1));
        }
    }

    @Test @DisplayName("CA-05.1 · RN-09: el integrante queda activo, asociado al hogar, y el total se actualiza")
    void registrarIntegrante() {
        Hogar h = hogar("Calle 56 # 17-20");
        assertEquals(0, h.totalIntegrantes());
        Integrante i = integrante(h, TipoDocumento.CC, "1035441982");
        Integrante.crear(i);
        assertTrue(i.getIdIntegrante() > 0);
        assertEquals(1, h.totalIntegrantes());
    }

    @Test @DisplayName("CA-06.1 · RN-07: un documento registrado en otro hogar se detecta y no se duplica")
    void documentoEnOtroHogar() {
        Hogar a = hogar("Calle 56 # 17-20"), b = hogar("Carrera 15 # 60-10");
        Integrante.crear(integrante(a, TipoDocumento.CC, "1035441982"));
        assertTrue(Integrante.existeDocumento(TipoDocumento.CC, "1035441982"));
        assertEquals(a.getIdHogar(), Hogar.buscarPorDocumento(TipoDocumento.CC, "1035441982").getIdHogar());
        ReglaNegocioException e = assertThrows(ReglaNegocioException.class, () -> Integrante.crear(integrante(b, TipoDocumento.CC, "1035441982")));
        assertEquals("RN-07", e.getRegla());
        assertEquals(0, b.totalIntegrantes());
    }

    @Test @DisplayName("CA-06.2 y CA-06.3 · RN-07: en el mismo hogar no se crea un segundo registro y el original no cambia")
    void documentoEnMismoHogar() {
        Hogar a = hogar("Calle 56 # 17-20");
        Integrante.crear(integrante(a, TipoDocumento.CC, "1035441982"));
        assertThrows(ReglaNegocioException.class, () -> Integrante.crear(integrante(a, TipoDocumento.CC, "1035441982")));
        assertEquals(1, a.totalIntegrantes());
        assertEquals("Laura", Hogar.buscarPorDocumento(TipoDocumento.CC, "1035441982").getIntegrantes().get(0).getNombres());
    }

    @Test @DisplayName("RN-09: no se registra un integrante en un hogar inexistente o inactivo")
    void hogarInactivo() throws Exception {
        Hogar a = hogar("Calle 56 # 17-20");
        try (Connection c = ConexionBD.abrir(); Statement s = c.createStatement()) {
            s.executeUpdate("UPDATE HOGAR SET activo = FALSE WHERE id_hogar = " + a.getIdHogar());
        }
        assertEquals("RN-09", assertThrows(ReglaNegocioException.class, () -> Integrante.crear(integrante(a, TipoDocumento.CC, "71654320"))).getRegla());
        Hogar fantasma = new Hogar(); fantasma.setIdHogar(999);
        assertEquals("RN-09", assertThrows(ReglaNegocioException.class, () -> Integrante.crear(integrante(fantasma, TipoDocumento.CC, "71654321"))).getRegla());
    }

    @Test @DisplayName("CA-07.1 y CA-07.2 · RN-10: asignar condiciones o dejar al integrante sin ellas")
    void enfoqueDiferencial() {
        Hogar a = hogar("Calle 56 # 17-20");
        Integrante i = integrante(a, TipoDocumento.CC, "1035441982"); Integrante.crear(i);
        Integrante j = integrante(a, TipoDocumento.RC, "1122334455"); Integrante.crear(j);
        i.asignarCondiciones(List.of(CondicionDiferencial.GESTANTE, CondicionDiferencial.MINORIA_ETNICA));
        Hogar h = Hogar.buscarPorDocumento(TipoDocumento.CC, "1035441982");
        assertEquals(List.of(CondicionDiferencial.GESTANTE, CondicionDiferencial.MINORIA_ETNICA), h.getIntegrantes().get(0).getCondiciones());
        assertTrue(h.getIntegrantes().get(1).getCondiciones().isEmpty());
    }

    @Test @DisplayName("CA-08.1 y CA-08.2: consulta con y sin resultado")
    void consultarHogar() {
        Hogar a = hogar("Calle 56 # 17-20");
        Integrante.crear(integrante(a, TipoDocumento.CC, "1035441982"));
        Hogar h = Hogar.buscarPorDocumento(TipoDocumento.CC, "1035441982");
        assertEquals("Calle 56 # 17-20", h.getDireccion());
        assertEquals(1, h.getIntegrantes().size());
        assertNull(Hogar.buscarPorDocumento(TipoDocumento.CC, "99999999"));
    }
}
