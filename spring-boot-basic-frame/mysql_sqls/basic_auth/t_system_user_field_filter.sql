CREATE TABLE t_system_user_field_filter(
  id          int         comment '自增Id'             auto_increment,
  user_id     int         not null comment 't_system_user.id',
  ctrl_id     int         not null comment 't_system_ctrl.id',
  method_id   int         not null comment 't_system_method.id',
  filter_fields varchar(512) not null comment '过滤的字段，多字段以,隔开',
  key idx_user_id(user_id),
  key idx_ctrl_id(ctrl_id),
  key idx_method_id(method_id),
  primary key(id)
) comment = '系统用户表';