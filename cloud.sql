/*
SQLyog Professional v13.1.1 (64 bit)
MySQL - 5.7.33-log : Database - cloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloud` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cloud`;

/*Table structure for table `DEPT` */

DROP TABLE IF EXISTS `DEPT`;

CREATE TABLE `DEPT` (
  `ID` int(11) NOT NULL,
  `DEPTNAME` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `DEPT` */

insert  into `DEPT`(`ID`,`DEPTNAME`) values 
(1,'部门1'),
(2,'部门2'),
(3,'部门3');

/*Table structure for table `USER` */

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) NOT NULL,
  `SEX` varchar(20) NOT NULL,
  `DEPT_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `USER` */

insert  into `USER`(`ID`,`USERNAME`,`SEX`,`DEPT_ID`) values 
(1,'用户1','男',1),
(2,'用户2','男',1),
(3,'用户3','女',1),
(4,'用户4','男',2),
(5,'用户5','男',2),
(6,'用户6','女',3);

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial` varchar(200) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `payment` */

insert  into `payment`(`id`,`serial`) values 
(1,'iPad Air3'),
(2,'demoData'),
(3,'Ipad');

/*Table structure for table `tb_profession` */

DROP TABLE IF EXISTS `tb_profession`;

CREATE TABLE `tb_profession` (
  `profession_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业Id',
  `profession_name` varchar(20) NOT NULL DEFAULT '' COMMENT '专业名称',
  PRIMARY KEY (`profession_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_profession` */

/*Table structure for table `tb_profession_student` */

DROP TABLE IF EXISTS `tb_profession_student`;

CREATE TABLE `tb_profession_student` (
  `id` int(11) NOT NULL COMMENT 'id',
  `profession_id` int(11) NOT NULL DEFAULT '0' COMMENT '专业ID',
  `student_id` int(11) NOT NULL DEFAULT '0' COMMENT '学生ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_profession_student` */

/*Table structure for table `tb_school` */

DROP TABLE IF EXISTS `tb_school`;

CREATE TABLE `tb_school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学习Id',
  `school_name` varchar(50) NOT NULL DEFAULT '""' COMMENT '学校名称',
  `school_provice` varchar(50) NOT NULL DEFAULT '""' COMMENT '所在省份',
  `school_city` varchar(50) NOT NULL DEFAULT '""' COMMENT '所在城市',
  `school_address` varchar(255) NOT NULL DEFAULT '""' COMMENT '详细地址',
  `school_tel` varchar(20) NOT NULL DEFAULT '""' COMMENT '联系电话',
  `school_mail` varchar(20) NOT NULL DEFAULT '""' COMMENT '邮箱',
  `school_postcode` varchar(20) NOT NULL DEFAULT '""' COMMENT '邮编',
  `school_create` varchar(20) NOT NULL DEFAULT '""' COMMENT '创建时间',
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_school` */

/*Table structure for table `tb_school_profession` */

DROP TABLE IF EXISTS `tb_school_profession`;

CREATE TABLE `tb_school_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) NOT NULL DEFAULT '0' COMMENT '学校ID',
  `profession_id` int(11) NOT NULL DEFAULT '0' COMMENT '专业Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_school_profession` */

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `student_name` varchar(20) NOT NULL DEFAULT '""' COMMENT '姓名',
  `student_sex` char(1) NOT NULL DEFAULT '0' COMMENT '性别：0男，1女',
  `student_weight` int(11) NOT NULL DEFAULT '0' COMMENT '体重',
  `student_height` int(11) NOT NULL DEFAULT '0' COMMENT '身高',
  `student_age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_student` */

/* Procedure structure for procedure `SearchUser` */

/*!50003 DROP PROCEDURE IF EXISTS  `SearchUser` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `SearchUser`(IN p_id INTEGER)
BEGIN
	SELECT * FROM `USER` WHERE `ID` = p_id;
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
