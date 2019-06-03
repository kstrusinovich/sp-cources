CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL
);

insert into book (id, name) values (1, 'Book1');
insert into book (id, name) values (2, 'Book2');
insert into book (id, name) values (3, 'Book3');
insert into book (id, name) values (4, 'Book4');

CREATE TABLE author
(
    id      NUMBER(7)   NOT NULL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL
);

INSERT INTO author (id, name) VALUES (1, 'Cay S. Horstmann');
INSERT INTO author (id, name) VALUES (2, 'Joshua Bloch');
INSERT INTO author (id, name) VALUES (3, 'Herbert Schildt');
INSERT INTO author (id, name) VALUES (4, 'Kathy Sierra');