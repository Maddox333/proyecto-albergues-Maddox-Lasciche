package albergues.vista;

import albergues.modelo.CondicionDiferencial;
import java.util.List;
import java.util.Map;

/**
 * MK-02 · Registrar integrante (CU-04, con CU-05 y CU-06). «Guardar» → antes Integrante.existeDocumento() (CU-06),
 * después Integrante.crear() y, si hay condiciones, Integrante.asignarCondiciones() (CU-05). «Cancelar» vuelve sin cambios (CA-06.3).
 */
public final class MK02Integrante {
    private MK02Integrante() { }

    public static String etiqueta(CondicionDiferencial c) {
        return switch (c) {
            case NINO -> "Niño o niña"; case ADULTO_MAYOR -> "Adulto mayor"; case DISCAPACIDAD -> "Persona con discapacidad";
            case GESTANTE -> "Gestante"; case MINORIA_ETNICA -> "Minoría étnica";
        };
    }

    public static String render(String usuario, String rol, int idHogar, Map<String, String> d, List<String> marcadas,
                                Map<String, String> err, String alerta, String exito) {
        StringBuilder ck = new StringBuilder("<fieldset><legend>Enfoque diferencial (opcional, una o varias)</legend>");
        for (CondicionDiferencial c : CondicionDiferencial.values())
            ck.append("<label class=\"ck\"><input type=\"checkbox\" name=\"condiciones\" value=\"").append(c.name()).append("\"")
              .append(marcadas.contains(c.name()) ? " checked" : "").append("> ").append(etiqueta(c)).append("</label>");
        ck.append(err.containsKey("condiciones") ? "<span class=\"msg\">" + Html.e(err.get("condiciones")) + "</span>" : "").append("</fieldset>");
        String volver = d.getOrDefault("volverTipo", "").isBlank() ? "/censo/hogar"
            : "/censo/hogar?tipo=" + Html.e(d.get("volverTipo")) + "&amp;numero=" + Html.e(d.get("volverNumero"));
        String c = Html.exito(exito) + Html.alerta(alerta)
            + "<form class=\"box\" method=\"post\" action=\"/censo/integrante\"><h2>Hogar N.º " + idHogar + "</h2>"
            + "<input type=\"hidden\" name=\"idHogar\" value=\"" + idHogar + "\">"
            + "<input type=\"hidden\" name=\"volverTipo\" value=\"" + Html.e(d.get("volverTipo")) + "\">"
            + "<input type=\"hidden\" name=\"volverNumero\" value=\"" + Html.e(d.get("volverNumero")) + "\">"
            + "<div class=\"row\"><div class=\"f" + (err.containsKey("tipoDocumento") ? " err" : "") + "\"><label for=\"tipoDocumento\">Tipo de documento</label>"
            + MK01Hogar.selectorTipo("tipoDocumento", d.get("tipoDocumento"))
            + (err.containsKey("tipoDocumento") ? "<span class=\"msg\">" + Html.e(err.get("tipoDocumento")) + "</span>" : "") + "</div>"
            + Html.campo("numeroDocumento", "Número de documento", d.get("numeroDocumento"), err.get("numeroDocumento"), "")
            + "</div><div class=\"row\">"
            + Html.campo("nombres", "Nombres", d.get("nombres"), err.get("nombres"), "")
            + Html.campo("apellidos", "Apellidos", d.get("apellidos"), err.get("apellidos"), "")
            + Html.campo("fechaNacimiento", "Fecha de nacimiento", d.get("fechaNacimiento"), err.get("fechaNacimiento"), "type=\"date\"")
            + "</div>" + ck
            + "<button class=\"btn p\" type=\"submit\">Guardar</button> <a class=\"btn\" href=\"" + volver + "\">Cancelar</a></form>";
        return Html.pagina("MK-02", "Registrar integrante", usuario, rol, true, true, c);
    }
}
