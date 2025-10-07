 drop database if exists carWash;
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
  idCliente INT NOT NULL auto_increment,
  nome VARCHAR(50) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  telefone CHAR(11) NOT NULL,
  email VARCHAR(50) NOT NULL,
  dataNascimento DATE NOT NULL,
  pontoCliente INT NOT NULL,
  PRIMARY KEY (idCliente)
)engine InnoDB;

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
	on delete restrict
    on update restrict 
)engine InnoDB;

CREATE TABLE Servicos
(
  idServico INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL,
  valor FLOAT NOT NULL,
  dataCadastro DATE NOT NULL,
  pontuacaoGerada INT NOT NULL,
  PRIMARY KEY (idServico)
)engine InnoDB;

CREATE TABLE Funcionario
(
  idFuncionario INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  dataNascimento DATE NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  cpf CHAR(11) NOT NULL,
  email VARCHAR(50) NOT NULL,
  telefone CHAR(11) NOT NULL,
  PRIMARY KEY (idFuncionario)
)engine InnoDB;

CREATE TABLE pessoaJuridica
(
  cnpj CHAR(14) NOT NULL,
  idCliente INT NOT NULL,
  PRIMARY KEY (idCliente),
  FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
	on delete restrict
    on update restrict
)engine InnoDB;

CREATE TABLE pessoaFisica
(
  cpf CHAR(11) NOT NULL,
  idCliente INT NOT NULL,
  PRIMARY KEY (idCliente),
  FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
	on delete restrict
    on update restrict
)engine InnoDB;

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
  PRIMARY KEY (idOS),
  FOREIGN KEY (placa) REFERENCES Carros(placa)
	on delete restrict
    on update restrict,
  FOREIGN KEY (idFuncionario) REFERENCES Funcionario(idFuncionario)
	on delete restrict
    on update restrict,
  FOREIGN KEY (idServico) REFERENCES Servicos(idServico)
	on delete restrict
    on update restrict
)engine InnoDB;

-- ========================================================
-- Povoamento do banco de dados
-- ========================================================

INSERT INTO Clientes (nome, endereco, telefone, email, dataNascimento, pontoCliente)
VALUES ('João da Silva', 'Rua das Flores, 123 - São Paulo, SP', '(11) 91234-5678', 'joao.silva@email.com', '1985-06-15', '1200'),
('Maria Oliveira', 'Av. Paulista, 1500 - São Paulo, SP', '(11) 99876-5432', 'maria.oliveira@email.com', '1990-03-22', '950'),
('Carlos Pereira', 'Rua das Acácias, 45 - Belo Horizonte, MG', '(31) 98888-1122', 'carlos.pereira@email.com', '1978-11-05', '1340'),
('Ana Beatriz Lima', 'Rua das Hortênsias, 120 - Porto Alegre, RS', '(51) 99876-3322', 'ana.lima@email.com', '1993-08-14', '870'),
('Ricardo Menezes', 'Av. Dom Pedro I, 456 - Manaus, AM', '(92) 99123-7788', 'ricardo.menezes@email.com', '1982-12-02', '1430'),
('Camila Duarte', 'Travessa São José, 32 - Salvador, BA', '(71) 98765-4433', 'camila.duarte@email.com', '2000-05-30', '610');


INSERT INTO Carros (placa, modelo, ano, cor, marca, idCliente)
VALUES ('ABC1D23', 'Civic', '2020', 'Preto', 'Honda', '1'),
('XYZ9K88', 'Corolla', '2019', 'Prata', 'Toyota', '2'),
('MNO3B45', 'Gol', '2015', 'Vermelho', 'Volkswagen', '3');

INSERT INTO Servicos (descricao, valor, dataCadastro, pontuacaoGerada)
VALUES ('Limpeza externa', '30.00', '2025-07-25', '30'),
('Limpeza interna e externa', '50.00', '2025-07-25', '50'),
('Limpeza interna, externa e aplicação de cera', '70.00', '2025-07-25', '70');

INSERT INTO Funcionario (nome, dataNascimento, endereco, cpf, email, telefone)
VALUES ('Lucas Martins', '1992-04-10', 'Rua do Progresso, 45 - Campinas, SP', '123.456.789-00', 'lucas.martins@email.com', '(19) 91234-5678'),
('Fernanda Souza', '1988-09-22', 'Av. Brasil, 200 - Curitiba, PR', '987.654.321-00', 'fernanda.souza@email.com', '(41) 99876-5432'),
('Rafael Lima', '1995-01-15', 'Rua das Palmeiras, 88 - Recife, PE', '456.789.123-00', 'rafael.lima@email.com', '(81) 99123-4567');

INSERT INTO pessoaJuridica (cnpj, idCliente)
VALUES ('12345678000195', '1'),
('45987321000108', '3'),
 ('78654123000160', '5');

INSERT INTO pessoaFisica (cpf, idCliente)
VALUES ('12345678909', '2'),
('98765432100', '4'),
('45678912385', '6');

INSERT INTO ordemServico (data, totalPontos, valor, valorDesconto, placa, idfuncionario, idservico)
VALUES ('2025-07-25', 30, 30.00, 0.00, 'ABC1D23', 1, 1),
('2025-07-24', 50, 50.00, 0.00, 'XYZ9K88', 2, 2),
('2025-07-23', 70, 70.00, 0.00, 'MNO3B45', 3, 3);

-- ========================================================
-- Colocando o bando de dados em normalização
-- ========================================================
-- Normalização do numero do telefone 
 ALTER TABLE Clientes ADD telefone2 CHAR(11);
 ALTER TABLE Funcionario ADD telefone2 CHAR(11);
 
 -- Normalização do endereço
 ALTER TABLE Clientes CHANGE endereco enderecoCompleto varchar(100);
 ALTER TABLE Funcionario CHANGE endereco enderecoCompleto varchar(100);
 
 ALTER TABLE Clientes ADD endereco varchar(100);
 ALTER TABLE Clientes ADD numero varchar(5);
 ALTER TABLE Clientes ADD cidade varchar(40);
 ALTER TABLE Clientes ADD estado char(2);
 ALTER TABLE Clientes ADD cep char(8);

 ALTER TABLE Funcionario ADD endereco varchar(100);
 ALTER TABLE Funcionario ADD numero varchar(5);
 ALTER TABLE Funcionario ADD cidade varchar(40);
 ALTER TABLE Funcionario ADD estado char(2);
 ALTER TABLE Funcionario ADD cep char(8);
 
 UPDATE Clientes SET endereco = 'Rua das Flores', numero = '123', cidade = 'São Paulo', estado = 'SP', cep = '01019-010' WHERE idCliente = '1';
 UPDATE Clientes SET endereco = 'Av. Paulista', numero = '1500', cidade = 'São Paulo', estado = 'SP', cep = '01310-100' WHERE idCliente = '2';
 UPDATE Clientes SET endereco = 'Rua das Acácias', numero = '45', cidade = 'Belo Horizonte', estado = 'MG', cep = '30310-000' WHERE idCliente = '3';
 UPDATE Clientes SET endereco = 'Rua das Hortênsias', numero = '120', cidade = 'Porto Alegre', estado = 'RS', cep = '91310-000' WHERE idCliente = '4';
 UPDATE Clientes SET endereco = 'Av. Dom Pedro I', numero = '456', cidade = 'Manaus', estado = 'AM', cep = '69050-000' WHERE idCliente = '5';
 UPDATE Clientes SET endereco = 'Travessa São José', numero = '32', cidade = 'Salvador', estado = 'BA', cep = '41299-150' WHERE idCliente = '6';

 UPDATE Funcionario SET endereco = 'Rua do Progresso', numero = '45', cidade = 'Campinas', estado = 'SP', cep = 12345678 WHERE idFuncionario = '1';
 UPDATE Funcionario SET endereco = 'Av. Brasil', numero = '200', cidade = 'Curitiba', estado = 'PR', cep = 87654321 WHERE idFuncionario = '2';
 UPDATE Funcionario SET endereco = 'Rua das Palmeiras', numero = '88', cidade = 'Recife', estado = 'PE', cep = 32145687 WHERE idFuncionario = '3';

 ALTER TABLE Clientes DROP COLUMN enderecoCompleto;
 ALTER TABLE Funcionario DROP COLUMN enderecoCompleto;

-- ========================================================
-- Apresentação banco de dados
-- ========================================================
 select * from Clientes;
select * from Carros;
select * from Servicos;
select * from Funcionario;
select * from pessoaJuridica;
select * from pessoaFisica;
select * from OrdemServico;