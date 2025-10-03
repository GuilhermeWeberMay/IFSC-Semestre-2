drop database if exists Exerc6;
create database Exerc6;
use Exerc6;

create table Produto(
 id int primary key auto_increment,
 nome varchar(1024) not null,
 descricao text not null,
 preco decimal(10,2) not null
)engine=InnoDB;

create table Desconto(
 id int primary key auto_increment,
 porcentagem int not null,
 idProduto int unique,
 foreign key (idProduto) references Produto(id)
)engine=InnoDB;

insert into Produto (nome, descricao, preco) values
('Camiseta Esportiva', 'Camiseta leve e confortável para prática esportiva', 100.00),
('Tênis de Corrida', 'Tênis de alto desempenho para corrida', 250.00),
('Bola de Futebol', 'Bola oficial tamanho 5', 120.00),
('Raquete de Tênis', 'Raquete de fibra de carbono', 350.00),
('Mochila Esportiva', 'Mochila resistente para academia ou esporte', 180.00),
('Smartwatch', 'Relógio inteligente com monitor cardíaco', 500.00);

insert into Desconto (porcentagem, idProduto) values
(10, 1), -- Camiseta
(20, 2), -- Tênis
(15, 3), -- Bola
(0, 4),  -- Raquete
(5, 6);  -- Smartwatch

delimiter //

create procedure calcularPrecoComDesconto(
    in preco decimal(10,2),
    in desconto int
)
begin
    declare precoFinal decimal(10,2);
    set precoFinal = preco - (preco * (desconto/100));
    select precoFinal as preco_com_desconto;
end //

create procedure precoProdutoComDesconto(in idProd int)
begin
    declare vPreco decimal(10,2);
    declare vDesc int default 0;

    select preco into vPreco from Produto where id = idProd;

    select ifnull(porcentagem,0) into vDesc 
    from Desconto 
    where idProduto = idProd;

    select vPreco as preco_original,
           vDesc as desconto,
           (vPreco - (vPreco * (vDesc/100))) as preco_com_desconto;
end //

create procedure listarProdutosComDesconto()
begin
    select 
        Produto.id,
        Produto.nome,
        Produto.preco as preco_original,
        ifnull(Desconto.porcentagem,0) as desconto,
        (Produto.preco - (Produto.preco * (ifnull(Desconto.porcentagem,0)/100))) as preco_com_desconto
    from Produto
    left join Desconto on Produto.id = Desconto.idProduto;
end //

delimiter ;

call precoProdutoComDesconto(2);

call listarProdutosComDesconto();

call calcularPrecoComDesconto(200, 15);
