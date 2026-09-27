# AgroControl - Modelo relacional v0.1

## 1. Fuente
Proyecto oficial: AgroControl
Modelo conceptual base: model-conceptual-v0.1.md
Flujo crítico utilizado: Gestión de predios, parcelas, asignación de labores a usuarios y control de insumos.

## 2. Criterios de transformación
- Relaciones 1:N: FK en el lado N.
- Relaciones N:M: tabla puente.
- Optionalidad registrada antes de decidir NULL/NOT NULL.
- Claves naturales relevantes registradas como candidatas a UNIQUE.

## 3. Tablas candidatas núcleo

### usuario
Propósito: Representa a los trabajadores o administradores del sistema.
- `usuario_id` [PK]
- `nombre`
- `email`
- `rol`

### predio
Propósito: Representa la finca o propiedad agrícola principal.
- `predio_id` [PK]
- `nombre`
- `ubicacion`

### parcela
Propósito: Representa una subdivisión de tierra dentro de un predio.
- `parcela_id` [PK]
- `predio_id` [FK -> predio.predio_id]
- `codigo`
- `hectareas`

### labor
Propósito: Representa una actividad agrícola (ej. Fumigación) a realizarse en una parcela.
- `labor_id` [PK]
- `parcela_id` [FK -> parcela.parcela_id]
- `usuario_id` [FK -> usuario.usuario_id]
- `nombre`
- `descripcion`
- `estado`

### insumo
Propósito: Representa los productos físicos a usar (ej. Fertilizante, Plaguicida).
- `insumo_id` [PK]
- `nombre_producto`
- `stock`

## 4. Relaciones
- `predio` 1:N `parcela` (Justificación: Un predio contiene muchas parcelas, la parcela pertenece a un solo predio).
- `parcela` 1:N `labor` (Justificación: En una parcela se realizan muchas labores a lo largo del tiempo).
- `usuario` 1:N `labor` (Justificación: Un usuario puede tener asignadas múltiples labores).

## 5. Relaciones N:M
`labor` N:M `insumo` -> Tabla puente candidata: `labor_insumo`
- Atributos propios de la relación: `cantidad_utilizada` (Cuánto de ese insumo exacto se usó en esa labor).

## 6. Claves naturales / UNIQUE candidatas
- `predio`.`nombre`: Debe ser único porque la regla de negocio de AgroControl prohíbe predios duplicados (RN-01).
- `parcela`.`codigo`: El código (ej. PAR-01) es el identificador natural de la empresa para la tierra.
- `usuario`.`email`: No pueden existir dos usuarios con el mismo correo.

## 7. Optionalidad
- `labor`.`usuario_id` -> Opcional. (Motivo: Una labor puede estar en estado "PLANIFICADA" sin tener todavía un trabajador asignado).

## 8. Reglas iniciales de integridad
- El campo `hectareas` en `parcela` debe ser mayor que 0.

## 9. Decisiones pendientes
- ¿Se debe crear una tabla historial para rastrear quién y cuándo cambió el estado de una labor de "PLANIFICADA" a "EN_PROGRESO"?

## 10. Revisión de normalización básica
- Listas multivaluadas detectadas/corregidas: No se guardan listas de insumos separadas por comas en la tabla labor, se usó la tabla puente `labor_insumo`.
- Columnas repetitivas detectadas/corregidas: Ninguna.
- Datos redundantes detectados/corregidos: La ubicación del predio no se copia a la parcela.