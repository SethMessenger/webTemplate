
CREATE DATABASE /*!32312 IF NOT EXISTS*/`racing_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `racing_db`;

/*
用户信息管理表
*********************************************************************
*/
CREATE TABLE `r_user` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `user_name` varchar(16) NOT NULL DEFAULT '' COMMENT '用户名',
  `user_nickname` varchar(16) DEFAULT NULL COMMENT '用户昵称',
  `mobile` varchar(16) NOT NULL DEFAULT '' COMMENT '用户绑定手机号',
  `wechat` varchar(16) DEFAULT NULL COMMENT '用户微信',
  `email` varchar(50) DEFAULT NULL COMMENT '用户电子邮件地址',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '用户密码MD5',
  `open_id` varchar(16) DEFAULT NULL COMMENT '用户关注微信后的openid，由微信生成',
  `other` varchar(50) DEFAULT NULL COMMENT '冗余字段',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `r_user_coin` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `user_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户uuid',
  `total` bigint(16) DEFAULT NULL COMMENT '用户总余额',
  `user_nickname` varchar(16) NOT NULL DEFAULT '' COMMENT '用户昵称冗余',
  `user_mobile` varchar(16) DEFAULT NULL COMMENT '用户手机号冗余',
  `user_openid` varchar(50) DEFAULT NULL COMMENT '用户关注微信后的openid，由微信生成,冗余',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `r_user_coin_log` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `user_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户uuid',
  `user_coin_uuid` varchar(32) DEFAULT NULL COMMENT '用户账户uuid',
  `log_type` int(2) DEFAULT 0 COMMENT '账户入账类型，0金币出账，1金币入账 2人民币入账 3人民币出账（不允许）',
  `coin_amount` bigint(10) NOT NULL DEFAULT 0 COMMENT '入账金额',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


/*
自定义比赛类型
*********************************************************************
*/
CREATE TABLE `r_match_type` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `match_name` varchar(32) NOT NULL DEFAULT '' COMMENT '自定义比赛名称',
  `match_type` int(5) DEFAULT NULL COMMENT '自定义比赛类型，自增',
  `muti_amount` double(4,2) NOT NULL DEFAULT 0 COMMENT '比赛倍率',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `r_match_info` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `match_type` int(5) NOT NULL DEFAULT 0 COMMENT '比赛类型',
  `match_player_amount` int(5) DEFAULT NULL COMMENT '共有多少赛车参加比赛',
  `muti_amount` double(4,2) NOT NULL DEFAULT 0 COMMENT '比赛倍率',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `r_match_result` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `match_type` int(5) NOT NULL DEFAULT 0 COMMENT '比赛类型',
  `match_status` int(5) NOT NULL DEFAULT 0 COMMENT '赛果状态 0新建，接收投注 1封板，停止下注',
  `match_result` varchar(200) DEFAULT NULL COMMENT '比赛最终结果，json展示',
  `muti_amount` double(4,2) NOT NULL DEFAULT 0 COMMENT '比赛倍率',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `r_match_log` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `match_result_uuid` varchar(32) NOT NULL COMMENT '赛果uuid',
  `user_uuid` varchar(32) NOT NULL COMMENT '押注人uuid',
  `coin_index` int(2) NOT NULL COMMENT '押注号码',
  `log_type` int(2) DEFAULT 0 COMMENT '账户入账类型，0押注金币, 1系统发奖金币',
  `coin_amount` bigint(5) NOT NULL DEFAULT 0 COMMENT '押注金额',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



/** 分界线，将原有系统和racing进行分割 */
DROP TABLE IF EXISTS `t_wxcms_account`;

CREATE TABLE `t_wxcms_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `account` varchar(100) NOT NULL,
  `appid` varchar(100) DEFAULT NULL,
  `appsecret` varchar(100) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `msgCount` int(11) DEFAULT '1',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_wxcms_account_fans`;

CREATE TABLE `t_wxcms_account_fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(100) DEFAULT NULL,
  `subscribeStatus` int(1) DEFAULT '1',
  `subscribeTime` varchar(50) DEFAULT NULL,
  `nickname` varbinary(50) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT '1',
  `language` varchar(50) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  `remark` varchar(50) DEFAULT NULL,
  `wxid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_account_fans` */

/*Table structure for table `t_wxcms_account_menu` */

DROP TABLE IF EXISTS `t_wxcms_account_menu`;

CREATE TABLE `t_wxcms_account_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mtype` varchar(50) DEFAULT NULL,
  `eventType` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `inputCode` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `msgId` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_account_menu` */

/*Table structure for table `t_wxcms_account_menu_group` */

DROP TABLE IF EXISTS `t_wxcms_account_menu_group`;

CREATE TABLE `t_wxcms_account_menu_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_account_menu_group` */

/*Table structure for table `t_wxcms_article` */

DROP TABLE IF EXISTS `t_wxcms_article`;

CREATE TABLE `t_wxcms_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `digest` varchar(100) DEFAULT NULL,
  `show_cover_pic` int(1) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `thumb_media_id` varchar(150) DEFAULT NULL,
  `content_source_url` varchar(200) DEFAULT NULL,
  `media_id` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_article` */

/*Table structure for table `t_wxcms_img_resource` */

DROP TABLE IF EXISTS `t_wxcms_img_resource`;

CREATE TABLE `t_wxcms_img_resource` (
  `id` varchar(32) NOT NULL,
  `mediaId` varchar(100) DEFAULT NULL,
  `trueName` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `url` varchar(200) NOT NULL,
  `httpUrl` varchar(200) DEFAULT NULL,
  `size` int(9) NOT NULL,
  `createTime` mediumtext NOT NULL,
  `updateTime` mediumtext NOT NULL,
  `flag` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_img_resource` */

/*Table structure for table `t_wxcms_media_files` */

DROP TABLE IF EXISTS `t_wxcms_media_files`;

CREATE TABLE `t_wxcms_media_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mediaType` varchar(20) DEFAULT NULL COMMENT '媒体类型',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `introduction` varchar(500) DEFAULT NULL COMMENT '简介说明',
  `logicClass` varchar(50) DEFAULT NULL COMMENT '标签_逻辑分类',
  `media_id` varchar(100) DEFAULT NULL COMMENT '返回的media_id',
  `uploadUrl` varchar(200) DEFAULT NULL COMMENT '返回的wx服务器url',
  `rmk` varchar(500) DEFAULT NULL COMMENT '备注_预留',
  `createTime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `updateTime` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_media_files` */

/*Table structure for table `t_wxcms_msg_base` */

DROP TABLE IF EXISTS `t_wxcms_msg_base`;

CREATE TABLE `t_wxcms_msg_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msgType` varchar(20) DEFAULT NULL,
  `inputCode` varchar(20) DEFAULT NULL,
  `rule` varchar(20) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `readCount` int(11) DEFAULT '0',
  `favourCount` int(11) unsigned zerofill DEFAULT '00000000000',
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_msg_base` */

/*Table structure for table `t_wxcms_msg_news` */

DROP TABLE IF EXISTS `t_wxcms_msg_news`;

CREATE TABLE `t_wxcms_msg_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `multType` varchar(5) DEFAULT NULL COMMENT '单图文多图文类型',
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `brief` varchar(255) DEFAULT NULL,
  `description` longtext,
  `picPath` varchar(255) DEFAULT NULL,
  `showPic` int(11) DEFAULT '0',
  `url` varchar(255) DEFAULT NULL,
  `fromurl` varchar(255) DEFAULT NULL,
  `base_id` int(11) DEFAULT NULL,
  `media_id` varchar(100) DEFAULT NULL COMMENT '上传后返回的媒体素材id',
  `thumbMediaId` varchar(150) DEFAULT NULL COMMENT '封面图片id',
  `news_index` int(11) DEFAULT NULL COMMENT '多图文中的第几条',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_msg_news` */

/*Table structure for table `t_wxcms_msg_news_combin` */

DROP TABLE IF EXISTS `t_wxcms_msg_news_combin`;

CREATE TABLE `t_wxcms_msg_news_combin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_id` int(11) NOT NULL,
  `msgnews_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`main_id`,`msgnews_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_msg_news_combin` */

/*Table structure for table `t_wxcms_msg_text` */

DROP TABLE IF EXISTS `t_wxcms_msg_text`;

CREATE TABLE `t_wxcms_msg_text` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `base_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_msg_text` */

/*Table structure for table `t_wxcms_sys_user` */

DROP TABLE IF EXISTS `t_wxcms_sys_user`;

CREATE TABLE `t_wxcms_sys_user` (
  `id` varchar(64) NOT NULL DEFAULT '' COMMENT '主键id',
  `account` varchar(50) DEFAULT NULL COMMENT '账号',
  `pwd` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `trueName` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) DEFAULT '0' COMMENT '性别：0是男 1是女',
  `phone` varchar(11) DEFAULT '' COMMENT '手机号码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `flag` int(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_sys_user` */

insert  into `t_wxcms_sys_user`(`id`,`account`,`pwd`,`trueName`,`sex`,`phone`,`createTime`,`updateTime`,`email`,`flag`) values ('1','admin','e10adc3949ba59abbe56e057f20f883e','admin','0','',NULL,NULL,'',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


-- 业务：修改表名为自身定义
-- 作者：SethMessenger
-- 日期: 2018-03-30
-- 执行状态： 未执行

-- 修改表名,起始字符修改为"s_"，
-- 微信账户表
ALTER  TABLE `t_wxcms_account` RENAME TO `s_account`;
-- 微信关注用户表（也可以理解为用户表）
ALTER  TABLE `t_wxcms_account_fans` RENAME TO `s_account_fans`;
-- 微信账户菜单
ALTER  TABLE `t_wxcms_account_menu` RENAME TO `s_account_menu`;
-- 微信账户菜单组
ALTER  TABLE `t_wxcms_account_menu_group` RENAME TO `s_account_menu_group`;
-- 微信图文消息表
ALTER  TABLE `t_wxcms_article` RENAME TO `s_article`;
-- 微信图片资料信息
ALTER  TABLE `t_wxcms_img_resource` RENAME TO `s_img_resource`;
-- 微信媒体信息？？？
ALTER  TABLE `t_wxcms_media_files` RENAME TO `s_media_files`;
-- 消息
ALTER  TABLE `t_wxcms_msg_base` RENAME TO `s_msg_base`;
-- 消息
ALTER  TABLE `t_wxcms_msg_news` RENAME TO `s_msg_news`;
-- 消息
ALTER  TABLE `t_wxcms_msg_news_combin` RENAME TO `s_msg_news_combin`;
-- 消息
ALTER  TABLE `t_wxcms_msg_text` RENAME TO `s_msg_text`;
-- 系统用户表（待拆分，根据业务单位公司进行人员权限划分）
ALTER  TABLE `t_wxcms_sys_user` RENAME TO `s_sys_user`;


-- 业务：新增冗余表s_company，以便于根据公司维度进行微信业务的区分，并且将微信账户和公司账户进行关联
-- 作者：SethMessenger
-- 日期: 2018-03-30
-- 执行状态： 已执行

CREATE TABLE `s_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '公司名称（以微信业务划分）',
  `legalPerson` varchar(32) NOT NULL DEFAULT '' COMMENT '法人姓名',
  `legalPhone` varchar(32) NOT NULL DEFAULT '' COMMENT '法人联系电话',
  `legalCompanyName` varchar(64) NOT NULL COMMENT '公司法定名称（以营业执照为准）',
  `legalLicense` varchar(64) NOT NULL DEFAULT '' COMMENT '公司法定营业号',
  `legalLicenseImage` int(64) NOT NULL COMMENT '营业执照图片',
  `logo` varchar(64) DEFAULT NULL COMMENT '公司logo缩略图',
  `createTime` date NOT NULL COMMENT '记录创建时间',
  `updateTime` date NOT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table s_sys_user add companyId varchar(11) not null default '';

alter table `s_account` add companyId varchar(11) not null default '';

-- 业务：新增前后端用户的二级分销系统，作为中间表将 后端用户t_wxcms_sys_user 和 r_user进行关联
-- 作者：SethMessenger
-- 日期: 2018-08-12
-- 执行状态： 已执行

CREATE TABLE `r_sysuser_user_rel` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `user_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户uuid',
  `sysuser_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '后台运营账户唯一标志',
  `sysuser_user_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '后台运营账户绑定的前端账户唯一标志',
  `rel_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '关联类型，0 后端运营账户一对多关联前端用户 ',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 业务：新增比赛下注类型  1冠军赛 2冠亚军赛 3竞速赛
-- 作者：SethMessenger
-- 日期: 2018-08-14
-- 执行状态： 已执行
alter table r_match_log add match_type INT(2) not null default 1 COMMENT '比赛下注类型  1冠军赛 2冠亚军赛 3竞速赛';

ALTER  TABLE `r_sysuser_user_rel` DROP COLUMN `sysuser_user_uuid`;

CREATE TABLE `r_sale_card` (
  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一主键',
  `is_del` int(2) NOT NULL COMMENT '是否删除 0可用 1删除',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人uuid',
  `updater` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人uuid',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间戳',
  `update_time` bigint(11) NOT NULL COMMENT '修改时间戳',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0 可用 1已用 2作废h ',
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0 金币充值卡 ',
  `amount` int(5) NOT NULL DEFAULT '0' COMMENT '币值金额',
  `create_sysuser_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人(关联系统用户)',
  `sale_user_uuid` varchar(32) DEFAULT '' COMMENT '消费人(关联客户端用户)',
  `sale_time` bigint(11) DEFAULT '0' COMMENT '消费时间',
  `remark` varchar(50) DEFAULT '' COMMENT '备注信息',
  `card_no` varchar(8) NOT NULL DEFAULT '' COMMENT '充值码',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
