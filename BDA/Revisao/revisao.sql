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
	('1','1','95','90'), -- Ana - Programação I
    ('2','2','78','95'), -- Bruno - Banco de Dados
    ('3','3','88','92'), -- Carlos - Gestão Financeira
    ('4','4','75','85'), -- Mariana - Direito Constitucional 
    ('5','5','90','98'); -- João - Anatomia 

 -- ===== ATIVIDADES =====
 -- SELEÇÃO SIMPLES 
/*
-- 1. Listar todos os dados da tabela Cursos.
	SELECT * FROM Curso;
-- 2. Listar todas as disciplinas.
	SELECT * FROM Disciplina;
-- 3. Selecionar nomes e emails dos alunos.
	SELECT nome, email FROM Aluno;
-- 4. Listar todos os registros da tabela Participa.
	SELECT * FROM Participa;
*/
 -- FILTRAGEM COM WHERE
/*
-- 5. Selecionar alunos com idAluno menor que 5.
	SELECT nome FROM Aluno WHERE idAluno < 5;
-- 6. Selecionar alunos com nota maior que 80.
	SELECT * FROM Participa WHERE nota > 80;
-- 7. Selecionar disciplinas com carga horária menor que 60.
	SELECT * FROM Disciplina WHERE cargaHoraria < 60;
-- 8. Selecionar cursos da área 'Negócios'.
	SELECT * FROM Curso WHERE area = 'Negócios';
-- 9. Selecionar participações com frequência menor que 90.
	SELECT * FROM Participa WHERE frequencia < 90;
-- 10. Selecionar alunos com idAluno 3 ou 4.
	SELECT * FROM Aluno WHERE idAluno IN (3,4);
*/
 -- FILTRAGEM COM LIKE 
/*
-- 11. Selecionar alunos cujo nome começa com 'M'.
	SELECT * FROM Aluno WHERE nome LIKE 'M%';
-- 12. Selecionar alunos cujo nome termina com 'a'.
	SELECT * FROM Aluno WHERE nome LIKE '%a';
-- 13. Selecionar disciplinas cujo nome contenha 'Banco'.
	SELECT * FROM Disciplina WHERE nome LIKE '%Banco%';
-- 14. Selecionar cursos cuja área contenha 'Engenharia'.
	SELECT * FROM Curso WHERE area LIKE '%Engenharia%';
-- 15. Selecionar alunos com nome de exatamente 5 letras.
	SELECT * FROM Aluno WHERE nome LIKE '_____'
*/
 -- FILTRAGEM COM IN
/*
 -- 16. Selecionar alunos com idAluno 2, 4 ou 5.
	SELECT * FROM Aluno WHERE idAluno IN (2,4,5);
 -- 17. Selecionar disciplinas cujo codCurso seja 1 ou 3.
	SELECT * FROM Disciplina WHERE idCurso IN (1,3);
 -- 18. Selecionar participações com nota 75, 80 ou 85.
	SELECT * FROM Participa WHERE nota IN (75,80,85);
 -- 19. Selecionar cursos com codCurso 2, 4 ou 5.
	SELECT * FROM Curso WHERE idCurso IN (2,4,5);
 -- 20. Selecionar alunos cujo idAluno esteja na lista de alunos com frequência > 90 (subconsulta)
	SELECT * FROM Aluno WHERE idAluno IN (SELECT idAluno FROM Participa WHERE frequencia > 90);
*/
 -- FILTRAGEM COM GROUP BY e HAVING
(
 -- 21. Calcular a média de nota de cada disciplina.
 /*
	SELECT idDisciplina, AVG(nota) AS médiaDisciplina
    FROM Participa GROUP BY idDisciplina;
 */
 -- 22. Contar alunos por disciplina.
  /*
	SELECT idDisciplina, COUNT(idDisciplina) AS contagem
    FROM Participa GROUP BY idDisciplina;
 */
 -- 23. Mostrar disciplinas com média de frequência > 85.
 /*
	SELECT idDisciplina, AVG(frequencia) AS mediaFrequencia
    FROM Participa GROUP BY idDisciplina
    HAVING AVG(frequencia) > 85;
 */
 -- 24. Exibir cursos com mais de 2 disciplinas.
 /*
	SELECT idCurso, COUNT(idCurso) AS qtdCurso
    FROM Disciplina GROUP BY idCurso 
    HAVING COUNT(idCurso) > 1;
 */
 -- 25. Mostrar alunos com média de nota > 80.
 /*
	SELECT idAluno, AVG(nota) as mediaAluno
    FROM Participa GROUP BY idAluno
    HAVING AVG(nota) > 80;
 */
 )
 -- FILTRAGEM COM ORDER BY
/*
 -- 26. Listar alunos ordenados por nome crescente.
	SELECT * FROM Aluno ORDER BY nome ASC;
 -- 27. Listar disciplinas por carga horária decrescente.
	SELECT * FROM Disciplina ORDER BY cargaHoraria DESC;
 -- 28. Listar participações por frequência crescente.
	SELECT * FROM Participa ORDER BY frequencia ASC;
 -- 29. Listar alunos por nota decrescente.
	SELECT * FROM Participa ORDER BY nota DESC;
 -- 30. Listar cursos ordenados por área alfabeticamente.
	SELECT * FROM Curso ORDER BY area ASC;
*/
 -- FILTRAGEM COM DISTINCT
/*
 -- 31. Listar todas as áreas de cursos sem repetição.
	SELECT DISTINCT area FROM Curso;
 -- 32. Listar todos os nomes de alunos distintos.
	SELECT DISTINCT nome FROM Aluno;
 -- 33. Listar todas as disciplinas distintas.
	SELECT DISTINCT nome FROM Disciplina;
 -- 34. Listar todas as notas distintas na tabela Participa.
	SELECT DISTINCT nota FROM Participa;
 -- 35. Listar todos os códigos de curso distintos que possuem disciplinas.
	SELECT DISTINCT idCurso FROM Disciplina;
*/
 -- FILTRAGEM COM UNION / UNION ALL
 (
 -- 36. Listar nomes de alunos e disciplinas sem repetição.
 /*
	SELECT nome FROM Aluno 
    UNION 
    SELECT nome FROM Disciplina;
 */
 -- 37. Listar emails de alunos e cursos (todos inclusivos).
 /*
	SELECT email FROM Aluno
    UNION ALL
    SELECT area FROM Curso;
 */
 -- 38. Combinar alunos com nota > 80 ou frequência > 90.
 /*
	SELECT idAluno FROM participa WHERE nota > 80
    UNION
    SELECT idAluno FROM participa WHERE frequencia > 90;
 */
 -- 39. Listar disciplinas e cursos da área 'Engenharia'.
 /*
	SELECT nome FROM Disciplina WHERE nome LIKE '%Engenharia%'
    UNION 
    SELECT nome FROM Curso WHERE area LIKE '%Engenharia%';
 */
 -- 40. Listar alunos e professores (assumindo tabela Professor).
 )
 -- ===== ATIVIDADES =====
 -- SELECT A PARTIR DE OUTRO SELECT
/*
 -- 1. Selecionar nomes de alunos que possuem nota maior que 75.
	SELECT nome FROM Aluno WHERE idAluno IN (SELECT idAluno FROM Participa WHERE nota > 75);
 -- 2. Selecionar nomes de disciplinas que têm carga horária menor que a média das disciplinas.
	SELECT nome FROM Disciplina WHERE cargaHoraria < (SELECT AVG(cargaHoraria) FROM Disciplina);
 -- 3. Selecionar nomes de alunos que possuem frequência menor que a média de frequência da tabela Participa.
	SELECT nome FROM Aluno WHERE idAluno IN (
		SELECT idAluno FROM Participa WHERE frequencia < (SELECT AVG(frequencia) FROM Participa));
 -- 4. Selecionar cursos que possuem menos disciplinas que a média de disciplinas por curso.
	SELECT nome FROM Disciplina WHERE idCurso IN
		(SELECT idCurso FROM Disciplina GROUP BY idCurso HAVING COUNT(idCurso) < 
			(SELECT AVG(qtd) FROM (	SELECT COUNT(idCurso) AS qtd FROM Disciplina GROUP BY idCurso) AS t));
 -- 5. Selecionar idAluno dos alunos que obtiveram a maior nota em alguma disciplina.
	SELECT nome FROM Aluno WHERE idAluno IN (SELECT idAluno FROM Participa WHERE nota = (SELECT MAX(nota) FROM Participa));
*/
 -- SELECT A PARTIR DE NATURAL JOIN
/*
 -- 1. Listar nome do aluno e nota usando NATURAL JOIN.
	SELECT Aluno.nome, Participa.nota FROM Aluno NATURAL JOIN Participa;
 -- 2. Listar nome do aluno e frequência usando NATURAL JOIN.
	SELECT Aluno.nome, Participa.frequencia FROM Aluno NATURAL JOIN Participa;
 -- 3. Selecionar codDisciplina e nota usando NATURAL JOIN.
	SELECT Disciplina.nome, Disciplina.idDisciplina, Participa.nota FROM Disciplina NATURAL JOIN Participa;
 -- 4. Listar todos os dados de Aluno e Participa usando NATURAL JOIN.
	SELECT * FROM Aluno NATURAL JOIN Participa;
 -- 5. Selecionar nomes dos alunos com nota maior que 80 usando NATURAL JOIN.
	SELECT nome, nota FROM Aluno NATURAL JOIN Participa WHERE nota > 80;
*/
 -- SELECT A PARTIR DE INNER JOIN
 -- 1. Listar nome do aluno e nota usando INNER JOIN.
 -- 2. Listar nome do aluno e frequência usando INNER JOIN.
 -- 3. Selecionar nome do aluno, nome da disciplina e nota usando INNER JOIN com Disciplina.
 -- 4. Listar todos os alunos e notas onde a nota seja maior que 75 usando INNER JOIN.
 -- 5. Selecionar idAluno, nome e frequência usando INNER JOIN, ordenando por frequência decrescente.

