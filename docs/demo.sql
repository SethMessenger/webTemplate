
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wx_manage` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

grant all privileges on wx_manage.* to racing@localhost identified by '123456';
flush privileges;

USE `wx_manage`;

/*
用户信息管理表
*********************************************************************
*/
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` date NOT NULL COMMENT '创建时间',
  `gmt_modified` date NOT NULL COMMENT '修改时间',
  `is_del` tinyint(2) NOT NULL COMMENT '是否删除 0未删除 1删除',
  `operator` varchar(32) NOT NULL DEFAULT '' COMMENT '操作人uuid',
  `user_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户uuid',
  `total` int(16) NOT NULL COMMENT '用户赚币总余额',
  `gender` int(1) NOT NULL COMMENT '性别 0女 1男',
  `nick_name` varchar(40) NOT NULL DEFAULT '' COMMENT '微信昵称（兼容老版本20字符）',
  `open_id` varchar(30) NOT NULL DEFAULT '' COMMENT '关注微信生成openId',
  `union_id` varchar(30) DEFAULT NULL COMMENT '微信平台账户下的unionId',
  `user_mobile` varchar(11) DEFAULT '' COMMENT '用户手机号',
  `user_wechat` varchar(16) DEFAULT NULL COMMENT '用户微信号',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '用户密码MD5',
  `head_img` varchar(156) DEFAULT '' COMMENT '微信授权头像(长度129)',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


/*
任务信息管理表
*********************************************************************
*/
DROP TABLE IF EXISTS `s_task`;
CREATE TABLE `s_task` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` date NOT NULL COMMENT '创建时间',
  `gmt_modified` date NOT NULL COMMENT '修改时间',
  `is_del` tinyint(2) NOT NULL COMMENT '是否删除 0未删除 1删除',
  `operator` varchar(32) NOT NULL DEFAULT '' COMMENT '操作人uuid',
  `task_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '任务uuid',
  `val` int(1) NOT NULL COMMENT '价值，可转换的赚币数量',
  `task_name` varchar(40) NOT NULL DEFAULT '' COMMENT '任务名',
  `description` varchar(312) DEFAULT '' COMMENT '任务描述',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `task_type` int(2) NOT NULL COMMENT '任务类型 0小程序 1小游戏 3H5',
  `appid` varchar(16) DEFAULT NULL COMMENT '小程序appid',
  `path` varchar(32) DEFAULT NULL COMMENT '小程序跳转路径',
  `params` varchar(128) DEFAULT NULL COMMENT '小程序跳转携带参数',
  `sort` int(2) NOT NULL COMMENT '人工排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;


/*
用户任务日志表
*********************************************************************
*/
DROP TABLE IF EXISTS `s_user_task_log`;
CREATE TABLE `s_user_task_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` date NOT NULL COMMENT '创建时间',
  `gmt_modified` date NOT NULL COMMENT '修改时间',
  `is_del` tinyint(2) NOT NULL COMMENT '是否删除 0未删除 1删除',
  `operator` varchar(32) NOT NULL DEFAULT '' COMMENT '操作人uuid',
  `task_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '日志uuid',
  `user_uuid` int(1) NOT NULL COMMENT '价值，可转换的赚币数量',
  `commit_time` date NOT NULL COMMENT '任务完成时间',
  `val` int(1) NOT NULL COMMENT '任务价值',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


/*
用户金币账户信息管理 TODO 暂时不使用，将用户user主表中的字段作为最终金额
*********************************************************************
*/


/*
用户金币账户进出账日志信息
*********************************************************************
*/
DROP TABLE IF EXISTS `s_user_coin_log`;
CREATE TABLE `s_user_coin_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` date NOT NULL COMMENT '创建时间',
  `gmt_modified` date NOT NULL COMMENT '修改时间',
  `is_del` tinyint(2) NOT NULL COMMENT '是否删除 0未删除 1删除',
  `operator` varchar(32) NOT NULL DEFAULT '' COMMENT '操作人uuid',
  `user_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户uuid',
  `val` int(16) NOT NULL COMMENT '转账金额',
  `log_type` int(2) NOT NULL DEFAULT '0' COMMENT '0出账 1入账 ',
  `description` varchar(312) DEFAULT '' COMMENT '账目描述',
  `remark` varchar(32) DEFAULT NULL COMMENT '账户变动备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;