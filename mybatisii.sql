/*
 Navicat Premium Data Transfer

 Source Server         : MySQL57
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : localhost:3307
 Source Schema         : mybatisii

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 13/03/2024 19:09:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_class
-- ----------------------------
DROP TABLE IF EXISTS `c_class`;
CREATE TABLE `c_class`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `classname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_class
-- ----------------------------
INSERT INTO `c_class` VALUES (1, '一班');
INSERT INTO `c_class` VALUES (2, '二班');

-- ----------------------------
-- Table structure for s_student
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `cid` int(32) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `s_student_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `c_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES (1, '张三', 18, 1);
INSERT INTO `s_student` VALUES (2, '李四', 18, 2);
INSERT INTO `s_student` VALUES (3, '王五', 19, 2);
INSERT INTO `s_student` VALUES (4, '丁真', 23, 1);

SET FOREIGN_KEY_CHECKS = 1;
