/*
 Navicat Premium Data Transfer

 Source Server         : univer
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : univer-mysql.home.univer:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 13/12/2018 17:12:48
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
INSERT INTO `func` VALUES (120000, 'fh4g7r5efc9a407196c3152c4ec89861', '标注系统', '标注系统管理', '', '标注图标', 'tag', 1, 100000, 120000, 'enabled', '2018-09-17 11:09:20', '2018-12-05 11:27:48');
INSERT INTO `func` VALUES (120100, 'f255715efc9a407196c3152c4ec89861', '组管理', '组管理', '/main/group', '组管理icon', 'group', 0, 120000, 120000, 'enabled', '2018-09-17 17:30:06', '2018-11-08 15:46:06');
INSERT INTO `func` VALUES (120101, 'f200715efc9a407196c3152c4ec87860', '列表查询', '列表查询', '/service/tag/groups/list', '列表查询icon01', 'group', 0, 120100, 120000, 'enabled', '2018-09-17 13:35:46', '2018-10-11 11:41:50');
INSERT INTO `func` VALUES (120102, '82pp690f984f453290da880ec162de9c', '创建组', '创建组', '/service/tag/groups/add', '创建组icon', 'group', 1, 120100, 120000, 'enabled', '2018-09-17 13:36:30', '2018-10-11 11:41:55');
INSERT INTO `func` VALUES (120103, 'abff395801324a76a22e892434779a3f', '删除组', '删除组', '/service/tag/groups/delete/{groupId}', '删除组icon', 'group', 2, 120100, 120000, 'enabled', '2018-09-17 13:39:20', '2018-10-11 11:41:58');
INSERT INTO `func` VALUES (120104, 'd4jhd6fd99404b5faf4c20d2819ed0be', '更新组信息', '更新组信息', '/service/tag/groups/update', '更新组信息icon', 'group', 3, 120100, 120000, 'enabled', '2018-09-17 17:16:33', '2018-10-11 11:42:03');
INSERT INTO `func` VALUES (120105, 'c6lgca1e7b774eb8888a3c29154588da', '查询组详情', '查询组详情', '/service/tag/groups/detail/{groupId}', '查询组详情icon', 'group', 4, 120100, 120000, 'enabled', '2018-09-17 17:19:39', '2018-10-11 11:42:06');
INSERT INTO `func` VALUES (120106, 'c6lgca1e7b77llb8888a3c29154588da', '查询组用户', '查询组用户', '/service/tag/groups/users', '查询组用户icon', 'group', 5, 120100, 120000, 'enabled', '2018-09-17 17:19:39', '2018-10-11 11:42:06');
INSERT INTO `func` VALUES (120200, 'f255715efc9a4071hlc3152c4ec89861', '标签管理', '标签管理', '/main/tag', '标签管理icon', 'tag', 1, 120000, 120000, 'enabled', '2018-09-17 17:30:06', '2018-12-04 09:40:05');
INSERT INTO `func` VALUES (120201, 'f200715efc9a407gl6c3152c4ec87860', '修改标签信息', '修改标签信息', '/service/tag/tag/update', '修改标签信息icon01', 'tag', 0, 120200, 120000, 'enabled', '2018-09-17 13:35:46', '2018-10-11 11:41:50');
INSERT INTO `func` VALUES (120202, '82pp690f984f453fr0da880ec162de9c', '标签树形列表', '标签树形列表', '/service/tag/tag/list', '标签树形列表icon', 'tag', 1, 120200, 120000, 'enabled', '2018-09-17 13:36:30', '2018-10-11 11:41:55');
INSERT INTO `func` VALUES (120203, 'abff395801324a7ik22e892434779a3f', '标签详情', '标签详情', '/service/tag/tag/detail/{tagId}', '标签详情icon', 'tag', 2, 120200, 120000, 'enabled', '2018-09-17 13:39:20', '2018-10-11 11:41:58');
INSERT INTO `func` VALUES (120204, 'd4jhd6fd99404b5olf4c20d2819ed0be', '添加标签', '添加标签', '/service/tag/tag/add', '添加标签icon', 'tag', 3, 120200, 120000, 'enabled', '2018-09-17 17:16:33', '2018-10-11 11:42:03');
INSERT INTO `func` VALUES (120205, 'c6lgca1e7b774ebpj88a3c29154588da', '删除标签', '删除标签', '/service/tag/tag/delete/{tagIds}', '删除标签icon', 'tag', 4, 120200, 120000, 'enabled', '2018-09-17 17:19:39', '2018-10-11 11:42:06');
INSERT INTO `func` VALUES (120206, 'c6llka1e7b774ebpj88a3c29154588da', '查询下一级标签列表', '查询下一级标签列表', '/service/tag/tag/children', '查询下一级标签列表icon', 'tag', 5, 120200, 120000, 'enabled', '2018-09-17 17:19:39', '2018-10-11 11:42:06');
INSERT INTO `func` VALUES (120300, 'f905715efc9a4071hlc3152c4ec89861', '任务管理', '任务管理', '/main/task', '任务管理icon', 'task', 2, 120000, 120000, 'enabled', '2018-09-17 17:30:06', '2018-12-04 09:41:01');
INSERT INTO `func` VALUES (120301, 'l200715efc9a407gl6c3152c4ec87860', '任务列表', '任务列表', '/service/tag/task/list', '任务列表icon01', 'task', 0, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-10-31 09:34:50');
INSERT INTO `func` VALUES (120302, 'f400715efc9a407gl6c3152c4ec87860', '任务详情', '任务详情', '/service/tag/task/detail/{taskId}', '任务详情icon01', 'task', 1, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-10-31 10:27:58');
INSERT INTO `func` VALUES (120303, 'f500715efc9a407gl6c3152c4ec87860', '创建任务', '创建任务', '/service/tag/task/add', '创建任务icon01', 'task', 2, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-10-31 10:28:06');
INSERT INTO `func` VALUES (120304, 'cad8b0d4197a49d991d191e5768c27f5', '任务列表页面下拉框', '任务列表页面下拉框', '/service/tag/task/button', '任务列表页面下拉框icon01', 'task', 3, 120300, 120000, 'enabled', '2018-12-04 10:27:06', '2018-12-04 10:31:33');
INSERT INTO `func` VALUES (120305, 'ef4d2dffe7324933922bd18cdce3956d', '工作量统计查询', '工作量统计查询', '/service/tag/task/get/user/handle/list', '工作量统计查询icon01', 'task', 4, 120300, 120000, 'enabled', '2018-12-04 10:31:33', '2018-12-04 10:31:33');
INSERT INTO `func` VALUES (120306, '4d7239d961d54df4847667ec22c6a65d', '数据总览', '数据总览', '/service/tag/task/statistics', '数据总览icon01', 'task', 5, 120300, 120000, 'enabled', '2018-12-04 10:33:06', '2018-12-05 10:55:30');
INSERT INTO `func` VALUES (120307, 'f50407adb1604fc18f23195526e156f2', '获取任务列表数量', '获取任务列表数量', '/service/tag/task/get/list/number', '获取任务列表数量icon01', 'task', 6, 120300, 120000, 'enabled', '2018-12-04 10:33:06', '2018-12-05 10:55:30');
INSERT INTO `func` VALUES (120308, '09488d77efa24d20aa34d2c039bdd30b', '通过taskId查询tag的层级的集合', '通过taskId查询tag的层级的集合', '/service/tag/tag/list/name/{taskId}', '通过taskId查询tag的层', 'task', 7, 120300, 120000, 'enabled', '2018-12-05 15:18:12', '2018-12-05 15:34:13');
INSERT INTO `func` VALUES (120401, 'f800715efc9a407gl6c3152c4ec87860', '审核设置标注员信息列表', '审核设置标注员信息列表', '/service/tag/task/user/list/tag/role', 'icon01', 'task', 8, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120402, 'f880715efc9a407gl6c3152c4ec87860', '设置整个任务的审核或者验收数量和抽取比例', '设置整个任务的审核或者验收数量和抽取比例', '/service/tag/task/user/update/num', 'icon01', 'task', 9, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120403, 'f770715efc9a407gl6c3152c4ec87860', '设置针对单个标注员或者审核员的审核或者验收数量和抽取比例', '设置针对单个标注员或者审核员的审核或者验收数量和抽取比例', '/service/tag/task/user/list/audit/submit', 'icon01', 'task', 10, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120404, 'f440715efc9a407gl6c3152c4ec87860', '返回标注员下拉框', '返回标注员下拉框', '/service/tag/task/user/list/tag/user/{taskId}', '返回标注员下拉框icon01', 'task', 11, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120405, '7c9ba7d0b78e47eb9b0a6fec035866d7', '设置整个任务的验收数量和抽取比例', '设置整个任务的验收数量和抽取比例', '/service/tag/task/user/update/accept/num', '设置整个任务的验收数量和抽取ic', 'task', 12, 120300, 120000, 'enabled', '2018-12-04 11:12:10', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120406, '0944eb08fc984b758b0be37c089ff086', '设置针对单个审核员的验收数量和抽取比例', '设置针对单个审核员的验收数量和抽取比例', '/service/tag/task/user/list/accept/submit', '置针对单个审核员的验收数量和抽取', 'task', 13, 120300, 120000, 'enabled', '2018-12-04 11:15:34', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120407, 'ac7acd0e2ab244d49d9ed05489e752fe', '验收设置审核员信息列表', '验收设置审核员信息列表', '/service/tag/task/user/list/audit/role', '验收设置审核员信息列表', 'task', 14, 120300, 120000, 'enabled', '2018-12-04 11:17:49', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120408, 'bfe8d9b7b50c49d9b8e940a8bd775597', '返回审核员下拉框', '返回审核员下拉框', '/service/tag/task/user/list/audit/user/{taskId}', '返回审核员下拉框icon01', 'task', 15, 120300, 120000, 'enabled', '2018-12-10 17:48:39', '2018-12-12 16:00:21');
INSERT INTO `func` VALUES (120409, '6b56172b23d6476dac5084c05d762250', '返回验收员下拉框', '返回验收员下拉框', '/service/tag/task/user/list/accept/user/{taskId}', '返回验收员下拉框icon02', 'task', 16, 120300, 120000, 'enabled', '2018-12-04 11:15:34', '2018-12-12 16:00:23');
INSERT INTO `func` VALUES (120501, 'f300715efc9a407gl6c3152c4ec87860', '任务界面任务状态', '任务界面任务状态', '/service/tag/resource/tag/detail/{taskId}', '任务界面任务状态icon01', 'resource', 15, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120502, 'f600715efc9a407gl6c3152c4ec87860', '审核任务界面样本列表', '审核任务界面样本列表', '/service/tag/resource/list/audit', 'icon', 'resource', 16, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120503, 'f700715efc9a407gl6c3152c4ec87860', '审核或者验收全部驳回', '审核或者验收全部驳回', '/service/tag/resource/reject/all', 'icon01', 'resource', 17, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120504, 'f900715efc9a407gl6c3152c4ec87860', '标注任务界面样本列表', '标注任务界面样本列表', '/service/tag/resource/list', '标注任务界面样本列表icon01', 'resource', 18, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120505, 'f660715efc9a407gl6c3152c4ec87860', '资源审核或者验收后提交', '资源审核或者验收后提交', '/service/tag/resource/update/submit/list', 'icon01', 'resource', 19, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120506, 'f550715efc9a407gl6c3152c4ec87860', '资源标记提交', '资源标记提交', '/service/tag/resource/update/list', '资源标记提交icon01', 'resource', 20, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120507, '54071b3450194494a9b8fbab8e90b0f6', '验收图片', '验收图片', '/service/tag/resource/accept/ids', '验收图片icon01', 'resource', 21, 120300, 120000, 'enabled', '2018-09-17 13:35:46', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120508, '2045043142374ec3958c1998be3202ed', '审核或者验收任务界面样本列表', '审核或者验收任务界面样本列表', '/service/tag/resource/list/resources', '审核或者验收任务界面样本列表', 'resource', 22, 120300, 120000, 'enabled', '2018-12-04 11:58:44', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120509, '454fa4522fc14f5aa1c3bfa03eb7aca7', '浏览图片', '浏览图片', '/service/tag/resource/browse', '浏览图片icon01', 'resource', 23, 120300, 120000, 'enabled', '2018-12-04 11:00:52', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120510, '265e4d827ac04e96a2af187f37b8fefd', '浏览图片ids', '通过ids浏览图片', '/service/tag/resource/browse/ids', '通过ids浏览图片icon01', 'resource', 24, 120300, 120000, 'enabled', '2018-12-04 11:03:00', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120511, '6ace3b651e22418e820563878da8ed26', '资源验收后提交', '资源验收后提交', '/service/tag/resource/update/submit/accept/list', '资源验收后提交icon01', 'resource', 25, 120300, 120000, 'enabled', '2018-12-04 11:04:35', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120512, '77013415f7d247d8ae9d1fd8037a91db', '验收任务界面样本列表', '验收任务界面样本列表', '/service/tag/resource/list/accept', '验收任务界面样本列表icon01', 'resource', 26, 120300, 120000, 'enabled', '2018-12-04 11:06:18', '2018-12-12 16:02:05');
INSERT INTO `func` VALUES (120513, '8138b6a766544397954a095fdb23e705', '验收全部驳回', '验收全部驳回', '/service/tag/resource/reject/accept/all', '验收全部驳回icon01', 'resource', 27, 120300, 120000, 'enabled', '2018-12-04 11:07:16', '2018-12-12 16:02:05');

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
  CONSTRAINT `func_role_key_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of func_role
-- ----------------------------
INSERT INTO `func_role` VALUES (72, 120301, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (73, 120302, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (74, 120304, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (75, 120305, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (76, 120306, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (77, 120307, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (78, 120308, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (79, 120401, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (80, 120402, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (81, 120403, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (82, 120404, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (83, 120405, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (84, 120406, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (85, 120407, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (86, 120408, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (87, 120409, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (88, 120501, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (89, 120502, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (90, 120503, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (91, 120504, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (92, 120505, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (93, 120506, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (94, 120507, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (95, 120508, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (96, 120509, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (97, 120510, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (98, 120511, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (99, 120512, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');
INSERT INTO `func_role` VALUES (100, 120513, 3, 'enabled', '2018-12-12 16:05:41', '2018-12-12 16:05:41');

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES (1, '5c493c91f94511e89e9b0242ac120002', '北京周同科技有限公司', 'ai', 0, '人工智能', 0, 1, 1, 'enabled', '2018-12-06 18:54:53', '2018-12-06 18:54:53');
INSERT INTO `org` VALUES (2, '26df6c5b1e184288827afcbe6ef330ae', '技术部', 'orgType', 0, '', 1, 1, 2, 'enabled', '2018-12-07 10:53:02', '2018-12-07 10:53:02');
INSERT INTO `org` VALUES (3, 'fb4a8981134e40e6bb30bba41094947e', '研发Team', 'orgType', 0, '', 2, 1, 2, 'enabled', '2018-12-07 10:54:11', '2018-12-07 10:54:11');
INSERT INTO `org` VALUES (4, '627569c496c14d60b234ae0bd17ea758', '品牌部', 'orgType', 1, '', 1, 1, 2, 'enabled', '2018-12-07 10:54:21', '2018-12-07 10:54:21');
INSERT INTO `org` VALUES (5, 'bad9ff5e0f3a4a3ebdf1841a67b93d6c', '市场部', 'orgType', 2, '', 1, 1, 2, 'enabled', '2018-12-07 10:54:28', '2018-12-07 10:54:28');

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
  CONSTRAINT `role_key_1` FOREIGN KEY (`creater_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'super', '超级管理员', '所有权限', 'function', 1, 'enabled', '2018-12-06 18:54:53', '2018-12-06 18:54:53');
INSERT INTO `role` VALUES (2, 'tag-admin', '标注管理员', '标注管理', 'data', 1, 'enabled', '2018-12-06 18:54:53', '2018-12-06 18:54:53');
INSERT INTO `role` VALUES (3, '1a1dc8af5fdf4b4e86001c175b7a1670', '标注测试', NULL, 'roleType', 1, 'enabled', '2018-12-06 19:07:20', '2018-12-06 19:07:20');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编码',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
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
  CONSTRAINT `user_key_1` FOREIGN KEY (`org_id`) REFERENCES `org` (`org_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1121 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '5c4cddebf94511e89e9b0242ac120002', 'superadmin', '周同科技', 'guwei@univer.ai', '15101195887', '$2a$04$Pn6IfavXvPpIZ203SCRerOAFlu4KlX6R/1CwZq4hTi1oFLEdcVMiS', NULL, NULL, '让视频的每一秒都是人工智能', 0, 0, 1, 1, 'enabled', '2018-12-06 18:54:53', '2018-12-06 18:54:53');
INSERT INTO `user` VALUES (2, '6085d5be51b8456cae563600847000f6', 'yini', 'yini', 'yini@univer.ai', '18547854789', '$2a$04$pfTFP9NypH6afeSq5PJvuugNQTNh2WLHOQngGO13fkmWG3x9oHcie', NULL, NULL, NULL, 0, 1, 1, 1, 'enabled', '2018-12-06 19:06:33', '2018-12-06 19:06:33');
INSERT INTO `user` VALUES (3, 'f3a9da196e6e473fadef716ca5735158', 'gaoliting', 'gaoliting', 'liting@univer.ai', '15748596325', '$2a$04$.PsYr7LhusxiozsVGKwANekEqG6knXs44gbXbVEUauYWE3AmWovW2', NULL, NULL, NULL, 0, 1, 1, 1, 'enabled', '2018-12-06 19:07:04', '2018-12-13 10:55:40');
INSERT INTO `user` VALUES (4, '9457df19d39547c4904321d2bcdeb43a', 'liting1', 'liting1', 'liting1@univer.ai', '18547547542', '$2a$04$7QuEnShnbsTJZt.IjqomH.Qrrd95giLT4D/SA30A7Cn9XSw/bd98y', NULL, NULL, NULL, 0, 1, 1, 3, 'enabled', '2018-12-06 19:08:12', '2018-12-07 15:17:28');
INSERT INTO `user` VALUES (5, '780eda69a89d4c0297b0dba4355c5419', 'yini2', 'yini2', 'yini2@163.com', '18600000002', '$2a$04$0JW8IWg9GmekNSVOX./MnOhm4fMEHih.mlADfFhBZ83HjfP2VZLTu', NULL, NULL, '', 0, 1, 1, 2, 'enabled', '2018-12-06 19:08:36', '2018-12-06 19:30:40');
INSERT INTO `user` VALUES (6, 'b01f7c66e9a74dd2bca4b8a04a3d05ff', 'liting2', 'liting2', 'liting2@univer.ai', '18745265874', '$2a$04$lD7AK.fDutgMUHurjd37QuPXp1kza/5WmavFPzkMk2HzQH8a.wMnG', NULL, NULL, NULL, 0, 1, 1, 3, 'enabled', '2018-12-06 19:08:43', '2018-12-11 09:17:44');
INSERT INTO `user` VALUES (7, '9c34522f4433460f93580590175d9bb1', 'yini3', 'yini3', 'yini3@163.com', '18600000003', '$2a$04$3g1KmQz/yNPCpkLMvv/ep.lXAyFXCcAiZxAXf0OStVK3qj3hCs5Va', NULL, NULL, NULL, 0, 1, 1, 2, 'enabled', '2018-12-06 19:09:07', '2018-12-06 19:09:07');
INSERT INTO `user` VALUES (8, '20914d938f4041a9bb71ab7b409fb5af', 'liting3', 'liting3', 'liting3@univer.ai', '15748523658', '$2a$04$Gnr.kaGFtd5Co66UJG.2WeuittbJVD37zhjGdI1min4vJLWh4wZBK', NULL, NULL, NULL, 0, 1, 1, 3, 'enabled', '2018-12-06 19:09:15', '2018-12-10 13:45:15');
INSERT INTO `user` VALUES (9, '41abbc9519924c4d9d2edd009403aafe', 'yini4', 'yini4', 'yini4@163.com', '18600000004', '$2a$04$swyQKtgRovKjuz7SbJmUuuORPZPtr8GTYpakASXZoDZekifJJAepe', NULL, NULL, NULL, 0, 1, 1, 2, 'enabled', '2018-12-06 19:09:42', '2018-12-06 19:09:42');
INSERT INTO `user` VALUES (10, '2b979aca4e5f4d78a49ae39a2b023cac', 'liting4', 'liting1', 'liting4@univer.ai', '18547256931', '$2a$04$ayfmSwv/VP0ay3h0FB.Ju.conD3ucSJ64xKGNdjZWFnvwXGKVLvc2', NULL, NULL, NULL, 0, 1, 1, 3, 'enabled', '2018-12-06 19:09:49', '2018-12-06 19:09:49');
INSERT INTO `user` VALUES (11, 'e16726c78dc245b58b1db48a8d0b7f86', 'liting5', 'liting5', 'liting5@univer.ai', '15247859632', '$2a$04$KD8amHJfi2M4RH1Z.SmPpu7Gi2wUzsBgR763tGnW1Cgydg2TqWuaq', NULL, NULL, NULL, 0, 1, 1, 3, 'enabled', '2018-12-06 19:10:18', '2018-12-06 19:10:18');
INSERT INTO `user` VALUES (12, 'a556ec1036004a2cbe6f6e57f90d05b6', 'yini5', 'yini5', 'yini5@163.com', '18600000005', '$2a$04$EB.BNmg7hOoqM5mOeqtGsOVli194zVGATpT6un.OMbdTb8oh4Uinm', NULL, NULL, NULL, 0, 1, 1, 2, 'enabled', '2018-12-06 19:10:18', '2018-12-06 19:10:18');
INSERT INTO `user` VALUES (13, 'eb814609e3f34c069c3b529c29967fbc', 'liting6', 'liting6', 'liting6@univer.ai', '15241854722', '$2a$04$b8Xa15ZoRI.QtdaAOaZzve.Wu79ZHWqxe73TSY3BiCdGWjldunooG', NULL, NULL, NULL, 0, 1, 1, 3, 'enabled', '2018-12-06 19:10:55', '2018-12-07 18:26:30');
INSERT INTO `user` VALUES (1112, 'd7e4523b6a0847daa3482bbcb7c38500', 'liuweitao', 'liuweitao', 'weitao@163.com', '18600000008', '$2a$04$jF92VbS6KIWGSaoOnKyy7eovuBoFzN5b245hZowxg9sX9U2YZaT36', NULL, NULL, NULL, 0, 1, 1, 2, 'enabled', '2018-12-07 10:55:26', '2018-12-10 12:49:18');
INSERT INTO `user` VALUES (1113, '0f853fc08a5b415e91553954a4078d70', 'yuxi', 'yixi', 'yuxi@163.com', '18600000011', '$2a$04$MrE1r./SCl3gV.GGB9NByOheXbcWXloYT.FfMZSTzMmgujxeZoUQq', NULL, NULL, NULL, 0, 1, 1, 1112, 'enabled', '2018-12-07 10:56:45', '2018-12-07 11:41:12');
INSERT INTO `user` VALUES (1114, '71f34bad241e44d4af60a7d2c5fc68cd', 'zhenlong', 'zhenlong', 'zhenlong@163.com', '18600000022', '$2a$04$n7VFgWp.mfS.lOpQiuDF6uxxTNywdwdidTmji6wIukk/MaGwrBeSe', NULL, NULL, NULL, 0, 1, 1, 1112, 'enabled', '2018-12-07 10:57:20', '2018-12-11 14:21:02');
INSERT INTO `user` VALUES (1115, 'f8e6eea7f98140cabfbd8a68fc6eb3a5', 'leon', 'leon', '527238779@qq.com', '18900000000', '$2a$04$bAFJjam2YS7J0nM3X.qGsOLs22xI9NNKe4NyJMwoJgyogjk1Vl4ey', NULL, NULL, '', 0, 1, 2, 1114, 'enabled', '2018-12-07 11:23:15', '2018-12-07 11:54:38');
INSERT INTO `user` VALUES (1116, 'f895325b3f0c4f1c85572d5dee742de0', 'yuxi2', '雨熙测试2', 'liufeifeng@univer.ai', '18600008888', '$2a$04$NgwvZMhdtXa5yD4miR8Pmu3b0nwfmLg5IMKPhWQg0K9sod2HH/.kG', NULL, NULL, NULL, 0, 1, 3, 1113, 'enabled', '2018-12-07 11:24:23', '2018-12-07 11:58:42');
INSERT INTO `user` VALUES (1117, '854e923a7bf8424dad37ca191bacdaf8', 'yuxi3', '雨熙测试3', 'yuxi3@univer.ai', '18600001111', '$2a$04$bp9uXB13ELevuTQQuSSZxO.OpyzdBQr8R/.JHsGzdgKm5cAr1JdKW', NULL, NULL, NULL, 0, 1, 2, 1113, 'enabled', '2018-12-07 11:27:25', '2018-12-07 11:27:25');
INSERT INTO `user` VALUES (1118, '133985308c23459b88841ffe3c27ebf4', 'leon1', 'leon1', '527238771@qq.com', '18900000001', '$2a$04$.IyqtD1Dim92LgYFCIWJeeHoDmdUi/exVmNKneTRaPyic3KsVaqzK', NULL, NULL, '112233344555', 0, 1, 2, 1114, 'enabled', '2018-12-07 11:32:46', '2018-12-07 11:55:44');
INSERT INTO `user` VALUES (1119, 'c9165ccf1b52494f816918541076308b', 'leon2', 'leon2', '527238772@qq.com', '18900000002', '$2a$04$huyGqJD.nN/ffN4Tn9lc5.lBp1lchsLYoRwVMJkmevbbcA84ugKBW', NULL, NULL, '', 0, 1, 1, 1114, 'enabled', '2018-12-07 11:36:41', '2018-12-07 14:17:11');
INSERT INTO `user` VALUES (1120, 'a4a495150ab642f890ac748f849bcd36', 'leon3', 'leon3', '527238773@qq.com', '18900000003', '$2a$04$T1jNrxhPfh2gyf49ozhlfulKsnRCRkyqc7b0zAhRT.q9Jbgo.1QR6', NULL, NULL, '222233344444', 1, 1, 1, 1114, 'enabled', '2018-12-07 11:46:30', '2018-12-07 14:18:01');

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
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, 'enabled', '2018-12-06 18:54:53', '2018-12-06 18:54:53');
INSERT INTO `user_role` VALUES (2, 2, 1, 'enabled', '2018-12-06 19:06:33', '2018-12-06 19:06:33');
INSERT INTO `user_role` VALUES (3, 3, 1, 'enabled', '2018-12-06 19:07:04', '2018-12-06 19:07:04');
INSERT INTO `user_role` VALUES (4, 4, 3, 'enabled', '2018-12-06 19:08:12', '2018-12-06 19:08:12');
INSERT INTO `user_role` VALUES (6, 6, 3, 'enabled', '2018-12-06 19:08:43', '2018-12-06 19:08:43');
INSERT INTO `user_role` VALUES (7, 7, 3, 'enabled', '2018-12-06 19:09:07', '2018-12-06 19:09:07');
INSERT INTO `user_role` VALUES (8, 8, 3, 'enabled', '2018-12-06 19:09:15', '2018-12-06 19:09:15');
INSERT INTO `user_role` VALUES (9, 9, 3, 'enabled', '2018-12-06 19:09:42', '2018-12-06 19:09:42');
INSERT INTO `user_role` VALUES (10, 10, 3, 'enabled', '2018-12-06 19:09:49', '2018-12-06 19:09:49');
INSERT INTO `user_role` VALUES (11, 11, 3, 'enabled', '2018-12-06 19:10:18', '2018-12-06 19:10:18');
INSERT INTO `user_role` VALUES (12, 12, 3, 'enabled', '2018-12-06 19:10:18', '2018-12-06 19:10:18');
INSERT INTO `user_role` VALUES (14, 5, 3, 'enabled', '2018-12-07 10:43:51', '2018-12-07 10:43:51');
INSERT INTO `user_role` VALUES (15, 1112, 1, 'enabled', '2018-12-07 10:55:26', '2018-12-07 10:55:26');
INSERT INTO `user_role` VALUES (16, 1113, 1, 'enabled', '2018-12-07 10:56:45', '2018-12-07 10:56:45');
INSERT INTO `user_role` VALUES (17, 1114, 1, 'enabled', '2018-12-07 10:57:20', '2018-12-07 10:57:20');
INSERT INTO `user_role` VALUES (18, 1115, 3, 'enabled', '2018-12-07 11:23:15', '2018-12-07 11:23:15');
INSERT INTO `user_role` VALUES (19, 1116, 3, 'enabled', '2018-12-07 11:24:23', '2018-12-07 11:24:23');
INSERT INTO `user_role` VALUES (22, 1119, 3, 'enabled', '2018-12-07 11:36:41', '2018-12-07 11:36:41');
INSERT INTO `user_role` VALUES (23, 1117, 3, 'enabled', '2018-12-07 11:43:53', '2018-12-07 11:43:53');
INSERT INTO `user_role` VALUES (26, 1120, 3, 'enabled', '2018-12-07 11:49:43', '2018-12-07 11:49:43');
INSERT INTO `user_role` VALUES (27, 1118, 3, 'enabled', '2018-12-07 11:49:51', '2018-12-07 11:49:51');
INSERT INTO `user_role` VALUES (31, 13, 2, 'enabled', '2018-12-07 19:00:01', '2018-12-07 19:00:01');

SET FOREIGN_KEY_CHECKS = 1;
