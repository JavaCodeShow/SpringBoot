CREATE TABLE `user` (
                        `id` CHAR ( 24 ) NOT NULL,
                        `name` VARCHAR ( 33 ) NOT NULL,
                        `phone` VARCHAR ( 33 ) NULL DEFAULT NULL,
                        `money` DECIMAL ( 10, 2 ) NULL DEFAULT NULL,
                        `password` VARCHAR ( 100 ) NULL DEFAULT NULL,
                        `is_deleted` TINYINT ( 1 ) NOT NULL DEFAULT 0 COMMENT '是否删除（0：未删除，1：已删除）',
                        `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                        PRIMARY KEY ( `id` ) USING BTREE
) ENGINE = INNODB;