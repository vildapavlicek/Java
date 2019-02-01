-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: performance
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
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `idFilm` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `year` int(4) NOT NULL,
  `director` varchar(45) NOT NULL,
  `description` text,
  PRIMARY KEY (`idFilm`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Tvář vody',2017,'Guillermo del Toro','V utajované americké vládní laboratoři probíhají experimenty s podivuhodným obojživelným monstrem nalezeným v Amazonii. Ví se o něm velmi málo – domorodci jej uctívali jako boha, může dýchat na vzduchu i pod vodou, podobá se člověku a je považován za nebezpečného tvora. V laboratoři jej drží a bezohledně zkoumá ambiciózní vládní agent Richard Strickland (Michael Shannon). Zachází s ním spíše jako s biologickým materiálem než s živou bytostí. Jeho experimenty neberou ohledy na to, zda objekt zkoumání zůstane na živu. Ve stejné laboratoři pracuje němá uklízečka Elisa (Sally Hawkins) a když se náhodou střetne s uvězněným stvořením, dokáže s ním navázat takovou komunikaci, k níž není potřeba žádných slov. Stačí jim gesta a emoce. Elisa jej nevnímá jako nebezpečnou zrůdu, cítí především jeho strašlivou osamělost. Je to i tím, že tato záhadná bytost má jednu základní vlastnost vody. Jak voda přijímá tvar nádoby, tak stejně tento vodní tvor přijímá vlastnosti každého, s kým se potkává, a odráží tak jeho agresivitu i osamělost nebo bezpodmínečnou lásku. Díky tomu se mezi ním a vnímavou Elisou vytvoří silné pouto. V okamžiku, kdy hrozí další brutální pokusy, Elisa pochopí, že je čas na společný útěk. A protože jsme v 60. letech minulého století, neobejde se to bez účasti sovětských špiónů.(CinemArt)'),(2,'Black Panther',2018,'Ryan Coogler','Film od studia Marvel Black Panther je dobrodružstvím válečníka T’Chally, který se po smrti svého otce, krále Wakandy, vrací domů do odloučené, avšak technologicky vyspělé africké země, aby se stal novým právoplatným králem. Když se však znovu objeví mocný dávný nepřítel, jsou T’Challovy schopnosti jako krále a Black Panthera podrobeny těžké zkoušce, neboť T’Challa je vtažen do konfliktu ohrožujícího nejen Wakandu, ale i celý svět. Tváří tvář zradě a ohrožení musí mladý král zmobilizovat své spojence a využít naplno sílu Black Pantera, aby porazil své nepřátele a zajistil svému národu a jeho kultuře bezpečnou budoucnost.(Falcon)'),(3,'Noční hra',2018,'John Francis Daley, Jonathan M. Goldstein','Jason Bateman a Rachel McAdams ve filmu ztvárnili Maxa a Annie, jejichž pravidelné společenské herní večery s dalšími páry naberou obrátky ve chvíli, kdy Maxův charizmatický bratr Brooks zorganizuje párty se záhadnou vraždou, včetně falešných lupičů a federálních agentů. Takže kdy je Brooks unesen, je to pořád ještě součást hry... nebo není?(Vertical Ent.)');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-15 20:17:03
