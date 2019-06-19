/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : vaipixel

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 19/06/2019 20:53:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for relation_work_tag
-- ----------------------------
DROP TABLE IF EXISTS `relation_work_tag`;
CREATE TABLE `relation_work_tag` (
  `id` int(11) NOT NULL,
  `work_id` int(11) DEFAULT NULL,
  `tag_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `work_id` (`work_id`),
  KEY `tag_id` (`tag_id`),
  CONSTRAINT `tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_id` FOREIGN KEY (`work_id`) REFERENCES `works` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) NOT NULL COMMENT '用户名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for works
-- ----------------------------
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `update_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
  `width` int(11) DEFAULT NULL COMMENT '图片宽度/视频宽度',
  `height` int(11) DEFAULT NULL COMMENT '图片高度/视频高度',
  `type` int(2) NOT NULL COMMENT '作品类型类型',
  `description` text COMMENT '作品描述',
  `rowUrl` varchar(255) DEFAULT NULL,
  `fullUrl` varchar(255) DEFAULT NULL,
  `regularUrl` varchar(255) DEFAULT NULL,
  `smallUrl` varchar(255) DEFAULT NULL,
  `thumbUrl` varchar(255) DEFAULT NULL,
  `camera` varchar(255) DEFAULT NULL COMMENT '相机',
  `lens` varchar(255) DEFAULT NULL COMMENT '镜头',
  `focalLength` int(255) DEFAULT NULL COMMENT '焦距',
  `aperture` int(255) DEFAULT NULL COMMENT '光圈',
  `iso` int(255) DEFAULT NULL COMMENT 'iso',
  `category_id` int(255) DEFAULT NULL COMMENT '分类id',
  `author_id` int(255) NOT NULL COMMENT '作者id',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
