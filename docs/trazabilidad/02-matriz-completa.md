> Versión 1.2 (12 de noviembre de 2026). Las tablas y figuras conservan la numeración del documento Word de docs/entregas.

## 3.7 Matriz de trazabilidad completa

La Tabla 188 es la matriz de trazabilidad que pide la ruta del curso: HU → RF → entidad → clase.método → CU → mensaje de secuencia → pantalla. Tiene una fila por cada método que implementa una historia (73 filas para 37 historias). La columna de secuencia indica el diagrama y el número del mensaje; «—» significa que el caso de uso no es crítico y no tiene diagrama de secuencia, y «Dentro de otro mensaje» que el método se ejecuta dentro de otro método del modelo.

**Tabla 188**  
*Matriz de trazabilidad HU → RF → entidad → clase.método → CU → mensaje de secuencia → pantalla*

| **HU** | **RF**       | **Entidad**                                 | **Clase.método**                     | **CU**       | **Mensaje (DS)**       | **Pantalla**        |
|--------|--------------|---------------------------------------------|--------------------------------------|--------------|------------------------|---------------------|
| HU-01  | RF-01, RF-02 | USUARIO                                     | Usuario.autenticar()                 | CU-01        | —                      | MK-12               |
| HU-01  | RF-05        | USUARIO                                     | Usuario.tienePermiso()               | CU-01        | —                      | MK-12               |
| HU-02  | RF-03        | USUARIO                                     | Usuario.crear()                      | CU-02        | —                      | MK-08               |
| HU-02  | RF-04        | USUARIO                                     | Usuario.existeNombreUsuario()        | CU-02        | —                      | MK-08               |
| HU-02  | RF-06        | USUARIO                                     | Usuario.tienePermiso()               | CU-02        | —                      | MK-12               |
| HU-03  | RF-05, RF-06 | USUARIO                                     | Usuario.tienePermiso()               | CU-01        | —                      | MK-12               |
| HU-04  | RF-07        | HOGAR                                       | Hogar.crear()                        | CU-03        | —                      | MK-01               |
| HU-04  | RF-11        | HOGAR, INTEGRANTE                           | Hogar.buscarPorDocumento()           | CU-03        | —                      | MK-01               |
| HU-05  | RF-08        | INTEGRANTE                                  | Integrante.crear()                   | CU-04        | DS-04: 12              | MK-02               |
| HU-05  | RF-08        | HOGAR, INTEGRANTE                           | Hogar.totalIntegrantes()             | CU-04        | DS-04: 16              | MK-02               |
| HU-06  | RF-09        | INTEGRANTE                                  | Integrante.existeDocumento()         | CU-04, CU-06 | DS-04: 4               | MK-02               |
| HU-07  | RF-10        | INTEGRANTE_CONDICION                        | Integrante.asignarCondiciones()      | CU-05        | —                      | MK-02               |
| HU-08  | RF-11        | HOGAR, INTEGRANTE                           | Hogar.buscarPorDocumento()           | CU-07        | —                      | MK-01               |
| HU-08  | RF-11        | ASIGNACION_ALBERGUE, ALBERGUE               | AsignacionAlbergue.albergueActual()  | CU-07        | —                      | MK-01, MK-04, MK-07 |
| HU-09  | RF-12        | HOGAR                                       | Hogar.actualizar()                   | CU-06, CU-08 | —                      | MK-01               |
| HU-09  | RF-12        | INTEGRANTE                                  | Integrante.actualizar()              | CU-06, CU-08 | —                      | MK-02               |
| HU-09  | RF-09        | INTEGRANTE                                  | Integrante.existeDocumento()         | CU-06, CU-08 | —                      | MK-02               |
| HU-10  | RF-13        | HOGAR, INTEGRANTE (copia en el dispositivo) | Hogar.guardarLocal()                 | CU-09        | —                      | MK-03               |
| HU-10  | RF-14        | HOGAR (copia en el dispositivo)             | Hogar.contarPorEstado()              | CU-09        | —                      | MK-03               |
| HU-11  | RF-15, RF-16 | HOGAR, INTEGRANTE                           | Hogar.sincronizarPendientes()        | CU-10        | DS-10: 2               | MK-03               |
| HU-11  | RF-16        | INTEGRANTE                                  | Integrante.existeDocumento()         | CU-10        | DS-10: 5               | MK-02               |
| HU-11  | RF-14        | HOGAR (copia en el dispositivo)             | Hogar.contarPorEstado()              | CU-10        | DS-10: 14              | MK-03               |
| HU-12  | RF-17        | ALBERGUE                                    | Albergue.crear()                     | CU-11        | —                      | MK-09               |
| HU-13  | RF-18        | ASIGNACION_ALBERGUE                         | AsignacionAlbergue.asignar()         | CU-12        | DS-12: 19              | MK-04               |
| HU-13  | RF-18        | HOGAR, INTEGRANTE                           | Hogar.totalIntegrantes()             | CU-12        | DS-12: 14              | MK-04               |
| HU-13  | RF-19        | ALBERGUE, ASIGNACION_ALBERGUE, INTEGRANTE   | Albergue.cuposDisponibles()          | CU-12        | DS-12: 6, 16           | MK-04, MK-09        |
| HU-13  | RF-18        | ASIGNACION_ALBERGUE, ALBERGUE               | AsignacionAlbergue.albergueActual()  | CU-12        | DS-12: 10              | MK-01, MK-04, MK-07 |
| HU-14  | RF-20        | ASIGNACION_ALBERGUE                         | AsignacionAlbergue.registrarSalida() | CU-13        | —                      | MK-09               |
| HU-14  | RF-18        | ASIGNACION_ALBERGUE                         | AsignacionAlbergue.asignar()         | CU-13        | —                      | MK-04               |
| HU-15  | RF-21        | ALBERGUE                                    | Albergue.listarActivos()             | CU-14        | —                      | MK-04, MK-09        |
| HU-15  | RF-21        | ALBERGUE, ASIGNACION_ALBERGUE, INTEGRANTE   | Albergue.ocupacionActual()           | CU-14        | —                      | MK-04, MK-09        |
| HU-15  | RF-21        | ALBERGUE, ASIGNACION_ALBERGUE, INTEGRANTE   | Albergue.cuposDisponibles()          | CU-14        | —                      | MK-04, MK-09        |
| HU-16  | RF-22, RF-23 | DONACION                                    | Donacion.registrar()                 | CU-15        | DS-15: 10              | MK-05               |
| HU-16  | RF-22, RF-23 | TIPO_AYUDA, DONACION, ENTREGA               | TipoAyuda.existencias()              | CU-15        | DS-15: 12              | MK-05, MK-10        |
| HU-16  | RF-23        | TIPO_AYUDA                                  | TipoAyuda.existeNombre()             | CU-15        | Dentro de otro mensaje | MK-10               |
| HU-17  | RF-24        | TIPO_AYUDA                                  | TipoAyuda.listarActivos()            | CU-16        | —                      | MK-10               |
| HU-17  | RF-24        | TIPO_AYUDA, DONACION, ENTREGA               | TipoAyuda.existencias()              | CU-16        | —                      | MK-05, MK-10        |
| HU-18  | RF-25        | INTEGRANTE, HOGAR                           | Integrante.buscarPorDocumento()      | CU-17        | —                      | MK-06               |
| HU-19  | RF-26        | ENTREGA                                     | Entrega.registrar()                  | CU-18        | DS-18: 24              | MK-06               |
| HU-19  | RF-25        | INTEGRANTE, HOGAR                           | Integrante.buscarPorDocumento()      | CU-18        | DS-18: 4               | MK-06               |
| HU-20  | RF-27        | ENTREGA                                     | Entrega.registrar()                  | CU-18        | DS-18: 24              | MK-06               |
| HU-20  | RF-27        | TIPO_AYUDA, DONACION, ENTREGA               | TipoAyuda.existencias()              | CU-18        | DS-18: 13              | MK-05, MK-10        |
| HU-20  | RF-28        | TIPO_AYUDA, DONACION, ENTREGA               | TipoAyuda.hayExistencias()           | CU-18        | DS-18: 12              | MK-06               |
| HU-21  | RF-29, RF-30 | ENTREGA                                     | Entrega.capturarFirma()              | CU-19        | —                      | MK-06               |
| HU-22  | RF-31        | ENTREGA                                     | Entrega.listarPorHogar()             | CU-20        | —                      | MK-01               |
| HU-22  | RF-31        | HOGAR, INTEGRANTE                           | Hogar.buscarPorDocumento()           | CU-20        | —                      | MK-01               |
| HU-23  | RF-32        | DONACION                                    | Donacion.listarPorTipo()             | CU-21        | —                      | MK-10               |
| HU-23  | RF-32        | ENTREGA                                     | Entrega.listarPorTipo()              | CU-21        | —                      | MK-10               |
| HU-23  | RF-32        | TIPO_AYUDA, DONACION, ENTREGA               | TipoAyuda.existencias()              | CU-21        | —                      | MK-05, MK-10        |
| HU-24  | RF-33        | VOLUNTARIO                                  | Voluntario.crear()                   | CU-22        | —                      | MK-11               |
| HU-25  | RF-35        | USUARIO                                     | Usuario.listarActivos()              | CU-24        | —                      | MK-08               |
| HU-25  | RF-06        | USUARIO                                     | Usuario.tienePermiso()               | CU-24        | —                      | MK-12               |
| HU-26  | RF-36        | USUARIO                                     | Usuario.actualizar()                 | CU-25        | —                      | MK-08               |
| HU-26  | RF-04        | USUARIO                                     | Usuario.existeNombreUsuario()        | CU-25        | —                      | MK-08               |
| HU-27  | RF-37        | USUARIO                                     | Usuario.inactivar()                  | CU-26        | —                      | MK-08               |
| HU-28  | RF-38        | INTEGRANTE                                  | Integrante.inactivar()               | CU-27        | —                      | MK-01               |
| HU-28  | RF-38        | HOGAR, INTEGRANTE                           | Hogar.totalIntegrantes()             | CU-27        | —                      | MK-01               |
| HU-29  | RF-39        | HOGAR                                       | Hogar.inactivar()                    | CU-28        | DS-28: 10              | MK-01, MK-07        |
| HU-29  | RF-39        | ASIGNACION_ALBERGUE, ALBERGUE               | AsignacionAlbergue.albergueActual()  | CU-28        | DS-28: 3               | MK-01, MK-04, MK-07 |
| HU-30  | RF-40        | ALBERGUE                                    | Albergue.actualizar()                | CU-29        | —                      | MK-09               |
| HU-30  | RF-40        | ALBERGUE, ASIGNACION_ALBERGUE, INTEGRANTE   | Albergue.cuposDisponibles()          | CU-29        | —                      | MK-04, MK-09        |
| HU-30  | RF-40        | ALBERGUE, ASIGNACION_ALBERGUE, INTEGRANTE   | Albergue.ocupacionActual()           | CU-29        | —                      | MK-04, MK-09        |
| HU-31  | RF-41        | ALBERGUE                                    | Albergue.inactivar()                 | CU-30        | —                      | MK-07, MK-09        |
| HU-31  | RF-41        | ALBERGUE, ASIGNACION_ALBERGUE, INTEGRANTE   | Albergue.ocupacionActual()           | CU-30        | —                      | MK-04, MK-09        |
| HU-32  | RF-42        | TIPO_AYUDA                                  | TipoAyuda.crear()                    | CU-31        | —                      | MK-10               |
| HU-32  | RF-42        | TIPO_AYUDA                                  | TipoAyuda.existeNombre()             | CU-31        | —                      | MK-10               |
| HU-33  | RF-43        | TIPO_AYUDA                                  | TipoAyuda.actualizar()               | CU-32        | —                      | MK-10               |
| HU-33  | RF-43        | TIPO_AYUDA                                  | TipoAyuda.existeNombre()             | CU-32        | —                      | MK-10               |
| HU-34  | RF-44        | TIPO_AYUDA                                  | TipoAyuda.inactivar()                | CU-33        | —                      | MK-10               |
| HU-34  | RF-44        | TIPO_AYUDA, DONACION, ENTREGA               | TipoAyuda.existencias()              | CU-33        | —                      | MK-05, MK-10        |
| HU-35  | RF-34        | VOLUNTARIO                                  | Voluntario.listarActivos()           | CU-23        | —                      | MK-11               |
| HU-36  | RF-45        | VOLUNTARIO                                  | Voluntario.actualizar()              | CU-34        | —                      | MK-11               |
| HU-37  | RF-46        | VOLUNTARIO                                  | Voluntario.inactivar()               | CU-35        | —                      | MK-11               |

*Nota.* DS = diagrama de secuencia de la sección 3.5. Los números son los de la numeración automática del diagrama. Elaboración propia.

Lectura de la matriz: 19 de las 73 filas llegan hasta un mensaje numerado de un diagrama de secuencia; todas las filas llegan a una pantalla, y todos los métodos del diagrama de clases aparecen al menos una vez. Las filas sin diagrama de secuencia pertenecen a casos de uso de registro o consulta directos, cuyo recorrido es el de la columna Pantalla (sección 2.5.1).
