package albergues;

import static org.junit.jupiter.api.Assertions.*;

import albergues.modelo.ReglaNegocioException;
import albergues.modelo.Rol;
import albergues.modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** CU-01 · HU-01: Usuario.autenticar() y Usuario.tienePermiso(). */
class UsuarioTest {
    @BeforeEach void base() throws Exception { BaseDatosPrueba.nueva(); }

    @Test @DisplayName("CA-01.1 · RN-01, RN-05: inicia sesión y solo ofrece las funciones del rol")
    void inicioExitoso() {
        Usuario u = Usuario.autenticar("lrestrepo", BaseDatosPrueba.CLAVE);
        assertEquals(Rol.FUNCIONARIO, u.getRol());
        assertTrue(u.tienePermiso("CENSO"));
        assertFalse(u.tienePermiso("USUARIOS"));
        Usuario c = Usuario.autenticar("arios", BaseDatosPrueba.CLAVE);
        assertTrue(c.tienePermiso("CONSULTAR_HOGAR"));
        assertFalse(c.tienePermiso("CENSO"));
    }

    @Test @DisplayName("CA-01.2 · RN-01: clave incorrecta")
    void claveIncorrecta() {
        ReglaNegocioException e = assertThrows(ReglaNegocioException.class, () -> Usuario.autenticar("lrestrepo", "otra"));
        assertEquals("Usuario o clave incorrectos.", e.getMessage());
    }

    @Test @DisplayName("CA-01.3 · RN-06: nombre de usuario o clave vacíos")
    void datoFaltante() {
        assertEquals("RN-06", assertThrows(ReglaNegocioException.class, () -> Usuario.autenticar("", "x")).getRegla());
    }

    @Test @DisplayName("CA-01.5 · RN-34: un usuario inactivo no inicia sesión")
    void usuarioInactivo() {
        ReglaNegocioException e = assertThrows(ReglaNegocioException.class, () -> Usuario.autenticar("inactivo", BaseDatosPrueba.CLAVE));
        assertEquals("El usuario está inactivo. Comuníquese con el Administrador.", e.getMessage());
    }
}
