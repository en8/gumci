
CREATE TABLE `info` (
  `number` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `state` enum('SAVED','RESERVED','WAITING','REJECTED','INSUFFICIENT','READY','PROCESSING','COMPLETED','CANCEL') NOT NULL DEFAULT 'WAITING',
  `time` datetime DEFAULT NULL,
  `getname` varchar(255) DEFAULT NULL,
  `sendname` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `failcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;


CREATE TABLE `ip` (
  `number` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `ip` VALUES (1,'223.130.121.106'),(2,'223.130.121.107');

CREATE TABLE `message` (
  `number` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `getname` varchar(255) DEFAULT NULL,
  `sendname` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `text` mediumtext,
  `state` enum('SUCCESSED','FAILED') NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8;


