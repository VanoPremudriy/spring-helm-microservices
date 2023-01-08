set names 'utf8';
\c auth_db

create table users
(
    id         bigint
        primary key,
    user_name varchar(255) null,
    user_password varchar(255) null,
    user_email varchar(255) null

);
