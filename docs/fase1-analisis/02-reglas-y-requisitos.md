> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 2.2 Reglas de negocio, requisitos funcionales y requisitos no funcionales

### 2.2.1 Reglas de negocio

Las 34 reglas de negocio nacen de los criterios de aceptación: cada criterio de rechazo delata una prohibición que existiría aunque no hubiera software, y esa prohibición se numera como regla. Cada ficha (Tabla 64 a Tabla 97) presenta el enunciado en presente, como política del negocio; su origen en los criterios y en la sección 1.7; y los requisitos funcionales que la vigilan. Ninguna regla queda sin vigilante.

**Tabla 64**  
*Ficha de la regla de negocio RN-01: Acceso solo con sesión de un usuario activo*

| **Código**            | **RN-01**                                                                                     |
|-----------------------|-----------------------------------------------------------------------------------------------|
| **Enunciado**         | Solo un usuario registrado y activo, con sesión iniciada, accede a las funciones del sistema. |
| **Origen**            | Criterios HU-01 CA-01.1, CA-01.2, CA-01.4, CA-01.5. Fuente de la sección 1.7: D-02.           |
| **RF que la vigilan** | RF-01, RF-02, RF-05                                                                           |

*Nota.* Tipo de regla: seguridad. Elaboración propia.

**Tabla 65**  
*Ficha de la regla de negocio RN-02: Nombre de usuario único*

| **Código**            | **RN-02**                                                               |
|-----------------------|-------------------------------------------------------------------------|
| **Enunciado**         | No existen dos usuarios con el mismo nombre de usuario.                 |
| **Origen**            | Criterios HU-02 CA-02.2; HU-26 CA-26.2. Fuente de la sección 1.7: D-02. |
| **RF que la vigilan** | RF-04                                                                   |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 66**  
*Ficha de la regla de negocio RN-03: Rol obligatorio entre los tres del sistema*

| **Código**            | **RN-03**                                                                                                                      |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Todo usuario tiene exactamente un rol: Funcionario de gestión del riesgo, Coordinador de albergue o Administrador del sistema. |
| **Origen**            | Criterios HU-02 CA-02.1, CA-02.3; HU-26 CA-26.1. Fuente de la sección 1.7: Alcance (sección 1.2).                              |
| **RF que la vigilan** | RF-03, RF-36                                                                                                                   |

*Nota.* Tipo de regla: política. Elaboración propia.

**Tabla 67**  
*Ficha de la regla de negocio RN-04: Gestión de usuarios exclusiva del Administrador*

| **Código**            | **RN-04**                                                                              |
|-----------------------|----------------------------------------------------------------------------------------|
| **Enunciado**         | Solo el Administrador del sistema registra, consulta, actualiza e inactiva usuarios.   |
| **Origen**            | Criterios HU-02 CA-02.4; HU-03 CA-03.3; HU-25 CA-25.2. Fuente de la sección 1.7: D-02. |
| **RF que la vigilan** | RF-06                                                                                  |

*Nota.* Tipo de regla: seguridad. Elaboración propia.

**Tabla 68**  
*Ficha de la regla de negocio RN-05: Acceso limitado a las funciones del rol*

| **Código**            | **RN-05**                                                                              |
|-----------------------|----------------------------------------------------------------------------------------|
| **Enunciado**         | Cada rol solo usa las funciones que la matriz de permisos le autoriza.                 |
| **Origen**            | Criterios HU-01 CA-01.1; HU-03 CA-03.1, CA-03.2. Fuente de la sección 1.7: D-02; H-09. |
| **RF que la vigilan** | RF-01, RF-05, RF-06                                                                    |

*Nota.* Tipo de regla: seguridad. Elaboración propia.

**Tabla 69**  
*Ficha de la regla de negocio RN-06: Datos obligatorios completos*

| **Código**            | **RN-06**                                                                                                                                                                                                                                                                                                          |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Ninguna operación de registro, actualización, búsqueda por documento o verificación se ejecuta si falta un dato que el diccionario de datos marca como obligatorio.                                                                                                                                                |
| **Origen**            | Criterios HU-01 CA-01.3; HU-02 CA-02.3; HU-04 CA-04.2; HU-05 CA-05.2; HU-08 CA-08.3; HU-09 CA-09.2; HU-10 CA-10.2; HU-12 CA-12.3; HU-18 CA-18.3; HU-24 CA-24.2; HU-26 CA-26.3; HU-30 CA-30.4; HU-32 CA-32.3; HU-33 CA-33.3; HU-36 CA-36.2. Fuente de la sección 1.7: H-01 (27 % de datos incompletos o ilegibles). |
| **RF que la vigilan** | RF-01, RF-03, RF-07, RF-08, RF-11, RF-12, RF-13, RF-17, RF-25, RF-33, RF-36, RF-40, RF-42, RF-43, RF-45                                                                                                                                                                                                            |

*Nota.* Tipo de regla: validación. Elaboración propia.

**Tabla 70**  
*Ficha de la regla de negocio RN-07: Documento único en el censo*

| **Código**            | **RN-07**                                                                                                                                         |
|-----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Un mismo tipo y número de documento pertenece a una sola persona del censo, esté activa o inactiva, y una persona es integrante de un solo hogar. |
| **Origen**            | Criterios HU-06 CA-06.1, CA-06.2, CA-06.3; HU-09 CA-09.3; HU-11 CA-11.2. Fuente de la sección 1.7: H-01, H-02, H-11.                              |
| **RF que la vigilan** | RF-09, RF-16                                                                                                                                      |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 71**  
*Ficha de la regla de negocio RN-08: Formato del documento según su tipo*

| **Código**            | **RN-08**                                                                                                                                                    |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | El número de documento respeta el formato de su tipo: RC, TI, CC y CE solo admiten dígitos (entre 6 y 11); PA y PPT admiten letras y dígitos (entre 6 y 15). |
| **Origen**            | Criterios HU-05 CA-05.3; HU-09 CA-09.4. Fuente de la sección 1.7: H-03.                                                                                      |
| **RF que la vigilan** | RF-08, RF-12                                                                                                                                                 |

*Nota.* Tipo de regla: validación. Elaboración propia.

**Tabla 72**  
*Ficha de la regla de negocio RN-09: Todo integrante pertenece a un hogar registrado*

| **Código**            | **RN-09**                                                                                                             |
|-----------------------|-----------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Un integrante solo se registra dentro de un hogar ya registrado y activo.                                             |
| **Origen**            | Criterios HU-05 CA-05.1. Fuente de la sección 1.7: Marco conceptual (sección 1.5): el hogar es la unidad de registro. |
| **RF que la vigilan** | RF-08                                                                                                                 |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 73**  
*Ficha de la regla de negocio RN-10: Enfoque diferencial restringido a la lista*

| **Código**            | **RN-10**                                                                                                                                                       |
|-----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Las condiciones de enfoque diferencial son niño, adulto mayor, persona con discapacidad, gestante o minoría étnica; un integrante puede tener varias o ninguna. |
| **Origen**            | Criterios HU-07 CA-07.1, CA-07.2, CA-07.3. Fuente de la sección 1.7: H-06; D-04.                                                                                |
| **RF que la vigilan** | RF-10                                                                                                                                                           |

*Nota.* Tipo de regla: datos. Elaboración propia.

**Tabla 74**  
*Ficha de la regla de negocio RN-11: Capacidad máxima mayor que cero*

| **Código**            | **RN-11**                                                                        |
|-----------------------|----------------------------------------------------------------------------------|
| **Enunciado**         | La capacidad máxima de un albergue es un número entero mayor que cero.           |
| **Origen**            | Criterios HU-12 CA-12.1, CA-12.2; HU-30 CA-30.3. Fuente de la sección 1.7: D-04. |
| **RF que la vigilan** | RF-17, RF-40                                                                     |

*Nota.* Tipo de regla: validación. Elaboración propia.

**Tabla 75**  
*Ficha de la regla de negocio RN-12: Hogar censado para ser alojado*

| **Código**            | **RN-12**                                                     |
|-----------------------|---------------------------------------------------------------|
| **Enunciado**         | Solo un hogar registrado en el censo se asigna a un albergue. |
| **Origen**            | Criterios HU-13 CA-13.3. Fuente de la sección 1.7: H-06.      |
| **RF que la vigilan** | RF-18                                                         |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 76**  
*Ficha de la regla de negocio RN-13: Un hogar, un solo albergue a la vez*

| **Código**            | **RN-13**                                                                                                         |
|-----------------------|-------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Un hogar no está alojado en más de un albergue al mismo tiempo; después de su salida puede ser asignado de nuevo. |
| **Origen**            | Criterios HU-13 CA-13.4; HU-14 CA-14.3. Fuente de la sección 1.7: H-04.                                           |
| **RF que la vigilan** | RF-18                                                                                                             |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 77**  
*Ficha de la regla de negocio RN-14: Cada hogar ocupa tantos cupos como integrantes activos tiene*

| **Código**            | **RN-14**                                                                                                                                                                  |
|-----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | La ocupación de un albergue es la suma de los integrantes activos de los hogares alojados, y sus cupos disponibles son la capacidad máxima menos la ocupación.             |
| **Origen**            | Criterios HU-13 CA-13.1; HU-14 CA-14.1; HU-15 CA-15.1, CA-15.2, CA-15.3; HU-28 CA-28.2; HU-30 CA-30.1. Fuente de la sección 1.7: H-06 (47 % usa el número de integrantes). |
| **RF que la vigilan** | RF-18, RF-20, RF-21, RF-38, RF-40                                                                                                                                          |

*Nota.* Tipo de regla: operacional. Elaboración propia.

**Tabla 78**  
*Ficha de la regla de negocio RN-15: Prohibido el sobrecupo*

| **Código**            | **RN-15**                                                                                                        |
|-----------------------|------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | No se asigna un hogar a un albergue cuyos cupos disponibles sean menores que el número de integrantes del hogar. |
| **Origen**            | Criterios HU-13 CA-13.2. Fuente de la sección 1.7: H-04, H-06; D-04.                                             |
| **RF que la vigilan** | RF-19                                                                                                            |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 79**  
*Ficha de la regla de negocio RN-16: Salida solo desde el albergue donde está alojado*

| **Código**            | **RN-16**                                                                                                            |
|-----------------------|----------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | La salida de un hogar se registra únicamente en el albergue donde está alojado y por el Coordinador de ese albergue. |
| **Origen**            | Criterios HU-14 CA-14.2. Fuente de la sección 1.7: H-04.                                                             |
| **RF que la vigilan** | RF-20                                                                                                                |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 80**  
*Ficha de la regla de negocio RN-17: Cantidades positivas*

| **Código**            | **RN-17**                                                                        |
|-----------------------|----------------------------------------------------------------------------------|
| **Enunciado**         | La cantidad de una donación o de una entrega es un número entero mayor que cero. |
| **Origen**            | Criterios HU-16 CA-16.2; HU-19 CA-19.2. Fuente de la sección 1.7: H-05.          |
| **RF que la vigilan** | RF-22, RF-26                                                                     |

*Nota.* Tipo de regla: validación. Elaboración propia.

**Tabla 81**  
*Ficha de la regla de negocio RN-18: Toda donación registra su procedencia*

| **Código**            | **RN-18**                                                               |
|-----------------------|-------------------------------------------------------------------------|
| **Enunciado**         | Toda donación se registra con tipo de ayuda, cantidad y origen.         |
| **Origen**            | Criterios HU-16 CA-16.1, CA-16.3. Fuente de la sección 1.7: D-03; H-05. |
| **RF que la vigilan** | RF-22                                                                   |

*Nota.* Tipo de regla: política. Elaboración propia.

**Tabla 82**  
*Ficha de la regla de negocio RN-19: Un solo registro por tipo de ayuda*

| **Código**            | **RN-19**                                                                              |
|-----------------------|----------------------------------------------------------------------------------------|
| **Enunciado**         | No existen dos tipos de ayuda con el mismo nombre, estén activos o inactivos.          |
| **Origen**            | Criterios HU-16 CA-16.4; HU-32 CA-32.2; HU-33 CA-33.2. Fuente de la sección 1.7: H-05. |
| **RF que la vigilan** | RF-23, RF-42, RF-43                                                                    |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 83**  
*Ficha de la regla de negocio RN-20: Existencias iguales a lo recibido menos lo entregado*

| **Código**            | **RN-20**                                                                                                               |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Las existencias de un tipo de ayuda son la suma de sus donaciones menos la suma de sus entregas.                        |
| **Origen**            | Criterios HU-16 CA-16.1, CA-16.4; HU-17 CA-17.1, CA-17.2, CA-17.3; HU-20 CA-20.1. Fuente de la sección 1.7: H-05, H-11. |
| **RF que la vigilan** | RF-22, RF-23, RF-24, RF-27                                                                                              |

*Nota.* Tipo de regla: operacional. Elaboración propia.

**Tabla 84**  
*Ficha de la regla de negocio RN-21: Prohibido entregar más de lo disponible*

| **Código**            | **RN-21**                                                                                                 |
|-----------------------|-----------------------------------------------------------------------------------------------------------|
| **Enunciado**         | No se registra una entrega cuya cantidad supere las existencias del tipo de ayuda, ni de un tipo agotado. |
| **Origen**            | Criterios HU-20 CA-20.2, CA-20.3. Fuente de la sección 1.7: H-05, H-11.                                   |
| **RF que la vigilan** | RF-28                                                                                                     |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 85**  
*Ficha de la regla de negocio RN-22: Entrega solo a beneficiario verificado y censado*

| **Código**            | **RN-22**                                                                                                                    |
|-----------------------|------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Solo se entrega ayuda a una persona cuyo documento corresponde a un integrante censado y fue verificado antes de la entrega. |
| **Origen**            | Criterios HU-18 CA-18.1, CA-18.2; HU-19 CA-19.4. Fuente de la sección 1.7: H-03, H-09.                                       |
| **RF que la vigilan** | RF-25                                                                                                                        |

*Nota.* Tipo de regla: política. Elaboración propia.

**Tabla 86**  
*Ficha de la regla de negocio RN-23: Toda entrega es trazable*

| **Código**            | **RN-23**                                                                                                                  |
|-----------------------|----------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Toda entrega registra el beneficiario y su hogar, el tipo de ayuda, la cantidad, la fecha y hora y el usuario responsable. |
| **Origen**            | Criterios HU-19 CA-19.1, CA-19.3; HU-22 CA-22.1; HU-23 CA-23.1. Fuente de la sección 1.7: H-08; D-03.                      |
| **RF que la vigilan** | RF-26, RF-31, RF-32                                                                                                        |

*Nota.* Tipo de regla: política. Elaboración propia.

**Tabla 87**  
*Ficha de la regla de negocio RN-24: Firma del beneficiario para completar la entrega*

| **Código**            | **RN-24**                                                                                        |
|-----------------------|--------------------------------------------------------------------------------------------------|
| **Enunciado**         | Ninguna entrega se completa sin la firma digital del beneficiario.                               |
| **Origen**            | Criterios HU-21 CA-21.1, CA-21.2. Fuente de la sección 1.7: H-08 (70 % ya firma en papel); H-11. |
| **RF que la vigilan** | RF-29, RF-30                                                                                     |

*Nota.* Tipo de regla: política. Elaboración propia.

**Tabla 88**  
*Ficha de la regla de negocio RN-25: Validaciones idénticas sin conexión*

| **Código**            | **RN-25**                                                                                      |
|-----------------------|------------------------------------------------------------------------------------------------|
| **Enunciado**         | Los registros hechos sin conexión cumplen las mismas validaciones que los hechos con conexión. |
| **Origen**            | Criterios HU-10 CA-10.1, CA-10.2. Fuente de la sección 1.7: H-10.                              |
| **RF que la vigilan** | RF-13                                                                                          |

*Nota.* Tipo de regla: validación. Elaboración propia.

**Tabla 89**  
*Ficha de la regla de negocio RN-26: Sincronización sin pérdida ni duplicación*

| **Código**            | **RN-26**                                                                                                                                                        |
|-----------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Ninguna sincronización pierde ni duplica registros; un registro cuyo documento ya existe en el sistema central queda en conflicto para revisión del Funcionario. |
| **Origen**            | Criterios HU-11 CA-11.1, CA-11.2, CA-11.3. Fuente de la sección 1.7: H-10.                                                                                       |
| **RF que la vigilan** | RF-15, RF-16                                                                                                                                                     |

*Nota.* Tipo de regla: operacional. Elaboración propia.

**Tabla 90**  
*Ficha de la regla de negocio RN-27: Las bajas son inactivaciones*

| **Código**            | **RN-27**                                                                                                                                                                                                                              |
|-----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Ningún usuario, hogar, integrante, albergue, tipo de ayuda o voluntario se borra: se inactiva, deja de aparecer en los listados y conserva su registro y su historial.                                                                 |
| **Origen**            | Criterios HU-25 CA-25.1; HU-27 CA-27.1, CA-27.2; HU-28 CA-28.1, CA-28.2; HU-29 CA-29.1, CA-29.2; HU-31 CA-31.1, CA-31.2; HU-34 CA-34.1, CA-34.2; HU-35 CA-35.1; HU-37 CA-37.1, CA-37.2, CA-37.3. Fuente de la sección 1.7: D-03; D-08. |
| **RF que la vigilan** | RF-34, RF-35, RF-37, RF-38, RF-39, RF-41, RF-44, RF-46                                                                                                                                                                                 |

*Nota.* Tipo de regla: política. Elaboración propia.

**Tabla 91**  
*Ficha de la regla de negocio RN-28: Siempre un Administrador activo*

| **Código**            | **RN-28**                                                               |
|-----------------------|-------------------------------------------------------------------------|
| **Enunciado**         | Existe en todo momento al menos un Administrador del sistema activo.    |
| **Origen**            | Criterios HU-26 CA-26.4; HU-27 CA-27.4. Fuente de la sección 1.7: D-02. |
| **RF que la vigilan** | RF-36, RF-37                                                            |

*Nota.* Tipo de regla: seguridad. Elaboración propia.

**Tabla 92**  
*Ficha de la regla de negocio RN-29: Un hogar alojado no se inactiva*

| **Código**            | **RN-29**                                                                      |
|-----------------------|--------------------------------------------------------------------------------|
| **Enunciado**         | Un hogar alojado en un albergue no se inactiva; primero se registra su salida. |
| **Origen**            | Criterios HU-29 CA-29.4. Fuente de la sección 1.7: H-04.                       |
| **RF que la vigilan** | RF-39                                                                          |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 93**  
*Ficha de la regla de negocio RN-30: Todo hogar activo conserva un integrante activo*

| **Código**            | **RN-30**                                                                                                               |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Un hogar activo tiene al menos un integrante activo; el último integrante activo no se inactiva sin inactivar el hogar. |
| **Origen**            | Criterios HU-28 CA-28.4. Fuente de la sección 1.7: Marco conceptual (sección 1.5).                                      |
| **RF que la vigilan** | RF-38                                                                                                                   |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 94**  
*Ficha de la regla de negocio RN-31: Un albergue con hogares alojados no se inactiva*

| **Código**            | **RN-31**                                                                                      |
|-----------------------|------------------------------------------------------------------------------------------------|
| **Enunciado**         | Un albergue con hogares alojados no se inactiva; primero se registra la salida de todos ellos. |
| **Origen**            | Criterios HU-31 CA-31.4. Fuente de la sección 1.7: H-04.                                       |
| **RF que la vigilan** | RF-41                                                                                          |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 95**  
*Ficha de la regla de negocio RN-32: La capacidad no baja de la ocupación*

| **Código**            | **RN-32**                                                                          |
|-----------------------|------------------------------------------------------------------------------------|
| **Enunciado**         | La capacidad máxima de un albergue no se reduce por debajo de su ocupación actual. |
| **Origen**            | Criterios HU-30 CA-30.2. Fuente de la sección 1.7: D-04.                           |
| **RF que la vigilan** | RF-40                                                                              |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 96**  
*Ficha de la regla de negocio RN-33: Un tipo de ayuda con existencias no se inactiva*

| **Código**            | **RN-33**                                                         |
|-----------------------|-------------------------------------------------------------------|
| **Enunciado**         | Un tipo de ayuda con existencias mayores que cero no se inactiva. |
| **Origen**            | Criterios HU-34 CA-34.4. Fuente de la sección 1.7: D-03.          |
| **RF que la vigilan** | RF-44                                                             |

*Nota.* Tipo de regla: restricción. Elaboración propia.

**Tabla 97**  
*Ficha de la regla de negocio RN-34: Los registros inactivos no participan en operaciones nuevas*

| **Código**            | **RN-34**                                                                                                                                                                                                       |
|-----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Enunciado**         | Un usuario inactivo no inicia sesión; un hogar o un albergue inactivo no admite asignaciones; un integrante o un hogar inactivo no recibe entregas; un tipo de ayuda inactivo no admite donaciones ni entregas. |
| **Origen**            | Criterios HU-01 CA-01.5; HU-13 CA-13.5; HU-18 CA-18.4; HU-27 CA-27.2; HU-29 CA-29.2; HU-31 CA-31.2; HU-34 CA-34.2. Fuente de la sección 1.7: D-08.                                                              |
| **RF que la vigilan** | RF-01, RF-18, RF-25, RF-37, RF-39, RF-41, RF-44                                                                                                                                                                 |

*Nota.* Tipo de regla: política. Elaboración propia.

### 2.2.2 Requisitos funcionales

Los 46 requisitos funcionales formalizan los «RF derivados» de las fichas de historia. Todos empiezan con «El sistema debe», citan su historia de origen y la regla que hacen cumplir, no mencionan pantallas, botones ni tecnología, y los que implementan una baja se redactan como inactivar. La Tabla 98 los resume y las fichas individuales van de la Tabla 99 a la Tabla 144.

**Tabla 98**  
*Resumen de los requisitos funcionales*

| **RF** | **Nombre corto**                            | **HU de origen**    | **RN que hace cumplir**    | **Prioridad** |
|--------|---------------------------------------------|---------------------|----------------------------|---------------|
| RF-01  | Autenticar usuario                          | HU-01               | RN-01, RN-05, RN-06, RN-34 | Alta          |
| RF-02  | Exigir sesión iniciada                      | HU-01               | RN-01                      | Alta          |
| RF-03  | Registrar usuario y asignar rol             | HU-02               | RN-03, RN-06               | Alta          |
| RF-04  | Verificar nombre de usuario único           | HU-02, HU-26        | RN-02                      | Alta          |
| RF-05  | Ofrecer solo las funciones del rol          | HU-01, HU-03        | RN-01, RN-05               | Alta          |
| RF-06  | Denegar funciones no autorizadas            | HU-02, HU-03, HU-25 | RN-04, RN-05               | Alta          |
| RF-07  | Registrar hogar afectado                    | HU-04               | RN-06                      | Alta          |
| RF-08  | Registrar integrante del hogar              | HU-05               | RN-06, RN-08, RN-09        | Alta          |
| RF-09  | Verificar documento no duplicado            | HU-06, HU-09        | RN-07                      | Alta          |
| RF-10  | Registrar enfoque diferencial               | HU-07               | RN-10                      | Alta          |
| RF-11  | Consultar hogar por documento               | HU-04, HU-08        | RN-06                      | Alta          |
| RF-12  | Actualizar hogar o integrante               | HU-09               | RN-06, RN-08               | Media         |
| RF-13  | Registrar hogares sin conexión              | HU-10               | RN-06, RN-25               | Alta          |
| RF-14  | Informar estado de sincronización           | HU-10, HU-11        | Ninguna                    | Media         |
| RF-15  | Sincronizar registros pendientes            | HU-11               | RN-26                      | Alta          |
| RF-16  | Detectar conflictos de sincronización       | HU-11               | RN-07, RN-26               | Alta          |
| RF-17  | Registrar albergue temporal                 | HU-12               | RN-06, RN-11               | Alta          |
| RF-18  | Asignar hogar a albergue                    | HU-13, HU-14        | RN-12, RN-13, RN-14, RN-34 | Alta          |
| RF-19  | Verificar cupos suficientes                 | HU-13               | RN-15                      | Alta          |
| RF-20  | Registrar salida de un hogar                | HU-14               | RN-14, RN-16               | Alta          |
| RF-21  | Consultar ocupación y cupos                 | HU-15               | RN-14                      | Alta          |
| RF-22  | Registrar donación recibida                 | HU-16               | RN-17, RN-18, RN-20        | Alta          |
| RF-23  | Consolidar existencias por tipo de ayuda    | HU-16               | RN-19, RN-20               | Alta          |
| RF-24  | Consultar existencias del inventario        | HU-17               | RN-20                      | Alta          |
| RF-25  | Verificar identidad del beneficiario        | HU-18, HU-19        | RN-06, RN-22, RN-34        | Alta          |
| RF-26  | Registrar entrega de ayuda                  | HU-19               | RN-17, RN-23               | Alta          |
| RF-27  | Descontar existencias por entrega           | HU-20               | RN-20                      | Alta          |
| RF-28  | Verificar existencias suficientes           | HU-20               | RN-21                      | Alta          |
| RF-29  | Capturar firma digital del beneficiario     | HU-21               | RN-24                      | Alta          |
| RF-30  | Exigir firma para completar la entrega      | HU-21               | RN-24                      | Alta          |
| RF-31  | Consultar historial de entregas de un hogar | HU-22               | RN-23                      | Alta          |
| RF-32  | Consultar trazabilidad de un tipo de ayuda  | HU-23               | RN-23                      | Alta          |
| RF-33  | Registrar voluntario                        | HU-24               | RN-06                      | Media         |
| RF-34  | Consultar voluntarios                       | HU-35               | RN-27                      | Media         |
| RF-35  | Consultar usuarios                          | HU-25               | RN-27                      | Media         |
| RF-36  | Actualizar usuario                          | HU-26               | RN-03, RN-06, RN-28        | Media         |
| RF-37  | Inactivar usuario                           | HU-27               | RN-27, RN-28, RN-34        | Media         |
| RF-38  | Inactivar integrante                        | HU-28               | RN-14, RN-27, RN-30        | Media         |
| RF-39  | Inactivar hogar                             | HU-29               | RN-27, RN-29, RN-34        | Media         |
| RF-40  | Actualizar albergue                         | HU-30               | RN-06, RN-11, RN-14, RN-32 | Media         |
| RF-41  | Inactivar albergue                          | HU-31               | RN-27, RN-31, RN-34        | Media         |
| RF-42  | Registrar tipo de ayuda                     | HU-32               | RN-06, RN-19               | Alta          |
| RF-43  | Actualizar tipo de ayuda                    | HU-33               | RN-06, RN-19               | Baja          |
| RF-44  | Inactivar tipo de ayuda                     | HU-34               | RN-27, RN-33, RN-34        | Baja          |
| RF-45  | Actualizar voluntario                       | HU-36               | RN-06                      | Baja          |
| RF-46  | Inactivar voluntario                        | HU-37               | RN-27                      | Baja          |

*Nota.* Las relaciones se derivan de los criterios de aceptación de las fichas de historia. Elaboración propia.

**Tabla 99**  
*Ficha del requisito funcional RF-01: Autenticar usuario*

| **Código**              | **RF-01**                                                                                                                                                                                         |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Autenticar usuario                                                                                                                                                                                |
| **Descripción**         | El sistema debe autenticar al usuario registrado y activo con su nombre de usuario y su clave, y rechazar las credenciales incorrectas, incompletas o de un usuario inactivo indicando el motivo. |
| **HU de origen**        | HU-01 (CA-01.1, CA-01.2, CA-01.3, CA-01.5)                                                                                                                                                        |
| **RN que hace cumplir** | RN-01, RN-05, RN-06, RN-34                                                                                                                                                                        |
| **Prioridad**           | Alta                                                                                                                                                                                              |

*Nota.* Métodos que lo implementan: Usuario.autenticar(). Elaboración propia.

**Tabla 100**  
*Ficha del requisito funcional RF-02: Exigir sesión iniciada*

| **Código**              | **RF-02**                                                                                                                                       |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Exigir sesión iniciada                                                                                                                          |
| **Descripción**         | El sistema debe exigir una sesión iniciada para ejecutar cualquier función y, si no existe, solicitar la autenticación sin revelar información. |
| **HU de origen**        | HU-01 (CA-01.4)                                                                                                                                 |
| **RN que hace cumplir** | RN-01                                                                                                                                           |
| **Prioridad**           | Alta                                                                                                                                            |

*Nota.* Métodos que lo implementan: Usuario.autenticar(). Elaboración propia.

**Tabla 101**  
*Ficha del requisito funcional RF-03: Registrar usuario y asignar rol*

| **Código**              | **RF-03**                                                                                                                                                      |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar usuario y asignar rol                                                                                                                                |
| **Descripción**         | El sistema debe registrar un usuario con nombre completo, nombre de usuario, clave y uno de los tres roles, dejándolo activo y habilitado para iniciar sesión. |
| **HU de origen**        | HU-02 (CA-02.1, CA-02.3)                                                                                                                                       |
| **RN que hace cumplir** | RN-03, RN-06                                                                                                                                                   |
| **Prioridad**           | Alta                                                                                                                                                           |

*Nota.* Métodos que lo implementan: Usuario.crear(). Elaboración propia.

**Tabla 102**  
*Ficha del requisito funcional RF-04: Verificar nombre de usuario único*

| **Código**              | **RF-04**                                                                                                                                               |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Verificar nombre de usuario único                                                                                                                       |
| **Descripción**         | El sistema debe verificar, antes de registrar un usuario o de cambiar su nombre de usuario, que no exista otro usuario con ese mismo nombre de usuario. |
| **HU de origen**        | HU-02, HU-26 (CA-02.2, CA-26.2)                                                                                                                         |
| **RN que hace cumplir** | RN-02                                                                                                                                                   |
| **Prioridad**           | Alta                                                                                                                                                    |

*Nota.* Métodos que lo implementan: Usuario.existeNombreUsuario(). Elaboración propia.

**Tabla 103**  
*Ficha del requisito funcional RF-05: Ofrecer solo las funciones del rol*

| **Código**              | **RF-05**                                                                                                         |
|-------------------------|-------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Ofrecer solo las funciones del rol                                                                                |
| **Descripción**         | El sistema debe ofrecer a cada usuario únicamente las funciones autorizadas para su rol en la matriz de permisos. |
| **HU de origen**        | HU-01, HU-03 (CA-01.1, CA-03.1)                                                                                   |
| **RN que hace cumplir** | RN-01, RN-05                                                                                                      |
| **Prioridad**           | Alta                                                                                                              |

*Nota.* Métodos que lo implementan: Usuario.tienePermiso(). Elaboración propia.

**Tabla 104**  
*Ficha del requisito funcional RF-06: Denegar funciones no autorizadas*

| **Código**              | **RF-06**                                                                                                                                                |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Denegar funciones no autorizadas                                                                                                                         |
| **Descripción**         | El sistema debe denegar, informando que el acceso no está autorizado, la ejecución de cualquier función para la que el rol del usuario no tenga permiso. |
| **HU de origen**        | HU-02, HU-03, HU-25 (CA-02.4, CA-03.2, CA-03.3, CA-25.2)                                                                                                 |
| **RN que hace cumplir** | RN-04, RN-05                                                                                                                                             |
| **Prioridad**           | Alta                                                                                                                                                     |

*Nota.* Métodos que lo implementan: Usuario.tienePermiso(). Elaboración propia.

**Tabla 105**  
*Ficha del requisito funcional RF-07: Registrar hogar afectado*

| **Código**              | **RF-07**                                                                                                                                                                                              |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar hogar afectado                                                                                                                                                                               |
| **Descripción**         | El sistema debe registrar un hogar con dirección, barrio, municipio y teléfono de contacto (opcional), dejándolo activo con un identificador único, la fecha de registro y el usuario que lo registró. |
| **HU de origen**        | HU-04 (CA-04.1, CA-04.2)                                                                                                                                                                               |
| **RN que hace cumplir** | RN-06                                                                                                                                                                                                  |
| **Prioridad**           | Alta                                                                                                                                                                                                   |

*Nota.* Métodos que lo implementan: Hogar.crear(). Elaboración propia.

**Tabla 106**  
*Ficha del requisito funcional RF-08: Registrar integrante del hogar*

| **Código**              | **RF-08**                                                                                                                                                                                                  |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar integrante del hogar                                                                                                                                                                             |
| **Descripción**         | El sistema debe registrar un integrante en un hogar existente con tipo y número de documento, nombres, apellidos y fecha de nacimiento, dejándolo activo y actualizando el total de integrantes del hogar. |
| **HU de origen**        | HU-05 (CA-05.1, CA-05.2, CA-05.3)                                                                                                                                                                          |
| **RN que hace cumplir** | RN-06, RN-08, RN-09                                                                                                                                                                                        |
| **Prioridad**           | Alta                                                                                                                                                                                                       |

*Nota.* Métodos que lo implementan: Hogar.totalIntegrantes(), Integrante.crear(). Elaboración propia.

**Tabla 107**  
*Ficha del requisito funcional RF-09: Verificar documento no duplicado*

| **Código**              | **RF-09**                                                                                                                                                                                                                      |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Verificar documento no duplicado                                                                                                                                                                                               |
| **Descripción**         | El sistema debe verificar, antes de registrar un integrante o de cambiar su documento, que el tipo y el número de documento no pertenezcan a otra persona censada, activa o inactiva, e informar en qué hogar está registrada. |
| **HU de origen**        | HU-06, HU-09 (CA-06.1, CA-06.2, CA-06.3, CA-09.3)                                                                                                                                                                              |
| **RN que hace cumplir** | RN-07                                                                                                                                                                                                                          |
| **Prioridad**           | Alta                                                                                                                                                                                                                           |

*Nota.* Métodos que lo implementan: Integrante.existeDocumento(). Elaboración propia.

**Tabla 108**  
*Ficha del requisito funcional RF-10: Registrar enfoque diferencial*

| **Código**              | **RF-10**                                                                                                                                                               |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar enfoque diferencial                                                                                                                                           |
| **Descripción**         | El sistema debe asignar a un integrante ninguna, una o varias condiciones de enfoque diferencial de la lista definida y rechazar los valores que no pertenezcan a ella. |
| **HU de origen**        | HU-07 (CA-07.1, CA-07.2, CA-07.3)                                                                                                                                       |
| **RN que hace cumplir** | RN-10                                                                                                                                                                   |
| **Prioridad**           | Alta                                                                                                                                                                    |

*Nota.* Métodos que lo implementan: Integrante.asignarCondiciones(). Elaboración propia.

**Tabla 109**  
*Ficha del requisito funcional RF-11: Consultar hogar por documento*

| **Código**              | **RF-11**                                                                                                                                                                                                |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Consultar hogar por documento                                                                                                                                                                            |
| **Descripción**         | El sistema debe buscar un hogar activo por el documento de uno de sus integrantes y mostrar sus datos, sus integrantes activos, sus condiciones de enfoque diferencial y el albergue donde está alojado. |
| **HU de origen**        | HU-04, HU-08 (CA-04.3, CA-08.1, CA-08.2, CA-08.3)                                                                                                                                                        |
| **RN que hace cumplir** | RN-06                                                                                                                                                                                                    |
| **Prioridad**           | Alta                                                                                                                                                                                                     |

*Nota.* Métodos que lo implementan: Hogar.buscarPorDocumento(), AsignacionAlbergue.albergueActual(). Elaboración propia.

**Tabla 110**  
*Ficha del requisito funcional RF-12: Actualizar hogar o integrante*

| **Código**              | **RF-12**                                                                                                                                               |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Actualizar hogar o integrante                                                                                                                           |
| **Descripción**         | El sistema debe actualizar los datos de un hogar o de un integrante con valores válidos y conservar los valores anteriores cuando el cambio se rechaza. |
| **HU de origen**        | HU-09 (CA-09.1, CA-09.2, CA-09.4)                                                                                                                       |
| **RN que hace cumplir** | RN-06, RN-08                                                                                                                                            |
| **Prioridad**           | Media                                                                                                                                                   |

*Nota.* Métodos que lo implementan: Hogar.actualizar(), Integrante.actualizar(). Elaboración propia.

**Tabla 111**  
*Ficha del requisito funcional RF-13: Registrar hogares sin conexión*

| **Código**              | **RF-13**                                                                                                                                                                                                        |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar hogares sin conexión                                                                                                                                                                                   |
| **Descripción**         | El sistema debe guardar en el dispositivo, sin conexión, los hogares e integrantes con datos obligatorios válidos, dejándolos pendientes de sincronización y aplicando las mismas validaciones que con conexión. |
| **HU de origen**        | HU-10 (CA-10.1, CA-10.2)                                                                                                                                                                                         |
| **RN que hace cumplir** | RN-06, RN-25                                                                                                                                                                                                     |
| **Prioridad**           | Alta                                                                                                                                                                                                             |

*Nota.* Métodos que lo implementan: Hogar.guardarLocal(). Elaboración propia.

**Tabla 112**  
*Ficha del requisito funcional RF-14: Informar estado de sincronización*

| **Código**              | **RF-14**                                                                                                                                                                                             |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Informar estado de sincronización                                                                                                                                                                     |
| **Descripción**         | El sistema debe informar cuántos registros están pendientes de sincronización y, al terminar una sincronización, cuántos se sincronizaron, cuántos quedaron en conflicto y cuántos siguen pendientes. |
| **HU de origen**        | HU-10, HU-11 (CA-10.3, CA-11.4)                                                                                                                                                                       |
| **RN que hace cumplir** | Ninguna                                                                                                                                                                                               |
| **Prioridad**           | Media                                                                                                                                                                                                 |

*Nota.* Métodos que lo implementan: Hogar.contarPorEstado(). Elaboración propia.

**Tabla 113**  
*Ficha del requisito funcional RF-15: Sincronizar registros pendientes*

| **Código**              | **RF-15**                                                                                                                                                                                             |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Sincronizar registros pendientes                                                                                                                                                                      |
| **Descripción**         | El sistema debe enviar al sistema central los registros pendientes cuando se recupere la conexión, cambiándolos a estado sincronizado, sin perder ni duplicar registros si la conexión se interrumpe. |
| **HU de origen**        | HU-11 (CA-11.1, CA-11.3)                                                                                                                                                                              |
| **RN que hace cumplir** | RN-26                                                                                                                                                                                                 |
| **Prioridad**           | Alta                                                                                                                                                                                                  |

*Nota.* Métodos que lo implementan: Hogar.sincronizarPendientes(). Elaboración propia.

**Tabla 114**  
*Ficha del requisito funcional RF-16: Detectar conflictos de sincronización*

| **Código**              | **RF-16**                                                                                                                                                                                                |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Detectar conflictos de sincronización                                                                                                                                                                    |
| **Descripción**         | El sistema debe detectar, durante la sincronización, los registros cuyo documento ya existe en el sistema central, no crear el duplicado, dejarlos en estado de conflicto e informarlo para su revisión. |
| **HU de origen**        | HU-11 (CA-11.2)                                                                                                                                                                                          |
| **RN que hace cumplir** | RN-07, RN-26                                                                                                                                                                                             |
| **Prioridad**           | Alta                                                                                                                                                                                                     |

*Nota.* Métodos que lo implementan: Hogar.sincronizarPendientes(), Integrante.existeDocumento(). Elaboración propia.

**Tabla 115**  
*Ficha del requisito funcional RF-17: Registrar albergue temporal*

| **Código**              | **RF-17**                                                                                                                                                         |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar albergue temporal                                                                                                                                       |
| **Descripción**         | El sistema debe registrar un albergue con nombre, dirección, municipio y una capacidad máxima mayor que cero, dejándolo activo y con todos sus cupos disponibles. |
| **HU de origen**        | HU-12 (CA-12.1, CA-12.2, CA-12.3)                                                                                                                                 |
| **RN que hace cumplir** | RN-06, RN-11                                                                                                                                                      |
| **Prioridad**           | Alta                                                                                                                                                              |

*Nota.* Métodos que lo implementan: Albergue.crear(). Elaboración propia.

**Tabla 116**  
*Ficha del requisito funcional RF-18: Asignar hogar a albergue*

| **Código**              | **RF-18**                                                                                                                                                                     |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Asignar hogar a albergue                                                                                                                                                      |
| **Descripción**         | El sistema debe asignar un hogar censado, activo y sin albergue a un albergue activo, aumentando la ocupación y disminuyendo los cupos en el número de integrantes del hogar. |
| **HU de origen**        | HU-13, HU-14 (CA-13.1, CA-13.3, CA-13.4, CA-13.5, CA-14.3)                                                                                                                    |
| **RN que hace cumplir** | RN-12, RN-13, RN-14, RN-34                                                                                                                                                    |
| **Prioridad**           | Alta                                                                                                                                                                          |

*Nota.* Métodos que lo implementan: Hogar.totalIntegrantes(), AsignacionAlbergue.asignar(), AsignacionAlbergue.albergueActual(). Elaboración propia.

**Tabla 117**  
*Ficha del requisito funcional RF-19: Verificar cupos suficientes*

| **Código**              | **RF-19**                                                                                                                                                                                                                                |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Verificar cupos suficientes                                                                                                                                                                                                              |
| **Descripción**         | El sistema debe verificar, antes de asignar un hogar, que los cupos disponibles del albergue sean iguales o mayores que el número de integrantes del hogar, y rechazar la asignación informando los cupos disponibles cuando no lo sean. |
| **HU de origen**        | HU-13 (CA-13.2)                                                                                                                                                                                                                          |
| **RN que hace cumplir** | RN-15                                                                                                                                                                                                                                    |
| **Prioridad**           | Alta                                                                                                                                                                                                                                     |

*Nota.* Métodos que lo implementan: Albergue.cuposDisponibles(). Elaboración propia.

**Tabla 118**  
*Ficha del requisito funcional RF-20: Registrar salida de un hogar*

| **Código**              | **RF-20**                                                                                                                                  |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar salida de un hogar                                                                                                               |
| **Descripción**         | El sistema debe registrar la salida de un hogar del albergue donde está alojado, dejándolo sin albergue y liberando los cupos que ocupaba. |
| **HU de origen**        | HU-14 (CA-14.1, CA-14.2)                                                                                                                   |
| **RN que hace cumplir** | RN-14, RN-16                                                                                                                               |
| **Prioridad**           | Alta                                                                                                                                       |

*Nota.* Métodos que lo implementan: AsignacionAlbergue.registrarSalida(). Elaboración propia.

**Tabla 119**  
*Ficha del requisito funcional RF-21: Consultar ocupación y cupos*

| **Código**              | **RF-21**                                                                                                                                                                                                   |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Consultar ocupación y cupos                                                                                                                                                                                 |
| **Descripción**         | El sistema debe informar por cada albergue activo su capacidad, su ocupación actual y sus cupos disponibles, reflejando de inmediato cada asignación y cada salida e identificando los albergues sin cupos. |
| **HU de origen**        | HU-15 (CA-15.1, CA-15.2, CA-15.3, CA-15.4)                                                                                                                                                                  |
| **RN que hace cumplir** | RN-14                                                                                                                                                                                                       |
| **Prioridad**           | Alta                                                                                                                                                                                                        |

*Nota.* Métodos que lo implementan: Albergue.listarActivos(), Albergue.ocupacionActual(), Albergue.cuposDisponibles(). Elaboración propia.

**Tabla 120**  
*Ficha del requisito funcional RF-22: Registrar donación recibida*

| **Código**              | **RF-22**                                                                                                                                                 |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar donación recibida                                                                                                                               |
| **Descripción**         | El sistema debe registrar una donación con tipo de ayuda, cantidad mayor que cero y origen, guardando la fecha de recepción y el usuario que la registró. |
| **HU de origen**        | HU-16 (CA-16.1, CA-16.2, CA-16.3)                                                                                                                         |
| **RN que hace cumplir** | RN-17, RN-18, RN-20                                                                                                                                       |
| **Prioridad**           | Alta                                                                                                                                                      |

*Nota.* Métodos que lo implementan: Donacion.registrar(). Elaboración propia.

**Tabla 121**  
*Ficha del requisito funcional RF-23: Consolidar existencias por tipo de ayuda*

| **Código**              | **RF-23**                                                                                                             |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Consolidar existencias por tipo de ayuda                                                                              |
| **Descripción**         | El sistema debe mantener un único registro por tipo de ayuda y acumular en sus existencias cada donación de ese tipo. |
| **HU de origen**        | HU-16 (CA-16.4)                                                                                                       |
| **RN que hace cumplir** | RN-19, RN-20                                                                                                          |
| **Prioridad**           | Alta                                                                                                                  |

*Nota.* Métodos que lo implementan: TipoAyuda.existeNombre(), Donacion.registrar(). Elaboración propia.

**Tabla 122**  
*Ficha del requisito funcional RF-24: Consultar existencias del inventario*

| **Código**              | **RF-24**                                                                                                                                                          |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Consultar existencias del inventario                                                                                                                               |
| **Descripción**         | El sistema debe informar por cada tipo de ayuda activo sus existencias actuales, calculadas como lo recibido menos lo entregado, e identificar los tipos agotados. |
| **HU de origen**        | HU-17 (CA-17.1, CA-17.2, CA-17.3, CA-17.4)                                                                                                                         |
| **RN que hace cumplir** | RN-20                                                                                                                                                              |
| **Prioridad**           | Alta                                                                                                                                                               |

*Nota.* Métodos que lo implementan: TipoAyuda.listarActivos(), TipoAyuda.existencias(). Elaboración propia.

**Tabla 123**  
*Ficha del requisito funcional RF-25: Verificar identidad del beneficiario*

| **Código**              | **RF-25**                                                                                                                                                                                                         |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Verificar identidad del beneficiario                                                                                                                                                                              |
| **Descripción**         | El sistema debe verificar que el documento ingresado al iniciar una entrega corresponda a un integrante activo de un hogar activo, identificar a la persona y a su hogar y habilitar la entrega solo en ese caso. |
| **HU de origen**        | HU-18, HU-19 (CA-18.1, CA-18.2, CA-18.3, CA-18.4, CA-19.4)                                                                                                                                                        |
| **RN que hace cumplir** | RN-06, RN-22, RN-34                                                                                                                                                                                               |
| **Prioridad**           | Alta                                                                                                                                                                                                              |

*Nota.* Métodos que lo implementan: Integrante.buscarPorDocumento(). Elaboración propia.

**Tabla 124**  
*Ficha del requisito funcional RF-26: Registrar entrega de ayuda*

| **Código**              | **RF-26**                                                                                                                                                                                                                  |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar entrega de ayuda                                                                                                                                                                                                 |
| **Descripción**         | El sistema debe registrar la entrega de un tipo de ayuda y una cantidad mayor que cero a un beneficiario verificado, guardando el beneficiario y su hogar, el tipo, la cantidad, la fecha y hora y el usuario responsable. |
| **HU de origen**        | HU-19 (CA-19.1, CA-19.2, CA-19.3)                                                                                                                                                                                          |
| **RN que hace cumplir** | RN-17, RN-23                                                                                                                                                                                                               |
| **Prioridad**           | Alta                                                                                                                                                                                                                       |

*Nota.* Métodos que lo implementan: Entrega.registrar(). Elaboración propia.

**Tabla 125**  
*Ficha del requisito funcional RF-27: Descontar existencias por entrega*

| **Código**              | **RF-27**                                                                                                              |
|-------------------------|------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Descontar existencias por entrega                                                                                      |
| **Descripción**         | El sistema debe descontar automáticamente de las existencias del tipo de ayuda la cantidad de cada entrega registrada. |
| **HU de origen**        | HU-20 (CA-20.1)                                                                                                        |
| **RN que hace cumplir** | RN-20                                                                                                                  |
| **Prioridad**           | Alta                                                                                                                   |

*Nota.* Métodos que lo implementan: TipoAyuda.existencias(), Entrega.registrar(). Elaboración propia.

**Tabla 126**  
*Ficha del requisito funcional RF-28: Verificar existencias suficientes*

| **Código**              | **RF-28**                                                                                                                                                                                            |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Verificar existencias suficientes                                                                                                                                                                    |
| **Descripción**         | El sistema debe rechazar la entrega, sin modificar las existencias, cuando la cantidad supere las existencias del tipo de ayuda o este se encuentre agotado, informando las existencias disponibles. |
| **HU de origen**        | HU-20 (CA-20.2, CA-20.3)                                                                                                                                                                             |
| **RN que hace cumplir** | RN-21                                                                                                                                                                                                |
| **Prioridad**           | Alta                                                                                                                                                                                                 |

*Nota.* Métodos que lo implementan: TipoAyuda.hayExistencias(). Elaboración propia.

**Tabla 127**  
*Ficha del requisito funcional RF-29: Capturar firma digital del beneficiario*

| **Código**              | **RF-29**                                                                                                                 |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Capturar firma digital del beneficiario                                                                                   |
| **Descripción**         | El sistema debe capturar la firma digital del beneficiario, asociarla a la entrega y presentarla al consultar la entrega. |
| **HU de origen**        | HU-21 (CA-21.1)                                                                                                           |
| **RN que hace cumplir** | RN-24                                                                                                                     |
| **Prioridad**           | Alta                                                                                                                      |

*Nota.* Métodos que lo implementan: Entrega.capturarFirma(). Elaboración propia.

**Tabla 128**  
*Ficha del requisito funcional RF-30: Exigir firma para completar la entrega*

| **Código**              | **RF-30**                                                                                  |
|-------------------------|--------------------------------------------------------------------------------------------|
| **Nombre corto**        | Exigir firma para completar la entrega                                                     |
| **Descripción**         | El sistema debe impedir que una entrega se complete sin la firma digital del beneficiario. |
| **HU de origen**        | HU-21 (CA-21.2)                                                                            |
| **RN que hace cumplir** | RN-24                                                                                      |
| **Prioridad**           | Alta                                                                                       |

*Nota.* Métodos que lo implementan: Entrega.capturarFirma(). Elaboración propia.

**Tabla 129**  
*Ficha del requisito funcional RF-31: Consultar historial de entregas de un hogar*

| **Código**              | **RF-31**                                                                                                                                              |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Consultar historial de entregas de un hogar                                                                                                            |
| **Descripción**         | El sistema debe presentar en orden cronológico las entregas de un hogar con fecha y hora, tipo de ayuda, cantidad, beneficiario y usuario responsable. |
| **HU de origen**        | HU-22 (CA-22.1, CA-22.2, CA-22.3)                                                                                                                      |
| **RN que hace cumplir** | RN-23                                                                                                                                                  |
| **Prioridad**           | Alta                                                                                                                                                   |

*Nota.* Métodos que lo implementan: Entrega.listarPorHogar(). Elaboración propia.

**Tabla 130**  
*Ficha del requisito funcional RF-32: Consultar trazabilidad de un tipo de ayuda*

| **Código**              | **RF-32**                                                                                                                                                                               |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Consultar trazabilidad de un tipo de ayuda                                                                                                                                              |
| **Descripción**         | El sistema debe presentar, por tipo de ayuda, sus donaciones (origen, fecha y cantidad), sus entregas (fecha, hogar, beneficiario, responsable y cantidad) y sus existencias restantes. |
| **HU de origen**        | HU-23 (CA-23.1, CA-23.2, CA-23.3)                                                                                                                                                       |
| **RN que hace cumplir** | RN-23                                                                                                                                                                                   |
| **Prioridad**           | Alta                                                                                                                                                                                    |

*Nota.* Métodos que lo implementan: Donacion.listarPorTipo(), Entrega.listarPorTipo(). Elaboración propia.

**Tabla 131**  
*Ficha del requisito funcional RF-33: Registrar voluntario*

| **Código**              | **RF-33**                                                                                                                |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar voluntario                                                                                                     |
| **Descripción**         | El sistema debe registrar un voluntario con tipo y número de documento, nombres, apellidos y teléfono, dejándolo activo. |
| **HU de origen**        | HU-24 (CA-24.1, CA-24.2)                                                                                                 |
| **RN que hace cumplir** | RN-06                                                                                                                    |
| **Prioridad**           | Media                                                                                                                    |

*Nota.* Métodos que lo implementan: Voluntario.crear(). Elaboración propia.

**Tabla 132**  
*Ficha del requisito funcional RF-34: Consultar voluntarios*

| **Código**              | **RF-34**                                                                                                              |
|-------------------------|------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Consultar voluntarios                                                                                                  |
| **Descripción**         | El sistema debe listar los voluntarios activos ordenados por apellido con su documento, nombres, apellidos y teléfono. |
| **HU de origen**        | HU-35 (CA-35.1, CA-35.2)                                                                                               |
| **RN que hace cumplir** | RN-27                                                                                                                  |
| **Prioridad**           | Media                                                                                                                  |

*Nota.* Métodos que lo implementan: Voluntario.listarActivos(). Elaboración propia.

**Tabla 133**  
*Ficha del requisito funcional RF-35: Consultar usuarios*

| **Código**              | **RF-35**                                                                                                         |
|-------------------------|-------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Consultar usuarios                                                                                                |
| **Descripción**         | El sistema debe listar los usuarios activos ordenados por nombre con su nombre completo, nombre de usuario y rol. |
| **HU de origen**        | HU-25 (CA-25.1)                                                                                                   |
| **RN que hace cumplir** | RN-27                                                                                                             |
| **Prioridad**           | Media                                                                                                             |

*Nota.* Métodos que lo implementan: Usuario.listarActivos(). Elaboración propia.

**Tabla 134**  
*Ficha del requisito funcional RF-36: Actualizar usuario*

| **Código**              | **RF-36**                                                                                                                      |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Actualizar usuario                                                                                                             |
| **Descripción**         | El sistema debe actualizar los datos y el rol de un usuario, conservando siempre al menos un Administrador del sistema activo. |
| **HU de origen**        | HU-26 (CA-26.1, CA-26.3, CA-26.4)                                                                                              |
| **RN que hace cumplir** | RN-03, RN-06, RN-28                                                                                                            |
| **Prioridad**           | Media                                                                                                                          |

*Nota.* Métodos que lo implementan: Usuario.actualizar(). Elaboración propia.

**Tabla 135**  
*Ficha del requisito funcional RF-37: Inactivar usuario*

| **Código**              | **RF-37**                                                                                                                                                                                            |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Inactivar usuario                                                                                                                                                                                    |
| **Descripción**         | El sistema debe inactivar un usuario cambiando su estado a inactivo y conservando su registro y las operaciones que realizó; un usuario inactivo no aparece en los listados ni puede iniciar sesión. |
| **HU de origen**        | HU-27 (CA-27.1, CA-27.2, CA-27.3, CA-27.4)                                                                                                                                                           |
| **RN que hace cumplir** | RN-27, RN-28, RN-34                                                                                                                                                                                  |
| **Prioridad**           | Media                                                                                                                                                                                                |

*Nota.* Métodos que lo implementan: Usuario.inactivar(). Elaboración propia.

**Tabla 136**  
*Ficha del requisito funcional RF-38: Inactivar integrante*

| **Código**              | **RF-38**                                                                                                                                                                                            |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Inactivar integrante                                                                                                                                                                                 |
| **Descripción**         | El sistema debe inactivar un integrante cambiando su estado a inactivo y conservando su registro y sus entregas; un integrante inactivo deja de contarse en el hogar y en la ocupación del albergue. |
| **HU de origen**        | HU-28 (CA-28.1, CA-28.2, CA-28.3, CA-28.4)                                                                                                                                                           |
| **RN que hace cumplir** | RN-14, RN-27, RN-30                                                                                                                                                                                  |
| **Prioridad**           | Media                                                                                                                                                                                                |

*Nota.* Métodos que lo implementan: Integrante.inactivar(). Elaboración propia.

**Tabla 137**  
*Ficha del requisito funcional RF-39: Inactivar hogar*

| **Código**              | **RF-39**                                                                                                                                                                                                                                   |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Inactivar hogar                                                                                                                                                                                                                             |
| **Descripción**         | El sistema debe inactivar un hogar que no esté alojado cambiando su estado a inactivo y conservando sus datos, sus integrantes y su historial de entregas; un hogar inactivo no aparece en las búsquedas ni admite asignaciones o entregas. |
| **HU de origen**        | HU-29 (CA-29.1, CA-29.2, CA-29.3, CA-29.4)                                                                                                                                                                                                  |
| **RN que hace cumplir** | RN-27, RN-29, RN-34                                                                                                                                                                                                                         |
| **Prioridad**           | Media                                                                                                                                                                                                                                       |

*Nota.* Métodos que lo implementan: Hogar.inactivar(), AsignacionAlbergue.albergueActual(). Elaboración propia.

**Tabla 138**  
*Ficha del requisito funcional RF-40: Actualizar albergue*

| **Código**              | **RF-40**                                                                                                                            |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Actualizar albergue                                                                                                                  |
| **Descripción**         | El sistema debe actualizar los datos y la capacidad máxima de un albergue, sin permitir una capacidad menor que su ocupación actual. |
| **HU de origen**        | HU-30 (CA-30.1, CA-30.2, CA-30.3, CA-30.4)                                                                                           |
| **RN que hace cumplir** | RN-06, RN-11, RN-14, RN-32                                                                                                           |
| **Prioridad**           | Media                                                                                                                                |

*Nota.* Métodos que lo implementan: Albergue.actualizar(). Elaboración propia.

**Tabla 139**  
*Ficha del requisito funcional RF-41: Inactivar albergue*

| **Código**              | **RF-41**                                                                                                                                                                                                                 |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Inactivar albergue                                                                                                                                                                                                        |
| **Descripción**         | El sistema debe inactivar un albergue sin hogares alojados cambiando su estado a inactivo y conservando su historial de asignaciones; un albergue inactivo no aparece en la consulta de ocupación ni admite asignaciones. |
| **HU de origen**        | HU-31 (CA-31.1, CA-31.2, CA-31.3, CA-31.4)                                                                                                                                                                                |
| **RN que hace cumplir** | RN-27, RN-31, RN-34                                                                                                                                                                                                       |
| **Prioridad**           | Media                                                                                                                                                                                                                     |

*Nota.* Métodos que lo implementan: Albergue.ocupacionActual(), Albergue.inactivar(). Elaboración propia.

**Tabla 140**  
*Ficha del requisito funcional RF-42: Registrar tipo de ayuda*

| **Código**              | **RF-42**                                                                                                                |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Registrar tipo de ayuda                                                                                                  |
| **Descripción**         | El sistema debe registrar un tipo de ayuda con nombre único y unidad de medida, dejándolo activo y con cero existencias. |
| **HU de origen**        | HU-32 (CA-32.1, CA-32.2, CA-32.3)                                                                                        |
| **RN que hace cumplir** | RN-06, RN-19                                                                                                             |
| **Prioridad**           | Alta                                                                                                                     |

*Nota.* Métodos que lo implementan: TipoAyuda.crear(), TipoAyuda.existeNombre(). Elaboración propia.

**Tabla 141**  
*Ficha del requisito funcional RF-43: Actualizar tipo de ayuda*

| **Código**              | **RF-43**                                                                                                                                   |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Actualizar tipo de ayuda                                                                                                                    |
| **Descripción**         | El sistema debe actualizar el nombre y la unidad de medida de un tipo de ayuda, conservando sus donaciones, sus entregas y sus existencias. |
| **HU de origen**        | HU-33 (CA-33.1, CA-33.2, CA-33.3)                                                                                                           |
| **RN que hace cumplir** | RN-06, RN-19                                                                                                                                |
| **Prioridad**           | Baja                                                                                                                                        |

*Nota.* Métodos que lo implementan: TipoAyuda.existeNombre(), TipoAyuda.actualizar(). Elaboración propia.

**Tabla 142**  
*Ficha del requisito funcional RF-44: Inactivar tipo de ayuda*

| **Código**              | **RF-44**                                                                                                                                                                                                  |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Inactivar tipo de ayuda                                                                                                                                                                                    |
| **Descripción**         | El sistema debe inactivar un tipo de ayuda sin existencias cambiando su estado a inactivo y conservando sus donaciones, sus entregas y su trazabilidad; un tipo inactivo no admite donaciones ni entregas. |
| **HU de origen**        | HU-34 (CA-34.1, CA-34.2, CA-34.3, CA-34.4)                                                                                                                                                                 |
| **RN que hace cumplir** | RN-27, RN-33, RN-34                                                                                                                                                                                        |
| **Prioridad**           | Baja                                                                                                                                                                                                       |

*Nota.* Métodos que lo implementan: TipoAyuda.existencias(), TipoAyuda.inactivar(). Elaboración propia.

**Tabla 143**  
*Ficha del requisito funcional RF-45: Actualizar voluntario*

| **Código**              | **RF-45**                                                                                                                        |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Actualizar voluntario                                                                                                            |
| **Descripción**         | El sistema debe actualizar los datos de un voluntario registrado y conservar los valores anteriores cuando el cambio se rechaza. |
| **HU de origen**        | HU-36 (CA-36.1, CA-36.2)                                                                                                         |
| **RN que hace cumplir** | RN-06                                                                                                                            |
| **Prioridad**           | Baja                                                                                                                             |

*Nota.* Métodos que lo implementan: Voluntario.actualizar(). Elaboración propia.

**Tabla 144**  
*Ficha del requisito funcional RF-46: Inactivar voluntario*

| **Código**              | **RF-46**                                                                                                                                        |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nombre corto**        | Inactivar voluntario                                                                                                                             |
| **Descripción**         | El sistema debe inactivar un voluntario cambiando su estado a inactivo y conservando sus datos; un voluntario inactivo no aparece en el listado. |
| **HU de origen**        | HU-37 (CA-37.1, CA-37.2, CA-37.3)                                                                                                                |
| **RN que hace cumplir** | RN-27                                                                                                                                            |
| **Prioridad**           | Baja                                                                                                                                             |

*Nota.* Métodos que lo implementan: Voluntario.inactivar(). Elaboración propia.

### 2.2.3 Requisitos no funcionales

Los 9 requisitos no funcionales tienen una categoría de calidad (International Organization for Standardization, 2011) y un enunciado con una medida verificable. Las medidas son metas propuestas por el equipo a partir de los hallazgos de la sección 1.7 y se confirmarán con los interesados en la Fase 2. Las fichas van de la Tabla 145 a la Tabla 153.

**Tabla 145**  
*Ficha del requisito no funcional RNF-01: Seguridad*

| **Código**                 | **RNF-01**                                                                                                                                                                                                                                        |
|----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Seguridad                                                                                                                                                                                                                                         |
| **Enunciado con medida**   | El 100 % de las funciones del sistema exige una sesión iniciada; la sesión se cierra automáticamente después de 15 minutos sin actividad, y en la prueba de la matriz de permisos (14 funciones por 3 roles) el número de accesos indebidos es 0. |
| **Origen**                 | RN-01, RN-05; HU-01 CA-01.4, HU-03; fuente D-02; hallazgo H-09                                                                                                                                                                                    |
| **Método de verificación** | Prueba                                                                                                                                                                                                                                            |

*Nota.* Elaboración propia.

**Tabla 146**  
*Ficha del requisito no funcional RNF-02: Protección de datos personales*

| **Código**                 | **RNF-02**                                                                                                                                                                                                                                                         |
|----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Protección de datos personales                                                                                                                                                                                                                                     |
| **Enunciado con medida**   | El 100 % de los datos personales (documento, nombres, dirección, teléfono y firma) es visible solo para usuarios con sesión iniciada y rol autorizado, y el 100 % de las claves se almacena cifrado de forma irreversible, en cumplimiento de la Ley 1581 de 2012. |
| **Origen**                 | Supuestos de la sección 1.2; fuente D-02                                                                                                                                                                                                                           |
| **Método de verificación** | Inspección y prueba                                                                                                                                                                                                                                                |

*Nota.* Elaboración propia.

**Tabla 147**  
*Ficha del requisito no funcional RNF-03: Trazabilidad*

| **Código**                 | **RNF-03**                                                                                                                                                                                                                                   |
|----------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Trazabilidad                                                                                                                                                                                                                                 |
| **Enunciado con medida**   | El 100 % de los registros de hogares, asignaciones, salidas, donaciones y entregas guarda el usuario responsable y la fecha y hora con precisión de un segundo, y el 100 % de las bajas se resuelve por inactivación (0 registros borrados). |
| **Origen**                 | RN-23, RN-27; HU-19 CA-19.1; fuente D-03; hallazgo H-08                                                                                                                                                                                      |
| **Método de verificación** | Inspección y prueba                                                                                                                                                                                                                          |

*Nota.* Elaboración propia.

**Tabla 148**  
*Ficha del requisito no funcional RNF-04: Integridad*

| **Código**                 | **RNF-04**                                                                                                                                                                                                                                              |
|----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Integridad                                                                                                                                                                                                                                              |
| **Enunciado con medida**   | En el 100 % de los casos de prueba, incluidos dos registros simultáneos, existen 0 personas con documento duplicado, las existencias de cada tipo de ayuda coinciden con las donaciones menos las entregas (diferencia 0) y nunca son menores que cero. |
| **Origen**                 | RN-07, RN-20, RN-21; HU-06, HU-20; hallazgos H-02 y H-05                                                                                                                                                                                                |
| **Método de verificación** | Prueba                                                                                                                                                                                                                                                  |

*Nota.* Elaboración propia.

**Tabla 149**  
*Ficha del requisito no funcional RNF-05: Disponibilidad sin conexión*

| **Código**                 | **RNF-05**                                                                                                                                                                            |
|----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Disponibilidad sin conexión                                                                                                                                                           |
| **Enunciado con medida**   | El registro de hogares e integrantes funciona sin conexión a internet durante al menos 72 horas continuas y conserva en el dispositivo al menos 500 registros pendientes sin pérdida. |
| **Origen**                 | RN-25; HU-10; hallazgo H-10 (73 % sin conectividad estable)                                                                                                                           |
| **Método de verificación** | Prueba                                                                                                                                                                                |

*Nota.* Elaboración propia.

**Tabla 150**  
*Ficha del requisito no funcional RNF-06: Confiabilidad de la sincronización*

| **Código**                 | **RNF-06**                                                                                                                                                                                             |
|----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Confiabilidad de la sincronización                                                                                                                                                                     |
| **Enunciado con medida**   | Después de 3 interrupciones forzadas de la conexión durante una sincronización de 100 registros, el 100 % de los registros queda sincronizado o en conflicto, con 0 registros perdidos y 0 duplicados. |
| **Origen**                 | RN-26; HU-11 CA-11.3; hallazgo H-10                                                                                                                                                                    |
| **Método de verificación** | Prueba                                                                                                                                                                                                 |

*Nota.* Elaboración propia.

**Tabla 151**  
*Ficha del requisito no funcional RNF-07: Compatibilidad*

| **Código**                 | **RNF-07**                                                                                                                                                                                                                                     |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Compatibilidad                                                                                                                                                                                                                                 |
| **Enunciado con medida**   | El sistema se usa sin instalación desde el navegador de un teléfono móvil con pantalla de 360 píxeles de ancho o más, y el 100 % de las funciones opera en las dos versiones más recientes de al menos dos navegadores móviles de uso general. |
| **Origen**                 | Alcance y supuestos de la sección 1.2; hallazgo H-10                                                                                                                                                                                           |
| **Método de verificación** | Demostración                                                                                                                                                                                                                                   |

*Nota.* Elaboración propia.

**Tabla 152**  
*Ficha del requisito no funcional RNF-08: Usabilidad*

| **Código**                 | **RNF-08**                                                                                                                                                                 |
|----------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Usabilidad                                                                                                                                                                 |
| **Enunciado con medida**   | El 100 % de los mensajes de rechazo indica el dato afectado y la corrección esperada, y un Funcionario capacitado registra un hogar de 4 integrantes en 5 minutos o menos. |
| **Origen**                 | CA de rechazo de todas las HU; hallazgos H-01 (22 % señala falta de personal o de tiempo) y H-07                                                                           |
| **Método de verificación** | Prueba con usuarios                                                                                                                                                        |

*Nota.* Elaboración propia.

**Tabla 153**  
*Ficha del requisito no funcional RNF-09: Rendimiento*

| **Código**                 | **RNF-09**                                                                                                                                                                                              |
|----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Categoría**              | Rendimiento                                                                                                                                                                                             |
| **Enunciado con medida**   | La búsqueda de un hogar por documento responde en 2 segundos o menos con 50.000 integrantes registrados, y la consulta de ocupación y la de existencias reflejan cada movimiento en 5 segundos o menos. |
| **Origen**                 | HU-08, HU-15 CA-15.2, HU-17 CA-17.2; hallazgos H-04 y H-07                                                                                                                                              |
| **Método de verificación** | Prueba                                                                                                                                                                                                  |

*Nota.* Elaboración propia.
