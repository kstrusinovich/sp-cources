CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  id_author        NUMBER(7)     NOT NULL
);

insert into book (id, name, id_author) values (1, 'Book1', 1);
insert into book (id, name, id_author) values (2, 'Book2', 2);
insert into book (id, name, id_author) values (3, 'Book3', 3);
insert into book (id, name, id_author) values (4, 'Book4', 4);


create table author (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  date        date     NOT NULL
  );

insert into author (id, name, date) values (1, 'Blok', '1945-01-01');
insert into author (id, name, date) values (2, 'Puhkin', '1938-02-02');
insert into author (id, name, date) values (3, 'Dostoevskii', '1934-03-03');
insert into author (id, name, date) values (4, 'Lokyanenko', '1953-04-04');

