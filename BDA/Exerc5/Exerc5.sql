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
 
 -- POVOAMENTO DO BANCO DE DADOS
 -- Tabela de produtos
 INSERT INTO produtos (nome, descricao, peso) VALUES
('Camiseta Básica', 'Camiseta de algodão 100%, confortável e leve.', 0.200),
('Notebook Gamer', 'Computador portátil com placa gráfica dedicada e alta performance.', 2.500),
('Smartphone X100', 'Smartphone com tela de 6.5", câmera de 48MP e bateria de longa duração.', 0.180),
('Mochila Escolar', 'Mochila com vários compartimentos, ideal para estudantes.', 0.750),
('Cadeira de Escritório', 'Cadeira ergonômica com ajuste de altura e suporte lombar.', 8.000),
('Livro "Aprendendo SQL"', 'Livro didático para iniciantes em SQL, com exercícios práticos.', 0.600),
('Fone de Ouvido Bluetooth', 'Fone sem fio com cancelamento de ruído e bateria de 20 horas.', 0.150),
('Caneca Personalizada', 'Caneca de cerâmica com estampa personalizada, capacidade 350ml.', 0.350),
('Relógio de Pulso', 'Relógio analógico com pulseira de couro e resistência à água.', 0.100),
('Mesa de Centro', 'Mesa de centro de madeira com acabamento em verniz.', 12.000);

-- Tabela de fornecedores 
INSERT INTO fornecedores (nome, email, telefone) VALUES
('Tech Solutions Ltda', 'contato@techsolutions.com', '+55 11 98765-4321'),
('Distribuidora Central', 'vendas@distribuidoracentral.com', '+55 21 99876-5432'),
('Mundo Eletrônicos', 'suporte@mundoeletronicos.com', '+55 31 91234-5678'),
('Papelaria & Cia', 'contato@papelariaecia.com', '+55 41 99887-7766'),
('Alimentos São José', 'sac@alimento-saojose.com', '+55 51 99999-0000'),
('ConstruFácil', 'atendimento@construfacil.com', '+55 27 98888-7777'),
('Moda & Estilo', 'comercial@modaestilo.com', '+55 61 97777-6666'),
('Peças Auto Brasil', 'vendas@pecasautobrasil.com', '+55 71 95555-4444');

-- Tabela de estoque
INSERT INTO estoque (idFornecedores, idProdutos, disponiveis, custo) VALUES
(7, 1, 150, 25.00),     -- Camiseta Básica do fornecedor Moda & Estilo
(1, 2, 50, 4500.00),    -- Notebook Gamer da Tech Solutions Ltda
(3, 3, 100, 1200.00),   -- Smartphone X100 do Mundo Eletrônicos
(4, 4, 200, 80.00),     -- Mochila Escolar da Papelaria & Cia
(6, 5, 20, 1200.00),    -- Cadeira de Escritório da ConstruFácil
(2, 6, 300, 40.00),     -- Livro "Aprendendo SQL" da Distribuidora Central
(1, 7, 120, 150.00),    -- Fone de Ouvido Bluetooth da Tech Solutions Ltda
(4, 8, 180, 30.00),     -- Caneca Personalizada da Papelaria & Cia
(7, 9, 75, 300.00),     -- Relógio de Pulso da Moda & Estilo
(6, 10, 15, 850.00);    -- Mesa de Centro da ConstruFácil

-- Tabela de pedidos
INSERT INTO pedidos (idFornecedores, idProdutos, quantidade, valor) VALUES
(7, 1, 50, 30.00),      -- Pedido de 50 Camisetas Básicas (Moda & Estilo)
(1, 2, 5, 4800.00),     -- Pedido de 5 Notebooks Gamer (Tech Solutions Ltda)
(3, 3, 20, 1300.00),    -- Pedido de 20 Smartphones X100 (Mundo Eletrônicos)
(4, 4, 100, 85.00),     -- Pedido de 100 Mochilas Escolares (Papelaria & Cia)
(6, 5, 10, 1250.00),    -- Pedido de 10 Cadeiras de Escritório (ConstruFácil)
(2, 6, 150, 45.00),     -- Pedido de 150 Livros "Aprendendo SQL" (Distribuidora Central)
(1, 7, 40, 160.00),     -- Pedido de 40 Fones Bluetooth (Tech Solutions Ltda)
(4, 8, 75, 35.00),      -- Pedido de 75 Canecas Personalizadas (Papelaria & Cia)
(7, 9, 30, 320.00),     -- Pedido de 30 Relógios de Pulso (Moda & Estilo)
(6, 10, 5, 900.00);     -- Pedido de 5 Mesas de Centro (ConstruFácil)

-- EXERCICIOS
-- 1) Mostrar a lista de fornecedores dos produtos que aparecem em pedidos;
-- select distinct fornecedores.nome from fornecedores natural join pedidos;
-- 1.1)Mostrar a lista de fornecedores em ordem alfabética e sem repetições
-- select distinct fornecedores.nome from fornecedores natural join pedidos order by fornecedores.nome;
-- 1.2)Mostrar a lista de fornecedores com o nome dos produtos fornecidos
select fornecedores.nome, produto.nome from produto natural join estoque join fornecedor on estoque.idForncedor = fornecedor.id;
-- 1.3)Mostrar a lista de fornecedores com o valor total de vendas




/*
select * from produtos;
select * from fornecedores;
select * from estoque;
select * from pedidos
*/