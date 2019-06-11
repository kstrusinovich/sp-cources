CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

CREATE TABLE author (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  first_name      VARCHAR2(50),
  last_name       VARCHAR2(50)  NOT NULL,
  date_of_birth   DATE
);

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  author_id       NUMBER(7)     NOT NULL,
  name            VARCHAR2(50)       NOT NULL,
  published_in    NUMBER(7)     NOT NULL,
  CONSTRAINT fk_book_author     FOREIGN KEY (author_id)   REFERENCES author(id)
);

insert into author values(1, 'Jane', 'Austen', '1775-12-16');
insert into author values(2, 'Alexandre', 'Dumas', '1802-07-24');
insert into author values(3, 'Joanne', 'Rowling', '1965-07-31');
insert into author values(4, 'Stephen', 'King', '1947-09-21');


INSERT INTO book VALUES (1, 1, 'Sense and Sensibility', 1811);
INSERT INTO book VALUES (2, 1, 'Pride and Prejudice', 1813);
INSERT INTO book VALUES (3, 2, 'Le Capitaine Paul', 1838);
INSERT INTO book VALUES (4, 2, 'Le Capitaine Pamphile', 1839);
INSERT INTO book VALUES (5, 1, 'Northanger Abbey', 1818);

CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  year            NUMBER(4)     NOT NULL,
  authorid        NUMBER (7)    NOT NULL
);

insert into book  values (1, 'Book1',1963,2);
insert into book  values (2, 'Book2',1964,2);
insert into book  values (3, 'Book3',1965,5);
insert into book  values (4, 'Book4',1966,3);
insert into book  values (5, 'Book5',1967,1);

create table Author (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  bithday         DATE           NOT NULL
);

insert into Author  values (1, 'Author1','1932-10-01');
insert into Author  values (2, 'Author2','1943-02-23');
insert into Author  values (3, 'Author3','1921-01-24');
insert into Author  values (4, 'Author4','1945-05-09');
insert into Author  values (5, 'Author5','1932-06-07');
