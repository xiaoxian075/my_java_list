create table t_system_ctrl(
  id                int           auto_increment    comment '主键Id',
  ctrl_name         varchar(256)  not null          comment '控制器名称',
  ctrl_desc         varchar(64)   not null          comment '控制器描述',
  ctrl_version      int           not null          comment '版本号'           default 0,
  ctrl_url          varchar(256)  not null          comment '跳转地址'         default '-',
  parent_id         int           not null          comment '父节点'           default 0,
  last_update_time  TIMESTAMP     not null          comment '最新更新时间',
  primary key(id)
) comment = '系统控制器列表';