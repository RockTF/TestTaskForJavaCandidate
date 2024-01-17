CREATE TABLE users
(
    id       UUID    NOT NULL,
    username VARCHAR NOT NULL,
    name     VARCHAR NOT NULL,
    surname  VARCHAR NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);