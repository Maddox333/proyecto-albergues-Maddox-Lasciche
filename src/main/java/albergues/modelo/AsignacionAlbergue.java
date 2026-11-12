package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;

/**
 * Clase AsignacionAlbergue del diagrama de clases (sección 1.8.3); tabla ASIGNACION_ALBERGUE del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class AsignacionAlbergue {

    // ---- Atributos del diagrama de clases
    private int idAsignacion;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    // ---- Asociaciones (cada llave foránea es una referencia al objeto asociado)
    private Hogar hogar; // ASIGNACION_ALBERGUE.id_hogar → HOGAR
    private Albergue albergue; // ASIGNACION_ALBERGUE.id_albergue → ALBERGUE
    private Usuario usuarioAsigna; // ASIGNACION_ALBERGUE.id_usuario_asigna → USUARIO
    private Usuario usuarioSalida; // ASIGNACION_ALBERGUE.id_usuario_salida → USUARIO

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Crea la estancia de un hogar en un albergue.
     * <p>Trazabilidad: HU-13, HU-14 · RF-18 · CU-12, CU-13.</p>
     */
    public static void asignar(int idHogar, int idAlbergue) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-12, CU-13).");
    }

    /**
     * Cierra la estancia con la fecha de salida.
     * <p>Trazabilidad: HU-14 · RF-20 · CU-13.</p>
     */
    public static void registrarSalida(int idHogar, int idAlbergue) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-13).");
    }

    /**
     * Devuelve el albergue donde está alojado el hogar, si lo hay.
     * <p>Trazabilidad: HU-08, HU-13, HU-29 · RF-11, RF-18, RF-39 · CU-07, CU-12, CU-28.</p>
     */
    public static Albergue albergueActual(int idHogar) {
        try (Connection c = ConexionBD.abrir();
             PreparedStatement ps = c.prepareStatement(
                 "SELECT a.* FROM ASIGNACION_ALBERGUE s JOIN ALBERGUE a ON a.id_albergue = s.id_albergue "
               + "WHERE s.id_hogar = ? AND s.fecha_salida IS NULL")) {
            ps.setInt(1, idHogar);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                Albergue a = new Albergue();
                a.setIdAlbergue(rs.getInt("id_albergue")); a.setNombre(rs.getString("nombre"));
                a.setDireccion(rs.getString("direccion")); a.setMunicipio(rs.getString("municipio"));
                a.setCapacidadMaxima(rs.getInt("capacidad_maxima")); a.setActivo(rs.getBoolean("activo"));
                return a;
            }
        } catch (SQLException e) { throw new ErrorDatosException(e); }
    }

    // ---- Acceso a los atributos
    public int getIdAsignacion() { return idAsignacion; }
    public void setIdAsignacion(int idAsignacion) { this.idAsignacion = idAsignacion; }
    public LocalDateTime getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDateTime fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    public LocalDateTime getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDateTime fechaSalida) { this.fechaSalida = fechaSalida; }
    public Hogar getHogar() { return hogar; }
    public void setHogar(Hogar hogar) { this.hogar = hogar; }
    public Albergue getAlbergue() { return albergue; }
    public void setAlbergue(Albergue albergue) { this.albergue = albergue; }
    public Usuario getUsuarioAsigna() { return usuarioAsigna; }
    public void setUsuarioAsigna(Usuario usuarioAsigna) { this.usuarioAsigna = usuarioAsigna; }
    public Usuario getUsuarioSalida() { return usuarioSalida; }
    public void setUsuarioSalida(Usuario usuarioSalida) { this.usuarioSalida = usuarioSalida; }
}
