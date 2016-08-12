-- MySQL dump 10.13  Distrib 5.7.14, for Linux (x86_64)
--
-- Host: localhost    Database: mail
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `number` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `getname` varchar(255) DEFAULT NULL,
  `sendname` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `text` mediumtext,
  `state` enum('SUCCESSED','FAILED') NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (113,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:23:48','bnxnfhdjy','sgt','SUCCESSED'),(114,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:24:44','gnfhn','fhjn','SUCCESSED'),(115,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:25:47','wpqkf','ehldjwnj','SUCCESSED'),(116,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:29:49','vbxcgbgsh','sdgh','SUCCESSED'),(117,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:33:50','bgsgfhgfhs','dfgsf','SUCCESSED'),(118,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:39:03','bc','c','SUCCESSED'),(119,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:39:44','vxcbgfbgsdh','tye','SUCCESSED'),(120,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:42:26','ppet','e','SUCCESSED'),(121,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:43:40','vcxbxcg','s','SUCCESSED'),(122,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:45:15','vbgds','sfd','SUCCESSED'),(123,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:46:25','vxcbgs','sgh','SUCCESSED'),(124,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:47:12','vbgsd','sd','SUCCESSED'),(125,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:49:11','hgfi','t','SUCCESSED'),(126,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:52:06','sdbgdbg','dfg','SUCCESSED'),(127,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:52:54','gsdbgs','sg','SUCCESSED'),(128,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:54:19','bnsf','s','SUCCESSED'),(129,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:55:44','afdga','a','SUCCESSED'),(130,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:56:44','bnsd','s','SUCCESSED'),(131,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:59:26','되자아자아자화이팅','나눠진다','SUCCESSED'),(132,'cho981114@naver.com','dosms12@naver.com','2016-08-12 11:59:59','bsdbigid','dfg','SUCCESSED'),(133,'cho981114@naver.com','dosms12@naver.com','2016-08-12 12:01:03','sfdgr','f','SUCCESSED'),(134,'dosms12@naver.com','dosms12@naver.com','2016-08-12 12:01:09','sfdgr','f','SUCCESSED'),(135,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:13:11','ㅏ이하이','이하이','SUCCESSED'),(136,'dosms12@naver.com','dosms12@naver.com','2016-08-12 13:13:12','ㅏ이하이','이하이','SUCCESSED'),(137,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:13:14','ㅏ이하이','이하이','SUCCESSED'),(138,'dosms12@naver.com','dosms12@naver.com','2016-08-12 13:13:15','ㅏ이하이','이하이','SUCCESSED'),(139,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:16:10','gnfsg','s','SUCCESSED'),(140,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:16:11','gnfsg','s','SUCCESSED'),(141,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:16:12','gnfsg','s','SUCCESSED'),(142,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:16:13','gnfsg','s','SUCCESSED'),(143,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:16:54','bsd','sd','SUCCESSED'),(144,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:16:55','bsd','sd','SUCCESSED'),(145,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:25:27','adfsfs','df','SUCCESSED'),(146,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:25:28','adfsfs','df','SUCCESSED'),(147,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:25:29','adfsfs','df','SUCCESSED'),(148,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:27:09','a','s','SUCCESSED'),(149,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:33:09','safdg','a','SUCCESSED'),(150,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:39:10','asdf','asdf','SUCCESSED'),(151,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:40:42','afg','as','SUCCESSED'),(152,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:57:39','asdf','sadf','SUCCESSED'),(153,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:20','asdfsadf','s','SUCCESSED'),(154,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:21','asdfsadf','s','SUCCESSED'),(155,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:22','asdfsadf','s','SUCCESSED'),(156,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:23','asdfsadf','s','SUCCESSED'),(157,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:24','asdfsadf','s','SUCCESSED'),(158,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:25','asdfsadf','s','SUCCESSED'),(159,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:26','asdfsadf','s','SUCCESSED'),(160,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:27','asdfsadf','s','SUCCESSED'),(161,'cho981114@naver.com','dosms12@naver.com','2016-08-12 13:58:28','asdfsadf','s','SUCCESSED'),(162,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:14:42','asdfsdaf','sadf','SUCCESSED'),(163,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:14:43','asdfsdaf','sadf','SUCCESSED'),(164,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:14:45','asdfsdaf','sadf','SUCCESSED'),(165,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:14:46','asdfsdaf','sadf','SUCCESSED'),(166,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:15:27','안녕','','SUCCESSED'),(167,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:16:04','tahhagf','xcvbcvbvcbvcb','SUCCESSED'),(168,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:16:05','tahhagf','xcvbcvbvcbvcb','SUCCESSED'),(169,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:16:11','tahhagf','xcvbcvbvcbvcb','SUCCESSED'),(170,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:16:12','tahhagf','xcvbcvbvcbvcb','SUCCESSED'),(171,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:16:13','tahhagf','xcvbcvbvcbvcb','SUCCESSED'),(172,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:25:53','ㅎㅇ','ㅇㅎ','SUCCESSED'),(173,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:25:54','ㅎㅇ','ㅇㅎ','SUCCESSED'),(174,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:25:55','ㅎㅇ','ㅇㅎ','SUCCESSED'),(175,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:25:56','ㅎㅇ','ㅇㅎ','SUCCESSED'),(176,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:25:57','ㅎㅇ','ㅇㅎ','SUCCESSED'),(177,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:25:58','ㅎㅇ','ㅇㅎ','SUCCESSED'),(178,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:25:59','ㅎㅇ','ㅇㅎ','SUCCESSED'),(179,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:26:01','ㅎㅇ','ㅇㅎ','SUCCESSED'),(180,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:26:02','ㅎㅇ','ㅇㅎ','SUCCESSED'),(181,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:26:03','ㅎㅇ','ㅇㅎ','SUCCESSED'),(182,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:42:07','f','d','SUCCESSED'),(183,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:42:51','asdfdsaf','asdf','SUCCESSED'),(184,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:42:52','asdfdsaf','asdf','SUCCESSED'),(185,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:42:53','asdfdsaf','asdf','SUCCESSED'),(186,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:42:54','asdfdsaf','asdf','SUCCESSED'),(187,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:42:55','asdfdsaf','asdf','SUCCESSED'),(188,'cho981114@naver.com','dosms12@naver.com','2016-08-12 14:42:56','asdfdsaf','asdf','SUCCESSED'),(189,'cho981114@naver.com','dosms12@naver.com','2016-08-12 15:50:48','ghgfi','d','SUCCESSED'),(190,'cho981114@naver.com','dosms12@naver.com','2016-08-12 15:50:49','ghgfi','d','SUCCESSED'),(191,'cho981114@naver.com','dosms12@naver.com','2016-08-12 15:50:50','ghgfi','d','SUCCESSED'),(192,'cho981114@naver.com','dosms12@naver.com','2016-08-12 15:50:51','ghgfi','d','SUCCESSED'),(193,'cho981114@naver.com','dosms12@naver.com','2016-08-12 15:50:52','ghgfi','d','SUCCESSED'),(194,'cho981114@naver.com','dosms12@naver.com','2016-08-12 15:50:53','ghgfi','d','SUCCESSED');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-12 16:01:03
