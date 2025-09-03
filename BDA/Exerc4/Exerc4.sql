drop database if exists Exerc4;
create database Exerc4;
use Exerc4;
DROP TABLE IF EXISTS `Departamento`;
CREATE TABLE `Departamento` (
  `idDepartamento` int(11) NOT NULL,
  `dNome` varchar(255) NOT NULL,
  `Orcamento` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `Departamento` VALUES (1,'Financeiro',15000),(2,'TI',60000),(3,'Gestão de Pessoas',150000),(4,'Pesquisa e Desenvolvimento',7500),(5,'Jurídico',1000);
DROP TABLE IF EXISTS `Funcionario`;
CREATE TABLE `Funcionario` (
  `idFuncionario` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Sobrenome` VARCHAR(45) NOT NULL,
  `idDepartamento` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  CONSTRAINT `fk_Funcionario_Departamento` FOREIGN KEY (`idDepartamento`)
    REFERENCES `Departamento` (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `Funcionario` VALUES (123,'Julio','Silva',1),(152,'Arnaldo','Coelho',1),(222,'Carol','Ferreira',2),(326,'João','Silveira',2),(331,'George','de la Rocha',3),(332,'José','Oliveira',1),(546,'José','Pereira',4),(631,'David','Luz',3),(654,'Zacarias','Ferreira',4),(745,'Eric','Estrada',4),(845,'Elizabeth','Coelho',1),(846,'Joaquim','Goveia',1);

-- Liste todos os dados de todos os funcionários, inclusive todos os dados de seus departamentos
 select * from funcionario natural join departamento;

-- Liste o nome do funcionário e o nome do departamento onde cada funcionário está lotado
 select Funcionario.Nome, Departamento.dNome from Departamento natural join Funcionario;

-- Liste o nome e sobrenome de todos os funcionários que estejam lotados em departamentos com orçamento maior que 60.000, 00
 select Funcionario.Nome, Funcionario.Sobrenome from Funcionario natural join Departamento where Orcamento > 60000;

 -- Liste os nomes de todos os departamentos que possuam mais de dois funcionários
 select distinct Departamento.dNome from Departamento natural join Funcionario where (select count(*) from funcionario where Funcionario.idDepartamento = Departamento.idDepartamento) > 2;
 select Departamento.dNome from Departamento natural join Funcionario group by idDepartamento having count(*) > 2;
