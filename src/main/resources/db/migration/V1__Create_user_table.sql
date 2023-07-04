CREATE TYPE role AS enum('USER', 'ADMIN');

CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    firstname varchar(255),
    lastname varchar(255),
    email varchar(255),
    birthday date,
    role role,
    primary key (id)
)