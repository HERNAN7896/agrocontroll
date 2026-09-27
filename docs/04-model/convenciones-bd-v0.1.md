# Convenciones de Base de Datos - AgroControl v0.1

## Nombres
* **Tablas:** minúsculas, singular (ej. `predio`, `parcela`).
* **Columnas:** minúsculas, separadas por guion bajo (snake_case) (ej. `nombre_producto`).
* **PK (Primary Key):** nombre de la tabla + `_id` (ej. `predio_id`).
* **FK (Foreign Key):** mismo nombre que la PK a la que hace referencia.
* **UNIQUE:** se documentará como UQ.
* **CHECK:** se documentará como CK.

## Tipos candidatos (PostgreSQL)
* **Identificador técnico (PK):** `BIGINT` autogenerado (elegido por simplicidad y rendimiento).
* **Texto corto (nombres, correos, códigos):** `VARCHAR(100)` o `VARCHAR(50)`.
* **Texto amplio (descripciones):** `TEXT`.
* **Importes/decimales exactos (hectáreas, cantidades):** `NUMERIC(10,2)` (Garantiza exactitud sin perder decimales).
* **Fecha calendario (días sin hora):** `DATE`.
* **Instante temporal (eventos con hora exacta):** `TIMESTAMPTZ`.
* **Booleanos (verdadero/falso):** `BOOLEAN`.
* **Estados:** `VARCHAR(50)` con valores controlados por reglas de negocio.

## Regla de equipo
Toda excepción a estos tipos candidatos debe quedar estrictamente justificada por una regla de negocio (RN) o requisito funcional (RF).