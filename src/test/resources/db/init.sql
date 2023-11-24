create database tienda_system;

\connect tienda_system;

create table Helados (
  id bigint primary key generated always as identity,
  sabor character varying(255) not null,
  tvaso character varying(255) not null, 
  precio numeric(10, 2) not null,
  disponibles integer not null, 

  CONSTRAINT helados_sabor_uniq UNIQUE (sabor)
);

insert into helados (sabor, tvaso, precio, disponibles) values
  ('Pistache', 'Grande', 19.99, 20),
  ('Chocolate', 'Mediano', 14.99, 50),
  ('Fresa', 'Chico', 9.99, 55);