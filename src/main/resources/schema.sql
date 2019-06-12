drop table t_carreras if exists;
drop table t_conductores if exists;
create table t_conductores (co_nombre varchar(255) not null, co_modelo varchar(255), co_matricula varchar(255), co_valoracion_media double, co_ocupado TINYINT,  primary key (co_nombre));
create table t_carreras (c_id integer, c_tarjeta_credito varchar(255) not null, c_origen varchar(255), c_destino varchar(255), c_distancia double, c_tiempo_esperado integer, c_tiempo_carrera integer, c_coste_total double, c_propina integer, c_conductor varchar(255), primary key (c_id));    
alter table t_carreras add constraint carreras_conductor_fk foreign key (c_conductor) references t_conductores