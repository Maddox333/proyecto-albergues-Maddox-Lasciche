> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 2.1 Historias de usuario

### 2.1.1 Actores y permisos

Las historias usan tres roles concretos, que son los valores de la enumeración Rol y los actores de los casos de uso: Funcionario de gestión del riesgo, Coordinador de albergue y Administrador del sistema. No se usan roles genéricos como «usuario». Cuando una función sirve a más de un rol, la historia se redacta con el rol que más la usa y la Tabla 24 indica qué otros roles la tienen autorizada; esa matriz es la que vigila la RN-05.

**Tabla 24**  
*Matriz de permisos por rol*

| **Función**                                                                                                              | **Funcionario** | **Coordinador** | **Administrador** |
|--------------------------------------------------------------------------------------------------------------------------|-----------------|-----------------|-------------------|
| Iniciar sesión (HU-01)                                                                                                   | Sí              | Sí              | Sí                |
| Gestionar usuarios: registrar, consultar, actualizar, inactivar (HU-02, HU-25 a HU-27)                                   | —               | —               | Sí                |
| Censo: registrar, actualizar e inactivar hogares e integrantes; enfoque diferencial (HU-04 a HU-07, HU-09, HU-28, HU-29) | Sí              | —               | —                 |
| Consultar un hogar por documento (HU-08)                                                                                 | Sí              | Sí              | —                 |
| Registrar sin conexión y sincronizar (HU-10, HU-11)                                                                      | Sí              | —               | —                 |
| Albergues: registrar, actualizar, inactivar y asignar hogares (HU-12, HU-13, HU-30, HU-31)                               | Sí              | —               | —                 |
| Registrar la salida de un hogar de su albergue (HU-14)                                                                   | —               | Sí              | —                 |
| Consultar ocupación y cupos (HU-15)                                                                                      | Sí              | Sí              | —                 |
| Inventario: tipos de ayuda y donaciones (HU-16, HU-32 a HU-34)                                                           | Sí              | —               | —                 |
| Consultar existencias (HU-17)                                                                                            | Sí              | Sí              | —                 |
| Entregas: verificar identidad, registrar entrega y firma (HU-18 a HU-21)                                                 | Sí              | —               | —                 |
| Consultar historial de entregas de un hogar (HU-22)                                                                      | Sí              | Sí              | —                 |
| Consultar trazabilidad de un tipo de ayuda (HU-23)                                                                       | Sí              | —               | —                 |
| Voluntarios: registrar, consultar, actualizar, inactivar (HU-24, HU-35 a HU-37)                                          | Sí              | —               | —                 |

*Nota.* El Coordinador consulta únicamente lo que necesita para operar su albergue. Elaboración propia.

### 2.1.2 Lista de historias y cobertura del modelo

La Tabla 25 lista las 37 historias con su entidad, su operación, el rol que obtiene el valor y los métodos que la implementan. Las historias HU-01 a HU-24 vienen de la entrega anterior; las historias HU-25 a HU-37 se agregaron al construir el modelo, para completar las operaciones de consulta, actualización e inactivación de cada entidad.

**Tabla 25**  
*Historias de usuario con su entidad, operación, rol y métodos*

| **HU** | **Título corto**                            | **Entidad**         | **CRUD** | **Rol**       | **Métodos que la implementan**                                                                                           | **Prioridad** |
|--------|---------------------------------------------|---------------------|----------|---------------|--------------------------------------------------------------------------------------------------------------------------|---------------|
| HU-01  | Iniciar sesión                              | USUARIO             | Acceso   | Funcionario   | Usuario.autenticar(), Usuario.tienePermiso()                                                                             | Alta          |
| HU-02  | Registrar usuario y asignar rol             | USUARIO             | C        | Administrador | Usuario.crear(), Usuario.existeNombreUsuario(), Usuario.tienePermiso()                                                   | Alta          |
| HU-03  | Usar solo las funciones del rol             | USUARIO             | Acceso   | Administrador | Usuario.tienePermiso()                                                                                                   | Alta          |
| HU-04  | Registrar hogar afectado                    | HOGAR               | C        | Funcionario   | Hogar.crear(), Hogar.buscarPorDocumento()                                                                                | Alta          |
| HU-05  | Registrar integrantes del hogar             | INTEGRANTE          | C        | Funcionario   | Integrante.crear(), Hogar.totalIntegrantes()                                                                             | Alta          |
| HU-06  | Evitar el registro duplicado de personas    | INTEGRANTE          | Apoyo    | Funcionario   | Integrante.existeDocumento()                                                                                             | Alta          |
| HU-07  | Registrar enfoque diferencial               | INTEGRANTE          | U        | Funcionario   | Integrante.asignarCondiciones()                                                                                          | Alta          |
| HU-08  | Consultar un hogar registrado               | HOGAR               | R        | Funcionario   | Hogar.buscarPorDocumento(), AsignacionAlbergue.albergueActual()                                                          | Alta          |
| HU-09  | Actualizar datos de un hogar o integrante   | HOGAR, INTEGRANTE   | U        | Funcionario   | Hogar.actualizar(), Integrante.actualizar(), Integrante.existeDocumento()                                                | Media         |
| HU-10  | Registrar hogares sin conexión              | HOGAR, INTEGRANTE   | C        | Funcionario   | Hogar.guardarLocal(), Hogar.contarPorEstado()                                                                            | Alta          |
| HU-11  | Sincronizar registros pendientes            | HOGAR, INTEGRANTE   | U        | Funcionario   | Hogar.sincronizarPendientes(), Integrante.existeDocumento(), Hogar.contarPorEstado()                                     | Alta          |
| HU-12  | Registrar albergue temporal                 | ALBERGUE            | C        | Funcionario   | Albergue.crear()                                                                                                         | Alta          |
| HU-13  | Asignar hogar a un albergue                 | ASIGNACION_ALBERGUE | C        | Funcionario   | AsignacionAlbergue.asignar(), Hogar.totalIntegrantes(), Albergue.cuposDisponibles(), AsignacionAlbergue.albergueActual() | Alta          |
| HU-14  | Registrar salida de un hogar del albergue   | ASIGNACION_ALBERGUE | U        | Coordinador   | AsignacionAlbergue.registrarSalida(), AsignacionAlbergue.asignar()                                                       | Alta          |
| HU-15  | Consultar ocupación y cupos de albergues    | ALBERGUE            | R        | Funcionario   | Albergue.listarActivos(), Albergue.ocupacionActual(), Albergue.cuposDisponibles()                                        | Alta          |
| HU-16  | Registrar donación recibida                 | DONACION            | C        | Funcionario   | Donacion.registrar(), TipoAyuda.existencias(), TipoAyuda.existeNombre()                                                  | Alta          |
| HU-17  | Consultar existencias del inventario        | TIPO_AYUDA          | R        | Funcionario   | TipoAyuda.listarActivos(), TipoAyuda.existencias()                                                                       | Alta          |
| HU-18  | Verificar identidad del beneficiario        | INTEGRANTE          | R        | Funcionario   | Integrante.buscarPorDocumento()                                                                                          | Alta          |
| HU-19  | Registrar entrega de ayuda a un hogar       | ENTREGA             | C        | Funcionario   | Entrega.registrar(), Integrante.buscarPorDocumento()                                                                     | Alta          |
| HU-20  | Descontar del inventario cada entrega       | TIPO_AYUDA          | Apoyo    | Funcionario   | Entrega.registrar(), TipoAyuda.existencias(), TipoAyuda.hayExistencias()                                                 | Alta          |
| HU-21  | Registrar firma digital del beneficiario    | ENTREGA             | Apoyo    | Funcionario   | Entrega.capturarFirma()                                                                                                  | Alta          |
| HU-22  | Consultar historial de entregas de un hogar | ENTREGA             | R        | Funcionario   | Entrega.listarPorHogar(), Hogar.buscarPorDocumento()                                                                     | Alta          |
| HU-23  | Consultar trazabilidad de un tipo de ayuda  | DONACION, ENTREGA   | R        | Funcionario   | Donacion.listarPorTipo(), Entrega.listarPorTipo(), TipoAyuda.existencias()                                               | Alta          |
| HU-24  | Registrar voluntario                        | VOLUNTARIO          | C        | Funcionario   | Voluntario.crear()                                                                                                       | Media         |
| HU-25  | Consultar usuarios                          | USUARIO             | R        | Administrador | Usuario.listarActivos(), Usuario.tienePermiso()                                                                          | Media         |
| HU-26  | Actualizar usuario                          | USUARIO             | U        | Administrador | Usuario.actualizar(), Usuario.existeNombreUsuario()                                                                      | Media         |
| HU-27  | Inactivar usuario                           | USUARIO             | D lógico | Administrador | Usuario.inactivar()                                                                                                      | Media         |
| HU-28  | Inactivar integrante del hogar              | INTEGRANTE          | D lógico | Funcionario   | Integrante.inactivar(), Hogar.totalIntegrantes()                                                                         | Media         |
| HU-29  | Inactivar hogar                             | HOGAR               | D lógico | Funcionario   | Hogar.inactivar(), AsignacionAlbergue.albergueActual()                                                                   | Media         |
| HU-30  | Actualizar albergue                         | ALBERGUE            | U        | Funcionario   | Albergue.actualizar(), Albergue.cuposDisponibles(), Albergue.ocupacionActual()                                           | Media         |
| HU-31  | Inactivar albergue                          | ALBERGUE            | D lógico | Funcionario   | Albergue.inactivar(), Albergue.ocupacionActual()                                                                         | Media         |
| HU-32  | Registrar tipo de ayuda                     | TIPO_AYUDA          | C        | Funcionario   | TipoAyuda.crear(), TipoAyuda.existeNombre()                                                                              | Alta          |
| HU-33  | Actualizar tipo de ayuda                    | TIPO_AYUDA          | U        | Funcionario   | TipoAyuda.actualizar(), TipoAyuda.existeNombre()                                                                         | Baja          |
| HU-34  | Inactivar tipo de ayuda                     | TIPO_AYUDA          | D lógico | Funcionario   | TipoAyuda.inactivar(), TipoAyuda.existencias()                                                                           | Baja          |
| HU-35  | Consultar voluntarios                       | VOLUNTARIO          | R        | Funcionario   | Voluntario.listarActivos()                                                                                               | Media         |
| HU-36  | Actualizar voluntario                       | VOLUNTARIO          | U        | Funcionario   | Voluntario.actualizar()                                                                                                  | Baja          |
| HU-37  | Inactivar voluntario                        | VOLUNTARIO          | D lógico | Funcionario   | Voluntario.inactivar()                                                                                                   | Baja          |

*Nota.* CRUD: C = crear; R = consultar; U = actualizar; D lógico = inactivar; Apoyo = validación que revela un criterio de rechazo; Acceso = autenticación y permisos. Elaboración propia.

La Tabla 26 verifica la cobertura: toda entidad del modelo tiene historias para sus cuatro operaciones. Las bajas son siempre inactivaciones (RN-27). Las entidades de movimiento (asignación, donación y entrega) no se actualizan ni se inactivan después de registradas, porque son la evidencia de la trazabilidad (RN-23); la asignación solo se cierra con la salida del hogar.

**Tabla 26**  
*Cobertura de las operaciones del modelo por historia de usuario*

| **Entidad**          | **Crear**           | **Consultar** | **Actualizar**       | **Inactivar**                     |
|----------------------|---------------------|---------------|----------------------|-----------------------------------|
| USUARIO              | HU-02               | HU-25         | HU-26                | HU-27                             |
| HOGAR                | HU-04, HU-10        | HU-08         | HU-09, HU-11         | HU-29                             |
| INTEGRANTE           | HU-05, HU-06        | HU-08, HU-18  | HU-09                | HU-28                             |
| INTEGRANTE_CONDICION | HU-07               | HU-08         | HU-07                | No aplica: se reemplaza con HU-07 |
| ALBERGUE             | HU-12               | HU-15         | HU-30                | HU-31                             |
| ASIGNACION_ALBERGUE  | HU-13               | HU-15, HU-08  | HU-14 (salida)       | No aplica: registro histórico     |
| TIPO_AYUDA           | HU-32               | HU-17         | HU-33                | HU-34                             |
| DONACION             | HU-16               | HU-23         | No aplica: inmutable | No aplica: inmutable              |
| ENTREGA              | HU-19, HU-20, HU-21 | HU-22, HU-23  | No aplica: inmutable | No aplica: inmutable              |
| VOLUNTARIO           | HU-24               | HU-35         | HU-36                | HU-37                             |

*Nota.* HU-01 y HU-03 no aparecen porque son de acceso y no una operación sobre los datos. Elaboración propia.

### 2.1.3 Fichas de las historias de usuario

Cada historia se presenta en la ficha oficial del curso (Lora Patiño, 2026), con sus siete campos: código, título corto, historia, criterios de aceptación, origen de la necesidad, RF derivados y prioridad. Los criterios se escriben como escenarios «dado, cuando, entonces»; cada uno indica entre paréntesis si es de éxito, de rechazo o alterno, y la línea que empieza con el signo \# nombra el método, la regla de negocio y el requisito funcional que lo respaldan. Las fichas se agrupan por módulo, de la Tabla 27 a la Tabla 63.

#### Módulo de acceso y usuarios.

**Tabla 27**  
*Ficha de la historia de usuario HU-01: Iniciar sesión*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-01</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Iniciar sesión</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero autenticarme en el sistema, para acceder a las funciones que corresponden a mi rol.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> ninguno; esta historia es la que crea la sesión.</p>
<p><strong>CA-01.1 Inicio de sesión exitoso</strong> (éxito)</p>
<p><em># Usuario.autenticar(), Usuario.tienePermiso() · RN-01, RN-05 · RF-01, RF-05</em></p>
<p><strong>Dado</strong> que el Funcionario está registrado y activo, <strong>cuando</strong> ingresa su nombre de usuario y su clave correctos, <strong>entonces</strong> el sistema inicia su sesión y le ofrece únicamente las funciones de su rol.</p>
<p><strong>CA-01.2 Rechazo por credenciales incorrectas</strong> (rechazo)</p>
<p><em># Usuario.autenticar() · RN-01 · RF-01</em></p>
<p><strong>Dado</strong> que el Funcionario está registrado, <strong>cuando</strong> ingresa un nombre de usuario o una clave incorrectos, <strong>entonces</strong> el sistema no inicia la sesión y muestra «Usuario o clave incorrectos.»</p>
<p><strong>CA-01.3 Rechazo por dato faltante</strong> (rechazo)</p>
<p><em># Usuario.autenticar() · RN-06 · RF-01</em></p>
<p><strong>Dado</strong> que el Funcionario va a iniciar sesión, <strong>cuando</strong> deja vacío el nombre de usuario o la clave y solicita ingresar, <strong>entonces</strong> el sistema no inicia la sesión y señala el dato faltante.</p>
<p><strong>CA-01.4 Rechazo por falta de sesión</strong> (rechazo)</p>
<p><em># Usuario.autenticar() · RN-01 · RF-02</em></p>
<p><strong>Dado</strong> que no hay una sesión iniciada, <strong>cuando</strong> una persona intenta usar directamente cualquier función del sistema, <strong>entonces</strong> el sistema no la ejecuta, no muestra información y solicita la autenticación.</p>
<p><strong>CA-01.5 Rechazo de un usuario inactivo</strong> (rechazo)</p>
<p><em># Usuario.autenticar() · RN-01, RN-34 · RF-01</em></p>
<p><strong>Dado</strong> que el usuario fue inactivado, <strong>cuando</strong> ingresa su nombre de usuario y su clave correctos, <strong>entonces</strong> el sistema no inicia la sesión y muestra «El usuario está inactivo. Comuníquese con el Administrador.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Fuente documental D-02 (Ley 1581 de 2012: acceso restringido a los datos personales) y objetivo general de la Fase 0 (control de acceso por roles). Hallazgo H-09: cerca de la mitad de los encuestados conoce con frecuencia casos de suplantación o entregas duplicadas, lo que exige que cada operación sea atribuible a un usuario identificado.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-01 (autenticar usuario), RF-05 (ofrecer solo las funciones del rol), RF-02 (exigir sesión iniciada). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: USUARIO. Operación: Acceso. Caso de uso: CU-01. Elaboración propia.

**Tabla 28**  
*Ficha de la historia de usuario HU-02: Registrar usuario y asignar rol*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-02</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar usuario y asignar rol</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Administrador del sistema, quiero registrar un usuario y asignarle uno de los roles del sistema, para controlar quién opera el sistema y con qué permisos.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Administrador del sistema ha iniciado sesión.</p>
<p><strong>CA-02.1 Registro exitoso de un usuario</strong> (éxito)</p>
<p><em># Usuario.crear() · RN-03 · RF-03</em></p>
<p><strong>Dado</strong> que no existe un usuario con el nombre de usuario «cmejia», <strong>cuando</strong> el Administrador registra un usuario con nombre completo, nombre de usuario «cmejia», clave y uno de los tres roles (Funcionario de gestión del riesgo, Coordinador de albergue o Administrador del sistema), <strong>entonces</strong> el usuario queda registrado, activo y con el rol asignado, y puede iniciar sesión.</p>
<p><strong>CA-02.2 Rechazo por nombre de usuario duplicado</strong> (rechazo)</p>
<p><em># Usuario.existeNombreUsuario() · RN-02 · RF-04</em></p>
<p><strong>Dado</strong> que ya existe un usuario con el nombre de usuario «cmejia», <strong>cuando</strong> el Administrador intenta registrar otro usuario con ese mismo nombre de usuario, <strong>entonces</strong> el sistema no lo registra y muestra «El nombre de usuario cmejia ya existe.»</p>
<p><strong>CA-02.3 Rechazo por rol o dato obligatorio faltante</strong> (rechazo)</p>
<p><em># Usuario.crear() · RN-03, RN-06 · RF-03</em></p>
<p><strong>Dado</strong> que el Administrador está registrando un usuario, <strong>cuando</strong> solicita guardar sin seleccionar un rol o con un dato obligatorio vacío, <strong>entonces</strong> el sistema no registra al usuario y señala el dato faltante.</p>
<p><strong>CA-02.4 Rechazo por rol no autorizado</strong> (rechazo)</p>
<p><em># Usuario.tienePermiso() · RN-04 · RF-06</em></p>
<p><strong>Dado</strong> que el usuario que inició sesión tiene un rol distinto de Administrador del sistema, <strong>cuando</strong> intenta registrar un usuario, <strong>entonces</strong> el sistema deniega la operación y no crea ningún usuario.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Objetivo general de la Fase 0 (control de acceso por roles) y fuente documental D-02 (Ley 1581 de 2012). Hallazgo H-12: los encuestados cumplen funciones distintas en la emergencia (coordinación de albergue, brigada, voluntariado), por lo que el acceso debe diferenciarse por rol.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-03 (registrar usuario y asignar rol), RF-04 (verificar nombre de usuario único), RF-06 (denegar funciones no autorizadas). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: USUARIO. Operación: C. Caso de uso: CU-02. Elaboración propia.

**Tabla 29**  
*Ficha de la historia de usuario HU-03: Usar solo las funciones del rol*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-03</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Usar solo las funciones del rol</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Administrador del sistema, quiero que cada usuario use únicamente las funciones permitidas para su rol, para que la información sensible de las familias afectadas solo sea accesible a quien corresponde.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Administrador del sistema ha iniciado sesión.</p>
<p><strong>CA-03.1 Funciones según el rol</strong> (éxito)</p>
<p><em># Usuario.tienePermiso() · RN-05 · RF-05</em></p>
<p><strong>Dado</strong> que un usuario inició sesión con un rol determinado, <strong>cuando</strong> accede al sistema, <strong>entonces</strong> el sistema le ofrece solo las funciones autorizadas para ese rol en la matriz de permisos.</p>
<p><strong>CA-03.2 Rechazo de una función no autorizada</strong> (rechazo)</p>
<p><em># Usuario.tienePermiso() · RN-05 · RF-06</em></p>
<p><strong>Dado</strong> que un usuario con sesión iniciada no tiene autorización para una función, <strong>cuando</strong> intenta ejecutarla directamente, <strong>entonces</strong> el sistema deniega el acceso, muestra «Acceso no autorizado para su rol.» y no ejecuta la función.</p>
<p><strong>CA-03.3 Rechazo de la gestión de usuarios a otros roles</strong> (rechazo)</p>
<p><em># Usuario.tienePermiso() · RN-04 · RF-06</em></p>
<p><strong>Dado</strong> que el usuario con sesión iniciada tiene el rol Coordinador de albergue, <strong>cuando</strong> intenta registrar un usuario, <strong>entonces</strong> el sistema deniega la operación porque esa función es exclusiva del Administrador del sistema.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Fuente documental D-02 (Ley 1581 de 2012 y Decreto 1377 de 2013: circulación restringida de datos personales) y hallazgo H-09 (cerca de la mitad reporta casos frecuentes de suplantación o entregas duplicadas).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-05 (ofrecer solo las funciones del rol), RF-06 (denegar funciones no autorizadas). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: USUARIO. Operación: Acceso. Caso de uso: CU-01. Elaboración propia.

**Tabla 30**  
*Ficha de la historia de usuario HU-25: Consultar usuarios*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-25</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Consultar usuarios</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Administrador del sistema, quiero consultar los usuarios registrados, para saber quién tiene acceso al sistema y con qué rol.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Administrador del sistema ha iniciado sesión.</p>
<p><strong>CA-25.1 Listado de usuarios activos</strong> (consulta o alterno)</p>
<p><em># Usuario.listarActivos() · RN-27 · RF-35</em></p>
<p><strong>Dado</strong> que existen usuarios activos e inactivos, <strong>cuando</strong> el Administrador consulta los usuarios, <strong>entonces</strong> el sistema muestra nombre completo, nombre de usuario y rol de los usuarios activos, ordenados por nombre, y no muestra los inactivos.</p>
<p><strong>CA-25.2 Rechazo por rol no autorizado</strong> (rechazo)</p>
<p><em># Usuario.tienePermiso() · RN-04 · RF-06</em></p>
<p><strong>Dado</strong> que el usuario con sesión iniciada no es Administrador del sistema, <strong>cuando</strong> intenta consultar los usuarios, <strong>entonces</strong> el sistema deniega la operación y no muestra ningún dato.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Fuente documental D-02 (Ley 1581 de 2012: el responsable debe conocer quién accede a los datos). Sin respaldo directo en la encuesta: se aplica el protocolo de subsanación (PS-01).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-35 (consultar usuarios), RF-06 (denegar funciones no autorizadas). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: USUARIO. Operación: R. Caso de uso: CU-24. Elaboración propia.

**Tabla 31**  
*Ficha de la historia de usuario HU-26: Actualizar usuario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-26</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Actualizar usuario</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Administrador del sistema, quiero modificar los datos o el rol de un usuario registrado, para mantener los permisos al día cuando una persona cambia de función.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Administrador del sistema ha iniciado sesión.</p>
<p><strong>CA-26.1 Actualización exitosa</strong> (éxito)</p>
<p><em># Usuario.actualizar() · RN-03 · RF-36</em></p>
<p><strong>Dado</strong> que existe el usuario activo «cmejia» con rol Funcionario de gestión del riesgo, <strong>cuando</strong> el Administrador cambia su rol a Coordinador de albergue y guarda, <strong>entonces</strong> el usuario queda con el nuevo rol, el sistema muestra «Datos actualizados correctamente.» y el cambio aplica en su siguiente inicio de sesión.</p>
<p><strong>CA-26.2 Rechazo por nombre de usuario de otro usuario</strong> (rechazo)</p>
<p><em># Usuario.existeNombreUsuario() · RN-02 · RF-04</em></p>
<p><strong>Dado</strong> que existen los usuarios «cmejia» y «lrios», <strong>cuando</strong> el Administrador intenta cambiar el nombre de usuario de «lrios» a «cmejia», <strong>entonces</strong> el sistema no guarda el cambio y muestra «El nombre de usuario cmejia ya existe.»</p>
<p><strong>CA-26.3 Rechazo por dato obligatorio vacío</strong> (rechazo)</p>
<p><em># Usuario.actualizar() · RN-06 · RF-36</em></p>
<p><strong>Dado</strong> que el Administrador está modificando un usuario, <strong>cuando</strong> deja vacío un dato obligatorio y solicita guardar, <strong>entonces</strong> el sistema no guarda el cambio y el usuario conserva sus datos anteriores.</p>
<p><strong>CA-26.4 Rechazo por dejar el sistema sin Administrador</strong> (rechazo)</p>
<p><em># Usuario.actualizar() · RN-28 · RF-36</em></p>
<p><strong>Dado</strong> que solo existe un Administrador del sistema activo, <strong>cuando</strong> se intenta cambiar su rol, <strong>entonces</strong> el sistema no guarda el cambio y muestra «Debe existir al menos un Administrador activo.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-12 (las personas cumplen funciones distintas y cambiantes durante la emergencia) y fuente documental D-02. Protocolo de subsanación PS-01.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-36 (actualizar usuario), RF-04 (verificar nombre de usuario único). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: USUARIO. Operación: U. Caso de uso: CU-25. Elaboración propia.

**Tabla 32**  
*Ficha de la historia de usuario HU-27: Inactivar usuario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-27</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Inactivar usuario</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Administrador del sistema, quiero inactivar a un usuario que ya no debe operar el sistema, para retirarle el acceso sin perder la constancia de las operaciones que realizó.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Administrador del sistema ha iniciado sesión.</p>
<p><strong>CA-27.1 El aviso explica la consecuencia</strong> (éxito)</p>
<p><em># Usuario.inactivar() · RN-27 · RF-37</em></p>
<p><strong>Dado</strong> que existe el usuario activo «lrios», <strong>cuando</strong> el Administrador solicita inactivarlo, <strong>entonces</strong> el sistema muestra el aviso «Laura Ríos no podrá iniciar sesión, pero los registros que realizó se conservarán. ¿Desea inactivarla?» y el registro no cambia mientras el Administrador no confirme.</p>
<p><strong>CA-27.2 Inactivación confirmada</strong> (éxito)</p>
<p><em># Usuario.inactivar() · RN-27, RN-34 · RF-37</em></p>
<p><strong>Dado</strong> que el Administrador está viendo el aviso de inactivación de «lrios», <strong>cuando</strong> confirma, <strong>entonces</strong> el usuario queda inactivo, deja de aparecer en el listado de usuarios activos, no puede iniciar sesión y sus registros se conservan.</p>
<p><strong>CA-27.3 El Administrador desiste</strong> (consulta o alterno)</p>
<p><em># Usuario.inactivar() · RF-37</em></p>
<p><strong>Dado</strong> que el Administrador está viendo el aviso de inactivación, <strong>cuando</strong> elige no inactivar, <strong>entonces</strong> el usuario continúa activo.</p>
<p><strong>CA-27.4 Rechazo por ser el único Administrador activo</strong> (rechazo)</p>
<p><em># Usuario.inactivar() · RN-28 · RF-37</em></p>
<p><strong>Dado</strong> que solo existe un Administrador del sistema activo, <strong>cuando</strong> se solicita inactivarlo, <strong>entonces</strong> el sistema no lo inactiva y muestra «Debe existir al menos un Administrador activo.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Fuente documental D-03 (Ley 1712 de 2014: conservación de la información para la rendición de cuentas) y D-08 (lineamiento del curso: las bajas son inactivaciones). Protocolo de subsanación PS-02.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-37 (inactivar usuario). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: USUARIO. Operación: D lógico. Caso de uso: CU-26. Elaboración propia.

#### Módulo de censo.

**Tabla 33**  
*Ficha de la historia de usuario HU-04: Registrar hogar afectado*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-04</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar hogar afectado</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar un hogar afectado por la emergencia, para incluirlo en el censo desde las primeras horas del evento.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-04.1 Registro exitoso de un hogar</strong> (éxito)</p>
<p><em># Hogar.crear() · RF-07</em></p>
<p><strong>Dado</strong> que el Funcionario atiende a una familia afectada, <strong>cuando</strong> registra un hogar con dirección, barrio y municipio (el teléfono de contacto es opcional), <strong>entonces</strong> el hogar queda registrado y activo con un identificador único generado por el sistema, la fecha de registro y el usuario que lo registró, y el sistema muestra «Hogar registrado correctamente.»</p>
<p><strong>CA-04.2 Rechazo por dato obligatorio faltante</strong> (rechazo)</p>
<p><em># Hogar.crear() · RN-06 · RF-07</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando un hogar, <strong>cuando</strong> deja vacía la dirección, el barrio o el municipio y solicita guardar, <strong>entonces</strong> el sistema no registra el hogar y señala el dato faltante.</p>
<p><strong>CA-04.3 El hogar registrado se puede consultar</strong> (consulta o alterno)</p>
<p><em># Hogar.buscarPorDocumento() · RF-11</em></p>
<p><strong>Dado</strong> que un hogar fue registrado con al menos un integrante, <strong>cuando</strong> el Funcionario lo consulta por el documento de ese integrante, <strong>entonces</strong> el sistema lo muestra con los datos con los que fue registrado.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-01: la principal dificultad del censo son los datos incompletos o ilegibles (27 %) y el registro repetido de una misma familia (25 %). Hallazgo H-02: cerca de la mitad encuentra con frecuencia familias duplicadas o no censadas.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-07 (registrar hogar afectado), RF-11 (consultar hogar por documento). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: HOGAR. Operación: C. Caso de uso: CU-03. Elaboración propia.

**Tabla 34**  
*Ficha de la historia de usuario HU-05: Registrar integrantes del hogar*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-05</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar integrantes del hogar</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar a cada integrante de un hogar con su documento de identidad, para que el censo identifique individualmente a cada persona afectada.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-05.1 Registro exitoso de un integrante</strong> (éxito)</p>
<p><em># Integrante.crear(), Hogar.totalIntegrantes() · RN-09 · RF-08</em></p>
<p><strong>Dado</strong> que existe un hogar registrado y activo, <strong>cuando</strong> el Funcionario agrega un integrante con tipo y número de documento válidos, nombres, apellidos y fecha de nacimiento, <strong>entonces</strong> el integrante queda activo y asociado a ese hogar, y el hogar muestra el nuevo total de integrantes.</p>
<p><strong>CA-05.2 Rechazo por dato obligatorio faltante</strong> (rechazo)</p>
<p><em># Integrante.crear() · RN-06 · RF-08</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando un integrante, <strong>cuando</strong> deja vacío un dato obligatorio y solicita guardar, <strong>entonces</strong> el sistema no registra al integrante y señala el dato faltante.</p>
<p><strong>CA-05.3 Rechazo por formato de documento inválido</strong> (rechazo)</p>
<p><em># Integrante.crear() · RN-08 · RF-08</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando un integrante, <strong>cuando</strong> ingresa el número «10A54» con tipo CC, <strong>entonces</strong> el sistema no registra al integrante y muestra «La cédula solo admite entre 6 y 11 dígitos.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-03: solo el 20 % verifica la identidad contra una base oficial y el 25 % no tiene un procedimiento definido. Hallazgo H-01 (27 % de datos incompletos o ilegibles).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-08 (registrar integrante del hogar). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: INTEGRANTE. Operación: C. Caso de uso: CU-04. Elaboración propia.

**Tabla 35**  
*Ficha de la historia de usuario HU-06: Evitar el registro duplicado de personas*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-06</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Evitar el registro duplicado de personas</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero recibir una alerta cuando el documento de una persona ya está registrado en el censo, para evitar que una misma persona o familia sea censada más de una vez.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-06.1 Rechazo por documento registrado en otro hogar</strong> (rechazo)</p>
<p><em># Integrante.existeDocumento() · RN-07 · RF-09</em></p>
<p><strong>Dado</strong> que la persona con CC 1035441982 ya es integrante del hogar A, <strong>cuando</strong> el Funcionario intenta registrar un integrante con CC 1035441982 en el hogar B, <strong>entonces</strong> el sistema no lo registra y muestra una alerta que indica que el documento ya está registrado y en qué hogar.</p>
<p><strong>CA-06.2 Rechazo por documento registrado en el mismo hogar</strong> (rechazo)</p>
<p><em># Integrante.existeDocumento() · RN-07 · RF-09</em></p>
<p><strong>Dado</strong> que la persona con CC 1035441982 ya es integrante del hogar A, <strong>cuando</strong> el Funcionario intenta registrarla de nuevo en el hogar A, <strong>entonces</strong> el sistema no crea un segundo registro y muestra la alerta de documento ya registrado.</p>
<p><strong>CA-06.3 La alerta no altera el registro original</strong> (consulta o alterno)</p>
<p><em># Integrante.existeDocumento() · RN-07 · RF-09</em></p>
<p><strong>Dado</strong> que el sistema mostró la alerta de documento ya registrado, <strong>cuando</strong> el Funcionario cancela la operación, <strong>entonces</strong> no se crea ningún registro y el registro original permanece sin cambios.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-01 (el 25 % señala el registro repetido de una misma familia como la principal dificultad), H-02 (cerca de la mitad lo encuentra con frecuencia) y H-11 (el 53 % considera indispensable la alerta de duplicados).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-09 (verificar documento no duplicado). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: INTEGRANTE. Operación: Apoyo. Caso de uso: CU-04, CU-06. Elaboración propia.

**Tabla 36**  
*Ficha de la historia de usuario HU-07: Registrar enfoque diferencial*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-07</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar enfoque diferencial</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar si un integrante pertenece a un grupo de enfoque diferencial, para que la atención reconozca sus necesidades particulares.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-07.1 Asignación de condiciones</strong> (éxito)</p>
<p><em># Integrante.asignarCondiciones() · RN-10 · RF-10</em></p>
<p><strong>Dado</strong> que existe un integrante activo, <strong>cuando</strong> el Funcionario le asigna una o más condiciones de la lista (niño, adulto mayor, persona con discapacidad, gestante, minoría étnica), <strong>entonces</strong> el integrante queda con esas condiciones y la consulta del hogar las muestra.</p>
<p><strong>CA-07.2 Integrante sin enfoque diferencial</strong> (consulta o alterno)</p>
<p><em># Integrante.asignarCondiciones() · RN-10 · RF-10</em></p>
<p><strong>Dado</strong> que existe un integrante activo, <strong>cuando</strong> el Funcionario guarda sin asignarle ninguna condición, <strong>entonces</strong> el integrante queda registrado sin enfoque diferencial.</p>
<p><strong>CA-07.3 Rechazo por condición fuera de la lista</strong> (rechazo)</p>
<p><em># Integrante.asignarCondiciones() · RN-10 · RF-10</em></p>
<p><strong>Dado</strong> que el Funcionario está asignando condiciones, <strong>cuando</strong> intenta registrar un valor que no pertenece a la lista definida, <strong>entonces</strong> el sistema no lo acepta y el integrante conserva sus condiciones anteriores.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-06: el 60 % de los encuestados aplica hoy la presencia de niños, adultos mayores, gestantes o personas con discapacidad como criterio de asignación. Fuente documental D-04 (Manual Esfera).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-10 (registrar enfoque diferencial). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: INTEGRANTE. Operación: U. Caso de uso: CU-05. Elaboración propia.

**Tabla 37**  
*Ficha de la historia de usuario HU-08: Consultar un hogar registrado*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-08</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Consultar un hogar registrado</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero buscar un hogar por el documento de uno de sus integrantes y ver sus datos, para verificar si ya está censado y conocer su situación.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-08.1 Consulta con resultado</strong> (consulta o alterno)</p>
<p><em># Hogar.buscarPorDocumento(), AsignacionAlbergue.albergueActual() · RF-11</em></p>
<p><strong>Dado</strong> que existe un hogar activo con un integrante de CC 1035441982, <strong>cuando</strong> el Funcionario busca ese documento, <strong>entonces</strong> el sistema muestra el hogar con sus datos, sus integrantes activos, sus condiciones de enfoque diferencial y el albergue donde está alojado, si lo tiene.</p>
<p><strong>CA-08.2 Consulta sin resultado</strong> (rechazo)</p>
<p><em># Hogar.buscarPorDocumento() · RF-11</em></p>
<p><strong>Dado</strong> que no existe ningún integrante activo con CC 99999999, <strong>cuando</strong> el Funcionario busca ese documento, <strong>entonces</strong> el sistema muestra «No se encontró ningún hogar con CC 99999999.»</p>
<p><strong>CA-08.3 Rechazo por documento no ingresado</strong> (rechazo)</p>
<p><em># Hogar.buscarPorDocumento() · RN-06 · RF-11</em></p>
<p><strong>Dado</strong> que el Funcionario va a consultar un hogar, <strong>cuando</strong> solicita buscar sin ingresar el número de documento, <strong>entonces</strong> el sistema no ejecuta la búsqueda y solicita el dato.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-01 (el 15 % reporta la información dispersa en planillas, hojas de cálculo o chats) y H-03 (el 18 % compara manualmente con listados anteriores).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-11 (consultar hogar por documento). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: HOGAR. Operación: R. Caso de uso: CU-07. Elaboración propia.

**Tabla 38**  
*Ficha de la historia de usuario HU-09: Actualizar datos de un hogar o integrante*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-09</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Actualizar datos de un hogar o integrante</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero modificar los datos de un hogar o de un integrante ya registrado, para corregir datos incompletos o ilegibles y mantener el censo confiable.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-09.1 Actualización exitosa</strong> (éxito)</p>
<p><em># Hogar.actualizar(), Integrante.actualizar() · RF-12</em></p>
<p><strong>Dado</strong> que existe un hogar o un integrante activo, <strong>cuando</strong> el Funcionario modifica uno o varios datos con valores válidos y guarda, <strong>entonces</strong> el registro queda con los nuevos valores y el sistema muestra «Datos actualizados correctamente.»</p>
<p><strong>CA-09.2 Rechazo por dato obligatorio vacío</strong> (rechazo)</p>
<p><em># Hogar.actualizar(), Integrante.actualizar() · RN-06 · RF-12</em></p>
<p><strong>Dado</strong> que el Funcionario está modificando un registro, <strong>cuando</strong> deja vacío un dato obligatorio y solicita guardar, <strong>entonces</strong> el sistema no guarda el cambio y el registro conserva el valor anterior.</p>
<p><strong>CA-09.3 Rechazo por documento de otra persona</strong> (rechazo)</p>
<p><em># Integrante.existeDocumento() · RN-07 · RF-09</em></p>
<p><strong>Dado</strong> que dos personas distintas están registradas, <strong>cuando</strong> el Funcionario intenta cambiar el documento de una por el documento de la otra, <strong>entonces</strong> el sistema no guarda el cambio y muestra «El documento ya pertenece a otra persona.»</p>
<p><strong>CA-09.4 Rechazo por formato de documento inválido</strong> (rechazo)</p>
<p><em># Integrante.actualizar() · RN-08 · RF-12</em></p>
<p><strong>Dado</strong> que el Funcionario está modificando un integrante, <strong>cuando</strong> ingresa un número de documento que no respeta el formato de su tipo, <strong>entonces</strong> el sistema no guarda el cambio y muestra el formato esperado.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-01: los datos incompletos o ilegibles son la dificultad más citada del censo (27 %).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-12 (actualizar hogar o integrante), RF-09 (verificar documento no duplicado). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: HOGAR, INTEGRANTE. Operación: U. Caso de uso: CU-06, CU-08. Elaboración propia.

**Tabla 39**  
*Ficha de la historia de usuario HU-28: Inactivar integrante del hogar*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-28</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Inactivar integrante del hogar</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero inactivar a un integrante que ya no hace parte de un hogar, para mantener el censo depurado sin perder la constancia de las ayudas que recibió.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-28.1 El aviso explica la consecuencia</strong> (éxito)</p>
<p><em># Integrante.inactivar() · RN-27 · RF-38</em></p>
<p><strong>Dado</strong> que el hogar A tiene dos integrantes activos, <strong>cuando</strong> el Funcionario solicita inactivar a «Pedro Arango», <strong>entonces</strong> el sistema muestra el aviso «Pedro Arango dejará de contarse en el hogar y en la ocupación del albergue, pero su registro y las entregas que recibió se conservarán. ¿Desea inactivarlo?» y el registro no cambia mientras el Funcionario no confirme.</p>
<p><strong>CA-28.2 Inactivación confirmada</strong> (éxito)</p>
<p><em># Integrante.inactivar(), Hogar.totalIntegrantes() · RN-14, RN-27 · RF-38</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación de «Pedro Arango», <strong>cuando</strong> confirma, <strong>entonces</strong> el integrante queda inactivo, el total de integrantes del hogar disminuye en uno, su documento sigue reservado y sus entregas se conservan.</p>
<p><strong>CA-28.3 El Funcionario desiste</strong> (consulta o alterno)</p>
<p><em># Integrante.inactivar() · RF-38</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación, <strong>cuando</strong> elige no inactivar, <strong>entonces</strong> el integrante continúa activo.</p>
<p><strong>CA-28.4 Rechazo por ser el único integrante activo</strong> (rechazo)</p>
<p><em># Integrante.inactivar(), Hogar.totalIntegrantes() · RN-30 · RF-38</em></p>
<p><strong>Dado</strong> que un hogar tiene un solo integrante activo, <strong>cuando</strong> el Funcionario solicita inactivarlo, <strong>entonces</strong> el sistema no lo inactiva y muestra «El hogar debe conservar al menos un integrante activo. Si corresponde, inactive el hogar.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-02 (cerca de la mitad encuentra con frecuencia registros repetidos u omitidos, que hoy se corrigen tachando o borrando en planillas) y fuente documental D-08 (las bajas son inactivaciones). Protocolo de subsanación PS-02.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-38 (inactivar integrante). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: INTEGRANTE. Operación: D lógico. Caso de uso: CU-27. Elaboración propia.

**Tabla 40**  
*Ficha de la historia de usuario HU-29: Inactivar hogar*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-29</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Inactivar hogar</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero inactivar un hogar que no debe seguir en el censo, para depurar el censo sin perder sus datos ni su historial de ayudas.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-29.1 El aviso explica la consecuencia</strong> (éxito)</p>
<p><em># Hogar.inactivar() · RN-27 · RF-39</em></p>
<p><strong>Dado</strong> que existe un hogar activo que no está alojado en ningún albergue, <strong>cuando</strong> el Funcionario solicita inactivarlo, <strong>entonces</strong> el sistema muestra el aviso «El hogar dejará de aparecer en las búsquedas y no podrá recibir asignaciones ni entregas, pero sus datos, sus integrantes y su historial de entregas se conservarán. ¿Desea inactivarlo?» y el registro no cambia mientras el Funcionario no confirme.</p>
<p><strong>CA-29.2 Inactivación confirmada</strong> (éxito)</p>
<p><em># Hogar.inactivar() · RN-27, RN-34 · RF-39</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación del hogar, <strong>cuando</strong> confirma, <strong>entonces</strong> el hogar queda inactivo, deja de aparecer en las búsquedas, no admite asignaciones ni entregas y sus datos, integrantes e historial se conservan.</p>
<p><strong>CA-29.3 El Funcionario desiste</strong> (consulta o alterno)</p>
<p><em># Hogar.inactivar() · RF-39</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación, <strong>cuando</strong> elige no inactivar, <strong>entonces</strong> el hogar continúa activo.</p>
<p><strong>CA-29.4 Rechazo por hogar alojado</strong> (rechazo)</p>
<p><em># Hogar.inactivar(), AsignacionAlbergue.albergueActual() · RN-29 · RF-39</em></p>
<p><strong>Dado</strong> que el hogar está alojado en el albergue «Coliseo Villatina», <strong>cuando</strong> el Funcionario solicita inactivarlo, <strong>entonces</strong> el sistema no lo inactiva y muestra «El hogar está alojado en Coliseo Villatina. Registre primero su salida.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-02 (registros repetidos frecuentes para cerca de la mitad) y H-09 (cerca de la mitad conoce casos frecuentes de entregas duplicadas o suplantación, que exigen conservar el historial). Fuentes documentales D-03 y D-08. Protocolo de subsanación PS-02.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-39 (inactivar hogar). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: HOGAR. Operación: D lógico. Caso de uso: CU-28. Elaboración propia.

#### Módulo de operación sin conexión.

**Tabla 41**  
*Ficha de la historia de usuario HU-10: Registrar hogares sin conexión*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-10</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar hogares sin conexión</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar hogares e integrantes aunque no haya conexión a internet, para no interrumpir el censo en los puntos de atención con conectividad limitada.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-10.1 Registro guardado en el dispositivo</strong> (éxito)</p>
<p><em># Hogar.guardarLocal() · RN-25 · RF-13</em></p>
<p><strong>Dado</strong> que el dispositivo del Funcionario no tiene conexión, <strong>cuando</strong> registra un hogar con sus datos obligatorios válidos, <strong>entonces</strong> el sistema lo guarda en el dispositivo y lo deja en estado pendiente de sincronización.</p>
<p><strong>CA-10.2 Rechazo con las mismas validaciones que en línea</strong> (rechazo)</p>
<p><em># Hogar.guardarLocal() · RN-06, RN-25 · RF-13</em></p>
<p><strong>Dado</strong> que el dispositivo no tiene conexión, <strong>cuando</strong> el Funcionario deja vacío un dato obligatorio y solicita guardar, <strong>entonces</strong> el sistema no guarda el registro y señala el dato faltante, igual que con conexión.</p>
<p><strong>CA-10.3 Conteo de registros pendientes</strong> (consulta o alterno)</p>
<p><em># Hogar.contarPorEstado() · RF-14</em></p>
<p><strong>Dado</strong> que existen registros guardados sin conexión, <strong>cuando</strong> el Funcionario consulta el estado de sincronización, <strong>entonces</strong> el sistema muestra cuántos registros están pendientes.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-10: el 73 % de los encuestados trabaja con conectividad intermitente, muy limitada o impredecible; solo el 27 % la reporta estable. Hallazgo H-11 (el 35 % considera indispensable el registro sin internet).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-13 (registrar hogares sin conexión), RF-14 (informar estado de sincronización). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: HOGAR, INTEGRANTE. Operación: C. Caso de uso: CU-09. Elaboración propia.

**Tabla 42**  
*Ficha de la historia de usuario HU-11: Sincronizar registros pendientes*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-11</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Sincronizar registros pendientes</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero que los registros guardados sin conexión se envíen al sistema central cuando se recupere la conexión, para que el censo quede unificado y sin pérdida de información.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-11.1 Sincronización exitosa</strong> (éxito)</p>
<p><em># Hogar.sincronizarPendientes() · RN-26 · RF-15</em></p>
<p><strong>Dado</strong> que existen registros pendientes y el dispositivo recupera la conexión, <strong>cuando</strong> el sistema detecta la conexión o el Funcionario solicita sincronizar, <strong>entonces</strong> los registros válidos quedan almacenados en el sistema central, cambian a estado sincronizado y dejan de contarse como pendientes.</p>
<p><strong>CA-11.2 Rechazo por documento ya existente (conflicto)</strong> (rechazo)</p>
<p><em># Hogar.sincronizarPendientes(), Integrante.existeDocumento() · RN-07, RN-26 · RF-16</em></p>
<p><strong>Dado</strong> que un registro pendiente contiene un documento que ya existe en el sistema central, <strong>cuando</strong> se ejecuta la sincronización, <strong>entonces</strong> el sistema no crea un registro duplicado, deja el registro en estado de conflicto y se lo informa al Funcionario para su revisión.</p>
<p><strong>CA-11.3 Interrupción de la conexión</strong> (rechazo)</p>
<p><em># Hogar.sincronizarPendientes() · RN-26 · RF-15</em></p>
<p><strong>Dado</strong> que la conexión se interrumpe durante la sincronización, <strong>cuando</strong> el proceso se detiene, <strong>entonces</strong> los registros no confirmados siguen pendientes y, al reintentar, no se pierden ni se duplican.</p>
<p><strong>CA-11.4 Resultado de la sincronización</strong> (consulta o alterno)</p>
<p><em># Hogar.contarPorEstado() · RF-14</em></p>
<p><strong>Dado</strong> que finalizó una sincronización, <strong>cuando</strong> el Funcionario revisa el resultado, <strong>entonces</strong> el sistema muestra cuántos registros se sincronizaron, cuántos quedaron en conflicto y cuántos siguen pendientes.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-10 (el 73 % no cuenta con conectividad estable) y H-01 (el 15 % reporta la información dispersa en varios medios).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-15 (sincronizar registros pendientes), RF-16 (detectar conflictos de sincronización), RF-14 (informar estado de sincronización). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: HOGAR, INTEGRANTE. Operación: U. Caso de uso: CU-10. Elaboración propia.

#### Módulo de albergues.

**Tabla 43**  
*Ficha de la historia de usuario HU-12: Registrar albergue temporal*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-12</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar albergue temporal</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar y habilitar un albergue temporal con su capacidad máxima, para que pueda recibir hogares y se controle su ocupación.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-12.1 Registro exitoso de un albergue</strong> (éxito)</p>
<p><em># Albergue.crear() · RN-11 · RF-17</em></p>
<p><strong>Dado</strong> que el Funcionario va a habilitar un albergue, <strong>cuando</strong> lo registra con nombre, dirección, municipio y una capacidad máxima de 120 personas, <strong>entonces</strong> el albergue queda activo, con su capacidad registrada y con 120 cupos disponibles.</p>
<p><strong>CA-12.2 Rechazo por capacidad inválida</strong> (rechazo)</p>
<p><em># Albergue.crear() · RN-11 · RF-17</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando un albergue, <strong>cuando</strong> ingresa una capacidad no numérica, igual a cero o negativa, <strong>entonces</strong> el sistema no registra el albergue y muestra «La capacidad debe ser un número mayor que cero.»</p>
<p><strong>CA-12.3 Rechazo por dato obligatorio faltante</strong> (rechazo)</p>
<p><em># Albergue.crear() · RN-06 · RF-17</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando un albergue, <strong>cuando</strong> deja vacío un dato obligatorio y solicita guardar, <strong>entonces</strong> el sistema no registra el albergue y señala el dato faltante.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-04: ningún encuestado cuenta con un control centralizado de cupos; el 32 % no tiene control sistemático y el resto usa planillas, hojas de cálculo, mensajes u observación directa. Fuente documental D-04 (Manual Esfera: capacidad de los alojamientos).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-17 (registrar albergue temporal). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ALBERGUE. Operación: C. Caso de uso: CU-11. Elaboración propia.

**Tabla 44**  
*Ficha de la historia de usuario HU-13: Asignar hogar a un albergue*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-13</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Asignar hogar a un albergue</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero asignar un hogar censado a un albergue con cupos disponibles, para alojarlo sin generar sobrecupo mientras otros albergues tienen capacidad.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-13.1 Asignación exitosa</strong> (éxito)</p>
<p><em># AsignacionAlbergue.asignar(), Hogar.totalIntegrantes(), Albergue.cuposDisponibles() · RN-14 · RF-18</em></p>
<p><strong>Dado</strong> que existe un hogar censado de 4 integrantes sin albergue y un albergue activo con 10 cupos disponibles, <strong>cuando</strong> el Funcionario asigna el hogar a ese albergue, <strong>entonces</strong> el hogar queda alojado, la ocupación del albergue aumenta en 4 y sus cupos disponibles pasan a 6.</p>
<p><strong>CA-13.2 Rechazo por cupos insuficientes</strong> (rechazo)</p>
<p><em># Albergue.cuposDisponibles() · RN-15 · RF-19</em></p>
<p><strong>Dado</strong> que un albergue tiene 3 cupos disponibles, <strong>cuando</strong> el Funcionario intenta asignarle un hogar de 4 integrantes, <strong>entonces</strong> el sistema no realiza la asignación y muestra «El albergue solo tiene 3 cupos disponibles.»</p>
<p><strong>CA-13.3 Rechazo por hogar no censado</strong> (rechazo)</p>
<p><em># AsignacionAlbergue.asignar() · RN-12 · RF-18</em></p>
<p><strong>Dado</strong> que un hogar no está registrado en el censo, <strong>cuando</strong> el Funcionario intenta asignarlo a un albergue, <strong>entonces</strong> el sistema no realiza la asignación e indica que el hogar debe estar censado.</p>
<p><strong>CA-13.4 Rechazo por hogar ya alojado</strong> (rechazo)</p>
<p><em># AsignacionAlbergue.albergueActual() · RN-13 · RF-18</em></p>
<p><strong>Dado</strong> que un hogar ya está alojado en un albergue, <strong>cuando</strong> el Funcionario intenta asignarlo a otro, <strong>entonces</strong> el sistema no realiza la asignación e informa en qué albergue se encuentra.</p>
<p><strong>CA-13.5 Rechazo por hogar o albergue inactivo</strong> (rechazo)</p>
<p><em># AsignacionAlbergue.asignar() · RN-34 · RF-18</em></p>
<p><strong>Dado</strong> que el hogar o el albergue está inactivo, <strong>cuando</strong> el Funcionario intenta la asignación, <strong>entonces</strong> el sistema no la realiza e indica cuál de los dos está inactivo.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-06: los criterios más usados hoy son la decisión del momento (62 %) y el orden de llegada (60 %); los que evitan el sobrecupo, cupos disponibles (53 %) y número de integrantes (47 %), son los menos aplicados. Hallazgo H-04.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-18 (asignar hogar a albergue), RF-19 (verificar cupos suficientes). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ASIGNACION_ALBERGUE. Operación: C. Caso de uso: CU-12. Elaboración propia.

**Tabla 45**  
*Ficha de la historia de usuario HU-14: Registrar salida de un hogar del albergue*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-14</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar salida de un hogar del albergue</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Coordinador de albergue, quiero registrar la salida de un hogar alojado en mi albergue, para mantener actualizada la ocupación y liberar los cupos que ocupaba.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Coordinador de albergue ha iniciado sesión.</p>
<p><strong>CA-14.1 Salida exitosa</strong> (éxito)</p>
<p><em># AsignacionAlbergue.registrarSalida() · RN-14 · RF-20</em></p>
<p><strong>Dado</strong> que un hogar de 4 integrantes está alojado en el albergue del Coordinador, <strong>cuando</strong> registra su salida, <strong>entonces</strong> el hogar queda sin albergue, la ocupación disminuye en 4 y los cupos disponibles aumentan en 4.</p>
<p><strong>CA-14.2 Rechazo por hogar no alojado en ese albergue</strong> (rechazo)</p>
<p><em># AsignacionAlbergue.registrarSalida() · RN-16 · RF-20</em></p>
<p><strong>Dado</strong> que un hogar no está alojado en el albergue del Coordinador, <strong>cuando</strong> intenta registrar su salida, <strong>entonces</strong> el sistema no la registra y muestra «El hogar no está alojado en este albergue.»</p>
<p><strong>CA-14.3 Nueva asignación después de la salida</strong> (consulta o alterno)</p>
<p><em># AsignacionAlbergue.asignar() · RN-13 · RF-18</em></p>
<p><strong>Dado</strong> que se registró la salida de un hogar, <strong>cuando</strong> el Funcionario lo asigna a un albergue con cupos suficientes, <strong>entonces</strong> el sistema permite la asignación.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-04: el 13 % de los encuestados reporta la ocupación por mensajería o llamada y el 15 % por observación directa, sin registro de salidas. Hallazgo H-12 (el 25 % de los encuestados son coordinadores de albergue).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-20 (registrar salida de un hogar), RF-18 (asignar hogar a albergue). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ASIGNACION_ALBERGUE. Operación: U. Caso de uso: CU-13. Elaboración propia.

**Tabla 46**  
*Ficha de la historia de usuario HU-15: Consultar ocupación y cupos de albergues*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-15</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Consultar ocupación y cupos de albergues</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero consultar la capacidad, la ocupación y los cupos disponibles de cada albergue, para decidir hacia dónde dirigir a los hogares y detectar el sobrecupo.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-15.1 Consulta de ocupación</strong> (consulta o alterno)</p>
<p><em># Albergue.listarActivos(), Albergue.ocupacionActual(), Albergue.cuposDisponibles() · RN-14 · RF-21</em></p>
<p><strong>Dado</strong> que existen albergues activos, <strong>cuando</strong> el Funcionario consulta la ocupación, <strong>entonces</strong> el sistema muestra por cada albergue su capacidad, su ocupación actual y sus cupos disponibles.</p>
<p><strong>CA-15.2 La consulta refleja el último movimiento</strong> (consulta o alterno)</p>
<p><em># Albergue.ocupacionActual() · RN-14 · RF-21</em></p>
<p><strong>Dado</strong> que se acaba de registrar una asignación o una salida, <strong>cuando</strong> el Funcionario consulta la ocupación, <strong>entonces</strong> los valores ya reflejan ese movimiento sin acciones adicionales.</p>
<p><strong>CA-15.3 Albergue sin cupos</strong> (consulta o alterno)</p>
<p><em># Albergue.cuposDisponibles() · RN-14 · RF-21</em></p>
<p><strong>Dado</strong> que un albergue tiene una ocupación igual a su capacidad, <strong>cuando</strong> el Funcionario consulta la ocupación, <strong>entonces</strong> el sistema lo identifica como «Sin cupos».</p>
<p><strong>CA-15.4 Consulta sin albergues</strong> (rechazo)</p>
<p><em># Albergue.listarActivos() · RF-21</em></p>
<p><strong>Dado</strong> que no hay albergues activos, <strong>cuando</strong> el Funcionario consulta la ocupación, <strong>entonces</strong> el sistema muestra «No hay albergues registrados.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-11: la consulta en tiempo real de ocupación y cupos es la función más votada como indispensable (58 %). Hallazgo H-04 (ningún encuestado dispone hoy de esa consulta).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-21 (consultar ocupación y cupos). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ALBERGUE. Operación: R. Caso de uso: CU-14. Elaboración propia.

**Tabla 47**  
*Ficha de la historia de usuario HU-30: Actualizar albergue*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-30</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Actualizar albergue</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero modificar los datos o la capacidad de un albergue, para mantener la capacidad real cuando el espacio se amplía o se reduce.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-30.1 Actualización exitosa</strong> (éxito)</p>
<p><em># Albergue.actualizar(), Albergue.cuposDisponibles() · RN-14 · RF-40</em></p>
<p><strong>Dado</strong> que existe un albergue activo con capacidad 120 y ocupación 80, <strong>cuando</strong> el Funcionario cambia la capacidad a 150 y guarda, <strong>entonces</strong> el albergue queda con capacidad 150 y 70 cupos disponibles.</p>
<p><strong>CA-30.2 Rechazo por capacidad menor que la ocupación</strong> (rechazo)</p>
<p><em># Albergue.actualizar(), Albergue.ocupacionActual() · RN-32 · RF-40</em></p>
<p><strong>Dado</strong> que un albergue tiene 80 personas alojadas, <strong>cuando</strong> el Funcionario intenta cambiar su capacidad a 60, <strong>entonces</strong> el sistema no guarda el cambio y muestra «La capacidad no puede ser menor que la ocupación actual (80).»</p>
<p><strong>CA-30.3 Rechazo por capacidad inválida</strong> (rechazo)</p>
<p><em># Albergue.actualizar() · RN-11 · RF-40</em></p>
<p><strong>Dado</strong> que el Funcionario está modificando un albergue, <strong>cuando</strong> ingresa una capacidad no numérica, igual a cero o negativa, <strong>entonces</strong> el sistema no guarda el cambio y muestra «La capacidad debe ser un número mayor que cero.»</p>
<p><strong>CA-30.4 Rechazo por dato obligatorio vacío</strong> (rechazo)</p>
<p><em># Albergue.actualizar() · RN-06 · RF-40</em></p>
<p><strong>Dado</strong> que el Funcionario está modificando un albergue, <strong>cuando</strong> deja vacío un dato obligatorio y solicita guardar, <strong>entonces</strong> el sistema no guarda el cambio y el albergue conserva sus datos anteriores.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-04 (control de cupos manual o inexistente) y fuente documental D-04 (Manual Esfera: la capacidad del alojamiento debe corresponder al espacio disponible). Protocolo de subsanación PS-03.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-40 (actualizar albergue). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ALBERGUE. Operación: U. Caso de uso: CU-29. Elaboración propia.

**Tabla 48**  
*Ficha de la historia de usuario HU-31: Inactivar albergue*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-31</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Inactivar albergue</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero inactivar un albergue que deja de operar, para que no reciba más hogares y se conserve el historial de quienes estuvieron allí.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-31.1 El aviso explica la consecuencia</strong> (éxito)</p>
<p><em># Albergue.inactivar() · RN-27 · RF-41</em></p>
<p><strong>Dado</strong> que existe un albergue activo sin hogares alojados, <strong>cuando</strong> el Funcionario solicita inactivarlo, <strong>entonces</strong> el sistema muestra el aviso «El albergue dejará de aparecer en la consulta de ocupación y no podrá recibir hogares, pero su historial de asignaciones se conservará. ¿Desea inactivarlo?» y el registro no cambia mientras el Funcionario no confirme.</p>
<p><strong>CA-31.2 Inactivación confirmada</strong> (éxito)</p>
<p><em># Albergue.inactivar() · RN-27, RN-34 · RF-41</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación del albergue, <strong>cuando</strong> confirma, <strong>entonces</strong> el albergue queda inactivo, deja de aparecer en la consulta de ocupación, no admite asignaciones y su historial se conserva.</p>
<p><strong>CA-31.3 El Funcionario desiste</strong> (consulta o alterno)</p>
<p><em># Albergue.inactivar() · RF-41</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación, <strong>cuando</strong> elige no inactivar, <strong>entonces</strong> el albergue continúa activo.</p>
<p><strong>CA-31.4 Rechazo por tener hogares alojados</strong> (rechazo)</p>
<p><em># Albergue.inactivar(), Albergue.ocupacionActual() · RN-31 · RF-41</em></p>
<p><strong>Dado</strong> que un albergue tiene 80 personas alojadas, <strong>cuando</strong> el Funcionario solicita inactivarlo, <strong>entonces</strong> el sistema no lo inactiva y muestra «El albergue tiene 80 personas alojadas. Registre primero la salida de los hogares.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-04 y fuentes documentales D-03 (conservación de la información) y D-08 (las bajas son inactivaciones). Protocolo de subsanación PS-02.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-41 (inactivar albergue). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ALBERGUE. Operación: D lógico. Caso de uso: CU-30. Elaboración propia.

#### Módulo de inventario.

**Tabla 49**  
*Ficha de la historia de usuario HU-32: Registrar tipo de ayuda*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-32</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar tipo de ayuda</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar un tipo de ayuda en el catálogo del inventario, para clasificar de la misma manera las donaciones y las entregas.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-32.1 Registro exitoso de un tipo de ayuda</strong> (éxito)</p>
<p><em># TipoAyuda.crear() · RF-42</em></p>
<p><strong>Dado</strong> que no existe el tipo de ayuda «Kit de aseo», <strong>cuando</strong> el Funcionario lo registra con nombre «Kit de aseo» y unidad de medida «unidad», <strong>entonces</strong> el tipo de ayuda queda activo y con cero existencias.</p>
<p><strong>CA-32.2 Rechazo por nombre duplicado</strong> (rechazo)</p>
<p><em># TipoAyuda.existeNombre() · RN-19 · RF-42</em></p>
<p><strong>Dado</strong> que ya existe el tipo de ayuda «Kit de aseo», activo o inactivo, <strong>cuando</strong> el Funcionario intenta registrar otro con ese nombre, <strong>entonces</strong> el sistema no lo registra y muestra «Ya existe el tipo de ayuda Kit de aseo.»</p>
<p><strong>CA-32.3 Rechazo por dato obligatorio faltante</strong> (rechazo)</p>
<p><em># TipoAyuda.crear() · RN-06 · RF-42</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando un tipo de ayuda, <strong>cuando</strong> deja vacío el nombre o la unidad de medida y solicita guardar, <strong>entonces</strong> el sistema no lo registra y señala el dato faltante.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-05 (para cerca de la mitad es difícil o muy difícil saber qué donaciones hay disponibles) y H-11 (el 52 % considera indispensable el inventario con descuento automático).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-42 (registrar tipo de ayuda). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: TIPO_AYUDA. Operación: C. Caso de uso: CU-31. Elaboración propia.

**Tabla 50**  
*Ficha de la historia de usuario HU-16: Registrar donación recibida*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-16</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar donación recibida</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar cada donación que se recibe con su tipo de ayuda, cantidad y origen, para que ingrese al inventario con su procedencia identificada.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-16.1 Registro exitoso de una donación</strong> (éxito)</p>
<p><em># Donacion.registrar(), TipoAyuda.existencias() · RN-18, RN-20 · RF-22</em></p>
<p><strong>Dado</strong> que existe el tipo de ayuda activo «Kit de aseo» con 40 unidades en existencia, <strong>cuando</strong> el Funcionario registra una donación de 60 unidades con origen «Cruz Roja Antioquia», <strong>entonces</strong> la donación queda registrada con su fecha de recepción y el usuario que la registró, y las existencias pasan a 100.</p>
<p><strong>CA-16.2 Rechazo por cantidad inválida</strong> (rechazo)</p>
<p><em># Donacion.registrar() · RN-17 · RF-22</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando una donación, <strong>cuando</strong> ingresa una cantidad igual a cero, negativa o no numérica, <strong>entonces</strong> el sistema no registra la donación y muestra «La cantidad debe ser un número mayor que cero.»</p>
<p><strong>CA-16.3 Rechazo por tipo de ayuda u origen faltante</strong> (rechazo)</p>
<p><em># Donacion.registrar() · RN-18 · RF-22</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando una donación, <strong>cuando</strong> deja vacío el tipo de ayuda o el origen y solicita guardar, <strong>entonces</strong> el sistema no registra la donación y señala el dato faltante.</p>
<p><strong>CA-16.4 Las donaciones del mismo tipo se acumulan</strong> (consulta o alterno)</p>
<p><em># Donacion.registrar(), TipoAyuda.existeNombre() · RN-19, RN-20 · RF-23</em></p>
<p><strong>Dado</strong> que ya existen existencias del tipo «Kit de aseo», <strong>cuando</strong> el Funcionario registra una nueva donación de ese tipo, <strong>entonces</strong> el sistema suma la cantidad a las existencias de ese tipo y no crea un tipo de ayuda duplicado.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-05 (cerca de la mitad califica como difícil o muy difícil conocer las donaciones disponibles en las primeras 48 horas) y H-11 (52 %). Fuente documental D-03 (Ley 1712 de 2014).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-22 (registrar donación recibida), RF-23 (consolidar existencias por tipo de ayuda). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: DONACION. Operación: C. Caso de uso: CU-15. Elaboración propia.

**Tabla 51**  
*Ficha de la historia de usuario HU-17: Consultar existencias del inventario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-17</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Consultar existencias del inventario</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero consultar las existencias disponibles por tipo de ayuda, para saber qué hay y cuánto queda después de cada entrega.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-17.1 Consulta de existencias</strong> (consulta o alterno)</p>
<p><em># TipoAyuda.listarActivos(), TipoAyuda.existencias() · RN-20 · RF-24</em></p>
<p><strong>Dado</strong> que existen donaciones y entregas registradas, <strong>cuando</strong> el Funcionario consulta el inventario, <strong>entonces</strong> el sistema muestra por cada tipo de ayuda activo sus existencias, equivalentes a lo recibido menos lo entregado.</p>
<p><strong>CA-17.2 La consulta refleja el último movimiento</strong> (consulta o alterno)</p>
<p><em># TipoAyuda.existencias() · RN-20 · RF-24</em></p>
<p><strong>Dado</strong> que se acaba de registrar una donación o una entrega, <strong>cuando</strong> el Funcionario consulta el inventario, <strong>entonces</strong> las existencias ya reflejan ese movimiento sin acciones adicionales.</p>
<p><strong>CA-17.3 Tipo de ayuda agotado</strong> (consulta o alterno)</p>
<p><em># TipoAyuda.existencias() · RN-20 · RF-24</em></p>
<p><strong>Dado</strong> que un tipo de ayuda tiene cero existencias, <strong>cuando</strong> el Funcionario consulta el inventario, <strong>entonces</strong> el sistema lo muestra con cero existencias y como «Agotado».</p>
<p><strong>CA-17.4 Consulta con inventario vacío</strong> (rechazo)</p>
<p><em># TipoAyuda.listarActivos() · RF-24</em></p>
<p><strong>Dado</strong> que no hay tipos de ayuda activos, <strong>cuando</strong> el Funcionario consulta el inventario, <strong>entonces</strong> el sistema muestra «El inventario está vacío.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-05 (cerca de la mitad considera difícil o muy difícil conocer las existencias) y H-11 (52 %).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-24 (consultar existencias del inventario). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: TIPO_AYUDA. Operación: R. Caso de uso: CU-16. Elaboración propia.

**Tabla 52**  
*Ficha de la historia de usuario HU-33: Actualizar tipo de ayuda*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-33</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Actualizar tipo de ayuda</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero corregir el nombre o la unidad de medida de un tipo de ayuda, para mantener el catálogo del inventario sin errores.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-33.1 Actualización exitosa</strong> (éxito)</p>
<p><em># TipoAyuda.actualizar() · RF-43</em></p>
<p><strong>Dado</strong> que existe el tipo de ayuda activo «Kit aseo», <strong>cuando</strong> el Funcionario cambia su nombre a «Kit de aseo» y guarda, <strong>entonces</strong> el tipo queda con el nuevo nombre y conserva sus donaciones, entregas y existencias.</p>
<p><strong>CA-33.2 Rechazo por nombre de otro tipo de ayuda</strong> (rechazo)</p>
<p><em># TipoAyuda.existeNombre() · RN-19 · RF-43</em></p>
<p><strong>Dado</strong> que existen los tipos «Kit de aseo» y «Kit de cocina», <strong>cuando</strong> el Funcionario intenta renombrar «Kit de cocina» como «Kit de aseo», <strong>entonces</strong> el sistema no guarda el cambio y muestra «Ya existe el tipo de ayuda Kit de aseo.»</p>
<p><strong>CA-33.3 Rechazo por dato obligatorio vacío</strong> (rechazo)</p>
<p><em># TipoAyuda.actualizar() · RN-06 · RF-43</em></p>
<p><strong>Dado</strong> que el Funcionario está modificando un tipo de ayuda, <strong>cuando</strong> deja vacío el nombre o la unidad de medida, <strong>entonces</strong> el sistema no guarda el cambio y el tipo conserva sus datos anteriores.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-05. Sin respaldo directo en la encuesta para la operación de corrección: protocolo de subsanación PS-03.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-43 (actualizar tipo de ayuda). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Baja</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: TIPO_AYUDA. Operación: U. Caso de uso: CU-32. Elaboración propia.

**Tabla 53**  
*Ficha de la historia de usuario HU-34: Inactivar tipo de ayuda*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-34</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Inactivar tipo de ayuda</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero inactivar un tipo de ayuda que ya no se recibe ni se entrega, para depurar el catálogo sin perder la trazabilidad de lo que ya se movió.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-34.1 El aviso explica la consecuencia</strong> (éxito)</p>
<p><em># TipoAyuda.inactivar() · RN-27 · RF-44</em></p>
<p><strong>Dado</strong> que existe el tipo de ayuda activo «Frazada» con cero existencias, <strong>cuando</strong> el Funcionario solicita inactivarlo, <strong>entonces</strong> el sistema muestra el aviso «Frazada dejará de estar disponible para donaciones y entregas, pero sus donaciones, sus entregas y su trazabilidad se conservarán. ¿Desea inactivarlo?» y el registro no cambia mientras el Funcionario no confirme.</p>
<p><strong>CA-34.2 Inactivación confirmada</strong> (éxito)</p>
<p><em># TipoAyuda.inactivar() · RN-27, RN-34 · RF-44</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación del tipo de ayuda, <strong>cuando</strong> confirma, <strong>entonces</strong> el tipo queda inactivo, deja de ofrecerse para donaciones y entregas y su trazabilidad se conserva.</p>
<p><strong>CA-34.3 El Funcionario desiste</strong> (consulta o alterno)</p>
<p><em># TipoAyuda.inactivar() · RF-44</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación, <strong>cuando</strong> elige no inactivar, <strong>entonces</strong> el tipo de ayuda continúa activo.</p>
<p><strong>CA-34.4 Rechazo por tener existencias</strong> (rechazo)</p>
<p><em># TipoAyuda.inactivar(), TipoAyuda.existencias() · RN-33 · RF-44</em></p>
<p><strong>Dado</strong> que el tipo de ayuda «Kit de aseo» tiene 100 unidades en existencia, <strong>cuando</strong> el Funcionario solicita inactivarlo, <strong>entonces</strong> el sistema no lo inactiva y muestra «Aún hay 100 unidades de Kit de aseo en existencia.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Fuentes documentales D-03 (Ley 1712 de 2014: rendición de cuentas sobre donaciones) y D-08 (las bajas son inactivaciones). Protocolo de subsanación PS-02.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-44 (inactivar tipo de ayuda). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Baja</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: TIPO_AYUDA. Operación: D lógico. Caso de uso: CU-33. Elaboración propia.

#### Módulo de entrega de ayudas.

**Tabla 54**  
*Ficha de la historia de usuario HU-18: Verificar identidad del beneficiario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-18</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Verificar identidad del beneficiario</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero verificar que quien recibe la ayuda es integrante de un hogar censado, para evitar la suplantación y las entregas a personas no registradas.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-18.1 Beneficiario identificado</strong> (éxito)</p>
<p><em># Integrante.buscarPorDocumento() · RN-22 · RF-25</em></p>
<p><strong>Dado</strong> que existe un integrante activo con CC 1035441982 en un hogar activo, <strong>cuando</strong> el Funcionario ingresa ese documento al iniciar una entrega, <strong>entonces</strong> el sistema identifica a la persona y a su hogar y habilita el registro de la entrega.</p>
<p><strong>CA-18.2 Rechazo por persona no censada</strong> (rechazo)</p>
<p><em># Integrante.buscarPorDocumento() · RN-22 · RF-25</em></p>
<p><strong>Dado</strong> que el documento CC 99999999 no corresponde a ningún integrante censado, <strong>cuando</strong> el Funcionario lo ingresa al iniciar una entrega, <strong>entonces</strong> el sistema no habilita la entrega y muestra «La persona no figura en el censo.»</p>
<p><strong>CA-18.3 Rechazo por documento no ingresado</strong> (rechazo)</p>
<p><em># Integrante.buscarPorDocumento() · RN-06 · RF-25</em></p>
<p><strong>Dado</strong> que el Funcionario inicia una entrega, <strong>cuando</strong> solicita continuar sin ingresar el documento, <strong>entonces</strong> el sistema no habilita la entrega y solicita el dato.</p>
<p><strong>CA-18.4 Rechazo por integrante u hogar inactivo</strong> (rechazo)</p>
<p><em># Integrante.buscarPorDocumento() · RN-34 · RF-25</em></p>
<p><strong>Dado</strong> que el integrante o su hogar está inactivo, <strong>cuando</strong> el Funcionario ingresa su documento al iniciar una entrega, <strong>entonces</strong> el sistema no habilita la entrega e indica que el registro está inactivo.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-09 (cerca de la mitad conoce con frecuencia casos de entregas duplicadas o suplantación) y H-03 (el 18 % acepta la información declarada por la persona y el 25 % no tiene procedimiento de verificación).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-25 (verificar identidad del beneficiario). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: INTEGRANTE. Operación: R. Caso de uso: CU-17. Elaboración propia.

**Tabla 55**  
*Ficha de la historia de usuario HU-19: Registrar entrega de ayuda a un hogar*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-19</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar entrega de ayuda a un hogar</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar la ayuda entregada a un hogar con su tipo y cantidad, para dejar constancia de quién recibió qué, cuándo y de manos de quién.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-19.1 Registro exitoso de una entrega</strong> (éxito)</p>
<p><em># Entrega.registrar() · RN-23 · RF-26</em></p>
<p><strong>Dado</strong> que el beneficiario fue verificado y hay existencias suficientes, <strong>cuando</strong> el Funcionario registra la entrega de un tipo de ayuda con su cantidad, <strong>entonces</strong> la entrega queda registrada con el beneficiario y su hogar, el tipo de ayuda, la cantidad, la fecha y hora y el usuario que la realizó.</p>
<p><strong>CA-19.2 Rechazo por cantidad inválida</strong> (rechazo)</p>
<p><em># Entrega.registrar() · RN-17 · RF-26</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando una entrega, <strong>cuando</strong> ingresa una cantidad igual a cero, negativa o no numérica, <strong>entonces</strong> el sistema no registra la entrega y muestra «La cantidad debe ser un número mayor que cero.»</p>
<p><strong>CA-19.3 Rechazo por tipo de ayuda faltante</strong> (rechazo)</p>
<p><em># Entrega.registrar() · RN-23 · RF-26</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando una entrega, <strong>cuando</strong> no selecciona ningún tipo de ayuda y solicita guardar, <strong>entonces</strong> el sistema no registra la entrega y señala el dato faltante.</p>
<p><strong>CA-19.4 Rechazo por beneficiario no verificado</strong> (rechazo)</p>
<p><em># Integrante.buscarPorDocumento() · RN-22 · RF-25</em></p>
<p><strong>Dado</strong> que el beneficiario no ha sido verificado, <strong>cuando</strong> el Funcionario intenta registrar la entrega, <strong>entonces</strong> el sistema no la registra e indica que primero debe verificarse la identidad.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-08: el 55 % indica que no se deja constancia sistemática y el 60 % que solo queda el registro de quien entrega; la constancia existente está dispersa entre planillas (70 %), mensajes (70 %) y hojas de cálculo (57 %). Hallazgo H-07 (para el 50 % pasa más de un día entre el registro y la primera ayuda).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-26 (registrar entrega de ayuda), RF-25 (verificar identidad del beneficiario). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ENTREGA. Operación: C. Caso de uso: CU-18. Elaboración propia.

**Tabla 56**  
*Ficha de la historia de usuario HU-20: Descontar del inventario cada entrega*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-20</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Descontar del inventario cada entrega</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero que cada entrega registrada descuente automáticamente la cantidad entregada del inventario, para conocer las existencias reales sin conteos manuales.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-20.1 Descuento automático</strong> (éxito)</p>
<p><em># Entrega.registrar(), TipoAyuda.existencias() · RN-20 · RF-27</em></p>
<p><strong>Dado</strong> que el tipo «Kit de aseo» tiene 100 unidades en existencia, <strong>cuando</strong> se registra una entrega de 4 unidades, <strong>entonces</strong> las existencias pasan a 96.</p>
<p><strong>CA-20.2 Rechazo por existencias insuficientes</strong> (rechazo)</p>
<p><em># TipoAyuda.hayExistencias() · RN-21 · RF-28</em></p>
<p><strong>Dado</strong> que el tipo «Kit de aseo» tiene 3 unidades en existencia, <strong>cuando</strong> se intenta registrar una entrega de 4 unidades, <strong>entonces</strong> el sistema no registra la entrega, las existencias no cambian y muestra «Solo hay 3 unidades disponibles.»</p>
<p><strong>CA-20.3 Rechazo por tipo de ayuda agotado</strong> (rechazo)</p>
<p><em># TipoAyuda.hayExistencias() · RN-21 · RF-28</em></p>
<p><strong>Dado</strong> que una entrega dejó las existencias de un tipo de ayuda en cero, <strong>cuando</strong> se intenta registrar otra entrega de ese tipo, <strong>entonces</strong> el sistema no la registra e informa que el tipo de ayuda está agotado.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-11 (el 52 % considera indispensable el inventario que descuenta cada entrega) y H-05 (dificultad para conocer las existencias).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-27 (descontar existencias por entrega), RF-28 (verificar existencias suficientes). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: TIPO_AYUDA. Operación: Apoyo. Caso de uso: CU-18. Elaboración propia.

**Tabla 57**  
*Ficha de la historia de usuario HU-21: Registrar firma digital del beneficiario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-21</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar firma digital del beneficiario</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero capturar la firma digital del beneficiario al entregar la ayuda, para dejar constancia verificable de que la recibió.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-21.1 Firma asociada a la entrega</strong> (éxito)</p>
<p><em># Entrega.capturarFirma() · RN-24 · RF-29</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando una entrega, <strong>cuando</strong> el beneficiario firma en el dispositivo y el Funcionario confirma, <strong>entonces</strong> la firma queda asociada a esa entrega y se muestra al consultarla.</p>
<p><strong>CA-21.2 Rechazo por entrega sin firma</strong> (rechazo)</p>
<p><em># Entrega.capturarFirma() · RN-24 · RF-30</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando una entrega, <strong>cuando</strong> intenta confirmarla sin la firma del beneficiario, <strong>entonces</strong> el sistema no completa la entrega, no descuenta existencias y solicita la firma.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-08: el 70 % ya recoge la firma del beneficiario en planillas de papel, práctica que la firma digital reemplaza y consolida. Hallazgo H-11 (el 40 % la considera indispensable).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-29 (capturar firma digital del beneficiario), RF-30 (exigir firma para completar la entrega). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ENTREGA. Operación: Apoyo. Caso de uso: CU-19. Elaboración propia.

**Tabla 58**  
*Ficha de la historia de usuario HU-22: Consultar historial de entregas de un hogar*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-22</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Consultar historial de entregas de un hogar</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero consultar todas las ayudas entregadas a un hogar, para verificar qué ha recibido y detectar posibles entregas repetidas.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-22.1 Historial con entregas</strong> (consulta o alterno)</p>
<p><em># Entrega.listarPorHogar() · RN-23 · RF-31</em></p>
<p><strong>Dado</strong> que un hogar tiene entregas registradas, <strong>cuando</strong> el Funcionario consulta su historial, <strong>entonces</strong> el sistema muestra en orden cronológico cada entrega con fecha y hora, tipo de ayuda, cantidad, beneficiario que recibió y usuario que entregó.</p>
<p><strong>CA-22.2 Historial sin entregas</strong> (consulta o alterno)</p>
<p><em># Entrega.listarPorHogar() · RF-31</em></p>
<p><strong>Dado</strong> que un hogar no tiene entregas registradas, <strong>cuando</strong> el Funcionario consulta su historial, <strong>entonces</strong> el sistema muestra «El hogar no ha recibido ayudas.»</p>
<p><strong>CA-22.3 Consulta de un documento no censado</strong> (rechazo)</p>
<p><em># Hogar.buscarPorDocumento() · RF-31</em></p>
<p><strong>Dado</strong> que el documento buscado no pertenece a ningún hogar censado, <strong>cuando</strong> el Funcionario solicita el historial, <strong>entonces</strong> el sistema muestra «No se encontró ningún hogar con ese documento.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-09 (cerca de la mitad conoce con frecuencia casos de entregas duplicadas) y H-08 (constancia dispersa en varios medios).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-31 (consultar historial de entregas de un hogar). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: ENTREGA. Operación: R. Caso de uso: CU-20. Elaboración propia.

**Tabla 59**  
*Ficha de la historia de usuario HU-23: Consultar trazabilidad de un tipo de ayuda*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-23</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Consultar trazabilidad de un tipo de ayuda</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero consultar el recorrido completo de un tipo de ayuda, desde su origen hasta los hogares que la recibieron, para justificar documentalmente el destino de los bienes humanitarios.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-23.1 Trazabilidad completa</strong> (consulta o alterno)</p>
<p><em># Donacion.listarPorTipo(), Entrega.listarPorTipo(), TipoAyuda.existencias() · RN-23 · RF-32</em></p>
<p><strong>Dado</strong> que un tipo de ayuda tiene donaciones y entregas registradas, <strong>cuando</strong> el Funcionario consulta su trazabilidad, <strong>entonces</strong> el sistema muestra las donaciones (origen, fecha y cantidad), las entregas (fecha, hogar, beneficiario, usuario responsable y cantidad) y las existencias restantes.</p>
<p><strong>CA-23.2 Tipo de ayuda sin entregas</strong> (consulta o alterno)</p>
<p><em># Donacion.listarPorTipo(), Entrega.listarPorTipo() · RF-32</em></p>
<p><strong>Dado</strong> que un tipo de ayuda tiene donaciones pero ninguna entrega, <strong>cuando</strong> el Funcionario consulta su trazabilidad, <strong>entonces</strong> el sistema muestra las donaciones y las existencias, e indica que no hay entregas registradas.</p>
<p><strong>CA-23.3 Consulta de un tipo de ayuda inexistente</strong> (rechazo)</p>
<p><em># Donacion.listarPorTipo() · RF-32</em></p>
<p><strong>Dado</strong> que el tipo de ayuda buscado no existe en el inventario, <strong>cuando</strong> el Funcionario solicita la consulta, <strong>entonces</strong> el sistema muestra «No hay registros de ese tipo de ayuda.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Fuente documental D-03 (Ley 1712 de 2014: transparencia y rendición de cuentas) y hallazgo H-08 (el 55 % reporta que no se deja constancia sistemática de las entregas).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-32 (consultar trazabilidad de un tipo de ayuda). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: DONACION, ENTREGA. Operación: R. Caso de uso: CU-21. Elaboración propia.

#### Módulo de voluntarios.

**Tabla 60**  
*Ficha de la historia de usuario HU-24: Registrar voluntario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-24</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Registrar voluntario</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero registrar los datos de un voluntario, para contar con el personal voluntario identificado durante la emergencia.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-24.1 Registro exitoso de un voluntario</strong> (éxito)</p>
<p><em># Voluntario.crear() · RF-33</em></p>
<p><strong>Dado</strong> que el Funcionario recibe a una persona voluntaria, <strong>cuando</strong> la registra con tipo y número de documento, nombres, apellidos y teléfono, <strong>entonces</strong> el voluntario queda registrado y activo y el sistema muestra «Voluntario registrado correctamente.»</p>
<p><strong>CA-24.2 Rechazo por dato obligatorio faltante</strong> (rechazo)</p>
<p><em># Voluntario.crear() · RN-06 · RF-33</em></p>
<p><strong>Dado</strong> que el Funcionario está registrando un voluntario, <strong>cuando</strong> deja vacío un dato obligatorio y solicita guardar, <strong>entonces</strong> el sistema no registra al voluntario y señala el dato faltante.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-12: el 27 % de los encuestados participa en la atención como voluntario, sin que exista un registro unificado de quiénes son. Alcance de la Fase 0 (coordinación de voluntarios).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-33 (registrar voluntario). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: VOLUNTARIO. Operación: C. Caso de uso: CU-22. Elaboración propia.

**Tabla 61**  
*Ficha de la historia de usuario HU-35: Consultar voluntarios*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-35</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Consultar voluntarios</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero consultar el listado de voluntarios registrados, para saber con qué personal voluntario se cuenta y cómo contactarlo.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-35.1 Listado de voluntarios activos</strong> (consulta o alterno)</p>
<p><em># Voluntario.listarActivos() · RN-27 · RF-34</em></p>
<p><strong>Dado</strong> que existen voluntarios activos e inactivos, <strong>cuando</strong> el Funcionario consulta los voluntarios, <strong>entonces</strong> el sistema muestra documento, nombres, apellidos y teléfono de los voluntarios activos, ordenados por apellido, y no muestra los inactivos.</p>
<p><strong>CA-35.2 Consulta sin voluntarios</strong> (rechazo)</p>
<p><em># Voluntario.listarActivos() · RF-34</em></p>
<p><strong>Dado</strong> que no hay voluntarios activos, <strong>cuando</strong> el Funcionario consulta los voluntarios, <strong>entonces</strong> el sistema muestra «No hay voluntarios registrados.»</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-12 (el 27 % de los encuestados son voluntarios).</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-34 (consultar voluntarios). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: VOLUNTARIO. Operación: R. Caso de uso: CU-23. Elaboración propia.

**Tabla 62**  
*Ficha de la historia de usuario HU-36: Actualizar voluntario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-36</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Actualizar voluntario</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero modificar los datos de un voluntario registrado, para mantener al día su información de contacto.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-36.1 Actualización exitosa</strong> (éxito)</p>
<p><em># Voluntario.actualizar() · RF-45</em></p>
<p><strong>Dado</strong> que existe un voluntario activo con teléfono 3104567890, <strong>cuando</strong> el Funcionario cambia el teléfono a 3017654321 y guarda, <strong>entonces</strong> el voluntario queda con el nuevo teléfono y el sistema muestra «Datos actualizados correctamente.»</p>
<p><strong>CA-36.2 Rechazo por dato obligatorio vacío</strong> (rechazo)</p>
<p><em># Voluntario.actualizar() · RN-06 · RF-45</em></p>
<p><strong>Dado</strong> que el Funcionario está modificando un voluntario, <strong>cuando</strong> deja vacío un dato obligatorio y solicita guardar, <strong>entonces</strong> el sistema no guarda el cambio y el voluntario conserva sus datos anteriores.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H-12. Sin respaldo directo en la encuesta para la operación de corrección: protocolo de subsanación PS-03.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-45 (actualizar voluntario). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Baja</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: VOLUNTARIO. Operación: U. Caso de uso: CU-34. Elaboración propia.

**Tabla 63**  
*Ficha de la historia de usuario HU-37: Inactivar voluntario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Código</strong></th>
<th><strong>HU-37</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Título corto</strong></td>
<td>Inactivar voluntario</td>
</tr>
<tr class="even">
<td><strong>Historia</strong></td>
<td>Como Funcionario de gestión del riesgo, quiero inactivar a un voluntario que deja de participar en la atención, para mantener el listado depurado sin perder sus datos.</td>
</tr>
<tr class="odd">
<td><strong>Criterios de aceptación</strong></td>
<td><p><strong>Antecedentes:</strong> dado que el Funcionario de gestión del riesgo ha iniciado sesión.</p>
<p><strong>CA-37.1 El aviso explica la consecuencia</strong> (éxito)</p>
<p><em># Voluntario.inactivar() · RN-27 · RF-46</em></p>
<p><strong>Dado</strong> que existe el voluntario activo «Sofía Ríos», <strong>cuando</strong> el Funcionario solicita inactivarlo, <strong>entonces</strong> el sistema muestra el aviso «Sofía Ríos dejará de aparecer en el listado de voluntarios, pero sus datos se conservarán. ¿Desea inactivarla?» y el registro no cambia mientras el Funcionario no confirme.</p>
<p><strong>CA-37.2 Inactivación confirmada</strong> (éxito)</p>
<p><em># Voluntario.inactivar() · RN-27 · RF-46</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación, <strong>cuando</strong> confirma, <strong>entonces</strong> el voluntario queda inactivo, deja de aparecer en el listado y sus datos se conservan.</p>
<p><strong>CA-37.3 Rechazo de una inactivación no confirmada</strong> (rechazo)</p>
<p><em># Voluntario.inactivar() · RN-27 · RF-46</em></p>
<p><strong>Dado</strong> que el Funcionario está viendo el aviso de inactivación, <strong>cuando</strong> elige no inactivar, <strong>entonces</strong> el sistema no cambia el registro y el voluntario continúa activo.</p></td>
</tr>
<tr class="even">
<td><strong>Origen de la necesidad</strong></td>
<td>Fuente documental D-08 (las bajas son inactivaciones) y hallazgo H-12. Protocolo de subsanación PS-02.</td>
</tr>
<tr class="odd">
<td><strong>RF derivados</strong></td>
<td>RF-46 (inactivar voluntario). Se formalizan en la sección 2.2.2.</td>
</tr>
<tr class="even">
<td><strong>Prioridad</strong></td>
<td>Baja</td>
</tr>
</tbody>
</table>

*Nota.* Entidad: VOLUNTARIO. Operación: D lógico. Caso de uso: CU-35. Elaboración propia.
