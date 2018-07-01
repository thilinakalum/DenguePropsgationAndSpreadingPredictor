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

-- Dumping data for table dengue.districts: ~1 rows (approximately)
/*!40000 ALTER TABLE `districts` DISABLE KEYS */;
INSERT INTO `districts` (`index_no`, `name`, `no_of_moh`) VALUES
	(1, 'Kaluthara', 15);
/*!40000 ALTER TABLE `districts` ENABLE KEYS */;

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

-- Dumping data for table dengue.gps: ~18 rows (approximately)
/*!40000 ALTER TABLE `gps` DISABLE KEYS */;
INSERT INTO `gps` (`index_no`, `fk_petients`, `fk_change_moh`, `gps_location`, `date`) VALUES
	(1, 1, 15, '', '2018-06-20'),
	(2, 2, 15, '', '2018-06-20'),
	(3, 3, 15, '', '2018-06-20'),
	(4, 4, 15, '', '2018-06-20'),
	(5, 5, 15, '', '2018-06-20'),
	(6, 6, 15, '', '2018-06-20'),
	(7, 7, 15, '', '2018-06-20'),
	(8, 8, 15, '', '2018-06-20'),
	(9, 9, 15, '', '2018-06-20'),
	(10, 10, 15, '', '2018-06-20'),
	(13, 1, 1, '', '2018-06-20'),
	(14, 2, 1, '', '2018-06-20'),
	(15, 3, 1, '', '2018-06-20'),
	(16, 4, 1, '', '2018-06-20'),
	(17, 5, 1, '', '2018-06-20'),
	(18, 6, 1, '', '2018-06-20'),
	(19, 7, 1, '', '2018-06-20'),
	(20, 8, 1, '', '2018-06-20');
/*!40000 ALTER TABLE `gps` ENABLE KEYS */;

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

-- Dumping data for table dengue.moh: ~15 rows (approximately)
/*!40000 ALTER TABLE `moh` DISABLE KEYS */;
INSERT INTO `moh` (`index_no`, `fk_district`, `name`, `total_population`) VALUES
	(1, 1, 'Agalawatta', 39013),
	(2, 1, 'Bandaragama', 114080),
	(3, 1, 'Bulathsinhala', 70015),
	(4, 1, 'Horana', 118578),
	(5, 1, 'Matugama\r\n', 90753),
	(6, 1, 'Panadura\r\n', 139434),
	(7, 1, 'Walallavita\r\n', 58688),
	(8, 1, 'Madurawala\r\n', 91473),
	(9, 1, 'Ingiriya\r\n', 59450),
	(10, 1, 'Palindanuwara\r\n', 56514),
	(11, 1, 'Dodangoda\r\n', 45193),
	(12, 1, 'Wadduwa\r\n', 111994),
	(13, 1, 'Millaniya\r\n', 56704),
	(14, 1, 'Beruwala\r\n', 164969),
	(15, 1, 'Kalutara (NIHS)\r\n', 159697);
/*!40000 ALTER TABLE `moh` ENABLE KEYS */;

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

-- Dumping data for table dengue.moh_patients_details: ~30 rows (approximately)
/*!40000 ALTER TABLE `moh_patients_details` DISABLE KEYS */;
INSERT INTO `moh_patients_details` (`index_no`, `fk_moh`, `patients_per_this_week`, `patients_per_last_week`, `probability`, `month`, `week`) VALUES
	(1, 1, 4, 5, 0.00010253, '2018-06-01', 1),
	(2, 2, 6, 6, 0.0000526, '2018-06-01', 1),
	(3, 3, 7, 7, 0.0000526, '2018-06-01', 1),
	(4, 4, 2, 5, 0.0000526, '2018-06-01', 1),
	(5, 5, 6, 6, 0.0000526, '2018-06-01', 1),
	(6, 6, 10, 10, 0.0000526, '2018-06-01', 1),
	(7, 7, 4, 5, 0.0000526, '2018-06-01', 1),
	(8, 8, 3, 5, 0.0000526, '2018-06-01', 1),
	(9, 9, 6, 5, 0.0000526, '2018-06-01', 1),
	(10, 10, 5, 6, 0.0000526, '2018-06-01', 1),
	(11, 11, 4, 5, 0.0000526, '2018-06-01', 1),
	(12, 12, 5, 5, 0.0000526, '2018-06-01', 1),
	(13, 13, 2, 5, 0.0000526, '2018-06-01', 1),
	(14, 14, 5, 6, 0.0000526, '2018-06-01', 1),
	(15, 15, 3, 5, 0.0000526, '2018-06-01', 1),
	(18, 1, 3, 5, 0.0000526, '2018-06-01', 2),
	(19, 2, 4, 5, 0.00010253, '2018-06-01', 2),
	(20, 3, 4, 5, 0.00010253, '2018-06-01', 2),
	(21, 4, 4, 5, 0.00010253, '2018-06-01', 2),
	(22, 5, 4, 5, 0.00010253, '2018-06-01', 2),
	(23, 6, 4, 5, 0.00010253, '2018-06-01', 2),
	(24, 7, 4, 5, 0.00010253, '2018-06-01', 2),
	(25, 8, 5, 5, 0.00010253, '2018-06-01', 2),
	(26, 9, 4, 5, 0.00010253, '2018-06-01', 2),
	(27, 10, 4, 5, 0.00010253, '2018-06-01', 2),
	(28, 11, 4, 5, 0.00010253, '2018-06-01', 2),
	(29, 12, 4, 5, 0.00010253, '2018-06-01', 2),
	(30, 13, 4, 5, 0.00010253, '2018-06-01', 2),
	(31, 14, 4, 5, 0.00010253, '2018-06-01', 2),
	(32, 15, 4, 5, 0.00010253, '2018-06-01', 2);
/*!40000 ALTER TABLE `moh_patients_details` ENABLE KEYS */;

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

-- Dumping data for table dengue.patients: ~20 rows (approximately)
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` (`index_no`, `name`, `address`, `date_of_birth`, `current_gps`, `fk_moh`) VALUES
	(1, 'A', '', NULL, '', 1),
	(2, 'B', '', NULL, '', 1),
	(3, 'C', '', NULL, '', 5),
	(4, 'D', '', NULL, '', 5),
	(5, 'E', '', NULL, '', 5),
	(6, 'F', '', NULL, '', 5),
	(7, 'G', '', NULL, '', 6),
	(8, 'H', '', NULL, '', 6),
	(9, 'I', '', NULL, '', 6),
	(10, 'J', '', NULL, '', 6),
	(11, 'K', '', NULL, '', 6),
	(12, 'L', '', NULL, '', 4),
	(13, 'M', '', NULL, '', 4),
	(14, 'N', '', NULL, '', 4),
	(15, 'O', '', NULL, '', 4),
	(16, 'P', '', NULL, '', 4),
	(17, 'Q', '', NULL, '', 4),
	(18, 'R', '', NULL, '', 4),
	(19, 'S', '', NULL, '', 2),
	(20, 'T', '', NULL, '', 2);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;

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

-- Dumping data for table dengue.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
