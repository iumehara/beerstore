drop table if exists beers;
drop table if exists breweries;

create table breweries (
    id serial primary key,
    name varchar
);

create table beers (
    id serial primary key,
    name varchar,
    brewery_id integer references breweries (id)
);
