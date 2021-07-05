create table if not exists items (
    id serial primary key,
    name text,
    created timestamp
);
--
--select * from items;
--SELECT * FROM pg_catalog.pg_tables;