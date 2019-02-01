-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cinemadb
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
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `idmovies` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `year` int(4) unsigned DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idmovies`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Pacific Rim: Povstání','Steven S. DeKnight',2018,'Poprvé jsme je dokázali zastavit. Jenže to, co mimozemští tvorové Kaiju napáchali na Zemi v prvním díle akčního sci-fi Pacific Rim byla jen předehra k tomu, co si pro lidstvo připravili teď. Hvězda Star Wars John Boyega a Scott Eastwood z Rychle a zběsile vedou tým, který je poslední nadějí na přežití planety. Členy tohoto týmu jsou piloti ovládající Jaegery, obří roboty, kteří jsou svou velikostí a vybavením schopní konkurovat stejně vybaveným Kaiju. Jake Pentecost (John Boyega) k nim dlouhou patřil, jenže pak se vykašlal	na svůj talent i na odkaz svého otce, jenž v boji proti Kaiju obětoval vlastní život.'),(2,'Avengers: Infinity War','Anthony Russo, Joe Russo',2018,'Snímek Avengers: Infinity War završuje neuvěřitelnou desetiletou cestu filmovým světem studia Marvel a přináší na stříbrná plátna nejsmrtonosnější a nejultimátnější válku všech dob. Avengers a jejich superhrdinští spojenci musí riskovat úplně vše a pokusit se porazit mocného Thanose dřív, než jeho bleskový útok, provázený ničením a zkázou, zničí vesmír jednou provždy.'),(3,'COCO','Lee Unkrich, Adrian Molina',2018,'Navzdory prazvláštnímu rodinnému zákazu muziky se Miguel touží stát uznávaným hudebníkem jako je jeho idol, Ernesto de la Cruz. V touze dokázat svůj talent se Miguel souhrou neuvěřitelných okolností ocitne v překrásné a barevné Říši mrtvých. Tam potká okouzlujícího šejdíře Hectora a společně se vypraví na strhující cestu odhalit skutečný příběh Miguelovy rodiny.');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 16:37:54
