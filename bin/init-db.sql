-- Active: 1713643215854@@localhost@5432
CREATE DATABASE javacnj;
\c javacnj;

CREATE SCHEMA keycloak;
CREATE SCHEMA log4j2;

CREATE TABLE log4j2.systemlog(
   	eventdate timestamp DEFAULT NULL,
    logger varchar(100),
    level varchar(100),
    message varchar(100),
    exception varchar(100)
);