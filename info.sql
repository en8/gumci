-- MySQL dump 10.13  Distrib 5.6.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mail
-- ------------------------------------------------------
-- Server version	5.6.31-0ubuntu0.14.04.2

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
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `state` enum('SAVED'',''RESERVED'',''WAITING'',''REJECTED'',''INSUFFICIENT'',''READY'',''PROCESSING'',''COMPLETED'',''CANCEL') DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `sendname` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES (1,NULL,'2016-08-04 17:03:09','dosms12@naver.com',1),(2,NULL,'2016-08-04 17:05:14','dosms12@naver.com',1),(3,NULL,'2016-08-04 17:05:24','dosms12@naver.com',1),(4,NULL,'2016-08-04 17:07:42','dosms12@naver.com',1),(5,NULL,'2016-08-04 17:15:51','dosms12@naver.com',1),(6,NULL,'2016-08-04 17:17:13','dosms12@naver.com',1),(7,NULL,'2016-08-04 17:18:12','dosms12@naver.com',1),(8,NULL,'2016-08-04 17:18:45','dosms12@naver.com',1),(9,NULL,'2016-08-04 17:19:48','dosms12@naver.com',1),(10,NULL,'2016-08-04 17:24:37','dosms12@naver.com',1),(11,NULL,'2016-08-04 17:25:17','dosms12@naver.com',21),(12,NULL,'2016-08-05 10:41:28','dosms12@naver.com',1),(13,NULL,'2016-08-05 13:14:40','dosms12@naver.com',1),(14,NULL,'2016-08-05 15:09:26','dosms12@naver.com',1),(15,NULL,'2016-08-05 15:10:42','dosms12@naver.com',6),(16,NULL,'2016-08-05 15:15:30','dosms12@naver.com',8),(17,NULL,'2016-08-05 15:37:44','dosms12@naver.com',6),(18,NULL,'2016-08-05 16:09:40','dosms12@naver.com',1),(19,NULL,'2016-08-05 16:10:03','dosms12@naver.com',5),(20,NULL,'2016-08-05 16:11:11','dosms12@naver.com',10),(21,NULL,'2016-08-05 16:11:40','dosms12@naver.com',1),(22,NULL,'2016-08-05 16:15:47','dosms12@naver.com',1),(23,NULL,'2016-08-05 16:19:02','dosms12@naver.com',1),(24,NULL,'2016-08-05 16:24:13','dosms12@naver.com',1),(25,NULL,'2016-08-05 16:25:14','dosms12@naver.com',1),(26,NULL,'2016-08-05 16:25:58','dosms12@naver.com',4),(27,NULL,'2016-08-05 16:27:05','dosms12@naver.com',10),(28,NULL,'2016-08-05 16:46:32','dosms12@naver.com',1),(29,NULL,'2016-08-05 16:47:00','dosms12@naver.com',13),(30,NULL,'2016-08-05 16:53:03','dosms12@naver.com',1),(31,NULL,'2016-08-05 17:11:23','dosms12@naver.com',1),(32,NULL,'2016-08-05 17:12:06','dosms12@naver.com',11),(33,NULL,'2016-08-05 17:15:14','dosms12@naver.com',1),(34,NULL,'2016-08-05 17:15:34','dosms12@naver.com',1),(35,NULL,'2016-08-05 17:18:20','dosms12@naver.com',1),(36,NULL,'2016-08-05 17:21:44','dosms12@naver.com',1),(37,NULL,'2016-08-05 17:22:07','dosms12@naver.com',15),(38,NULL,'2016-08-05 17:26:46','dosms12@naver.com',5),(39,NULL,'2016-08-05 17:26:49','dosms12@naver.com',6),(40,NULL,'2016-08-05 17:29:36','dosms12@naver.com',4),(41,NULL,'2016-08-08 08:59:35','dosms12@naver.com',1),(42,NULL,'2016-08-08 08:59:37','dosms12@naver.com',1),(43,NULL,'2016-08-08 09:01:33','dosms12@naver.com',1),(44,NULL,'2016-08-08 09:01:33','dosms12@naver.com',1),(45,NULL,'2016-08-08 09:12:43','dosms12@naver.com',1),(46,NULL,'2016-08-08 09:14:25','dosms12@naver.com',2),(47,NULL,'2016-08-08 09:14:26','dosms12@naver.com',2),(48,NULL,'2016-08-08 11:39:56','dosms12@naver.com',1),(49,NULL,'2016-08-08 11:40:24','dosms12@naver.com',2),(50,NULL,'2016-08-08 11:41:51','dosms12@naver.com',2),(51,NULL,'2016-08-08 11:43:26','dosms12@naver.com',3),(52,NULL,'2016-08-08 11:48:14','dosms12@naver.com',1),(53,NULL,'2016-08-08 11:48:48','dosms12@naver.com',3),(54,NULL,'2016-08-08 14:30:38','dosms12@naver.com',3),(55,NULL,'2016-08-08 14:32:12','dosms12@naver.com',1),(56,NULL,'2016-08-08 14:33:49','dosms12@naver.com',1),(57,NULL,'2016-08-08 14:36:04','dosms12@naver.com',2),(58,NULL,'2016-08-08 14:37:58','dosms12@naver.com',1),(59,NULL,'2016-08-08 14:38:35','dosms12@naver.com',3),(60,NULL,'2016-08-08 14:46:11','dosms12@naver.com',2),(61,NULL,'2016-08-08 14:51:06','dosms12@naver.com',2);
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-08 15:36:51
