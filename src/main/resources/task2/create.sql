CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  autor              NUMBER(7)     NOT NULL PRIMARY KEY,
   year              NUMBER(4)     NOT NULL PRIMARY KEY
);

insert into book (id, name,autor,year) values (1, 'Book1',2,1999);
insert into book (id, name,autor,year) values (2, 'Book2',2,2005);
insert into book (id, name,autor,year) values (3, 'Book3',1,1809);
insert into book (id, name,autor,year) values (4, 'Book4',3,2003);