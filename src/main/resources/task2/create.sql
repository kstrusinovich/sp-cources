CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;
create table autor (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  dateofbirth              DATE     NOT NULL
);
create table book (
  id              NUMBER(7)     NOT NULL PRIMARY KEY,
  name            VARCHAR2(50)       NOT NULL,
  autor_id             NUMBER(7)     NOT NULL ,
  date_edition        DATE     NOT NULL,
constraint FKbookautorid foreign key (autor_id) references autor);

insert into autor (id, name,dateofbirth) values (1, 'Autor1','1965-12-15');
insert into autor (id, name,dateofbirth) values (2, 'Autor2','1997-09-16');
insert into autor (id, name,dateofbirth) values (3, 'Autor3','1988-06-15');

insert into book (id, name,autor_id,date_edition) values (1, 'Book1',2,'1899-05-02');
insert into book (id, name,autor_id,date_edition) values (2, 'Book2',2,'1905-07-02');
insert into book (id, name,autor_id,date_edition) values (3, 'Book3',1,'1809-05-10');
insert into book (id, name,autor_id,date_edition) values (4, 'Book4',3,'2003-10-12');
insert into book (id, name,autor_id,date_edition) values (5, 'Book4',1,'2008-12-02');