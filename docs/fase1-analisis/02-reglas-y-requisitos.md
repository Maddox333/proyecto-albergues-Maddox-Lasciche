> Versión 0.2 (entrega parcial de octubre de 2026). Se corrige en las semanas 13 y 14; ver BITACORA.md.

# 4. Requisitos Funcionales

**RF-01 — Autenticar usuario**

> **Descripción:** El sistema debe autenticar al usuario registrado y activo con sus credenciales, rechazando credenciales incorrectas o incompletas e indicando el motivo.
>
> **Origen:** HU-01 / CA-01.1, CA-01.2, CA-01.3
>
> **Prioridad:** Alta

**RF-02 — Exigir sesión iniciada**

> **Descripción:** El sistema debe redirigir al inicio de sesión, sin mostrar información, a toda persona que intente abrir una función sin sesión iniciada.
>
> **Origen:** HU-01 / CA-01.4
>
> **Prioridad:** Alta

**RF-03 — Registrar usuario y asignar rol**

> **Descripción:** El sistema debe registrar un usuario con sus datos obligatorios y un rol entre los contemplados, dejándolo activo y habilitado para iniciar sesión.
>
> **Origen:** HU-02 / CA-02.1, CA-02.3
>
> **Prioridad:** Alta

**RF-04 — Verificar unicidad del identificador de acceso**

> **Descripción:** El sistema debe verificar, antes de registrar un usuario, que no exista otro con el mismo identificador de acceso, e informar si ya existe.
>
> **Origen:** HU-02 / CA-02.2
>
> **Prioridad:** Alta

**RF-05 — Mostrar solo las funciones del rol**

> **Descripción:** El sistema debe mostrar en el menú del usuario únicamente las funciones autorizadas para su rol.
>
> **Origen:** HU-03 / CA-03.1
>
> **Prioridad:** Alta

**RF-06 — Denegar funciones no autorizadas**

> **Descripción:** El sistema debe denegar, con mensaje de acceso no autorizado, la ejecución de cualquier función para la que el rol del usuario no tenga permiso (incluido el registro de usuarios por quien no es Administrador).
>
> **Origen:** HU-03 / CA-03.2, CA-03.3; HU-02 / CA-02.4
>
> **Prioridad:** Alta

**RF-07 — Registrar hogar afectado**

> **Descripción:** El sistema debe registrar un hogar con sus datos obligatorios, asignarle un identificador único generado por el sistema y confirmar el registro; si falta un dato obligatorio, no lo registra y señala el dato faltante.
>
> **Origen:** HU-04 / CA-04.1, CA-04.2
>
> **Prioridad:** Alta

**RF-08 — Registrar integrante del hogar**

> **Descripción:** El sistema debe registrar un integrante en un hogar existente con tipo y número de documento válidos y demás datos obligatorios, y actualizar el total de integrantes del hogar; si falta un dato o el formato del documento es inválido, no lo registra e indica el motivo y el formato esperado.
>
> **Origen:** HU-05 / CA-05.1, CA-05.2, CA-05.3
>
> **Prioridad:** Alta

**RF-09 — Verificar documento no duplicado**

> **Descripción:** El sistema debe verificar, al registrar un integrante o cambiar el documento de una persona, que el tipo y número de documento no pertenezcan a otra persona ya censada, alertando en qué hogar está registrado y sin crear ni modificar registros.
>
> **Origen:** HU-06 / CA-06.1, CA-06.2, CA-06.3; HU-09 / CA-09.3
>
> **Prioridad:** Alta

**RF-10 — Registrar enfoque diferencial**

> **Descripción:** El sistema debe permitir asignar a un integrante una o más condiciones de enfoque diferencial de la lista definida (niño, adulto mayor, persona con discapacidad, gestante, minoría étnica), o ninguna, y rechazar valores fuera de la lista conservando las condiciones anteriores.
>
> **Origen:** HU-07 / CA-07.1, CA-07.2, CA-07.3
>
> **Prioridad:** Media

**RF-11 — Consultar hogar por documento**

> **Descripción:** El sistema debe buscar un hogar por el documento de uno de sus integrantes y mostrar sus datos, integrantes, enfoque diferencial y albergue asignado; si el documento no existe, informa que no se encontró; si no se ingresa, lo solicita.
>
> **Origen:** HU-08 / CA-08.1, CA-08.2, CA-08.3; HU-04 / CA-04.3
>
> **Prioridad:** Alta

**RF-12 — Actualizar datos de hogar o integrante**

> **Descripción:** El sistema debe actualizar los datos de un hogar o integrante con valores válidos y confirmar el cambio; si queda vacío un dato obligatorio, no guarda y conserva el valor anterior.
>
> **Origen:** HU-09 / CA-09.1, CA-09.2
>
> **Prioridad:** Media

**RF-13 — Registrar hogares sin conexión**

> **Descripción:** El sistema debe guardar localmente en el dispositivo, sin conexión, los hogares e integrantes con datos obligatorios válidos, marcándolos como pendientes de sincronización y aplicando las mismas validaciones que en línea.
>
> **Origen:** HU-10 / CA-10.1, CA-10.2
>
> **Prioridad:** Alta

**RF-14 — Informar estado de sincronización**

> **Descripción:** El sistema debe mostrar cuántos registros están pendientes de sincronización y, al finalizar una sincronización, cuántos se sincronizaron, cuántos quedaron en conflicto y cuántos siguen pendientes.
>
> **Origen:** HU-10 / CA-10.3; HU-11 / CA-11.4
>
> **Prioridad:** Media

**RF-15 — Sincronizar registros pendientes**

> **Descripción:** El sistema debe enviar al sistema central los registros pendientes válidos cuando se recupere la conexión, cambiándolos a estado sincronizado; si la conexión se interrumpe, los no confirmados siguen pendientes y, al reintentar, no se pierden ni se duplican.
>
> **Origen:** HU-11 / CA-11.1, CA-11.3
>
> **Prioridad:** Alta

**RF-16 — Detectar conflictos de sincronización**

> **Descripción:** El sistema debe detectar, durante la sincronización, los registros cuyo documento ya existe en el sistema central, no crear duplicado, marcarlos como en conflicto e informarlo al Funcionario para su revisión.
>
> **Origen:** HU-11 / CA-11.2
>
> **Prioridad:** Alta

**RF-17 — Registrar albergue temporal**

> **Descripción:** El sistema debe registrar y habilitar un albergue con sus datos obligatorios y una capacidad máxima numérica mayor que cero, dejándolo con todos sus cupos disponibles; si falta un dato o la capacidad es inválida, no lo registra e indica el motivo.
>
> **Origen:** HU-12 / CA-12.1, CA-12.2, CA-12.3
>
> **Prioridad:** Alta

**RF-18 — Asignar hogar a albergue**

> **Descripción:** El sistema debe asignar un hogar censado, sin albergue, a un albergue habilitado, aumentando la ocupación y disminuyendo los cupos en el número de integrantes del hogar; debe rechazar la asignación si el hogar no está censado o ya tiene albergue (informando cuál).
>
> **Origen:** HU-13 / CA-13.1, CA-13.3, CA-13.4; HU-14 / CA-14.3
>
> **Prioridad:** Alta

**RF-19 — Verificar cupos suficientes**

> **Descripción:** El sistema debe verificar, antes de asignar un hogar, que el albergue tenga cupos disponibles iguales o mayores al número de integrantes, y de lo contrario rechazar la asignación mostrando los cupos disponibles.
>
> **Origen:** HU-13 / CA-13.2
>
> **Prioridad:** Alta

**RF-20 — Registrar salida de hogar del albergue**

> **Descripción:** El sistema debe registrar la salida de un hogar alojado en el albergue del Coordinador, dejándolo sin albergue y liberando los cupos que ocupaba; si el hogar no está alojado allí, rechaza la salida e informa el motivo.
>
> **Origen:** HU-14 / CA-14.1, CA-14.2
>
> **Prioridad:** Alta

**RF-21 — Consultar ocupación y cupos**

> **Descripción:** El sistema debe mostrar por cada albergue su capacidad, ocupación actual y cupos disponibles, reflejando de inmediato asignaciones y salidas, identificando los albergues sin cupos e informando cuando no hay albergues registrados.
>
> **Origen:** HU-15 / CA-15.1, CA-15.2, CA-15.3, CA-15.4
>
> **Prioridad:** Alta

**RF-22 — Registrar donación recibida**

> **Descripción:** El sistema debe registrar una donación con tipo de ayuda, cantidad mayor que cero y origen, con su fecha de recepción, aumentando las existencias de ese tipo; si la cantidad es inválida o falta tipo u origen, no la registra e indica el motivo.
>
> **Origen:** HU-16 / CA-16.1, CA-16.2, CA-16.3
>
> **Prioridad:** Alta

**RF-23 — Consolidar existencias por tipo de ayuda**

> **Descripción:** El sistema debe sumar cada nueva donación a las existencias del mismo tipo de ayuda, sin crear un tipo duplicado.
>
> **Origen:** HU-16 / CA-16.4
>
> **Prioridad:** Alta

**RF-24 — Consultar existencias del inventario**

> **Descripción:** El sistema debe mostrar por tipo de ayuda las existencias actuales (recibido menos entregado), reflejando de inmediato cada donación o entrega, marcando como agotados los tipos con cero existencias e informando cuando el inventario está vacío.
>
> **Origen:** HU-17 / CA-17.1, CA-17.2, CA-17.3, CA-17.4
>
> **Prioridad:** Alta

**RF-25 — Verificar identidad del beneficiario**

> **Descripción:** El sistema debe verificar que el documento ingresado al iniciar una entrega corresponda a un integrante censado, identificando a la persona y su hogar y habilitando la entrega; si no figura en el censo o no se ingresa el documento, no la habilita.
>
> **Origen:** HU-18 / CA-18.1, CA-18.2, CA-18.3; HU-19 / CA-19.4
>
> **Prioridad:** Alta

**RF-26 — Registrar entrega de ayuda**

> **Descripción:** El sistema debe registrar la entrega de un tipo de ayuda y cantidad mayor que cero a un beneficiario verificado, guardando hogar, beneficiario, tipo, cantidad, fecha y hora y usuario responsable; si la cantidad es inválida o falta el tipo de ayuda, no la registra.
>
> **Origen:** HU-19 / CA-19.1, CA-19.2, CA-19.3
>
> **Prioridad:** Alta

**RF-27 — Descontar existencias por entrega**

> **Descripción:** El sistema debe descontar automáticamente del inventario la cantidad de cada entrega registrada.
>
> **Origen:** HU-20 / CA-20.1
>
> **Prioridad:** Alta

**RF-28 — Verificar existencias suficientes**

> **Descripción:** El sistema debe rechazar la entrega, sin modificar existencias y mostrando las disponibles, cuando la cantidad supere las existencias, e informar que el tipo de ayuda está agotado cuando no queden.
>
> **Origen:** HU-20 / CA-20.2, CA-20.3
>
> **Prioridad:** Alta

**RF-29 — Capturar firma digital del beneficiario**

> **Descripción:** El sistema debe capturar la firma digital del beneficiario en el dispositivo, asociarla a la entrega y mostrarla al consultar la entrega.
>
> **Origen:** HU-21 / CA-21.1
>
> **Prioridad:** Alta

**RF-30 — Exigir firma para completar la entrega (CONDICIONADO A V-10)**

> **Descripción:** El sistema debe impedir completar la entrega sin la firma del beneficiario y solicitarla, si se confirma que la firma es obligatoria.
>
> **Origen:** HU-21 / CA-21.2
>
> **Prioridad:** Alta

**RF-31 — Consultar historial de entregas de un hogar**

> **Descripción:** El sistema debe mostrar en orden cronológico las entregas de un hogar (fecha y hora, tipo, cantidad, beneficiario y responsable), e informar cuando el hogar no tiene entregas o el documento no corresponde a un hogar censado.
>
> **Origen:** HU-22 / CA-22.1, CA-22.2, CA-22.3
>
> **Prioridad:** Alta

**RF-32 — Consultar trazabilidad de un tipo de ayuda**

> **Descripción:** El sistema debe mostrar, por tipo de ayuda, las donaciones (origen, fecha, cantidad), las entregas (fecha, hogar, beneficiario, responsable, cantidad) y las existencias restantes, informando cuando no hay entregas o no hay registros del tipo.
>
> **Origen:** HU-23 / CA-23.1, CA-23.2, CA-23.3
>
> **Prioridad:** Alta

**RF-33 — Registrar voluntario**

> **Descripción:** El sistema debe registrar un voluntario con sus datos obligatorios, dejándolo activo y confirmando el registro; si falta un dato obligatorio, no lo registra y señala el dato faltante.
>
> **Origen:** HU-24 / CA-24.1, CA-24.2
>
> **Prioridad:** Media

**RF-34 — Listar voluntarios**

> **Descripción:** El sistema debe mostrar el listado de voluntarios registrados con sus datos.
>
> **Origen:** HU-24 / CA-24.3
>
> **Prioridad:** Media


# 5. Reglas de Negocio

**RN-01 — Acceso solo para usuarios registrados, activos y autenticados**

> **Regla:** Solo un usuario registrado y activo con sesión iniciada puede acceder a las funciones del sistema.
>
> **Origen:** HU-01 / CA-01.1, CA-01.2, CA-01.4

**RN-02 — Identificador de acceso único**

> **Regla:** No pueden existir dos usuarios con el mismo identificador de acceso.
>
> **Origen:** HU-02 / CA-02.2

**RN-03 — Rol obligatorio entre los contemplados**

> **Regla:** Todo usuario tiene un rol entre los siete del alcance: Funcionario de gestión del riesgo, Coordinador de albergue, Donante, Voluntario, Organismo de socorro, Familia afectada y Administrador del sistema.
>
> **Origen:** HU-02 / CA-02.1, CA-02.3; Fase 0 (Alcance, roles)

**RN-04 — Registro de usuarios exclusivo del Administrador**

> **Regla:** Solo el Administrador del sistema puede registrar usuarios.
>
> **Origen:** HU-02 / CA-02.4; HU-03 / CA-03.3

**RN-05 — Acceso limitado a las funciones del rol**

> **Regla:** Cada rol solo puede ver y ejecutar las funciones autorizadas para él (matriz pendiente: V-02).
>
> **Origen:** HU-03 / CA-03.1, CA-03.2; Fase 0 (objetivo general: control de acceso por roles)

**RN-06 — Datos obligatorios completos**

> **Regla:** No se registra ni se modifica un hogar, integrante, albergue o voluntario si falta un dato obligatorio (cuáles son: V-05).
>
> **Origen:** HU-04 / CA-04.2; HU-05 / CA-05.2; HU-09 / CA-09.2; HU-10 / CA-10.2; HU-12 / CA-12.3; HU-24 / CA-24.2

**RN-07 — Documento único en el censo**

> **Regla:** Un mismo tipo y número de documento no puede pertenecer a más de una persona en el censo; una persona es integrante de un solo hogar.
>
> **Origen:** HU-06 / CA-06.1, CA-06.2; HU-09 / CA-09.3; HU-11 / CA-11.2; Fase 0 (control automático de duplicados, unicidad del registro familiar)

**RN-08 — Formato del documento según su tipo**

> **Regla:** El número de documento debe respetar el formato de su tipo de documento (formatos exactos: V-06).
>
> **Origen:** HU-05 / CA-05.3

**RN-09 — Todo integrante pertenece a un hogar registrado**

> **Regla:** Un integrante solo se registra dentro de un hogar ya registrado en el censo.
>
> **Origen:** HU-05 / CA-05.1; Fase 0 (Hogar como unidad básica de registro)

**RN-10 — Enfoque diferencial restringido a la lista definida**

> **Regla:** Las condiciones de enfoque diferencial solo pueden ser niño, adulto mayor, persona con discapacidad, gestante o minoría étnica; un integrante puede tener varias o ninguna.
>
> **Origen:** HU-07 / CA-07.1, CA-07.2, CA-07.3; Fase 0 (Enfoque Diferencial)

**RN-11 — Capacidad máxima mayor que cero**

> **Regla:** La capacidad máxima de un albergue es un número mayor que cero.
>
> **Origen:** HU-12 / CA-12.1, CA-12.2

**RN-12 — Hogar censado para ser alojado**

> **Regla:** Solo un hogar registrado en el censo puede ser asignado a un albergue.
>
> **Origen:** HU-13 / CA-13.3

**RN-13 — Un hogar, un solo albergue a la vez**

> **Regla:** Un hogar no puede estar asignado a más de un albergue simultáneamente; tras su salida, puede ser asignado de nuevo.
>
> **Origen:** HU-13 / CA-13.4; HU-14 / CA-14.3

**RN-14 — Cada hogar ocupa tantos cupos como integrantes tiene**

> **Regla:** La ocupación de un albergue es la suma de integrantes de los hogares alojados, y los cupos disponibles son la capacidad menos la ocupación.
>
> **Origen:** HU-13 / CA-13.1; HU-14 / CA-14.1; HU-15 / CA-15.1, CA-15.3

**RN-15 — Prohibido el sobrecupo**

> **Regla:** No se asigna un hogar a un albergue cuyos cupos disponibles sean menores que el número de integrantes del hogar.
>
> **Origen:** HU-13 / CA-13.2; Fase 0 (efecto: albergues con sobrecupo)

**RN-16 — Salida solo desde el albergue donde está alojado**

> **Regla:** La salida de un hogar solo se registra en el albergue al que está asignado.
>
> **Origen:** HU-14 / CA-14.2

**RN-17 — Cantidades positivas**

> **Regla:** La cantidad de una donación o de una entrega debe ser un número mayor que cero.
>
> **Origen:** HU-16 / CA-16.2; HU-19 / CA-19.2

**RN-18 — Toda donación registra su procedencia**

> **Regla:** Toda donación se registra con tipo de ayuda, cantidad y origen.
>
> **Origen:** HU-16 / CA-16.1, CA-16.3; Fase 0 (Trazabilidad: origen del recurso)

**RN-19 — Un solo registro de existencias por tipo de ayuda**

> **Regla:** No pueden existir tipos de ayuda duplicados en el inventario (catálogo de tipos: V-09).
>
> **Origen:** HU-16 / CA-16.4

**RN-20 — Existencias = recibido menos entregado**

> **Regla:** Las existencias de un tipo de ayuda son lo recibido menos lo entregado.
>
> **Origen:** HU-17 / CA-17.1; HU-20 / CA-20.1; Fase 0 (control de inventario con deducción automática)

**RN-21 — Prohibido entregar más de lo disponible**

> **Regla:** No se registra una entrega cuya cantidad supere las existencias del tipo de ayuda, ni de un tipo agotado.
>
> **Origen:** HU-20 / CA-20.2, CA-20.3

**RN-22 — Entrega solo a beneficiario verificado y censado**

> **Regla:** Solo se registra una entrega a una persona cuyo documento corresponda a un integrante censado y haya sido verificado antes.
>
> **Origen:** HU-18 / CA-18.1, CA-18.2; HU-19 / CA-19.4; Fase 0 (verificación de identidad contra suplantación)

**RN-23 — Toda entrega es trazable**

> **Regla:** Toda entrega registra hogar, beneficiario, tipo de ayuda, cantidad, fecha y hora y usuario responsable.
>
> **Origen:** HU-19 / CA-19.1, CA-19.3; HU-22 / CA-22.1; HU-23 / CA-23.1; Fase 0 (Trazabilidad: origen, movimiento, responsable y beneficiario)

**RN-24 — Firma del beneficiario para completar la entrega (CONDICIONAL, V-10)**

> **Regla:** Si se confirma que la firma es obligatoria, no se completa una entrega sin la firma digital del beneficiario.
>
> **Origen:** HU-21 / CA-21.2; Fase 0 (firma digital de entrega)

**RN-25 — Validaciones idénticas sin conexión**

> **Regla:** Los registros hechos sin conexión cumplen las mismas validaciones de datos obligatorios que en línea.
>
> **Origen:** HU-10 / CA-10.2

**RN-26 — Sincronización sin pérdida ni duplicación**

> **Regla:** Ninguna sincronización pierde ni duplica registros; un registro cuyo documento ya existe en el sistema central queda en conflicto para revisión (resolución: V-12).
>
> **Origen:** HU-11 / CA-11.2, CA-11.3
