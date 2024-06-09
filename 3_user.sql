-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: 3
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(60) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` bigint DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2024-05-14 19:22:00.000000',_binary '','$2a$10$MfaBQ2ob6sEvWBDtSo3m0Oa1H.qMpEHUi3sE3Zr7EC6eAQwdcpD8u','2024-05-14 19:22:00.000000','Gaston','1',1,'2024-10-10','1'),(2,'2024-05-14 19:22:00.000000',_binary '','$2a$10$MfaBQ2ob6sEvWBDtSo3m0Oa1H.qMpEHUi3sE3Zr7EC6eAQwdcpD8u','2024-05-14 19:22:00.000000','Ezequiel','1',1,'2024-10-10','1'),(3,'2024-05-14 19:22:00.000000',_binary '','$2a$10$MfaBQ2ob6sEvWBDtSo3m0Oa1H.qMpEHUi3sE3Zr7EC6eAQwdcpD8u','2024-05-14 19:22:00.000000','Arturo','1',1,'2024-10-10','1'),(4,'2024-05-14 19:22:00.000000',_binary '','$2a$10$MfaBQ2ob6sEvWBDtSo3m0Oa1H.qMpEHUi3sE3Zr7EC6eAQwdcpD8u','2024-05-14 19:22:00.000000','Tomas','1',1,'2024-10-10','1'),(5,'2024-05-14 19:22:00.000000',_binary '','$2a$10$MfaBQ2ob6sEvWBDtSo3m0Oa1H.qMpEHUi3sE3Zr7EC6eAQwdcpD8u','2024-05-14 19:22:00.000000','Rodrigo','1',1,'2024-10-10','1'),(6,'2024-05-14 19:22:00.000000',_binary '','$2a$10$MfaBQ2ob6sEvWBDtSo3m0Oa1H.qMpEHUi3sE3Zr7EC6eAQwdcpD8u','2024-05-14 19:22:00.000000','Pedro','1',1,'2024-10-10','1'),(7,'2024-05-14 19:22:00.000000',_binary '','$2a$10$MfaBQ2ob6sEvWBDtSo3m0Oa1H.qMpEHUi3sE3Zr7EC6eAQwdcpD8u','2024-05-14 19:22:00.000000','Pepito','1',1,'2024-10-10','1'),(8,'2024-05-14 19:22:00.000000',_binary '','$2a$10$MfaBQ2ob6sEvWBDtSo3m0Oa1H.qMpEHUi3sE3Zr7EC6eAQwdcpD8u','2024-05-14 19:22:00.000000','Jorge','1',1,'2024-10-10','1');
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

-- Dump completed on 2024-05-31 17:41:44
