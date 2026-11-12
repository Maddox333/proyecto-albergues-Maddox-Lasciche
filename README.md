# Sistema de información para la gestión de albergues, censo de familias afectadas y trazabilidad de ayudas humanitarias en emergencias: caso Valle de Aburrá

Proyecto del curso Ingeniería de Software II, Corporación Universitaria Remington.
Autor: Maddox Lasciche · Docente: Gloria Amparo Lora Patiño · Versión 1.2 (12 de noviembre de 2026).

El sistema registra los hogares afectados por una emergencia y sus integrantes, los albergues y su
ocupación, el inventario de donaciones y cada entrega de ayuda con firma del beneficiario, de modo
que cada ayuda se pueda rastrear desde la donación hasta la persona que la recibió.

## Qué contiene este primer corte

El primer corte vertical construye completo, de la pantalla a la base de datos, el núcleo del censo:

| CU | HU | Pantalla | Controlador | Métodos del modelo |
|---|---|---|---|---|
| CU-01 | HU-01 | MK-12 | `AccesoControlador` | Usuario.autenticar(), Usuario.tienePermiso() |
| CU-03 | HU-04 | MK-01 | `CensoControlador` | Hogar.crear() |
| CU-04 | HU-05 | MK-02 | `CensoControlador` | Integrante.crear(), Hogar.totalIntegrantes() |
| CU-05 | HU-07 | MK-02 | `CensoControlador` | Integrante.asignarCondiciones() |
| CU-06 | HU-06 | MK-02 | `CensoControlador` | Integrante.existeDocumento(), Hogar.buscarPorDocumento() |
| CU-07 | HU-08 | MK-01 | `CensoControlador` | Hogar.buscarPorDocumento(), AsignacionAlbergue.albergueActual(), Hogar.totalIntegrantes() |

Los otros 22 casos de uso tienen ya sus clases y métodos con la firma del diagrama de clases; al
invocarlos informan el caso de uso pendiente (sección 4.5 del documento).

## Tablas de la base de datos

`albergues_ddl.sql` crea las 10 tablas del modelo relacional: `ALBERGUE`, `USUARIO`, `HOGAR`,
`INTEGRANTE`, `INTEGRANTE_CONDICION`, `ASIGNACION_ALBERGUE`, `TIPO_AYUDA`, `DONACION`, `ENTREGA` y
`VOLUNTARIO`. El primer corte usa las seis primeras.

## Tecnología y por qué

Java 21, JDBC y MySQL 8, sin frameworks (decisiones DA-01, DA-03 y DA-09 en [DECISIONES.md](DECISIONES.md)).
El servidor HTTP es el que trae el JDK. Así cada clase del código corresponde a un elemento del
diagrama de clases o del documento de diseño arquitectónico, sin capas añadidas. Las pruebas usan
JUnit 5 y una base H2 en modo MySQL creada con el mismo `albergues_ddl.sql`.

## Estructura

```
├── albergues_ddl.sql          Script de creación de la base de datos (MySQL 8)
├── datos_iniciales.sql        Albergue y usuarios de prueba
├── pom.xml                    Proyecto Maven
├── src/main/java/albergues
│   ├── vista/                 MK-12, MK-01, MK-02 y validación de forma (DA-05)
│   ├── controlador/           AccesoControlador, CensoControlador, sesiones y permisos (DA-06)
│   ├── modelo/                9 clases y 4 enumeraciones del diagrama de clases
│   ├── persistencia/          Conexión con MySQL y hash de claves
│   └── Aplicacion.java        Servidor HTTP y rutas
├── src/test/java/albergues    19 pruebas, una por criterio de aceptación
├── BITACORA.md                Una entrada por semana del cronograma
├── DECISIONES.md              Decisiones técnicas y solicitudes de cambio
└── docs/
    ├── fase0-concepcion/      Problema, objetivos, marco, metodología, encuesta, modelo de datos, cronograma
    ├── fase1-analisis/        Historias de usuario, reglas y requisitos, casos de uso, mockups
    ├── fase2-diseño/          Modelo relacional, auditoría, actividades, DDA, secuencia, estados
    ├── fase3-construccion/    Script SQL, repositorio, corte vertical, instalación
    ├── trazabilidad/          Matriz de las Fases 0 y 1, matriz completa, lectura cruzada
    ├── diagramas/             Fuentes PlantUML
    ├── imagenes/              Figuras de los documentos
    ├── entregas/              Cada versión entregada del documento Word
    └── gestion-configuracion.md
```

## Cómo ejecutar

Requisitos: Java 21, Maven 3.9 y MySQL 8.

```bash
git clone https://github.com/Maddox333/proyecto-albergues-Maddox-Lasciche.git
cd proyecto-albergues-Maddox-Lasciche
mysql -u root -p < albergues_ddl.sql
mysql -u root -p albergues < datos_iniciales.sql
mvn test                  # 19 pruebas; no necesitan MySQL (usan H2)
mvn compile exec:java     # inicia en http://localhost:8080/
```

Usuario y clave de MySQL: `src/main/resources/albergues.properties`, o las variables de entorno
`ALBERGUES_DB_URL`, `ALBERGUES_DB_USUARIO` y `ALBERGUES_DB_CLAVE`.
Usuarios de prueba: `lrestrepo` (Funcionario) y `arios` (Coordinador); la clave de prueba está en
`datos_iniciales.sql`.

## Cómo seguir la trazabilidad en el código

Cadena: hallazgo de la encuesta (1.7) → HU → CA → RN/RF → CU → mockup → clase.método → mensaje de
secuencia → pantalla.

- Cada método del modelo cita en su Javadoc las HU, RF y CU que lo exigen.
- `CensoControlador.registrarIntegrante` marca cada llamada con el mensaje de DS-04 que implementa.
- Cada prueba cita en su nombre el criterio de aceptación y la regla que verifica.
- La matriz completa está en [docs/trazabilidad/02-matriz-completa.md](docs/trazabilidad/02-matriz-completa.md)
  y los recorridos de lectura en [docs/trazabilidad/03-lectura-cruzada.md](docs/trazabilidad/03-lectura-cruzada.md).

## Historial: un commit por semana del cronograma

Las fechas de los commits son las fechas reales en que se subieron al repositorio; la semana a la
que corresponde cada uno está en su mensaje y en [BITACORA.md](BITACORA.md).

| Sem. | Fechas (2026) | Commit | Etiqueta |
|---|---|---|---|
| 01 | 3 ago – 8 ago | Fase 0: estructura del repositorio, descripción del problema y alcance |  |
| 02 | 10 ago – 15 ago | Fase 0: objetivos y estado del arte |  |
| 03 | 17 ago – 22 ago | Fase 0: marco teórico, metodología y diseño del guion de entrevista |  |
| 04 | 24 ago – 29 ago | Fase 0: cronograma y entrega del documento de la Fase 0 |  |
| 05 | 31 ago – 5 sep | Fase 1: actores y lista de historias de usuario |  |
| 06 | 7 sep – 12 sep | Fase 1: fichas y criterios de aceptación de las historias de usuario |  |
| 07 | 14 sep – 19 sep | Fase 1: requisitos funcionales y reglas de negocio |  |
| 08 | 21 sep – 26 sep | Fase 1: requisitos no funcionales y matrices HU–CA–RF–RN |  |
| 09 | 28 sep – 3 oct | Fase 1: modelo general de casos de uso y casos críticos |  |
| 10 | 5 oct – 10 oct | Fase 1: revisión cruzada HU–RF–RN–CU y requisitos huérfanos |  |
| 11 | 12 oct – 17 oct | Fases 0 y 1: integración del documento |  |
| 12 | 19 oct – 24 oct | Fases 0 y 1: entrega parcial |  |
| 13 | 26 oct – 31 oct | Corrección 1: diccionario de datos en 3FN, MER y diagrama de clases |  |
| 14 | 2 nov – 7 nov | Correcciones 1 a 3: historias en ficha oficial, requisitos, análisis de la encuesta, cronograma, casos de uso, mockups y matriz | LB1 |
| 15 | 9 nov – 13 nov | Fase 2: modelo relacional, auditoría, actividades, DDA, secuencia, estados, matriz y lectura cruzada (CRF-02) | LB2 |
| 15 | 9 nov – 13 nov | Fase 3: script SQL, primer corte vertical en MVC (CU-01, CU-03 a CU-07) y gestión de la configuración (CRF-01) | LB3-corte1 |

Líneas base (etiquetas):

| Etiqueta | Contenido | Semana |
|---|---|---|
| `LB1` | Fases 0 y 1 corregidas | semana 14 |
| `LB2` | Fase 2 completa, compuerta M2 | semana 15 |
| `LB3-corte1` | Fase 3, primer corte vertical | semana 15 (entrega final, 13 de noviembre) |
