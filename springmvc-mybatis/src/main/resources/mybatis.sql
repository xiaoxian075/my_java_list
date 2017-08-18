DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_name` varchar(40) NOT NULL,  
  `password` varchar(255) NOT NULL,  
  `age` int(4) NOT NULL,  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `user_t`(`id`,`user_name`,`password`,`age`) values (1,'测试','sfasgfaf',24);


DROP TABLE IF EXISTS `good_info`;
CREATE TABLE `good_info` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `name` char(32) NOT NULL,  
  `serial_number` char(32) NOT NULL,  
  `branch` varchar(255) NOT NULL,
  `updatetime` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `good_info`(`name`,`serial_number`,`branch`,`updatetime`) values ('显示屏','A01-03-055','飞利浦',1496650521);