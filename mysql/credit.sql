/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : credit

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 29/01/2019 15:12:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任务描述',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程类型(required必修,elective选修)',
  `university_id` bigint(20) NULL DEFAULT NULL COMMENT '限定大学id',
  `university_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `faculty_id` bigint(20) NULL DEFAULT NULL COMMENT '限定的学院id',
  `faculty_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '限定系id',
  `subject_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'enable' COMMENT '是否禁用',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'a93d1bafb4884a56aa60b077fd7be25d', '高等数学1', NULL, 'elective', 1, '北华大学', NULL, NULL, NULL, NULL, 'enabled', 1, '2019-01-14 10:52:49', '2019-01-14 10:52:50');
INSERT INTO `course` VALUES (2, '980de821b92a43cda33751546ef8c01e', '高等数学2', NULL, 'elective', 1, '北华大学', NULL, NULL, NULL, NULL, 'enabled', 1, '2019-01-14 10:56:24', '2019-01-14 10:56:25');
INSERT INTO `course` VALUES (3, '8c8e0899e14642ec8e73e3aea93e5b8b', '高等数学3', NULL, 'elective', 1, '北华大学', 110, '计算机科学技术学院', NULL, NULL, 'enabled', 1, '2019-01-15 11:57:56', '2019-01-15 11:57:57');
INSERT INTO `course` VALUES (4, '8c8e0899e14642ec8e73e3aea93e5b86', '高等数学4', NULL, 'elective', 1, '北华大学', NULL, NULL, NULL, NULL, 'disabled', 1, '2019-01-14 11:01:44', '2019-01-14 11:01:45');
INSERT INTO `course` VALUES (5, '2b20f9ebf3514108a3574f7e950d94e7', '高等数学5', NULL, 'elective', 1, '北华大学', NULL, NULL, NULL, NULL, 'disabled', 1, '2018-12-21 09:12:36', '2018-12-21 09:12:36');
INSERT INTO `course` VALUES (6, '6c9e80ac1edd44318f91213891190ca4', '大学英语1', NULL, 'elective', 1, '北华大学', NULL, NULL, NULL, NULL, 'enabled', 1, '2019-01-14 10:56:55', '2019-01-14 10:56:55');
INSERT INTO `course` VALUES (7, '159c0433f8114544a97d58608735aaea', '课程1', NULL, 'required', NULL, NULL, NULL, NULL, NULL, NULL, 'enabled', 1, '2019-01-14 10:57:00', '2019-01-14 10:57:00');

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson`  (
  `lesson_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` bigint(20) NULL DEFAULT NULL COMMENT '课程id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任务描述',
  `maxnum` int(11) NOT NULL COMMENT '上限人数',
  `num` int(11) NULL DEFAULT NULL COMMENT '已选人数',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'nofull' COMMENT '课程类型(full已满,surplus有余,stop终止,)',
  `teacher_id` bigint(20) NOT NULL COMMENT '授课老师id',
  `teacher_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '授课老师姓名',
  `behavior` int(11) NULL DEFAULT NULL COMMENT '表现分百分比，结果/100',
  `test` int(11) NULL DEFAULT NULL COMMENT '实验分占百分比，结果/100',
  `exam` int(11) NULL DEFAULT NULL COMMENT '考试结果百分比，结果/100',
  `credit` int(11) NOT NULL DEFAULT 0 COMMENT '满学分',
  `teach_time` int(64) NOT NULL DEFAULT 0 COMMENT '授课时长',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'enable' COMMENT '是否可用(enable,disable)',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`lesson_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach`  (
  `teach_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `lesson_id` bigint(20) NOT NULL COMMENT '课程id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生描述',
  `student_id` bigint(20) NOT NULL COMMENT '学生id',
  `student_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '已选人数',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'teaching' COMMENT '学生授课状态(teaching授课中，teached授课结束，lose未参加)',
  `behavior` int(11) NULL DEFAULT NULL COMMENT '表现分，结果/10',
  `test` int(11) NULL DEFAULT NULL COMMENT '实验分，结果/10',
  `exam` int(11) NULL DEFAULT NULL COMMENT '考试分，结果/10',
  `score` int(11) NULL DEFAULT NULL COMMENT '最终成绩',
  `credit` int(11) NULL DEFAULT NULL COMMENT '学分，结果/10',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'enable' COMMENT '是否可用(enable,disable)',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`teach_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
