package albergues.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import albergues.persistencia.ConexionBD;
import albergues.persistencia.ErrorDatosException;
import albergues.persistencia.Claves;

/**
 * Clase Usuario del diagrama de clases (sección 1.8.3); tabla USUARIO del modelo relacional (sección 3.1).
 * Generada desde el diagrama: atributos, asociaciones y firmas no se editan a mano.
 */
public class Usuario {

    // ---- Atributos del diagrama de clases
    private int idUsuario;
    private String nombreCompleto;
    private String nombreUsuario;
    private String claveHash;
    private Rol rol;
    private boolean activo;
    // ---- Asociaciones (cada llave foránea es una referencia al objeto asociado)
    private Albergue albergue; // USUARIO.id_albergue → ALBERGUE

    // ---- Métodos del diagrama de clases (sección 1.8.4)
    /**
     * Valida las credenciales de un usuario activo e inicia su sesión.
     * <p>Trazabilidad: HU-01 · RF-01, RF-02 · CU-01.</p>
     */
    public static Usuario autenticar(String nombreUsuario, String clave) {
        if (nombreUsuario == null || nombreUsuario.isBlank() || clave == null || clave.isBlank())
            throw new ReglaNegocioException("RN-06", "Ingrese el nombre de usuario y la clave.");
        try (Connection c = ConexionBD.abrir();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM USUARIO WHERE nombre_usuario = ?")) {
            ps.setString(1, nombreUsuario.trim());
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next() || !Claves.verificar(clave, rs.getString("clave_hash")))
                    throw new ReglaNegocioException("RN-01", "Usuario o clave incorrectos.");
                Usuario u = desdeFila(rs);
                if (!u.isActivo())
                    throw new ReglaNegocioException("RN-34", "El usuario está inactivo. Comuníquese con el Administrador.");
                return u;
            }
        } catch (SQLException e) { throw new ErrorDatosException(e); }
    }

    /**
     * Indica si el rol del usuario está autorizado para una función.
     * <p>Trazabilidad: HU-01, HU-02, HU-03, HU-25 · RF-05, RF-06 · CU-01, CU-02, CU-24.</p>
     */
    public boolean tienePermiso(String funcion) {
        if (!activo || rol == null) return false;
        java.util.Set<Rol> roles = PERMISOS.get(funcion);
        return roles != null && roles.contains(rol);
    }

    /**
     * Registra un usuario activo con su rol.
     * <p>Trazabilidad: HU-02 · RF-03 · CU-02.</p>
     */
    public static void crear(Usuario u) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-02).");
    }

    /**
     * Verifica si el nombre de usuario ya está en uso.
     * <p>Trazabilidad: HU-02, HU-26 · RF-04 · CU-02, CU-25.</p>
     */
    public static boolean existeNombreUsuario(String nombreUsuario) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-02, CU-25).");
    }

    /**
     * Trae los usuarios activos ordenados por nombre.
     * <p>Trazabilidad: HU-25 · RF-35 · CU-24.</p>
     */
    public static List<Usuario> listarActivos() {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-24).");
    }

    /**
     * Modifica los datos o el rol de un usuario.
     * <p>Trazabilidad: HU-26 · RF-36 · CU-25.</p>
     */
    public static void actualizar(Usuario u) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-25).");
    }

    /**
     * Cambia activo a FALSE (nunca borra).
     * <p>Trazabilidad: HU-27 · RF-37 · CU-26.</p>
     */
    public static void inactivar(int idUsuario) {
        throw new UnsupportedOperationException("Pendiente para el siguiente corte de construcción (CU-26).");
    }


    /** Matriz de permisos por rol (sección 2.2): función → roles autorizados (RN-05). */
    static final java.util.Map<String, java.util.Set<Rol>> PERMISOS = java.util.Map.ofEntries(
        java.util.Map.entry("SESION", java.util.Set.of(Rol.FUNCIONARIO, Rol.COORDINADOR, Rol.ADMINISTRADOR)) /* Iniciar sesión (HU-01) */,
        java.util.Map.entry("USUARIOS", java.util.Set.of(Rol.ADMINISTRADOR)) /* Gestionar usuarios: registrar, consultar, actualizar, inactivar (HU-02, HU-25 a HU-27) */,
        java.util.Map.entry("CENSO", java.util.Set.of(Rol.FUNCIONARIO)) /* Censo: registrar, actualizar e inactivar hogares e integrantes; enfoque diferencial (HU-04 a HU-07, HU-09, HU-28, HU-29) */,
        java.util.Map.entry("CONSULTAR_HOGAR", java.util.Set.of(Rol.FUNCIONARIO, Rol.COORDINADOR)) /* Consultar un hogar por documento (HU-08) */,
        java.util.Map.entry("SINCRONIZACION", java.util.Set.of(Rol.FUNCIONARIO)) /* Registrar sin conexión y sincronizar (HU-10, HU-11) */,
        java.util.Map.entry("ALBERGUES", java.util.Set.of(Rol.FUNCIONARIO)) /* Albergues: registrar, actualizar, inactivar y asignar hogares (HU-12, HU-13, HU-30, HU-31) */,
        java.util.Map.entry("SALIDA_ALBERGUE", java.util.Set.of(Rol.COORDINADOR)) /* Registrar la salida de un hogar de su albergue (HU-14) */,
        java.util.Map.entry("OCUPACION", java.util.Set.of(Rol.FUNCIONARIO, Rol.COORDINADOR)) /* Consultar ocupación y cupos (HU-15) */,
        java.util.Map.entry("INVENTARIO", java.util.Set.of(Rol.FUNCIONARIO)) /* Inventario: tipos de ayuda y donaciones (HU-16, HU-32 a HU-34) */,
        java.util.Map.entry("EXISTENCIAS", java.util.Set.of(Rol.FUNCIONARIO, Rol.COORDINADOR)) /* Consultar existencias (HU-17) */,
        java.util.Map.entry("ENTREGAS", java.util.Set.of(Rol.FUNCIONARIO)) /* Entregas: verificar identidad, registrar entrega y firma (HU-18 a HU-21) */,
        java.util.Map.entry("HISTORIAL_ENTREGAS", java.util.Set.of(Rol.FUNCIONARIO, Rol.COORDINADOR)) /* Consultar historial de entregas de un hogar (HU-22) */,
        java.util.Map.entry("TRAZABILIDAD_AYUDA", java.util.Set.of(Rol.FUNCIONARIO)) /* Consultar trazabilidad de un tipo de ayuda (HU-23) */,
        java.util.Map.entry("VOLUNTARIOS", java.util.Set.of(Rol.FUNCIONARIO)) /* Voluntarios: registrar, consultar, actualizar, inactivar (HU-24, HU-35 a HU-37) */);

    static Usuario desdeFila(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setIdUsuario(rs.getInt("id_usuario")); u.setNombreCompleto(rs.getString("nombre_completo"));
        u.setNombreUsuario(rs.getString("nombre_usuario")); u.setClaveHash(rs.getString("clave_hash"));
        u.setRol(Rol.valueOf(rs.getString("rol"))); u.setActivo(rs.getBoolean("activo"));
        return u;
    }

    // ---- Acceso a los atributos
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getClaveHash() { return claveHash; }
    public void setClaveHash(String claveHash) { this.claveHash = claveHash; }
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public Albergue getAlbergue() { return albergue; }
    public void setAlbergue(Albergue albergue) { this.albergue = albergue; }
}
