USE DAUST;
drop table Banking;
CREATE TABLE  IF NOT EXISTS Banking(
	fName VARCHAR(100),
    lName VARCHAR(100), 
    aNumber INT NOT NULL,
    amount INT, 
    PRIMARY KEY(aNumber)
);
INSERT INTO Banking VALUES(
	"Mamadou","Cisse",1,100000
);
INSERT INTO Banking VALUES(
	"Akhad","Top",2,100000
);
INSERT INTO Banking VALUES(
	"Mamaodu","Mbengue",3,9000
);
INSERT INTO Banking VALUES(
	"FaPathe","Fall",4,9000
);
INSERT INTO Banking VALUES(
	"Seynabou","Faye",5,9000
);
INSERT INTO Banking VALUES(
	"Nafissatou","Niang",6,9000
);
INSERT INTO Banking VALUES(
	"Mamaodu","Niass",7,1000
);
INSERT INTO Banking VALUES(
	"Bamba","Sene",8,10000
);
INSERT INTO Banking VALUES(
	"Ibrahima","Cisse",9,9000
);
INSERT INTO Banking VALUES(
	"Adama","Ba",10,9000
);
INSERT INTO Banking VALUES(
	"Ibrahima","Diene",3,7500
);
SELECT * FROM Banking;
SELECT amount FROM Banking WHERE aNumber = 2;

UPDATE Banking set amount = 999999 where aNumber = 2;