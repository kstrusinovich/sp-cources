CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;
CREATE TABLE languages (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name_languages  VARCHAR2(50)
);


CREATE TABLE author (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  first_name      VARCHAR2(50),
  last_name       VARCHAR2(50)  NOT NULL,
  date_of_birth   DATE
);

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  author_id       NUMBER(7)     NOT NULL,
  languages_id     NUMBER(7)     NOT NULL,
  name            VARCHAR2(50)       NOT NULL,
  published_in    NUMBER(7)     NOT NULL,
  CONSTRAINT fk_book_author     FOREIGN KEY (author_id)   REFERENCES author(id),
  CONSTRAINT fk_book_languages     FOREIGN KEY (languages_id)    REFERENCES languages(id)
);

insert into languages values(1, 'English');
insert into languages values(2, 'French');
insert into languages values(3, 'Deutsch');
insert into languages values(4, 'Chinese');
insert into languages values(5, 'Belarusian');

insert into author values(1, 'Jane', 'Austen', '1775-12-16');
insert into author values(2, 'Alexandre', 'Dumas', '1802-07-24');
insert into author values(3, 'Joanne', 'Rowling', '1965-07-31');
insert into author values(4, 'Stephen', 'King', '1947-09-21');
insert into author values(5, 'Yanka', 'Kupala', '1882-07-07');


INSERT INTO book VALUES (1, 1, 3, 'Sense and Sensibility', 1811);
INSERT INTO book VALUES (2, 1, 2,  'Pride and Prejudice', 1813);
INSERT INTO book VALUES (3, 2, 3, 'Le Capitaine Paul', 1838);
INSERT INTO book VALUES (4, 2, 1, 'Le Capitaine Pamphile', 1839);
INSERT INTO book VALUES (5, 1, 3, 'Northanger Abbey', 1818);
INSERT INTO book VALUES (6, 5, 5, 'Tuteyshyya', 1911);