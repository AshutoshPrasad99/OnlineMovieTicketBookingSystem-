-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: bookmyshow
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `bookingID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `custName` varchar(45) NOT NULL,
  `custAge` int NOT NULL,
  `showID` int NOT NULL,
  `seat` varchar(5) NOT NULL,
  PRIMARY KEY (`bookingID`),
  KEY `booking_ibfk_1` (`userID`),
  KEY `booking_ibfk_2` (`showID`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (70,51,'govind',25,52,'3D'),(71,51,'gaurav',26,52,'3E'),(72,51,'gauri',24,52,'3F'),(73,31,'rohan',30,90,'2G'),(74,31,'rohit',28,90,'2H'),(75,31,'rohan',30,63,'3D'),(76,31,'nitin',32,63,'3E'),(78,31,'rohan',30,58,'5G'),(79,32,'samrat',25,56,'2D'),(80,32,'pawan',26,56,'2E'),(81,32,'gaurav',24,56,'2F'),(82,51,'govind',25,89,'1D'),(83,51,'arijit',23,89,'1E'),(84,51,'mayank',24,89,'1F'),(85,34,'rajesh',28,89,'3H'),(86,34,'nitish',29,89,'3I'),(87,33,'mohit',38,56,'4H'),(88,33,'ajit',29,56,'4G'),(89,33,'avinash',30,56,'4I'),(90,33,'akshay',25,56,'4J'),(91,35,'pawan',26,58,'4E'),(92,35,'samrat',25,58,'4F'),(93,35,'mayank',23,58,'4G'),(94,35,'ajit',29,58,'4H'),(95,32,'samrat',25,89,'3C'),(96,32,'ajit',29,89,'3D'),(97,32,'pawan',26,89,'3E'),(98,32,'mayank',23,89,'3F'),(99,32,'samrat',25,59,'3G'),(100,32,'mohit',35,59,'3H'),(101,32,'samrat',25,63,'4G'),(102,32,'ayushi',26,63,'4H'),(103,32,'govind',26,63,'4I'),(104,34,'rajesh',28,90,'3D'),(105,34,'manisha',25,90,'3E'),(106,34,'ashish',26,90,'3F'),(107,34,'rajesh',28,56,'2I'),(108,34,'rahul',27,56,'2J'),(109,35,'pawan',26,89,'4E'),(111,35,'ayushi',25,89,'4G'),(112,35,'samrat',25,89,'4H'),(113,31,'rohan',30,60,'3E'),(114,31,'rashmi',28,60,'3F'),(130,31,'rohan',30,52,'2G'),(131,31,'rachna',28,52,'2H');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movieID` int NOT NULL AUTO_INCREMENT,
  `movieName` varchar(45) NOT NULL,
  PRIMARY KEY (`movieID`)
) ENGINE=InnoDB AUTO_INCREMENT=1057 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'The Croods'),(1003,'The Imitation Game'),(1005,'Rocketry'),(1006,'Avengers : Age of Ultron'),(1007,'Kaagaz'),(1008,'Drishyam'),(1009,'The Theory of Everything'),(1011,'The Gifted'),(1012,'Martian'),(1013,'Intersteller'),(1014,'Soorma'),(1023,'Home Alone'),(1030,'King Kong');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shows`
--

DROP TABLE IF EXISTS `shows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shows` (
  `showID` int NOT NULL AUTO_INCREMENT,
  `movieID` int NOT NULL,
  `theaterID` int NOT NULL,
  `date` varchar(20) NOT NULL,
  `availableSeat` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`showID`),
  KEY `movieID` (`movieID`),
  KEY `theaterID` (`theaterID`),
  CONSTRAINT `shows_ibfk_2` FOREIGN KEY (`theaterID`) REFERENCES `theater` (`theaterID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shows_ibfk_3` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shows_ibfk_4` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shows_ibfk_5` FOREIGN KEY (`theaterID`) REFERENCES `theater` (`theaterID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shows`
--

LOCK TABLES `shows` WRITE;
/*!40000 ALTER TABLE `shows` DISABLE KEYS */;
INSERT INTO `shows` VALUES (44,1,4,'2021-05-31T10:00',0,249),(50,1006,12,'2021-05-02T16:30',60,269),(51,1014,12,'2021-05-02T10:20',60,249),(52,1008,12,'2021-05-02T19:59',55,210),(56,1009,9,'2021-05-02T10:00',51,299),(57,1012,9,'2021-05-02T13:50',60,249),(58,1013,9,'2021-05-02T16:11',55,299),(59,1007,11,'2021-05-02T10:30',58,230),(60,1014,11,'2021-05-02T14:10',58,210),(62,1011,11,'2021-05-02T19:40',60,269),(63,1006,13,'2021-05-02T10:10',54,249),(64,1003,13,'2021-05-02T13:00',60,249),(65,1005,13,'2021-05-02T16:15',59,299),(68,1007,15,'2021-05-02T16:30',45,230),(74,1012,4,'2021-05-03T16:15',60,249),(89,1023,33,'2021-05-12T14:27',48,200),(90,1,13,'2021-05-12T15:16',55,249),(91,1030,33,'2021-05-13T17:27',60,199);
/*!40000 ALTER TABLE `shows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `theaterID` int NOT NULL AUTO_INCREMENT,
  `theaterName` varchar(45) NOT NULL,
  `thContact` bigint NOT NULL,
  `thAddress` varchar(45) NOT NULL,
  PRIMARY KEY (`theaterID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES (4,'THEATER 2',7412589630,'theater-2-address'),(9,'THEATER 4',8258961470,'theater-4-address'),(11,'THEATER 6',9637412580,'theater-6-address'),(12,'THEATER 7',9516238470,'theater-7-address'),(13,'THEATER 8',8426975310,'theater-8-address'),(15,'THEATER 9',9517382460,'theater-9-address'),(33,'THEATER 10',8546923710,'theater-10-address');
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `contact` bigint NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (29,'admin',0,'admin@','admin555'),(31,'rohan',9998888555,'rohan@xyz.com','rohan111'),(32,'samrat',9931248960,'samrat@xyz.com','samrat111'),(33,'mohit',8012345679,'mohit@gmail.com','mohit999'),(34,'rajesh',4563217890,'rajesh@gmail.com','rajesh111'),(35,'pawan',7827279241,'pawan@paw.com','pawan000'),(51,'govind',8137294650,'govind@xyz.com','govind222');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-13 23:15:09
