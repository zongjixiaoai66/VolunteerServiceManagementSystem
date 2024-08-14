/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb3 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `t346`;
CREATE DATABASE IF NOT EXISTS `t346` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `t346`;

DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='配置文件';

DELETE FROM `config`;
INSERT INTO `config` (`id`, `name`, `value`) VALUES
	(1, '轮播图1', 'upload/config1.jpg'),
	(2, '轮播图2', 'upload/config2.jpg'),
	(3, '轮播图3', 'upload/config3.jpg');

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE IF NOT EXISTS `dictionary` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 COMMENT='字典';

DELETE FROM `dictionary`;
INSERT INTO `dictionary` (`id`, `dic_code`, `dic_name`, `code_index`, `index_name`, `super_id`, `beizhu`, `create_time`) VALUES
	(1, 'huodong_types', '活动类型', 1, '活动类型1', NULL, NULL, '2023-04-27 06:29:46'),
	(2, 'huodong_types', '活动类型', 2, '活动类型2', NULL, NULL, '2023-04-27 06:29:46'),
	(3, 'huodong_types', '活动类型', 3, '活动类型3', NULL, NULL, '2023-04-27 06:29:46'),
	(4, 'status_types', '活动状态', 1, '未开始', NULL, NULL, '2023-04-27 06:29:46'),
	(5, 'status_types', '活动状态', 2, '已结束', NULL, NULL, '2023-04-27 06:29:46'),
	(6, 'huodong_collection_types', '收藏表类型', 1, '收藏', NULL, NULL, '2023-04-27 06:29:46'),
	(7, 'huodong_collection_types', '收藏表类型', 2, '赞', NULL, NULL, '2023-04-27 06:29:47'),
	(8, 'huodong_collection_types', '收藏表类型', 3, '踩', NULL, NULL, '2023-04-27 06:29:47'),
	(9, 'huodong_yuyue_yesno_types', '报名状态', 1, '待审核', NULL, NULL, '2023-04-27 06:29:47'),
	(10, 'huodong_yuyue_yesno_types', '报名状态', 2, '同意', NULL, NULL, '2023-04-27 06:29:47'),
	(11, 'huodong_yuyue_yesno_types', '报名状态', 3, '拒绝', NULL, NULL, '2023-04-27 06:29:47'),
	(12, 'ziyuan_types', '资源类型', 1, '资源类型1', NULL, NULL, '2023-04-27 06:29:47'),
	(13, 'ziyuan_types', '资源类型', 2, '资源类型2', NULL, NULL, '2023-04-27 06:29:47'),
	(14, 'ziyuan_types', '资源类型', 3, '资源类型3', NULL, NULL, '2023-04-27 06:29:47'),
	(15, 'ziyuan_collection_types', '收藏表类型', 1, '收藏', NULL, NULL, '2023-04-27 06:29:47'),
	(16, 'ziyuan_collection_types', '收藏表类型', 2, '赞', NULL, NULL, '2023-04-27 06:29:47'),
	(17, 'ziyuan_collection_types', '收藏表类型', 3, '踩', NULL, NULL, '2023-04-27 06:29:47'),
	(18, 'junazheng_types', '捐赠类型', 1, '捐赠公示', NULL, NULL, '2023-04-27 06:29:47'),
	(19, 'junazheng_types', '捐赠类型', 2, '求助贴', NULL, NULL, '2023-04-27 06:29:47'),
	(20, 'junazheng_types', '捐赠类型', 3, '其他1', NULL, NULL, '2023-04-27 06:29:47'),
	(21, 'junazheng_yesno_types', '报名状态', 1, '待审核', NULL, NULL, '2023-04-27 06:29:47'),
	(22, 'junazheng_yesno_types', '报名状态', 2, '同意', NULL, NULL, '2023-04-27 06:29:47'),
	(23, 'junazheng_yesno_types', '报名状态', 3, '拒绝', NULL, NULL, '2023-04-27 06:29:47'),
	(24, 'news_types', '公告类型', 1, '公告类型1', NULL, NULL, '2023-04-27 06:29:47'),
	(25, 'news_types', '公告类型', 2, '公告类型2', NULL, NULL, '2023-04-27 06:29:47'),
	(26, 'news_types', '公告类型', 3, '公告类型3', NULL, NULL, '2023-04-27 06:29:47'),
	(27, 'sex_types', '性别类型', 1, '男', NULL, NULL, '2023-04-27 06:29:47'),
	(28, 'sex_types', '性别类型', 2, '女', NULL, NULL, '2023-04-27 06:29:47'),
	(29, 'yonghu_types', '用户类型', 1, '个人', NULL, NULL, '2023-04-27 06:29:47'),
	(30, 'yonghu_types', '用户类型', 2, '团队', NULL, NULL, '2023-04-27 06:29:47'),
	(31, 'forum_state_types', '帖子状态', 1, '发帖', NULL, NULL, '2023-04-27 06:29:47'),
	(32, 'forum_state_types', '帖子状态', 2, '回帖', NULL, NULL, '2023-04-27 06:29:47');

DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `forum_name` varchar(200) DEFAULT NULL COMMENT '帖子标题  Search111 ',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `users_id` int DEFAULT NULL COMMENT '管理员',
  `forum_content` longtext COMMENT '发布内容',
  `super_ids` int DEFAULT NULL COMMENT '父id',
  `forum_state_types` int DEFAULT NULL COMMENT '帖子状态',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '发帖时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COMMENT='广场论坛';

DELETE FROM `forum`;
INSERT INTO `forum` (`id`, `forum_name`, `yonghu_id`, `users_id`, `forum_content`, `super_ids`, `forum_state_types`, `insert_time`, `update_time`, `create_time`) VALUES
	(1, '帖子标题1', 3, NULL, '发布内容1', 363, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(2, '帖子标题2', 2, NULL, '发布内容2', 44, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(3, '帖子标题3', 3, NULL, '发布内容3', 163, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(4, '帖子标题4', 3, NULL, '发布内容4', 62, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(5, '帖子标题5', 1, NULL, '发布内容5', 284, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(6, '帖子标题6', 1, NULL, '发布内容6', 367, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(7, '帖子标题7', 3, NULL, '发布内容7', 177, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(8, '帖子标题8', 1, NULL, '发布内容8', 30, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(9, '帖子标题9', 3, NULL, '发布内容9', 10, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(10, '帖子标题10', 1, NULL, '发布内容10', 360, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(11, '帖子标题11', 2, NULL, '发布内容11', 19, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(12, '帖子标题12', 1, NULL, '发布内容12', 255, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(13, '帖子标题13', 3, NULL, '发布内容13', 353, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(14, '帖子标题14', 3, NULL, '发布内容14', 214, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(15, NULL, 1, NULL, '1111111111111111111111', 14, 2, '2023-04-27 07:07:28', NULL, '2023-04-27 07:07:28'),
	(18, NULL, NULL, 1, '2222222222222222222', 14, 2, '2023-04-27 07:08:05', NULL, '2023-04-27 07:08:05'),
	(19, NULL, 1, NULL, '111', 12, 2, '2024-08-04 05:40:32', NULL, '2024-08-04 05:40:32');

DROP TABLE IF EXISTS `huodong`;
CREATE TABLE IF NOT EXISTS `huodong` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `huodong_uuid_number` varchar(200) DEFAULT NULL COMMENT '活动编号',
  `huodong_name` varchar(200) DEFAULT NULL COMMENT '活动名称  Search111 ',
  `huodong_photo` varchar(200) DEFAULT NULL COMMENT '活动照片',
  `huodong_address` varchar(200) DEFAULT NULL COMMENT '活动地点',
  `huodong_shijian` varchar(200) DEFAULT NULL COMMENT '活动时间',
  `zan_number` int DEFAULT NULL COMMENT '赞',
  `cai_number` int DEFAULT NULL COMMENT '踩',
  `huodong_types` int DEFAULT NULL COMMENT '活动类型 Search111',
  `huodong_kucun_number` int DEFAULT NULL COMMENT '可报名人数',
  `huodong_clicknum` int DEFAULT NULL COMMENT '活动热度',
  `status_types` int DEFAULT NULL COMMENT '活动状态 Search111',
  `jiezhi_time` timestamp NULL DEFAULT NULL COMMENT '报名截止时间',
  `huodong_content` longtext COMMENT '活动介绍 ',
  `huodong_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow homeMain',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COMMENT='志愿活动';

DELETE FROM `huodong`;
INSERT INTO `huodong` (`id`, `huodong_uuid_number`, `huodong_name`, `huodong_photo`, `huodong_address`, `huodong_shijian`, `zan_number`, `cai_number`, `huodong_types`, `huodong_kucun_number`, `huodong_clicknum`, `status_types`, `jiezhi_time`, `huodong_content`, `huodong_delete`, `insert_time`, `create_time`) VALUES
	(1, '1682577011300', '活动名称1', 'upload/huodong1.jpg', '活动地点1', '活动时间1', 82, 417, 3, 101, 256, 2, '2023-04-27 06:30:11', '活动介绍1', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(2, '1682577011236', '活动名称2', 'upload/huodong2.jpg', '活动地点2', '活动时间2', 284, 105, 3, 102, 371, 2, '2023-04-27 06:30:11', '活动介绍2', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(3, '1682577011227', '活动名称3', 'upload/huodong3.jpg', '活动地点3', '活动时间3', 425, 79, 3, 103, 241, 2, '2023-04-27 06:30:11', '活动介绍3', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(4, '1682577011297', '活动名称4', 'upload/huodong4.jpg', '活动地点4', '活动时间4', 80, 450, 3, 104, 137, 2, '2023-04-27 06:30:11', '活动介绍4', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(5, '1682577011262', '活动名称5', 'upload/huodong5.jpg', '活动地点5', '活动时间5', 457, 34, 1, 105, 130, 2, '2023-04-27 06:30:11', '活动介绍5', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(6, '1682577011278', '活动名称6', 'upload/huodong6.jpg', '活动地点6', '活动时间6', 192, 486, 1, 106, 379, 1, '2023-04-27 06:30:11', '活动介绍6', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(7, '1682577011258', '活动名称7', 'upload/huodong7.jpg', '活动地点7', '活动时间7', 418, 147, 2, 107, 201, 1, '2023-04-27 06:30:11', '活动介绍7', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(8, '1682577011286', '活动名称8', 'upload/huodong8.jpg', '活动地点8', '活动时间8', 468, 205, 3, 108, 380, 2, '2023-04-27 06:30:11', '活动介绍8', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(9, '1682577011255', '活动名称9', 'upload/huodong9.jpg', '活动地点9', '活动时间9', 294, 84, 2, 109, 134, 1, '2023-04-27 06:30:11', '活动介绍9', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(10, '1682577011234', '活动名称10', 'upload/huodong10.jpg', '活动地点10', '活动时间10', 194, 179, 3, 1010, 79, 2, '2023-04-27 06:30:11', '活动介绍10', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(11, '1682577011238', '活动名称11', 'upload/huodong11.jpg', '活动地点11', '活动时间11', 348, 243, 1, 1011, 248, 2, '2023-04-27 06:30:11', '活动介绍11', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(12, '1682577011278', '活动名称12', 'upload/huodong12.jpg', '活动地点12', '活动时间12', 144, 11, 3, 1012, 249, 1, '2023-04-28 06:30:11', '活动介绍12', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(13, '1682577011224', '活动名称13', 'upload/huodong13.jpg', '活动地点13', '活动时间13', 484, 24, 2, 1013, 106, 1, '2023-04-28 06:30:11', '活动介绍13', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(14, '1682577011285', '活动名称14', 'upload/huodong14.jpg', '活动地点14', '活动时间14', 80, 423, 1, 1013, 362, 1, '2023-04-28 06:30:11', '<p>活动介绍14</p>', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11');

DROP TABLE IF EXISTS `huodong_collection`;
CREATE TABLE IF NOT EXISTS `huodong_collection` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `huodong_id` int DEFAULT NULL COMMENT '活动',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `huodong_collection_types` int DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COMMENT='活动收藏';

DELETE FROM `huodong_collection`;
INSERT INTO `huodong_collection` (`id`, `huodong_id`, `yonghu_id`, `huodong_collection_types`, `insert_time`, `create_time`) VALUES
	(1, 1, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(2, 2, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(3, 3, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(7, 7, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(8, 8, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(9, 9, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(10, 10, 3, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(11, 11, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(12, 12, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(13, 13, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(14, 14, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(15, 8, 1, 3, '2023-04-27 07:06:33', '2023-04-27 07:06:33'),
	(16, 14, 1, 2, '2023-04-27 07:06:40', '2023-04-27 07:06:40'),
	(17, 6, 1, 1, '2024-08-04 05:40:38', '2024-08-04 05:40:38');

DROP TABLE IF EXISTS `huodong_liuyan`;
CREATE TABLE IF NOT EXISTS `huodong_liuyan` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `huodong_id` int DEFAULT NULL COMMENT '活动',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `huodong_liuyan_text` longtext COMMENT '留言内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '留言时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COMMENT='活动留言';

DELETE FROM `huodong_liuyan`;
INSERT INTO `huodong_liuyan` (`id`, `huodong_id`, `yonghu_id`, `huodong_liuyan_text`, `insert_time`, `create_time`) VALUES
	(1, 1, 1, '留言内容1', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(2, 2, 3, '留言内容2', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(3, 3, 2, '留言内容3', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(4, 4, 1, '留言内容4', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(5, 5, 1, '留言内容5', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(6, 6, 1, '留言内容6', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(7, 7, 1, '留言内容7', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(8, 8, 3, '留言内容8', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(9, 9, 3, '留言内容9', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(10, 10, 1, '留言内容10', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(11, 11, 2, '留言内容11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(12, 12, 2, '留言内容12', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(13, 13, 3, '留言内容13', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(14, 14, 1, '留言内容14', '2023-04-27 06:30:11', '2023-04-27 06:30:11');

DROP TABLE IF EXISTS `huodong_yuyue`;
CREATE TABLE IF NOT EXISTS `huodong_yuyue` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `huodong_yuyue_uuid_number` varchar(200) DEFAULT NULL COMMENT '报名编号 Search111 ',
  `huodong_id` int DEFAULT NULL COMMENT '活动',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `huodong_yuyue_text` longtext COMMENT '报名理由',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '活动报名时间',
  `huodong_yuyue_yesno_types` int DEFAULT NULL COMMENT '报名状态 Search111 ',
  `huodong_yuyue_yesno_text` longtext COMMENT '审核回复',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='活动报名';

DELETE FROM `huodong_yuyue`;
INSERT INTO `huodong_yuyue` (`id`, `huodong_yuyue_uuid_number`, `huodong_id`, `yonghu_id`, `huodong_yuyue_text`, `insert_time`, `huodong_yuyue_yesno_types`, `huodong_yuyue_yesno_text`, `create_time`) VALUES
	(2, '1682577011291', 2, 3, '报名理由2', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(4, '1682577011249', 4, 3, '报名理由4', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(5, '1682577011272', 5, 2, '报名理由5', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(6, '1682577011226', 6, 3, '报名理由6', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(8, '1682577011315', 8, 2, '报名理由8', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(9, '1682577011320', 9, 2, '报名理由9', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(10, '1682577011243', 10, 3, '报名理由10', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(11, '1682577011239', 11, 2, '报名理由11', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(12, '1682577011247', 12, 2, '报名理由12', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(13, '1682577011245', 13, 2, '报名理由13', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(14, '1682577011321', 14, 2, '报名理由14', '2023-04-27 06:30:11', 3, '2', '2023-04-27 06:30:11'),
	(16, '1682579203193', 14, 1, '111111111111111', '2023-04-27 07:06:43', 2, '1', '2023-04-27 07:06:43');

DROP TABLE IF EXISTS `junazheng`;
CREATE TABLE IF NOT EXISTS `junazheng` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `junazheng_name` varchar(200) DEFAULT NULL COMMENT '标题  Search111 ',
  `junazheng_types` int DEFAULT NULL COMMENT '捐赠类型  Search111 ',
  `junazheng_file` varchar(200) DEFAULT NULL COMMENT '凭证 ',
  `junazheng_text` longtext COMMENT '详情内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '活动报名时间',
  `junazheng_yesno_types` int DEFAULT NULL COMMENT '报名状态 Search111 ',
  `junazheng_yesno_text` longtext COMMENT '审核回复',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='捐赠信息';

DELETE FROM `junazheng`;
INSERT INTO `junazheng` (`id`, `yonghu_id`, `junazheng_name`, `junazheng_types`, `junazheng_file`, `junazheng_text`, `insert_time`, `junazheng_yesno_types`, `junazheng_yesno_text`, `create_time`) VALUES
	(1, 1, '标题1', 2, 'upload/file.rar', '详情内容1', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(2, 2, '标题2', 3, 'upload/file.rar', '详情内容2', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(3, 2, '标题3', 1, 'upload/file.rar', '详情内容3', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(4, 1, '标题4', 3, 'upload/file.rar', '详情内容4', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(5, 3, '标题5', 1, 'upload/file.rar', '详情内容5', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(6, 3, '标题6', 1, 'upload/file.rar', '详情内容6', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(7, 1, '标题7', 2, 'upload/file.rar', '详情内容7', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(8, 3, '标题8', 2, 'upload/file.rar', '详情内容8', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(9, 2, '标题9', 2, 'upload/file.rar', '详情内容9', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(10, 3, '标题10', 1, 'upload/file.rar', '详情内容10', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(11, 2, '标题11', 3, 'upload/file.rar', '详情内容11', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(12, 2, '标题12', 2, 'upload/file.rar', '详情内容12', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(13, 2, '标题13', 2, 'upload/file.rar', '详情内容13', '2023-04-27 06:30:11', 1, NULL, '2023-04-27 06:30:11'),
	(14, 3, '标题14', 2, 'upload/file.rar', '详情内容14', '2023-04-27 06:30:11', 3, '2', '2023-04-27 06:30:11'),
	(15, 1, '123', 2, 'upload/1682579221673.doc', '12312', '2023-04-27 07:07:03', 2, '1', '2023-04-27 07:07:03');

DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `news_name` varchar(200) DEFAULT NULL COMMENT '公告标题  Search111 ',
  `news_types` int DEFAULT NULL COMMENT '公告类型  Search111 ',
  `news_photo` varchar(200) DEFAULT NULL COMMENT '公告图片',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `news_content` longtext COMMENT '公告详情',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show1 show2 nameShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COMMENT='公告通知';

DELETE FROM `news`;
INSERT INTO `news` (`id`, `news_name`, `news_types`, `news_photo`, `insert_time`, `news_content`, `create_time`) VALUES
	(1, '公告标题1', 1, 'upload/news1.jpg', '2023-04-27 06:30:11', '公告详情1', '2023-04-27 06:30:11'),
	(2, '公告标题2', 2, 'upload/news2.jpg', '2023-04-27 06:30:11', '公告详情2', '2023-04-27 06:30:11'),
	(3, '公告标题3', 2, 'upload/news3.jpg', '2023-04-27 06:30:11', '公告详情3', '2023-04-27 06:30:11'),
	(4, '公告标题4', 1, 'upload/news4.jpg', '2023-04-27 06:30:11', '公告详情4', '2023-04-27 06:30:11'),
	(5, '公告标题5', 1, 'upload/news5.jpg', '2023-04-27 06:30:11', '公告详情5', '2023-04-27 06:30:11'),
	(6, '公告标题6', 1, 'upload/news6.jpg', '2023-04-27 06:30:11', '公告详情6', '2023-04-27 06:30:11'),
	(7, '公告标题7', 1, 'upload/news7.jpg', '2023-04-27 06:30:11', '公告详情7', '2023-04-27 06:30:11'),
	(8, '公告标题8', 2, 'upload/news8.jpg', '2023-04-27 06:30:11', '公告详情8', '2023-04-27 06:30:11'),
	(9, '公告标题9', 3, 'upload/news9.jpg', '2023-04-27 06:30:11', '公告详情9', '2023-04-27 06:30:11'),
	(10, '公告标题10', 1, 'upload/news10.jpg', '2023-04-27 06:30:11', '公告详情10', '2023-04-27 06:30:11'),
	(11, '公告标题11', 2, 'upload/news11.jpg', '2023-04-27 06:30:11', '公告详情11', '2023-04-27 06:30:11'),
	(12, '公告标题12', 2, 'upload/news12.jpg', '2023-04-27 06:30:11', '公告详情12', '2023-04-27 06:30:11'),
	(13, '公告标题13', 1, 'upload/news13.jpg', '2023-04-27 06:30:11', '公告详情13', '2023-04-27 06:30:11'),
	(14, '公告标题14', 2, 'upload/news14.jpg', '2023-04-27 06:30:11', '公告详情14', '2023-04-27 06:30:11');

DROP TABLE IF EXISTS `token`;
CREATE TABLE IF NOT EXISTS `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '管理id',
  `username` varchar(100) NOT NULL COMMENT '管理名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='token表';

DELETE FROM `token`;
INSERT INTO `token` (`id`, `userid`, `username`, `tablename`, `role`, `token`, `addtime`, `expiratedtime`) VALUES
	(1, 1, 'a1', 'yonghu', '用户', 'btnlffx6owi1iswwuj4r3nryq2tyy3gv', '2023-04-27 06:34:15', '2024-08-04 06:40:22'),
	(2, 1, 'admin', 'users', '管理员', '8z0u0rb1mun15dnafiepio4n1at56pq0', '2023-04-27 06:49:45', '2024-08-04 06:39:03');

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '医院名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='管理员';

DELETE FROM `users`;
INSERT INTO `users` (`id`, `username`, `password`, `role`, `addtime`) VALUES
	(1, 'admin', '123456', '管理员', '2023-04-27 06:29:46');

DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE IF NOT EXISTS `yonghu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yonghu_name` varchar(200) DEFAULT NULL COMMENT '用户名称 Search111 ',
  `yonghu_phone` varchar(200) DEFAULT NULL COMMENT '用户手机号',
  `yonghu_id_number` varchar(200) DEFAULT NULL COMMENT '用户身份证号',
  `yonghu_photo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `sex_types` int DEFAULT NULL COMMENT '性别 Search111',
  `yonghu_email` varchar(200) DEFAULT NULL COMMENT '用户邮箱',
  `yonghu_types` int DEFAULT NULL COMMENT '用户类型 Search111',
  `yonghu_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='用户';

DELETE FROM `yonghu`;
INSERT INTO `yonghu` (`id`, `username`, `password`, `yonghu_name`, `yonghu_phone`, `yonghu_id_number`, `yonghu_photo`, `sex_types`, `yonghu_email`, `yonghu_types`, `yonghu_delete`, `insert_time`, `create_time`) VALUES
	(1, '用户1', '123456', '用户名称1', '17703786901', '410224199010102001', 'upload/yonghu1.jpg', 1, '1@qq.com', 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(2, '用户2', '123456', '用户名称2', '17703786902', '410224199010102002', 'upload/yonghu2.jpg', 2, '2@qq.com', 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(3, '用户3', '123456', '用户名称3', '17703786903', '410224199010102003', 'upload/yonghu3.jpg', 1, '3@qq.com', 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11');

DROP TABLE IF EXISTS `ziyuan`;
CREATE TABLE IF NOT EXISTS `ziyuan` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `ziyuan_uuid_number` varchar(200) DEFAULT NULL COMMENT '资源编号',
  `ziyuan_name` varchar(200) DEFAULT NULL COMMENT '资源名称  Search111 ',
  `ziyuan_photo` varchar(200) DEFAULT NULL COMMENT '资源照片',
  `zan_number` int DEFAULT NULL COMMENT '赞',
  `cai_number` int DEFAULT NULL COMMENT '踩',
  `ziyuan_types` int DEFAULT NULL COMMENT '资源类型 Search111',
  `ziyuan_content` longtext COMMENT '资源介绍 ',
  `ziyuan_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COMMENT='志愿资源';

DELETE FROM `ziyuan`;
INSERT INTO `ziyuan` (`id`, `ziyuan_uuid_number`, `ziyuan_name`, `ziyuan_photo`, `zan_number`, `cai_number`, `ziyuan_types`, `ziyuan_content`, `ziyuan_delete`, `insert_time`, `create_time`) VALUES
	(1, '1682577011267', '资源名称1', 'upload/ziyuan1.jpg', 38, 100, 2, '资源介绍1', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(2, '1682577011261', '资源名称2', 'upload/ziyuan2.jpg', 317, 303, 3, '资源介绍2', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(3, '1682577011273', '资源名称3', 'upload/ziyuan3.jpg', 187, 298, 2, '资源介绍3', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(4, '1682577011253', '资源名称4', 'upload/ziyuan4.jpg', 251, 379, 1, '资源介绍4', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(5, '1682577011311', '资源名称5', 'upload/ziyuan5.jpg', 121, 184, 2, '资源介绍5', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(6, '1682577011257', '资源名称6', 'upload/ziyuan6.jpg', 84, 304, 1, '资源介绍6', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(7, '1682577011280', '资源名称7', 'upload/ziyuan7.jpg', 352, 82, 3, '资源介绍7', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(8, '1682577011312', '资源名称8', 'upload/ziyuan8.jpg', 110, 367, 1, '资源介绍8', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(9, '1682577011241', '资源名称9', 'upload/ziyuan9.jpg', 43, 20, 2, '资源介绍9', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(10, '1682577011314', '资源名称10', 'upload/ziyuan10.jpg', 78, 194, 1, '资源介绍10', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(11, '1682577011264', '资源名称11', 'upload/ziyuan11.jpg', 166, 415, 3, '资源介绍11', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(12, '1682577011294', '资源名称12', 'upload/ziyuan12.jpg', 159, 308, 1, '资源介绍12', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(13, '1682577011335', '资源名称13', 'upload/ziyuan13.jpg', 246, 302, 1, '资源介绍13', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(14, '1682577011292', '资源名称14', 'upload/ziyuan14.jpg', 219, 313, 3, '资源介绍14', 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11');

DROP TABLE IF EXISTS `ziyuan_collection`;
CREATE TABLE IF NOT EXISTS `ziyuan_collection` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ziyuan_id` int DEFAULT NULL COMMENT '资源',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `ziyuan_collection_types` int DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COMMENT='资源收藏';

DELETE FROM `ziyuan_collection`;
INSERT INTO `ziyuan_collection` (`id`, `ziyuan_id`, `yonghu_id`, `ziyuan_collection_types`, `insert_time`, `create_time`) VALUES
	(1, 1, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(5, 5, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(6, 6, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(7, 7, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(8, 8, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(9, 9, 3, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(10, 10, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(11, 11, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(12, 12, 2, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(14, 14, 1, 1, '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(15, 13, 1, 2, '2023-04-27 06:39:59', '2023-04-27 06:39:59'),
	(16, 7, 1, 2, '2023-04-27 07:06:18', '2023-04-27 07:06:18'),
	(17, 7, 1, 1, '2023-04-27 07:06:20', '2023-04-27 07:06:20');

DROP TABLE IF EXISTS `ziyuan_liuyan`;
CREATE TABLE IF NOT EXISTS `ziyuan_liuyan` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ziyuan_id` int DEFAULT NULL COMMENT '资源',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `ziyuan_liuyan_text` longtext COMMENT '留言内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '留言时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='资源留言';

DELETE FROM `ziyuan_liuyan`;
INSERT INTO `ziyuan_liuyan` (`id`, `ziyuan_id`, `yonghu_id`, `ziyuan_liuyan_text`, `insert_time`, `create_time`) VALUES
	(1, 1, 2, '留言内容1', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(2, 2, 2, '留言内容2', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(3, 3, 1, '留言内容3', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(4, 4, 1, '留言内容4', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(5, 5, 2, '留言内容5', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(6, 6, 1, '留言内容6', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(7, 7, 3, '留言内容7', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(8, 8, 1, '留言内容8', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(9, 9, 2, '留言内容9', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(10, 10, 2, '留言内容10', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(11, 11, 2, '留言内容11', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(12, 12, 1, '留言内容12', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(13, 13, 1, '留言内容13', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(14, 14, 3, '留言内容14', '2023-04-27 06:30:11', '2023-04-27 06:30:11'),
	(15, 7, 1, '111111111111111111111', '2023-04-27 07:06:25', '2023-04-27 07:06:25'),
	(16, 13, 1, '1111', '2024-08-04 05:40:54', '2024-08-04 05:40:54');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
