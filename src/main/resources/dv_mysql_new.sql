
-----------------------------------------------------------------
/**
 * 城市信息表
 */
CREATE TABLE T_CITIES ( 
	CITY_ID  	VARCHAR(8) NOT NULL,
	CITY_NAME	VARCHAR(32) NOT NULL,
	CITY_TYPE	CHAR(1) NOT NULL,
	PARENT_ID	VARCHAR(8) NOT NULL 
);


/**
 * 字典表（枚举表）
 */
CREATE TABLE T_DICT(
   DICT_ID VARCHAR(32) NOT NULL,
   DICT_NAME VARCHAR(32) NOT NULL,
   DICT_KEY VARCHAR(32) NOT NULL,
   DICT_VALUE VARCHAR(32) NOT NULL,
   NOTE VARCHAR(64),
   PRIMARY KEY(DICT_ID,DICT_KEY)
);


/**
 * 广告板块表
 */
CREATE TABLE T_SECTORS(
  SECTOR_ID VARCHAR(32) NOT NULL,
  SECTOR_NAME VARCHAR(32) NOT NULL,
  TASK_NUM INT DEFAULT 9,/*板块下任务数*/
  SECTOR_TYPE VARCHAR(4),/*板块类型,此处是编码，应该在枚举表中定义所有类型*/
  SECTOR_STATUS CHAR(2),/*板块状态*/
  SECTOR_DESC VARCHAR(128),/*板块描述*/
  SECTOR_PIC VARCHAR(64),
  CRT_TIME TIMESTAMP ,/*创建时间*/
  PRIMARY KEY (SECTOR_ID)
);
-----------------------------------------------------------------
/**
 * 用户表
 */
CREATE TABLE T_USERS(
  USER_ID VARCHAR(32) NOT NULL,
  USER_NAME VARCHAR(32) NOT NULL,
  USER_PWD  VARCHAR(32) NOT NULL,
  NICKNAME VARCHAR(32),/*别名*/
  SEX CHAR(1),
  TEL_NUMBER VARCHAR(16),
  CITY_ID CHAR(4),
  PROVENCE_ID CHAR(4),
  COUNTRY_ID CHAR(4),
  COUNTY_ID CHAR(4),
  USER_ADDR VARCHAR(128),
  EMAIL VARCHAR(64),
  INVITER VARCHAR(32),/*邀请人*/
  REG_TIME TIMESTAMP ,
  PRIMARY KEY(USER_ID)
);

/**
 * 用户扩展表
 * 当用户的基本信息越来越多时，操作用户基本表的消耗太大，对于用户的分数，操作的频率非常高，所以作为一个扩展,关联查询
 */
CREATE TABLE T_USER_EXPAND(
  USER_ID VARCHAR(32) NOT NULL,
  TOTAL_POINT INTEGER,/*可用的总积分*/
  AD_PLACE_ID VARCHAR(100) NULL,/*拥有的广告位ID*/
  PAY_POINT INTEGER,/*购买积分总额*/
  REWARD_POINT INTEGER,/*奖励积分总额*/
  PRIMARY KEY(USER_ID)
);

/**
 * 用户积分明细表
 */
CREATE TABLE T_USER_SHIP_POINT(
  POINT_ID INT NOT NULL AUTO_INCREMENT,/*自增主键*/
  USER_ID VARCHAR(32),
  POINT INTEGER,/*得到(+)积分或者失去积分(-)*/
  POINT_TYPE VARCHAR(4),/*获得或者失去积分的途径；应该有专门的定义：比如：01:注册；02:邀请注册等等*/
  BEFORE_POINT INTEGER,/*未获得(或失去)积分前的可用积分*/
  AFTER_POINT INTEGER,/*获得（或失去）积分后的可用积分*/
  POINT_NOTE VARCHAR(64),/*对本次积分的说明*/
  EXPIRE_DATE VARCHAR(8) ,/*积分失效日期*/
  STATUS VARCHAR(2) ,/*积分是否可用：00:可用；其他：*/
  CRT_TIME TIMESTAMP,
  PRIMARY KEY(POINT_ID)
)
-----------------------------------------------------------------

/**
商家表
 */
CREATE TABLE T_MERCHANTS(
  MERCHANT_ID VARCHAR(32) NOT NULL,
  MERCHANT_NAME VARCHAR(64) NOT NULL,
  SHORT_NAME VARCHAR(32),
  TEL_NUMBER VARCHAR(16),
  MERCHANT_PWD VARCHAR(32) NOT NULL,
  MERCHANT_TYPE CHAR(2),/*商家类型*/
  MERCHANT_PRINCIPAL VARCHAR(16),/*负责人*/
  REG_TIME TIMESTAMP ,
  PRIMARY KEY(MERCHANT_ID)
)

/**
商家扩展表
 */
CREATE TABLE T_MERCHANT_EXPAND(
  MERCHANT_ID VARCHAR(32) NOT NULL,
  TOTAL_POINT INTEGER,/*总积分：可用的总积分*/
  PRIMARY KEY (MERCHANT_ID)
);

/**
商家积分明细表;对于商家发布的任务积分，显示任务，点击这个任务，可以查看具体哪些用户获得了这个任务积分
 */
CREATE TABLE T_MERCHANT_SHIP_POINT(
  POINT_ID INT NOT NULL AUTO_INCREMENT,/*自增主键*/
  MERCHAN_ID VARCHAR(32),
  POINT INTEGER,/*得到(+)积分或者失去积分(-)*/
  POINT_TYPE VARCHAR(4),/*获得或者失去积分的途径；应该有专门的定义：比如：01:注册；02:邀请注册等等*/
  BEFORE_POINT INTEGER,/*未获得(或失去)积分前的可用积分*/
  AFTER_POINT INTEGER,/*获得（或失去）积分后的可用积分*/
  POINT_NOTE VARCHAR(64),/*对本次积分的说明*/
  CRT_TIME TIMESTAMP,
  PRIMARY KEY(POINT_ID)
)

-----------------------------------------------------------------
/**
 * 用户广告信息表
 */
CREATE TABLE T_USER_ADVERTISE ( 
	AD_PLACE_ID VARCHAR(100) NULL,--广告位ID
	USER_ID 	VARCHAR(100) NULL,--拥有广告位的用户ID
	MERCHANT_ID VARCHAR(100) NULL,--发布广告信息的用户ID
	AD_ID 		VARCHAR(100) NOT NULL,--广告ID
	SECTOR_ID  	VARCHAR(100) NOT NULL, --隶属板块
	AD_STATUS   VARCHAR(25) NOT NULL,--用户地址状态？有枚举？
	PRIMARY KEY(AD_PLACE_ID, OWER_ID)
);

/**
 * 用户广告信息明细表
 */
CREATE TABLE T_USER_ADVERTISE_DETAIL ( 
	AD_ID 			VARCHAR(100) NOT NULL,
	AD_NAME 		VARCHAR(100) NOT NULL,--广告关键字
	AD_DESC			VARCHAR(1000) NOT NULL,--广告描述
	AD_LEVEL   		VARCHAR(25) NOT NULL,--广告等级，优先级，这个最好设定枚举做关联
	AD_PICTURE		VARCHAR(500) NOT NULL,--广告图片的全地址访问路径
	AD_PICTURE1		VARCHAR(500) NOT NULL,--广告图片的全地址访问路径
	AD_PICTURE2		VARCHAR(500) NOT NULL,--广告图片的全地址访问路径
	AD_PICTURE3		VARCHAR(500) NOT NULL,--广告图片的全地址访问路径
	AD_PICTURE4		VARCHAR(500) NOT NULL,--广告图片的全地址访问路径
	APPLY_TIME    	TIMESTAMP NULL,--申请日期
	CRT_TIME		TIMESTAMP NULL,--审核通过日期
	PRIMARY KEY(AD_ID)
);

/**
 * 广告评论表
 */
CREATE TABLE T_USER_ADVERTISE_COMMENTS(
   COMMENT_ID VARCHAR(32) NOT NULL,
   AD_ID VARCHAR(100) NOT NULL,
   USER_ID VARCHAR(100) NULL,--评论人的ID
   CO_DESC VARCHAR(400) NOT NULL,--评论描述
   CRT_TIME TIMESTAMP NOT NULL,
   PRIMARY KEY(COMMENT_ID)
);
-----------------------------------------------------------------
/**
 * 任务表
 */
CREATE TABLE T_TASKS(
  USER_ID VARCHAR(32) NOT NULL,/*所属商家；平台也是一个商家*/
  SECTOR_ID VARCHAR(32) NOT NULL,
  TASK_ID VARCHAR(32) NOT NULL,
  TASK_NAME VARCHAR(64) NOT NULL,
  TASK_TYPE CHAR(2),/*任务类型，注册邀请这个应该属于平台任务，非商家创建；00:平台任务；10:板块任务*/
  TASK_RULE VARCHAR(32),/*？？？？任务规则；定义一个规则的工具集，处理每个规则，比如：注册邀请3人的平台任务，在处理用户任务时，调用次规则方法；每增加一个规则就需要增加一个规则方法；定义成可配置的*/
  TASK_STATUS CHAR(2),/*00:未发布；01:发布；02:锁定；03:完成*/
  TASK_SCORE INTEGER,/*任务积分*/
  TASK_CONTENT BLOB,/*任务内容，图文结合的HTML字符串*/
  APPOINTMENT_NUM INTEGER,/*预约号码，如果任务非常紧张，当商家发布任务时，进入排对队列(是否还需要一个对列表呢？？？？)*/
  START_TIME TIMESTAMP ,/*任务开始时间*/
  STOP_TIME TIMESTAMP ,/*任务结束时间*/
  CRT_TIME TIMESTAMP ,/*创建时间*/
  PRIMARY KEY(MERCHANT_ID,SECTOR_ID,TASK_ID)
);

/**
 * 任务规则表
 * 当前表还需要好好的思考与设计
 */
CREATE TABLE T_TASK_RULES(
	RULE_ID VARCHAR(32) NOT NULL,
	RULE_NAME VARCHAR(32) NOT NULL,
	RULE_CONTENT VARCHAR(256),/*规则内容*/
	RULE_CLASS VARCHAR(64),/*解析规则的类;这样每次有新的规则，只要调用这个解析类就行。这个解析类应该有专门的父类以及固定的方法；
	但是对于今天邀请3个人；明天改为邀请5个，1个的怎么办呢？设计一个规则参数扩展表，在规则中插入特殊化的参数，到解析类中解析这个参数*/
	PRIMARY KEY(RULE_ID)
);

/**
 * 任务规则扩展表，需要设计一个专门的工具类进行解析此内容；并固定一些常用的参数。
 * 这些参数应该放到缓存中，并可刷新
 */
CREATE TABLE T_TASK_RULE_EXPAND(
	PARAM_NAME VARCHAR(32) NOT NULL,/*特殊格式的参数，比如：{{INVITE_REG_NUM}}邀请注册的个数*/
	PARAM_DESC VARCHAR(32) NOT NULL,/*参数说明*/
	NOTE VARCHAR(64),
	PRIMARY KEY (PARAM_NAME);/*参数必须唯一*/
)

/**
 * 用户任务表
 */
CREATE TABLE T_USER_TASK(
  USER_ID VARCHAR(32) NOT NULL,
  TASK_ID VARCHAR(32) NOT NULL,
  TASK_STATUS CHAR(2),/*用户任务表，也需要标志任务状态，此状态是用户对于任务；01:领取；02:完成；03:失败；04:放弃*/
  TASK_TIME TIMESTAMP,
  TASK_NOTE VARCHAR(64),/*用户任务说明，比如放弃任务时*/
  PRIMARY KEY(USER_ID,TASK_ID)
)
-----------------------------------------------------------------

