> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 4.4 Instalación y ejecución

Para ejecutar el corte se necesita Java 21, Maven y MySQL 8. Los pasos son:

> • Crear la base de datos: ejecutar albergues_ddl.sql y luego datos_iniciales.sql en MySQL.
>
> • Ajustar usuario y clave de MySQL en src/main/resources/albergues.properties, o en las variables de entorno ALBERGUES_DB_URL, ALBERGUES_DB_USUARIO y ALBERGUES_DB_CLAVE.
>
> • Ejecutar las pruebas con «mvn test» (no necesitan MySQL: usan H2).
>
> • Iniciar la aplicación con «mvn compile exec:java» y abrir http://localhost:8080/ en el navegador.
>
> • Ingresar con el usuario lrestrepo (Funcionario) o arios (Coordinador); la clave de prueba está en datos_iniciales.sql.
