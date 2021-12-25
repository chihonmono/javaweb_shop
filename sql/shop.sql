/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.24 : Database - shopping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shopping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shopping`;

/*Table structure for table `good` */

DROP TABLE IF EXISTS `good`;

CREATE TABLE `good` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(32) NOT NULL,
  `g_price` double(16,2) DEFAULT NULL,
  `g_stock` int(11) DEFAULT '0',
  `g_type` varchar(32) DEFAULT NULL,
  `g_img` varchar(32) DEFAULT NULL,
  `g_introduce` text,
  `s_id` int(11) DEFAULT '0',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

/*Data for the table `good` */

insert  into `good`(`g_id`,`g_name`,`g_price`,`g_stock`,`g_type`,`g_img`,`g_introduce`,`s_id`) values (1,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(21,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(22,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(23,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(24,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(25,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(26,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(27,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(28,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(29,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(30,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(31,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(32,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(33,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(34,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(35,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(36,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(37,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(38,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(39,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(40,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(41,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(42,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(43,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(44,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(45,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(46,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(47,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(48,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(49,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(50,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(51,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(52,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(53,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(54,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(55,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(56,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(57,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(58,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(59,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(60,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(61,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(62,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(63,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(64,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(65,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(66,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(67,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(68,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(69,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(70,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(71,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(72,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(73,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(74,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(75,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(76,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(77,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(78,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(79,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0),(80,'苹果',9.99,500,'水果','apple','正宗山东烟台栖霞红富士苹果脆甜水果新鲜当季整箱10斤一级鲜果十',0),(81,'雪梨',10.80,500,'水果','pear','魏鑫河北鸭梨新鲜梨子整箱水果包邮当季时令批发红梨水晶梨10斤',0),(82,'西瓜',5.22,500,'水果','watermelon','冰糖麒麟早佳8424西瓜种子农田阳台盆栽高产四季蔬果种籽早熟脆甜',0),(83,'香蕉',22.90,500,'水果','banana','云南高山甜香蕉9斤当季新鲜水果软香甜banana芭蕉大蕉批发包邮10\r\n',0),(84,'菠萝',15.80,500,'水果','pineapple','海南金钻凤梨9斤当季新鲜手撕凤梨水果无眼香水大菠萝整箱5包邮10\r\n',0),(85,'桃子',22.80,500,'水果','peach','金秋红蜜桃山东大桃子新鲜水果水蜜桃毛桃整箱孕妇现摘脆桃冬桃5\r\n',0);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL,
  `o_num` int(11) DEFAULT NULL,
  `o_totalprice` double DEFAULT NULL,
  `o_time` date DEFAULT NULL,
  `o_status` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`o_id`,`u_id`,`g_id`,`o_num`,`o_totalprice`,`o_time`,`o_status`) values (1,1,1,1,9.99,'2021-10-23','1'),(2,1,1,1,9.99,'2021-10-23','1'),(3,1,1,1,9.99,'2021-10-23','1'),(4,1,1,1,9.99,'2021-10-23','1'),(5,1,22,1,5.22,'2021-10-23','1'),(6,1,27,1,10.8,'2021-10-23','1'),(7,1,25,1,22.8,'2021-10-23','1'),(8,1,26,1,9.99,'2021-10-23','1'),(9,1,26,1,9.99,'2021-10-23','1'),(10,1,26,1,9.99,'2021-10-23','1'),(11,1,36,1,15.8,'2021-10-23','1');

/*Table structure for table `seller` */

DROP TABLE IF EXISTS `seller`;

CREATE TABLE `seller` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(32) DEFAULT NULL,
  `s_password` varchar(32) DEFAULT NULL,
  `s_address` varchar(128) DEFAULT NULL,
  `s_rank` int(11) DEFAULT '1',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `seller` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(32) NOT NULL,
  `u_password` varchar(32) DEFAULT NULL,
  `u_createtime` date DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`u_name`,`u_password`,`u_createtime`) values (1,'honmono','honmono','2021-10-22');

/*Table structure for table `user_address` */

DROP TABLE IF EXISTS `user_address`;

CREATE TABLE `user_address` (
  `ua_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `ua_name` varchar(32) DEFAULT NULL,
  `ua_address` varchar(128) DEFAULT NULL,
  `ua_phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ua_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_address` */

/*Table structure for table `user_cart` */

DROP TABLE IF EXISTS `user_cart`;

CREATE TABLE `user_cart` (
  `uc_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `good_id` int(11) DEFAULT NULL,
  `uc_num` int(11) DEFAULT NULL,
  `uc_totalprice` double(16,2) DEFAULT NULL,
  PRIMARY KEY (`uc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_cart` */

/*Table structure for table `user_collection` */

DROP TABLE IF EXISTS `user_collection`;

CREATE TABLE `user_collection` (
  `uco_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`uco_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_collection` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
