/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.1.44-community : Database - eservice
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eservice` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `eservice`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`adminid`,`username`,`email`,`password`) values (1,'Raj','raj@gmail.com','rajE$90'),(2,'Aman','ansariaman19487@gmail.com','aman_01');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bookid` int(10) NOT NULL AUTO_INCREMENT,
  `subserviceid` int(10) NOT NULL,
  `customerid` int(10) NOT NULL,
  `orderdate` varchar(50) NOT NULL,
  `ordertime` varchar(50) NOT NULL,
  `bstatus` varchar(50) NOT NULL,
  `pstatus` varchar(50) NOT NULL,
  `price` varchar(16) NOT NULL,
  PRIMARY KEY (`bookid`),
  KEY `subserviceid` (`subserviceid`),
  KEY `customerid` (`customerid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`subserviceid`) REFERENCES `subservice` (`subserviceid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`bookid`,`subserviceid`,`customerid`,`orderdate`,`ordertime`,`bstatus`,`pstatus`,`price`) values (1,2,1,'27/03/2025','03:00:56 pm','Pending','Pending','1200'),(2,2,1,'28/03/2025','04:11:07 pm','Pending','Pending','1200');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customerid` int(10) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `number` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(25) NOT NULL,
  `state` varchar(25) NOT NULL,
  `pincode` int(6) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`customerid`,`firstname`,`lastname`,`number`,`email`,`password`,`address`,`city`,`state`,`pincode`) values (1,'AmanHussain','Ansari','1234567890','ansariaman19487@gmail.com','aman_02','79, ASIYANA NAGAR, Kantharia road, Sherpura Village, Bharuch, Gujarat.','BHARUCH','Gujarat',382481);

/*Table structure for table `service` */

DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `serviceid` int(10) NOT NULL AUTO_INCREMENT,
  `servicename` varchar(25) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `service` */

insert  into `service`(`serviceid`,`servicename`,`image`) values (1,'Plumber Service','Plumber.jpg'),(2,'AC Services','AC.jpeg'),(4,'Washing Services','washing image.jfif');

/*Table structure for table `subservice` */

DROP TABLE IF EXISTS `subservice`;

CREATE TABLE `subservice` (
  `subserviceid` int(10) NOT NULL AUTO_INCREMENT,
  `serviceid` int(10) NOT NULL,
  `subservicename` varchar(50) NOT NULL,
  `feature` varchar(100) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`subserviceid`),
  KEY `serviceid` (`serviceid`),
  CONSTRAINT `subservice_ibfk_1` FOREIGN KEY (`serviceid`) REFERENCES `service` (`serviceid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `subservice` */

insert  into `subservice`(`subserviceid`,`serviceid`,`subservicename`,`feature`,`price`) values (1,2,'Window AC','Window must be open','1800'),(2,2,'Split AC','Point should be there','1200'),(5,4,'Paint Protection Plus','Protective treatments for your car\'s paint.','4000');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
