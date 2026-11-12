-- Datos iniciales para probar el primer corte vertical (CU-01, CU-03, CU-04 a CU-07).
-- Ejecutar después de albergues_ddl.sql. Clave de los tres usuarios de prueba: Albergues2026
-- (solo para el entorno de pruebas; cámbiela antes de cualquier uso real).
USE albergues;

INSERT INTO ALBERGUE (nombre, direccion, municipio, capacidad_maxima)
VALUES ('Coliseo Villatina', 'Calle 56 # 17-20', 'Medellín', 120);

INSERT INTO USUARIO (nombre_completo, nombre_usuario, clave_hash, rol, id_albergue) VALUES
 ('Laura Restrepo', 'lrestrepo', 'pbkdf2$120000$VsaJbmYvsRzxiYrEd2Hl2A==$7In36CunxAKJfxebxXhSK0t8cmsFsY+fxu89PjqWu5w=', 'FUNCIONARIO', NULL),
 ('Andrés Ríos', 'arios', 'pbkdf2$120000$eExQCTg92Fa/nZ2w8AuxXA==$cUUiPoCehL1YMK5tjC6wHzy7diBToV0ekemC3pV6r6I=', 'COORDINADOR', 1),
 ('Administrador del sistema', 'admin', 'pbkdf2$120000$F2C+KBMDb7G7STWQjd9bJw==$H5KTN/2IXrJNMdhtbSU+KWyUP7MseNSiItaNDmmNN1o=', 'ADMINISTRADOR', NULL);
