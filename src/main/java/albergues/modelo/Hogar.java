package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;

/**
 * Clase Hogar del diagrama de clases (sección 1.8.3); tabla HOGAR del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class Hogar {

    // ---- Atributos del diagrama de clases
    private int idHogar;
    private String direccion;
    private String barrio;
    private String municipio;
    private String telefonoContacto;
    private LocalDateTime fechaRegistro;
    private EstadoSincronizacion estadoSincronizacion;
    private boolean activo;
    // ---- Asociaciones (cada llave foránea es una referencia al objeto asociado)
    private Usuario usuarioRegistro; // HOGAR.id_usuario_registro → USUARIO
    private List<Integrante> integrantes = new ArrayList<>(); // Integrantes activos del hogar (asociación Hogar 1 — 1..* Integrante; CA-08.1).

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Registra un hogar activo en el censo.
     * <p>Trazabilidad: HU-04 · RF-07 · CU-03.</p>
     */
    public static void crear(Hogar h) {
        if (h.getUsuarioRegistro() == null) throw new ReglaNegocioException("RN-01", "Se requiere un usuario con sesión iniciada.");
        try (Connection c = ConexionBD.abrir();
             PreparedStatement ps = c.prepareStatement(
                 "INSERT INTO HOGAR (direccion, barrio, municipio, telefono_contacto, estado_sincronizacion, id_usuario_registro) VALUES (?, ?, ?, ?, ?, ?)",
                 Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, h.getDireccion()); ps.setString(2, h.getBarrio()); ps.setString(3, h.getMunicipio());
            ps.setString(4, h.getTelefonoContacto() == null || h.getTelefonoContacto().isBlank() ? null : h.getTelefonoContacto());
            ps.setString(5, EstadoSincronizacion.SINCRONIZADO.name());
            ps.setInt(6, h.getUsuarioRegistro().getIdUsuario());
            ps.executeUpdate();
            try (ResultSet k = ps.getGeneratedKeys()) { k.next(); h.setIdHogar(k.getInt(1)); }
            h.setEstadoSincronizacion(EstadoSincronizacion.SINCRONIZADO);
            h.setActivo(true);
            h.setFechaRegistro(fechaRegistro(c, h.getIdHogar()));
        } catch (SQLException e) { throw new ErrorDatosException(e); }
    }

    /**
     * Encuentra el hogar activo de un integrante por su documento.
     * <p>Trazabilidad: HU-04, HU-08, HU-22 · RF-11 · CU-03, CU-07, CU-20.</p>
     */
    public static Hogar buscarPorDocumento(TipoDocumento tipo, String numero) {
        try (Connection c = ConexionBD.abrir();
             PreparedStatement ps = c.prepareStatement(
                 "SELECT h.* FROM HOGAR h JOIN INTEGRANTE i ON i.id_hogar = h.id_hogar "
               + "WHERE i.tipo_documento = ? AND i.numero_documento = ? AND i.activo = TRUE AND h.activo = TRUE")) {
            ps.setString(1, tipo.name()); ps.setString(2, numero.trim());
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                Hogar h = desdeFila(rs);
                h.setIntegrantes(Integrante.listarActivosDeHogar(c, h));
                return h;
            }
        } catch (SQLException e) { throw new ErrorDatosException(e); }
    }

    /**
     * Modifica los datos de un hogar.
     * <p>Trazabilidad: HU-09 · RF-12 · CU-06, CU-08.</p>
     */
    public static void actualizar(Hogar h) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-06, CU-08).");
    }

    /**
     * Cambia activo a FALSE y conserva integrantes e historial.
     * <p>Trazabilidad: HU-29 · RF-39 · CU-28.</p>
     */
    public static void inactivar(int idHogar) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-28).");
    }

    /**
     * Cuenta los integrantes activos del hogar.
     * <p>Trazabilidad: HU-05, HU-13, HU-28 · RF-08, RF-18 · CU-04, CU-12, CU-27.</p>
     */
    public int totalIntegrantes() {
        try (Connection c = ConexionBD.abrir();
             PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM INTEGRANTE WHERE id_hogar = ? AND activo = TRUE")) {
            ps.setInt(1, idHogar);
            try (ResultSet rs = ps.executeQuery()) { rs.next(); return rs.getInt(1); }
        } catch (SQLException e) { throw new ErrorDatosException(e); }
    }

    /**
     * Guarda el hogar y sus integrantes en el dispositivo en estado PENDIENTE.
     * <p>Trazabilidad: HU-10 · RF-13 · CU-09.</p>
     */
    public static void guardarLocal(Hogar h) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-09).");
    }

    /**
     * Cuenta los registros pendientes, sincronizados o en conflicto.
     * <p>Trazabilidad: HU-10, HU-11 · RF-14 · CU-09, CU-10.</p>
     */
    public static int contarPorEstado(EstadoSincronizacion estado) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-09, CU-10).");
    }

    /**
     * Envía los registros pendientes al sistema central y marca los conflictos.
     * <p>Trazabilidad: HU-11 · RF-15, RF-16 · CU-10.</p>
     */
    public static void sincronizarPendientes() {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-10).");
    }


    static Hogar desdeFila(ResultSet rs) throws SQLException {
        Hogar h = new Hogar();
        h.setIdHogar(rs.getInt("id_hogar")); h.setDireccion(rs.getString("direccion")); h.setBarrio(rs.getString("barrio"));
        h.setMunicipio(rs.getString("municipio")); h.setTelefonoContacto(rs.getString("telefono_contacto"));
        Timestamp f = rs.getTimestamp("fecha_registro"); h.setFechaRegistro(f == null ? null : f.toLocalDateTime());
        h.setEstadoSincronizacion(EstadoSincronizacion.valueOf(rs.getString("estado_sincronizacion")));
        h.setActivo(rs.getBoolean("activo"));
        return h;
    }

    private static LocalDateTime fechaRegistro(Connection c, int id) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement("SELECT fecha_registro FROM HOGAR WHERE id_hogar = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { rs.next(); return rs.getTimestamp(1).toLocalDateTime(); }
        }
    }

    // ---- Acceso a los atributos
    public int getIdHogar() { return idHogar; }
    public void setIdHogar(int idHogar) { this.idHogar = idHogar; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getBarrio() { return barrio; }
    public void setBarrio(String barrio) { this.barrio = barrio; }
    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }
    public String getTelefonoContacto() { return telefonoContacto; }
    public void setTelefonoContacto(String telefonoContacto) { this.telefonoContacto = telefonoContacto; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public EstadoSincronizacion getEstadoSincronizacion() { return estadoSincronizacion; }
    public void setEstadoSincronizacion(EstadoSincronizacion estadoSincronizacion) { this.estadoSincronizacion = estadoSincronizacion; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public Usuario getUsuarioRegistro() { return usuarioRegistro; }
    public void setUsuarioRegistro(Usuario usuarioRegistro) { this.usuarioRegistro = usuarioRegistro; }
    public List<Integrante> getIntegrantes() { return integrantes; }
    public void setIntegrantes(List<Integrante> integrantes) { this.integrantes = integrantes; }
}
