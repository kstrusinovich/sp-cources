CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)         NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)      NOT NULL,
  authorCode      NUMBER(7)         NOT NULL
);

create table author (
  id              NUMBER(7)         NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)      NOT NULL,
  dateOfBirth     DATE			    NOT NULL

);

insert into book (id, name, authorCode) values (1, 'Book1', 1);
insert into book (id, name, authorCode) values (2, 'Book2', 2);
insert into book (id, name, authorCode) values (3, 'Book3', 3);
insert into book (id, name, authorCode) values (4, 'Book3', 1);


insert into author (id, name, dateOfBirth) values (1, 'Author1', '1980-05-05');
insert into author (id, name, dateOfBirth) values (2, 'Author2', '1960-10-15');
insert into author (id, name, dateOfBirth) values (3, 'Author3', '1970-03-10');