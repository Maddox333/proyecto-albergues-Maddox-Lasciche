package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;

/**
 * Clase Voluntario del diagrama de clases (sección 1.8.3); tabla VOLUNTARIO del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class Voluntario {

    // ---- Atributos del diagrama de clases
    private int idVoluntario;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private boolean activo;
    // ---- Asociaciones (cada llave foránea es una referencia al objeto asociado)
    private Usuario usuarioRegistro; // VOLUNTARIO.id_usuario_registro → USUARIO

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Registra un voluntario activo.
     * <p>Trazabilidad: HU-24 · RF-33 · CU-22.</p>
     */
    public static void crear(Voluntario v) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-22).");
    }

    /**
     * Trae los voluntarios activos ordenados por apellido.
     * <p>Trazabilidad: HU-35 · RF-34 · CU-23.</p>
     */
    public static List<Voluntario> listarActivos() {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-23).");
    }

    /**
     * Modifica los datos de un voluntario.
     * <p>Trazabilidad: HU-36 · RF-45 · CU-34.</p>
     */
    public static void actualizar(Voluntario v) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-34).");
    }

    /**
     * Cambia activo a FALSE y conserva sus datos.
     * <p>Trazabilidad: HU-37 · RF-46 · CU-35.</p>
     */
    public static void inactivar(int idVoluntario) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-35).");
    }

    // ---- Acceso a los atributos
    public int getIdVoluntario() { return idVoluntario; }
    public void setIdVoluntario(int idVoluntario) { this.idVoluntario = idVoluntario; }
    public TipoDocumento getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(TipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public Usuario getUsuarioRegistro() { return usuarioRegistro; }
    public void setUsuarioRegistro(Usuario usuarioRegistro) { this.usuarioRegistro = usuarioRegistro; }
}
