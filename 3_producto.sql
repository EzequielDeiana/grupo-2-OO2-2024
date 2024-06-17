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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activo` bit(1) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock_restante` int DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (27,_binary '\0','Placa de Video XFX Radeon RX 6650 XT 8GB GDDR6 Speedster SWFT 210','XFX Radeon RX 6650 XT',324950,1,'Placa de Video','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_33401_Placa_de_Video_XFX_Radeon_RX_6650_XT_8GB_GDDR6_Speedster_SWFT_210_589f396b-med.jpg'),(28,_binary '','Placa de Video XFX Radeon RX 6750 XT ULTRA 12GB GDDR6 SPEEDSTER QICK 319','XFX Radeon RX 6750 XT ULTRA',476900,10,'Placa de Video','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_34294_Placa_de_Video_XFX_Radeon_RX_6750_XT_ULTRA_12GB_GDDR6_SPEEDSTER_QICK_319_33c89c63-grn.jpg'),(29,_binary '','Placa de Video XFX Radeon RX 580 8GB GDDR5 GTS 2048SP','XFX Radeon RX 580',169090,10,'Placa de Video','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_39191_Placa_de_Video_XFX_Radeon_RX_580_8GB_GDDR5_GTS_2048SP_8c7b9091-grn.jpg'),(30,_binary '','Placa de Video ASUS GeForce GT 730 2GB GDDR5','ASUS GeForce GT 730',83290,10,'Placa de Video','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_38989_Placa_de_Video_ASUS_GeForce_GT_730_2GB_GDDR5_2f3e3544-grn.jpg'),(31,_binary '\0','Procesador AMD RYZEN 5 3600 4.2GHz Turbo AM4 Wraith Stealth Cooler','AMD RYZEN 5 3600',130000,1,'Procesador ','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_16749_Procesador_AMD_RYZEN_5_3600_4.2GHz_Turbo_AM4_Wraith_Stealth_Cooler_f8ab4915-grn.jpg'),(32,_binary '','Procesador AMD RYZEN 3 3200G 4.0GHz Turbo + Radeon Vega 8 AM4 Wraith Stealth Cooler','AMD RYZEN 3 3200',85000,20,'Procesador ','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_16752_Procesador_AMD_RYZEN_3_3200G_4.0GHz_Turbo___Radeon_Vega_8_AM4_Wraith_Stealth_Cooler_f414a507-grn.jpg'),(33,_binary '','Procesador AMD Athlon 3000G 3.5GHz + Radeon Vega 3 AM4','AMD Athlon 3000',59500,18,'Procesador ','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_16481_Procesador_AMD_Athlon_3000G_3.5GHz___Radeon_Vega_3_AM4_8a762b5b-grn.jpg'),(34,_binary '','Procesador AMD Ryzen 5 5600X 4.6GHz Turbo AM4 + Wraith Stealth Cooler','AMD Ryzen 5 5600X',230000,20,'Procesador ','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_22254_Procesador_AMD_Ryzen_5_5600X_4.6GHz_Turbo_AM4___Wraith_Stealth_Cooler_f737ec9f-grn.jpg'),(35,_binary '','Procesador AMD Ryzen 5 5600G 4.4GHz Turbo + Wraith Stealth Cooler','AMD Ryzen 5 5600',180000,26,'Procesador ','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_27675_Procesador_AMD_Ryzen_5_5600G_4.4GHz_Turbo___Wraith_Stealth_Cooler_d4e323ea-grn.jpg'),(36,_binary '','Memoria Patriot Viper DDR4 16GB 3200MHz Steel','Patriot Viper DDR4 16GB',52900,1,'Memoria RAM','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_17152_Memoria_Patriot_Viper_DDR4_16GB_3200MHz_Steel_72af2fec-grn.jpg'),(37,_binary '','Memoria Patriot Viper DDR4 8GB 3200MHz Steel CL16','Patriot Viper DDR4 8GB',27780,26,'Memoria RAM','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_18964_Memoria_Patriot_Viper_DDR4_8GB_3200MHz_Steel_CL16_72af2fec-grn.jpg'),(38,_binary '','Memoria Team DDR4 16GB 3600MHz T-Force Delta RGB Black CL18','Team DDR4 16GB ',58000,24,'Memoria RAM','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_28524_Memoria_Team_DDR4_16GB_3600MHz_T-Force_Delta_RGB_Black_CL18_441c03ab-grn.jpg'),(39,_binary '\0','Memoria Team DDR4 16GB 3600MHz T-Force Delta RGB White CL18','Team DDR4 16GB',61290,246,'Memoria RAM','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_28525_Memoria_Team_DDR4_16GB_3600MHz_T-Force_Delta_RGB_White_CL18_353ab761-grn.jpg'),(40,_binary '','Memoria Team DDR4 8GB 3200MHz T-Force Vulcan Z Grey CL16','Team DDR4 8GB',27630,1,'Memoria RAM','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_33872_Memoria_Team_DDR4_8GB_3200MHz_T-Force_Vulcan_Z_Grey_CL16_07ea04cc-grn.jpg'),(41,_binary '','Mother Asrock A520M-HDV AM4','Asrock A520M-HDV AM4',77300,38,'Mother','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_24392_Mother_Asrock_A520M-HDV_AM4_5c7ae4d7-grn.jpg'),(42,_binary '','Mother ASUS PRIME A320M-K AM4','ASUS PRIME A320M-K AM4 ',77800,40,'Mother','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_15566_Mother_ASUS_PRIME_A320M-K_AM4_9f5c58de-grn.jpg'),(43,_binary '','Mother Asrock B450M-HDV 4.0 AM4 HDMI M.2 ','Asrock B450M-HDV 4.0 AM4 HDMI M.2 ',78800,42,'Mother','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_13643_Mother_Asrock_B450M-HDV_4.0_AM4_HDMI_M.2__31247782-grn.jpg'),(44,_binary '','Mother MSI B450M-A PRO MAX II AM4','MSI B450M-A PRO MAX II AM4 ',80940,60,'Mother','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_39821_Mother_MSI_B450M-A_PRO_MAX_II_AM4_0b15c6ff-grn.jpg'),(45,_binary '','Mother Asrock B450M Pro4 AM4 R2.0 ','Asrock B450M Pro4 AM4 R2.0 ',88870,46,'Mother','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_39568_Mother_Asrock_B450M_Pro4_AM4_R2.0__3e752c3a-grn.jpg'),(46,_binary '','Disco Solido SSD Team 1TB T-Force Delta MAX RGB White 550MB/s','SSD Team 1TB',73140,48,'Disco Solido','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_37902_Disco_Solido_SSD_Team_1TB_T-Force_Delta_MAX_RGB_White_550MB_s_1001b50d-grn.jpg'),(47,_binary '','Disco Solido SSD Team 1TB T-Force Vulcan Z 550MB/s','SSD Team 1TB',79250,50,'Disco Solido','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_33784_Disco_Solido_SSD_Team_1TB_T-Force_Vulcan_Z_550MB_s_26f71eeb-grn.jpg'),(48,_binary '','Disco Solido SSD M.2 WD 1TB Green SN350 2400MB/s NVMe PCI-E Gen3 x4','SSD M.2 WD 1TB',83680,52,'Disco Solido','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_39975_Disco_Solido_SSD_M.2_WD_1TB_Green_SN350_2400MB_s_NVMe_PCI-E_Gen3_x4_a4a93c6b-grn.jpg'),(49,_binary '','Disco Sólido SSD M.2 Kingston 1TB NV2 3500MB/s NVME PCI-E 4x','SSD M.2 Kingston 1TB',84950,54,'Disco Solido','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_35375_Disco_S__lido_SSD_M.2_Kingston_1TB_NV2_3500MB_s_NVME_PCI-E_4x_b4183908-grn.jpg'),(50,_binary '','Disco Solido SSD M.2 Team 1TB MP44L 5000MB/s NVMe PCI-E x4 Gen4','SSD M.2 Team 1TB',98320,1,'Disco Solido','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_37905_Disco_Solido_SSD_M.2_Team_1TB_MP44L_5000MB_s_NVMe_PCI-E_x4_Gen4_efc8d4c5-grn.jpg'),(51,_binary '','Gabinete Antec NX292 RGB MESH Black 3x120mm RGB Fans + 1x120mm Fan Vidrio Templado','Antec NX292 RGB MESH Black',64990,58,'Gabinete','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_35714_Gabinete_Antec_NX292_RGB_MESH_Black_3x120mm_RGB_Fans___1x120mm_Fan_Vidrio_Templado_a017a79f-grn.jpg'),(52,_binary '','Gabinete Antec NX292 RGB MESH White 3x120mm RGB Fans + 1x120mm Fan Vidrio Templado Vidrio Templado','Antec NX292 RGB MESH White',67570,60,'Gabinete','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_38038_Gabinete_Antec_NX292_RGB_MESH_White_3x120mm_RGB_Fans___1x120mm_Fan_Vidrio_Templado_Vidrio_Templado_2184f894-grn.jpg'),(53,_binary '','Gabinete Cougar MX360 ARGB Vidrio Templado ATX','Cougar MX360 ARGB',51350,115,'Gabinete','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_39113_Gabinete_Cougar_MX360_ARGB_Vidrio_Templado_ATX_d826ba7b-grn.jpg'),(54,_binary '','Gabinete Aerocool Tomahawk-A ATX Ventana Acrilica','Aerocool Tomahawk-A ATX',54100,64,'Gabinete','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_13639_Gabinete_Aerocool_Tomahawk-A_ATX_Ventana_Acrilica_b261cbca-grn.jpg'),(55,_binary '','Gabinete Kolink Inspire K3 RGB  M-ATX Vidrio Templado','Kolink Inspire K3 RGB',42920,66,'Gabinete','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_34567_Gabinete_Kolink_Inspire_K3_RGB__M-ATX_Vidrio_Templado_7306ef99-grn.jpg'),(56,_binary '','Monitor LG 24\'\' 24MK430H-B 75Hz IPS Full HD FreeSync HDMI','LG 24\'\'',149750,64,'Monitor','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_13283_Monitor_LG_24___24MK430H-B_75Hz_IPS_Full_HD_FreeSync_HDMI_13e39792-grn.jpg'),(57,_binary '','Monitor Curvo Gamer Samsung 24\" G50 144Hz Full HD VA FreeSync','Samsung 24\"',264390,66,'Monitor','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_38258_Monitor_Curvo_Gamer_Samsung_24__G50_144Hz_Full_HD_VA_FreeSync_ea8dab71-grn.jpg'),(58,_binary '','Monitor LG 20\" 20MK400H-B TN VGA HDMI VGA HDMI','LG 20\"',110250,72,'Monitor','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_13768_Monitor_LG_20__20MK400H-B_TN_VGA_HDMI_VGA_HDMI_bce7a72d-grn.jpg'),(59,_binary '','Monitor Gamer LG 27\" 27UL500-W UHD 4K HDR10 IPS','LG 27\"',418850,74,'Monitor','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_15108_Monitor_Gamer_LG_27__27UL500-W_UHD_4K_HDR10_IPS_d7cfcca9-grn.jpg'),(60,_binary '\0','Monitor Gamer LG 27\" 27GL650F 144hz IPS FHD GSync FreeSync','LG 27\"',409950,81,'Monitor','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_19484_Monitor_Gamer_LG_27__27GL650F_144hz_IPS_FHD_GSync_FreeSync_1e30b9f9-grn.jpg'),(61,_binary '','Monitor LG 32\" 32MN500M-B Full HD IPS 75Hz FreeSync','LG 32\"',350000,74,'Monitor','https://imagenes.compragamer.com/productos/compragamer_Imganen_general_19489_Monitor_LG_32__32MN500M-B_Full_HD_IPS_75Hz_FreeSync_b9da8229-grn.jpg');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-17  1:34:28