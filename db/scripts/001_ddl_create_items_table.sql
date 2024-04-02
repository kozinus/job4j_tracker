create table item (
   id serial primary key,
   name text,
   created timestamp default now()
);