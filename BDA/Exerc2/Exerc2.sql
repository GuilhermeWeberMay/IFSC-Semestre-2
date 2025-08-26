-- create database Exerc2;
use Exerc2;

set foreign_key_checks = 0;
drop table if exists cursos;
drop table if exists matriculas;
drop table if exists disciplinas;
drop table if exists alunos;
set foreign_key_checks = 1;

create table cursos (
 id int primary key unique auto_increment not null,
 nome varchar(256) not null,
 descricao text not null
 ) engine InnoDB;
 
 create table disciplinas (
 id int primary key unique auto_increment not null,
 nome varchar(256) not null,
 cursos_id int not null,
 foreign key (cursos_id) references cursos(id)
 ) engine InnoDB;
 
 create table alunos (
 id int primary key unique auto_increment not null,
 nome varchar(512) not null,
 email varchar(100) not null,
 telefone varchar(20) not null
 ) engine InnoDB;
 
 create table matriculas (
 id int primary key unique auto_increment not null,
 alunos_id int not null,
 cursos_id int not null,
 disciplinas_id int not null,
 foreign key (alunos_id) references alunos(id),
 foreign key (cursos_id) references cursos(id),
 foreign key (disciplinas_id) references disciplinas(id)
 ) engine InnoDB;

-- Povoamento do Banco de dados
-- Cursos
INSERT INTO cursos (nome, descricao) VALUES
('Curso de Finanças', 'Aprenda os fundamentos das finanças no mercado luxemburguês.'),
('Curso de Direito Internacional', 'Estudo das leis internacionais com foco na União Europeia.'),
('Curso de Tecnologia da Informação', 'Introdução às tecnologias emergentes no setor de TI em Luxemburgo.'),
('Curso de Gestão de Fundos', 'Conheça as melhores práticas para gestão de fundos de investimento.'),
('Curso de Desenvolvimento Sustentável', 'Princípios e práticas para promover a sustentabilidade ambiental e econômica.');

-- Disciplinas
INSERT INTO disciplinas (nome, cursos_id) VALUES
('Fundamentos de Economia', 1),
('Legislação Europeia', 2),
('Programação em Python', 3),
('Análise de Investimentos', 4),
('Gestão de Recursos Naturais', 5);

-- Alunos
INSERT INTO alunos (nome, email, telefone) VALUES
('Lucas Müller', 'lucas.muller@example.lu', '+352 621 123 456'),
('Sophie Weber', 'sophie.weber@example.lu', '+352 621 654 321'),
('Maximilian Schmit', 'max.schmit@example.lu', '+352 621 789 012'),
('Emma Hoffmann', 'emma.hoffmann@example.lu', '+352 621 345 678'),
('Marie Dupont', 'marie.dupont@example.lu', '+352 621 901 234');
  
INSERT INTO matriculas (alunos_id, cursos_id, disciplinas_id) VALUES
(1, 1, 1),  -- Lucas Müller: Curso de Finanças Luxemburguês -> Fundamentos de Economia
(2, 2, 2),  -- Sophie Weber: Curso de Direito Internacional -> Legislação Europeia
(3, 3, 3),  -- Maximilian Schmit: Curso de Tecnologia da Informação -> Programação em Python
(4, 4, 4),  -- Emma Hoffmann: Curso de Gestão de Fundos -> Análise de Investimentos
(5, 5, 5);  -- Marie Dupont: Curso de Desenvolvimento Sustentável -> Gestão de Recursos Naturais

-- Exercicios 
-- Remova linhas da tabela Matriculas
delete from matriculas where id = 1;
-- Não é necessário colocar * no delete por conta do delete apagar a linha inteira!
-- Primeiro delete nas chaves estrangeiras depois a primaria!

-- Remova linhas da tabela Disciplinas que sejam referenciadas na tabela Matriculas
delete from disciplinas where id = 1;

-- Remova linhas da tabela Alunos que sejam referenciadas na tabela Matriculas
delete from alunos where id = 1;

-- Remova linhas da tabela Cursos que sejam referenciadas na tabela Disciplinas
delete from cursos where id = 1;

-- Alteração 
ALTER TABLE disciplinas
ADD FOREIGN KEY (cursos_id) REFERENCES cursos(id)
ON DELETE CASCADE;

alter table matriculas
add foreign key (alunos_id) references alunos(id),
add foreign key (cursos_id) references cursos(id),
add foreign key (disciplinas_id) references disciplinas(id)
on delete cascade;
-- ALter table so podem ser feitas com chaves estrangeiras!