CREATE DATABASE dbwork;
USE dbwork;

CREATE TABLE usuarios
(
    id int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    senha varchar(50) NOT NULL
);