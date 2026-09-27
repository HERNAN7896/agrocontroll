# Plan de Migración V1 - AgroControl

## Objetivo
Establecer el orden estricto de creación de tablas en la base de datos PostgreSQL para evitar errores de referencias cruzadas (Foreign Keys), cubriendo el núcleo del negocio: gestión de usuarios, predios, parcelas, labores e insumos.

## Tablas incluidas y orden de creación (Dependencias)
1. `usuario` (Sin dependencias / tabla raíz)
2. `predio` (Sin dependencias / tabla raíz)
3. `insumo` (Sin dependencias / tabla raíz)
4. `parcela` (Depende de `predio`)
5. `labor` (Depende de `parcela` y de `usuario`)
6. `labor_insumo` (Depende de `labor` y de `insumo`)

## Restricciones previstas
* **PK:** Se usarán identificadores autogenerados tipo BIGINT.
* **FK:** Respetarán el orden de dependencia definido arriba.
* **NOT NULL:** Aplicado a la mayoría de campos para asegurar calidad de datos. `usuario_id` en `labor` permite NULL.
* **UNIQUE:** Aplicado a correos de usuario, nombres de predio, códigos de parcela (por predio) y nombres de insumo.
* **CHECK:** Aplicado a valores numéricos (hectáreas > 0, stock >= 0, cantidad_utilizada > 0) y a los estados de la labor y roles de usuario.

## Criterio de salida
Con este plan, podemos escribir el DDL (CREATE TABLE) en la versión V1 sin tomar decisiones nuevas importantes.