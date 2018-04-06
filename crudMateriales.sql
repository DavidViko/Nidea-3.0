/*
    Operaciones CRUD
*/

-- Listar 

SELECT `id`, `nombre`, `precio` FROM `material` ORDER BY `id` DESC LIMIT 500;

-- Buscar 

SELECT `id`, `nombre`, `precio` FROM `material` WHERE `nombre` LIKE '%a%' ORDER BY `id` DESC LIMIT 500;
     
	 
-- Detalle

SELECT `id`, `nombre`, `precio` FROM `material` WHERE `id` = 8;	

-- Update
 
UPDATE `material` SET `nombre`='birra' WHERE  `id`=8;	 

-- DELETE

DELETE FROM `material` WHERE  `id`=8;

-- insertar

INSERT INTO `material` (`nombre`, `precio`) VALUES ('cerveza tostada', '2.50');