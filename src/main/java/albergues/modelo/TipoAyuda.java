package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;

/**
 * Clase TipoAyuda del diagrama de clases (sección 1.8.3); tabla TIPO_AYUDA del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class TipoAyuda {

    // ---- Atributos del diagrama de clases
    private int idTipoAyuda;
    private String nombre;
    private String unidadMedida;
    private boolean activo;

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Registra un tipo de ayuda activo.
     * <p>Trazabilidad: HU-32 · RF-42 · CU-31.</p>
     */
    public static void crear(TipoAyuda t) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-31).");
    }

    /**
     * Verifica si ya existe un tipo de ayuda con ese nombre.
     * <p>Trazabilidad: HU-16, HU-32, HU-33 · RF-23, RF-42, RF-43 · CU-15, CU-31, CU-32.</p>
     */
    public static boolean existeNombre(String nombre) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-15, CU-31, CU-32).");
    }

    /**
     * Trae los tipos de ayuda activos.
     * <p>Trazabilidad: HU-17 · RF-24 · CU-16.</p>
     */
    public static List<TipoAyuda> listarActivos() {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-16).");
    }

    /**
     * Calcula lo recibido menos lo entregado.
     * <p>Trazabilidad: HU-16, HU-17, HU-20, HU-23, HU-34 · RF-24, RF-27, RF-44 · CU-15, CU-16, CU-18, CU-21, CU-33.</p>
     */
    public int existencias() {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-15, CU-16, CU-18, CU-21, CU-33).");
    }

    /**
     * Indica si las existencias cubren una cantidad.
     * <p>Trazabilidad: HU-20 · RF-28 · CU-18.</p>
     */
    public boolean hayExistencias(int cantidad) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-18).");
    }

    /**
     * Modifica el nombre o la unidad de medida.
     * <p>Trazabilidad: HU-33 · RF-43 · CU-32.</p>
     */
    public static void actualizar(TipoAyuda t) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-32).");
    }

    /**
     * Cambia activo a FALSE y conserva donaciones y entregas.
     * <p>Trazabilidad: HU-34 · RF-44 · CU-33.</p>
     */
    public static void inactivar(int idTipoAyuda) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-33).");
    }

    // ---- Acceso a los atributos
    public int getIdTipoAyuda() { return idTipoAyuda; }
    public void setIdTipoAyuda(int idTipoAyuda) { this.idTipoAyuda = idTipoAyuda; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}
