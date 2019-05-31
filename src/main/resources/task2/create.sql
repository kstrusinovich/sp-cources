CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  id_author              NUMBER(7)     NOT NULL,
  name            VARCHAR2(50)       NOT NULL,
   date            DATE               NOT NULL
);

insert into book (id, id_author, name, date) values (1, 1, 'Book1', '1960-01-01');
insert into book (id, id_author, name, date) values (2, 2, 'Book2', '1965-06-01');
insert into book (id, id_author, name, date) values (3, 3, 'Book3', '1970-01-01');
insert into book (id, id_author, name, date) values (4, 4, 'Book4', '1950-01-01');

create table author (
  id_author              NUMBER(7)     NOT NULL PRIMARY KEY,
  name_author            VARCHAR2(50)       NOT NULL
);

insert into author (id_author, name_author) values (1, 'Author1');
insert into author (id_author, name_author) values (2, 'Author2');
insert into author (id_author, name_author) values (3, 'Author3');
insert into author (id_author, name_author) values (4, 'Author4');
