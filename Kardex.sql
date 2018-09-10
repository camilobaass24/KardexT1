/*
SQLyog Community- MySQL GUI v8.22 
MySQL - 5.5.5-10.1.30-MariaDB : Database - kardex
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kardex` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `kardex`;

/*Table structure for table `categorias` */

DROP TABLE IF EXISTS `categorias`;

CREATE TABLE `categorias` (
  `id_categoria` int(20) NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(100) NOT NULL,
  `activo_categoria` char(1) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `categorias` */

insert  into `categorias`(`id_categoria`,`nombre_categoria`,`activo_categoria`) values (1,'Vaso',''),(2,'Camiseta','S'),(3,'Camiseta','S'),(4,'Camiseta','S'),(5,'Camiseta','S'),(6,'Camiseta','S'),(7,'Camiseta','S'),(8,'Camisetas hombre araña','S');

/*Table structure for table `movimientos` */

DROP TABLE IF EXISTS `movimientos`;

CREATE TABLE `movimientos` (
  `id_movimiento` int(50) NOT NULL AUTO_INCREMENT,
  `detalle_movimiento` varchar(100) NOT NULL,
  `fecha_movimiento` date NOT NULL,
  `tipo_movimiento` int(2) NOT NULL,
  `producto_movimiento` int(50) NOT NULL,
  `precio_unitario` int(100) NOT NULL,
  `total` int(100) NOT NULL,
  `cantidad` int(100) NOT NULL,
  PRIMARY KEY (`id_movimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `movimientos` */

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `codigo_producto` int(50) NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(100) NOT NULL,
  `id_categoria` int(20) NOT NULL,
  PRIMARY KEY (`codigo_producto`),
  KEY `FK_productos` (`id_categoria`),
  CONSTRAINT `FK_productos` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `productos` */

insert  into `productos`(`codigo_producto`,`nombre_producto`,`id_categoria`) values (1,'vasos de hulk',1),(2,'vasos de hulk',1),(3,'vasos de hulk',1),(4,'vasos de hulk',1);

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id_role` int(50) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(100) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `roles` */

insert  into `roles`(`id_role`,`nombre_rol`) values (1,'Administrador');

/*Table structure for table `saldos` */

DROP TABLE IF EXISTS `saldos`;

CREATE TABLE `saldos` (
  `id_saldo` int(50) NOT NULL AUTO_INCREMENT,
  `id_producto` int(50) NOT NULL,
  `precio_unitario` int(100) DEFAULT NULL,
  `unidades_totales` int(100) DEFAULT NULL,
  PRIMARY KEY (`id_saldo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `saldos` */

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id_usuario` int(50) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `rol_usuario` int(50) NOT NULL,
  `pasword_usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id_usuario`,`nombre_usuario`,`rol_usuario`,`pasword_usuario`) values (1,'Batman',1,'hola12345');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
