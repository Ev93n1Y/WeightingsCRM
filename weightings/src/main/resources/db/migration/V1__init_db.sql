CREATE TABLE users
(
    id          UUID            PRIMARY KEY ,
    name        VARCHAR(100)    NOT NULL UNIQUE,
    password    VARCHAR(100)    NOT NULL,
    first_name  VARCHAR(100),
    last_name   VARCHAR(100)
);

CREATE TABLE roles
(
    id          UUID            PRIMARY KEY ,
    role        VARCHAR(100)    NOT NULL UNIQUE
);

CREATE TABLE user_roles
(
    role_id     UUID            NOT NULL REFERENCES roles (id),
    user_id     UUID            NOT NULL REFERENCES users (id),
	PRIMARY KEY (role_id, user_id)
);

CREATE TABLE statuses
(
    id          UUID            PRIMARY KEY ,
    status      VARCHAR(100)    NOT NULL UNIQUE
);

CREATE TABLE companies
(
    id          UUID            PRIMARY KEY ,
    company     VARCHAR(100)    NOT NULL UNIQUE
);

CREATE TABLE drivers
(
    id          UUID            PRIMARY KEY ,
    driver      VARCHAR(100)    NOT NULL UNIQUE
);

CREATE TABLE trucks
(
    id          UUID            PRIMARY KEY ,
    truck       VARCHAR(100)    NOT NULL UNIQUE
);

CREATE TABLE products
(
    id          UUID            PRIMARY KEY ,
    product     VARCHAR(100)    NOT NULL UNIQUE
);

CREATE TABLE chemicals
(
    id          UUID            PRIMARY KEY ,
    product_id  UUID            REFERENCES products (id),
    humidity    INTEGER         NOT NULL
);

CREATE TABLE weightings
(
    id          UUID            PRIMARY KEY ,
    brutto_time DATE,
    brutto      INTEGER,
    tara_time   DATE,
    tara        INTEGER,
    netto       INTEGER
);

CREATE TABLE directions
(
    id          UUID            PRIMARY KEY ,
    direction   VARCHAR(100)    NOT NULL
);

CREATE TABLE warehouse
(
    id          UUID            PRIMARY KEY ,
    product_id  UUID            REFERENCES products (id),
    summary       INTEGER         NOT NULL
);

