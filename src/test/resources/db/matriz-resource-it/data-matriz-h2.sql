INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, ultima_actualizacion, valor_default)
VALUES (6, 'Relojes', 'MatrizCoordenadas', 'Catalogo de matriz de coordenadas', '2018-08-15 10:28:07', null);


INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion)
VALUES (1, 'SNES_EXLT', 'Sin estrenar - Excelente', 'SNES', 'EXLT', 0.9000, 1, 6);

INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion)
VALUES (2, 'SNES_ALTO', 'Sin estrenar - Alto', 'SNES', 'ALTO', 0.8500, 1, 6);

INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion)
VALUES (22, 'DMTR_ALTO', 'Desmantelar - Alto ', 'DMTR', 'ALTO', 0.1500, 0, 6);