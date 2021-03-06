CREATE TABLE authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(100) NOT NULL,
    enabled      boolean default true,
    authority_id int not null references authorities (id)
);

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id) values ('admin', true, '$2a$10$gTI1EQrRh3FTuUZ76sYyA.p50a9KO7pyA/a8eTnK5ViL83P0nTYam', (select id from authorities where authority = 'ROLE_ADMIN'));