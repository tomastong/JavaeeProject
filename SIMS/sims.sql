/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : sims

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2014-07-15 16:31:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `sims_admin`
-- ----------------------------
DROP TABLE IF EXISTS `sims_admin`;
CREATE TABLE `sims_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_admin
-- ----------------------------
INSERT INTO `sims_admin` VALUES ('1', '宗明魁', '男', '45', '副院长', '11111111', '1');

-- ----------------------------
-- Table structure for `sims_assistant`
-- ----------------------------
DROP TABLE IF EXISTS `sims_assistant`;
CREATE TABLE `sims_assistant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `jobNum` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `imgSrc` varchar(255) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `gradeid` (`gradeid`),
  KEY `FK703960DB161560AE` (`gradeid`),
  CONSTRAINT `FK703960DB161560AE` FOREIGN KEY (`gradeid`) REFERENCES `sims_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_assistant
-- ----------------------------
INSERT INTO `sims_assistant` VALUES ('1', '刘佳', '女', '18944630503', '11111111', '黑龙江哈尔滨', '1', null, '1');
INSERT INTO `sims_assistant` VALUES ('2', '李哲', '男', '18944630503', '22222222', '黑龙江哈尔滨', '22222222', null, '2');

-- ----------------------------
-- Table structure for `sims_classes`
-- ----------------------------
DROP TABLE IF EXISTS `sims_classes`;
CREATE TABLE `sims_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `maxNum` int(11) DEFAULT NULL,
  `directionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE40E8163BF74B7E` (`directionid`),
  CONSTRAINT `FKE40E8163BF74B7E` FOREIGN KEY (`directionid`) REFERENCES `sims_direction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_classes
-- ----------------------------
INSERT INTO `sims_classes` VALUES ('1', '1班', '31', '1');
INSERT INTO `sims_classes` VALUES ('2', '2班', '32', '1');
INSERT INTO `sims_classes` VALUES ('3', '3班', '33', '1');
INSERT INTO `sims_classes` VALUES ('4', '1班', '31', '2');
INSERT INTO `sims_classes` VALUES ('5', '2班', '32', '2');
INSERT INTO `sims_classes` VALUES ('6', '1班', '31', '3');
INSERT INTO `sims_classes` VALUES ('7', '1班', '31', '4');
INSERT INTO `sims_classes` VALUES ('8', '2班', '32', '4');
INSERT INTO `sims_classes` VALUES ('9', '3班', '33', '4');
INSERT INTO `sims_classes` VALUES ('10', '4班', '34', '4');
INSERT INTO `sims_classes` VALUES ('11', '5班', '35', '4');
INSERT INTO `sims_classes` VALUES ('12', '1班', '31', '5');
INSERT INTO `sims_classes` VALUES ('13', '1班', '33', '6');

-- ----------------------------
-- Table structure for `sims_course`
-- ----------------------------
DROP TABLE IF EXISTS `sims_course`;
CREATE TABLE `sims_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `techerid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30D8FB3E7A080E65` (`techerid`),
  CONSTRAINT `FK30D8FB3E7A080E65` FOREIGN KEY (`techerid`) REFERENCES `sims_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_course
-- ----------------------------

-- ----------------------------
-- Table structure for `sims_direction`
-- ----------------------------
DROP TABLE IF EXISTS `sims_direction`;
CREATE TABLE `sims_direction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE19FF57C161560AE` (`gradeid`),
  CONSTRAINT `FKE19FF57C161560AE` FOREIGN KEY (`gradeid`) REFERENCES `sims_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_direction
-- ----------------------------
INSERT INTO `sims_direction` VALUES ('1', 'Java', '1');
INSERT INTO `sims_direction` VALUES ('2', 'DotNet', '1');
INSERT INTO `sims_direction` VALUES ('3', '物联网', '1');
INSERT INTO `sims_direction` VALUES ('4', 'Java', '2');
INSERT INTO `sims_direction` VALUES ('5', '物联网', '2');
INSERT INTO `sims_direction` VALUES ('6', 'Java', '3');

-- ----------------------------
-- Table structure for `sims_grade`
-- ----------------------------
DROP TABLE IF EXISTS `sims_grade`;
CREATE TABLE `sims_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_grade
-- ----------------------------
INSERT INTO `sims_grade` VALUES ('1', '11级');
INSERT INTO `sims_grade` VALUES ('2', '12级');
INSERT INTO `sims_grade` VALUES ('3', '13级');

-- ----------------------------
-- Table structure for `sims_inform`
-- ----------------------------
DROP TABLE IF EXISTS `sims_inform`;
CREATE TABLE `sims_inform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `descr` longtext,
  `scope` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3B011A8C161560AE` (`gradeid`),
  CONSTRAINT `FK3B011A8C161560AE` FOREIGN KEY (`gradeid`) REFERENCES `sims_grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_inform
-- ----------------------------

-- ----------------------------
-- Table structure for `sims_internshipdirection`
-- ----------------------------
DROP TABLE IF EXISTS `sims_internshipdirection`;
CREATE TABLE `sims_internshipdirection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `internshipPosition` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `companyAddress` varchar(255) DEFAULT NULL,
  `companyUrl` varchar(255) DEFAULT NULL,
  `addInformation` longtext,
  `gradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF36E9CAE161560AE` (`gradeid`),
  CONSTRAINT `FKF36E9CAE161560AE` FOREIGN KEY (`gradeid`) REFERENCES `sims_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_internshipdirection
-- ----------------------------
INSERT INTO `sims_internshipdirection` VALUES ('12', '自主实习', '深圳启智之星有限公司', 'Java实习生', '1', '深圳福田区', 'http://www.qizhixing.com', null, '1');
INSERT INTO `sims_internshipdirection` VALUES ('13', '自主实习', '深圳启智之星有限公司', 'Java实习生', '0', '深圳福田区', 'http://www.qizhixing.com', null, '1');

-- ----------------------------
-- Table structure for `sims_post`
-- ----------------------------
DROP TABLE IF EXISTS `sims_post`;
CREATE TABLE `sims_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `descr` longtext,
  `createdate` date DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK85CD20834A850736` (`studentid`),
  CONSTRAINT `FK85CD20834A850736` FOREIGN KEY (`studentid`) REFERENCES `sims_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_post
-- ----------------------------

-- ----------------------------
-- Table structure for `sims_resources`
-- ----------------------------
DROP TABLE IF EXISTS `sims_resources`;
CREATE TABLE `sims_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) DEFAULT NULL,
  `fileSize` varchar(255) DEFAULT NULL,
  `fileUrl` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_resources
-- ----------------------------

-- ----------------------------
-- Table structure for `sims_student`
-- ----------------------------
DROP TABLE IF EXISTS `sims_student`;
CREATE TABLE `sims_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `sno` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `imgSrc` varchar(255) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  `classesid` int(11) DEFAULT NULL,
  `internshipid` int(11) DEFAULT NULL,
  `directionid` int(11) DEFAULT NULL,
  `assistantid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK412BCB78DC11F99F` (`internshipid`),
  KEY `FK412BCB78E87CC67C` (`assistantid`),
  KEY `FK412BCB78BF74B7E` (`directionid`),
  KEY `FK412BCB78161560AE` (`gradeid`),
  KEY `FK412BCB786274A44C` (`classesid`),
  CONSTRAINT `FK412BCB78161560AE` FOREIGN KEY (`gradeid`) REFERENCES `sims_grade` (`id`),
  CONSTRAINT `FK412BCB786274A44C` FOREIGN KEY (`classesid`) REFERENCES `sims_classes` (`id`),
  CONSTRAINT `FK412BCB78BF74B7E` FOREIGN KEY (`directionid`) REFERENCES `sims_direction` (`id`),
  CONSTRAINT `FK412BCB78DC11F99F` FOREIGN KEY (`internshipid`) REFERENCES `sims_internshipdirection` (`id`),
  CONSTRAINT `FK412BCB78E87CC67C` FOREIGN KEY (`assistantid`) REFERENCES `sims_assistant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_student
-- ----------------------------
INSERT INTO `sims_student` VALUES ('1', '董红岩', '18944630503', '11031702', '1', '男', '21', '广东深圳', null, '1', '3', '12', '1', '1');
INSERT INTO `sims_student` VALUES ('2', '赵敏', '18944630503', '12031503', '12031503', '女', '20', '重庆', null, '2', '11', null, '4', '2');
INSERT INTO `sims_student` VALUES ('3', '张海涛', '18944630503', '11031212', '1', '男', '21', '河南鹤壁', null, '1', null, '13', null, '1');

-- ----------------------------
-- Table structure for `sims_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `sims_teacher`;
CREATE TABLE `sims_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `jobNum` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `imgSrc` varchar(255) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  `directionid` int(11) DEFAULT NULL,
  `classesid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5B5F151FBF74B7E` (`directionid`),
  KEY `FK5B5F151F161560AE` (`gradeid`),
  KEY `FK5B5F151F6274A44C` (`classesid`),
  CONSTRAINT `FK5B5F151F161560AE` FOREIGN KEY (`gradeid`) REFERENCES `sims_grade` (`id`),
  CONSTRAINT `FK5B5F151F6274A44C` FOREIGN KEY (`classesid`) REFERENCES `sims_classes` (`id`),
  CONSTRAINT `FK5B5F151FBF74B7E` FOREIGN KEY (`directionid`) REFERENCES `sims_direction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `sims_time`
-- ----------------------------
DROP TABLE IF EXISTS `sims_time`;
CREATE TABLE `sims_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startTime` date DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK85CEDAB0161560AE` (`gradeid`),
  CONSTRAINT `FK85CEDAB0161560AE` FOREIGN KEY (`gradeid`) REFERENCES `sims_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_time
-- ----------------------------
INSERT INTO `sims_time` VALUES ('4', '2014-07-14', '2014-07-18', 'shixun', '2');
INSERT INTO `sims_time` VALUES ('7', '2014-07-14', '2014-07-18', 'shixi', '1');

-- ----------------------------
-- Table structure for `sims_zhouji`
-- ----------------------------
DROP TABLE IF EXISTS `sims_zhouji`;
CREATE TABLE `sims_zhouji` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `status` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK57B31CF64A850736` (`studentid`),
  CONSTRAINT `FK57B31CF64A850736` FOREIGN KEY (`studentid`) REFERENCES `sims_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sims_zhouji
-- ----------------------------
