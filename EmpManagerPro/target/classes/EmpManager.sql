/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/11/17 21:17:49                          */
/*==============================================================*/


drop table if exists tbl_department;

drop table if exists tbl_empolyee;

/*==============================================================*/
/* Table: tbl_department                                        */
/*==============================================================*/
create table tbl_department
(
   id                   int not null auto_increment,
   dep_name             varchar(10),
   dep_des              varchar(200),
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_empolyee                                          */
/*==============================================================*/
create table tbl_empolyee
(
   id                   int not null auto_increment,
   emp_name             varchar(10),
   emp_sex              varchar(10),
   emp_age              int,
   emp_tel              varchar(11),
   dep_id               int,
   primary key (id)
);

alter table tbl_empolyee add constraint FK_Reference_1 foreign key (dep_id)
      references tbl_department (id) on delete restrict on update restrict;

