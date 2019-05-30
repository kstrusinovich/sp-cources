CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)  NOT NULL,
  year            DATE          NOT NULL
);

insert into book (id, name) values (1, 'Book1');
insert into book (id, name) values (2, 'Book2');
insert into book (id, name) values (3, 'Book3');
insert into book (id, name) values (4, 'Book4');