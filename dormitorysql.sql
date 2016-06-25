/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : dormitory

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-22 08:38:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for baoxiu
-- ----------------------------
DROP TABLE IF EXISTS `baoxiu`;
CREATE TABLE `baoxiu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dmt_id` varchar(10) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `xiangqing` varchar(50) DEFAULT NULL,
  `zhuangtai` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of baoxiu
-- ----------------------------
INSERT INTO `baoxiu` VALUES ('1', 'E8-338', '范正威', '日光灯坏了', '未完成');
INSERT INTO `baoxiu` VALUES ('2', 'E8-338', '范正威', '老周胖了', '未完成');
INSERT INTO `baoxiu` VALUES ('3', 'E8-338', '范正威', '床断了', '未完成');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `beizhu` varchar(50) DEFAULT NULL,
  `admin` varchar(10) DEFAULT NULL,
  `sid` char(11) DEFAULT NULL,
  `dmt_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '范正威', '男', '2013年9月9日', '入住E8-338寝室', '宿管甲', '13303013107', 'E8-338');
INSERT INTO `student` VALUES ('2', '周盛军', '男', '2013年9月9日', '入住E8-338寝室', '宿管甲', '13303013149', 'E8-338');

-- ----------------------------
-- Table structure for stu_user
-- ----------------------------
DROP TABLE IF EXISTS `stu_user`;
CREATE TABLE `stu_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sid` char(11) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_user
-- ----------------------------
INSERT INTO `stu_user` VALUES ('1', '范正威', '13303013107', '123456');
INSERT INTO `stu_user` VALUES ('2', 'cyj', '13303013106', '123456');
INSERT INTO `stu_user` VALUES ('3', '', '', '');
INSERT INTO `stu_user` VALUES ('4', '', '', '');

-- ----------------------------
-- Table structure for tch_user
-- ----------------------------
DROP TABLE IF EXISTS `tch_user`;
CREATE TABLE `tch_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(16) NOT NULL,
  `tid` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tch_user
-- ----------------------------
INSERT INTO `tch_user` VALUES ('1', '宿管甲', '123456', '100001');
