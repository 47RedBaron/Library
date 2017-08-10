create table AUTHORS
(
ID int unsigned not null auto_increment,
NAME varchar(50),
LASTNAME varchar(50),
YEAROFBIRTH int,
constraint PK_AUTHORS primary key (ID)
);
create table BOOKS
(
ID int unsigned not null auto_increment,
AUTHORS_ID int unsigned not null,
NAME varchar(50),
DESCRIPTION varchar(250),
PRICE int,

INSERT INTO AUTHORS (NAME, LASTNAME, YEAROFBIRTH) VALUES ('Douglas','Adams',1952);
INSERT INTO AUTHORS (NAME, LASTNAME, YEAROFBIRTH) VALUES ('Haruki','Murakami',1949);
INSERT INTO BOOKS (AUTHORS_ID, NAME, DESCRIPTION, PRICE) VALUES (1 , 'Dirk Gently','',20);
INSERT INTO BOOKS (AUTHORS_ID, NAME, DESCRIPTION, PRICE) VALUES (1 ,'H2G2','',15);ON varchar(255),
PRICE int,

INSERT INTO BOOKS (AUTHORS_ID, NAME, DESCRIPTION, PRICE) VALUES (2 , 'Les Amants du Spoutnik','',19);
INSERT INTO BOOKS (AUTHORS_ID, NAME, DESCRIPTION, PRICE) VALUES (2 , 'Au sud de la frontière, à louest du soleil','',18);

constraint PK_BOOKS primary key (ID),
FOREIGN KEY (AUTHORS_ID) REFERENCES AUTHORS(ID),
);
