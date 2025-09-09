 drop database if exists Exerc5;
 create database Exerc5;
 use Exerc5;
 set foreign_key_checks = 0;
 drop table if exists produtos;
 drop table if exists fornecedores;
 drop table if exists estoque;
 drop table if exists pedidos;
 set foreign_key_checks = 1;
 
 create table produtos(
 idProduto int primary key auto_increment not null unique,
 nome varchar(256) not null,
 descricao text not null,
 peso float not null
)engine InnoDB;

create table fornecedores(
idFornecedor int primary key auto_increment not null unique,
 nome varchar(256) not null,
 email varchar(256) not null,
 telefone varchar(25) not null
 )engine InnoDB;

create table estoque(
 idEstoque int primary key auto_increment not null unique,
 idFornecedores int not null,
 idProdutos int not null,
 disponiveis int not null,
 custo float not null,
 foreign key (idFornecedores) references fornecedores(idFornecedor)
 on delete restrict
 on update restrict,
 foreign key (idProdutos) references produtos(idProduto)
 on delete restrict
 on update restrict
 )engine InnoDB;
 
 create table pedidos(
 idPedidos int primary key auto_increment not null unique,
 idFornecedores int not null,
 idProdutos int not null,
 quantidade int not null,
 valor float not null,
 foreign key (idFornecedores) references fornecedores(idFornecedores)
 on delete restrict
 on update restrict,
 foreign key (idProdutos) references produtos(idProduto)
 on delete restrict
 on update restrict
 );