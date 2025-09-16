DROP DATABASE IF EXISTS Revisao;
CREATE DATABASE Revisao;
USE Revisao;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS Aluno;
DROP TABLE IF EXISTS Curso;
DROP TABLE IF EXISTS Disciplina;
DROP TABLE IF EXISTS Participa;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE Aluno(
 idAluno INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
 nome VARCHAR(45) NOT NULL,
 email VARCHAR(45) NOT NULL
)ENGINE InnoDB;

CREATE TABLE Curso(
 idCurso INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
 nome VARCHAR(45) NOT NULL,
 area VARCHAR(45) NOT NULL
)ENGINE InnoDB;

CREATE TABLE Disciplina(
 idDisciplina INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
 idCurso INT NOT NULL,
 cargaHoraria INT NOT NULL,
 nome VARCHAR(45),
 FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT
)ENGINE InnoDb;

CREATE TABLE Participa (
 idDisciplina INT NOT NULL,
	FOREIGN KEY (idDisciplina) REFERENCES Disciplina(idDisciplina)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,
 idAluno INT NOT NULL,
	FOREIGN KEY (idAluno) REFERENCES Aluno(idAluno)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,
 nota INT NOT NULL,
 frequencia INT NOT NULL,
 PRIMARY KEY (idDisciplina,idAluno)
)ENGINE InnoDB;

-- ===== POVOAMENTO DO BANCO DE DADOS =====
INSERT INTO Aluno (nome, email) VALUES 
	('Ana Luiza','ana@email.com'),
    ('Bruno Silva','bruno@email.com'),
    ('Carlos Pereira','carlos@email.com'),
    ('Mariana Souza','mariana@email.com'),
    ('João Santos','joao@email.com')

-- INSERT INTO Curso (nome






