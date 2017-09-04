create table t_system_group_method(
  id            int not null auto_increment,
  group_id      int not null comment 't_system_group.id',
  ctrl_id       int not null comment 't_system_ctrl.id',
  method_id     int not null comment 't_system_method.id',
  key idx_group_id(group_id),
  key idx_method_id(method_id),
  primary key(id)
) comment = '系统权限组控制器列表';