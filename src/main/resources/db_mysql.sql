/**
mysql建表语句
 */

 /*字典表（枚举表）*/
 create table t_dict(
    dict_id varchar(32) not null,
    dict_name varchar(32) not null,
    dict_key varchar(32) not null,
    dict_value varchar(32) not null,
    note varchar(64),
    primary key(dict_id,dict_key)
 );

 /**
 全国地市、区县表
  */
create table t_citys(
   city_id varchar(8) not null,
   city_name varchar(32) not null,
   city_type char(1) not null,
   parent_id varchar(8) not null,
   primary KEY (city_id)
)

/**
用户表
 */
create table t_users(
  user_id varchar(32) not null,
  user_name varchar(32) not null,
  user_pwd  varchar(32) not null,
  nickname varchar(32),/*别名*/
  sex char(1),
  tel_number varchar(16),
  city_id char(4),
  provence_id char(4),
  country_id char(4),
  county_id char(4),
  user_addr varchar(128),
  email varchar(64),
  inviter varchar(32),/*邀请人*/
  reg_time TIMESTAMP ,
  primary key(user_id)
);
/**
用户扩展表
当用户的基本信息越来越多时，操作用户基本表的消耗太大，对于用户的分数，操作的频率非常高，所以作为一个扩展,关联查询
 */
create table t_user_expand(
  user_id varchar(32) not null,
  total_point integer,/*可用的总积分*/
  primary key(user_id)
);

/**
会员积分明细表
 */
create table t_user_ship_point(
  point_id int not null auto_increment,/*自增主键*/
  user_id varchar(32),
  point integer,/*得到(+)积分或者失去积分(-)*/
  point_type varchar(4),/*获得或者失去积分的途径；应该有专门的定义：比如：01:注册；02:邀请注册等等*/
  before_point integer,/*未获得(或失去)积分前的可用积分*/
  after_point integer,/*获得（或失去）积分后的可用积分*/
  point_note varchar(64),/*对本次积分的说明*/
  crt_time timestamp,
  primary key(point_id)
)

/**
板块表
 */
create table t_sectors(
  sector_id varchar(32) not null,
  sector_name varchar(32) not null,
  task_num int DEFAULT 9,/*板块下任务数*/
  sector_type varchar(4),/*板块类型,此处是编码，应该在枚举表中定义所有类型*/
  sector_status char(2),/*板块状态*/
  sector_desc varchar(128),/*板块描述*/
  sector_pic varchar(64),
  crt_time TIMESTAMP ,/*创建时间*/
  primary key (sector_id)
);

/**
任务表
 */
create table t_tasks(
  merchant_id varchar(32) not null,/*所属商家；平台也是一个商家*/
  sector_id varchar(32) not null,
  task_id varchar(32) not null,
  task_name varchar(64) not null,
  task_type char(2),/*任务类型，注册邀请这个应该属于平台任务，非商家创建；00:平台任务；10:板块任务*/
  task_rule varchar(32),/*任务规则；定义一个规则的工具集，处理每个规则，比如：注册邀请3人的平台任务，在处理用户任务时，调用次规则方法；每增加一个规则就需要增加一个规则方法；定义成可配置的*/
  task_status char(2),/*00:未发布；01:发布；02:锁定；03:完成*/
  task_score integer,/*任务积分*/
  task_content blob,/*任务内容，图文结合的html字符串*/
  appointment_num integer,/*预约号码，如果任务非常紧张，当商家发布任务时，进入排对队列(是否还需要一个对列表呢？)*/
  start_time TIMESTAMP ,/*任务开始时间*/
  stop_time TIMESTAMP ,/*任务结束时间*/
  crt_time TIMESTAMP ,/*创建时间*/
  primary key(merchant_id,sector_id,task_id)
);

/**
任务规则表
当前表还需要好好的思考与设计
 */
 create table t_task_rules(
   rule_id varchar(32) not null,
   rule_name varchar(32) not null,
   rule_content varchar(256),/*规则内容*/
   rule_class varchar(64),/*解析规则的类;这样每次有心的规则，只要调用这个解析类就行。这个解析类应该有专门的父类以及固定的方法；
   但是对于今天邀请3个人；明天改为邀请5个，1个的怎么办呢？设计一个规则参数扩展表，在规则中插入特殊化的参数，到解析类中解析这个参数*/
   primary key(rule_id)
 );

/**
任务规则扩展表，需要设计一个专门的工具类进行解析此内容；并固定一些常用的参数。
这些参数应该放到缓存中，并可刷新
 */
 create table t_task_rule_expand(
    param_name varchar(32) not null,/*特殊格式的参数，比如：{{invite_reg_num}}邀请注册的个数*/
    param_desc varchar(32) not null,/*参数说明*/
    note varchar(64),
    primary key (param_name);/*参数必须唯一*/
 )




create table t_user_task(
  user_id varchar(32) not null,
  task_id varchar(32) not null,
  task_status char(2),/*用户任务表，也需要标志任务状态，此状态是用户对于任务；01:领取；02:完成；03:失败；04:放弃*/
  task_time timestamp,
  task_note varchar(64),/*用户任务说明，比如放弃任务时*/
  primary key(user_id,task_id)
)



/**
商家表
 */
create table t_merchants(
  merchant_id varchar(32) not null,
  merchant_name varchar(64) not null,
  short_name varchar(32),
  tel_number varchar(16),
  merchant_pwd varchar(32) not null,
  merchant_type char(2),/*商家类型*/
  merchant_principal varchar(16),/*负责人*/
  reg_time TIMESTAMP ,

  primary key(merchant_id)
)

/**
商家扩展表
 */
create table t_merchant_expand(
  merchant_id varchar(32) not null,
  total_point integer,/*总积分：可用的总积分*/
  primary key (merchant_id)
);

/**
商家积分明细表;对于商家发布的任务积分，显示任务，点击这个任务，可以查看具体哪些用户获得了这个任务积分
 */
create table t_merchant_ship_point(
  point_id int not null auto_increment,/*自增主键*/
  merchan_id varchar(32),
  point integer,/*得到(+)积分或者失去积分(-)*/
  point_type varchar(4),/*获得或者失去积分的途径；应该有专门的定义：比如：01:注册；02:邀请注册等等*/
  before_point integer,/*未获得(或失去)积分前的可用积分*/
  after_point integer,/*获得（或失去）积分后的可用积分*/
  point_note varchar(64),/*对本次积分的说明*/
  crt_time timestamp,
  primary key(point_id)
)