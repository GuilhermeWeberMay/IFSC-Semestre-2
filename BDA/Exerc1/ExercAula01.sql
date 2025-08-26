-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
-- Host: 127.0.0.1:3306
-- Tempo de geração: 08-Ago-2023 às 19:27
-- Versão do servidor: 5.7.31
-- versão do PHP: 7.3.21
-- set sql_safe_updates = 0;
-- create database ExerAula01;
-- use ExercAula01;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
-- Banco de dados: `aula0108`
-- --------------------------------------------------------
-- Estrutura da tabela `pessoas`
DROP TABLE IF EXISTS `pessoas`;
CREATE TABLE IF NOT EXISTS `pessoas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Extraindo dados da tabela `pessoas`
INSERT INTO `pessoas` (`id`, `nome`, `email`) VALUES
(1, 'Ana', 'ana@email'),
(2, 'Bruno', 'bruno@email'),
(3, 'Carlos', 'carlos@email'),
(5, 'Edith', 'edith@email');
-- --------------------------------------------------------

-- Estrutura da tabela `telefones`
DROP TABLE IF EXISTS `telefones`;
CREATE TABLE IF NOT EXISTS `telefones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPessoa` int(11) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Extraindo dados da tabela `telefones`
INSERT INTO `telefones` (`id`, `idPessoa`, `telefone`) VALUES
(1, 1, '(48)91111-1111'),
(2, 2, '(48)92222-2222'),
(3, 3, '(48)93333-3333'),
(4, 1, '(48)94444-4444'),
(5, 5, '(48)95555-5555');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- Exercicios 
-- 1) Listar todos os dados da tabela pessoa
-- select * from pessoas; Correto

-- 2) Listar nome e e-mail em ordem descendente de e-mail
 -- select nome, email from pessoas order by email desc; Correto

-- 3) Listar dados e telefones das pessoas que tem telefone
-- select nome, email, idPessoa from pessoas, telefones where pessoas.id = telefones.idPessoa; Correto

-- 4) Listar somente nome e telefone destas pessoas
-- select nome, telefone from pessoas, telefones where pessoas.id = telefones.idPessoa; Correto

-- 5) Listar telefones de uma pessoas 
-- select telefone from telefones where telefones.idPessoa = 1; Correto

-- 6) Alterar o nome das pessoas para os colegas de classe
-- update pessoas set nome='Zara' where nome = 'Ana'; Correto
-- update pessoas set nome='Onurb' where nome = 'Bruno'; Correto
-- update pessoas set nome='Solrac' where nome = 'Carlos'; Correto
-- update pessoas set nome='Htide' where nome = 'Edith'; Correto

-- 7) Listar nome das pessoas que não tem telefone em ordem descendente (nome)
-- select nome from pessoas where id not in (select idPessoa from telefones) order by nome desc; Correto

-- 8) Listar nome e email das pessoas que não tem telefone
-- select nome, email from pessoas where id not in (select idPessoa from telefones); Correto

-- 9) Acrescentar o prefixo (48) e o algarismo 9 aos telefones
-- UPDATE telefones SET telefone = CONCAT('(48)9', telefone) WHERE telefone IS NOT NULL;

-- 10) Deletar as pessoas que não tem telefone
-- delete pessoas from pessoas, telefones where telefone in (null);