# Decisiones de integridad v0.1

## 1. Mapeo de Reglas a Protecciones
| RN/RF | Regla | Protección prevista | Justificación |
|---|---|---|---|
| RN-01 | El nombre de un predio no puede repetirse en el sistema. | UQ (Unique) en `predio.nombre` | Garantiza unicidad global de nombres para no registrar la misma finca dos veces. |
| RN-02 | El tamaño de la parcela debe ser un valor real. | CHECK en `hectareas > 0` | Evita registrar parcelas con áreas negativas o en cero (imposible físicamente). |
| RN-03 | El código de parcela es único solo dentro de su predio. | UQ compuesta en `(predio_id, codigo)` | Unicidad contextual: Dos fincas distintas pueden tener la "Parcela A", pero no la misma finca. |
| RN-04 | Asignación inicial de labor opcional. | `usuario_id` en tabla `labor` permite NULL | Una labor puede estar 'PLANIFICADA' sin tener un trabajador asignado todavía. |

## 2. Ejercicio obligatorio: Prueba de contradicción
| Regla de tu proyecto | Estado inválido posible (Qué pasaría sin protección) | Protección prevista |
|---|---|---|
| RN-01 (Nombre único) | Intentar guardar un predio llamado "La Esperanza" cuando ya existe otro igual. | Será bloqueado por la restricción UNIQUE en la columna `nombre`. |
| RN-02 (Tamaño válido) | Un usuario teclea por error "-5" al registrar las hectáreas de una parcela. | Será bloqueado por la restricción CHECK > 0 en la base de datos. |
| RN-05 (Rol obligatorio)| Intentar crear un usuario en el sistema sin definir si es "Admin" o "Trabajador". | Será bloqueado por la restricción NOT NULL (NN) en la columna `rol`. |