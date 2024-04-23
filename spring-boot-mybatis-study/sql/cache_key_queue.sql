/*
Navicat MySQL Data Transfer

Source Server         : jfTencentServer
Source Server Version : 80028
Source Host           : 172.31.128.22:3306
Source Database       : jfTest

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-11-13 19:44:37
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cache_key_queue
-- ----------------------------
DROP TABLE IF EXISTS `cache_key_queue`;
CREATE TABLE `cache_key_queue`
(
    `id`          char(24)   NOT NULL,
    `cache_key`   char(24)   NOT NULL,
    `is_deleted`  tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除（0：未删除，1：已删除）',
    `create_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cache_key_queue
-- ----------------------------
