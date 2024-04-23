/*
Navicat MySQL Data Transfer

Source Server         : jfTencentServer
Source Server Version : 80028
Source Host           : 172.31.128.22:3306
Source Database       : jfTest

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-11-13 19:37:05
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base
-- ----------------------------
DROP TABLE IF EXISTS `base`;
CREATE TABLE `base`
(
    `id`          char(24)   NOT NULL,
    `is_deleted`  tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除（0：未删除，1：已删除）',
    `create_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of base
-- ----------------------------
INSERT INTO `base`
VALUES ('1', '0', '2022-11-13 11:35:25', '2022-11-13 11:36:51');
