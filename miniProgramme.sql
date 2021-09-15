/*
 Navicat MySQL Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : miniProgramme

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 15/09/2021 23:02:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for AdminInfo
-- ----------------------------
DROP TABLE IF EXISTS `AdminInfo`;
CREATE TABLE `AdminInfo` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '管理员账号唯一标识',
  `username` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '管理员密码',
  `createtime` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账号创建时间',
  `role_id` int NOT NULL COMMENT '账户对应的角色id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='后台管理员账号表';

-- ----------------------------
-- Records of AdminInfo
-- ----------------------------
BEGIN;
INSERT INTO `AdminInfo` VALUES (4, 'cy', '$2a$10$31UvZ17Rt0VwF9x7a611dOHwG1GXkpC6JGz6OtdN0VYIgFQ5757M.', '2021-02-07 16:26:12', 1);
INSERT INTO `AdminInfo` VALUES (5, 'xy', '$2a$10$KJ9LEr6VXFGDTYkLZX0X6O.d2Uc9CeHO9.2l7SH1A2QT.FdZhvUWK', '2021-02-09 09:24:26', 1);
INSERT INTO `AdminInfo` VALUES (7, 'user', '$2a$10$2Geb/Xt/RdJ0ZresiTNMb.37cXtOYt/MEIFsdxHUfMsIWnLQ3bR7.', '2021-02-09 22:47:47', 2);
COMMIT;

-- ----------------------------
-- Table structure for AllStudyCourse
-- ----------------------------
DROP TABLE IF EXISTS `AllStudyCourse`;
CREATE TABLE `AllStudyCourse` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '学习资料唯一标识',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学习资料标题',
  `courseImageUrlPath` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学习资料图片URl链接',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学习资料表述',
  `learnNum` int DEFAULT NULL COMMENT '学习资料点击次数',
  `uploadtime` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学习资料上传时间',
  `relatedTeacherID` int DEFAULT NULL COMMENT '学习资料相关教师ID',
  `courseState` int DEFAULT NULL COMMENT '开课状态',
  `videoUrlPath` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资料详细视频Url',
  `favorOrNot` int DEFAULT NULL COMMENT '是否收藏（作废）',
  `courseWeather` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '开课季节',
  `courseTimer` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '开课时间短段',
  `hotOrNot` int DEFAULT NULL COMMENT '是否为热门',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='所有的学习课程表内容表';

-- ----------------------------
-- Records of AllStudyCourse
-- ----------------------------
BEGIN;
INSERT INTO `AllStudyCourse` VALUES (1, '对话模型预训练策略', 'http://localhost:9999/upload/hot/hot1.png', '《运动与健康》全面地阐述体育运动与健康的关系、如何向体育运动要健康、\n                        不同运动项目的健康机制、运动损伤的预防与处理等基本内容。', 55, '2021-3-14', 1, 0, NULL, 0, NULL, NULL, 1);
INSERT INTO `AllStudyCourse` VALUES (2, '基于学习排序', 'http://localhost:9999/upload/hot/hot1.png', '基于学习排序的对话模型预训练策略', 55, '2021-3-14', 2, 1, NULL, 0, NULL, NULL, 1);
INSERT INTO `AllStudyCourse` VALUES (3, '基于学习排序的对话', 'http://localhost:9999/upload/allStudyCourse/pic/1615726612256.png', '基于学习排序的对话模型预训练策略', 99990, '2021-03-14 20:52', 3, 0, 'http://localhost:9999/upload/allStudyCourse/video/1615726612286.MOV', 0, NULL, NULL, 1);
INSERT INTO `AllStudyCourse` VALUES (4, '基于学习训练策略', 'http://localhost:9999/upload/allStudyCourse/pic/1615726894935.png', '《运动与健康》课程以人文社会科学的视野，将体育人文社会科学、运动人体科学和医学等相关学科有机地结合起来，系统、全面地阐述体育运动与健康的关系、如何向体育运动要健康、不同运动项目的健康机制、运动损伤的预防与处理等基本内容。《运动与健康》祝愿每一位同学掌握科学锻炼的方法，每天锻炼一小时，健康生活一辈子！\n      \n健康是人类发展永恒的主题，追求健康是人们共同的愿望，拥有健康是人人享有的权利，维护健康必须走科学的道路，增进健康应遵循自身的规律。《运动与健康》这门课程将带领大家为健康而运动。\n\n在这门课程里，你可以领悟到运动对机体的神奇影响；你可以寻找到科学健身的方法；你可以欣赏到精彩的运动视频；你还可以学会运动损伤的初步处理；你会在运动误区的解释中豁然开朗！', 10002, '2021-03-14 21:34', 4, 0, 'http://localhost:9999/upload/allStudyCourse/video/1615726894956.MOV', 0, '2021春', '2021-12-31 - 2022-01-31', 0);
INSERT INTO `AllStudyCourse` VALUES (5, '习近平总书记关于教育的重要论述研究', 'http://localhost:9999/upload/picture/1618936053100.png', '本慕课课程是依托《习近平总书记关于教育的重要论述研究》线下课程录制完成的。这门课程的内容主要由“导言+九讲”构成。“导言”主要阐述习近平总书记关于教育的重要论述的战略视野、内容体系和重大意义，目的是帮助同学们形成对总书记教育论述的整体性认识。“九讲”按照习近平总书记在全国教育大会上提出的“九个坚持”的逻辑顺序展开，分别回答了事关中国教育发展最为根本、最为关键、最为重要的九个方面的问题。         本课程于2020年秋季学期上线运行，2021年春季学期作为选择性必修课面向全校两校区共1200余名本科公费师范生开设线下课堂。在该课程学习过程中，学生对习近平总书记关于教育的重要论述的基本观点和内容体系有了比较全面的了解，对改革以来特别是党的十八大以来中国特色社会主义教育发展成就有了更为深刻的体悟，对进一步确立终身从教的职业理想有着较强的指导意义。学生在学习过程中普遍反映，课程内容逻辑衔接紧密、体系完整、语言通俗，有很强的思想性、逻辑性、生动性。', 100, NULL, 13, 1, 'http://localhost:9999/upload/picture/1618936056108.MP4', 0, '2021春', '2021-04-23', 0);
COMMIT;

-- ----------------------------
-- Table structure for BrosingHistory
-- ----------------------------
DROP TABLE IF EXISTS `BrosingHistory`;
CREATE TABLE `BrosingHistory` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '历史浏览唯一标识',
  `scanCourseID` int DEFAULT NULL COMMENT '历史浏览课程ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='历史浏览记录表';

-- ----------------------------
-- Table structure for CourseDetails
-- ----------------------------
DROP TABLE IF EXISTS `CourseDetails`;
CREATE TABLE `CourseDetails` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '资料详细唯一标识',
  `title` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资料详细标题',
  `videoUrlPath` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资料详细视频Url',
  `relatedTeacher` int DEFAULT NULL COMMENT '资料详细相关教师',
  `courseDescription` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资料详细描述',
  `updatetime` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资料详细更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='课程细节表';

-- ----------------------------
-- Table structure for Favorites
-- ----------------------------
DROP TABLE IF EXISTS `Favorites`;
CREATE TABLE `Favorites` (
  `ID` int NOT NULL COMMENT '数据唯一ID',
  `faverID` int NOT NULL COMMENT '收藏的资料ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='收藏资料表';

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES (1);
COMMIT;

-- ----------------------------
-- Table structure for HotContent
-- ----------------------------
DROP TABLE IF EXISTS `HotContent`;
CREATE TABLE `HotContent` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '热门内容唯一标识',
  `studyCourseID` int NOT NULL COMMENT '学习资料ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='热门内容汇总表';

-- ----------------------------
-- Records of HotContent
-- ----------------------------
BEGIN;
INSERT INTO `HotContent` VALUES (1, 1);
INSERT INTO `HotContent` VALUES (2, 2);
COMMIT;

-- ----------------------------
-- Table structure for HotTeacher
-- ----------------------------
DROP TABLE IF EXISTS `HotTeacher`;
CREATE TABLE `HotTeacher` (
  `ID` int NOT NULL COMMENT '数据唯一ID',
  `TeacherID` int NOT NULL COMMENT '所对应的教师的ID值\n',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='热门教师表';

-- ----------------------------
-- Table structure for MiniProDetails
-- ----------------------------
DROP TABLE IF EXISTS `MiniProDetails`;
CREATE TABLE `MiniProDetails` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '小程序细节唯一标识',
  `aboutDetails` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小程序关于我们描述细节',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='小程序内容描述表';

-- ----------------------------
-- Table structure for RoleInfo
-- ----------------------------
DROP TABLE IF EXISTS `RoleInfo`;
CREATE TABLE `RoleInfo` (
  `rid` int NOT NULL AUTO_INCREMENT COMMENT '角色唯一标识',
  `r_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  `r_description` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色表';

-- ----------------------------
-- Records of RoleInfo
-- ----------------------------
BEGIN;
INSERT INTO `RoleInfo` VALUES (1, 'admin', '管理员');
INSERT INTO `RoleInfo` VALUES (2, 'user', '普通');
COMMIT;

-- ----------------------------
-- Table structure for SwiperItems
-- ----------------------------
DROP TABLE IF EXISTS `SwiperItems`;
CREATE TABLE `SwiperItems` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '轮播图图片唯一标识',
  `imageName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '轮播图图片名称',
  `imageUrlPath` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '轮播图URl',
  `uploadtime` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片上传时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='轮播图内容表';

-- ----------------------------
-- Records of SwiperItems
-- ----------------------------
BEGIN;
INSERT INTO `SwiperItems` VALUES (12, '1615701391639.png', 'http://localhost:9999/upload/swiper/1615701391639.png', '2021-03-14 13:31');
INSERT INTO `SwiperItems` VALUES (13, '1615701398888.png', 'http://localhost:9999/upload/swiper/1615701398888.png', '2021-03-14 13:38');
INSERT INTO `SwiperItems` VALUES (14, '1615701403893.png', 'http://localhost:9999/upload/swiper/1615701403893.png', '2021-03-14 13:43');
INSERT INTO `SwiperItems` VALUES (15, '1615703161354.png', 'http://localhost:9999/upload/swiper/1615703161354.png', '2021-03-14 14:01');
INSERT INTO `SwiperItems` VALUES (16, '1615703214664.png', 'http://localhost:9999/upload/swiper/1615703214664.png', '2021-03-14 14:54');
INSERT INTO `SwiperItems` VALUES (24, '1618897855642.png', 'http://localhost:9999/upload/picture/1618897855642.png', '2021-04-20 13:50:56');
COMMIT;

-- ----------------------------
-- Table structure for TeacherDetails
-- ----------------------------
DROP TABLE IF EXISTS `TeacherDetails`;
CREATE TABLE `TeacherDetails` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '教师唯一标识',
  `teacherName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '教师名字',
  `teacherSchool` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '教师毕业学校以及专业职称',
  `teacherImageUrlPath` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '教师照片URl',
  `teacherDescription` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '教师简要描述',
  `uploadtime` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新或者上传时间',
  `hotOrNot` int DEFAULT NULL COMMENT '是否为热门',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='教师表';

-- ----------------------------
-- Records of TeacherDetails
-- ----------------------------
BEGIN;
INSERT INTO `TeacherDetails` VALUES (1, '杨静', '华东师范大学', 'http://localhost:9999/upload/teacher/1615728944655.png', '老师非常牛逼，讲课生动动听，脾气特别好', '2021-03-14 21:44', 1);
INSERT INTO `TeacherDetails` VALUES (2, '查宏远', '华东师范大学', 'http://localhost:9999/upload/teacher/1615776446005.png', '就是喜欢晚上喊人起来写论文，太过于严格', '2021-03-15 10:26', 1);
INSERT INTO `TeacherDetails` VALUES (3, '江镇然', '华东师范大学', 'http://localhost:9999/upload/teacher/1615776491404.png', '研究员，实力强硬', '2021-03-15 10:11', 1);
INSERT INTO `TeacherDetails` VALUES (4, '方爱莲', '华东师范大学', 'http://localhost:9999/upload/teacher/1615776538824.png', '为人和蔼可亲，搞计算机教育方向', '2021-03-15 10:58', 1);
INSERT INTO `TeacherDetails` VALUES (10, '贺梁', '华东师范大学', 'http://localhost:9999/upload/picture/1618827892468.png', '贺樑，博士，华东师范大学计算机科学与技术学院副院长、教授、博士生导师。', '2021-04-19 18:22', 0);
INSERT INTO `TeacherDetails` VALUES (12, '方发明', '华东师范大学', 'http://localhost:9999/upload/picture/1618879026851.png', '方发明，博士，华东师范大学计算机科学与技术学院视觉与机器智能研究所副所长、教授、博士生导师，上海市“晨光学者”。', '2021-04-20 08:12', 0);
INSERT INTO `TeacherDetails` VALUES (13, '段妍', '北京师范大学', 'http://localhost:9999/upload/picture/1618934798746.png', '段妍，北京师范大学法学博士。现任东北师范大学马克思主义学部副部长，教授、博士生导师。', '2021-04-21 00:07:05', 0);
COMMIT;

-- ----------------------------
-- Table structure for tp_users
-- ----------------------------
DROP TABLE IF EXISTS `tp_users`;
CREATE TABLE `tp_users` (
  `user_id` int NOT NULL,
  `address_id` int DEFAULT NULL,
  `birthday` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `city` int DEFAULT NULL,
  `code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `discount` decimal(19,2) DEFAULT NULL,
  `distribut_level` tinyint DEFAULT NULL,
  `distribut_money` decimal(19,2) DEFAULT NULL,
  `district` int DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email_validated` bit(1) DEFAULT NULL,
  `first_leader` int DEFAULT NULL,
  `frozen_money` decimal(19,2) DEFAULT NULL,
  `head_pic` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_distribut` bit(1) DEFAULT NULL,
  `is_lock` bit(1) DEFAULT NULL,
  `last_ip` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_login` int DEFAULT NULL,
  `level` bit(1) DEFAULT NULL,
  `message_mask` bit(1) DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mobile_validated` tinyint DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `oauth` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `openid` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pay_points` int DEFAULT NULL,
  `paypwd` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `promotion_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `province` int DEFAULT NULL,
  `push_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `qq` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `reg_time` int DEFAULT NULL,
  `second_leader` int DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL,
  `third_leader` int DEFAULT NULL,
  `token` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `total_amount` decimal(19,2) DEFAULT NULL,
  `underling_number` int DEFAULT NULL,
  `unionid` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_money` decimal(19,2) DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for UserInfo
-- ----------------------------
DROP TABLE IF EXISTS `UserInfo`;
CREATE TABLE `UserInfo` (
  `openID` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '微信用户唯一标识',
  `nickName` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户微信昵称',
  `gender` varchar(2) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户性别',
  `country` varchar(5) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户所在国家',
  `province` varchar(3) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户所在省份',
  `city` varchar(3) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户所在城市',
  `imageUrlPath` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户头像URl',
  `createtime` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户第一次授权登陆的时间',
  `favor` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收藏的ID编号',
  `history` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览历史的ID编号',
  `historyState` varchar(4) COLLATE utf8mb4_general_ci DEFAULT '1',
  PRIMARY KEY (`openID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微信用户表';

-- ----------------------------
-- Records of UserInfo
-- ----------------------------
BEGIN;
INSERT INTO `UserInfo` VALUES ('117', '名字', '男', '美国', '洛杉矶', '泰兴', '。。。', '2021-02-03 21:52:54', NULL, NULL, '1');
INSERT INTO `UserInfo` VALUES ('oBTZP5f-hzqltA4eCVV-40aBQp9A', '微信用户', '0', '', '', '', 'https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132', '2021-04-21 19:32', '1', '1,2,5,4', '1');
COMMIT;

-- ----------------------------
-- View structure for v_all_list
-- ----------------------------
DROP VIEW IF EXISTS `v_all_list`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_all_list` AS select `allstudycourse`.`ID` AS `ID`,`allstudycourse`.`title` AS `title`,`allstudycourse`.`courseImageUrlPath` AS `courseImageUrlPath`,`allstudycourse`.`description` AS `description`,`allstudycourse`.`learnNum` AS `learnNum`,`teacherdetails`.`teacherSchool` AS `teacherSchool`,`allstudycourse`.`courseState` AS `courseState` from (`allstudycourse` left join `teacherdetails` on((`allstudycourse`.`relatedTeacherID` = `teacherdetails`.`ID`)));

-- ----------------------------
-- View structure for v_hot_content
-- ----------------------------
DROP VIEW IF EXISTS `v_hot_content`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_hot_content` AS select `allstudycourse`.`ID` AS `ID`,`allstudycourse`.`title` AS `title`,`allstudycourse`.`courseImageUrlPath` AS `courseImageUrlPath`,`allstudycourse`.`description` AS `description` from `allstudycourse` where (`allstudycourse`.`hotOrNot` = '1');

-- ----------------------------
-- View structure for v_hot_teacher
-- ----------------------------
DROP VIEW IF EXISTS `v_hot_teacher`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_hot_teacher` AS select `teacherdetails`.`ID` AS `ID`,`teacherdetails`.`teacherName` AS `teacherName`,`teacherdetails`.`teacherSchool` AS `teacherSchool`,`teacherdetails`.`teacherImageUrlPath` AS `teacherImageUrlPath` from `teacherdetails` where (`teacherdetails`.`hotOrNot` = 1);

-- ----------------------------
-- Procedure structure for addUser
-- ----------------------------
DROP PROCEDURE IF EXISTS `addUser`;
delimiter ;;
CREATE PROCEDURE `miniProgramme`.`addUser`(IN openid VARCHAR(30),
												 IN nickName VARCHAR(15),
												 IN gender varchar(2),
												 IN country VARCHAR(5),
												 IN province VARCHAR(3),
												 IN city VARCHAR(3),
												 IN imageUrlPath VARCHAR(30),
												 OUT resultCode INTEGER)
BEGIN
			DECLARE result_code INTEGER DEFAULT 0; -- 定义返回结果并赋初值0
			DECLARE result_info VARCHAR(5);
			DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET result_code=1; -- 在执行过程中出任何异常设置result_code为1

			START TRANSACTION;
			
				INSERT INTO UserInfo(openID,nickName,gender,country,province,city,imageUrlPath) 
				values(openid,nickName,gender,country,province,city,imageUrlPath);
				SET result_info = '插入成功';
				
				IF result_code = 1 THEN -- 可以根据不同的业务逻辑错误返回不同的result_code，这里只定义了1和0
				SET result_info = '插入失败';
        ROLLBACK; 
				ELSE 
						COMMIT; 
				END IF;
		SET resultCode = result_code;
		select resultCode;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table AdminInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `inse_time`;
delimiter ;;
CREATE TRIGGER `inse_time` BEFORE INSERT ON `AdminInfo` FOR EACH ROW BEGIN
			SET NEW.createtime = DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%s');
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table UserInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `addTime`;
delimiter ;;
CREATE TRIGGER `addTime` BEFORE INSERT ON `UserInfo` FOR EACH ROW BEGIN
		SET NEW.createtime = DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%s');
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
