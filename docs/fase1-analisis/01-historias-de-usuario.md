> Versión 0.2 (entrega parcial de octubre de 2026). Se corrige en las semanas 13 y 14; ver BITACORA.md.

## 1. Lista de Historias de Usuario

| HU    | Nombre                                                | Actor/Rol                                                   | Fundamento en Fase 0        |
|-------|-------------------------------------------------------|-------------------------------------------------------------|-----------------------------|
| HU-01 | Iniciar sesión                                        | Usuario registrado                                          | Derivado                    |
| HU-02 | Registrar usuario y asignar rol                       | Administrador del sistema                                   | Derivado                    |
| HU-03 | Acceder solo a las funciones de mi rol                | Usuario autenticado                                         | Directo                     |
| HU-04 | Registrar hogar afectado                              | Funcionario de gestión del riesgo                           | Directo                     |
| HU-05 | Registrar integrantes del hogar                       | Funcionario de gestión del riesgo                           | Directo                     |
| HU-06 | Evitar el registro duplicado de personas              | Funcionario de gestión del riesgo                           | Directo                     |
| HU-07 | Registrar enfoque diferencial de un integrante        | Funcionario de gestión del riesgo                           | Directo                     |
| HU-08 | Consultar un hogar registrado                         | Funcionario de gestión del riesgo                           | Derivado                    |
| HU-09 | Actualizar datos de un hogar o integrante             | Funcionario de gestión del riesgo                           | Derivado (V-17)             |
| HU-10 | Registrar hogares sin conexión                        | Funcionario de gestión del riesgo                           | Directo                     |
| HU-11 | Sincronizar registros pendientes                      | Funcionario de gestión del riesgo                           | Directo                     |
| HU-12 | Registrar albergue temporal                           | Funcionario de gestión del riesgo                           | Directo                     |
| HU-13 | Asignar hogar a un albergue                           | Funcionario de gestión del riesgo                           | Directo                     |
| HU-14 | Registrar salida de un hogar del albergue             | Coordinador de albergue                                     | Derivado                    |
| HU-15 | Consultar ocupación y cupos de albergues              | Funcionario de gestión del riesgo / Coordinador de albergue | Directo                     |
| HU-16 | Registrar donación recibida                           | Funcionario de gestión del riesgo                           | Directo                     |
| HU-17 | Consultar existencias del inventario                  | Funcionario de gestión del riesgo / Coordinador de albergue | Directo                     |
| HU-18 | Verificar identidad del beneficiario                  | Funcionario de gestión del riesgo                           | Directo                     |
| HU-19 | Registrar entrega de ayuda a un hogar                 | Funcionario de gestión del riesgo                           | Directo                     |
| HU-20 | Descontar automáticamente del inventario cada entrega | Funcionario de gestión del riesgo                           | Directo                     |
| HU-21 | Registrar firma digital del beneficiario              | Funcionario de gestión del riesgo                           | Directo                     |
| HU-22 | Consultar historial de entregas de un hogar           | Funcionario de gestión del riesgo                           | Directo                     |
| HU-23 | Consultar trazabilidad de un tipo de ayuda            | Funcionario de gestión del riesgo                           | Directo                     |
| HU-24 | Registrar voluntario                                  | Funcionario de gestión del riesgo                           | Directo (datos por validar) |

*Criterio de la columna Fundamento:* **Directo** = la funcionalidad está nombrada en la Fase 0. **Derivado** = no está nombrada textualmente, pero es necesaria para operar una funcionalidad que sí lo está. **REQUIERE VALIDACIÓN** = el fundamento o el alcance no pueden justificarse con la Fase 0.


## 2–3. Historias de Usuario completas y Criterios de Aceptación

### Módulo de acceso y roles

### HU-01 — Iniciar sesión

**Actor/Rol:** Usuario registrado (cualquiera de los roles contemplados)

**Historia de Usuario:** Como usuario registrado, quiero autenticarme en el sistema, para acceder a las funciones que corresponden a mi rol.

**CA-01.1** Dado que el usuario está registrado y activo, cuando ingresa sus credenciales correctas, entonces el sistema inicia su sesión y le muestra únicamente las opciones de su rol.

**CA-01.2** Dado que el usuario está registrado, cuando ingresa credenciales incorrectas, entonces el sistema no inicia la sesión y muestra un mensaje de credenciales inválidas.

**CA-01.3** Dado que el usuario está en la pantalla de inicio de sesión, cuando deja vacío el usuario o la contraseña y solicita ingresar, entonces el sistema no inicia la sesión y señala el campo faltante.

**CA-01.4** Dado que no hay una sesión iniciada, cuando una persona intenta abrir directamente cualquier función del sistema, entonces el sistema la redirige al inicio de sesión sin mostrar información.

### HU-02 — Registrar usuario y asignar rol

**Actor/Rol:** Administrador del sistema

**Historia de Usuario:** Como Administrador del sistema, quiero registrar un usuario y asignarle uno de los roles contemplados, para controlar quién opera el sistema y con qué permisos.

**CA-02.1** Dado que el Administrador ha iniciado sesión, cuando registra un usuario con todos sus datos obligatorios y selecciona uno de los roles contemplados en el alcance (Funcionario de gestión del riesgo, Coordinador de albergue, Donante, Voluntario, Organismo de socorro, Familia afectada o Administrador del sistema), entonces el usuario queda registrado, activo y con el rol asignado, y puede iniciar sesión.

**CA-02.2** Dado que ya existe un usuario con determinado identificador de acceso, cuando el Administrador intenta registrar otro usuario con el mismo identificador, entonces el sistema no lo registra y muestra un mensaje indicando que el identificador ya existe.

**CA-02.3** Dado que el Administrador está registrando un usuario, cuando solicita guardar sin seleccionar un rol, entonces el sistema no registra al usuario y señala que el rol es obligatorio.

**CA-02.4** Dado que el usuario autenticado tiene un rol distinto de Administrador del sistema, cuando intenta registrar un usuario, entonces el sistema deniega la operación y no crea ningún usuario.

### HU-03 — Acceder solo a las funciones de mi rol

**Actor/Rol:** Usuario autenticado

**Historia de Usuario:** Como usuario autenticado, quiero ver y usar únicamente las funciones permitidas para mi rol, para que la información sensible de las familias afectadas solo sea accesible a quien corresponde.

**CA-03.1** Dado que un usuario ha iniciado sesión con un rol determinado, cuando accede a su menú principal, entonces el sistema muestra solo las funciones autorizadas para ese rol (V-02).

**CA-03.2** Dado que un usuario autenticado no tiene autorización para una función, cuando intenta abrirla directamente por su dirección, entonces el sistema deniega el acceso, muestra un mensaje de acceso no autorizado y no ejecuta la función.

**CA-03.3** Dado que el usuario autenticado tiene el rol Coordinador de albergue, cuando intenta registrar un usuario nuevo, entonces el sistema deniega la operación porque esa función es exclusiva del Administrador del sistema.

### Módulo de censo

### HU-04 — Registrar hogar afectado

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero registrar un hogar (unidad familiar) afectado por la emergencia, para incluirlo en el censo desde las primeras horas del evento.

**CA-04.1** Dado que el Funcionario ha iniciado sesión, cuando registra un hogar con todos sus datos obligatorios (V-05), entonces el hogar queda registrado en el censo con un identificador único generado por el sistema y el sistema muestra un mensaje de confirmación.

**CA-04.2** Dado que el Funcionario está registrando un hogar, cuando deja vacío un dato obligatorio y solicita guardar, entonces el sistema no registra el hogar y señala el dato faltante.

**CA-04.3** Dado que un hogar fue registrado correctamente, cuando el Funcionario lo busca en el censo, entonces el sistema lo muestra con los datos con los que fue registrado.

### HU-05 — Registrar integrantes del hogar

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero registrar a cada integrante de un hogar con su documento de identidad, para que el censo identifique individualmente a cada persona afectada.

**CA-05.1** Dado que existe un hogar registrado, cuando el Funcionario agrega un integrante con tipo y número de documento válidos y los demás datos obligatorios (V-05), entonces el integrante queda asociado a ese hogar y el hogar muestra el nuevo total de integrantes.

**CA-05.2** Dado que el Funcionario está registrando un integrante, cuando deja vacío un dato obligatorio y solicita guardar, entonces el sistema no registra al integrante y señala el dato faltante.

**CA-05.3** Dado que el Funcionario está registrando un integrante, cuando ingresa un número de documento con formato inválido para el tipo de documento seleccionado (V-06), entonces el sistema no registra al integrante y muestra un mensaje que indica el formato esperado.

### HU-06 — Evitar el registro duplicado de personas

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero que el sistema me alerte cuando el documento de una persona ya está registrado en el censo, para evitar que una misma persona o familia sea censada más de una vez.

**CA-06.1** Dado que una persona con determinado tipo y número de documento ya es integrante del hogar A, cuando el Funcionario intenta registrar un integrante con ese mismo tipo y número en el hogar B, entonces el sistema no lo registra y muestra una alerta indicando que el documento ya está registrado y en qué hogar.

**CA-06.2** Dado que una persona ya es integrante del hogar A, cuando el Funcionario intenta registrarla nuevamente en el mismo hogar A, entonces el sistema no crea un segundo registro y muestra la alerta de documento ya registrado.

**CA-06.3** Dado que el sistema mostró la alerta de duplicado, cuando el Funcionario cancela la operación, entonces no se crea ningún registro nuevo y el registro original permanece sin cambios.

### HU-07 — Registrar enfoque diferencial de un integrante

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero registrar si un integrante pertenece a un grupo de enfoque diferencial, para que la atención reconozca sus necesidades particulares.

**CA-07.1** Dado que existe un integrante registrado, cuando el Funcionario le asigna una o más condiciones de enfoque diferencial de la lista (niño, adulto mayor, persona con discapacidad, gestante, minoría étnica), entonces el integrante queda con esas condiciones y la ficha del hogar las muestra.

**CA-07.2** Dado que existe un integrante registrado, cuando el Funcionario guarda sin asignarle ninguna condición, entonces el integrante queda registrado sin enfoque diferencial.

**CA-07.3** Dado que el Funcionario está asignando una condición de enfoque diferencial, cuando intenta registrar un valor que no pertenece a la lista definida, entonces el sistema no lo acepta y conserva las condiciones anteriores del integrante.

### HU-08 — Consultar un hogar registrado

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero buscar un hogar por el documento de uno de sus integrantes y ver sus datos, para verificar si ya está censado y conocer su situación.

**CA-08.1** Dado que existe un hogar con un integrante de determinado tipo y número de documento, cuando el Funcionario busca ese documento, entonces el sistema muestra el hogar con sus datos, sus integrantes, sus condiciones de enfoque diferencial y su albergue asignado si lo tiene.

**CA-08.2** Dado que no existe ningún integrante con determinado documento, cuando el Funcionario lo busca, entonces el sistema muestra un mensaje indicando que no se encontró ningún hogar con ese documento.

**CA-08.3** Dado que el Funcionario está en la búsqueda, cuando solicita buscar sin ingresar el número de documento, entonces el sistema no ejecuta la búsqueda y solicita el dato.

### HU-09 — Actualizar datos de un hogar o integrante

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero modificar los datos de un hogar o de un integrante ya registrado, para corregir datos incompletos o ilegibles y mantener el censo confiable.

**CA-09.1** Dado que existe un hogar o integrante registrado, cuando el Funcionario modifica uno o varios datos con valores válidos y guarda, entonces el registro queda con los nuevos valores y el sistema muestra un mensaje de confirmación.

**CA-09.2** Dado que el Funcionario está modificando un registro, cuando deja vacío un dato obligatorio y solicita guardar, entonces el sistema no guarda el cambio y el registro conserva el valor anterior.

**CA-09.3** Dado que dos personas distintas están registradas, cuando el Funcionario intenta cambiar el documento de una por el documento de la otra, entonces el sistema no guarda el cambio y muestra un mensaje indicando que el documento ya pertenece a otra persona.

### Módulo de operación sin conexión

### HU-10 — Registrar hogares sin conexión

**Actor/Rol:** Funcionario de gestión del riesgo (personal operativo en campo)

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero registrar hogares e integrantes aunque no haya conexión a internet, para no interrumpir el censo en los puntos de atención con conectividad limitada.

**CA-10.1** Dado que el dispositivo del Funcionario no tiene conexión, cuando registra un hogar con sus datos obligatorios válidos, entonces el sistema lo guarda localmente en el dispositivo y lo marca como pendiente de sincronización (V-12).

**CA-10.2** Dado que el dispositivo no tiene conexión, cuando el Funcionario deja vacío un dato obligatorio y solicita guardar, entonces el sistema aplica la misma validación que en línea, no guarda el registro y señala el dato faltante.

**CA-10.3** Dado que existen registros guardados sin conexión, cuando el Funcionario consulta el estado del dispositivo, entonces el sistema muestra cuántos registros están pendientes de sincronización.

### HU-11 — Sincronizar registros pendientes

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero que los registros guardados sin conexión se envíen al sistema central cuando se recupere la conexión, para que el censo quede unificado y sin pérdida de información.

**CA-11.1** Dado que existen registros pendientes y el dispositivo recupera la conexión, cuando se ejecuta la sincronización, entonces los registros válidos quedan almacenados en el sistema central, cambian a estado sincronizado y dejan de contarse como pendientes.

**CA-11.2** Dado que un registro pendiente contiene un documento que ya existe en el sistema central, cuando se ejecuta la sincronización, entonces el sistema no crea un registro duplicado, marca el registro como en conflicto y se lo informa al Funcionario para su revisión (V-12).

**CA-11.3** Dado que la conexión se interrumpe durante la sincronización, cuando el proceso se detiene, entonces los registros no confirmados siguen pendientes y, al reintentar, no se pierden ni se duplican.

**CA-11.4** Dado que finalizó una sincronización, cuando el Funcionario revisa el resultado, entonces el sistema muestra cuántos registros se sincronizaron, cuántos quedaron en conflicto y cuántos siguen pendientes.

### Módulo de albergues

### HU-12 — Registrar albergue temporal

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero registrar y habilitar un albergue temporal con su capacidad máxima, para que pueda recibir hogares y se controle su ocupación.

**CA-12.1** Dado que el Funcionario ha iniciado sesión, cuando registra un albergue con sus datos obligatorios (V-05) y una capacidad máxima numérica mayor que cero, entonces el albergue queda habilitado con su capacidad registrada y con todos sus cupos disponibles.

**CA-12.2** Dado que el Funcionario está registrando un albergue, cuando ingresa una capacidad que no es numérica o es menor o igual a cero, entonces el sistema no registra el albergue y muestra un mensaje indicando que la capacidad debe ser un número mayor que cero.

**CA-12.3** Dado que el Funcionario está registrando un albergue, cuando deja vacío un dato obligatorio y solicita guardar, entonces el sistema no registra el albergue y señala el dato faltante.

### HU-13 — Asignar hogar a un albergue

**Actor/Rol:** Funcionario de gestión del riesgo (V-04)

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero asignar un hogar censado a un albergue con cupos disponibles, para alojarlo sin generar sobrecupo mientras otros albergues tienen capacidad.

**CA-13.1** Dado que existe un hogar censado de N integrantes sin albergue asignado y un albergue habilitado con al menos N cupos disponibles, cuando el Funcionario asigna el hogar a ese albergue, entonces el hogar queda asignado, la ocupación del albergue aumenta en N y sus cupos disponibles disminuyen en N.

**CA-13.2** Dado que un albergue tiene menos cupos disponibles que los N integrantes del hogar, cuando el Funcionario intenta asignar el hogar a ese albergue, entonces el sistema no realiza la asignación y muestra un mensaje con los cupos disponibles de ese albergue (V-08).

**CA-13.3** Dado que un hogar no está registrado en el censo, cuando el Funcionario intenta asignarlo a un albergue, entonces el sistema no realiza la asignación e indica que el hogar debe estar censado.

**CA-13.4** Dado que un hogar ya está asignado a un albergue, cuando el Funcionario intenta asignarlo a otro, entonces el sistema no realiza la asignación e informa en qué albergue se encuentra el hogar (V-08).

### HU-14 — Registrar salida de un hogar del albergue

**Actor/Rol:** Coordinador de albergue

**Historia de Usuario:** Como Coordinador de albergue, quiero registrar la salida de un hogar alojado, para mantener actualizada la ocupación y liberar los cupos que ocupaba.

**CA-14.1** Dado que un hogar de N integrantes está asignado al albergue del Coordinador, cuando registra su salida, entonces el hogar queda sin albergue asignado, la ocupación del albergue disminuye en N y sus cupos disponibles aumentan en N.

**CA-14.2** Dado que un hogar no está asignado al albergue del Coordinador, cuando intenta registrar su salida en ese albergue, entonces el sistema no registra la salida y muestra un mensaje indicando que el hogar no está alojado allí.

**CA-14.3** Dado que se registró la salida de un hogar, cuando el Funcionario intenta asignarlo nuevamente a un albergue con cupos suficientes, entonces el sistema permite la asignación.

### HU-15 — Consultar ocupación y cupos de albergues

**Actor/Rol:** Funcionario de gestión del riesgo / Coordinador de albergue

**Historia de Usuario:** Como Funcionario de gestión del riesgo o Coordinador de albergue, quiero consultar la capacidad, la ocupación y los cupos disponibles de cada albergue, para decidir hacia dónde dirigir a los hogares y detectar sobrecupo.

**CA-15.1** Dado que existen albergues habilitados, cuando el usuario consulta la ocupación, entonces el sistema muestra por cada albergue su capacidad, su ocupación actual y sus cupos disponibles.

**CA-15.2** Dado que se acaba de registrar una asignación o una salida de hogar, cuando el usuario consulta la ocupación, entonces los valores mostrados ya reflejan ese movimiento sin acciones adicionales.

**CA-15.3** Dado que un albergue tiene ocupación igual a su capacidad, cuando el usuario consulta la ocupación, entonces el sistema lo identifica como sin cupos disponibles.

**CA-15.4** Dado que no hay albergues registrados, cuando el usuario consulta la ocupación, entonces el sistema muestra un mensaje indicando que no existen albergues registrados.

### Módulo de inventario de donaciones

### HU-16 — Registrar donación recibida

**Actor/Rol:** Funcionario de gestión del riesgo (V-01)

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero registrar cada donación que se recibe con su tipo de ayuda, cantidad y origen, para que ingrese al inventario con su procedencia identificada.

**CA-16.1** Dado que el Funcionario ha iniciado sesión, cuando registra una donación con tipo de ayuda, cantidad mayor que cero y origen, entonces la donación queda registrada con su fecha de recepción y las existencias de ese tipo de ayuda aumentan en la cantidad recibida.

**CA-16.2** Dado que el Funcionario está registrando una donación, cuando ingresa una cantidad igual a cero, negativa o no numérica, entonces el sistema no registra la donación y muestra un mensaje indicando que la cantidad debe ser un número mayor que cero.

**CA-16.3** Dado que el Funcionario está registrando una donación, cuando deja vacío el tipo de ayuda o el origen y solicita guardar, entonces el sistema no registra la donación y señala el dato faltante.

**CA-16.4** Dado que ya existen existencias de un tipo de ayuda, cuando el Funcionario registra una nueva donación de ese mismo tipo, entonces el sistema suma la cantidad a las existencias de ese tipo sin crear un tipo de ayuda duplicado (V-09).

### HU-17 — Consultar existencias del inventario

**Actor/Rol:** Funcionario de gestión del riesgo / Coordinador de albergue

**Historia de Usuario:** Como Funcionario de gestión del riesgo o Coordinador de albergue, quiero consultar las existencias disponibles por tipo de ayuda, para saber qué hay y cuánto queda después de cada entrega.

**CA-17.1** Dado que existen donaciones y entregas registradas, cuando el usuario consulta el inventario, entonces el sistema muestra por cada tipo de ayuda sus existencias actuales, equivalentes a lo recibido menos lo entregado.

**CA-17.2** Dado que se acaba de registrar una donación o una entrega, cuando el usuario consulta el inventario, entonces las existencias mostradas ya reflejan ese movimiento sin acciones adicionales.

**CA-17.3** Dado que un tipo de ayuda tiene existencias iguales a cero, cuando el usuario consulta el inventario, entonces el sistema lo muestra con cero existencias y como agotado.

**CA-17.4** Dado que no hay donaciones registradas, cuando el usuario consulta el inventario, entonces el sistema muestra un mensaje indicando que el inventario está vacío.

### Módulo de entrega de ayudas

### HU-18 — Verificar identidad del beneficiario

**Actor/Rol:** Funcionario de gestión del riesgo (responsable de la entrega; V-03)

**Historia de Usuario:** Como responsable de la entrega, quiero verificar que quien recibe la ayuda es un integrante de un hogar censado, para evitar la suplantación y las entregas a personas no registradas.

**CA-18.1** Dado que existe un integrante censado con determinado tipo y número de documento, cuando el responsable ingresa ese documento al iniciar una entrega, entonces el sistema identifica a la persona y a su hogar y habilita el registro de la entrega.

**CA-18.2** Dado que un documento no corresponde a ningún integrante censado, cuando el responsable lo ingresa al iniciar una entrega, entonces el sistema no habilita la entrega y muestra un mensaje indicando que la persona no figura en el censo.

**CA-18.3** Dado que el responsable inicia una entrega, cuando solicita continuar sin ingresar el documento, entonces el sistema no habilita la entrega y solicita el dato.

### HU-19 — Registrar entrega de ayuda a un hogar

**Actor/Rol:** Funcionario de gestión del riesgo (responsable de la entrega; V-03)

**Historia de Usuario:** Como responsable de la entrega, quiero registrar la ayuda entregada a un hogar con su tipo y cantidad, para dejar constancia de quién recibió qué, cuándo y de manos de quién.

**CA-19.1** Dado que el beneficiario fue verificado y hay existencias suficientes, cuando el responsable registra la entrega de un tipo de ayuda con su cantidad, entonces la entrega queda registrada con el hogar, el beneficiario, el tipo de ayuda, la cantidad, la fecha y hora y el usuario que la realizó.

**CA-19.2** Dado que el responsable está registrando una entrega, cuando ingresa una cantidad igual a cero, negativa o no numérica, entonces el sistema no registra la entrega y muestra un mensaje indicando que la cantidad debe ser un número mayor que cero.

**CA-19.3** Dado que el responsable está registrando una entrega, cuando no selecciona ningún tipo de ayuda y solicita guardar, entonces el sistema no registra la entrega y señala el dato faltante.

**CA-19.4** Dado que el beneficiario no ha sido verificado, cuando el responsable intenta registrar la entrega, entonces el sistema no la registra e indica que primero debe verificarse la identidad.

### HU-20 — Descontar automáticamente del inventario cada entrega

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero que cada entrega registrada descuente automáticamente la cantidad entregada del inventario, para conocer las existencias reales sin conteos manuales.

**CA-20.1** Dado que un tipo de ayuda tiene E unidades en existencia, cuando se registra una entrega de c unidades con c menor o igual a E, entonces las existencias de ese tipo pasan a E menos c.

**CA-20.2** Dado que un tipo de ayuda tiene E unidades en existencia, cuando se intenta registrar una entrega de c unidades con c mayor que E, entonces el sistema no registra la entrega, las existencias no cambian y se muestra un mensaje con las existencias disponibles.

**CA-20.3** Dado que una entrega deja las existencias de un tipo de ayuda en cero, cuando se intenta registrar otra entrega de ese tipo, entonces el sistema no la registra e informa que el tipo de ayuda está agotado.

### HU-21 — Registrar firma digital del beneficiario

**Actor/Rol:** Funcionario de gestión del riesgo (responsable de la entrega; V-03)

**Historia de Usuario:** Como responsable de la entrega, quiero capturar la firma digital del beneficiario al entregar la ayuda, para dejar constancia verificable de que la recibió.

**CA-21.1** Dado que el responsable está registrando una entrega, cuando el beneficiario firma en el dispositivo y el responsable confirma, entonces la firma queda asociada a esa entrega y se muestra al consultar la entrega.

**CA-21.2** Dado que la firma se exige para completar la entrega (V-10), cuando el responsable intenta confirmar la entrega sin firma, entonces el sistema no completa la entrega y solicita la firma del beneficiario.

### HU-22 — Consultar historial de entregas de un hogar

**Actor/Rol:** Funcionario de gestión del riesgo / Coordinador de albergue

**Historia de Usuario:** Como Funcionario de gestión del riesgo o Coordinador de albergue, quiero consultar todas las ayudas entregadas a un hogar, para verificar qué ha recibido y detectar posibles entregas repetidas.

**CA-22.1** Dado que un hogar tiene entregas registradas, cuando el usuario consulta su historial, entonces el sistema muestra en orden cronológico cada entrega con su fecha y hora, tipo de ayuda, cantidad, beneficiario que recibió y responsable que entregó.

**CA-22.2** Dado que un hogar no tiene entregas registradas, cuando el usuario consulta su historial, entonces el sistema muestra un mensaje indicando que el hogar no ha recibido ayudas.

**CA-22.3** Dado que el usuario busca el historial de un documento que no pertenece a ningún hogar censado, cuando solicita la consulta, entonces el sistema muestra un mensaje indicando que no se encontró ningún hogar con ese documento.

### HU-23 — Consultar trazabilidad de un tipo de ayuda

**Actor/Rol:** Funcionario de gestión del riesgo

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero consultar el recorrido completo de un tipo de ayuda, desde su origen hasta los hogares que la recibieron, para justificar documentalmente el destino de los bienes humanitarios.

**CA-23.1** Dado que un tipo de ayuda tiene donaciones y entregas registradas, cuando el Funcionario consulta su trazabilidad, entonces el sistema muestra las donaciones recibidas (origen, fecha y cantidad), las entregas realizadas (fecha, hogar, beneficiario, responsable y cantidad) y las existencias restantes (V-09).

**CA-23.2** Dado que un tipo de ayuda tiene donaciones pero ninguna entrega, cuando el Funcionario consulta su trazabilidad, entonces el sistema muestra las donaciones y las existencias, e indica que no hay entregas registradas.

**CA-23.3** Dado que el Funcionario busca un tipo de ayuda que no existe en el inventario, cuando solicita la consulta, entonces el sistema muestra un mensaje indicando que no hay registros de ese tipo de ayuda.

### Módulo de voluntarios

### HU-24 — Registrar voluntario

**Actor/Rol:** Funcionario de gestión del riesgo (V-13)

**Historia de Usuario:** Como Funcionario de gestión del riesgo, quiero registrar los datos de un voluntario, para contar con el personal voluntario identificado durante la emergencia.

**CA-24.1** Dado que el Funcionario ha iniciado sesión, cuando registra un voluntario con todos sus datos obligatorios (V-05), entonces el voluntario queda registrado y activo y el sistema muestra un mensaje de confirmación.

**CA-24.2** Dado que el Funcionario está registrando un voluntario, cuando deja vacío un dato obligatorio y solicita guardar, entonces el sistema no registra al voluntario y señala el dato faltante.

**CA-24.3** Dado que un voluntario fue registrado correctamente, cuando el Funcionario consulta el listado de voluntarios, entonces el voluntario aparece en el listado con sus datos.
