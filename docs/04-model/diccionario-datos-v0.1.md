# Diccionario de datos v0.1 - AgroControl

## Tabla: predio
| Campo | Significado | Obligatorio | PK/FK/UQ | Dominio/regla | Origen |
|---|---|---|---|---|---|
| predio_id | Identificador único de la finca | Sí (NN) | PK | Autoincremental/UUID | Diseño técnico |
| nombre | Nombre comercial de la finca | Sí (NN) | UQ | Texto no vacío | RN-01 |
| ubicacion | Dirección física o coordenadas | Sí (NN) | - | Texto | Ficha base |

## Tabla: parcela
| Campo | Significado | Obligatorio | PK/FK/UQ | Dominio/regla | Origen |
|---|---|---|---|---|---|
| parcela_id | Identificador de la porción de tierra | Sí (NN) | PK | Autoincremental/UUID | Diseño técnico |
| predio_id | Finca a la que pertenece | Sí (NN) | FK | Referencia a tabla predio | Relación 1:N |
| codigo | Código interno (Ej. P-01) | Sí (NN) | UQ (contextual)| Alfanumérico | RN-03 |
| hectareas | Tamaño en hectáreas de la parcela | Sí (NN) | - | Decimal > 0 | RN-02 |

## Tabla: usuario
| Campo | Significado | Obligatorio | PK/FK/UQ | Dominio/regla | Origen |
|---|---|---|---|---|---|
| usuario_id | Identificador del trabajador/admin | Sí (NN) | PK | Autoincremental/UUID | Diseño técnico |
| nombre | Nombre completo del usuario | Sí (NN) | - | Texto | Ficha base |
| email | Correo de contacto y login | Sí (NN) | UQ | Formato correo válido | Autenticación |
| rol | Cargo o nivel de acceso | Sí (NN) | - | 'Admin' o 'Trabajador' | RN-05 |