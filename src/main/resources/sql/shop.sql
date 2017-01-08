CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `tel` varchar(255) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `t_phone` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `num` varchar(255) DEFAULT NULL COMMENT '商品编号',
  `phonename` varchar(255) DEFAULT NULL COMMENT '手机名',
  `screen` varchar(255) DEFAULT NULL COMMENT '屏幕尺寸',
  `disk` varchar(255) DEFAULT NULL COMMENT '容量',
  `memory` varchar(255) DEFAULT NULL COMMENT '运存',
  `price` varchar(255) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手机';