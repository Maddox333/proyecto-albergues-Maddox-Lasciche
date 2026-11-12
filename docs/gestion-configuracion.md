> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

# 5. Gestión del cambio y de la configuración

La gestión del cambio y la gestión de la configuración son transversales a toda la ruta del curso. La primera decide: todo cambio a un artefacto aprobado entra por una solicitud de cambio (CRF). La segunda registra: cada versión del documento queda en el historial, las líneas base congelan los artefactos que sirven de puerta para la fase siguiente y, en Git, cada línea base es una etiqueta.

## 5.1 Historial de versiones

**Tabla 197**  
*Historial de versiones del documento*

| **Versión** | **Fecha**               | **Descripción**                                                                                                                                            | **CRF** | **Línea base** |
|-------------|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|----------------|
| 0.1         | 29 de agosto de 2026    | Documento de la Fase 0: problema, alcance, objetivos, estado del arte, marco teórico, metodología, guion de entrevista y cronograma.                       | —       | —              |
| 0.2         | 24 de octubre de 2026   | Entrega parcial de las Fases 0 y 1: historias de usuario, requisitos, reglas de negocio y casos de uso.                                                    | —       | —              |
| 1.0         | 10 de noviembre de 2026 | Corrección según la retroalimentación del 25 de octubre (Apéndice A): sección 1.7, modelo de datos, fichas oficiales, mockups y formato APA.               | —       | LB1            |
| 1.1         | 11 de noviembre de 2026 | Fase 2 (pasos 6 a 12b de la ruta del curso), capítulo de gestión del cambio y de la configuración y corrección de la auditoría cruzada.                    | CRF-02  | LB2            |
| 1.2         | 12 de noviembre de 2026 | Cronograma ajustado a 15 semanas, recorridos de lectura (12b), compuerta M2 aprobada y Fase 3: script SQL, repositorio Git y primer corte vertical en MVC. | CRF-01  | LB3 (corte 1)  |

*Nota.* Las versiones 0.1 y 0.2 se reconstruyeron a partir de los hitos del cronograma. Elaboración propia.

## 5.2 Líneas base

Una línea base es un conjunto de artefactos revisados que solo cambia mediante una solicitud de cambio aprobada. La Tabla 198 define las tres líneas base del proyecto y la etiqueta que las representa en el repositorio.

**Tabla 198**  
*Líneas base del proyecto*

| **Línea base** | **Contenido**                                                                                                                                                  | **Se congeló**                                  | **Etiqueta en Git** |
|----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------|---------------------|
| LB1            | Fases 0 y 1: secciones 1 y 2 del documento (problema, recolección de información, modelo de datos, cronograma, historias, requisitos, casos de uso y mockups). | Al cerrar las correcciones (semana 14).         | LB1                 |
| LB2            | Fase 2: sección 3 (modelo relacional, auditoría, actividades, DDA, secuencia, estados, matriz y lectura).                                                      | Con la compuerta M2 aprobada (12 de noviembre). | LB2                 |
| LB3            | Fase 3, primer corte: script SQL, código del censo y sus pruebas (capítulo 4).                                                                                 | Con la entrega final (13 de noviembre).         | LB3-corte1          |

*Nota.* Elaboración propia.

## 5.3 Solicitudes de cambio

Cada solicitud de cambio usa el formato de las fichas siguientes. Indica el elemento de configuración afectado y su impacto en la trazabilidad, para que ningún cambio rompa la cadena entre artefactos. Hay dos solicitudes registradas, ambas aprobadas y aplicadas.

**Tabla 199**  
*Solicitud de cambio CRF-01: Ajuste del cronograma por el adelanto de la entrega final al 13 de noviembre*

| **Código**                             | **CRF-01**                                                                                                                                                                                                                        |
|----------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Fecha de solicitud**                 | 11 de noviembre de 2026 (propuesta) y 12 de noviembre de 2026 (ajuste)                                                                                                                                                            |
| **Solicitante**                        | Maddox Lasciche                                                                                                                                                                                                                   |
| **Elemento de configuración afectado** | Sección 1.9 Cronograma (tabla del cronograma y resumen por fase) e historial semanal del repositorio (sección 4.2).                                                                                                               |
| **Descripción del cambio**             | El semestre pasa de 16 a 15 semanas (del 3 de agosto al 13 de noviembre) y de 192 a 180 horas. La semana 14 reúne las correcciones de las Fases 0 y 1, y la semana 15 la Fase 2 completa y el primer corte vertical de la Fase 3. |
| **Justificación**                      | La docente adelantó la entrega final del 20 al 13 de noviembre. La propuesta inicial de esta solicitud (11 de noviembre) redistribuía las semanas 15 y 16; con el adelanto, la semana 16 desaparece.                              |
| **Impacto en la trazabilidad**         | Ninguno sobre HU, RF, RN, CU ni mockups. Cambia la planeación y, con ella, la correspondencia entre semanas y commits del repositorio.                                                                                            |
| **Impacto en el alcance**              | La Fase 3 se limita al primer corte vertical (censo de hogares e integrantes). Los cortes siguientes pasan al siguiente nivel del proyecto de continuidad.                                                                        |
| **Estado y decisión**                  | **Aprobado y aplicado.** Visto bueno de la docente el 12 de noviembre de 2026; aplicado en la versión 1.2.                                                                                                                        |
| **Línea base afectada**                | LB1 (sección 1.9).                                                                                                                                                                                                                |

*Nota.* Elaboración propia.

**Tabla 200**  
*Solicitud de cambio CRF-02: Asociación faltante entre Usuario y AsignacionAlbergue para el registro de la salida*

| **Código**                             | **CRF-02**                                                                                                                                                                                                                                                   |
|----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Fecha de solicitud**                 | 11 de noviembre de 2026                                                                                                                                                                                                                                      |
| **Solicitante**                        | Maddox Lasciche (resultado de la auditoría cruzada, sección 3.2)                                                                                                                                                                                             |
| **Elemento de configuración afectado** | Figura del modelo entidad-relación (1.8.2) y figura del diagrama de clases de usuarios, censo y albergues (1.8.3).                                                                                                                                           |
| **Descripción del cambio**             | Agregar la relación «registra salida» entre USUARIO y ASIGNACION_ALBERGUE en el MER (cero o uno a muchos) y la asociación correspondiente entre Usuario y AsignacionAlbergue en el diagrama de clases, con multiplicidad 0..1 a 0..\*.                       |
| **Justificación**                      | El diccionario de datos tiene dos llaves foráneas de ASIGNACION_ALBERGUE hacia USUARIO (id_usuario_asigna e id_usuario_salida), pero el MER y el diagrama de clases solo dibujaban la primera. La segunda nace de HU-14 y RNF-03 (quién registró la salida). |
| **Impacto en la trazabilidad**         | No cambia HU, RF, RN ni métodos. Corrige dos figuras para que coincidan con el diccionario. El script SQL ya incluía la llave foránea porque se genera desde el diccionario, y la clase AsignacionAlbergue del código tiene la referencia usuarioSalida.     |
| **Estado y decisión**                  | **Aprobado y aplicado** en la versión 1.1.                                                                                                                                                                                                                   |
| **Línea base afectada**                | LB1 (sección 1.8).                                                                                                                                                                                                                                           |

*Nota.* Elaboración propia.

## 5.4 Convenciones del repositorio Git

El repositorio aplica las convenciones de la Tabla 201, para que la configuración del código quede trazada a las mismas semanas, solicitudes de cambio y líneas base del documento.

**Tabla 201**  
*Convenciones de gestión de la configuración en Git*

| **Elemento**                        | **Convención**                                                                                                                                                                                              |
|-------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Rama principal                      | main: solo recibe trabajo revisado.                                                                                                                                                                         |
| Un commit por semana del cronograma | El mensaje empieza con la semana y sus fechas, y cita los artefactos, casos de uso o solicitudes de cambio que contiene. Ejemplo: «Semana 15 (9 nov – 13 nov): Fase 3, CU-04 registrar integrante (DS-04)». |
| Bitácora semanal                    | BITACORA.md tiene una entrada por semana con las actividades, las horas y los artefactos, tal como aparecen en la Tabla 22.                                                                                 |
| Etiquetas                           | Cada línea base es una etiqueta: LB1, LB2 y LB3-corte1.                                                                                                                                                     |
| Raíz del repositorio                | Script SQL de creación de la base de datos, datos iniciales, pom.xml, README y .gitignore.                                                                                                                  |
| Documento                           | Cada versión entregada del documento Word se guarda en docs/entregas, y cada sección en Markdown en la carpeta de su fase.                                                                                  |

*Nota.* Elaboración propia.
