/*
 Navicat Premium Data Transfer

 Source Server         : jfTencentServer
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 172.28.88.249:3306
 Source Schema         : jfTest

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 07/03/2023 17:10:44
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
    `id`          char(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `user_id`     char(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
    `money`       decimal(10, 2)                                            NOT NULL COMMENT '金额',
    `is_deleted`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0：未删除，1：已删除）',
    `create_time` timestamp                                                 NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp                                                 NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account`
VALUES ('1', '', 9.00, 0, '2022-09-27 00:00:00', '2022-11-13 11:42:17');
INSERT INTO `account`
VALUES ('100', '', 100.00, 0, '2022-09-27 00:00:00', '2022-11-13 00:00:00');
INSERT INTO `account`
VALUES ('111', '', 100.00, 0, '2022-09-27 00:00:00', '2022-11-13 00:00:00');
INSERT INTO `account`
VALUES ('2', '', 11.00, 0, '2022-09-27 00:00:00', '2022-09-27 00:00:00');
INSERT INTO `account`
VALUES ('3', '', 10.00, 0, '2022-09-27 00:00:00', '2022-11-13 11:42:17');
INSERT INTO `account`
VALUES ('4', '', 100.00, 0, '2022-09-27 00:00:00', '2022-09-27 00:00:00');

SET
FOREIGN_KEY_CHECKS = 1;
