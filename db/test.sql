CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE IF NOT EXISTS SISTEMA(
	nombre VARCHAR(36),
	numJuegos INT,
    PRIMARY KEY(nombre)	
);

CREATE TABLE IF NOT EXISTS USUARIOS(
	DNI CHAR(9) NOT NULL CHECK(DNI LIKE ('[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]')),
    contrasena VARCHAR(256) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
	nombre VARCHAR(36) NOT NULL,
	apellidos VARCHAR(255) NOT NULL,
	domicilio VARCHAR(255) NOT NULL,
	UserType INT NOT NULL default 2,
    PRIMARY KEY(DNI)
);

CREATE TABLE IF NOT EXISTS JUEGOS(
	numeroJuego INT,
	nombreJuego VARCHAR(36),
    PRIMARY KEY(nombreJuego)
);

CREATE table if not exists ranking(
	nombreJuego varchar(36),
    puntuacion int,
    DNI varchar(9),
    FOREIGN KEY (nombreJuego) REFERENCES JUEGOS(nombreJuego),
    FOREIGN KEY (DNI) REFERENCES USUARIOS(DNI)
);
