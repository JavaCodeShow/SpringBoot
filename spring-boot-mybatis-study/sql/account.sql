/*
Navicat MySQL Data Transfer

Source Server         : jfTencentServer
Source Server Version : 80028
Source Host           : 1.15.226.249:3306
Source Database       : jftest

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-11-13 19:42:33
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`          char(24)       NOT NULL,
    `money`       decimal(10, 2) NOT NULL,
    `name`        varchar(64)             DEFAULT '',
    `is_deleted`  tinyint(1)     NOT NULL DEFAULT '0' COMMENT '是否删除（0：未删除，1：已删除）',
    `create_time` timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account`
VALUES ('1', '9.00', '张三', '0', '2022-09-27 00:00:00', '2022-11-13 11:42:17');
INSERT INTO `account`
VALUES ('2', '11.00', '李四', '0', '2022-09-27 00:00:00', '2022-09-27 00:00:00');
INSERT INTO `account`
VALUES ('3', '10.00', '王五', '0', '2022-09-27 00:00:00', '2022-11-13 11:42:17');
INSERT INTO `account`
VALUES ('4', '100.00', '赵1', '0', '2022-09-27 00:00:00', '2022-09-27 00:00:00');
