-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: docker.for.mac.localhost    Database: groupboard
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `account_due`
--

DROP TABLE IF EXISTS `account_due`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_due` (
  `accountDuesID` int NOT NULL AUTO_INCREMENT,
  `groupID` int NOT NULL,
  `userID` int NOT NULL,
  `articleID` int NOT NULL,
  `accountDueAmount` double NOT NULL,
  `accounttitle` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `uploadDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `paid` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`accountDuesID`),
  KEY `articleID` (`articleID`),
  KEY `groupID` (`groupID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_due`
--

LOCK TABLES `account_due` WRITE;
/*!40000 ALTER TABLE `account_due` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_due` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `articleUUID` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `articleID` int NOT NULL AUTO_INCREMENT,
  `groupID` int NOT NULL,
  `userID` int NOT NULL,
  `uploadDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `articleContent` varchar(2000) COLLATE utf8mb4_general_ci NOT NULL,
  `type` int NOT NULL,
  `vote_multiple` tinyint(1) DEFAULT NULL,
  `vote_count` int DEFAULT NULL,
  `schedule_subject` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `schedule_place` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `schedule_startDate` date DEFAULT NULL,
  `schedule_endDate` date DEFAULT NULL,
  `place_thumbnail_UUID` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `place_coordinate_x` float DEFAULT NULL,
  `place_coordinate_y` float DEFAULT NULL,
  `place_address` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `accountSpent_amount` int DEFAULT NULL,
  `accountDue_amount` int DEFAULT NULL,
  `likeCount` int DEFAULT NULL,
  PRIMARY KEY (`articleID`),
  UNIQUE KEY `articleUUID` (`articleUUID`),
  KEY `groupID` (`groupID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_like`
--

DROP TABLE IF EXISTS `article_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_like` (
  `articleID` int NOT NULL,
  `userID` int NOT NULL,
  `likeDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_like`
--

LOCK TABLES `article_like` WRITE;
/*!40000 ALTER TABLE `article_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group` (
  `groupID` int NOT NULL AUTO_INCREMENT,
  `groupName` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `url` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `summary` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `groupColor` int NOT NULL DEFAULT '0' COMMENT '0 = primary, 1 = secondary, 2=success, 3=danger, 4=warning, 5=info',
  `manager` int NOT NULL,
  `imgExt` varchar(12) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`groupID`),
  UNIQUE KEY `groupName` (`groupName`),
  UNIQUE KEY `group_url_uindex` (`url`),
  KEY `manager` (`manager`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `imageID` int NOT NULL AUTO_INCREMENT,
  `groupID` int NOT NULL,
  `userID` int NOT NULL,
  `articleID` int NOT NULL,
  `uploadDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `filePath` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`imageID`),
  KEY `articleID` (`articleID`),
  KEY `groupID` (`groupID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_reply`
--

DROP TABLE IF EXISTS `image_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_reply` (
  `imageReplyID` int NOT NULL AUTO_INCREMENT,
  `groupID` int NOT NULL,
  `articleID` int DEFAULT NULL,
  `userID` int NOT NULL,
  `imageID` int NOT NULL,
  `uploadDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `imageRereplyID` int DEFAULT NULL,
  `imageReplyContent` varchar(1000) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`imageReplyID`),
  KEY `groupID` (`groupID`),
  KEY `imageID` (`imageID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_reply`
--

LOCK TABLES `image_reply` WRITE;
/*!40000 ALTER TABLE `image_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `groupID` int NOT NULL,
  `articleID` int NOT NULL,
  `replyID` int NOT NULL AUTO_INCREMENT,
  `parentReplyID` int DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `uploadDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `replyContent` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`replyID`),
  KEY `articleID` (`articleID`),
  KEY `groupID` (`groupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_attend`
--

DROP TABLE IF EXISTS `schedule_attend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule_attend` (
  `articleID` int NOT NULL,
  `scheduleAttendID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `attend` tinyint(1) NOT NULL,
  `uploadDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`scheduleAttendID`),
  KEY `articleID` (`articleID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_attend`
--

LOCK TABLES `schedule_attend` WRITE;
/*!40000 ALTER TABLE `schedule_attend` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_attend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscribe`
--

DROP TABLE IF EXISTS `subscribe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscribe` (
  `subscribeID` int NOT NULL AUTO_INCREMENT,
  `groupID` int NOT NULL,
  `userID` int DEFAULT NULL,
  `inviteDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `inviteCode` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `joinDate` datetime DEFAULT NULL,
  `unsubscribeDate` datetime DEFAULT NULL,
  PRIMARY KEY (`subscribeID`),
  UNIQUE KEY `inviteCode` (`inviteCode`),
  KEY `groupID` (`groupID`),
  KEY `inviteCode_2` (`inviteCode`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscribe`
--

LOCK TABLES `subscribe` WRITE;
/*!40000 ALTER TABLE `subscribe` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscribe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `userName` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `pwd` varchar(60) COLLATE utf8mb4_general_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `joinDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gravatar` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_item`
--

DROP TABLE IF EXISTS `vote_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote_item` (
  `articleID` int NOT NULL,
  `voteItemID` int NOT NULL AUTO_INCREMENT,
  `voteItemValue` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`voteItemID`),
  KEY `articleID` (`articleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_item`
--

LOCK TABLES `vote_item` WRITE;
/*!40000 ALTER TABLE `vote_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_selected`
--

DROP TABLE IF EXISTS `vote_selected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote_selected` (
  `articleID` int NOT NULL,
  `voteItemID` int NOT NULL,
  `voteSelectedID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `uploadDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`voteSelectedID`),
  KEY `articleID` (`articleID`),
  KEY `userID` (`userID`),
  KEY `voteContentID` (`voteItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_selected`
--

LOCK TABLES `vote_selected` WRITE;
/*!40000 ALTER TABLE `vote_selected` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_selected` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-02 19:17:42
