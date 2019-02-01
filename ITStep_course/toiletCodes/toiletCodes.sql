CREATE DATABASE  IF NOT EXISTS `toiletcodes` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `toiletcodes`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: toiletcodes
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `dt_codes`
--

DROP TABLE IF EXISTS `dt_codes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dt_codes` (
  `pk_codes` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_place` int(10) unsigned NOT NULL,
  `code` varchar(45) DEFAULT NULL,
  `rating_positive` int(10) unsigned DEFAULT NULL,
  `rating_negative` int(10) unsigned DEFAULT NULL,
  `rating` int(10) unsigned DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_codes`),
  KEY `pk_place_idx` (`fk_place`),
  CONSTRAINT `pk_place` FOREIGN KEY (`fk_place`) REFERENCES `dt_place` (`pk_place`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dt_codes`
--

LOCK TABLES `dt_codes` WRITE;
/*!40000 ALTER TABLE `dt_codes` DISABLE KEYS */;
/*!40000 ALTER TABLE `dt_codes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dt_comments`
--

DROP TABLE IF EXISTS `dt_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dt_comments` (
  `pk_comments` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_place` int(10) unsigned NOT NULL,
  `author` varchar(45) DEFAULT NULL,
  `comment` varchar(1000) NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_comments`),
  KEY `fk_place_idx` (`fk_place`),
  CONSTRAINT `fk_place` FOREIGN KEY (`fk_place`) REFERENCES `dt_place` (`pk_place`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dt_comments`
--

LOCK TABLES `dt_comments` WRITE;
/*!40000 ALTER TABLE `dt_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `dt_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dt_place`
--

DROP TABLE IF EXISTS `dt_place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dt_place` (
  `pk_place` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `latitude` double(15,12) unsigned NOT NULL,
  `longtitude` double(15,12) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `formatted_address` varchar(250) DEFAULT NULL,
  `open_hours` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`pk_place`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dt_place`
--

LOCK TABLES `dt_place` WRITE;
/*!40000 ALTER TABLE `dt_place` DISABLE KEYS */;
/*!40000 ALTER TABLE `dt_place` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-20 22:43:28
