# Modelo Físico v0.1 - AgroControl

## Tabla: usuario
Propósito: Almacena las credenciales y datos básicos del personal.
| Columna | Tipo candidato | NULL | Rol/Restricción | Fuente |
|---|---|---|---|---|
| usuario_id | BIGINT | NO | PK | Diseño |
| nombre | VARCHAR(100) | NO | - | Ficha base |
| email | VARCHAR(100) | NO | UQ (Unique) | Autenticación |
| rol | VARCHAR(50) | NO | CK ('Admin', 'Trabajador') | RN-05 |

## Tabla: predio
Propósito: Registra las fincas o propiedades principales.
| Columna | Tipo candidato | NULL | Rol/Restricción | Fuente |
|---|---|---|---|---|
| predio_id | BIGINT | NO | PK | Diseño |
| nombre | VARCHAR(100) | NO | UQ (Unique) | RN-01 |
| ubicacion | TEXT | NO | - | Ficha base |

## Tabla: parcela
Propósito: Subdivisión de un predio con un tamaño específico.
| Columna | Tipo candidato | NULL | Rol/Restricción | Fuente |
|---|---|---|---|---|
| parcela_id | BIGINT | NO | PK | Diseño |
| predio_id | BIGINT | NO | FK (-> predio) | Relación 1:N |
| codigo | VARCHAR(50) | NO | UQ (predio_id, codigo) | RN-03 |
| hectareas | NUMERIC(10,2) | NO | CK (> 0) | RN-02 |

## Tabla: labor
Propósito: Tareas agrícolas ejecutadas en una parcela.
| Columna | Tipo candidato | NULL | Rol/Restricción | Fuente |
|---|---|---|---|---|
| labor_id | BIGINT | NO | PK | Diseño |
| parcela_id | BIGINT | NO | FK (-> parcela) | Relación 1:N |
| usuario_id | BIGINT | SÍ | FK (-> usuario) | RN-04 |
| nombre | VARCHAR(100) | NO | - | Ficha base |
| estado | VARCHAR(50) | NO | CK ('PLANIFICADA', 'EN_CURSO', 'COMPLETADA') | Control estados |
| descripcion | TEXT | SÍ | - | Ficha base |

## Tabla: insumo
Propósito: Catálogo de productos (fertilizantes, semillas) y su stock.
| Columna | Tipo candidato | NULL | Rol/Restricción | Fuente |
|---|---|---|---|---|
| insumo_id | BIGINT | NO | PK | Diseño |
| nombre_producto | VARCHAR(100) | NO | UQ (Unique) | Ficha base |
| stock | NUMERIC(10,2) | NO | CK (>= 0) | Regla negocio |

## Tabla: labor_insumo
Propósito: Tabla intermedia para registrar qué insumos y qué cantidad se usaron en cada labor.
| Columna | Tipo candidato | NULL | Rol/Restricción | Fuente |
|---|---|---|---|---|
| labor_insumo_id| BIGINT | NO | PK | Diseño |
| labor_id | BIGINT | NO | FK (-> labor) | Relación 1:N |
| insumo_id | BIGINT | NO | FK (-> insumo) | Relación 1:N |
| cantidad_utilizada| NUMERIC(10,2)| NO | CK (> 0) | Ficha base |

### Regla que NO se resuelve con constraint simple (Para futura lógica transaccional)
* **Control de Stock:** Al registrar una `cantidad_utilizada` en `labor_insumo`, el sistema deberá restar automáticamente ese valor del `stock` en la tabla `insumo`. Esto requerirá lógica a nivel de código o base de datos (transacción), no un simple `CHECK`.