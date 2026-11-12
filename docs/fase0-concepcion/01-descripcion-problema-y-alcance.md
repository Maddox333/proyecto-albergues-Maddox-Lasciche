> Versión 0.2 (entrega parcial de octubre de 2026). Se corrige en las semanas 13 y 14; ver BITACORA.md.

**0.1 Descripción del problema y alcance**

**Planteamiento del problema**

En Colombia, la atención de emergencias depende de que las familias afectadas queden debidamente inscritas en el Registro Único de Damnificados (RUD), instrumento coordinado por la Unidad Nacional para la Gestión del Riesgo de Desastres (UNGRD). De este registro depende la entrega de kits de alimentos, subsidios de arrendamiento temporal y proyectos de reubicación de vivienda. Sin embargo, el RUD es un instrumento nacional de centralización orientado a la asignación de subsidios, no una herramienta operativa en tiempo real para las primeras horas y días de la emergencia. En esta fase inicial, las alcaldías y los consejos municipales de gestión del riesgo (como el DAGRD en Medellín o el DAGRAN en Antioquia) deben censar familias, habilitar y gestionar albergues, receptar donaciones y entregar ayudas de manera inmediata.

En el nivel municipal, la operación se sostiene predominantemente con planillas de papel, hojas de cálculo aisladas y grupos de mensajería instantánea, sin integración entre sí ni control de versiones. Eventos recientes —como el deslizamiento en Villatina (Medellín, mayo de 2025), el movimiento en masa de Granizal (Bello, junio de 2025) y el sismo nacional del 10 de agosto de 2026— demuestran patrones sistemáticos de falla: familias no registradas o censadas de forma duplicada, albergues en hacinamiento con sobrecupo mientras otros registran capacidad disponible, inventarios de donaciones desconocidos en tiempo real, demoras en la distribución y vulnerabilidad a la suplantación o fraude por falta de verificación de identidad y trazabilidad.

**Formulación del problema**

Los municipios carecen de un sistema de información integrado que, desde el primer momento del evento, articule el censo de familias, la ocupación de albergues, la gestión del inventario de donaciones, el registro de entregas y la coordinación de voluntarios con trazabilidad y reportes. Esta ausencia genera inequidad en la distribución de la ayuda, ineficiencia operativa y opacidad en la rendición de cuentas.

**Pregunta de investigación**

<table>
<colgroup>
<col style="width: 100%" />
</colgroup>
<thead>
<tr class="header">
<th><p><strong>Pregunta Central de Investigación:</strong></p>
<p>¿Cómo puede un sistema de información centralizado, con control de acceso por roles y trazabilidad de operaciones, mejorar el censo de familias afectadas, la asignación a albergues y la entrega de ayudas humanitarias en emergencias municipales en el Valle de Aburrá, reduciendo duplicidades, tiempos de respuesta y riesgos de fraude?</p></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

**Causas y Efectos**

**Causas identificadas:**

- Captura manual de datos en papel o herramientas no integradas, sin estandarización.

- Dispersión de fuentes de información y falta de interoperabilidad entre dependencias.

- Ausencia de mecanismos de validación de identidad y control automático de duplicados.

- Falta de visibilidad centralizada y en tiempo real de la capacidad disponible en albergues e inventarios.

- Carencia de una bitácora auditable de entregas y responsables de campo.

**Efectos producidos:**

- Cobertura incompleta del censo y registros duplicados de hogares.

- Distribución ineficiente e inequitativa de recursos y albergues con sobrecupo.

- Dilación en la respuesta y tiempos de entrega extendidos a la población vulnerable.

- Imposibilidad de justificar documentalmente el destino de los bienes humanitarios.

- Riesgo elevado de fraude e intermediación no autorizada.

**Alcance, supuestos y limitaciones**

**• Alcance operativo y geográfico:**

- Diseñado para la atención de emergencias a escala municipal (deslizamientos, inundaciones, incendios).

- Contexto geográfico y de validación: Municipios del Valle de Aburrá.

- Roles contemplados: Funcionario de gestión del riesgo, Coordinador de albergue, Donante, Voluntario, Organismo de socorro, Familia afectada y Administrador del sistema.

- Solución exclusivamente de software (web/móvil) con capacidades de registro offline y sincronización diferida.

**• Exclusiones (Fuera del alcance):**

- No reemplaza ni se conecta en tiempo real con la base de datos del RUD nacional (solo prevé exportación de datos en formatos compatibles).

- No realiza evaluaciones técnicas o de vulnerabilidad de infraestructura física (labor reservada a Bomberos y Cruz Roja).

- No incluye sensores, internet de las cosas (IoT) ni modelado/alerta temprana de amenazas geológicas o hidrológicas.

- No gestiona transferencias ni giros monetarios directos.

- No se realizará un despliegue en un entorno institucional de producción real; el resultado es un prototipo funcional validado en un entorno simulado.

**• Supuestos y restricciones:**

- El tratamiento de datos personales se alineará estrictamente a la Ley 1581 de 2012 (Habeas Data).

- Se asume el uso de dispositivos móviles con navegador por parte del personal operativo en campo.

- Las pruebas y validaciones se efectuarán mediante simulacros estructurados y conjuntos de datos sintéticos o anonimizados.
