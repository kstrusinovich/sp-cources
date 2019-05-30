CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  dateOfRelise    DATE          NOT NULL,
  id_author       NUMBER(7)     NOT NULL

  CONSTRAINT fk_book_author     FOREIGN KEY (id_author)   REFERENCES author(id)
);

insert into book (id, name) values (1, 'Book1', '1981-04-26', 2);
insert into book (id, name) values (2, 'Book2', '1975-04-26', 3);
insert into book (id, name) values (3, 'Book3', '1999-04-26', 1);
insert into book (id, name) values (4, 'Book4', '2003-04-26', 4);


create table author (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  dateOfBirth     DATE              NOT NULL
);

insert into book (id, name) values (1, 'Author1', '1970-04-26');
insert into book (id, name) values (2, 'Author2', '1978-02-06');
insert into book (id, name) values (3, 'Author3', '1954-08-13');
insert into book (id, name) values (4, 'Author4', '1992-11-01');