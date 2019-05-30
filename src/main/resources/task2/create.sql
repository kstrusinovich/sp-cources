CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)  NOT NULL,
  year            NUMBER(4)     NOT NULL
);

insert into book (id, name) values (1, 'Book1', 2015);
insert into book (id, name) values (2, 'Book2', 2000);
insert into book (id, name) values (3, 'Book3', 1965);
insert into book (id, name) values (4, 'Book4', 1985);