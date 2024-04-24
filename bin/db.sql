-- Active: 1713643215854@@localhost@5432@teste
/*
CREATE TABLE CasosJudiciais (
	numero SERIAL PRIMARY KEY,
	decisao CHAR(1),
	descricao VARCHAR(255)
);

INSERT INTO CasosJudiciais
	(decisao, descricao)
VALUES
	('I', 'Descrição caso 01'),
	('C', 'Descrição caso 02'),
	('A', 'Descrição caso 03'),
	('A', 'Descrição caso 04');

DELETE FROM CasosJudiciais WHERE decisao = 'I';
*/

FROM DATABASE teste;

SELECT * FROM CasosJudiciais;

UPDATE CasosJudiciais
SET decisao='A' 
WHERE numero=3;

UPDATE CasosJudiciais
SET decisao='C'
WHERE decisao='A';

DROP TABLE casojudiciais;
