package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;

/**
 * Clase Integrante del diagrama de clases (sección 1.8.3); tabla INTEGRANTE del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class Integrante {

    // ---- Atributos del diagrama de clases
    private int idIntegrante;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private List<CondicionDiferencial> condiciones = new ArrayList<>();
    private boolean activo;
    // ---- Asociaciones (cada llave foránea es una referencia al objeto asociado)
    private Hogar hogar; // INTEGRANTE.id_hogar → HOGAR

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Registra un integrante activo dentro de un hogar.
     * <p>Trazabilidad: HU-05 · RF-08 · CU-04.</p>
     */
    public static void crear(Integrante i) {
        if (i.getHogar() == null) throw new ReglaNegocioException("RN-09", "El integrante debe pertenecer a un hogar registrado.");
        try (Connection c = ConexionBD.abrir()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT activo FROM HOGAR WHERE id_hogar = ?")) {
                ps.setInt(1, i.getHogar().getIdHogar());
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next() || !rs.getBoolean(1))
                        throw new ReglaNegocioException("RN-09", "El hogar no está registrado o está inactivo.");
                }
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO INTEGRANTE (id_hogar, tipo_documento, numero_documento, nombres, apellidos, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, i.getHogar().getIdHogar()); ps.setString(2, i.getTipoDocumento().name());
                ps.setString(3, i.getNumeroDocumento().trim()); ps.setString(4, i.getNombres().trim());
                ps.setString(5, i.getApellidos().trim()); ps.setObject(6, i.getFechaNacimiento());
                ps.executeUpdate();
                try (ResultSet k = ps.getGeneratedKeys()) { k.next(); i.setIdIntegrante(k.getInt(1)); }
                i.setActivo(true);
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new ReglaNegocioException("RN-07", "El documento ya está registrado en el censo.");
            }
        } catch (SQLException e) { throw new ErrorDatosException(e); }
    }

    /**
     * Verifica si el documento ya pertenece a una persona censada.
     * <p>Trazabilidad: HU-06, HU-09, HU-11 · RF-09, RF-16 · CU-04, CU-06, CU-08, CU-10.</p>
     */
    public static boolean existeDocumento(TipoDocumento tipo, String numero) {
        try (Connection c = ConexionBD.abrir();
             PreparedStatement ps = c.prepareStatement(
                 "SELECT 1 FROM INTEGRANTE WHERE tipo_documento = ? AND numero_documento = ?")) {
            ps.setString(1, tipo.name()); ps.setString(2, numero.trim());
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        } catch (SQLException e) { throw new ErrorDatosException(e); }
    }

    /**
     * Identifica al integrante activo y su hogar.
     * <p>Trazabilidad: HU-18, HU-19 · RF-25 · CU-17, CU-18.</p>
     */
    public static Integrante buscarPorDocumento(TipoDocumento tipo, String numero) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-17, CU-18).");
    }

    /**
     * Modifica los datos de un integrante.
     * <p>Trazabilidad: HU-09 · RF-12 · CU-06, CU-08.</p>
     */
    public static void actualizar(Integrante i) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-06, CU-08).");
    }

    /**
     * Reemplaza las condiciones de enfoque diferencial del integrante.
     * <p>Trazabilidad: HU-07 · RF-10 · CU-05.</p>
     */
    public void asignarCondiciones(List<CondicionDiferencial> condiciones) {
        if (idIntegrante == 0) throw new ReglaNegocioException("RN-09", "Primero se registra el integrante.");
        try (Connection c = ConexionBD.abrir()) {
            c.setAutoCommit(false);
            try (PreparedStatement del = c.prepareStatement("DELETE FROM INTEGRANTE_CONDICION WHERE id_integrante = ?");
                 PreparedStatement ins = c.prepareStatement("INSERT INTO INTEGRANTE_CONDICION (id_integrante, condicion) VALUES (?, ?)")) {
                del.setInt(1, idIntegrante); del.executeUpdate();
                for (CondicionDiferencial cd : new java.util.LinkedHashSet<>(condiciones)) {
                    ins.setInt(1, idIntegrante); ins.setString(2, cd.name()); ins.executeUpdate();
                }
                c.commit();
                this.condiciones = new ArrayList<>(new java.util.LinkedHashSet<>(condiciones));
            } catch (SQLException e) { c.rollback(); throw e; }
        } catch (SQLException e) { throw new ErrorDatosException(e); }
    }

    /**
     * Cambia activo a FALSE y conserva sus entregas.
     * <p>Trazabilidad: HU-28 · RF-38 · CU-27.</p>
     */
    public static void inactivar(int idIntegrante) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-27).");
    }


    /** Apoyo de Hogar.buscarPorDocumento(): carga los integrantes activos con sus condiciones (CA-08.1). */
    static List<Integrante> listarActivosDeHogar(Connection c, Hogar h) throws SQLException {
        List<Integrante> out = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(
                "SELECT * FROM INTEGRANTE WHERE id_hogar = ? AND activo = TRUE ORDER BY id_integrante")) {
            ps.setInt(1, h.getIdHogar());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Integrante i = new Integrante();
                    i.setIdIntegrante(rs.getInt("id_integrante")); i.setHogar(h);
                    i.setTipoDocumento(TipoDocumento.valueOf(rs.getString("tipo_documento")));
                    i.setNumeroDocumento(rs.getString("numero_documento"));
                    i.setNombres(rs.getString("nombres")); i.setApellidos(rs.getString("apellidos"));
                    i.setFechaNacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
                    i.setActivo(rs.getBoolean("activo"));
                    out.add(i);
                }
            }
        }
        try (PreparedStatement ps = c.prepareStatement("SELECT condicion FROM INTEGRANTE_CONDICION WHERE id_integrante = ? ORDER BY condicion")) {
            for (Integrante i : out) {
                ps.setInt(1, i.getIdIntegrante());
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) i.getCondiciones().add(CondicionDiferencial.valueOf(rs.getString(1)));
                }
            }
        }
        return out;
    }

    // ---- Acceso a los atributos
    public int getIdIntegrante() { return idIntegrante; }
    public void setIdIntegrante(int idIntegrante) { this.idIntegrante = idIntegrante; }
    public TipoDocumento getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(TipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public List<CondicionDiferencial> getCondiciones() { return condiciones; }
    public void setCondiciones(List<CondicionDiferencial> condiciones) { this.condiciones = condiciones; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public Hogar getHogar() { return hogar; }
    public void setHogar(Hogar hogar) { this.hogar = hogar; }
}
