CREATE DATABASE IF NOT EXISTS springboot DEFAULT CHARACTER SET utf8mb4;

USE springboot;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_name` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `phone` varchar(32) COMMENT '手机号',
  `email` varchar(64) COMMENT '邮箱地址',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '0标识删除, 1标识未删除',
  `data_change_created_time` datetime NOT NULL COMMENT '创建时间',
  `data_change_last_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY (`user_name`),
  UNIQUE KEY (`phone`),
  UNIQUE KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账号表';