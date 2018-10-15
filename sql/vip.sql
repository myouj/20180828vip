/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.6.39-log : Database - vip
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vip` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vip`;

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` char(32) NOT NULL,
  `account` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` char(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`account`,`name`,`password`) values 
('fdsafafdsaf','0001','系统管理员','e10adc3949ba59abbe56e057f20f883e');

/*Table structure for table `vip_consume` */

DROP TABLE IF EXISTS `vip_consume`;

CREATE TABLE `vip_consume` (
  `id` char(32) NOT NULL,
  `vip_id` char(32) DEFAULT NULL,
  `whens` datetime DEFAULT CURRENT_TIMESTAMP,
  `orderno` varchar(32) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '以分为单位',
  `operator_id` char(32) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vip_id` (`vip_id`),
  KEY `fk_vip_operatorid` (`operator_id`),
  CONSTRAINT `fk_vip_id` FOREIGN KEY (`vip_id`) REFERENCES `vip_detail` (`id`),
  CONSTRAINT `fk_vip_operatorid` FOREIGN KEY (`operator_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vip_consume` */

insert  into `vip_consume`(`id`,`vip_id`,`whens`,`orderno`,`amount`,`operator_id`,`remark`,`flag`) values 
('1','1','2018-07-12 10:44:53','201807120003',5000,'fdsafafdsaf','很骚',1),
('2','1','2018-08-23 20:15:33','201808230001',10000,'fdsafafdsaf',NULL,1),
('3','1','2018-08-20 11:47:09','201808201111',20000,'fdsafafdsaf',NULL,1),
('32984ee763df4355946f0e6c1b6fe17c','6af7ee9faf514af0b08ab2f2f593dc46','2018-08-20 20:02:45','11111',20000,'fdsafafdsaf','',0),
('748e68b82fb845a2a5187e07ec9e7863','13ccdfb8a9e14b379043cdb77021a77a','2018-08-20 20:04:02','11111',30000,'fdsafafdsaf','',1),
('f1bc8401bdb74f07a980389c362fbe32','1','2018-08-20 17:26:38','11111',20000,'fdsafafdsaf','',0);

/*Table structure for table `vip_detail` */

DROP TABLE IF EXISTS `vip_detail`;

CREATE TABLE `vip_detail` (
  `id` char(32) NOT NULL,
  `code` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `qq` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `zip` varchar(16) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `rank` tinyint(1) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '以分为单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vip_detail` */

insert  into `vip_detail`(`id`,`code`,`name`,`sex`,`age`,`qq`,`email`,`address`,`zip`,`remark`,`rank`,`amount`) values 
('1','18565544225','王老五',1,40,'390752095','laowang@qq.com','海大海蓝B311','566666','很q',1,40000),
('13ccdfb8a9e14b379043cdb77021a77a','13535922642','李嘉诚',1,21,'','','','','',0,0),
('6af7ee9faf514af0b08ab2f2f593dc46','13420122287','小强',0,22,'525235','56@qq.com','海大路1号','525235','',0,0),
('83bb0fc91bac4b2ca0e559f75c8aa480','13480397260','马宇坚',1,21,'222222222222','13480397260@163.com','海大路1号','566666','',0,0);

/*Table structure for table `vip_rank` */

DROP TABLE IF EXISTS `vip_rank`;

CREATE TABLE `vip_rank` (
  `no` tinyint(1) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `needAmount` int(11) DEFAULT NULL,
  `discount` tinyint(4) DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vip_rank` */

insert  into `vip_rank`(`no`,`name`,`needAmount`,`discount`,`remark`) values 
(1,'普通VIP',100,98,NULL),
(2,'黄金VIP',1000,95,NULL),
(3,'白金VIP',5000,90,NULL),
(4,'钻石VIP',10000,85,NULL),
(5,'终身VIP',20000,80,NULL),
(0,'普通会员',0,100,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
