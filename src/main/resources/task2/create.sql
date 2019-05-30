CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

CREATE TABLE author (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name      VARCHAR2(50),
  date_of_birth   DATE
);


CREATE TABLE book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  author_id       NUMBER(7)     NOT NULL,
  name           VARCHAR2(400) NOT NULL,
  published    DATE     NOT NULL,

  CONSTRAINT fk_book_author     FOREIGN KEY (author_id)   REFERENCES author(id)
);


insert into author (id, name, date_of_birth) values (1, 'Ivan', '1775-12-16');
insert into author (id, name, date_of_birth) values (2, 'Serj', '1835-03-12');
insert into author (id, name, date_of_birth) values (3, 'Kate', '1732-11-30');
insert into author (id, name, date_of_birth) values (4, 'Victory', '1932-04-01');

insert into book (id, author_id, name, published) values (1, 3, 'Pervoe prishestvie', '1895-02-05');
insert into book (id, author_id, name, published) values (2, 2, 'Yama', '1920-04-24');
insert into book (id, author_id, name, published) values (3, 4, 'Voina', '2013-12-04');
insert into book (id, author_id, name, published) values (4, 1, 'Titanic', '1888-03-05');

