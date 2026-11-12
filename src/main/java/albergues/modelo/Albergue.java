package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;

/**
 * Clase Albergue del diagrama de clases (sección 1.8.3); tabla ALBERGUE del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class Albergue {

    // ---- Atributos del diagrama de clases
    private int idAlbergue;
    private String nombre;
    private String direccion;
    private String municipio;
    private int capacidadMaxima;
    private boolean activo;

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Registra y habilita un albergue.
     * <p>Trazabilidad: HU-12 · RF-17 · CU-11.</p>
     */
    public static void crear(Albergue a) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-11).");
    }

    /**
     * Trae los albergues activos con su capacidad.
     * <p>Trazabilidad: HU-15 · RF-21 · CU-14.</p>
     */
    public static List<Albergue> listarActivos() {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-14).");
    }

    /**
     * Suma los integrantes activos de los hogares alojados.
     * <p>Trazabilidad: HU-15, HU-30, HU-31 · RF-21, RF-41 · CU-14, CU-29, CU-30.</p>
     */
    public int ocupacionActual() {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-14, CU-29, CU-30).");
    }

    /**
     * Calcula capacidad máxima menos ocupación.
     * <p>Trazabilidad: HU-13, HU-15, HU-30 · RF-19, RF-21 · CU-12, CU-14, CU-29.</p>
     */
    public int cuposDisponibles() {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-12, CU-14, CU-29).");
    }

    /**
     * Modifica los datos o la capacidad de un albergue.
     * <p>Trazabilidad: HU-30 · RF-40 · CU-29.</p>
     */
    public static void actualizar(Albergue a) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-29).");
    }

    /**
     * Cambia activo a FALSE y conserva sus asignaciones.
     * <p>Trazabilidad: HU-31 · RF-41 · CU-30.</p>
     */
    public static void inactivar(int idAlbergue) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-30).");
    }

    // ---- Acceso a los atributos
    public int getIdAlbergue() { return idAlbergue; }
    public void setIdAlbergue(int idAlbergue) { this.idAlbergue = idAlbergue; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}
