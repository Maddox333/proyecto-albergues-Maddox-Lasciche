package albergues.vista;

/** Utilidades de las páginas: escape de texto y plantilla común con barra superior y menú por rol. */
public final class Html {
    private Html() { }

    public static String e(Object o) {
        if (o == null) return "";
        return o.toString().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
    }

    /**
     * Página completa. El menú solo muestra las funciones que el rol puede usar (RN-05, CA-01.1);
     * las de cortes posteriores aparecen deshabilitadas.
     */
    public static String pagina(String mk, String titulo, String usuario, String rol, boolean censo, boolean consulta, String cuerpo) {
        StringBuilder nav = new StringBuilder();
        if (usuario != null) {
            if (consulta) nav.append("<a class=\"on\" href=\"/censo/hogar\">Censo</a>");
            for (String s : new String[] {"Albergues", "Inventario", "Entregas", "Voluntarios", "Sincronización"})
                nav.append("<span title=\"Siguiente corte de construcción\">").append(s).append("</span>");
        }
        return """
            <!doctype html><html lang="es"><head><meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>%s · %s</title><link rel="stylesheet" href="/estilos.css"></head><body>
            <header class="top"><b>Sistema de albergues · Valle de Aburrá</b><span>%s</span></header>
            <nav class="nav">%s</nav>
            <main class="body"><div class="mk">%s</div><h1>%s</h1>%s</main></body></html>
            """.formatted(e(titulo), e(mk), usuario == null ? "" : e(usuario) + " · " + e(rol) + " · <a href=\"/salir\">Salir</a>",
                nav, e(mk), e(titulo), cuerpo);
    }

    public static String alerta(String texto) { return texto == null ? "" : "<div class=\"al\" role=\"alert\">" + e(texto) + "</div>"; }
    public static String exito(String texto) { return texto == null ? "" : "<div class=\"al ok\" role=\"status\">" + e(texto) + "</div>"; }

    /** Campo de texto con su mensaje de error al lado (RN-06, RN-08). */
    public static String campo(String nombre, String etiqueta, String valor, String error, String extra) {
        return "<div class=\"f" + (error != null ? " err" : "") + "\"><label for=\"" + nombre + "\">" + etiqueta + "</label>"
             + "<input class=\"in\" id=\"" + nombre + "\" name=\"" + nombre + "\" value=\"" + e(valor) + "\" " + extra + ">"
             + (error != null ? "<span class=\"msg\">" + e(error) + "</span>" : "") + "</div>";
    }

    public static final String CSS = """
        *{box-sizing:border-box;font-family:"Liberation Sans",Arial,sans-serif}
        body{margin:0;color:#111;background:#fafafa}
        .top{background:#2f2f2f;color:#fff;padding:10px 16px;display:flex;justify-content:space-between;flex-wrap:wrap;gap:8px}
        .top a{color:#fff}
        .nav{background:#e9e9e9;border-bottom:1px solid #999;padding:8px 16px}
        .nav a,.nav span{margin-right:20px;color:#333}.nav a.on{font-weight:bold}.nav span{color:#999}
        .body{max-width:1100px;margin:0 auto;padding:16px;position:relative}
        .mk{position:absolute;right:16px;top:16px;border:2px solid #222;padding:2px 8px;font-weight:bold;background:#fff}
        h1{font-size:22px;margin:0 0 12px;padding-right:90px}h2{font-size:17px}
        .row{display:flex;gap:14px;flex-wrap:wrap;align-items:flex-start;margin-bottom:10px}
        .f{display:flex;flex-direction:column;min-width:180px}.f label{font-weight:bold;margin-bottom:3px}
        .in{border:1.5px solid #555;border-radius:3px;padding:7px 8px;font-size:15px;background:#fff}
        .f.err .in{border:2px solid #000;background:#f1f1f1}.msg{font-weight:bold;font-size:13px;margin-top:3px}.msg:before{content:"⚠ "}
        .btn{border:1.5px solid #222;border-radius:4px;padding:8px 14px;font-size:15px;background:#fff;font-weight:bold;cursor:pointer;text-decoration:none;color:#111;display:inline-block}
        .btn.p{background:#2f2f2f;color:#fff}
        .al{border:2px solid #222;padding:10px 12px;margin:8px 0 12px;background:#f3f3f3}.al.ok{border-style:dashed}
        table{border-collapse:collapse;width:100%;margin:6px 0 12px}th{background:#e4e4e4;text-align:left;border:1px solid #777;padding:6px 8px}
        td{border:1px solid #999;padding:6px 8px;vertical-align:top}
        .box{border:1.5px solid #777;padding:12px 14px;margin-bottom:12px;background:#fff}
        fieldset{border:1.5px solid #777;margin:8px 0}label.ck{margin-right:16px;font-weight:normal}
        """;
}
