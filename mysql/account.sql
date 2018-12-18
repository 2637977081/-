/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 18/12/2018 18:30:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '键值',
  `value` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '值',
  `type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'enabled' COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `key_UNIQUE`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES (1, 'tag', '标注', 'sys', 'enabled', '2018-09-13 14:53:00', '2018-09-13 14:53:00');
INSERT INTO `dict` VALUES (2, 'audit', '审核', 'sys', 'enabled', '2018-09-13 14:53:00', '2018-09-13 14:53:00');
INSERT INTO `dict` VALUES (3, 'account', '用户管理', 'sys', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (4, 'tagTask', '标注任务', 'task_purpose', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (5, 'algorithmValidate', '算法验证任务', 'task_purpose', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (6, 'image', '图片任务', 'task_type', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (7, 'video', '视频任务', 'task_type', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (8, 'audio', '音频任务', 'task_type', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (9, 'tClassificationTag', '二分类标注', 'task_sub_image_type', 'enabled', '2018-09-17 11:09:55', '2018-11-13 18:29:53');
INSERT INTO `dict` VALUES (10, 'multiClassificationTag', '多分类标注', 'task_sub_image_type', 'enabled', '2018-09-17 11:09:55', '2018-11-13 18:29:53');
INSERT INTO `dict` VALUES (11, 'boundingBox', 'bounding box标注', 'task_sub_image_type', 'enabled', '2018-09-17 11:09:55', '2018-11-13 18:29:53');
INSERT INTO `dict` VALUES (12, 'divisionTag', '分割标注', 'task_sub_image_type', 'enabled', '2018-09-17 11:09:55', '2018-11-13 18:29:53');
INSERT INTO `dict` VALUES (13, 'wordRecognition', '文字识别', 'task_sub_image_type', 'enabled', '2018-09-17 11:09:55', '2018-11-13 18:29:53');
INSERT INTO `dict` VALUES (14, 'sliceTag', '切片标注', 'task_sub_type', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (15, 'speechRecognition', '语音识别', 'task_sub_type', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (16, 'unmarked', '未标注', 'resource_status', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (17, 'marked', '已标注', 'resource_status', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (18, 'audited', '已审核', 'resource_status', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (19, 'accepted', '已验收', 'resource_status', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (20, 'rejected', '被驳回', 'resource_status', 'enabled', '2018-09-17 11:09:55', '2018-09-17 11:09:55');
INSERT INTO `dict` VALUES (21, 'imagetClassificationTag', '图片二分类类型', 'task_image_type', 'enabled', '2018-11-13 15:30:11', '2018-11-13 18:31:48');
INSERT INTO `dict` VALUES (22, 'imageMultiClassificationTag', '图片多分类', 'task_image_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:31:48');
INSERT INTO `dict` VALUES (23, 'imageBoundingBox', '图片框标注', 'task_image_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:31:48');
INSERT INTO `dict` VALUES (24, 'imageWordRecognition', '图片文字识别', 'task_image_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:31:48');
INSERT INTO `dict` VALUES (25, 'imageDivisionTag', '图片分隔标注', 'task_image_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:38:44');
INSERT INTO `dict` VALUES (26, 'videoTClassificationTag', '视频二分类标注', 'task_video_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:38:37');
INSERT INTO `dict` VALUES (27, 'videoMultiClassificationTag', '视频多分类标注', 'task_video_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:38:31');
INSERT INTO `dict` VALUES (28, 'videoSliceTag', '视频切片标注', 'task_video_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:38:23');
INSERT INTO `dict` VALUES (29, 'videoSpeechRecognition', '视频语音识别', 'task_video_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:38:16');
INSERT INTO `dict` VALUES (30, 'videoWordRecognition', '视频文字识别', 'task_video_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:38:10');
INSERT INTO `dict` VALUES (31, 'audioTClassificationTag', '音频二分类标注', 'task_audio_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:38:01');
INSERT INTO `dict` VALUES (32, 'audioMultiClassificationTag', '音频多分类标注', 'task_audio_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:37:54');
INSERT INTO `dict` VALUES (33, 'audioSpeechRecognition', '音频语音识别', 'task_audio_type', 'enabled', '2018-11-13 15:34:18', '2018-11-13 18:37:47');
INSERT INTO `dict` VALUES (47, 'imageTClassNum', '图片二分类', 'task_statistics_ring', 'enabled', '2018-11-15 15:09:41', '2018-11-15 15:09:41');
INSERT INTO `dict` VALUES (48, 'videoTClassNum', '视频二分类', 'task_statistics_ring', 'enabled', '2018-11-15 15:12:52', '2018-11-15 15:12:52');
INSERT INTO `dict` VALUES (49, 'imageMultiClassNum', '图片多分类', 'task_statistics_ring', 'enabled', '2018-11-15 15:15:52', '2018-11-15 15:15:52');
INSERT INTO `dict` VALUES (50, 'videoMultiClassNum', '视频多分类', 'task_statistics_ring', 'enabled', '2018-11-15 15:15:52', '2018-11-15 15:15:52');
INSERT INTO `dict` VALUES (51, 'imageBoundingBoxNum', '图片bounding box标注', 'task_statistics_ring', 'enabled', '2018-11-15 15:15:52', '2018-11-15 15:15:52');
INSERT INTO `dict` VALUES (52, 'imageDivisionTagNum', '图片分割标注', 'task_statistics_ring', 'enabled', '2018-11-15 15:15:52', '2018-11-15 15:15:52');
INSERT INTO `dict` VALUES (53, 'audioTagNum', '音频标注', 'task_statistics_ring', 'enabled', '2018-11-15 15:15:52', '2018-11-15 15:15:52');
INSERT INTO `dict` VALUES (54, 'videoSliceTagNum', '视频片段标注', 'task_statistics_ring', 'enabled', '2018-11-15 15:15:52', '2018-11-15 15:15:52');
INSERT INTO `dict` VALUES (55, 'tagNumDay', '标注量', 'task_statistics_diagram', 'enabled', '2018-11-16 14:08:05', '2018-11-16 14:08:05');
INSERT INTO `dict` VALUES (56, 'auditNumDay', '审核量', 'task_statistics_diagram', 'enabled', '2018-11-16 14:08:05', '2018-11-16 14:08:05');
INSERT INTO `dict` VALUES (57, 'acceptNumDay', '验收量', 'task_statistics_diagram', 'enabled', '2018-11-16 14:08:05', '2018-11-16 14:08:05');
INSERT INTO `dict` VALUES (62, 'crawling', '爬取中', 'task_status', 'enabled', '2018-11-19 15:48:19', '2018-11-19 15:48:19');
INSERT INTO `dict` VALUES (63, 'totag', '待标注', 'task_status', 'enabled', '2018-11-19 15:48:19', '2018-11-19 15:48:19');
INSERT INTO `dict` VALUES (64, 'tagging', '标注中', 'task_status', 'enabled', '2018-11-19 15:48:19', '2018-11-19 15:48:19');
INSERT INTO `dict` VALUES (65, 'completed', '已完成', 'task_status', 'enabled', '2018-11-19 15:48:19', '2018-11-19 15:48:19');
INSERT INTO `dict` VALUES (66, 'formalTask', '正式任务', 'task_nature', 'enabled', '2018-11-19 16:13:39', '2018-11-19 16:13:39');
INSERT INTO `dict` VALUES (67, 'testTask', '练习任务', 'task_nature', 'enabled', '2018-11-19 16:13:39', '2018-11-20 16:46:48');
INSERT INTO `dict` VALUES (68, 'crawl', '爬虫', 'resource_from', 'enabled', '2018-11-19 16:28:23', '2018-11-19 16:28:23');
INSERT INTO `dict` VALUES (69, 'localUpload', '本地上传', 'resource_from', 'enabled', '2018-11-19 16:28:23', '2018-11-19 16:28:23');
INSERT INTO `dict` VALUES (70, 'tagRole', '标注员', 'task_role', 'enabled', '2018-11-21 17:05:06', '2018-11-21 17:05:06');
INSERT INTO `dict` VALUES (71, 'auditRole', '审核员', 'task_role', 'enabled', '2018-11-21 17:05:06', '2018-11-21 17:05:06');
INSERT INTO `dict` VALUES (72, 'acceptRole', '验收员', 'task_role', 'enabled', '2018-11-21 17:05:06', '2018-11-21 17:05:06');

-- ----------------------------
-- Table structure for func
-- ----------------------------
DROP TABLE IF EXISTS `func`;
CREATE TABLE `func`  (
  `func_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '路径',
  `icon` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
  `number` bigint(20) NOT NULL DEFAULT 0 COMMENT '序号',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父ID',
  `root_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '根节点',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'enabled' COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`func_id`) USING BTREE,
  UNIQUE INDEX `name_UNIQUE`(`name`) USING BTREE,
  UNIQUE INDEX `code_UNIQUE`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120514 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of func
-- ----------------------------
INSERT INTO `func` VALUES (100000, 'n603715efc9a407196c3152c4ec87860', '系统', '系统', '', '图标', 'all', 0, 0, 0, 'hide', '2018-09-17 11:01:27', '2018-10-09 20:21:40');
INSERT INTO `func` VALUES (110000, '09o735e9c99d4bf788337debb3d3f300', '组织管理', '用户管理系统', '', '图标', 'account', 0, 100000, 110000, 'enabled', '2018-09-17 11:07:59', '2018-11-09 14:31:02');
INSERT INTO `func` VALUES (110100, 'f244715efc9a407196c3152c4ec89861', '用户管理', '用户管理', '/main/user', '用户管理icon', 'user', 0, 110000, 110000, 'enabled', '2018-09-17 17:30:06', '2018-11-08 15:42:35');
INSERT INTO `func` VALUES (110101, 'f244715efc9a407196c3152c4ec87860', '删除用户', '删除用户', '/service/account/user/delete/{id}', '删除用户icon01', 'user', 0, 110100, 110000, 'enabled', '2018-09-17 13:35:46', '2018-10-11 11:41:50');
INSERT INTO `func` VALUES (110102, '8255690f984f453290da880ec162de9c', '修改用户', '修改用户', '/service/account/user/update', '修改用户icon', 'user', 1, 110100, 110000, 'enabled', '2018-09-17 13:36:30', '2018-10-11 11:41:55');
INSERT INTO `func` VALUES (110103, 'abfa395801324a76a22e892434779a3f', '创建用户', '创建用户', '/service/account/user/add', '创建用户icon', 'user', 2, 110100, 110000, 'enabled', '2018-09-17 13:39:20', '2018-10-11 11:41:58');
INSERT INTO `func` VALUES (110104, 'd402d6fd99404b5faf4c20d2819ed0be', '修改密码', '修改密码', '/service/account/user/update/password', '修改密码icon', 'user', 3, 110100, 110000, 'enabled', '2018-09-17 17:16:33', '2018-10-11 11:42:03');
INSERT INTO `func` VALUES (110105, 'c65bca1e7b774eb8888a3c29154588da', '查询用户', '查询用户', '/service/account/user/list', '查询用户icon', 'user', 4, 110100, 110000, 'enabled', '2018-09-17 17:19:39', '2018-10-11 11:42:06');
INSERT INTO `func` VALUES (110106, 'c65bca1e7b774eb8888a3c20154588da', '查询用户详情', '查询用户详情', '/service/account/user/detail/{userId}', '查询用户详情icon', 'user', 5, 110100, 110000, 'enabled', '2018-09-17 17:19:39', '2018-10-15 14:59:20');
INSERT INTO `func` VALUES (110200, '71ece202aa8840688fd79e9b59ada628', '角色管理', '角色管理description', '/main/role', '角色管理icon', 'role', 1, 110000, 110000, 'enabled', '2018-09-17 17:55:33', '2018-12-05 11:25:00');
INSERT INTO `func` VALUES (110201, 'c574ba552d14410fbd9378c7d67039f0', '添加角色', '添加角色description', '/service/account/role/add', '添加角色icon', 'role', 0, 110200, 110000, 'enabled', '2018-09-17 17:56:19', '2018-10-11 11:42:12');
INSERT INTO `func` VALUES (110202, '06e72fdc5fce4706ab16bdc0763571db', '更新角色信息', '更新角色信息description', '/service/account/role/update', '更新角色信息icon', 'role', 1, 110200, 110000, 'enabled', '2018-09-17 17:58:12', '2018-10-11 11:42:15');
INSERT INTO `func` VALUES (110203, '6dcef5eff183485698e51a10a7032dc8', '查询角色详情', '查询角色详情description', '/service/account/role/detail/{roleId}', '查询角色详情icon', 'role', 2, 110200, 110000, 'enabled', '2018-09-17 17:59:10', '2018-10-11 11:42:18');
INSERT INTO `func` VALUES (110204, '3b6a77c473f14c11ac5bb148df54cc40', '查询用户的角色和功能列表', '查询用户的角色和功能列表description', '/service/account/role/func/list/{userId}', '查询用户的角色和功能列表icon', 'role', 3, 110200, 110000, 'enabled', '2018-09-17 18:00:19', '2018-10-11 11:42:21');
INSERT INTO `func` VALUES (110205, 'l3p79f3110084d30acac310ac5ac6b8e', '角色列表查询', '角色列表查询desp', '/service/account/role/list', '角色列表查询icon', 'role', 4, 110200, 110000, 'enabled', '2018-09-27 18:06:33', '2018-10-11 11:42:25');
INSERT INTO `func` VALUES (110206, '96p79f3110084d30acao310ac5ac6b8e', '删除角色', '删除角色desp', '/service/account/role/delete/{roleId}', '删除角色icon', 'role', 5, 110200, 110000, 'enabled', '2018-09-27 18:06:33', '2018-10-11 11:42:25');
INSERT INTO `func` VALUES (110400, '38e235904e3c4de884450436005579a2', '组织机构管理', '组织机构管理description', '/main/org', '组织机构管理icon', 'org', 2, 110000, 110000, 'enabled', '2018-09-17 18:02:01', '2018-12-05 11:25:02');
INSERT INTO `func` VALUES (110401, '086435e9c99d4bf788337debb3d3f391', '添加机构', '添加机构description', '/service/account/org/add', '添加机构icon', 'org', 0, 110400, 110000, 'enabled', '2018-09-17 18:03:47', '2018-10-11 11:32:52');
INSERT INTO `func` VALUES (110402, 'ea6b65fe2a274dbc87a9ef3c2a34f2e7', '更新机构信息', '更新机构信息description', '/service/account/org/update', '更新机构信息icon', 'org', 1, 110400, 110000, 'enabled', '2018-09-17 18:04:56', '2018-10-11 11:32:56');
INSERT INTO `func` VALUES (110403, '87d2efb390ae4725a609de2119e2ef35', '删除机构', '删除机构description', '/service/account/org/delete/{orgId}', '删除机构icon', 'org', 2, 110400, 110000, 'enabled', '2018-09-17 18:05:29', '2018-10-11 11:33:01');
INSERT INTO `func` VALUES (110404, 'dd22940ed9664ee68f2feb4a51f50474', '组织机构更换顺序', '组织机构更换顺序description', '/service/account/org/exchange/{id1}/{id2}', '组织机构更换顺序icon', 'org', 3, 110400, 110000, 'enabled', '2018-09-17 18:06:06', '2018-10-11 11:33:12');
INSERT INTO `func` VALUES (110405, '8eb17ea569b945a0ae091bfd5050fe62', '查询机构详情', '查询机构详情description', '/service/account/org/detail/{orgId}', '查询机构详情icon', 'org', 4, 110400, 110000, 'enabled', '2018-09-17 18:06:50', '2018-10-11 11:33:17');
INSERT INTO `func` VALUES (110406, '1920d28fc25546e0936901af7c0ef304', '机构树形列表', '机构树形列表description', '/service/account/org/list', '机构树形列表icon', 'org', 5, 110400, 110000, 'enabled', '2018-09-17 18:07:28', '2018-10-11 11:33:20');
INSERT INTO `func` VALUES (110501, '23f79f3110084d30acac310ac5ac6b8e', '添加功能', '添加功能description', '/service/account/func/add', '添加功能icon', 'func', 6, 110200, 110000, 'enabled', '2018-09-17 18:54:47', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (110502, 'a51b5815c054449a9301d3b69678c24b', '查询功能详情', '查询功能详情description', '/service/account/func/detail/{funcId}', '查询功能详情icon', 'func', 7, 110200, 110000, 'enabled', '2018-09-17 18:55:32', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (110503, 'bb4bad0029534194aa41eae63b3d39a8', '更新功能基本信息', '更新功能基本信息description', '/service/account/func/update', '更新功能基本信息icon', 'func', 8, 110200, 110000, 'enabled', '2018-09-17 18:56:05', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (110504, 'f91a7a93abda46679bb8bfc65b872f8a', '删除功能', '删除功能description', '/service/account/func/delete/{funcId}', '删除功能icon', 'func', 9, 110200, 110000, 'enabled', '2018-09-17 18:56:33', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (110505, 'effecd9f7da145efbf5b6e8343295bfd', '功能树形列表', '功能树形列表', '/service/account/func/list/{funcId}', '功能树形列表icon', 'func', 10, 110200, 110000, 'enabled', '2018-09-17 18:57:57', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (110506, 'effecd9f7da145efbf5b6e8340o95bfd', '多系统树形列表查询', '多系统树形列表查询', '/service/account/func/systems/ids', 'icon', 'func', 11, 110200, 110000, 'enabled', '2018-09-17 18:57:57', '2018-12-12 16:02:05');

-- ----------------------------
-- Table structure for func_role
-- ----------------------------
DROP TABLE IF EXISTS `func_role`;
CREATE TABLE `func_role`  (
  `func_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `func_id` bigint(20) NOT NULL COMMENT '功能ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'enabled' COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`func_role_id`) USING BTREE,
  UNIQUE INDEX `func_role`(`func_id`, `role_id`) USING BTREE,
  INDEX `func_role_key_1_idx`(`func_id`) USING BTREE,
  INDEX `func_role_key_2_idx`(`role_id`) USING BTREE,
  CONSTRAINT `func_role_key_1` FOREIGN KEY (`func_id`) REFERENCES `func` (`func_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `func_role_key_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 266 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of func_role
-- ----------------------------
INSERT INTO `func_role` VALUES (113, 100000, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (114, 110000, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (115, 110100, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (116, 110101, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (117, 110102, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (118, 110103, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (119, 110104, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (120, 110105, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (121, 110106, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (122, 110200, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (123, 110201, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (124, 110202, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (125, 110203, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (126, 110204, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (127, 110205, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (128, 110206, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (129, 110400, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (130, 110401, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (131, 110402, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (132, 110403, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (133, 110404, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (134, 110405, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (135, 110406, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (136, 110501, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (137, 110502, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (138, 110503, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (139, 110504, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (140, 110505, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');
INSERT INTO `func_role` VALUES (141, 110506, 2, 'enabled', '2018-12-17 10:54:37', '2018-12-17 10:54:37');

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org`  (
  `org_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
  `number` bigint(20) NOT NULL DEFAULT 0 COMMENT '序号',
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父ID',
  `root_id` bigint(20) NOT NULL DEFAULT 0,
  `creater_id` bigint(20) NOT NULL COMMENT '创建者',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'enabled' COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`org_id`) USING BTREE,
  UNIQUE INDEX `code_UNIQUE`(`code`) USING BTREE,
  INDEX `org_key_1_idx`(`creater_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES (1, '5c493c91f94511e89e9b0242ac120002', '北华大学', 'university', 0, '人工智能', 0, 1, 1, 'enabled', '2018-12-06 18:54:53', '2018-12-17 20:04:31');
INSERT INTO `org` VALUES (2, '26df6c5b1e184288827afcbe6ef330ae', '计算机科学技术学院', 'faculty', 0, '', 1, 1, 2, 'enabled', '2018-12-07 10:53:02', '2018-12-17 20:07:52');
INSERT INTO `org` VALUES (3, 'fb4a8981134e40e6bb30bba41094947e', '电气学院', 'faculty', 1, '', 1, 1, 2, 'enabled', '2018-12-07 10:54:11', '2018-12-17 20:07:53');
INSERT INTO `org` VALUES (4, '627569c496c14d60b234ae0bd17ea758', '机械学院', 'faculty', 2, '', 1, 1, 2, 'enabled', '2018-12-07 10:54:21', '2018-12-17 20:07:16');
INSERT INTO `org` VALUES (6, '6c257305cb27403a933cce8cb3eb8526', '网络', 'department', 1, NULL, 2, 1, 3, 'enabled', '2018-12-17 11:51:54', '2018-12-17 20:07:39');
INSERT INTO `org` VALUES (101, 'bad9ff5e0f3a4a3ebdf1841a67b93d6c', '计算机科学与技术', 'department', 0, '', 2, 1, 2, 'enabled', '2018-12-07 10:54:28', '2018-12-17 20:08:16');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
  `creater_id` bigint(20) NOT NULL COMMENT '创建者',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'enabled' COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `code_UNIQUE`(`code`) USING BTREE,
  INDEX `role_key_1_idx`(`creater_id`) USING BTREE,
  CONSTRAINT `role_key_1` FOREIGN KEY (`creater_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'super', '超级管理员', '所有权限', 'function', 1, 'enabled', '2018-12-06 18:54:53', '2018-12-06 18:54:53');
INSERT INTO `role` VALUES (2, 'tag-admin', '标注管理员', '标注管理', 'roleType', 1, 'enabled', '2018-12-06 18:54:53', '2018-12-17 10:54:37');
INSERT INTO `role` VALUES (3, '1a1dc8af5fdf4b4e86001c175b7a1670', '标注测试', NULL, 'roleType', 1, 'enabled', '2018-12-06 19:07:20', '2018-12-06 19:07:20');
INSERT INTO `role` VALUES (9, '2035dcdfdba7411e8fe71dafa2d3bb3e', '测试角色', '测试标注系统修改角色', 'roleType', 3, 'enabled', '2018-12-17 10:36:13', '2018-12-17 11:52:14');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编码',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名字',
  `gender` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `avatar` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `captcha_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否需要验证码，0：不需要，1：需要',
  `reset_status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否已重置密码，0：未重置，1：已重置',
  `org_id` bigint(20) NOT NULL COMMENT '组织机构ID',
  `creater_id` bigint(20) NOT NULL COMMENT '创建者',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'enabled' COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `code_UNIQUE`(`code`) USING BTREE,
  UNIQUE INDEX `username_UNIQUE`(`username`) USING BTREE,
  UNIQUE INDEX `email_UNIQUE`(`email`) USING BTREE,
  UNIQUE INDEX `phone_UNIQUE`(`phone`) USING BTREE,
  INDEX `user_key_1_idx`(`org_id`) USING BTREE,
  CONSTRAINT `user_key_1` FOREIGN KEY (`org_id`) REFERENCES `org` (`org_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1122 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '5c4cddebf94511e89e9b0242ac120002', 'superadmin', '周同科技', '', 'lvgang@univer.ai', '15101195887', '$2a$04$Pn6IfavXvPpIZ203SCRerOAFlu4KlX6R/1CwZq4hTi1oFLEdcVMiS', NULL, NULL, '让视频的每一秒都是人工智能', 0, 0, 1, 1, 'enabled', '2018-12-06 18:54:53', '2018-12-18 17:51:07');
INSERT INTO `user` VALUES (3, 'f3a9da196e6e473fadef716ca5735158', 'gaoliting', 'gaoliting', '', 'liting@univer.ai', '15748596325', '$2a$04$.PsYr7LhusxiozsVGKwANekEqG6knXs44gbXbVEUauYWE3AmWovW2', NULL, NULL, NULL, 0, 1, 1, 1, 'enabled', '2018-12-06 19:07:04', '2018-12-17 09:14:24');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'enabled' COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`user_role_id`) USING BTREE,
  UNIQUE INDEX `user_role`(`user_id`, `role_id`) USING BTREE,
  INDEX `user_role_key_1_idx`(`user_id`) USING BTREE,
  INDEX `user_role_key_2_idx`(`role_id`) USING BTREE,
  CONSTRAINT `user_role_key_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_key_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, 'enabled', '2018-12-06 18:54:53', '2018-12-06 18:54:53');
INSERT INTO `user_role` VALUES (3, 3, 1, 'enabled', '2018-12-06 19:07:04', '2018-12-06 19:07:04');

SET FOREIGN_KEY_CHECKS = 1;
