INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, ultima_actualizacion, valor_default)
VALUES (1, 'Relojes', 'Marca', 'Catalogo de marcas de reloj', '2018-08-15 10:27:15', null);


INSERT INTO cnf_entidad_catalogo (id, catalogo, entidad)
VALUES (1, 'MARCA', 'mx.com.nmp.ms.sivar.catalogo.domain.Marca');

INSERT INTO cat_marca (id_elemento, abreviatura, etiqueta, id_configuracion)
VALUES (1, 'OTRO', 'Otro', 1);

INSERT INTO cat_marca (id_elemento, abreviatura, etiqueta, id_configuracion)
VALUES (2, 'LANG', 'A. LANGE & SÖHNE', 1);