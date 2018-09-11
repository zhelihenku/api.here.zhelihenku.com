/*
 Navicat Premium Data Transfer

 Source Server         : loaclhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : db_zhelihenku_here

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 09/11/2018 23:15:47 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_system_department`
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_department`;
CREATE TABLE `tb_system_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` int(11) DEFAULT NULL COMMENT '父部门ID',
  `name` varchar(45) DEFAULT NULL COMMENT '名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '提示',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态（0：不可用，1：可用）',
  `is_delete` int(2) NOT NULL DEFAULT '0' COMMENT '删除标识（0：未删除，1：已删除）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
--  Records of `tb_system_department`
-- ----------------------------
BEGIN;
INSERT INTO `tb_system_department` VALUES ('1', '0', '这里集团', '这里集团', '1', '0', '2018-09-10 10:10:08', '2018-09-10 10:10:08'), ('2', '1', '北京分公司', '北京分公司', '1', '0', '2018-09-10 10:10:27', '2018-09-10 10:29:14'), ('3', '1', '上海分公司', '上海分公司', '1', '0', '2018-09-10 10:10:44', '2018-09-10 10:29:17'), ('4', '2', '技术部', '北京分公司技术部', '1', '0', '2018-09-10 10:11:49', '2018-09-10 10:29:19'), ('5', '2', '业务部', '北京分公司业务部', '1', '0', '2018-09-10 10:12:16', '2018-09-10 10:29:22'), ('6', '3', '财法部', '上海分公司财法部', '1', '1', '2018-09-10 10:48:24', '2018-09-10 10:52:53'), ('7', '3', '后勤部', '北京分公司后勤部', '1', '0', '2018-09-10 13:09:37', '2018-09-10 13:40:36');
COMMIT;

-- ----------------------------
--  Table structure for `tb_system_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_menu`;
CREATE TABLE `tb_system_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` int(11) DEFAULT NULL COMMENT '菜单父ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `sort` int(65) DEFAULT NULL COMMENT '排序号',
  `levels` int(65) DEFAULT NULL COMMENT '层级',
  `is_menu` int(2) DEFAULT NULL COMMENT '是否是菜单（0：不是，1：是）',
  `is_open` int(2) DEFAULT NULL COMMENT '是否打开（0：未打开，1：打开）',
  `desc` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '菜单状态（0：未启用，1：已启用）',
  `is_delete` int(2) NOT NULL DEFAULT '0' COMMENT '删除标识（0：未删除，1：已删除）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `component` varchar(255) DEFAULT NULL COMMENT '成分',
  `redirect` varchar(255) DEFAULT NULL COMMENT '重定向路由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
--  Records of `tb_system_menu`
-- ----------------------------
BEGIN;
INSERT INTO `tb_system_menu` VALUES ('1', '0', '系统管理', '123', 'system', null, null, '1', null, '系统管理', '1', '0', '2018-09-10 20:33:55', '2018-09-10 20:33:55', null, null), ('2', '1', '菜单管理', '123', 'menu', null, '2', '1', null, '菜单管理', '1', '0', '2018-09-10 20:38:47', '2018-09-10 20:38:47', null, null), ('3', '1', '角色管理', '123', 'role', null, '2', '1', null, '角色管理', '1', '0', '2018-09-10 20:45:45', '2018-09-10 20:45:45', null, null), ('4', '1', '部门管理', '123', 'department', null, '2', '1', null, '部门管理', '1', '0', '2018-09-10 20:46:17', '2018-09-10 20:46:17', null, null), ('5', '1', '用户管理', '123', 'user', null, '2', '1', null, '用户管理', '1', '0', '2018-09-10 20:46:42', '2018-09-10 20:46:42', null, null), ('6', '5', '评论管理', '123', 'comment', null, '3', '1', null, '评论管理', '1', '0', '2018-09-11 21:28:28', '2018-09-11 21:28:28', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `tb_system_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_role`;
CREATE TABLE `tb_system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` int(11) DEFAULT NULL COMMENT '父角色ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `department_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态（0：不可用，1：可用）',
  `is_delete` int(2) NOT NULL DEFAULT '0' COMMENT '删除标识（0：未删除，1：已删除）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
--  Records of `tb_system_role`
-- ----------------------------
BEGIN;
INSERT INTO `tb_system_role` VALUES ('1', '0', '超级管理员', '1', '超级管理员', '1', '0', '2018-09-10 11:47:28', '2018-09-10 14:16:37'), ('2', '1', '后台管理员', '1', '北京分公司后台管理员', '1', '0', '2018-09-10 11:48:37', '2018-09-10 14:16:38'), ('3', '2', '普通用户', '2', '北京分公司普通用户', '1', '0', '2018-09-10 13:59:30', '2018-09-10 13:59:30'), ('4', '1', '系统管理员', '2', '北京分公司系统管理员', '1', '1', '2018-09-10 19:33:53', '2018-09-10 19:41:37');
COMMIT;

-- ----------------------------
--  Table structure for `tb_system_role_menu_relation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_role_menu_relation`;
CREATE TABLE `tb_system_role_menu_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
--  Records of `tb_system_role_menu_relation`
-- ----------------------------
BEGIN;
INSERT INTO `tb_system_role_menu_relation` VALUES ('10', '1', '1', '2018-09-11 22:27:28'), ('11', '5', '1', '2018-09-11 22:27:28'), ('12', '6', '1', '2018-09-11 22:27:28'), ('13', '4', '1', '2018-09-11 22:27:28'), ('14', '3', '1', '2018-09-11 22:27:28'), ('15', '2', '1', '2018-09-11 22:27:28'), ('25', '5', '3', '2018-09-11 22:52:13'), ('26', '6', '3', '2018-09-11 22:52:13'), ('27', '4', '3', '2018-09-11 22:52:13'), ('28', '1', '3', '2018-09-11 22:52:13');
COMMIT;

-- ----------------------------
--  Table structure for `tb_system_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_user`;
CREATE TABLE `tb_system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `department_id` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态（0：停用，1：启用，2：冻结）',
  `is_delete` int(2) NOT NULL DEFAULT '0' COMMENT '删除标识（0：未删除，1：已删除）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
--  Records of `tb_system_user`
-- ----------------------------
BEGIN;
INSERT INTO `tb_system_user` VALUES ('2', 'zhangsanfeng', '96e79218965eb72c92a549dd5a330112', null, '张三疯', null, null, null, null, '1', '1', '1', '0', '2018-09-11 15:38:30', '2018-09-11 15:38:30'), ('3', 'lisi', '96e79218965eb72c92a549dd5a330112', null, '李四', null, null, null, null, '3', '4', '1', '0', '2018-09-11 22:46:29', '2018-09-11 22:46:29');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
