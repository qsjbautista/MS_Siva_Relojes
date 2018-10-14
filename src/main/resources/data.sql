INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, valor_default) VALUES (1, 'Relojes', 'Marca', 'Catalogo de marcas de reloj', null);
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, valor_default) VALUES (2, 'Relojes', 'TipoReloj', 'Catalogo de tipos de reloj', null);
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, valor_default) VALUES (3, 'Relojes', 'CondicionesGenerales', 'Catalogo de condiciones generales del reloj', null);
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, valor_default) VALUES (4, 'Relojes', 'DesplazamientoComercial', 'Catalogo de desplazamiento comercial del reloj', null);
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, valor_default) VALUES (5, 'Relojes', 'Genero', 'Catalogo de genero del reloj', null);
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, valor_default) VALUES (6, 'Relojes', 'MatrizCoordenadas', 'Catalogo de matriz de coordenadas', null);
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion, valor_default) VALUES (7, 'Relojes', 'Refrendos', 'Catalogo de refrendos segun tipo de reloj', null);


INSERT INTO cnf_entidad_catalogo (id, catalogo, entidad) VALUES (1, 'MARCA', 'mx.com.nmp.ms.sivar.catalogo.domain.Marca');
INSERT INTO cnf_entidad_catalogo (id, catalogo, entidad) VALUES (2, 'TIPO_RELOJ', 'mx.com.nmp.ms.sivar.catalogo.domain.TipoReloj');
INSERT INTO cnf_entidad_catalogo (id, catalogo, entidad) VALUES (3, 'CONDICIONES_GENERALES', 'mx.com.nmp.ms.sivar.catalogo.domain.CondicionesGenerales');
INSERT INTO cnf_entidad_catalogo (id, catalogo, entidad) VALUES (4, 'DESPLAZAMIENTO_COMERCIAL', 'mx.com.nmp.ms.sivar.catalogo.domain.DesplazamientoComercial');
INSERT INTO cnf_entidad_catalogo (id, catalogo, entidad) VALUES (5, 'GENERO', 'mx.com.nmp.ms.sivar.catalogo.domain.Genero');


INSERT INTO cat_tipo_reloj (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (1, 'AUTO', 'Automático', 2);
INSERT INTO cat_tipo_reloj (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (2, 'CURZ', 'Cuarzo', 2);
INSERT INTO cat_tipo_reloj (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (3, 'MANL', 'Cuerda manual', 2);


INSERT INTO cat_marca (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (1, 'OTRO', 'Otro', 1);
INSERT INTO cat_marca (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (2, 'LANG', 'A. LANGE & SÖHNE', 1);
INSERT INTO cat_marca (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (3, 'ACTN', 'ACCUTRON', 1);
INSERT INTO cat_marca (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (4, 'ADIS', 'ADIDAS', 1);
INSERT INTO cat_marca (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (5, 'ROLX', 'ROLEX', 1);


INSERT INTO cat_genero (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (1, 'CBRO', 'Caballero', 5);
INSERT INTO cat_genero (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (2, 'DAMA', 'Dama', 5);
INSERT INTO cat_genero (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (3, 'TMED', 'Talla media (MIDSIZE)', 5);
INSERT INTO cat_genero (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (4, 'OTRO', 'Otro', 5);


INSERT INTO cat_condiciones_generales (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (1, 'SNES', 'Sin estrenar', 3);
INSERT INTO cat_condiciones_generales (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (2, 'MBUE', 'Muy bueno', 3);
INSERT INTO cat_condiciones_generales (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (3, 'BUNO', 'Bueno', 3);
INSERT INTO cat_condiciones_generales (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (4, 'USDO', 'Usado', 3);
INSERT INTO cat_condiciones_generales (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (5, 'DFTO', 'Defectuoso', 3);
INSERT INTO cat_condiciones_generales (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (6, 'DMTR', 'Desmantelar', 3);


INSERT INTO cat_desplazamiento_comercial (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (1, 'EXLT', 'Excelente', 4);
INSERT INTO cat_desplazamiento_comercial (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (2, 'ALTO', 'Alto', 4);
INSERT INTO cat_desplazamiento_comercial (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (3, 'MEDI', 'Medio', 4);
INSERT INTO cat_desplazamiento_comercial (id_elemento, abreviatura, etiqueta, id_configuracion) VALUES (4, 'BAJO', 'Bajo', 4);


INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (1, 'SNES_EXLT', 'Sin estrenar - Excelente', 'SNES', 'EXLT', 0.9000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (2, 'SNES_ALTO', 'Sin estrenar - Alto', 'SNES', 'ALTO', 0.8500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (3, 'SNES_MEDI', 'Sin estrenar - Medio', 'SNES', 'MEDI', 0.8000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (4, 'SNES_BAJO', 'Sin estrenar - Bajo', 'SNES', 'BAJO', 0.7500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (5, 'MBUE_EXLT', 'Muy bueno - Excelente', 'MBUE', 'EXLT', 0.8500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (6, 'MBUE_ALTO', 'Muy bueno - Alto', 'MBUE', 'ALTO', 0.8000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (7, 'MBUE_MEDI', 'Muy bueno - Medio', 'MBUE', 'MEDI', 0.7500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (8, 'MBUE_BAJO', 'Muy bueno - Bajo', 'MBUE', 'BAJO', 0.7000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (9, 'BUNO_EXLT', 'Bueno - Excelente', 'BUNO', 'EXLT', 0.8000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (10, 'BUNO_ALTO', 'Bueno - Alto', 'BUNO', 'ALTO', 0.7500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (11, 'BUNO_MEDI', 'Bueno - Medio', 'BUNO', 'MEDI', 0.7000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (12, 'BUNO_BAJO', 'Bueno - Bajo', 'BUNO', 'BAJO', 0.6500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (13, 'USDO_EXLT', 'Usado - Excelente', 'USDO', 'EXLT', 0.7500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (14, 'USDO_ALTO', 'Usado - Alto', 'USDO', 'ALTO', 0.7000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (15, 'USDO_MEDI', 'Usado - Medio', 'USDO', 'MEDI', 0.6500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (16, 'USDO_BAJO', 'Usado - Bajo', 'USDO', 'BAJO', 0.6000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (17, 'DFTO_EXLT', 'Defectuoso - Excelente', 'DFTO', 'EXLT', 0.5500, 0, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (18, 'DFTO_ALTO', 'Defectuoso - Alto', 'DFTO', 'ALTO', 0.5000, 0, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (19, 'DFTO_MEDI', 'Defectuoso - Medio ', 'DFTO', 'MEDI', 0.4500, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (20, 'DFTO_BAJO', 'Defectuoso - Bajo ', 'DFTO', 'BAJO', 0.4000, 1, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (21, 'DMTR_EXLT', 'Desmantelar - Excelente ', 'DMTR', 'EXLT', 0.2000, 0, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (22, 'DMTR_ALTO', 'Desmantelar - Alto ', 'DMTR', 'ALTO', 0.1500, 0, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (23, 'DMTR_MEDI', 'Desmantelar - Medio ', 'DMTR', 'MEDI', 0.1000, 0, 6);
INSERT INTO cat_matriz_coordenadas (id_elemento, abreviatura, etiqueta, condicion, desplazamiento, factor, valida, id_configuracion) VALUES (24, 'DMTR_BAJO', 'Desmantelar -  Bajo', 'DMTR', 'BAJO', 0.0500, 0, 6);


INSERT INTO cat_refrendo (id_elemento, abreviatura, etiqueta, tipo_reloj, numero, id_configuracion) VALUES (1, 'REF_AUTO', 'Refrendos para reloj automaitco', 'AUTO', 3, 7);
INSERT INTO cat_refrendo (id_elemento, abreviatura, etiqueta, tipo_reloj, numero, id_configuracion) VALUES (2, 'REF_CURZ', 'Refrendos para reloj de cuarzo', 'CURZ', 0, 7);
INSERT INTO cat_refrendo (id_elemento, abreviatura, etiqueta, tipo_reloj, numero, id_configuracion) VALUES (3, 'REF_MANL', 'Refrendos para reloj manual', 'MANL', 3, 7);
