---Creacion de tablas
CREATE TABLE PERSON(
USERNAME VARCHAR(30),
PASSWORD VARCHAR(30),
CONSTRAINT person_pk PRIMARY KEY (USERNAME)
);

--Insercion de datos
insert into person values('test','test');

---Seleccion
Select * from PERSON;
ALTER TABLE PERSON ADD CONSTRAINT person_username_uk UNIQUE (USERNAME);
ALTER TABLE PERSON DROP CONSTRAINT person_username_uk;
ALTER TABLE PERSON 
ADD CONSTRAINT person_pk PRIMARY KEY (USERNAME);


