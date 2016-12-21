# 创建表
drop table if exists user;
drop table if exists role;
drop table if exists permission;
drop table if exists user_role;
drop table if exists role_permission;

create table user (
  id bigint auto_increment,
  username varchar(100),
  password varchar(100),
  salt varchar(100),
  locked bool default false,
  constraint pk_user primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_user_username on user(username);

create table role (
  id bigint auto_increment,
  role_name varchar(100),
  description varchar(100),
  available bool default false,
  constraint pk_role primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_role_role on role(role_name);

create table permission (
  id bigint auto_increment,
  permission_name varchar(100),
  description varchar(100),
  available bool default false,
  constraint pk_permission primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_permission_permission_name on permission(permission_name);

create table user_role (
  id bigint auto_increment,
  user_id bigint,
  role_id bigint,
  constraint pk_user_role primary key(id)
) charset=utf8 ENGINE=InnoDB;

create table role_permission (
  id bigint auto_increment,
  role_id bigint,
  permission_id bigint,
  constraint pk_role_permission primary key(id)
) charset=utf8 ENGINE=InnoDB;


# 插入数据
INSERT INTO user(username, password, salt, locked)
VALUES('zhang', '123', '', 1);

INSERT INTO role(role_name, description, available)
VALUES('programmer', '程序员权限', 1);

INSERT INTO permission(permission_name, description, available)
VALUES ('normal:view', '普通用户看权限', 1);

INSERT INTO user_role(user_id, role_id)
VALUES ((SELECT id FROM user WHERE username='zhang'), (SELECT id FROM role WHERE role_name = 'programmer'));

INSERT INTO role_permission(role_id, permission_id)
VALUES((SELECT id FROM role WHERE role_name = 'programmer'), (SELECT id FROM permission WHERE permission_name = 'normal:view'));


