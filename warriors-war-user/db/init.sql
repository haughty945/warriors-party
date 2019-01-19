CREATE TABLE `sys_user`
(
  `id`           bigint(7) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `no`           varchar(32)  NOT NULL COMMENT 'UUID',
  `user_name`    varchar(255) NOT NULL COMMENT '姓名',
  `user_mobile`  varchar(11)  NOT NULL COMMENT '手机号',
  `pass_word`    varchar(255) NOT NULL COMMENT '密码',
  `user_address` varchar(255)          DEFAULT NULL COMMENT '地址',
  `signature`    varchar(255)          DEFAULT NULL COMMENT '个性签名',
  `token`        varchar(255)          DEFAULT NULL COMMENT 'token',
  `create_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`  timestamp    NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `version`      bigint(255) NOT NULL DEFAULT '1' COMMENT '版本号',
  `delete_flag`  int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 0 存在 1 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户';