package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;

/**
 * Clase Entrega del diagrama de clases (sección 1.8.3); tabla ENTREGA del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class Entrega {

    // ---- Atributos del diagrama de clases
    private int idEntrega;
    private int cantidad;
    private LocalDateTime fechaHora;
    private String firmaBeneficiario;
    // ---- Asociaciones (cada llave foránea es una referencia al objeto asociado)
    private Integrante integrante; // ENTREGA.id_integrante → INTEGRANTE
    private TipoAyuda tipoAyuda; // ENTREGA.id_tipo_ayuda → TIPO_AYUDA
    private Usuario usuarioResponsable; // ENTREGA.id_usuario_responsable → USUARIO

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Registra una entrega a un beneficiario verificado.
     * <p>Trazabilidad: HU-19, HU-20 · RF-26, RF-27 · CU-18.</p>
     */
    public static void registrar(Entrega e) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-18).");
    }

    /**
     * Asocia la firma digital del beneficiario a la entrega.
     * <p>Trazabilidad: HU-21 · RF-29, RF-30 · CU-19.</p>
     */
    public void capturarFirma(String firma) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-19).");
    }

    /**
     * Trae las entregas de un hogar en orden cronológico.
     * <p>Trazabilidad: HU-22 · RF-31 · CU-20.</p>
     */
    public static List<Entrega> listarPorHogar(int idHogar) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-20).");
    }

    /**
     * Trae las entregas de un tipo de ayuda.
     * <p>Trazabilidad: HU-23 · RF-32 · CU-21.</p>
     */
    public static List<Entrega> listarPorTipo(int idTipoAyuda) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-21).");
    }

    // ---- Acceso a los atributos
    public int getIdEntrega() { return idEntrega; }
    public void setIdEntrega(int idEntrega) { this.idEntrega = idEntrega; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public String getFirmaBeneficiario() { return firmaBeneficiario; }
    public void setFirmaBeneficiario(String firmaBeneficiario) { this.firmaBeneficiario = firmaBeneficiario; }
    public Integrante getIntegrante() { return integrante; }
    public void setIntegrante(Integrante integrante) { this.integrante = integrante; }
    public TipoAyuda getTipoAyuda() { return tipoAyuda; }
    public void setTipoAyuda(TipoAyuda tipoAyuda) { this.tipoAyuda = tipoAyuda; }
    public Usuario getUsuarioResponsable() { return usuarioResponsable; }
    public void setUsuarioResponsable(Usuario usuarioResponsable) { this.usuarioResponsable = usuarioResponsable; }
}
