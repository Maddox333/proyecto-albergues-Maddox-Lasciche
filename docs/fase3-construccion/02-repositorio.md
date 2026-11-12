> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 4.2 Repositorio Git

El repositorio del proyecto está en https://github.com/Maddox333/proyecto-albergues-Maddox-Lasciche. Tiene un README con la descripción, la instalación y el mapa de trazabilidad del código, una BITACORA.md con una entrada por semana, un DECISIONES.md con las decisiones técnicas y el artefacto de diseño que respalda cada una, y la carpeta docs con una subcarpeta por fase y otra para la trazabilidad (Tabla 192).

**Tabla 192**  
*Estructura del repositorio*

| **Ruta**                                   | **Contenido**                                                                                                             |
|--------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| README.md                                  | Descripción del proyecto, estructura, instalación, ejecución y mapa de trazabilidad del código.                           |
| BITACORA.md                                | Una entrada por semana del cronograma: qué se hizo, horas, artefactos, problema encontrado, cómo se resolvió y uso de IA. |
| DECISIONES.md                              | Decisiones técnicas DA-01 a DA-09 y solicitudes de cambio, cada una con el artefacto que la respalda.                     |
| .gitignore                                 | Excluye compilados de Maven, configuración del IDE, bases de datos locales y temporales.                                  |
| albergues_ddl.sql, datos_iniciales.sql     | Creación de la base de datos y datos de prueba, en la raíz (sección 4.1).                                                 |
| pom.xml, src/main/java, src/test/java      | Proyecto Maven: código MVC en los paquetes del DDA (sección 3.4) y sus pruebas (sección 4.3).                             |
| docs/fase0-concepcion, docs/fase1-analisis | Secciones de las Fases 0 y 1 en Markdown: primero la versión entregada en octubre y luego la corregida.                   |
| docs/fase2-diseño, docs/fase3-construccion | Secciones de las Fases 2 y 3 en Markdown.                                                                                 |
| docs/trazabilidad                          | Matriz de las Fases 0 y 1, matriz completa y recorridos de lectura cruzada.                                               |
| docs/diagramas                             | Fuentes PlantUML de los casos de uso, el modelo de datos y la Fase 2.                                                     |
| docs/entregas                              | Las versiones entregadas del documento Word (historial de la sección 5.1).                                                |

*Nota.* Elaboración propia.

El historial tiene un commit por semana del cronograma de la Tabla 22, en el mismo orden, y cada commit contiene los artefactos de esa semana (Tabla 193); la semana 15 tiene dos commits, uno por fase. Hasta la semana 12 los archivos de docs tienen el contenido de la versión entregada en octubre (v0.2); en las semanas 13 y 14 se reemplazan por la versión corregida, de modo que el diff de GitHub muestra cada corrección. Las líneas base son etiquetas (sección 5.2). Las fechas de los commits son las fechas reales en que se subieron; la semana a la que corresponde cada uno está en su mensaje y en la BITACORA.md.

**Tabla 193**  
*Historial del repositorio: un commit por semana del cronograma*

| **Sem.** | **Fechas (2026)** | **Mensaje del commit (sin el prefijo de semana)**                                                                               | **Archivos principales**                                                                                                                         | **Etiqueta** |
|----------|-------------------|---------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|--------------|
| 1        | 3 ago – 8 ago     | Fase 0: estructura del repositorio, descripción del problema y alcance                                                          | README.md, .gitignore, BITACORA.md, 01-descripcion-problema-y-alcance.md                                                                         | —            |
| 2        | 10 ago – 15 ago   | Fase 0: objetivos y estado del arte                                                                                             | 02-objetivos.md, 03-estado-del-arte.md                                                                                                           | —            |
| 3        | 17 ago – 22 ago   | Fase 0: marco teórico, metodología y diseño del guion de entrevista                                                             | 04-marco-teorico.md, 05-metodologia-y-recoleccion.md                                                                                             | —            |
| 4        | 24 ago – 29 ago   | Fase 0: cronograma y entrega del documento de la Fase 0                                                                         | 07-cronograma.md, v0.1_Documento_Fase_0.docx                                                                                                     | —            |
| 5        | 31 ago – 5 sep    | Fase 1: actores y lista de historias de usuario                                                                                 | 01-historias-de-usuario.md                                                                                                                       | —            |
| 6        | 7 sep – 12 sep    | Fase 1: fichas y criterios de aceptación de las historias de usuario                                                            | 01-historias-de-usuario.md                                                                                                                       | —            |
| 7        | 14 sep – 19 sep   | Fase 1: requisitos funcionales y reglas de negocio                                                                              | 02-reglas-y-requisitos.md                                                                                                                        | —            |
| 8        | 21 sep – 26 sep   | Fase 1: requisitos no funcionales y matrices HU–CA–RF–RN                                                                        | 02-reglas-y-requisitos.md, 01-matriz-fases-0-y-1.md                                                                                              | —            |
| 9        | 28 sep – 3 oct    | Fase 1: modelo general de casos de uso y casos críticos                                                                         | 03-casos-de-uso.md                                                                                                                               | —            |
| 10       | 5 oct – 10 oct    | Fase 1: revisión cruzada HU–RF–RN–CU y requisitos huérfanos                                                                     | 01-matriz-fases-0-y-1.md                                                                                                                         | —            |
| 11       | 12 oct – 17 oct   | Fases 0 y 1: integración del documento                                                                                          | v0.2_Documento_Fase_1.docx                                                                                                                       | —            |
| 12       | 19 oct – 24 oct   | Fases 0 y 1: entrega parcial                                                                                                    | v0.2_Documento_Fases_0_y_1.docx                                                                                                                  | —            |
| 13       | 26 oct – 31 oct   | Corrección 1: diccionario de datos en 3FN, MER y diagrama de clases                                                             | 06-modelo-de-datos.md, modelo-de-datos/                                                                                                          | —            |
| 14       | 2 nov – 7 nov     | Correcciones 1 a 3: historias en ficha oficial, requisitos, análisis de la encuesta, cronograma, casos de uso, mockups y matriz | fase0-concepcion/, fase1-analisis/, 01-matriz-fases-0-y-1.md, casos-de-uso/, v1.0_Documento_Fases_0_y_1.docx                                     | LB1          |
| 15       | 9 nov – 13 nov    | Fase 2: modelo relacional, auditoría, actividades, DDA, secuencia, estados, matriz y lectura cruzada (CRF-02)                   | fase2-diseño/, 02-matriz-completa.md, 03-lectura-cruzada.md, fase2/, DECISIONES.md, v1.1_Documento_Fases_0_1_y_2.docx                            | LB2          |
| 15       | 9 nov – 13 nov    | Fase 3: script SQL, primer corte vertical en MVC (CU-01, CU-03 a CU-07) y gestión de la configuración (CRF-01)                  | albergues_ddl.sql, datos_iniciales.sql, pom.xml, src/, fase3-construccion/, gestion-configuracion.md, README.md, v1.2_Documento_Fases_0_a_3.docx | LB3-corte1   |

*Nota.* Cada mensaje empieza con «Semana NN (fechas):»; todos los commits actualizan además la BITACORA.md. Una carpeta sin archivo indica todos sus archivos. Elaboración propia.
