/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/4/16 16:00:39                           */
/*==============================================================*/


drop table if exists tb_grade;

drop table if exists tb_group;

drop table if exists tb_master;

drop table if exists tb_media;

drop table if exists tb_message;

drop table if exists tb_message_read;

drop table if exists tb_notice;

drop table if exists tb_notice_read;

drop table if exists tb_role;

drop table if exists tb_role_function;

drop table if exists tb_scope;

drop table if exists tb_task;

drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_grade                                              */
/*==============================================================*/
create table tb_grade
(
  id integer not null auto_increment,
   userid               integer,
   taskid               integer,
   score                integer,
   judgment             integer,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_group                                              */
/*==============================================================*/
create table tb_group
(
  id integer not null auto_increment,
   name                 varchar(20),
   count                integer,
   members              text,
   owner                integer,
   type                 smallint,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_master                                             */
/*==============================================================*/
create table tb_master
(
  id integer not null auto_increment,
   mkey                  integer,
   type                 varbinary(50),
   reander              varchar(40),
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_media                                              */
/*==============================================================*/
create table tb_media
(
   id                   integer not null auto_increment,
   owner                integer,
   receiver             integer,
   status               smallint,
   url                  text not null,
   type                 integer not null,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_message                                            */
/*==============================================================*/
create table tb_message
(
  id integer not null auto_increment,
   content              text,
   sender               integer,
   receiver             integer,
   parentid             integer,
   time                 timestamp,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_message_read                                       */
/*==============================================================*/
create table tb_message_read
(
  id integer not null auto_increment,
   messageid            integer,
   userId               integer,
   time                 timestamp,
   isread               smallint,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_notice                                             */
/*==============================================================*/
create table tb_notice
(
  id integer not null auto_increment,
   title                text,
   content              text,
   time                 timestamp,
   sender               integer,
   type                 smallint,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_notice_read                                        */
/*==============================================================*/
create table tb_notice_read
(
   noticeid             integer,
   userid               integer,
   time                 timestamp,
   isread               smallint
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_role                                               */
/*==============================================================*/
create table tb_role
(
   id                   integer not null auto_increment,
   rolename             varchar(10),
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_role_function                                      */
/*==============================================================*/
create table tb_role_function
(
  id integer not null auto_increment,
   roleid               integer not null,
   functionurl          varchar(255) not null,
   primary key (id, roleid, functionurl)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_scope                                              */
/*==============================================================*/
create table tb_scope
(
   id                   integer not null auto_increment,
   scope                integer,
   type                 integer,
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_task                                               */
/*==============================================================*/
create table tb_task
(
  id integer not null auto_increment,
   name                 varchar(100),
   parentid             integer,
   publisher            integer,
   limitime             date,
   descrption           text,
   scope                integer,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
  id integer not null auto_increment,
   name                 varbinary(20) not null,
   mail                 varchar(30),
   phone                varchar(20),
   password             varchar(50) not null,
   roleid               integer,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table tb_grade add constraint FK_Reference_11 foreign key (userid)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_grade add constraint FK_Reference_12 foreign key (taskid)
      references tb_task (id) on delete restrict on update restrict;

alter table tb_group add constraint FK_Reference_2 foreign key (owner)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_message add constraint FK_Reference_10 foreign key (sender)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_message_read add constraint FK_Reference_8 foreign key (userid)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_message_read add constraint FK_Reference_9 foreign key (messageid)
      references tb_message (id) on delete restrict on update restrict;

alter table tb_notice add constraint FK_Reference_4 foreign key (sender)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_notice_read add constraint FK_Reference_5 foreign key (noticeid)
      references tb_notice (id) on delete restrict on update restrict;

alter table tb_notice_read add constraint FK_Reference_6 foreign key (userid)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_role_function add constraint FK_Reference_3 foreign key (roleid)
      references tb_role (id) on delete restrict on update restrict;

alter table tb_task add constraint FK_Reference_7 foreign key (publisher)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_user add constraint FK_Reference_1 foreign key (roleid)
      references tb_role (id) on delete restrict on update restrict;

