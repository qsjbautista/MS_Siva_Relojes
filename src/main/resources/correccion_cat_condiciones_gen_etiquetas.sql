-- scripts para cambiar las descripciones de el catalogo cat_condiciones_generales
UPDATE cat_condiciones_generales SET etiqueta = 'Sin estrenar' WHERE id_elemento = 1;
UPDATE cat_condiciones_generales SET etiqueta = 'Muy buen estado' WHERE id_elemento = 2;
UPDATE cat_condiciones_generales SET etiqueta = 'Buen estado' WHERE id_elemento = 3;
UPDATE cat_condiciones_generales SET etiqueta = 'Usado' WHERE id_elemento = 4;
UPDATE cat_condiciones_generales SET etiqueta = 'Defectuoso' WHERE id_elemento = 5;
UPDATE cat_condiciones_generales SET etiqueta = 'Para desmantelar' WHERE id_elemento = 6;