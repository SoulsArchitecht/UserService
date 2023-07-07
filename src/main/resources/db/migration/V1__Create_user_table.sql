CREATE TABLE IF NOT EXISTS user_service.users (
    id SERIAL,
    firstname varchar(255),
    lastname varchar(255),
    email varchar(255),
    birthday date,
    role varchar(255),
    primary key (id)
)