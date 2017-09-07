# Host: 127.0.0.1  (Version: 5.5.29)
# Date: 2017-09-01 14:51:59
# Generator: MySQL-Front 5.3  (Build 4.89)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "playerinfo"
#

DROP TABLE IF EXISTS `playerinfo`;
CREATE TABLE `playerinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Team` varchar(255) DEFAULT NULL,
  `Number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "playerinfo"
#

INSERT INTO `playerinfo` VALUES (1,'James Harden','Houston Rockets','13'),(2,'Stephen Curry','Golden States Warriors','30'),(3,'Chris Paul','Houston Rockets','3'),(4,'Russell Westbrook','Oklahoma Thunders','0'),(5,'LeBron James','Cleveland Cavaliers','23'),(6,'Paul George','Oklahoma Thunders','13'),(7,'John Wall','Washington Wizards','2'),(8,'Kevin Durant','Golden States Warriors','35'),(9,'Kyrie Irving','Boston Celtics','2'),(10,'Lonzo Ball','Los Angels Lakers','2');

#
# Structure for table "team"
#

DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `name` varchar(255) NOT NULL DEFAULT '',
  `fullname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "team"
#

INSERT INTO `team` VALUES ('Cavaliers','Cleveland Cavaliers'),('Celtics','Boston Celtics'),('Rockets','Houtston Rockets'),('Spurs','San Antonio Spurs'),('Thunder','Oklahoma City Thunder'),('Warriors','Golden States Warriors');

#
# Structure for table "teaminfo"
#

DROP TABLE IF EXISTS `teaminfo`;
CREATE TABLE `teaminfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `information` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  CONSTRAINT `teaminfo_ibfk_1` FOREIGN KEY (`name`) REFERENCES `team` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "teaminfo"
#

INSERT INTO `teaminfo` VALUES (1,'Rockets','The Houston Rockets are an American professional basketball team based in Houston, Texas. '),(2,'Rockets','The Rockets compete in the National Basketball Association (NBA), as a member of the league\'s Western Conference Southwest Division. '),(3,'Rockets','The team plays its home games at the Toyota Center, located in downtown Houston.'),(4,'Rockets','The Rockets have won two NBA championships and four Western Conference titles.');
