DROP DATABASE IF EXISTS carWash;
CREATE DATABASE carWash;
USE carWash;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS Clientes;
DROP TABLE IF EXISTS Carros;
DROP TABLE IF EXISTS Servicos;
DROP TABLE IF EXISTS Funcionario;
DROP TABLE IF EXISTS pessoaJuridica;
DROP TABLE IF EXISTS pessoaFisica;
DROP TABLE IF EXISTS OrdemServico;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE Clientes
(
  idCliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  telefone CHAR(11) NOT NULL,
  telefone2 CHAR(11) NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  dataNascimento DATE NOT NULL,
  pontoCliente INT NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  numero VARCHAR(5) NOT NULL,
  cidade VARCHAR(40) NOT NULL,
  estado CHAR(2) NOT NULL,
  cep CHAR(8) NOT NULL,

  PRIMARY KEY (idCliente)
) ENGINE=InnoDB;

CREATE TABLE Carros
(
  placa CHAR(7) NOT NULL,
  modelo VARCHAR(20) NOT NULL,
  ano CHAR(4) NOT NULL,
  cor VARCHAR(20) NOT NULL,
  marca VARCHAR(20) NOT NULL,
  idCliente INT NOT NULL,
  PRIMARY KEY (placa),
  FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE Servicos
(
  idServico INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL,
  valor FLOAT NOT NULL,
  dataCadastro DATE NOT NULL,
  pontuacaoGerada INT NOT NULL,
  PRIMARY KEY (idServico)
) ENGINE=InnoDB;

CREATE TABLE Funcionario
(
  idFuncionario INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  dataNascimento DATE NOT NULL,
  cpf CHAR(11) NOT NULL UNIQUE,
  email VARCHAR(50) NOT NULL UNIQUE,
  telefone CHAR(11) NOT NULL,
  telefone2 CHAR(11) NULL,
  endereco VARCHAR(100) NOT NULL,
  numero VARCHAR(5) NOT NULL,
  cidade VARCHAR(40) NOT NULL,
  estado CHAR(2) NOT NULL,
  cep CHAR(8) NOT NULL,

  PRIMARY KEY (idFuncionario)
) ENGINE=InnoDB;

CREATE TABLE pessoaJuridica
(
  cnpj CHAR(14) NOT NULL UNIQUE,
  idCliente INT NOT NULL,
  PRIMARY KEY (idCliente),
  FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE pessoaFisica
(
  cpf CHAR(11) NOT NULL UNIQUE,
  idCliente INT NOT NULL,
  PRIMARY KEY (idCliente),
  FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE OrdemServico
(
  idOS INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  totalPontos INT NOT NULL,
  valor FLOAT NOT NULL,
  valorDesconto FLOAT NOT NULL,
  placa CHAR(7) NOT NULL,
  idFuncionario INT NOT NULL,
  idServico INT NOT NULL,
  idCliente INT NOT NULL,
  PRIMARY KEY (idOS),
  FOREIGN KEY (placa) REFERENCES Carros(placa)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  FOREIGN KEY (idFuncionario) REFERENCES Funcionario(idFuncionario)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  FOREIGN KEY (idServico) REFERENCES Servicos(idServico)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- ========================================================
-- POVOAMENTO DAS TABELAS
-- ========================================================

INSERT INTO Clientes (nome, telefone, telefone2, email, dataNascimento, pontoCliente, endereco, numero, cidade, estado, cep)
VALUES
('João da Silva','11912345678',NULL,'joao.silva@email.com','1985-06-15',1200,'Rua das Flores','123','São Paulo','SP','01019010'),
('Maria Oliveira','11998765432',NULL,'maria.oliveira@email.com','1990-03-22',950,'Av. Paulista','1500','São Paulo','SP','01310100'),
('Carlos Pereira','31988881122',NULL,'carlos.pereira@email.com','1978-11-05',1340,'Rua das Acácias','45','Belo Horizonte','MG','30310000'),
('Ana Lima','51998763322',NULL,'ana.lima@email.com','1993-08-14',870,'Rua das Hortênsias','120','Porto Alegre','RS','91310000'),
('Ricardo Menezes','92991237788',NULL,'ricardo.menezes@email.com','1982-12-02',1430,'Av. Dom Pedro I','456','Manaus','AM','69050000'),
('Camila Duarte','71987654433',NULL,'camila.duarte@email.com','2000-05-30',610,'Travessa São José','32','Salvador','BA','41299150'),
('Pedro Nunes','61992341111',NULL,'pedro.nunes@email.com','1989-04-19',790,'Rua Brasília','58','Brasília','DF','70040900'),
('Luana Costa','85991234567',NULL,'luana.costa@email.com','1995-07-01',880,'Av. Beira Mar','200','Fortaleza','CE','60165121'),
('Marcos Rocha','41999887766',NULL,'marcos.rocha@email.com','1987-10-12',1020,'Rua XV de Novembro','33','Curitiba','PR','80020000'),
('Fernanda Alves','61999988877',NULL,'fernanda.alves@email.com','1992-01-23',670,'Av. Central','250','Goiânia','GO','74000010');

INSERT INTO Carros (placa, modelo, ano, cor, marca, idCliente)
VALUES
('ABC1D23','Civic','2020','Preto','Honda',1),
('XYZ9K88','Corolla','2019','Prata','Toyota',2),
('MNO3B45','Gol','2015','Vermelho','Volkswagen',3),
('JKL4H56','Onix','2021','Branco','Chevrolet',4),
('RTY8U22','HB20','2022','Cinza','Hyundai',5),
('FDS7G44','Polo','2018','Azul','Volkswagen',6),
('POI6M33','Fiesta','2016','Branco','Ford',7),
('LKJ3D55','Compass','2023','Preto','Jeep',8),
('TRE8X90','Argo','2020','Vermelho','Fiat',9),
('BVC2N77','Renegade','2021','Prata','Jeep',10);

INSERT INTO Servicos (descricao, valor, dataCadastro, pontuacaoGerada)
VALUES
('Lavagem simples',30.00,'2025-07-25',30),
('Lavagem completa',50.00,'2025-07-25',50),
('Lavagem + Cera',70.00,'2025-07-25',70),
('Higienização interna',100.00,'2025-07-25',100),
('Polimento técnico',250.00,'2025-07-25',250),
('Cristalização de pintura',180.00,'2025-07-25',180),
('Limpeza de motor',90.00,'2025-07-25',90),
('Descontaminação de pintura',120.00,'2025-07-25',120),
('Hidratação de bancos',110.00,'2025-07-25',110),
('Lavagem premium + enceramento',200.00,'2025-07-25',200);

INSERT INTO Funcionario (nome,dataNascimento,cpf,email,telefone,telefone2,endereco,numero,cidade,estado,cep)
VALUES
('Lucas Martins','1992-04-10','12345678900','lucas.martins@email.com','19912345678',NULL,'Rua do Progresso','45','Campinas','SP','13010010'),
('Fernanda Souza','1988-09-22','98765432100','fernanda.souza@email.com','41998765432',NULL,'Av. Brasil','200','Curitiba','PR','80050000'),
('Rafael Lima','1995-01-15','45678912300','rafael.lima@email.com','81991234567',NULL,'Rua das Palmeiras','88','Recife','PE','50000000'),
('Juliana Mendes','1990-02-25','65498732100','juliana.mendes@email.com','11998877665',NULL,'Av. Independência','400','São Paulo','SP','01020000'),
('Bruno Costa','1985-08-30','32165498700','bruno.costa@email.com','61991231234',NULL,'Rua Goiás','15','Goiânia','GO','74000000'),
('Patrícia Gomes','1993-11-12','85274196300','patricia.gomes@email.com','31988887777',NULL,'Av. Afonso Pena','300','Belo Horizonte','MG','30130000'),
('Rodrigo Alves','1987-03-10','96325874100','rodrigo.alves@email.com','71992334455',NULL,'Rua Porto','120','Salvador','BA','40010000'),
('Aline Ribeiro','1996-05-22','74185296300','aline.ribeiro@email.com','51991234455',NULL,'Av. Ipiranga','900','Porto Alegre','RS','90040000'),
('Thiago Moreira','1989-10-14','15975348600','thiago.moreira@email.com','61998887711',NULL,'Rua das Oliveiras','66','Brasília','DF','70000000'),
('Mariana Lopes','1994-12-05','75395148600','mariana.lopes@email.com','85998775544',NULL,'Av. Santos Dumont','560','Fortaleza','CE','60160160');

INSERT INTO pessoaJuridica (cnpj, idCliente)
VALUES
('12345678000195',1),
('45987321000108',3),
('78654123000160',5),
('99887766000110',7),
('33445577000122',9);

INSERT INTO pessoaFisica (cpf, idCliente)
VALUES
('12345678909',2),
('98765432111',4),
('45678912385',6),
('78912345622',8),
('74185296377',10);

INSERT INTO OrdemServico (data,totalPontos,valor,valorDesconto,placa,idFuncionario,idServico, idCliente)
VALUES
('2025-07-25',30,30.00,0.00,'ABC1D23',1,1,1),
('2025-07-24',50,50.00,0.00,'XYZ9K88',2,2,2),
('2025-07-23',70,70.00,0.00,'MNO3B45',3,3,3),
('2025-07-22',100,100.00,10.00,'JKL4H56',4,4,4),
('2025-07-21',250,250.00,20.00,'RTY8U22',5,5,5),
('2025-07-20',180,180.00,15.00,'FDS7G44',6,6,6),
('2025-07-19',90,90.00,5.00,'POI6M33',7,7,7),
('2025-07-18',120,120.00,10.00,'LKJ3D55',8,8,8),
('2025-07-17',110,110.00,0.00,'TRE8X90',9,9,9),
('2025-07-16',200,200.00,20.00,'BVC2N77',10,10,10);

-- INICIO - Multiplos JOIN's
-- 1
SELECT F.idFuncionario, f.nome, f.cpf, os.idOS, os.data, os.totalPontos, os.valor, os.valorDesconto, os.placa, car.modelo, car.ano, car.cor, car.marca
FROM Funcionario f
INNER JOIN OrdemServico os ON f.idFuncionario = os.idFuncionario INNER JOIN Carros car ON car.placa = os.placa;

-- 2
SELECT 'PF' AS tipo, c.idCliente, c.nome, pf.cpf AS documento
FROM pessoaFisica pf
JOIN Clientes c ON pf.idCliente = c.idCliente
UNION ALL
SELECT 'PJ' AS tipo, c.idCliente, c.nome, pj.cnpj AS documento
FROM pessoaJuridica pj
JOIN Clientes c ON pj.idCliente = c.idCliente
ORDER BY idCliente;

-- 3
SELECT 
    f.idFuncionario, f.nome AS nomeFuncionario, f.cpf AS cpfFuncionario,
    c.idCliente, c.nome AS nomeCliente, c.email AS emailCliente,
    os.idOS, os.data, os.totalPontos, os.valor, os.valorDesconto
FROM OrdemServico os
INNER JOIN Funcionario f ON os.idFuncionario = f.idFuncionario
INNER JOIN Clientes c ON os.idCliente = c.idCliente;
-- FIM - Multiplos JOIN's

-- 4
SELECT *
FROM Carros
INNER JOIN Clientes ON Carros.idCliente = Clientes.idCliente;

-- 5
SELECT 
    c.idCliente, c.nome AS nomeCliente, c.email,
    pf.cpf,
    car.placa, car.modelo, car.ano, car.cor, car.marca
FROM Carros car
INNER JOIN Clientes c ON car.idCliente = c.idCliente
INNER JOIN pessoaFisica pf ON c.idCliente = pf.idCliente
ORDER BY c.idCliente;

-- 6
SELECT 
    c.idCliente, c.nome AS nomeCliente, c.email,
    pj.cnpj,
    car.placa, car.modelo, car.ano, car.cor, car.marca
FROM Carros car
INNER JOIN Clientes c ON car.idCliente = c.idCliente
INNER JOIN pessoaJuridica pj ON c.idCliente = pj.idCliente
ORDER BY c.idCliente;

-- 7
 SELECT os.idOS,os.data,os.totalPontos,os.valor,os.placa, fun.idFuncionario, fun.nome, fun.cpf
 from OrdemServico os natural join Funcionario fun;

-- 8
 SELECT os.idOS,os.data,os.totalPontos,os.valor,os.placa, ser.*
 from OrdemServico os natural join Servicos ser;
 
-- 9
 SELECT os.idOS,os.data,os.totalPontos,os.valor,os.placa, c.nome as nomeCliente
 from OrdemServico os natural join Clientes c;
 
-- 10
SELECT *
FROM Carros
INNER JOIN Clientes ON Carros.idCliente = Clientes.idCliente
where Carros.ano > 2020;

-- 11
SELECT 
    c.nome, c.pontoCliente, car.modelo, car.marca
FROM Clientes c
INNER JOIN Carros car ON c.idCliente = car.idCliente
WHERE c.pontoCliente > 1000;

-- 12
SELECT 
    s.descricao, COUNT(os.idOS) AS qtdServicosExecutados
FROM Servicos s
LEFT JOIN OrdemServico os ON s.idServico = os.idServico
GROUP BY s.descricao;

-- 13
SELECT 
    c.cidade, COUNT(car.placa) AS qtdCarros
FROM Clientes c
INNER JOIN Carros car ON c.idCliente = car.idCliente
GROUP BY c.cidade
ORDER BY qtdCarros DESC;

-- 14
SELECT 
    f.nome, COUNT(os.idOS) AS totalOrdens
FROM Funcionario f
INNER JOIN OrdemServico os ON f.idFuncionario = os.idFuncionario
GROUP BY f.nome
ORDER BY totalOrdens DESC;
	
-- 15
SELECT 
    car.modelo, car.marca, s.descricao, s.valor
FROM OrdemServico os
INNER JOIN Carros car ON os.placa = car.placa
INNER JOIN Servicos s ON os.idServico = s.idServico
WHERE s.valor > 100;

-- 5) Criar pelo menos uma view que resuma informações do sistema
create view informaCliente as
	select data,totalPontos,valor,valorDesconto
    from OrdemServico
    where idCliente = '2';
select * from informaCliente;

-- 6) Criar pelo menos uma procedure que execute uma operação relevante (ex.: inserir um pedido)
 DELIMITER //
CREATE PROCEDURE mostraTabelas()
BEGIN
    SELECT * FROM Clientes;
    SELECT * FROM Carros;
    SELECT * FROM Servicos;
    SELECT * FROM Funcionario;
    SELECT * FROM pessoaJuridica;
    SELECT * FROM pessoaFisica;
    SELECT * FROM OrdemServico;
END //
DELIMITER ;
-- call mostraTabelas();