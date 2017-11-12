/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2017-11-10 23:39:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '??', '123456');
INSERT INTO `tbl_user` VALUES ('2', '王刚', '123');
INSERT INTO `tbl_user` VALUES ('3', '王刚', '123');
INSERT INTO `tbl_user` VALUES ('4', '呃呃呃', '123');
INSERT INTO `tbl_user` VALUES ('5', '张扬', '123');
INSERT INTO `tbl_user` VALUES ('6', '何东平', '123');
