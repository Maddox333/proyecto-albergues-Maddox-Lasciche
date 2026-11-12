> Versión 0.2 (entrega parcial de octubre de 2026). Se corrige en las semanas 13 y 14; ver BITACORA.md.

**0.4 Recolección de información y metodología**

**Fuentes de información**

- **Fuentes secundarias:** Informes del DAGRD Medellín, DAGRAN Antioquia, informes de la Defensoría del Pueblo tras el sismo de 2026, normatividad de the UNGRD y documentación técnica del RUD.

- **Fuentes primarias (simuladas / entrevistas):** Entrevistas cualitativas semiestructuradas con funcionarios de gestión del riesgo, coordinadores de albergues y brigadistas para determinar las reglas de negocio reales de la atención inmediata.

**Guion de entrevista**

Las entrevistas semiestructuradas con funcionarios de gestión del riesgo, coordinadores de albergues y brigadistas se apoyan en un guion de 12 preguntas cerradas, configurado como formulario de Google Forms. Usa listas desplegables, opciones múltiples, casillas de verificación y escalas del 1 al 5 para facilitar la respuesta en campo, medir la gravedad de cada falla y comparar las respuestas entre entrevistados. Todas indagan el problema (PIN) y validan la brecha y el factor diferenciador del estado del arte (0.3.1): unicidad del registro familiar con validación del documento, control de inventario con deducción automática, trazabilidad auditable de las ayudas y operación liviana con registro offline.

**Revisión de las preguntas iniciales**

| **N°** | **Pregunta inicial (resumen)**                                                                                  | **Valoración**               | **Decisión y motivo**                                                                                                                                                |
|--------|-----------------------------------------------------------------------------------------------------------------|------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **1**  | Cómo se realiza el censo en las primeras horas y qué dificultades hay para que sea completo, único y confiable. | **Específica, pero abierta** | Se reescribe como pregunta cerrada (pregunta 2): se conserva el tema, pero la respuesta pasa a ser una opción entre alternativas.                                    |
| **2**  | Cómo se controla la ocupación de albergues y la recepción, almacenamiento y entrega de ayudas.                  | **Específica, pero abierta** | Se reescribe como pregunta cerrada (pregunta 5), centrada en el control de cupos. El inventario y las entregas se preguntan por separado (preguntas 6 y 9).          |
| **3**  | Qué información, controles y funcionalidades considera necesarios para una plataforma de seguimiento.           | **Genérica y abierta**       | Se reescribe (pregunta 12). Serviría para cualquier proyecto y no valida el factor diferenciador. Se convierte en una priorización de funciones propias del sistema. |

Las tres preguntas iniciales eran abiertas, por lo que se reescribieron como preguntas cerradas. La pregunta inicial sobre herramientas en uso queda cubierta por las opciones de las preguntas 2, 5 y 9. El guion final no incluye preguntas de respuesta abierta ni de solo "sí" o "no".

**Preguntas del guion**

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 1</strong> | Lista desplegable | Nueva</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>¿Cuál es su rol principal en la atención de emergencias en su municipio?</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Funcionario de gestión del riesgo (alcaldía / consejo municipal)</p>
<p>• Coordinador de albergue</p>
<p>• Brigadista u organismo de socorro</p>
<p>• Voluntario</p>
<p>• Otro</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Identificar desde qué perspectiva responde cada persona entrevistada.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se agrega</strong></td>
<td>Permite segmentar las respuestas por rol (funcionario, coordinador de albergue, brigadista) y relacionarlas con los roles definidos en el alcance del sistema.</td>
</tr>
</tbody>
</table>

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 2</strong> | Opción múltiple | Reescrita (pregunta 1)</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>Durante las primeras horas de una emergencia, ¿cuál es la dificultad principal para que el censo de familias afectadas sea completo, único y confiable?</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Familias que no llegan al punto de registro o no se logran ubicar</p>
<p>• Registro de una misma familia más de una vez</p>
<p>• Datos incompletos o ilegibles</p>
<p>• Información dispersa en varias planillas, hojas de cálculo o chats</p>
<p>• Falta de personal o de tiempo para registrar</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Identificar el punto de falla más frecuente del censo actual.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se incluye</strong></td>
<td>Valida el problema central: registros duplicados y familias no censadas, y señala cuál de las causas pesa más.</td>
</tr>
</tbody>
</table>

|                                                     |                                                                                                                                                                                                       |
|-----------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Pregunta 3** \| Escala lineal del 1 al 5 \| Nueva |                                                                                                                                                                                                       |
| **Pregunta**                                        | En las emergencias que ha atendido, ¿con qué frecuencia ha encontrado familias registradas más de una vez o familias afectadas que no fueron censadas? (1 = nunca, 5 = en casi todas las emergencias) |
| **Qué busca indagar**                               | Medir la frecuencia percibida de duplicados y omisiones en el censo.                                                                                                                                  |
| **Por qué se agrega**                               | Dimensiona el efecto "cobertura incompleta y registros duplicados" y justifica la unicidad del registro familiar como factor diferenciador.                                                           |

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 4</strong> | Opción múltiple | Nueva</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>Al registrar a una familia, ¿cómo se verifica hoy la identidad de sus integrantes y se evita que alguien se registre dos veces?</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Se revisa físicamente el documento de identidad y se anota en planilla</p>
<p>• Se compara manualmente con listados o planillas anteriores</p>
<p>• Se consulta una base de datos oficial</p>
<p>• Se acepta la información declarada por la persona</p>
<p>• No existe un procedimiento definido</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Identificar el mecanismo actual de validación de identidad y de control de duplicados.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se agrega</strong></td>
<td>Valida la brecha de la estructura del censo por hogar con validación del documento nacional y el riesgo de suplantación.</td>
</tr>
</tbody>
</table>

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 5</strong> | Opción múltiple | Reescrita (pregunta 2)</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>¿Cómo se controla hoy la ocupación y los cupos disponibles de los albergues durante una emergencia?</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Planilla en papel en cada albergue</p>
<p>• Hoja de cálculo actualizada manualmente</p>
<p>• Reporte del coordinador por mensajería instantánea o llamada</p>
<p>• Observación directa en el lugar, sin registro</p>
<p>• No existe un control sistemático</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Conocer el mecanismo actual de control de cupos de los albergues.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se incluye</strong></td>
<td>Valida el sobrecupo en algunos albergues mientras otros tienen espacio, y la falta de visibilidad en tiempo real.</td>
</tr>
</tbody>
</table>

|                                                     |                                                                                                                                                                                                    |
|-----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Pregunta 6** \| Escala lineal del 1 al 5 \| Nueva |                                                                                                                                                                                                    |
| **Pregunta**                                        | Durante las primeras 48 horas de una emergencia, ¿qué tan difícil es saber con exactitud qué donaciones hay disponibles y cuántas quedan después de cada entrega? (1 = muy fácil, 5 = muy difícil) |
| **Qué busca indagar**                               | Medir la dificultad para conocer las existencias en tiempo real.                                                                                                                                   |
| **Por qué se agrega**                               | Respalda el control de inventario de donaciones con deducción automática propuesto como factor diferenciador.                                                                                      |

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 7</strong> | Casillas de verificación | Nueva</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>¿Qué criterios se aplican hoy para asignar una familia a un albergue o decidir qué ayuda recibe? (marque todos los que apliquen)</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Número de integrantes del hogar</p>
<p>• Presencia de niños, adultos mayores, gestantes o personas con discapacidad (enfoque diferencial)</p>
<p>• Cupos disponibles en el albergue</p>
<p>• Orden de llegada</p>
<p>• Decisión del funcionario o coordinador en el momento</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Documentar las reglas de negocio reales de asignación y priorización en la atención inmediata.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se agrega</strong></td>
<td>Valida la brecha de las reglas de negocio específicas de las entidades territoriales colombianas que las plataformas genéricas no incorporan, y alimenta los requisitos de la Fase 1.</td>
</tr>
</tbody>
</table>

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 8</strong> | Opción múltiple | Nueva</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>En una emergencia reciente que usted haya atendido, ¿cuánto tiempo pasó aproximadamente entre el registro de una familia y la entrega efectiva de su primera ayuda?</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Menos de 6 horas</p>
<p>• Entre 6 y 24 horas</p>
<p>• Entre 1 y 3 días</p>
<p>• Más de 3 días</p>
<p>• No lo sé / varía mucho</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Obtener un rango de referencia del tiempo entre registro y entrega.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se agrega</strong></td>
<td>Establece una línea base para el efecto "demoras en la distribución" y permite medir después la mejora del sistema.</td>
</tr>
</tbody>
</table>

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 9</strong> | Casillas de verificación | Nueva</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>¿Cómo se deja constancia hoy de quién recibió qué ayuda, cuándo y de manos de quién? (marque todas las que apliquen)</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Firma del beneficiario en planilla de papel</p>
<p>• Foto o mensaje en un grupo de mensajería instantánea</p>
<p>• Anotación en una hoja de cálculo</p>
<p>• Solo el registro de quien entrega, sin firma del beneficiario</p>
<p>• No se deja constancia sistemática</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Conocer cómo se documentan las entregas.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se agrega</strong></td>
<td>Valida la brecha de trazabilidad estricta con firmas digitales de entrega y la imposibilidad de demostrar quién recibió qué.</td>
</tr>
</tbody>
</table>

|                                                      |                                                                                                                                                                                                      |
|------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Pregunta 10** \| Escala lineal del 1 al 5 \| Nueva |                                                                                                                                                                                                      |
| **Pregunta**                                         | ¿Con qué frecuencia ha conocido casos de entregas duplicadas, suplantación de identidad o personas que prometían incluir a alguien en un censo a cambio de algo? (1 = nunca, 5 = muy frecuentemente) |
| **Qué busca indagar**                                | Medir la frecuencia percibida de fraude y suplantación.                                                                                                                                              |
| **Por qué se agrega**                                | Dimensiona el riesgo de fraude e intermediación no autorizada y justifica la verificación de identidad y la trazabilidad auditable.                                                                  |

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 11</strong> | Opción múltiple | Nueva</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>En los puntos de atención y albergues donde ha trabajado durante una emergencia, ¿cómo es normalmente la conectividad a internet?</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Estable durante toda la operación</p>
<p>• Intermitente, con cortes frecuentes</p>
<p>• Muy limitada o inexistente</p>
<p>• Depende del lugar y no es predecible</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Determinar si la operación puede depender de conexión permanente.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se agrega</strong></td>
<td>Valida el supuesto de registro offline con sincronización diferida y de una solución web liviana usada desde dispositivos móviles.</td>
</tr>
</tbody>
</table>

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td colspan="2"><strong>Pregunta 12</strong> | Casillas de verificación | Reescrita (pregunta 3)</td>
</tr>
<tr class="even">
<td><strong>Pregunta</strong></td>
<td>De las siguientes funciones, ¿cuáles considera indispensables en una herramienta para su municipio durante una emergencia? (elija máximo 3)</td>
</tr>
<tr class="odd">
<td><strong>Opciones</strong></td>
<td><p>• Alerta de duplicados al registrar una familia</p>
<p>• Consulta en tiempo real de la ocupación y los cupos de los albergues</p>
<p>• Inventario que descuenta automáticamente cada entrega</p>
<p>• Firma digital del beneficiario al recibir la ayuda</p>
<p>• Registro sin internet con sincronización posterior</p></td>
</tr>
<tr class="even">
<td><strong>Qué busca indagar</strong></td>
<td>Priorizar las funciones que los usuarios consideran críticas.</td>
</tr>
<tr class="odd">
<td><strong>Por qué se incluye</strong></td>
<td>Reemplaza la pregunta 3 genérica por una priorización de las funciones que conforman el factor diferenciador del sistema.</td>
</tr>
</tbody>
</table>

**Metodología de desarrollo**

Se aplicará un ciclo de vida de desarrollo de software iterativo e incremental basado en el marco ágil Scrum, adaptado a los hitos académicos de los tres niveles de Ingeniería de Software:

- **Modelado y Requisitos (Fase 1):** Levantamiento de Historias de Usuario (HU), Casos de Uso y criterios de aceptación.

- **Diseño de Arquitectura y Datos (Fase 2):** Modelado Entidad-Relación en 3FN, diagramación de clases y diseño de arquitectura por capas (MVC).

- **Construcción e Integración (Fase 3):** Desarrollo modular de componentes, control de versiones en Git y scripts de base de datos SQL DDL.

- **Verificación y Calidad:** Pruebas unitarias, funcionales, de sistema y matriz de trazabilidad cruzada.
