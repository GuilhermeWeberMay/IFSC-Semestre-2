drop database if exists Exerc6;
create database Exerc6;
use Exerc6;

create table Produto(
 id int primary key auto_increment unique not null,
 nome varchar(1024) not null,
 descricao text not null,
 preco decimal(10,2) not null
 )engine InnoDB;
 
create table Desconto(
 id int primary key auto_increment unique not null,
 porcentagem int not null,
 idProduto int not null,
 foreign key (idProduto) references Produto(id)
 )engine InnoDB;
 
 delimiter //
 
 create procedure calcularDesconto(preco decimal(10,2), porcentagem int)
	begin
		declare precoFinal int;
        set precoFinal = preco - (preco * porcentagem / 100);
        select precoFinal;
	end //

delimiter // ;

call calcularDesconto(100,10);