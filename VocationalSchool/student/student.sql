/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.24 : Database - student
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `s_grade` */

DROP TABLE IF EXISTS `s_grade`;

CREATE TABLE `s_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` int(11) DEFAULT NULL COMMENT '年级名称',
  `abbreviation` varchar(10) DEFAULT NULL COMMENT '年级简称',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `uptime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `updater` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_grade` */

/*Table structure for table `s_grade_major` */

DROP TABLE IF EXISTS `s_grade_major`;

CREATE TABLE `s_grade_major` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gradeId` bigint(20) DEFAULT NULL COMMENT '年级id',
  `majorId` bigint(20) DEFAULT NULL COMMENT '专业id',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_grade_major` */

/*Table structure for table `s_major` */

DROP TABLE IF EXISTS `s_major`;

CREATE TABLE `s_major` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '专业名称',
  `abbreviation` varchar(50) DEFAULT NULL COMMENT '简称',
  `num` varchar(20) DEFAULT NULL COMMENT '编号',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `uptime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `updater` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_major` */

/*Table structure for table `s_major_type` */

DROP TABLE IF EXISTS `s_major_type`;

CREATE TABLE `s_major_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `majorId` bigint(20) DEFAULT NULL COMMENT '专业id',
  `type` varchar(50) DEFAULT NULL COMMENT '专业类型',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `uptime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `updater` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_major_type` */

/*Table structure for table `s_source` */

DROP TABLE IF EXISTS `s_source`;

CREATE TABLE `s_source` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `school` varchar(50) DEFAULT NULL COMMENT '学校',
  `addr` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_source` */

/*Table structure for table `s_student` */

DROP TABLE IF EXISTS `s_student`;

CREATE TABLE `s_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `state` int(2) DEFAULT NULL COMMENT '状态 0：正常，1：冻结，2：注销',
  `idno` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `clazzId` bigint(20) DEFAULT NULL COMMENT '班级id',
  `gradeId` bigint(20) DEFAULT NULL COMMENT '年级id',
  `majorId` bigint(20) DEFAULT NULL COMMENT '专业id',
  `sourceId` bigint(20) DEFAULT NULL COMMENT '生源地id',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `uptime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `updater` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_student` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
