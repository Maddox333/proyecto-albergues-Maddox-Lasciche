package albergues.vista;

import albergues.modelo.Albergue;
import albergues.modelo.CondicionDiferencial;
import albergues.modelo.Hogar;
import albergues.modelo.Integrante;
import albergues.modelo.TipoDocumento;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * MK-01 · Ficha del hogar. Botones de este corte: «Buscar» → Hogar.buscarPorDocumento() (CU-07),
 * «+ Nuevo hogar» → Hogar.crear() (CU-03), «+ Agregar integrante» → abre MK-02 (CU-04).
 */
public final class MK01Hogar {
    private MK01Hogar() { }

    static String selectorTipo(String nombre, String valor) {
        StringBuilder s = new StringBuilder("<select class=\"in\" id=\"" + nombre + "\" name=\"" + nombre + "\"><option value=\"\">Seleccione</option>");
        for (TipoDocumento t : TipoDocumento.values())
            s.append("<option").append(t.name().equals(valor) ? " selected" : "").append(">").append(t.name()).append("</option>");
        return s.append("</select>").toString();
    }

    static String buscador(String tipo, String numero, Map<String, String> err) {
        return "<form class=\"box\" method=\"get\" action=\"/censo/hogar\"><div class=\"row\">"
            + "<div class=\"f" + (err.containsKey("tipo") ? " err" : "") + "\"><label for=\"tipo\">Tipo de documento</label>" + selectorTipo("tipo", tipo)
            + (err.containsKey("tipo") ? "<span class=\"msg\">" + Html.e(err.get("tipo")) + "</span>" : "") + "</div>"
            + Html.campo("numero", "Número de documento de un integrante", numero, err.get("numero"), "")
            + "<div class=\"f\"><label>&nbsp;</label><button class=\"btn p\" type=\"submit\">Buscar</button></div></div></form>";
    }

    public static String consulta(String usuario, String rol, boolean puedeRegistrar, String tipo, String numero,
                                  Map<String, String> err, String mensaje, String exito, Hogar h, Albergue alb, int total) {
        StringBuilder c = new StringBuilder(Html.exito(exito)).append(Html.alerta(mensaje)).append(buscador(tipo, numero, err));
        if (puedeRegistrar) c.append("<p><a class=\"btn\" href=\"/censo/hogar/nuevo\">+ Nuevo hogar</a></p>");
        if (h != null) {
            c.append("<div class=\"box\"><h2>Hogar N.º ").append(h.getIdHogar()).append("</h2><table>")
             .append("<tr><th>Dirección</th><td>").append(Html.e(h.getDireccion())).append("</td><th>Barrio</th><td>").append(Html.e(h.getBarrio())).append("</td></tr>")
             .append("<tr><th>Municipio</th><td>").append(Html.e(h.getMunicipio())).append("</td><th>Teléfono</th><td>").append(Html.e(h.getTelefonoContacto())).append("</td></tr>")
             .append("<tr><th>Albergue</th><td>").append(alb == null ? "Sin albergue asignado" : Html.e(alb.getNombre()))
             .append("</td><th>Integrantes activos</th><td>").append(total).append("</td></tr></table>")
             .append("<h2>Integrantes</h2><table><tr><th>Documento</th><th>Nombres y apellidos</th><th>Nacimiento</th><th>Enfoque diferencial</th></tr>");
            for (Integrante i : h.getIntegrantes()) {
                c.append("<tr><td>").append(i.getTipoDocumento()).append(" ").append(Html.e(i.getNumeroDocumento())).append("</td><td>")
                 .append(Html.e(i.getNombres() + " " + i.getApellidos())).append("</td><td>").append(i.getFechaNacimiento()).append("</td><td>")
                 .append(i.getCondiciones().isEmpty() ? "—" : i.getCondiciones().stream().map(MK02Integrante::etiqueta).collect(Collectors.joining(", ")))
                 .append("</td></tr>");
            }
            c.append("</table>");
            if (puedeRegistrar) c.append("<a class=\"btn\" href=\"/censo/integrante?idHogar=").append(h.getIdHogar()).append("\">+ Agregar integrante</a>");
            c.append("</div>");
        }
        return Html.pagina("MK-01", "Ficha del hogar", usuario, rol, puedeRegistrar, true, c.toString());
    }

    public static String nuevo(String usuario, String rol, Map<String, String> d, Map<String, String> err) {
        String c = "<form class=\"box\" method=\"post\" action=\"/censo/hogar\"><h2>Registrar hogar afectado</h2><div class=\"row\">"
            + Html.campo("direccion", "Dirección", d.get("direccion"), err.get("direccion"), "")
            + Html.campo("barrio", "Barrio", d.get("barrio"), err.get("barrio"), "")
            + Html.campo("municipio", "Municipio", d.get("municipio"), err.get("municipio"), "")
            + Html.campo("telefonoContacto", "Teléfono de contacto (opcional)", d.get("telefonoContacto"), err.get("telefonoContacto"), "inputmode=\"numeric\"")
            + "</div><button class=\"btn p\" type=\"submit\">Guardar</button> <a class=\"btn\" href=\"/censo/hogar\">Cancelar</a></form>";
        return Html.pagina("MK-01", "Ficha del hogar", usuario, rol, true, true, c);
    }
}
