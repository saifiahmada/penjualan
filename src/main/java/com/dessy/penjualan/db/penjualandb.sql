-- MySQL dump 10.13  Distrib 5.5.34, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: penjualandb
-- ------------------------------------------------------
-- Server version	5.5.34-0ubuntu0.13.04.1-log

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
-- Table structure for table `hdr_po`
--

DROP TABLE IF EXISTS `hdr_po`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hdr_po` (
  `NO_PO` varchar(10) NOT NULL,
  `VCREABY` varchar(255) DEFAULT NULL,
  `DCREA` datetime DEFAULT NULL,
  `VMODIBY` varchar(255) DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `ID_DEALER` varchar(6) DEFAULT NULL,
  `STATUS` varchar(1) DEFAULT NULL,
  `TGL_PO` date DEFAULT NULL,
  PRIMARY KEY (`NO_PO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hdr_po`
--

LOCK TABLES `hdr_po` WRITE;
/*!40000 ALTER TABLE `hdr_po` DISABLE KEYS */;
/*!40000 ALTER TABLE `hdr_po` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_access_role`
--

DROP TABLE IF EXISTS `mst_access_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_access_role` (
  `VMENUID` varchar(20) NOT NULL,
  `VROLEID` varchar(20) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `VSTAT` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`VMENUID`,`VROLEID`),
  KEY `FK_b76e8380cce14ac1bde747c177e` (`VMENUID`),
  KEY `FK_3563609500d245b5894381e35cf` (`VROLEID`),
  CONSTRAINT `FK_3563609500d245b5894381e35cf` FOREIGN KEY (`VROLEID`) REFERENCES `mst_role` (`VROLEID`),
  CONSTRAINT `FK_b76e8380cce14ac1bde747c177e` FOREIGN KEY (`VMENUID`) REFERENCES `mst_menu` (`VMENUID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_access_role`
--

LOCK TABLES `mst_access_role` WRITE;
/*!40000 ALTER TABLE `mst_access_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `mst_access_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_dealer`
--

DROP TABLE IF EXISTS `mst_dealer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_dealer` (
  `ID` varchar(6) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `ALAMAT` varchar(200) DEFAULT NULL,
  `NAMA` varchar(50) DEFAULT NULL,
  `PIMPINAN` varchar(30) DEFAULT NULL,
  `TELPON` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_dealer`
--

LOCK TABLES `mst_dealer` WRITE;
/*!40000 ALTER TABLE `mst_dealer` DISABLE KEYS */;
INSERT INTO `mst_dealer` VALUES ('CH5','2014-08-26 23:04:00',NULL,'dessy',NULL,'Martadinata','Martadinata','Saifi Ahmada','0511 456 789'),('T11','2014-08-26 23:01:21',NULL,'saifi',NULL,'Kolonel','Kolonel','Nadrah Syukra','0511 234 567'),('T13','2014-08-26 23:00:44',NULL,'saifi',NULL,'Perintis Kemerdekaan','Perintis','Setiawan Pangestu','0511 567 890');
/*!40000 ALTER TABLE `mst_dealer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_item`
--

DROP TABLE IF EXISTS `mst_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_item` (
  `KD_ITEM` varchar(3) NOT NULL,
  `VCREABY` varchar(255) DEFAULT NULL,
  `DCREA` datetime DEFAULT NULL,
  `VMODIBY` varchar(255) DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `NAMA` varchar(15) DEFAULT NULL,
  `TIPE` varchar(15) DEFAULT NULL,
  `WARNA` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`KD_ITEM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_item`
--

LOCK TABLES `mst_item` WRITE;
/*!40000 ALTER TABLE `mst_item` DISABLE KEYS */;
INSERT INTO `mst_item` VALUES ('GB0','saifi','2014-08-29 23:08:41',NULL,NULL,'SUPRA','PGM FI','MERAH'),('GB1','saifi','2014-08-29 23:11:44',NULL,NULL,'SUPRAX','PGM FI','MERAH'),('GB8',NULL,NULL,'saifi','2014-08-29 23:42:11','VARIO','PGM FI','PUTIH'),('GB9','saifi','2014-08-29 23:48:55',NULL,NULL,'VARIO9','PGM FI','PUTIH'),('GBX','saifi','2014-08-29 23:22:06','saifi','2014-08-29 23:22:07','BEAT','PGM FI','MERAH');
/*!40000 ALTER TABLE `mst_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_menu`
--

DROP TABLE IF EXISTS `mst_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_menu` (
  `VMENUID` varchar(11) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `NORDERER` int(11) DEFAULT NULL,
  `VIMAGE` varchar(30) DEFAULT NULL,
  `VLOCATION` varchar(30) DEFAULT NULL,
  `VPARENT` varchar(6) DEFAULT NULL,
  `VSTATUS` varchar(1) DEFAULT NULL,
  `VTITLE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`VMENUID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_menu`
--

LOCK TABLES `mst_menu` WRITE;
/*!40000 ALTER TABLE `mst_menu` DISABLE KEYS */;
INSERT INTO `mst_menu` VALUES ('MENU10','2014-08-30 21:50:20',NULL,'saifi',NULL,10,'z-icon-dashboard','uploadPoDealer.zul',NULL,'T','Upload PO'),('MENU20','2014-08-30 21:47:05',NULL,'saifi',NULL,20,'z-icon-dashboard','mstPoDealer.zul',NULL,'T','PO Dealer'),('MENU30','2014-08-30 00:13:27',NULL,'saifi',NULL,30,'z-icon-dashboard','mstItem.zul',NULL,'T','Master Item'),('MENU40','2014-08-28 23:58:36',NULL,'saifi',NULL,40,'z-icon-list-alt','uploadStok.zul',NULL,'T','Upload Stok'),('MENU50','2014-08-28 23:10:17',NULL,'saifi',NULL,50,'z-icon-list-alt','stokDetail.zul',NULL,'T','Stok Detail'),('MENU60','2014-08-28 22:26:43',NULL,'saifi',NULL,60,'z-icon-dashboard','stokGlobal.zul',NULL,'T','Stok Global'),('MENU70','2014-08-26 22:59:06',NULL,'saifi',NULL,70,'z-icon-list-alt','mstDealer.zul',NULL,'T','Master Dealer'),('MENU80',NULL,NULL,NULL,NULL,80,'z-icon-list-alt','mstMenu.zul',NULL,'T','Master Menu'),('MENU90',NULL,NULL,NULL,NULL,81,'z-icon-dashboard','mstUser.zul',NULL,'T','Master User');
/*!40000 ALTER TABLE `mst_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_role`
--

DROP TABLE IF EXISTS `mst_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_role` (
  `VROLEID` varchar(20) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `VROLENAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_role`
--

LOCK TABLES `mst_role` WRITE;
/*!40000 ALTER TABLE `mst_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `mst_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_user`
--

DROP TABLE IF EXISTS `mst_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_user` (
  `VUSERNAME` varchar(20) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `VPASSWORD` varchar(64) NOT NULL,
  `VSTAT` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`VUSERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_user`
--

LOCK TABLES `mst_user` WRITE;
/*!40000 ALTER TABLE `mst_user` DISABLE KEYS */;
INSERT INTO `mst_user` VALUES ('arya','2014-08-25 23:14:50',NULL,'saifi',NULL,'5882985c8b1e2dce2763072d56a1d6e5','T'),('dessy','2014-08-26 22:24:23',NULL,'saifi',NULL,'7dc46db19361a419ffee0fbd066afa9b','T'),('saifi',NULL,NULL,NULL,NULL,'6b61471b2f5a83b8b259a54f7be262df','T');
/*!40000 ALTER TABLE `mst_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_user_role`
--

DROP TABLE IF EXISTS `mst_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_user_role` (
  `VROLEID` varchar(20) NOT NULL,
  `VUSERNAME` varchar(20) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `VSTAT` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`VROLEID`,`VUSERNAME`),
  KEY `FK_78f0a99449fe4202b9f7a35c414` (`VROLEID`),
  KEY `FK_a4c1fac915684b16946c476b292` (`VUSERNAME`),
  CONSTRAINT `FK_78f0a99449fe4202b9f7a35c414` FOREIGN KEY (`VROLEID`) REFERENCES `mst_role` (`VROLEID`),
  CONSTRAINT `FK_a4c1fac915684b16946c476b292` FOREIGN KEY (`VUSERNAME`) REFERENCES `mst_user` (`VUSERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_user_role`
--

LOCK TABLES `mst_user_role` WRITE;
/*!40000 ALTER TABLE `mst_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `mst_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stok_detail`
--

DROP TABLE IF EXISTS `stok_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stok_detail` (
  `NO_SHIPLIST` varchar(10) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `KD_ITEM` varchar(3) DEFAULT NULL,
  `NO_MESIN` varchar(13) DEFAULT NULL,
  `NO_RANGKA` varchar(13) DEFAULT NULL,
  `QTY` int(11) DEFAULT NULL,
  `TGL_SHIPLIST` date DEFAULT NULL,
  PRIMARY KEY (`NO_SHIPLIST`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stok_detail`
--

LOCK TABLES `stok_detail` WRITE;
/*!40000 ALTER TABLE `stok_detail` DISABLE KEYS */;
INSERT INTO `stok_detail` VALUES ('001/SL-AHM','2014-08-29 01:37:22',NULL,'saifi',NULL,'GH0','JB134','JBKGH',1,'2014-08-28'),('002/SL-AHM','2014-08-29 01:37:22',NULL,'saifi',NULL,'GH1','JB135','JBKGJ',1,'2014-08-28'),('003/SL-AHM','2014-08-29 01:37:22',NULL,'saifi',NULL,'GH2','JB136','JBKGK',1,'2014-08-28');
/*!40000 ALTER TABLE `stok_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stok_global`
--

DROP TABLE IF EXISTS `stok_global`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stok_global` (
  `KD_ITEM` varchar(255) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `QTY` int(11) DEFAULT NULL,
  PRIMARY KEY (`KD_ITEM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stok_global`
--

LOCK TABLES `stok_global` WRITE;
/*!40000 ALTER TABLE `stok_global` DISABLE KEYS */;
INSERT INTO `stok_global` VALUES ('GH0','2014-08-29 01:37:22','2014-08-29 16:05:08','saifi','saifi',2),('GH1','2014-08-29 01:37:22','2014-08-29 16:05:32','saifi','saifi',2),('GH2','2014-08-29 01:37:22',NULL,'saifi',NULL,1),('GH3','2014-08-29 16:05:49',NULL,'saifi',NULL,1);
/*!40000 ALTER TABLE `stok_global` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-31 11:27:17
