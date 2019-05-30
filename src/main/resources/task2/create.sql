CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  author_id       NUMBER(7)     NOT NULL,
  name            VARCHAR2(50)       NOT NULL,
  year            NUMBER(7)       NOT NULL
);

insert into book (id, author_id, name, year) values (1, 1, 'Book1', 1960);
insert into book (id, author_id, name, year) values (2, 1, 'Book2', 1970);
insert into book (id, author_id, name, year) values (3, 2, 'Book3', 1980);
insert into book (id, author_id, name, year) values (4, 3, 'Book4', 1990);


create table author (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  date_of_birth   DATE       NOT NULL
);

insert into author (id, name, date_of_birth) values (1, 'Author1', '1960-01-01');
insert into author (id, name, date_of_birth) values (2, 'Author2', '1970-01-01');
insert into author (id, name, date_of_birth) values (3, 'Author3', '1980-01-01');
