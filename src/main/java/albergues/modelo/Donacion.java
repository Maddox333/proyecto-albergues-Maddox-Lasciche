package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;

/**
 * Clase Donacion del diagrama de clases (sección 1.8.3); tabla DONACION del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class Donacion {

    // ---- Atributos del diagrama de clases
    private int idDonacion;
    private int cantidad;
    private String origen;
    private LocalDateTime fechaRecepcion;
    // ---- Asociaciones (cada llave foránea es una referencia al objeto asociado)
    private TipoAyuda tipoAyuda; // DONACION.id_tipo_ayuda → TIPO_AYUDA
    private Usuario usuarioRegistro; // DONACION.id_usuario_registro → USUARIO

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Registra una donación con su origen y fecha.
     * <p>Trazabilidad: HU-16 · RF-22, RF-23 · CU-15.</p>
     */
    public static void registrar(Donacion d) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-15).");
    }

    /**
     * Trae las donaciones de un tipo de ayuda.
     * <p>Trazabilidad: HU-23 · RF-32 · CU-21.</p>
     */
    public static List<Donacion> listarPorTipo(int idTipoAyuda) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-21).");
    }

    // ---- Acceso a los atributos
    public int getIdDonacion() { return idDonacion; }
    public void setIdDonacion(int idDonacion) { this.idDonacion = idDonacion; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public LocalDateTime getFechaRecepcion() { return fechaRecepcion; }
    public void setFechaRecepcion(LocalDateTime fechaRecepcion) { this.fechaRecepcion = fechaRecepcion; }
    public TipoAyuda getTipoAyuda() { return tipoAyuda; }
    public void setTipoAyuda(TipoAyuda tipoAyuda) { this.tipoAyuda = tipoAyuda; }
    public Usuario getUsuarioRegistro() { return usuarioRegistro; }
    public void setUsuarioRegistro(Usuario usuarioRegistro) { this.usuarioRegistro = usuarioRegistro; }
}
