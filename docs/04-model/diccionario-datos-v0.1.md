# DER lógico v0.1 AgroControl

## Convenciones
PK = clave primaria
FK = clave foránea
UQ = unicidad
NN = obligatorio

## usuario
PK usuario_id
NN nombre
NN email
UQ email
NN rol

## predio
PK predio_id
NN nombre
UQ nombre
NN ubicacion

## parcela
PK parcela_id
FK predio_id -> predio.predio_id
NN codigo
UQ (predio_id, codigo)
NN hectareas

## labor
PK labor_id
FK parcela_id -> parcela.parcela_id
FK usuario_id -> usuario.usuario_id
NN nombre
NN estado
- descripcion (NULL)

## insumo
PK insumo_id
NN nombre_producto
UQ nombre_producto
NN stock

## labor_insumo
PK labor_insumo_id
FK labor_id -> labor.labor_id
FK insumo_id -> insumo.insumo_id
NN cantidad_utilizada

## Relaciones
1. predio 1:N parcela
2. parcela 1:N labor
3. usuario 1:N labor
4. labor 1:N labor_insumo
5. insumo 1:N labor_insumo

## Reglas que afectan el modelo
RN-01 (Nombres únicos de predio) -> decisión: UQ en predio.nombre
RN-02 (Tamaño de parcela válido) -> decisión: CHECK en parcela.hectareas > 0
RN-03 (Trabajador asignado opcional al inicio) -> decisión: FK usuario_id en labor permite NULL