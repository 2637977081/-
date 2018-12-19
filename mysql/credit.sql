CREATE TABLE `course` (
`course_id` bigint NOT NULL AUTO_INCREMENT,
`code` varchar(64) NOT NULL,
`name` varchar(64) NOT NULL,
`description` varchar(1024) NULL COMMENT '任务描述',
`type` varchar(16) NULL COMMENT '课程类型(required必修,elective选修)',
`university_id` bigint NULL COMMENT '限定大学id',
`university_name` varchar(64) NULL,
`faculty_id` bigint NULL COMMENT '限定的学院id',
`faculty_name` varchar(64) NULL,
`subject_id` bigint NULL COMMENT '限定系id',
`subject_name` varchar(64) NULL,
`status` varchar(16) NOT NULL DEFAULT enable COMMENT '是否禁用',
`create_id` bigint NULL COMMENT '创建者id',
`create_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
`update_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`course_id`) 
);

CREATE TABLE `lesson` (
`lesson_id` bigint NOT NULL AUTO_INCREMENT,
`code` varchar(64) NOT NULL,
`course_id` bigint NULL COMMENT '课程id',
`name` varchar(64) NOT NULL,
`description` varchar(1024) NULL COMMENT '任务描述',
`maxnum` int NOT NULL COMMENT '上限人数',
`num` int NULL COMMENT '已选人数',
`type` varchar(16) NULL DEFAULT nofull COMMENT '课程类型(full已满,surplus有余)',
`teacher_id` bigint NOT NULL COMMENT '授课老师id',
`teacher_name` varchar(64) NOT NULL COMMENT '授课老师姓名',
`behavior` int NULL COMMENT '表现分百分比，结果/100',
`test` int NULL COMMENT '实验分占百分比，结果/10',
`exam` int NULL COMMENT '考试结果百分比，结果/10',
`credit` int NOT NULL DEFAULT 0 COMMENT '学分，实际结果/10',
`teach_time` int(64) NOT NULL DEFAULT 0 COMMENT '授课时长',
`status` varchar(16) NOT NULL DEFAULT enable COMMENT '是否可用(enable,disable)',
`create_id` bigint NULL COMMENT '创建者id',
`create_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
`update_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`lesson_id`) 
);

CREATE TABLE `teach` (
`teach_id` bigint NOT NULL AUTO_INCREMENT,
`code` varchar(64) NOT NULL,
`lesson_id` bigint NOT NULL COMMENT '课程id',
`name` varchar(64) NOT NULL,
`description` varchar(1024) NULL COMMENT '学生描述',
`student_id` bigint NOT NULL COMMENT '学生id',
`student_name` varchar(64) NULL COMMENT '已选人数',
`type` varchar(16) NULL DEFAULT teaching COMMENT '学生授课状态(teaching授课中，teached授课结束，lose未参加)',
`behavior` int NULL COMMENT '表现分，结果/10',
`test` int NULL COMMENT '实验分，结果/10',
`exam` int NULL COMMENT '考试分，结果/10',
`score` int NULL COMMENT '最终成绩',
`credit` int NULL COMMENT '学分，结果/10',
`status` varchar(16) NOT NULL DEFAULT enable COMMENT '是否可用(enable,disable)',
`create_id` bigint NULL COMMENT '创建者id',
`create_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
`update_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`teach_id`) 
);

