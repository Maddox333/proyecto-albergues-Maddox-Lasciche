# Decisiones técnicas

Cada decisión registra qué se decidió, por qué y qué artefacto de diseño la respalda. Las decisiones DA-01 a DA-09 son las del documento de diseño arquitectónico (sección 3.4.1).

---

## DA-01
**¿Qué decidí?**
Arquitectura por capas con el patrón MVC.

**¿Por qué?**
Separa las pantallas (MK) de las reglas de negocio y de la base de datos, de modo que cada capa se traza a su artefacto de análisis: vista → mockups, controlador → casos de uso, modelo → diagrama de clases.

**¿Qué artefacto de diseño respalda esta decisión?**
Ruta del curso; RNF-08

---

## DA-02
**¿Qué decidí?**
Aplicación web adaptable, usada desde el navegador.

**¿Por qué?**
El personal de campo usa teléfonos con navegador (supuesto de la sección 1.2); no se instala nada en el dispositivo.

**¿Qué artefacto de diseño respalda esta decisión?**
RNF-07

---

## DA-03
**¿Qué decidí?**
Base de datos relacional MySQL; tipos Java en el modelo.

**¿Por qué?**
El diccionario ya usa tipos ENUM, VARCHAR y DATETIME de MySQL y tipos Java; las llaves únicas y las restricciones CHECK hacen cumplir reglas en la base de datos.

**¿Qué artefacto de diseño respalda esta decisión?**
RN-02, RN-07, RN-11, RN-17, RN-19; RNF-04

---

## DA-04
**¿Qué decidí?**
Operación sin conexión con almacenamiento local en el navegador.

**¿Por qué?**
El cliente guarda los hogares e integrantes en estado PENDIENTE y los envía al recuperar la conexión; el servidor confirma registro por registro, así una interrupción no pierde ni duplica datos.

**¿Qué artefacto de diseño respalda esta decisión?**
RN-25, RN-26; RNF-05, RNF-06

---

## DA-05
**¿Qué decidí?**
Validación en dos niveles.

**¿Por qué?**
La vista valida la forma (datos obligatorios, formato del documento, cantidades positivas) sin acceder a los datos, también sin conexión. El modelo valida las reglas que necesitan datos: documento único, cupos, existencias, estados activos.

**¿Qué artefacto de diseño respalda esta decisión?**
RN-06, RN-08, RN-17 (vista); RN-07, RN-13, RN-15, RN-21, RN-34 (modelo)

---

## DA-06
**¿Qué decidí?**
Control de acceso centralizado en el controlador.

**¿Por qué?**
Un filtro verifica la sesión y el permiso del rol antes de atender cualquier evento; la clave se guarda como hash.

**¿Qué artefacto de diseño respalda esta decisión?**
RN-01, RN-04, RN-05; RNF-01, RNF-02

---

## DA-07
**¿Qué decidí?**
Datos de trazabilidad asignados por el sistema; existencias calculadas.

**¿Por qué?**
Las fechas y el usuario responsable no los digita nadie; las existencias se calculan como recibido menos entregado y no se almacenan, por lo que no pueden quedar desactualizadas.

**¿Qué artefacto de diseño respalda esta decisión?**
RN-20, RN-23; RNF-03, RNF-04

---

## DA-08
**¿Qué decidí?**
Ninguna operación borra registros.

**¿Por qué?**
Las bajas cambian el atributo activo a FALSE y las llaves foráneas se definen sin borrado en cascada.

**¿Qué artefacto de diseño respalda esta decisión?**
RN-27

---

## DA-09
**¿Qué decidí?**
Servidor HTTP incorporado en el JDK, sin frameworks.

**¿Por qué?**
El primer corte se ejecuta con Java 21 y solo dos dependencias externas: el conector de MySQL y, para las pruebas, H2 y JUnit. Así cada clase del código corresponde a un elemento del DDA o del diagrama de clases, sin capas añadidas por un framework.

**¿Qué artefacto de diseño respalda esta decisión?**
RNF-07; alcance del curso

---

# Solicitudes de cambio

## CRF-01: Ajuste del cronograma por el adelanto de la entrega final al 13 de noviembre

| Campo | Detalle |
|---|---|
| Código | CRF-01 |
| Fecha de solicitud | 11 de noviembre de 2026 (propuesta) y 12 de noviembre de 2026 (ajuste) |
| Solicitante | Maddox Lasciche |
| Elemento de configuración afectado | Sección 1.9 Cronograma (tabla del cronograma y resumen por fase) e historial semanal del repositorio (sección 4.2). |
| Descripción del cambio | El semestre pasa de 16 a 15 semanas (del 3 de agosto al 13 de noviembre) y de 192 a 180 horas. La semana 14 reúne las correcciones de las Fases 0 y 1, y la semana 15 la Fase 2 completa y el primer corte vertical de la Fase 3. |
| Justificación | La docente adelantó la entrega final del 20 al 13 de noviembre. La propuesta inicial de esta solicitud (11 de noviembre) redistribuía las semanas 15 y 16; con el adelanto, la semana 16 desaparece. |
| Impacto en la trazabilidad | Ninguno sobre HU, RF, RN, CU ni mockups. Cambia la planeación y, con ella, la correspondencia entre semanas y commits del repositorio. |
| Impacto en el alcance | La Fase 3 se limita al primer corte vertical (censo de hogares e integrantes). Los cortes siguientes pasan al siguiente nivel del proyecto de continuidad. |
| Estado y decisión | Aprobado y aplicado. Visto bueno de la docente el 12 de noviembre de 2026; aplicado en la versión 1.2. |
| Línea base afectada | LB1 (sección 1.9). |

## CRF-02: Asociación faltante entre Usuario y AsignacionAlbergue para el registro de la salida

| Campo | Detalle |
|---|---|
| Código | CRF-02 |
| Fecha de solicitud | 11 de noviembre de 2026 |
| Solicitante | Maddox Lasciche (resultado de la auditoría cruzada, sección 3.2) |
| Elemento de configuración afectado | Figura del modelo entidad-relación (1.8.2) y figura del diagrama de clases de usuarios, censo y albergues (1.8.3). |
| Descripción del cambio | Agregar la relación «registra salida» entre USUARIO y ASIGNACION_ALBERGUE en el MER (cero o uno a muchos) y la asociación correspondiente entre Usuario y AsignacionAlbergue en el diagrama de clases, con multiplicidad 0..1 a 0..*. |
| Justificación | El diccionario de datos tiene dos llaves foráneas de ASIGNACION_ALBERGUE hacia USUARIO (id_usuario_asigna e id_usuario_salida), pero el MER y el diagrama de clases solo dibujaban la primera. La segunda nace de HU-14 y RNF-03 (quién registró la salida). |
| Impacto en la trazabilidad | No cambia HU, RF, RN ni métodos. Corrige dos figuras para que coincidan con el diccionario. El script SQL ya incluía la llave foránea porque se genera desde el diccionario, y la clase AsignacionAlbergue del código tiene la referencia usuarioSalida. |
| Estado y decisión | Aprobado y aplicado en la versión 1.1. |
| Línea base afectada | LB1 (sección 1.8). |

## Decisión sobre el historial de Git

**¿Qué decidí?**
Un commit por semana del cronograma, en orden, con la semana y sus fechas al inicio del mensaje, y
con las fechas reales de subida en cada commit.

**¿Por qué?**
El repositorio debe mostrar lo que se hizo en cada semana, coincidiendo con el cronograma, sin
alterar las fechas que registra Git. La semana queda en el mensaje, en la bitácora y en la tabla
del historial (sección 4.2).

**¿Qué artefacto de diseño respalda esta decisión?**
Sección 1.9 (cronograma), sección 5.4 (convenciones de Git) y CRF-01.
