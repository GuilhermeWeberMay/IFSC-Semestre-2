-- show databases;
-- create database aula01;
use aula01;

set foreign_key_checks = 0;
drop table if exists pessoas;
set foreign_key_checks = 1;

-- Estrutura para tabela 'Pessoas'
create table pessoas (
 id int not null auto_increment,
 nome varchar(1024) not null,
 email varchar(1024) not null,
 primary key (id)
 )engine InnoDB;
 
 -- O comando DESCRIBE descreve o formato da tabela atual, mesmo com alterações posteriores
 -- describe pessoas;
 
 -- O comando SHOWTABLES mostra todas as tabelas somente desta DATABASE 
 -- show tables;
-- select * from pessoas;