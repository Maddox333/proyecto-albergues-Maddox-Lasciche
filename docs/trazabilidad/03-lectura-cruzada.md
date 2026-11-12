> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 3.8 Lectura cruzada y compuerta M2

La lectura cruzada (paso 12b) es un punto de control de lectura: comprueba que el equipo sabe ubicarse en el proyecto y seguir la trazabilidad de un artefacto a otro sin ayuda, que es lo que se evalúa. La Tabla 189 resuelve cinco recorridos de lectura, uno por cada tipo de artefacto de la Fase 2, y cita en cada paso la tabla o figura donde se encuentra el eslabón.

**Tabla 189**  
*Recorridos de lectura resueltos (paso 12b)*

| **N.º** | **Punto de partida**                                                      | **Recorrido**                                                                                                                                                                                                                  | **Resultado**                                                                                              |
|---------|---------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| 1       | Fila de la matriz: HU-05 con Integrante.crear() (Tabla 188)               | HU-05 (ficha de la sección 2.1) → CA-05.1 → RF-08 (sección 2.2) → tabla INTEGRANTE (Tabla 179) → Integrante.crear() (Tabla 21) → CU-04 (Tabla 157) → mensaje 12 de DS-04 (Figura 34) → botón «Guardar» de MK-02 (sección 2.5). | La cadena se recorre completa, sin eslabones faltantes.                                                    |
| 2       | Rombo «¿Cupos disponibles ≥ integrantes del hogar? \[RN-15\]» (Figura 27) | RN-15 «Prohibido el sobrecupo» (sección 2.2) → origen: hallazgos H-04 y H-06 de la encuesta (sección 1.7.3) → CA-13.2 de HU-13 → RF-19 → Albergue.cuposDisponibles() → FA-04 de CU-12 (Tabla 159).                             | La regla del rombo nace de la encuesta y del criterio de rechazo de HU-13.                                 |
| 3       | Mensaje 24 de DS-18: registrar(e) (Figura 39)                             | Entrega.registrar(e) existe en el diagrama de clases (Figura 8) → lo dispara el botón «Registrar entrega» de MK-06 (sección 2.5) → CU-18 → HU-19 y HU-20 → RN-20, RN-21 y RN-23.                                               | El mensaje cumple la regla de oro y llega a su pantalla.                                                   |
| 4       | Transición «Sin albergue → Inactivo» del hogar (Figura 42)                | Hogar.inactivar(idHogar) con la guarda \[no está alojado; RN-29\] → CA-29.4 «Rechazo por hogar alojado» de HU-29 → CU-28, FA-01 (Tabla 162) → mensajes de DS-28 (Figura 40) → aviso MK-07.                                     | La transición la exige HU-29; la guarda es su criterio de rechazo.                                         |
| 5       | Tabla INTEGRANTE del modelo relacional (Tabla 179)                        | Diccionario INTEGRANTE (sección 1.8.1) → atributos de la clase Integrante (Figura 7) → id_hogar como asociación Integrante–Hogar → UNIQUE (tipo_documento, numero_documento) de la Tabla 181 → RN-07 → CU-06.                  | Los tres modelos coinciden (Tabla 182); la regla de documento único se cumple también en la base de datos. |

*Nota.* Elaboración propia.

La compuerta M2 decide si se abre la Fase 3. La regla del curso es «sin matriz cerrada y leída, no hay código». La Tabla 190 presenta su estado final.

**Tabla 190**  
*Lista de verificación de la compuerta M2*

| **N.º** | **Condición**                                                                             | **Estado**                                                                                    |
|---------|-------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| 1       | Matriz cerrada: cada historia llega a requisito, entidad, método, caso de uso y pantalla. | Cumple: 73 filas, ninguna incompleta (Tabla 188).                                             |
| 2       | Regla de oro: ningún mensaje invoca un método inexistente.                                | Cumple: 27 mensajes revisados (Tabla 186).                                                    |
| 3       | Cada rombo de los diagramas de actividades cita una regla de negocio del caso de uso.     | Cumple: 25 rombos en seis diagramas.                                                          |
| 4       | Cada transición de estados nombra un método existente.                                    | Cumple: 23 transiciones.                                                                      |
| 5       | Diccionario, MER, clases y modelo relacional coinciden.                                   | Cumple, después de aplicar CRF-02 (Tabla 182).                                                |
| 6       | Cada paquete del DDA se traza a artefactos del análisis.                                  | Cumple (Tabla 184).                                                                           |
| 7       | Lectura cruzada: el equipo sabe ubicarse y seguir la trazabilidad.                        | Cumple: cinco recorridos resueltos (Tabla 189).                                               |
| 8       | Revisión de la docente y congelamiento de la LB2.                                         | Cumple: visto bueno de la docente el 12 de noviembre de 2026; etiqueta LB2 en el repositorio. |

*Nota.* Con las ocho condiciones cumplidas, la compuerta se abrió y comenzó la Fase 3 (capítulo 4). Elaboración propia.

Quedan registrados dos puntos para el siguiente nivel del proyecto, porque no afectan el primer corte de construcción: cómo sale un registro del estado CONFLICTO (las historias solo piden que quede para revisión) y si el registro de un integrante nuevo en un hogar alojado debe verificar los cupos del albergue, porque la ocupación cuenta integrantes activos (RN-14) y ninguna regla lo controla hoy. Ambos entrarán por solicitud de cambio.
