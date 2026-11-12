> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 1.1 Descripción del problema

### 1.1.1 Planteamiento del problema

En Colombia, la atención de una emergencia depende de que las familias afectadas queden inscritas en el Registro Único de Damnificados (RUD), que administra la Unidad Nacional para la Gestión del Riesgo de Desastres (UNGRD) y que alimentan los consejos territoriales de gestión del riesgo (Redacción Medioambiente, 2022). De ese registro depende el acceso a kits de alimentos, subsidios de arrendamiento y proyectos de reubicación. Sin embargo, el RUD consolida información para asignar ayudas del Estado; no es una herramienta operativa para las primeras horas y días del evento. En ese lapso, las alcaldías y los consejos municipales de gestión del riesgo son los primeros respondientes (Congreso de la República de Colombia, 2012a): deben censar familias, habilitar albergues, recibir donaciones y entregar ayudas de inmediato.

En el nivel municipal esa operación se sostiene con planillas de papel, hojas de cálculo aisladas y grupos de mensajería. Los eventos recientes del Valle de Aburrá muestran el patrón. En el movimiento en masa de Villatina (Medellín, 22 de mayo de 2025) se evacuaron 180 personas de 40 viviendas y el censo se levantó a mano en la sede de la junta de acción comunal, con damnificados que habían perdido sus documentos (Álvarez Correa, 2025). En el deslizamiento de la vereda Granizal (Bello, junio de 2025) murieron 27 personas, 163 familias quedaron damnificadas y 128 personas de 40 familias pasaron por un alojamiento temporal (Redacción El Colombiano, 2025). El sismo del 10 de agosto de 2026, de magnitud 7,4, afectó a 16 departamentos: dos meses después el RUD sumaba 489.862 personas y 305.791 familias, las cifras seguían dependiendo de los datos que cargaban los municipios y la Defensoría del Pueblo pidió reabrir el registro porque parte de la población afectada no había recibido asistencia (Saavedra, 2026).

La entrevista aplicada para este proyecto (sección 1.7.3) confirma el patrón desde quienes atienden las emergencias: registros duplicados o familias sin censar con frecuencia alta, albergues sin control centralizado de cupos, inventarios de donaciones difíciles de conocer y constancias de entrega dispersas entre planillas, mensajes y hojas de cálculo.

### 1.1.2 Formulación del problema

Los municipios carecen de un sistema de información integrado que, desde el primer momento del evento, articule el censo de familias, la ocupación de los albergues, el inventario de donaciones, el registro de entregas y la identificación de voluntarios, con trazabilidad de cada operación. Esa ausencia produce inequidad en la distribución de la ayuda, ineficiencia operativa y opacidad en la rendición de cuentas.

**Pregunta de investigación.** ¿Cómo puede un sistema de información centralizado, con control de acceso por roles y trazabilidad de las operaciones, mejorar el censo de familias afectadas, la asignación a albergues y la entrega de ayudas humanitarias en emergencias municipales del Valle de Aburrá, reduciendo duplicidades, tiempos de respuesta y riesgos de fraude?

### 1.1.3 Causas y efectos

Las causas identificadas son cinco:

> • Captura manual de datos en papel o en herramientas no integradas, sin estandarización.
>
> • Dispersión de las fuentes de información entre dependencias y personas.
>
> • Ausencia de mecanismos de validación de identidad y de control automático de duplicados.
>
> • Falta de visibilidad centralizada de la capacidad de los albergues y de las existencias del inventario.
>
> • Carencia de un registro verificable de las entregas y de sus responsables.

Sus efectos son los siguientes:

> • Cobertura incompleta del censo y registros duplicados de hogares.
>
> • Albergues con sobrecupo mientras otros tienen capacidad disponible.
>
> • Demoras en la entrega de ayudas a la población vulnerable.
>
> • Imposibilidad de justificar documentalmente el destino de los bienes humanitarios.
>
> • Riesgo de suplantación e intermediación no autorizada.


## 1.2 Alcance

El sistema es una solución exclusivamente de software para la atención de emergencias a escala municipal (deslizamientos, inundaciones, incendios, sismos), validada en el contexto de los municipios del Valle de Aburrá. El alcance funcional corresponde, una a una, a las entidades del modelo de datos de la sección 1.8, como muestra la Tabla 1.

**Tabla 1**  
*Alcance funcional por entidad del modelo de datos*

| **Entidad del MER**  | **Qué gestiona el sistema**                                                   | **Historias de usuario**                               |
|----------------------|-------------------------------------------------------------------------------|--------------------------------------------------------|
| USUARIO              | Acceso por rol: registro, consulta, actualización e inactivación de usuarios. | HU-01, HU-02, HU-03, HU-25, HU-26, HU-27               |
| HOGAR                | Censo de hogares afectados, con registro sin conexión y sincronización.       | HU-04, HU-08, HU-09, HU-10, HU-11, HU-29               |
| INTEGRANTE           | Personas de cada hogar, identificadas por documento y sin duplicados.         | HU-05, HU-06, HU-07, HU-09, HU-10, HU-11, HU-18, HU-28 |
| INTEGRANTE_CONDICION | Enfoque diferencial de cada integrante.                                       | HU-07                                                  |
| ALBERGUE             | Albergues temporales, su capacidad, ocupación y cupos.                        | HU-12, HU-15, HU-30, HU-31                             |
| ASIGNACION_ALBERGUE  | Asignación de hogares a albergues y registro de su salida.                    | HU-13, HU-14                                           |
| TIPO_AYUDA           | Catálogo del inventario y existencias por tipo de ayuda.                      | HU-17, HU-20, HU-32, HU-33, HU-34                      |
| DONACION             | Donaciones recibidas con su procedencia.                                      | HU-16, HU-23                                           |
| ENTREGA              | Ayudas entregadas, con verificación de identidad, firma y trazabilidad.       | HU-19, HU-21, HU-22, HU-23                             |
| VOLUNTARIO           | Identificación de las personas voluntarias.                                   | HU-24, HU-35, HU-36, HU-37                             |

*Nota.* Las diez entidades son las del diccionario de datos (Tabla 10 a Tabla 19) y del modelo entidad-relación (Figura 6). Elaboración propia.

**Roles.** Operan el sistema tres roles con cuenta de usuario: Funcionario de gestión del riesgo, Coordinador de albergue y Administrador del sistema. La familia afectada, el donante, el voluntario y el organismo de socorro participan en la emergencia, pero no operan el sistema: la familia afectada está representada por las entidades HOGAR e INTEGRANTE y firma al recibir la ayuda; el donante y el organismo de socorro quedan registrados como origen de cada donación; el voluntario es la entidad VOLUNTARIO. Esta precisión corrige la versión anterior, que enumeraba siete roles sin distinguir cuáles tienen acceso.

**Exclusiones.** Quedan fuera del alcance:

> • La conexión en tiempo real con el RUD nacional. El sistema no lo reemplaza.
>
> • Las evaluaciones técnicas de infraestructura o de vulnerabilidad, propias de los organismos de socorro.
>
> • Los sensores, el internet de las cosas y las alertas tempranas.
>
> • Las transferencias o giros monetarios.
>
> • El despliegue en un entorno institucional de producción: el resultado es un prototipo funcional validado con datos de prueba.
>
> • En esta línea base, la bitácora de auditoría consultable, los reportes consolidados, la exportación de datos para el RUD y la asignación de tareas a voluntarios. Están previstos en los objetivos del proyecto y se especificarán en el siguiente nivel del curso; por eso no tienen entidad en el modelo actual.

**Supuestos y restricciones.** El tratamiento de los datos personales se ajusta a la Ley 1581 de 2012 (Congreso de la República de Colombia, 2012b). El personal de campo usa teléfonos móviles con navegador. Las pruebas se hacen con simulacros y datos sintéticos o anonimizados.
