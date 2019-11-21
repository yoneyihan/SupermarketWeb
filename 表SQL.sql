/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.20 : Database - supermarket
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`supermarket` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

/*Table structure for table `admin_account` */

CREATE TABLE `admin_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账户标识',
  `admin_name` varchar(55) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员名称',
  `user_name` varchar(55) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名',
  `password` varchar(225) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `salt` varchar(225) CHARACTER SET utf8 DEFAULT NULL COMMENT '盐值',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_default` int(1) DEFAULT '1' COMMENT '默认管理员(0:是,1:否)',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除()',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
