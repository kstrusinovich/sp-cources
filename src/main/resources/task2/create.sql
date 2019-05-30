CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table autor (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)  NOT NULL,
  birthday        DATE          NOT NULL
);

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)  NOT NULL,
  year            NUMBER(7)     NOT NULL,
  autor           NUMBER(7)     NOT NULL,
  FOREIGN KEY (autor) REFERENCES autor(id)
);

insert into autor (id, name, birthday) values (1, 'Ivanov', '1977-03-18');
insert into autor (id, name, birthday) values (2, 'Petrov', '1980-04-12');
insert into autor (id, name, birthday) values (3, 'Pupkin', '1960-11-21');

insert into book (id, name, year, autor) values (1, 'Book1', 2015, 1);
insert into book (id, name, year, autor) values (2, 'Book2', 1964, 3);
insert into book (id, name, year, autor) values (3, 'Book3', 1966, 2);
insert into book (id, name, year, autor) values (4, 'Book4', 1985, 1);