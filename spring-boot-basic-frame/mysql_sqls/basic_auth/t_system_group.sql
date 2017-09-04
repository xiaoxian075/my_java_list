create table t_system_group(
    id          int          not null auto_increment,
    group_name  varchar(32)  not null comment '权限组名称',
    status      tinyint(2)   not null comment '状态0正常1被删除4禁用',
    create_time TIMESTAMP    not null comment '创建时间',
    create_ip   bigint(11)   not null comment '创建IP',
    creator     int          not null comment 't_system_user.id 0表示初始化创建',
    key idx_status(status),
    primary key(id)
) comment = '系统权限组';