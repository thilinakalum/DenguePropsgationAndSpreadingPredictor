-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.13 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for dengue
DROP DATABASE IF EXISTS `dengue`;
CREATE DATABASE IF NOT EXISTS `dengue` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dengue`;

-- Dumping structure for table dengue.districts
DROP TABLE IF EXISTS `districts`;
CREATE TABLE IF NOT EXISTS `districts` (
  `index_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `no_of_moh` int(11) DEFAULT NULL,
  PRIMARY KEY (`index_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table dengue.gps
DROP TABLE IF EXISTS `gps`;
CREATE TABLE IF NOT EXISTS `gps` (
  `index_no` int(11) NOT NULL AUTO_INCREMENT,
  `fk_petients` int(11) DEFAULT NULL,
  `fk_change_moh` int(11) DEFAULT NULL,
  `gps_location` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`index_no`),
  KEY `FK_gps_patients` (`fk_petients`),
  KEY `FK_gps_moh` (`fk_change_moh`),
  CONSTRAINT `FK_gps_moh` FOREIGN KEY (`fk_change_moh`) REFERENCES `moh` (`index_no`),
  CONSTRAINT `FK_gps_patients` FOREIGN KEY (`fk_petients`) REFERENCES `patients` (`index_no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table dengue.moh
DROP TABLE IF EXISTS `moh`;
CREATE TABLE IF NOT EXISTS `moh` (
  `index_no` int(11) NOT NULL AUTO_INCREMENT,
  `fk_district` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `total_population` int(11) DEFAULT NULL,
  PRIMARY KEY (`index_no`),
  KEY `FK_moh_districts` (`fk_district`),
  CONSTRAINT `FK_moh_districts` FOREIGN KEY (`fk_district`) REFERENCES `districts` (`index_no`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table dengue.moh_patients_details
DROP TABLE IF EXISTS `moh_patients_details`;
CREATE TABLE IF NOT EXISTS `moh_patients_details` (
  `index_no` int(11) NOT NULL AUTO_INCREMENT,
  `fk_moh` int(11) NOT NULL,
  `patients_per_this_week` int(11) DEFAULT NULL,
  `patients_per_last_week` int(11) DEFAULT NULL,
  `probability` float DEFAULT NULL,
  `month` date DEFAULT NULL,
  `week` int(10) DEFAULT NULL,
  PRIMARY KEY (`index_no`),
  KEY `FK_moh_patients_details_moh` (`fk_moh`),
  CONSTRAINT `FK_moh_patients_details_moh` FOREIGN KEY (`fk_moh`) REFERENCES `moh` (`index_no`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table dengue.patients
DROP TABLE IF EXISTS `patients`;
CREATE TABLE IF NOT EXISTS `patients` (
  `index_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `current_gps` varchar(50) DEFAULT NULL,
  `fk_moh` int(11) DEFAULT NULL,
  PRIMARY KEY (`index_no`),
  KEY `FK_patients_moh` (`fk_moh`),
  CONSTRAINT `FK_patients_moh` FOREIGN KEY (`fk_moh`) REFERENCES `moh` (`index_no`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table dengue.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `index_no` int(11) NOT NULL AUTO_INCREMENT,
  `fk_district` int(11) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`index_no`),
  KEY `FK_user_districts` (`fk_district`),
  CONSTRAINT `FK_user_districts` FOREIGN KEY (`fk_district`) REFERENCES `districts` (`index_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
