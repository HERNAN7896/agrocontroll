-- ============================================================
-- CLASE 07: CONSULTAS BÁSICAS DE NEGOCIO (AGROCONTROLL)
-- ============================================================

-- Q01. Listado de parcelas ordenadas de mayor a menor superficie (hectáreas)
SELECT nombre, hectareas
FROM parcelas
ORDER BY hectareas DESC;

-- Q02. Parcelas con superficie mayor a 12 hectáreas
SELECT *
FROM parcelas
WHERE hectareas > 12;

-- Q03. Búsqueda de predios ubicados en la "Zona Norte"
SELECT *
FROM predios
WHERE ubicacion LIKE '%Zona Norte%';

-- Q04. Parcelas pertenecientes al Predio 1 que estén activas
SELECT *
FROM parcelas
WHERE predio_id = 1 AND estado = 'ACTIVO';

-- Q05. Parcelas con una superficie entre 10 y 20 hectáreas
SELECT *
FROM parcelas
WHERE hectareas BETWEEN 10 AND 20;

-- Q06. Parcelas que no tienen observaciones registradas (Manejo de NULL)
SELECT *
FROM parcelas
WHERE observaciones IS NULL;

-- Q07. Parcelas que están inactivas o en descanso
SELECT *
FROM parcelas
WHERE estado IN ('INACTIVO', 'EN_DESCANSO');

-- Q08. Nombre y estado de parcelas del Predio 2 (Proyección explícita)
SELECT nombre, estado
FROM parcelas
WHERE predio_id = 2;