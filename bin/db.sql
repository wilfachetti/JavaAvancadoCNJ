-- Active: 1713643215854@@localhost@5432@javacnj
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

-- DELETE FROM CasosJudiciais WHERE decisao = 'I';
*/

SELECT * FROM log4j2.systemlog;

SELECT * FROM casosjudiciais;

DROP TABLE casosjudiciais;

DELETE 
FROM log4j2.systemlog
--WHERE exception = '';
WHERE level = 'ERROR';

UPDATE CasosJudiciais
SET decisao='A' 
WHERE numero=3;

UPDATE CasosJudiciais
SET decisao='C'
WHERE decisao='A';