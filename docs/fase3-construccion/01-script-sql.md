> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 4.1 Script SQL (DDL)

El archivo albergues_ddl.sql, en la raíz del repositorio, crea la base de datos albergues para MySQL 8 con sus 10 tablas. No se escribió a mano: se genera desde el diccionario de datos (sección 1.8.1), por lo que cada columna, llave y restricción coincide con el modelo relacional de la sección 3.1. Las llaves foráneas no borran en cascada (RN-27) y las restricciones UNIQUE y CHECK hacen cumplir en la base de datos las reglas RN-02, RN-07, RN-11, RN-17 y RN-19. El archivo datos_iniciales.sql agrega un albergue y tres usuarios de prueba, uno por rol.

La Tabla 191 muestra las pruebas del script: cada una intenta una operación que una regla de negocio prohíbe, o una válida, y verifica la respuesta de la base de datos.

**Tabla 191**  
*Pruebas del script SQL contra las reglas de negocio*

| **Operación intentada**                    | **Respuesta** | **Resultado** |
|--------------------------------------------|---------------|---------------|
| Documento repetido en el censo (RN-07)     | Rechazado     | Correcto      |
| Nombre de usuario repetido (RN-02)         | Rechazado     | Correcto      |
| Tipo de ayuda repetido (RN-19)             | Rechazado     | Correcto      |
| Albergue con capacidad cero (RN-11)        | Rechazado     | Correcto      |
| Donación con cantidad cero (RN-17)         | Rechazado     | Correcto      |
| Integrante en un hogar inexistente (RN-09) | Rechazado     | Correcto      |
| Borrar un hogar con integrantes (RN-27)    | Rechazado     | Correcto      |
| Donación válida                            | Aceptado      | Correcto      |
| Entrega válida con firma                   | Aceptado      | Correcto      |
| Entrega sin firma (RN-24)                  | Rechazado     | Correcto      |

*Nota.* Se ejecutaron sobre el script traducido a SQLite y, con las pruebas del código, sobre H2 en modo MySQL; la sintaxis MySQL se verificó con un analizador SQL. Elaboración propia.
