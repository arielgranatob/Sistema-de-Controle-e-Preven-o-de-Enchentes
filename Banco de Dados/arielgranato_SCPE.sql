-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 26-Jun-2019 às 17:23
-- Versão do servidor: 10.1.40-MariaDB
-- versão do PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arielgranato_SCPE`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `baciaHidrografica`
--

CREATE TABLE `baciaHidrografica` (
  `idBaciaHidografica` int(11) NOT NULL,
  `nomeBaciaHidrografica` varchar(45) NOT NULL,
  `areaBaciaHidrografica` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `enchente`
--

CREATE TABLE `enchente` (
  `idEnchente` int(11) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `idRio` int(11) NOT NULL,
  `dataEnchente` varchar(45) NOT NULL,
  `estacaoEnchente` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `paisEndereco` varchar(255) NOT NULL,
  `estadoEndereco` varchar(255) NOT NULL,
  `reigaoEndereco` varchar(255) NOT NULL,
  `cidadeEndereco` varchar(255) NOT NULL,
  `bairroEndereco` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `paisEndereco`, `estadoEndereco`, `reigaoEndereco`, `cidadeEndereco`, `bairroEndereco`) VALUES
(1, 'Brasil', 'SP', 'Sul', 'São Paulo', 'Pinheiros'),
(2, 'Brasil', 'MG', 'Norte', 'Rio Pomba', 'Gordo'),
(3, 'Brasil', 'MG', 'Nordeste', 'Tabuleiro', 'Tabuleirinho'),
(4, 'Brasil', 'MG', 'Centro-Oeste', 'Barbacena', 'Morro'),
(5, 'Brasil', 'RJ', 'Sudeste', 'Rio de Janeiro', 'Lapa'),
(6, 'Brasil', 'SP', 'Sul', 'Campinas', 'Campo Bom'),
(7, 'Brasil', 'MG', 'Norte', 'Mercês', 'Fundão'),
(8, 'Brasil', 'ES', 'Nordeste', 'Vitória', 'Derrota'),
(9, 'Brasil', 'MG', 'Centro-Oeste', 'Nova Lima', 'Seinao'),
(10, 'Brasil', 'RJ', 'Sudeste', 'Nova Iguaçu', 'Velhinho'),
(11, 'Brasil', 'ES', 'Sul', 'Campão', 'Matinho');

-- --------------------------------------------------------

--
-- Estrutura da tabela `indicePluviometrico`
--

CREATE TABLE `indicePluviometrico` (
  `idIndicePluviometrico` int(11) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `medidaIndicePluviometrico` double NOT NULL,
  `periodoIndicePluviometrico` varchar(255) NOT NULL,
  `estacaoIndicePluviometrico` varchar(255) NOT NULL,
  `dataIndicePluviometrico` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `indicePluviometrico`
--

INSERT INTO `indicePluviometrico` (`idIndicePluviometrico`, `idEndereco`, `medidaIndicePluviometrico`, `periodoIndicePluviometrico`, `estacaoIndicePluviometrico`, `dataIndicePluviometrico`) VALUES
(1, 1, 192, '01/03/2017 - 09/03/2017', 'Verão', '15/03/2017'),
(2, 1, 153, '06/04/2017 - 16/04/2017', 'Primavera', '18/05/2018'),
(3, 2, 203, '01/03/2017 - 09/03/2017', 'Inverno', '15/03/2017'),
(4, 5, 153, '06/04/2017 - 16/04/2018', 'Outono', '02/09/2018'),
(5, 5, 159, '01/02/2017 - 05/02/2018', 'Outono', '02/03/2018');

-- --------------------------------------------------------

--
-- Estrutura da tabela `inundacao`
--

CREATE TABLE `inundacao` (
  `idInundacao` int(11) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `idRio` int(11) NOT NULL,
  `dataInundacao` varchar(45) NOT NULL,
  `estacaoInundacao` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rio`
--

CREATE TABLE `rio` (
  `idRio` int(11) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `idBaciaHidografica` int(11) NOT NULL,
  `nomeRio` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rioAfluente`
--

CREATE TABLE `rioAfluente` (
  `idRioAfluente` int(11) NOT NULL,
  `idRio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Usuario`
--

CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL,
  `nomeUsuario` varchar(255) NOT NULL,
  `emailUsuario` varchar(255) NOT NULL,
  `loginUsuario` varchar(255) NOT NULL,
  `senhaUsuario` varchar(255) NOT NULL,
  `enderecoUsuario` varchar(255) DEFAULT NULL,
  `cpfUsuario` varchar(255) DEFAULT NULL,
  `numeroRegistoUsuario` varchar(255) DEFAULT NULL,
  `nivelPrivilegioUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Usuario`
--

INSERT INTO `Usuario` (`idUsuario`, `nomeUsuario`, `emailUsuario`, `loginUsuario`, `senhaUsuario`, `enderecoUsuario`, `cpfUsuario`, `numeroRegistoUsuario`, `nivelPrivilegioUsuario`) VALUES
(1, 'italo', 'italo@mail.com', 'italo', '123', 'rua da cove', '455454', '849849', 2),
(2, 'ariel', 'ariel@mail.com', 'ariel', '123', 'rua do caixao', '423432', '42423', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baciaHidrografica`
--
ALTER TABLE `baciaHidrografica`
  ADD PRIMARY KEY (`idBaciaHidografica`);

--
-- Indexes for table `enchente`
--
ALTER TABLE `enchente`
  ADD PRIMARY KEY (`idEnchente`),
  ADD KEY `fk_enchente_1_idx` (`idEndereco`),
  ADD KEY `fk_enchente_2_idx` (`idRio`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`);

--
-- Indexes for table `indicePluviometrico`
--
ALTER TABLE `indicePluviometrico`
  ADD PRIMARY KEY (`idIndicePluviometrico`),
  ADD KEY `fk_indicePluviometrico_1_idx` (`idEndereco`);

--
-- Indexes for table `inundacao`
--
ALTER TABLE `inundacao`
  ADD PRIMARY KEY (`idInundacao`),
  ADD KEY `fk_inundacao_1_idx` (`idEndereco`),
  ADD KEY `fk_inundacao_2_idx` (`idRio`);

--
-- Indexes for table `rio`
--
ALTER TABLE `rio`
  ADD PRIMARY KEY (`idRio`),
  ADD KEY `fk_rio_1_idx` (`idEndereco`),
  ADD KEY `fk_rio_2_idx` (`idBaciaHidografica`);

--
-- Indexes for table `rioAfluente`
--
ALTER TABLE `rioAfluente`
  ADD PRIMARY KEY (`idRioAfluente`),
  ADD KEY `fk_rioAfluente_1_idx` (`idRio`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `baciaHidrografica`
--
ALTER TABLE `baciaHidrografica`
  MODIFY `idBaciaHidografica` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `enchente`
--
ALTER TABLE `enchente`
  MODIFY `idEnchente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `indicePluviometrico`
--
ALTER TABLE `indicePluviometrico`
  MODIFY `idIndicePluviometrico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `inundacao`
--
ALTER TABLE `inundacao`
  MODIFY `idInundacao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rio`
--
ALTER TABLE `rio`
  MODIFY `idRio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rioAfluente`
--
ALTER TABLE `rioAfluente`
  MODIFY `idRioAfluente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `enchente`
--
ALTER TABLE `enchente`
  ADD CONSTRAINT `fk_enchente_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_enchente_2` FOREIGN KEY (`idRio`) REFERENCES `rio` (`idRio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `indicePluviometrico`
--
ALTER TABLE `indicePluviometrico`
  ADD CONSTRAINT `fk_indicePluviometrico_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `inundacao`
--
ALTER TABLE `inundacao`
  ADD CONSTRAINT `fk_inundacao_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_inundacao_2` FOREIGN KEY (`idRio`) REFERENCES `rio` (`idRio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rio`
--
ALTER TABLE `rio`
  ADD CONSTRAINT `fk_rio_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rio_2` FOREIGN KEY (`idBaciaHidografica`) REFERENCES `baciaHidrografica` (`idBaciaHidografica`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rioAfluente`
--
ALTER TABLE `rioAfluente`
  ADD CONSTRAINT `fk_rioAfluente_1` FOREIGN KEY (`idRio`) REFERENCES `rio` (`idRio`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
