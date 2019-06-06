CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

CREATE TABLE author (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  first_name      VARCHAR2(50),
  last_name       VARCHAR2(50)  NOT NULL,
  date_of_birth   DATE
);

CREATE TABLE language (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)
);

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  author_id       NUMBER(7)     NOT NULL,
  name            VARCHAR2(50)       NOT NULL,
  published_in    NUMBER(7)     NOT NULL,
  language_id     NUMBER(7)     NOT NULL,
  CONSTRAINT fk_book_author     FOREIGN KEY (author_id)   REFERENCES author(id),
  CONSTRAINT fk_book_language   FOREIGN KEY (language_id)   REFERENCES language(id)
);


insert into author values(1, 'Jane', 'Austen', '1775-12-16');
insert into author values(2, 'Alexandre', 'Dumas', '1802-07-24');
insert into author values(3, 'Joanne', 'Rowling', '1965-07-31');
insert into author values(4, 'Stephen', 'King', '1947-09-21');

INSERT INTO language VALUES (1, 'russian');
INSERT INTO language VALUES (2, 'belarus');
INSERT INTO language VALUES (3, 'english');

INSERT INTO book VALUES (1, 1, 'Sense and Sensibility', 1811, 1);
INSERT INTO book VALUES (2, 1, 'Pride and Prejudice', 1813, 1);
INSERT INTO book VALUES (3, 2, 'Le Capitaine Paul', 1838, 1);
INSERT INTO book VALUES (4, 2, 'Le Capitaine Pamphile', 1839, 2);
INSERT INTO book VALUES (5, 1, 'Northanger Abbey', 1818, 3);

