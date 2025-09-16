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
  FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT,
 cargaHoraria INT NOT NULL,
 nome VARCHAR(45)
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
    ('João Santos','joao@email.com');

 INSERT INTO Curso (nome, area) VALUES
	('Administração','Negócios'),
    ('Direito','Jurídico'),
    ('Medicina','Saúde'),
    ('Arquitetura','Engenharia'),
    ('Engenharia de Software','Computação');

 INSERT INTO Disciplina (idCurso, cargaHoraria, nome) VALUES
	('1','60','Programação I'),
    ('1','60','Banco de Dados'),
    ('2','40','Gestão Financeira'),
    ('3','80','Direito Constitucional'),
    ('4','100','Anatomia');

INSERT INTO Participa (idDisciplina,idAluno,nota,frequencia) VALUES
	('1','1','85','90'), -- Ana - Programação I
    ('2','2','78','95'), -- Bruno - Banco de Dados
    ('3','3','88','92'), -- Carlos - Gestão Financeira
    ('4','4','75','85'), -- Mariana - Direito Constitucional 
    ('5','5','90','98'); -- João - Anatomia 

-- ===== ATIVIDADES =====
-- SELEÇÃO SIMPLES 
(
-- 1. Listar todos os dados da tabela Cursos.
	#SELECT * FROM Curso;
-- 2. Listar todas as disciplinas.
	#SELECT * FROM Disciplina;
-- 3. Selecionar nomes e emails dos alunos.
	#SELECT nome, email FROM Aluno;
-- 4. Listar todos os registros da tabela Participa.
	#SELECT * FROM Participa;
)
 -- FILTRAGEM COM WHERE
(
-- 5. Selecionar alunos com idAluno menor que 5.
	#SELECT nome FROM Aluno WHERE idAluno < 5;
-- 6. Selecionar alunos com nota maior que 80.
	#SELECT * FROM Participa WHERE nota > 80;
-- 7. Selecionar disciplinas com carga horária menor que 60.
	#SELECT * FROM Disciplina WHERE cargaHoraria < 60;
-- 8. Selecionar cursos da área 'Negócios'.
	#SELECT * FROM Curso WHERE area = 'Negócios';
-- 9. Selecionar participações com frequência menor que 90.
	#SELECT * FROM Participa WHERE frequencia < 90;
-- 10. Selecionar alunos com idAluno 3 ou 4.
	#SELECT * FROM Aluno WHERE idAluno IN (3,4);
)


