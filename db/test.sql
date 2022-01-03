CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE IF NOT EXISTS SISTEMA(
	nombre VARCHAR(36),
    PRIMARY KEY(nombre)
);

CREATE TABLE IF NOT EXISTS USUARIOS(
	DNI CHAR(9) CHECK(DNI LIKE ('[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]')),
    constrasena VARCHAR(36) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
	nombre_completo VARCHAR(255) NOT NULL,
	nombre_sistema VARCHAR(36),
    FOREIGN KEY (nombre_sistema) REFERENCES SISTEMA(nombre),
    PRIMARY KEY(DNI)
);