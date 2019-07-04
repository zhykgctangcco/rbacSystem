/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50704
 Source Host           : localhost:3306
 Source Schema         : SchoolSystem

 Target Server Type    : MySQL
 Target Server Version : 50704
 File Encoding         : 65001

 Date: 04/07/2019 20:47:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for privileges
-- ----------------------------
DROP TABLE IF EXISTS `privileges`;
CREATE TABLE `privileges`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilegename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `privilegeUrl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `requestaction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of privileges
-- ----------------------------
INSERT INTO `privileges` VALUES (1, '查看权限', '路径1', 'listprivileges', '查看所有的权限信息');
INSERT INTO `privileges` VALUES (2, '添加权限', '路径1', 'addprivilege', '添加权限信息');
INSERT INTO `privileges` VALUES (3, '查看角色', 'toRoleList.action?param=rolelist', 'listrole', '查看所有角色信息');
INSERT INTO `privileges` VALUES (4, '查看用户', 'toUserList.action?param=userList', 'updaterole', '查看所有用户信息');
INSERT INTO `privileges` VALUES (5, '布置作业', '路径1', 'listuser', '给学生布置作业');
INSERT INTO `privileges` VALUES (6, '登记成绩', '路径1', 'noaction', '登记学生每次考试成绩');
INSERT INTO `privileges` VALUES (32, '查看考试成绩', '路径1', '路径1', '查看期末成绩');

-- ----------------------------
-- Table structure for roleprivilege
-- ----------------------------
DROP TABLE IF EXISTS `roleprivilege`;
CREATE TABLE `roleprivilege`  (
  `roleprivilege_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `privilege_id` int(11) NOT NULL,
  PRIMARY KEY (`roleprivilege_id`) USING BTREE,
  INDEX `roleprivilege_ibfk_1`(`role_id`) USING BTREE,
  INDEX `roleprivilege_ibfk_2`(`privilege_id`) USING BTREE,
  CONSTRAINT `roleprivilege_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `roleprivilege_ibfk_2` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of roleprivilege
-- ----------------------------
INSERT INTO `roleprivilege` VALUES (6, 22, 5);
INSERT INTO `roleprivilege` VALUES (7, 22, 6);
INSERT INTO `roleprivilege` VALUES (8, 23, 32);
INSERT INTO `roleprivilege` VALUES (13, 21, 1);
INSERT INTO `roleprivilege` VALUES (14, 21, 2);
INSERT INTO `roleprivilege` VALUES (15, 21, 3);
INSERT INTO `roleprivilege` VALUES (16, 21, 4);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (21, 'admin', '超级管理员、拥有最高权限');
INSERT INTO `roles` VALUES (22, 'teacher', '教师');
INSERT INTO `roles` VALUES (23, 'student', '学生');

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole`  (
  `userrole_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`userrole_id`) USING BTREE,
  INDEX `userrole_ibfk_1`(`user_id`) USING BTREE,
  INDEX `userrole_ibfk_2`(`role_id`) USING BTREE,
  CONSTRAINT `userrole_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userrole_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES (3, '9999c08ad44b3996b2aaa74fbdc4737e', 23);
INSERT INTO `userrole` VALUES (6, 'fe1f9c8e496434c28dcce0ea7e347b28', 22);
INSERT INTO `userrole` VALUES (7, '68bec08ad44b3996b2aaa74fbdc4737e', 21);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `updatetime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('68bec08ad44b3996b2aaa74fbdc4737e', '123456@qq.com', '大王管理员', '123456', '2019-06-27 11:03:00');
INSERT INTO `users` VALUES ('9999c08ad44b3996b2aaa74fbdc4737e', 'anmeijiao@qq.com', '土豆学生', '123456', '2019-06-27 11:03:07');
INSERT INTO `users` VALUES ('fe1f9c8e496434c28dcce0ea7e347b28', 'zhanghongyue@qq.com', '地瓜老师', '123456', '2019-06-27 11:03:04');

SET FOREIGN_KEY_CHECKS = 1;
