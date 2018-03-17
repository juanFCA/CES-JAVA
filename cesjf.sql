-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 16-Mar-2018 às 02:08
-- Versão do servidor: 5.5.29
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cesjf`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `dataMatricula` date NOT NULL,
  `endereco` text NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `altura` float(15,2) NOT NULL,
  `peso` float(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `nome`, `dataMatricula`, `endereco`, `telefone`, `dataNascimento`, `altura`, `peso`) VALUES
(1, 'Toto', '2018-02-28', 'Rua bob', '5552525', '2018-02-28', 1.55, 65.50),
(2, 'Nolo', '2018-02-28', 'Rua as', '123645496', '2018-02-28', 1.55, 65.50),
(3, 'Abobora', '2018-02-28', 'Rua B', '12345799', '2018-02-28', 1.68, 98.50),
(4, 'John dos 2', '2018-02-28', 'Rua A', '123456789', '2018-02-28', 1.75, 88.50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `ID_CID` int(11) NOT NULL,
  `NOME_CID` varchar(60) NOT NULL,
  `UF_CID` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`ID_CID`, `NOME_CID`, `UF_CID`) VALUES
(1, 'JUIZ DE FORA', 'MG'),
(2, 'RIO DE JANEIRO', 'RJ'),
(3, 'São Paulo', 'Sp'),
(4, 'Curitiba', 'PR');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `pro_codigo` int(11) NOT NULL,
  `pro_nome` varchar(50) NOT NULL,
  `pro_descricao` varchar(100) NOT NULL,
  `pro_preco` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`pro_codigo`, `pro_nome`, `pro_descricao`, `pro_preco`) VALUES
(1, 'Café', 'Pó para Bebida Energética - 500 gramas', 7.85),
(2, 'Caqui', 'Fruta Tropical meio Amarga', 3.5),
(3, 'Pão de Queijo', 'Pão fofo feito de queijo - 1Un', 1.9),
(4, 'Leite em Pó', 'Lata com 500 gramas de Leite em Pó', 4.95),
(5, 'Biscoito Doce', 'Biscoito de chocolate adocicado', 1.95),
(6, 'Banana', 'Penca com 12 unidades', 5.89);

-- --------------------------------------------------------

--
-- Estrutura da tabela `uf`
--

CREATE TABLE `uf` (
  `ID_UF` int(11) NOT NULL,
  `SIGLA_UF` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `uf`
--

INSERT INTO `uf` (`ID_UF`, `SIGLA_UF`) VALUES
(1, 'MG'),
(2, 'RJ'),
(3, 'SP'),
(4, 'PR');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`ID_CID`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`pro_codigo`);

--
-- Indexes for table `uf`
--
ALTER TABLE `uf`
  ADD PRIMARY KEY (`ID_UF`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `ID_CID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `pro_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `uf`
--
ALTER TABLE `uf`
  MODIFY `ID_UF` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
