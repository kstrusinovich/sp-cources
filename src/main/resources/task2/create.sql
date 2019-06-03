CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  year            NUMBER(4)     NOT NULL
);

insert into book  values (1, 'Book1',1963);
insert into book  values (2, 'Book2',1964);
insert into book  values (3, 'Book3',1965);
insert into book  values (4, 'Book4',1966);
insert into book  values (5, 'Book5',1967);

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