/*
 Navicat Premium Data Transfer

 Source Server         : jf_aliyun_server
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : 139.224.103.236:3306
 Source Schema         : jftest

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 27/09/2022 17:07:17
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`          char(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    NOT NULL COMMENT '主键ID',
    `money`       decimal(10, 2)                                               NOT NULL COMMENT '金额',
    `name`        varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
    `is_deleted`  tinyint(1) NOT NULL DEFAULT 0,
    `create_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account`
VALUES ('1', 10.00, '张三', 0, '2022-09-27 08:04:23', '2022-09-27 09:06:46');
INSERT INTO `account`
VALUES ('2', 10.00, '李四', 0, '2022-09-27 08:04:41', '2022-09-27 09:06:53');

SET
FOREIGN_KEY_CHECKS = 1;
