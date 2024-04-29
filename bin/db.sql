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

-- DELETE FROM CasosJudiciais WHERE decisao = 'I';
*/

DROP DATABASE keycloak;
CREATE SCHEMA keycloak;

CREATE USER demouser WITH ENCRYPTED PASSWORD 'demopassword';

GRANT ALL ON DATABASE "teste" TO demouser;
GRANT ALL ON SCHEMA public,keycloak TO demouser;
GRANT ALL PRIVILEGES ON TABLE casosjudiciais TO demouser;

CREATE SCHEMA log4j2;

CREATE TABLE log4j2.systemlog(
   	eventdate timestamp DEFAULT NULL,
    logger varchar(100),
    level varchar(100),
    message varchar(100),
    exception varchar(100)
);

SELECT * FROM log4j2.systemlog;

UPDATE CasosJudiciais
SET decisao='A' 
WHERE numero=3;

UPDATE CasosJudiciais
SET decisao='C'
WHERE decisao='A';

DROP TABLE casojudiciais;

DELETE 
FROM log4j2.systemlog 
--WHERE exception = '';
WHERE level = 'ERROR';