CREATE TABLE t_system_user(
  id          int         not null comment '系统用户Id'             auto_increment,
  login_name  varchar(16) not null comment '登录帐号',
  password    char(32)    not null comment '登录密码',
  status      tinyint(2)  not null comment '状态0正常1被删除4禁用'     default 0,
  group_id    int         not null comment '权限组Id'                default 0,
  bind_ip     bigint(11)  not null comment '绑定Ip地址 0表示所有'      default 0,
  create_time TIMESTAMP   not null comment '创建时间',
  create_ip   bigint(11)  not null comment '创建IP'                   default 0,
  creator     int         not null comment 't_system_user.id 0表示初始化创建' default 0,
  key idx_login_name(login_name(10)),
  key idx_status(status),
  primary key(id)
) comment = '系统用户表';
ALTER TABLE t_system_user
ADD UNIQUE INDEX `login_name_UNIQUE` (`login_name` ASC);