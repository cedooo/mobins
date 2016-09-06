/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2014/6/20 10:25:06                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_CYC_DEST') and o.name = 'FK_T_CYC_DE_REFERENCE_T_DEST')
alter table T_CYC_DEST
   drop constraint FK_T_CYC_DE_REFERENCE_T_DEST
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_CYC_DEST') and o.name = 'FK_T_CYC_DE_REFERENCE_T_CYC_EX')
alter table T_CYC_DEST
   drop constraint FK_T_CYC_DE_REFERENCE_T_CYC_EX
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_CYC_KEY_WORD') and o.name = 'FK_T_CYC_KE_REFERENCE_T_CYC_EX')
alter table T_CYC_KEY_WORD
   drop constraint FK_T_CYC_KE_REFERENCE_T_CYC_EX
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_CYC_TASK') and o.name = 'FK_T_CYC_TA_REFERENCE_T_DEST')
alter table T_CYC_TASK
   drop constraint FK_T_CYC_TA_REFERENCE_T_DEST
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_CYC_TASK') and o.name = 'FK_T_CYC_TA_REFERENCE_T_CYC_EX')
alter table T_CYC_TASK
   drop constraint FK_T_CYC_TA_REFERENCE_T_CYC_EX
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_CYC_DEST')
            and   type = 'U')
   drop table T_CYC_DEST
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_CYC_EXEC_STRATEGY')
            and   type = 'U')
   drop table T_CYC_EXEC_STRATEGY
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_CYC_KEY_WORD')
            and   type = 'U')
   drop table T_CYC_KEY_WORD
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_CYC_TASK')
            and   type = 'U')
   drop table T_CYC_TASK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_DEST')
            and   type = 'U')
   drop table T_DEST
go

/*==============================================================*/
/* Table: T_CYC_DEST                                            */
/*==============================================================*/
create table T_CYC_DEST (
   N_DEST_BM            integer              null,
   N_CYC_EXEC_STRATEGY_ID integer              null,
   DT_CD_MAP_ADD_DATETIME datetime             null,
   DT_CD_MAP_DEL_DATETIME datetime             null
)
go

/*==============================================================*/
/* Table: T_CYC_EXEC_STRATEGY                                   */
/*==============================================================*/
create table T_CYC_EXEC_STRATEGY (
   N_CYC_EXEC_STRATEGY_ID integer              identity,
   VC_CRON_EXPRESSION   varchar(32)          null,
   VC_CYC_PLAN_NOTE     varchar(128)         null,
   VC_ALARM_TYPE        varchar(8)           null,
   VC_CYC_NAME          varchar(32)          null,
   DT_CYC_ADD_DATETIME  datetime             null,
   DT_CYC_DEL_DATETIME  datetime             null,
   constraint PK_T_CYC_EXEC_STRATEGY primary key (N_CYC_EXEC_STRATEGY_ID)
)
go

/*==============================================================*/
/* Table: T_CYC_KEY_WORD                                        */
/*==============================================================*/
create table T_CYC_KEY_WORD (
   N_CYC_KEY_WORDS_ID   integer              identity,
   N_CYC_EXEC_STRATEGY_ID integer              null,
   VC_KEY_WORDS_NAME    varchar(128)         null,
   VC_KEY_WORD          varchar(128)         null,
   VC_KEY_WORD_NOTE     varchar(128)         null,
   VC_CARE_LEVEL        varchar(16)          null,
   DT_KEY_WORD_ADD_DATETIME datetime             null,
   DT_KEY_WORD_DEL_DATETIME datetime             null,
   constraint PK_T_CYC_KEY_WORD primary key (N_CYC_KEY_WORDS_ID)
)
go

/*==============================================================*/
/* Table: T_CYC_TASK                                            */
/*==============================================================*/
create table T_CYC_TASK (
   N_CHECK_ID           integer              identity,
   N_DEST_BM            integer              null,
   N_CYC_EXEC_STRATEGY_ID integer              null,
   DT_CHECK_TIME        datetime             null,
   VC_CHECK_RESULT      varchar(128)         null,
   VC_CHECK_NOTE        varchar(128)         null,
   VC_CHECK_DETAILS     varchar(1024)        null,
   DT_CHECK_ADD_DATETIME datetime             null,
   DT_CHECK_DEL_DATETIME datetime             null,
   constraint PK_T_CYC_TASK primary key nonclustered (N_CHECK_ID)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '巡检任务记录',
   'user', @CurrentUser, 'table', 'T_CYC_TASK'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '是否含有异常',
   'user', @CurrentUser, 'table', 'T_CYC_TASK', 'column', 'VC_CHECK_RESULT'
go

/*==============================================================*/
/* Table: T_DEST                                                */
/*==============================================================*/
create table T_DEST (
   N_DEST_BM            integer              identity,
   VC_DEST_IP           varchar(128)         null,
   N_DEST_PORT          integer              null,
   VC_DEST_NAME         varchar(128)         null,
   VC_DEST_NOTE         varchar(128)         null,
   VC_DEST_TYPE         varchar(128)         null,
   VC_DEST_STATUS       varchar(32)          null,
   DT_ADD_DATE          datetime             null,
   DT_DEL_DATE          datetime             null,
   constraint PK_T_DEST primary key nonclustered (N_DEST_BM)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '巡检目标',
   'user', @CurrentUser, 'table', 'T_DEST'
go

alter table T_CYC_DEST
   add constraint FK_T_CYC_DE_REFERENCE_T_DEST foreign key (N_DEST_BM)
      references T_DEST (N_DEST_BM)
go

alter table T_CYC_DEST
   add constraint FK_T_CYC_DE_REFERENCE_T_CYC_EX foreign key (N_CYC_EXEC_STRATEGY_ID)
      references T_CYC_EXEC_STRATEGY (N_CYC_EXEC_STRATEGY_ID)
go

alter table T_CYC_KEY_WORD
   add constraint FK_T_CYC_KE_REFERENCE_T_CYC_EX foreign key (N_CYC_EXEC_STRATEGY_ID)
      references T_CYC_EXEC_STRATEGY (N_CYC_EXEC_STRATEGY_ID)
go

alter table T_CYC_TASK
   add constraint FK_T_CYC_TA_REFERENCE_T_DEST foreign key (N_DEST_BM)
      references T_DEST (N_DEST_BM)
go

alter table T_CYC_TASK
   add constraint FK_T_CYC_TA_REFERENCE_T_CYC_EX foreign key (N_CYC_EXEC_STRATEGY_ID)
      references T_CYC_EXEC_STRATEGY (N_CYC_EXEC_STRATEGY_ID)
go

