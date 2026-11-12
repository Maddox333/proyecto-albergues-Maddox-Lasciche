> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 3.1 Modelo relacional

El modelo relacional se derivó en retroceso desde el diccionario de datos: cada tabla del diccionario es una relación, cada atributo es una columna con el mismo nombre y cada llave foránea es una referencia a la llave primaria de otra tabla. Por eso el modelo relacional, el MER de la Figura 6 y el script SQL no pueden diferir del diccionario. La Tabla 179 presenta las diez relaciones, la Tabla 180 las llaves foráneas y la Tabla 181 las restricciones que hacen cumplir reglas de negocio en la propia base de datos.

**Tabla 179**  
*Modelo relacional del sistema*

| **Relación**         | **Atributos (la llave primaria en negrita)**                                                                                                                                |
|----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| USUARIO              | **id_usuario** (PK), nombre_completo, nombre_usuario, clave_hash, rol, id_albergue (FK → ALBERGUE), activo                                                                  |
| HOGAR                | **id_hogar** (PK), direccion, barrio, municipio, telefono_contacto, fecha_registro, estado_sincronizacion, id_usuario_registro (FK → USUARIO), activo                       |
| INTEGRANTE           | **id_integrante** (PK), id_hogar (FK → HOGAR), tipo_documento, numero_documento, nombres, apellidos, fecha_nacimiento, activo                                               |
| INTEGRANTE_CONDICION | **id_integrante** (PK, FK → INTEGRANTE), **condicion** (PK)                                                                                                                 |
| ALBERGUE             | **id_albergue** (PK), nombre, direccion, municipio, capacidad_maxima, activo                                                                                                |
| ASIGNACION_ALBERGUE  | **id_asignacion** (PK), id_hogar (FK → HOGAR), id_albergue (FK → ALBERGUE), fecha_ingreso, fecha_salida, id_usuario_asigna (FK → USUARIO), id_usuario_salida (FK → USUARIO) |
| TIPO_AYUDA           | **id_tipo_ayuda** (PK), nombre, unidad_medida, activo                                                                                                                       |
| DONACION             | **id_donacion** (PK), id_tipo_ayuda (FK → TIPO_AYUDA), cantidad, origen, fecha_recepcion, id_usuario_registro (FK → USUARIO)                                                |
| ENTREGA              | **id_entrega** (PK), id_integrante (FK → INTEGRANTE), id_tipo_ayuda (FK → TIPO_AYUDA), cantidad, fecha_hora, firma_beneficiario, id_usuario_responsable (FK → USUARIO)      |
| VOLUNTARIO           | **id_voluntario** (PK), tipo_documento, numero_documento, nombres, apellidos, telefono, id_usuario_registro (FK → USUARIO), activo                                          |

*Nota.* PK = llave primaria; FK = llave foránea. Los tipos de cada atributo están en el diccionario de datos (sección 1.8.1). Elaboración propia.

**Tabla 180**  
*Llaves foráneas del modelo relacional*

| **Tabla**            | **Columna**            | **Referencia**           | **Nulo** | **Al borrar**       |
|----------------------|------------------------|--------------------------|----------|---------------------|
| USUARIO              | id_albergue            | ALBERGUE.id_albergue     | Sí       | Restringido (RN-27) |
| HOGAR                | id_usuario_registro    | USUARIO.id_usuario       | No       | Restringido (RN-27) |
| INTEGRANTE           | id_hogar               | HOGAR.id_hogar           | No       | Restringido (RN-27) |
| INTEGRANTE_CONDICION | id_integrante          | INTEGRANTE.id_integrante | No       | Restringido (RN-27) |
| ASIGNACION_ALBERGUE  | id_hogar               | HOGAR.id_hogar           | No       | Restringido (RN-27) |
| ASIGNACION_ALBERGUE  | id_albergue            | ALBERGUE.id_albergue     | No       | Restringido (RN-27) |
| ASIGNACION_ALBERGUE  | id_usuario_asigna      | USUARIO.id_usuario       | No       | Restringido (RN-27) |
| ASIGNACION_ALBERGUE  | id_usuario_salida      | USUARIO.id_usuario       | Sí       | Restringido (RN-27) |
| DONACION             | id_tipo_ayuda          | TIPO_AYUDA.id_tipo_ayuda | No       | Restringido (RN-27) |
| DONACION             | id_usuario_registro    | USUARIO.id_usuario       | No       | Restringido (RN-27) |
| ENTREGA              | id_integrante          | INTEGRANTE.id_integrante | No       | Restringido (RN-27) |
| ENTREGA              | id_tipo_ayuda          | TIPO_AYUDA.id_tipo_ayuda | No       | Restringido (RN-27) |
| ENTREGA              | id_usuario_responsable | USUARIO.id_usuario       | No       | Restringido (RN-27) |
| VOLUNTARIO           | id_usuario_registro    | USUARIO.id_usuario       | No       | Restringido (RN-27) |

*Nota.* Ninguna llave foránea borra en cascada: las bajas son inactivaciones (RN-27). Elaboración propia.

**Tabla 181**  
*Restricciones que hacen cumplir reglas de negocio en la base de datos*

| **Tabla**                   | **Restricción**                                 | **Regla** |
|-----------------------------|-------------------------------------------------|-----------|
| USUARIO                     | UNIQUE (nombre_usuario)                         | RN-02     |
| INTEGRANTE                  | UNIQUE (tipo_documento, numero_documento)       | RN-07     |
| TIPO_AYUDA                  | UNIQUE (nombre)                                 | RN-19     |
| ALBERGUE                    | CHECK (capacidad_maxima \> 0)                   | RN-11     |
| DONACION                    | CHECK (cantidad \> 0)                           | RN-17     |
| ENTREGA                     | CHECK (cantidad \> 0)                           | RN-17     |
| Todas las tablas con activo | DEFAULT TRUE                                    | RN-27     |
| HOGAR                       | DEFAULT 'SINCRONIZADO' en estado_sincronizacion | RN-26     |

*Nota.* Las demás reglas necesitan comparar datos de varias tablas (cupos, existencias, estados activos) y las verifica el modelo (decisión DA-05). Elaboración propia.
