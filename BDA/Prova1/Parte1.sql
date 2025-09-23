 drop database if exists Parte1;
 create database Parte1;
 use Parte1;
 set foreign_key_checks = 0;
 drop table if exists bolo;
 drop table if exists confeiteiro;
 set foreign_key_checks = 1;
 
 create table confeiteiro(
 idConfeiteiro int auto_increment not null primary key unique,
 nome varchar(45),
 dataNasc date
 )engine InnoDB;
 
 create table bolo(
 idBolo int auto_increment not null primary key unique,
 sabor varchar(45),
 cobertura varchar (45),
 idConfeiteiro int,
 foreign key (idConfeiteiro) references confeiteiro(idConfeiteiro)
	on delete cascade
    on update cascade
 )engine InnoDB;
 
/* 
 2) (10 pontos) Insira os seguintes dados no banco (sem indicar os valores das chaves primárias): 
 Confeiteiro
  • Joao, 1990-05-12
  • Maria, 1985-11-23
  • Carlos, 1992-07-01
 */
 
 insert into confeiteiro (nome,dataNasc) 
	values ('Joao', 19900512),
		   ('Maria', 19851123),
           ('Carlos', 19920701);
           
/*
  Bolo
 • Chocolate, Morango, (confeiteiro João) - 1
 • Baunilha, Chocolate, (confeiteiro Maria) - 2
 • Cenoura, Chocolate, (confeiteiro Carlos) - 3
 • Limão, Limão, (confeiteiro Maria) - 2
 • Floresta Negra, Chantilly, (confeiteiro João) - 1 
*/
 insert into bolo (sabor, cobertura, idConfeiteiro)
	values ('Chocolate','Morango','1'),
		   ('Baunilha','Chocolate','2'),
           ('Cenoura','Chocolate','3'),
           ('Limão','Limão','2'),
           ('Floresta Negra','Chantilly','1');
           
 -- 3. (10 pontos) Corrija o nome do confeiteiro Carlos para Carlos Eduardo.
 update confeiteiro set nome = 'Carlos Eduardo' where idConfeiteiro = '3'; -- feito
 
/*
 4. (10 pontos) Supondo que você queira remover a confeiteira “Maria” e todos os bolos associados a ela, escreva o(s) comando(s) SQL necessários para realizar essa exclusão em uma única operação. Caso
 não tenha preparado essa opção na criação da tabela, descreva também os comandos necessários para habilitar essa funcionalidade.
*/
 delete from confeiteiro where idConfeiteiro = '2'; -- FEITO 

 
 
 