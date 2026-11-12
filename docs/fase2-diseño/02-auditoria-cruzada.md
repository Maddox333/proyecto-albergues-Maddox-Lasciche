> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 3.2 Auditoría cruzada diccionario ↔ MER ↔ clases

La auditoría cruzada (paso 7b de la ruta) compara los tres modelos atributo por atributo. Para cada tabla verifica que cada atributo simple del diccionario exista en la clase con su nombre en notación camelCase, y que cada llave foránea esté dibujada como relación en el MER y como asociación en el diagrama de clases, tantas veces como llaves haya hacia la misma tabla. La Tabla 182 presenta el resultado.

La primera ejecución encontró un hallazgo: ASIGNACION_ALBERGUE tiene dos llaves foráneas hacia USUARIO (quién asigna y quién registra la salida), pero el MER y el diagrama de clases solo dibujaban la primera. Se corrigió mediante la solicitud de cambio CRF-02 (sección 5.3) y las figuras de la sección 1.8 ya incluyen la relación «registra salida». Con la corrección, las diez tablas coinciden.

**Tabla 182**  
*Resultado de la auditoría cruzada diccionario ↔ MER ↔ clases*

| **Tabla**            | **Diccionario** | **Clase**                                            | **Llaves foráneas → MER y asociaciones**                                                           | **Resultado** |
|----------------------|-----------------|------------------------------------------------------|----------------------------------------------------------------------------------------------------|---------------|
| USUARIO              | 7 atributos     | Usuario: 6 atributos                                 | id_albergue → ALBERGUE                                                                             | Coincide      |
| HOGAR                | 9 atributos     | Hogar: 8 atributos                                   | id_usuario_registro → USUARIO                                                                      | Coincide      |
| INTEGRANTE           | 8 atributos     | Integrante: 8 atributos                              | id_hogar → HOGAR                                                                                   | Coincide      |
| INTEGRANTE_CONDICION | 2 atributos     | Integrante.condiciones: List\<CondicionDiferencial\> | INTEGRANTE \|\|--o{ INTEGRANTE_CONDICION                                                           | Coincide      |
| ALBERGUE             | 6 atributos     | Albergue: 6 atributos                                | Sin llaves foráneas                                                                                | Coincide      |
| ASIGNACION_ALBERGUE  | 7 atributos     | AsignacionAlbergue: 3 atributos                      | id_hogar → HOGAR; id_albergue → ALBERGUE; id_usuario_asigna → USUARIO; id_usuario_salida → USUARIO | Coincide      |
| TIPO_AYUDA           | 4 atributos     | TipoAyuda: 4 atributos                               | Sin llaves foráneas                                                                                | Coincide      |
| DONACION             | 6 atributos     | Donacion: 4 atributos                                | id_tipo_ayuda → TIPO_AYUDA; id_usuario_registro → USUARIO                                          | Coincide      |
| ENTREGA              | 7 atributos     | Entrega: 4 atributos                                 | id_integrante → INTEGRANTE; id_tipo_ayuda → TIPO_AYUDA; id_usuario_responsable → USUARIO           | Coincide      |
| VOLUNTARIO           | 8 atributos     | Voluntario: 7 atributos                              | id_usuario_registro → USUARIO                                                                      | Coincide      |

*Nota.* Las llaves foráneas no se repiten como atributos de la clase: se expresan como asociaciones (sección 1.8.3). INTEGRANTE_CONDICION se representa como el atributo multivaluado condiciones de Integrante. Elaboración propia.
