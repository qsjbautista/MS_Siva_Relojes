create table cnf_configuracion_catalogo
(
	id bigint auto_increment
		primary key,
	dominio varchar(100) not null,
	tipo varchar(100) not null,
	descripcion varchar(255) not null,
	ultima_actualizacion timestamp default CURRENT_TIMESTAMP null,
	valor_default varchar(20) null
)
;

create table cat_condiciones_generales
(
	id_elemento bigint auto_increment
		primary key,
	abreviatura varchar(20) not null,
	etiqueta varchar(255) not null,
	id_configuracion bigint not null,
	constraint UK_cat_condiciones_generales_abreviatura
		unique (abreviatura),
	constraint FK_cat_cat_condiciones_generales_cnf_configuracion_catalogo
		foreign key (id_configuracion) references cnf_configuracion_catalogo (id)
)
;

create index IXFK_cat_cat_condiciones_generales_cnf_configuracion_catalogo
	on cat_condiciones_generales (id_configuracion)
;

create index IX_cat_cat_condiciones_generales_abreviatura
	on cat_condiciones_generales (abreviatura)
;

create table cat_desplazamiento_comercial
(
	id_elemento bigint auto_increment
		primary key,
	abreviatura varchar(20) not null,
	etiqueta varchar(255) not null,
	id_configuracion bigint not null,
	constraint UK_cat_desplazamiento_comercial_abreviatura
		unique (abreviatura),
	constraint FK_cat_cat_desplazamiento_comercial_cnf_configuracion_catalogo
		foreign key (id_configuracion) references cnf_configuracion_catalogo (id)
)
;

create index IXFK_cat_cat_desplazamiento_comercial_cnf_configuracion_catalogo
	on cat_desplazamiento_comercial (id_configuracion)
;

create index IX_cat_cat_desplazamiento_comercial_abreviatura
	on cat_desplazamiento_comercial (abreviatura)
;

create table cat_genero
(
	id_elemento bigint auto_increment
		primary key,
	abreviatura varchar(20) not null,
	etiqueta varchar(255) not null,
	id_configuracion bigint not null,
	constraint UK_cat_genero_abreviatura
		unique (abreviatura),
	constraint FK_cat_cat_genero_cnf_configuracion_catalogo
		foreign key (id_configuracion) references cnf_configuracion_catalogo (id)
)
;

create index IXFK_cat_cat_genero_cnf_configuracion_catalogo
	on cat_genero (id_configuracion)
;

create index IX_cat_cat_genero_abreviatura
	on cat_genero (abreviatura)
;

create table cat_marca
(
	id_elemento bigint auto_increment
		primary key,
	abreviatura varchar(20) not null,
	etiqueta varchar(255) not null,
	id_configuracion bigint not null,
	constraint UK_cat_marca_abreviatura
		unique (abreviatura),
	constraint FK_cat_cat_marca_cnf_configuracion_catalogo
		foreign key (id_configuracion) references cnf_configuracion_catalogo (id)
)
;

create index IXFK_cat_cat_marca_cnf_configuracion_catalogo
	on cat_marca (id_configuracion)
;

create index IX_cat_cat_marca_abreviatura
	on cat_marca (abreviatura)
;

create table cat_matriz_coordenadas
(
	id_elemento bigint not null
		primary key,
	abreviatura varchar(50) not null,
	etiqueta varchar(255) not null,
	condicion varchar(20) not null,
	desplazamiento varchar(20) not null,
	factor decimal(5,4) not null,
	valida tinyint(1) not null,
	id_configuracion bigint not null,
	constraint UK_cat_matriz_coordendas_abreviatura
		unique (abreviatura),
        constraint UK_cat_matriz_coordendas_condicion_desplazamiento
		unique (condicion, desplazamiento),
	constraint FK_cat_matriz_coordenadas_cnf_configuracion_catalogo
		foreign key (id_configuracion) references cnf_configuracion_catalogo (id)
)
;

create index IXFK_cat_cat_matriz_coordenadas_cnf_configuracion_catalogo
	on cat_matriz_coordenadas (id_configuracion)
;

create index IX_cat_cat_matriz_coordenadas_abreviatura
	on cat_matriz_coordenadas (abreviatura)
;

create index IX_cat_cat_matriz_coordenadas_condicion
	on cat_matriz_coordenadas (condicion);
;

create index IX_cat_cat_matriz_coordenadas_desplazamiento
	on cat_matriz_coordenadas (desplazamiento)
;

create table cat_tipo_reloj
(
	id_elemento bigint auto_increment
		primary key,
	abreviatura varchar(20) not null,
	etiqueta varchar(255) not null,
	id_configuracion bigint not null,
	constraint UK_cat_tipo_reloj_abreviatura
		unique (abreviatura),
	constraint FK_cat_cat_tipo_reloj_cnf_configuracion_catalogo
		foreign key (id_configuracion) references cnf_configuracion_catalogo (id)
)
;

create index IXFK_cat_cat_tipo_reloj_cnf_configuracion_catalogo
	on cat_tipo_reloj (id_configuracion)
;

create index IX_cat_cat_tipo_reloj_abreviatura
	on cat_tipo_reloj (abreviatura)
;

create table cat_refrendo
(
  id_elemento      bigint       not null
    primary key,
  abreviatura      varchar(50)  not null,
  etiqueta         varchar(255) not null,
  tipo_reloj       varchar(20)  not null,
  numero           int          not null,
  id_configuracion bigint       not null,
  constraint UK_cat_refrendo_abreviatura
  unique (abreviatura),
  constraint UK_cat_refrendo_tipo_reloj
  unique (tipo_reloj),
  constraint FK_cat_refrendo_cnf_configuracion_catalogo
  foreign key (id_configuracion) references cnf_configuracion_catalogo (id)
);

create index IXFK_cat_refrendo_cnf_configuracion_catalogo
  on cat_refrendo (id_configuracion);

create index IX_cat_refrendo_abreviatura
  on cat_refrendo (abreviatura);

create index IX_cat_refrendo_tipo_reloj
  on cat_refrendo (tipo_reloj);

create index IX_cnf_configuracion_catalogo_dominio
	on cnf_configuracion_catalogo (dominio)
;

create index IX_cnf_configuracion_catalogo_tipo
	on cnf_configuracion_catalogo (tipo)
;

create table cnf_entidad_catalogo
(
	id bigint auto_increment
		primary key,
	catalogo varchar(100) not null,
	entidad varchar(100) not null,
	constraint catalogo
		unique (catalogo),
	constraint FK_cnf_entidad_catalogo_cnf_configuracion_catalogo
		foreign key (id) references cnf_configuracion_catalogo (id)
)
;

