-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(255) NOT NULL,
  `emailUsuario` varchar(255) NOT NULL,
  `loginUsuario` varchar(255) NOT NULL,
  `senhaUsuario` varchar(255) NOT NULL,
  `enderecoUsuario` varchar(255) DEFAULT NULL,
  `cpfUsuario` varchar(255) DEFAULT NULL,
  `numeroRegistoUsuario` varchar(255) DEFAULT NULL,
  `nivelPrivilegioUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'italo','italo@mail.com','italo','123','rua da cove','455454','849849',2),(2,'ariel','ariel@mail.com','ariel','123','rua do caixao','423432','42423',1);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baciaHidrografica`
--

DROP TABLE IF EXISTS `baciaHidrografica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baciaHidrografica` (
  `idBaciaHidografica` int(11) NOT NULL AUTO_INCREMENT,
  `nomeBaciaHidrografica` varchar(45) NOT NULL,
  `areaBaciaHidrografica` double NOT NULL,
  PRIMARY KEY (`idBaciaHidografica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baciaHidrografica`
--

LOCK TABLES `baciaHidrografica` WRITE;
/*!40000 ALTER TABLE `baciaHidrografica` DISABLE KEYS */;
/*!40000 ALTER TABLE `baciaHidrografica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enchente`
--

DROP TABLE IF EXISTS `enchente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enchente` (
  `idEnchente` int(11) NOT NULL AUTO_INCREMENT,
  `idEndereco` int(11) NOT NULL,
  `idRio` int(11) NOT NULL,
  `dataEnchente` varchar(45) NOT NULL,
  `estacaoEnchente` varchar(45) NOT NULL,
  PRIMARY KEY (`idEnchente`),
  KEY `fk_enchente_1_idx` (`idEndereco`),
  KEY `fk_enchente_2_idx` (`idRio`),
  CONSTRAINT `fk_enchente_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_enchente_2` FOREIGN KEY (`idRio`) REFERENCES `rio` (`idRio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enchente`
--

LOCK TABLES `enchente` WRITE;
/*!40000 ALTER TABLE `enchente` DISABLE KEYS */;
/*!40000 ALTER TABLE `enchente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `paisEndereco` varchar(255) NOT NULL,
  `estadoEndereco` varchar(255) NOT NULL,
  `reigaoEndereco` varchar(255) NOT NULL,
  `cidadeEndereco` varchar(255) NOT NULL,
  `bairroEndereco` varchar(255) NOT NULL,
  PRIMARY KEY (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indicePluviometrico`
--

DROP TABLE IF EXISTS `indicePluviometrico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `indicePluviometrico` (
  `idIndicePluviometrico` int(11) NOT NULL AUTO_INCREMENT,
  `idEndereco` int(11) NOT NULL,
  `medidaIndicePluviometrico` double NOT NULL,
  `periodoIndicePluviometrico` varchar(255) NOT NULL,
  `estacaoIndicePluviometrico` varchar(255) NOT NULL,
  `dataIndicePluviometrico` varchar(255) NOT NULL,
  PRIMARY KEY (`idIndicePluviometrico`),
  KEY `fk_indicePluviometrico_1_idx` (`idEndereco`),
  CONSTRAINT `fk_indicePluviometrico_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indicePluviometrico`
--

LOCK TABLES `indicePluviometrico` WRITE;
/*!40000 ALTER TABLE `indicePluviometrico` DISABLE KEYS */;
/*!40000 ALTER TABLE `indicePluviometrico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inundacao`
--

DROP TABLE IF EXISTS `inundacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inundacao` (
  `idInundacao` int(11) NOT NULL AUTO_INCREMENT,
  `idEndereco` int(11) NOT NULL,
  `idRio` int(11) NOT NULL,
  `dataInundacao` varchar(45) NOT NULL,
  `estacaoInundacao` varchar(45) NOT NULL,
  PRIMARY KEY (`idInundacao`),
  KEY `fk_inundacao_1_idx` (`idEndereco`),
  KEY `fk_inundacao_2_idx` (`idRio`),
  CONSTRAINT `fk_inundacao_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inundacao_2` FOREIGN KEY (`idRio`) REFERENCES `rio` (`idRio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inundacao`
--

LOCK TABLES `inundacao` WRITE;
/*!40000 ALTER TABLE `inundacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `inundacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rio`
--

DROP TABLE IF EXISTS `rio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rio` (
  `idRio` int(11) NOT NULL AUTO_INCREMENT,
  `idEndereco` int(11) NOT NULL,
  `idBaciaHidografica` int(11) NOT NULL,
  `nomeRio` varchar(255) NOT NULL,
  PRIMARY KEY (`idRio`),
  KEY `fk_rio_1_idx` (`idEndereco`),
  KEY `fk_rio_2_idx` (`idBaciaHidografica`),
  CONSTRAINT `fk_rio_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rio_2` FOREIGN KEY (`idBaciaHidografica`) REFERENCES `baciaHidrografica` (`idBaciaHidografica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rio`
--

LOCK TABLES `rio` WRITE;
/*!40000 ALTER TABLE `rio` DISABLE KEYS */;
/*!40000 ALTER TABLE `rio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rioAfluente`
--

DROP TABLE IF EXISTS `rioAfluente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rioAfluente` (
  `idRioAfluente` int(11) NOT NULL AUTO_INCREMENT,
  `idRio` int(11) NOT NULL,
  PRIMARY KEY (`idRioAfluente`),
  KEY `fk_rioAfluente_1_idx` (`idRio`),
  CONSTRAINT `fk_rioAfluente_1` FOREIGN KEY (`idRio`) REFERENCES `rio` (`idRio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rioAfluente`
--

LOCK TABLES `rioAfluente` WRITE;
/*!40000 ALTER TABLE `rioAfluente` DISABLE KEYS */;
/*!40000 ALTER TABLE `rioAfluente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mydb'
--

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 15:40:12
