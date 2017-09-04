create table t_system_ctrl_method(
  id                int             auto_increment  comment '主键Id',
  method_id         int             not null        comment '方法Id',
  ctrl_id           int             not null        comment 't_system_ctrl.id',
  method_name       varchar(64)     not null        comment '方法名称',
  method_desc       varchar(64)     not null        comment '方法描述',
  method_version    int             not null        comment '方法版本',
  last_update_time  TIMESTAMP       not null        comment '最后更新时间',
  key `auth_pk`(ctrl_id,method_id),
  primary key(id)
) comment = '系统控制器方法列表';
