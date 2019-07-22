DROP DATABASE IF EXISTS `game`;
CREATE DATABASE `game`;
USE `game`;
#房子表
DROP TABLE IF EXISTS `game_house`;
CREATE TABLE  `game_house`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    region VARCHAR(20)  NOT NULL ,
    type_id INT NOT NULL,
    price  FLOAT NOT NULL,
    prices FLOAT,
    goodDegrees FLOAT NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `game_house` VALUES(DEFAULT,'daxuecheng',1,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'daxuecheng',2,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'jinrongzhongxin',1,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'jinrongzhongxin',2,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'rencaichuangyeyuan',1,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'rencaichuangyeyuan',2,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'renmingongyuan',1,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'renmingongyuan',2,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'dawangzhongxincun',1,600,600,0.2);
INSERT INTO `game_house` VALUES(DEFAULT,'dawangzhongxincun',2,600,600,0.2);
#用户表
DROP TABLE IF EXISTS `game_user`;
CREATE TABLE  `game_user`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username  VARCHAR(20),
    phone VARCHAR(11),
    address VARCHAR(60),
    money FLOAT ,
    uuid VARCHAR(20)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `game_user` VALUES(DEFAULT,'test001','15297973901','广东省深圳市福田区深南中路204号',9999999999999,'123456');
#房子类型表
DROP TABLE IF EXISTS `house_type`;
CREATE TABLE  `house_type`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_name VARCHAR(15) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `house_type` VALUES(DEFAULT,'单房');
INSERT INTO `house_type` VALUES(DEFAULT,'两房一厅');
#建材类型
DROP TABLE IF EXISTS `fintment_type`;
CREATE TABLE  `fintment_type`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `type_name` VARCHAR(20) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `fintment_type` VALUES(DEFAULT,'设备');
INSERT INTO `fintment_type` VALUES(DEFAULT,'装修套餐');
#建材表
DROP TABLE IF EXISTS `house_fintment`;
CREATE TABLE  `house_fintment`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL ,
    price FLOAT NOT NULL,
    `describe` VARCHAR(30),
    `type_id` INT NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `house_fintment` VALUES(DEFAULT,'门锁',30,'防盗',1);
INSERT INTO `house_fintment` VALUES(DEFAULT,'烟感报警器',40,'烟感报警器',1);
INSERT INTO `house_fintment` VALUES(DEFAULT,'水表',50,'水表',1);
INSERT INTO `house_fintment` VALUES(DEFAULT,'电表',60,'电表',1);
INSERT INTO `house_fintment` VALUES(DEFAULT,'衣橱',70,'衣橱');
INSERT INTO `house_fintment` VALUES(DEFAULT,'简装修',500,'简装修',2);
INSERT INTO `house_fintment` VALUES(DEFAULT,'精装修',800,'精装修',2);
INSERT INTO `house_fintment` VALUES(DEFAULT,'豪华装修',1000,'豪华装修',2);
#仓库表
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE  `warehouse`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
	fintment_id INT NOT NULL,
    num INT NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `warehouse` VALUES(DEFAULT,1,1,31);
INSERT INTO `warehouse` VALUES(DEFAULT,1,2,32);
INSERT INTO `warehouse` VALUES(DEFAULT,1,3,33);
INSERT INTO `warehouse` VALUES(DEFAULT,1,4,34);
INSERT INTO `warehouse` VALUES(DEFAULT,1,5,35);
INSERT INTO `warehouse` VALUES(DEFAULT,1,6,36);
INSERT INTO `warehouse` VALUES(DEFAULT,1,7,37);
INSERT INTO `warehouse` VALUES(DEFAULT,1,8,38);
#已拥有的房屋
DROP TABLE IF EXISTS `house_my`;
CREATE TABLE  `house_my`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
	house_id INT NOT NULL,
    buy_price FLOAT NOT NULL,
    sell_price FLOAT,
	`status` VARCHAR(100),
    jiaozuri INT,
    shouzuri INT ,
    yizu INT
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `house_my` VALUES(DEFAULT,1,1,600,800,'1,2,3,4',3,5,0);
INSERT INTO `house_my` VALUES(DEFAULT,1,2,600,800,'1,2,3,4',3,5,1);
INSERT INTO `house_my` VALUES(DEFAULT,1,3,600,800,'1,2,3,4',3,5,0);
INSERT INTO `house_my` VALUES(DEFAULT,1,4,600,800,'1,2,3,4',3,5,1);
INSERT INTO `house_my` VALUES(DEFAULT,1,5,600,800,'1,2,3,4',3,5,0);
INSERT INTO `house_my` VALUES(DEFAULT,1,6,600,800,'1,2,3,4',3,5,1);
INSERT INTO `house_my` VALUES(DEFAULT,1,7,600,800,'1,2,3,4',3,5,0);
INSERT INTO `house_my` VALUES(DEFAULT,1,8,600,800,'1,2,3,4',3,5,1);
INSERT INTO `house_my` VALUES(DEFAULT,1,9,600,800,'1,2,3,4',3,5,0);
INSERT INTO `house_my` VALUES(DEFAULT,1,10,600,800,'1,2,3,4',3,5,1);
#可杜绝事件
DROP TABLE IF EXISTS `eradicate_event`;
CREATE TABLE  `eradicate_event`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	message VARCHAR(100) NOT NULL,
    `is` INT NOT NULL,
    `value` FLOAT NOT NULL,
    `status` INT NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `eradicate_event` VALUES(DEFAULT,'租客看你不爽,暴打了你一顿,人品值减少10',4,10,0);
INSERT INTO `eradicate_event` VALUES(DEFAULT,'欺骗租客说房子有家私,人品值减10',4,10,0);
INSERT INTO `eradicate_event` VALUES(DEFAULT,'在马路边,捡到1000元,真好~!',1,1000,1);
INSERT INTO `eradicate_event` VALUES(DEFAULT,'在马路边,捡到1000元,真好~!',1,0.2,0);
INSERT INTO `eradicate_event` VALUES(DEFAULT,'租客说,吃鸡吗?,给了你一瓶可乐,体力值增加5',5,5,1);
INSERT INTO `eradicate_event` VALUES(DEFAULT,'国家提高了对公寓的扶持,现金增加5%',1,0.05,1);
INSERT INTO `eradicate_event` VALUES(DEFAULT,'租客对公寓不满带头起义,现金减少10%',1,0.1,0);
INSERT INTO `eradicate_event` VALUES(DEFAULT,'小偷进入公寓,现金减少30%',1,0.3,0);
INSERT INTO `eradicate_event` VALUES(DEFAULT,'帮租客办家私到10楼,体力值减少15',5,15,0);
#运营事件
DROP TABLE IF EXISTS `operate_event`;
CREATE TABLE  `operate_event`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(100) NOT NULL,
    `is` INT NOT NULL,
    `value` FLOAT NOT NULL,
      `type` INT NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `operate_event` VALUES(DEFAULT,'夜黑风高起火夜,由于您的房子没装烟感器,起火啦,现金减少3000~!',1,3000,1);
INSERT INTO `operate_event` VALUES(DEFAULT,'小偷进入租客房间,由于您的房子没装门锁,现金减少2000~!',1,2000,2);
INSERT INTO `operate_event` VALUES(DEFAULT,'爆水管泡烂家私家电,由于您的房子没装水表,现金减少1500~!',1,1500,3);
INSERT INTO `operate_event` VALUES(DEFAULT,'客户利用恶劣手段偷取电,由于您的房子没装电表,现金减少1000~!',1,1000,4);
INSERT INTO `operate_event` VALUES(DEFAULT,'房子漏水啦,由于您的房子没装修,现金减少2000~!',1,2000,5);
#每天要触发的事件
DROP TABLE IF EXISTS `day_event`;
CREATE TABLE  `day_event`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(100) NOT NULL,
    `type` INT NOT NULL,
    `value` FLOAT NOT NULL,
    `status` INT NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `day_event` VALUES(DEFAULT,'正常退房~!',1,0,0);
INSERT INTO `day_event` VALUES(DEFAULT,'业务毁约~!',2,3500,0);
INSERT INTO `day_event` VALUES(DEFAULT,'租客毁约~!',3,3500,1);