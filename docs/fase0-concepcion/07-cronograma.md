> Versión 0.2 (entrega parcial de octubre de 2026). Se corrige en las semanas 13 y 14; ver BITACORA.md.

**0.5 Cronograma de trabajo**

A continuación se detalla el desglose de actividades, estimación de horas y distribución por semanas para el desarrollo de la Fase 0 a la Fase 3 del semestre:

| **\#** | **Actividad**                                             | **Horas** | **Semana(s)** | **Acumulado** |
|--------|-----------------------------------------------------------|-----------|---------------|---------------|
| 1      | 0.1 Descripción del problema y alcance                    | 8,73      | 1             | 8,7           |
| 2      | 0.2 Objetivo general y específicos                        | 8,73      | 1–2           | 17,5          |
| 3      | 0.3 Estado del arte y marco teórico                       | 8,73      | 2–3           | 26,2          |
| 4      | 0.4 Recolección de información y metodología (entrevista) | 8,73      | 3             | 34,9          |
| 5      | 0.5 Cronograma de trabajo                                 | 8,73      | 3–4           | 43,6          |
| 6      | 1\. HU + criterios de aceptación                          | 8,73      | 4–5           | 52,4          |
| 7      | 2\. RF + RN + RNF                                         | 8,73      | 5–6           | 61,1          |
| 8      | 3\. Casos de uso (general + 4 a 6 críticos)               | 8,73      | 6             | 69,8          |
| 9      | 4\. Mockups (UI/UX)                                       | 8,73      | 6–7           | 78,5          |
| 10     | 5\. Diccionario de datos (3FN)                            | 8,73      | 7–8           | 87,3          |
| 11     | 6\. MER / modelo relacional                               | 8,73      | 8             | 96,0          |
| 12     | 7\. Diagrama de clases                                    | 8,73      | 9             | 104,7         |
| 13     | 7b. Auditoría cruzada (diccionario ↔ MER ↔ clases)        | 8,73      | 9–10          | 113,5         |
| 14     | 8\. Diagrama de actividades                               | 8,73      | 10–11         | 122,2         |
| 15     | 9\. DDA (MVC + paquetes)                                  | 8,73      | 11            | 130,9         |
| 16     | 10\. Diagramas de secuencia                               | 8,73      | 11–12         | 139,6         |
| 17     | 11\. Diagrama de estados                                  | 8,73      | 12–13         | 148,4         |
| 18     | 12\. Matriz de trazabilidad                               | 8,73      | 13–14         | 157,1         |
| 19     | 12b. Lectura cruzada entre equipos                        | 8,73      | 14            | 165,8         |
| 20     | 13\. Script SQL (DDL)                                     | 8,73      | 14–15         | 174,5         |
| 21     | 14\. Repositorio Git + .gitignore + script (GCS)          | 8,73      | 15–16         | 183,3         |
| 22     | 15\. Código MVC (vertical slice primero)                  | 8,73      | 16            | 192,0         |

**Resumen y Vista por Fase**

| **Fase**                  | **Actividades** | **Horas Total** | **Semanas**                    |
|---------------------------|-----------------|-----------------|--------------------------------|
| Fase 0: Concepción        | 5               | 43,6            | 1–4                            |
| Fase 1: Análisis          | 4               | 34,9            | 4–7                            |
| Fase 2: Diseño            | 10              | 87,3            | 7–14                           |
| **Compuerta M2 (Puerta)** | **-**           | **0**           | **Semana 14 (entre 12b y 13)** |
| Fase 3: Construcción      | 3               | 26,2            | 14–16                          |

# Historias de Usuario, Criterios de Aceptación y Requisitos Proyecto: Sistema de información para la gestión de albergues, censo de familias afectadas y trazabilidad de ayudas humanitarias en emergencias — caso Valle de Aburrá

Etapa: Fase 1 — Análisis y especificación (HU + CA + RF + RN + RNF)

**Etapa:** Fase 1 — Análisis (HU + Criterios de Aceptación)

**Fuentes:** Documento Fase 0 del proyecto (única fuente de contenido). Los ejemplos de la entidad PERSONA se usaron solo como molde de estructura, formato y nivel de detalle; ninguna de sus funcionalidades se trasladó al proyecto.

**Nota de lectura:** las secciones 2 y 3 del entregable (HU completas y Criterios de Aceptación) se presentan integradas, cada HU seguida de sus propios CA. Los CA se numeran CA-XX.n, donde XX es el número de la HU padre. Las HU no se limitan al CRUD: incluyen operaciones propias del dominio (asignar, verificar, descontar, sincronizar, trazar). Todo CA que dependa de un dato aún no definido en la Fase 0 remite a un ítem de la sección 5 (V-XX).
