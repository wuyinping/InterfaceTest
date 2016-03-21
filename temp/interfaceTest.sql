--项目主表
CREATE TABLE `project_main` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '项目表主键' ,
`name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称' ,
`key`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目加密key' ,
`version`  int(20) NOT NULL DEFAULT 0 COMMENT '项目数据版本号，防止幻读（目前先不启用）' ,
`del_flag`  int(4) NOT NULL DEFAULT 0 COMMENT '删除标记，0有效；1删除' ,
`mtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据时间戳' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_index` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;

--项目测试地址关联表
CREATE TABLE `project_url` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '项目测试地址表主键' ,
`project_id`  int(20) NOT NULL COMMENT '外键：对应项目id' ,
`base_url`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目测试地址基址' ,
`url_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目测试地址标志名(例如：online)' ,
`del_flag`  int(4) NOT NULL DEFAULT 0 COMMENT '数据删除标记，0有效；1删除' ,
`mtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据时间戳' ,
PRIMARY KEY (`id`),
CONSTRAINT `foreign_key` FOREIGN KEY (`project_id`) REFERENCES `project_main` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
UNIQUE INDEX `id_index` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;

--项目版本关联表
CREATE TABLE `project_version` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '项目版本表主键' ,
`project_id`  int(20) NOT NULL COMMENT '外键：项目主表id' ,
`version_code`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '项目版本号' ,
`del_flag`  int(4) NOT NULL DEFAULT 0 COMMENT '删除标记：0有效；1删除' ,
`mtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据时间戳' ,
PRIMARY KEY (`id`),
CONSTRAINT `foreign_key2` FOREIGN KEY (`project_id`) REFERENCES `project_main` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
UNIQUE INDEX `id_index` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;

--项目公共上行关联表
CREATE TABLE `project_common` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '项目公共上行关联表主键' ,
`project_id`  int(20) NOT NULL COMMENT '外键：项目id' ,
`def_field1`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value1`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field2`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value2`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field3`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value3`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field4`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value4`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field5`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value5`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field6`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value6`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field7`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value7`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field8`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value8`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field9`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value9`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field10`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value10`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field11`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value11`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field12`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value12`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field13`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value13`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field14`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value14`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field15`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value15`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field16`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value16`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field17`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value17`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field18`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value18`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field19`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value19`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field20`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value20`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field21`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value21`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field22`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value22`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field23`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value23`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field24`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value24`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field25`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value25`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field26`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value26`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field27`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value27`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field28`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value28`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field29`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value29`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`def_field30`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段' ,
`def_value30`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目公共上行字段值' ,
`del_flag`  int(4) NOT NULL DEFAULT 0 COMMENT '数据删除标记：0有效；1删除' ,
`mtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据时间戳' ,
PRIMARY KEY (`id`),
CONSTRAINT `foreign_key3` FOREIGN KEY (`project_id`) REFERENCES `project_main` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
UNIQUE INDEX `id_index` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;

--接口表
CREATE TABLE `interface_main` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '接口主键' ,
`version_id`  int(20) NOT NULL DEFAULT 0 COMMENT '外键：所属项目版本号（0为全部版本适用）' ,
`tag`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口tag号' ,
`url`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口请求地址' ,
`description`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口描述' ,
`usekey`  int(4) NOT NULL DEFAULT 1 COMMENT '是否加密接口：0不加密；1加密' ,
`request_type`  int(4) NOT NULL DEFAULT 0 COMMENT '请求方式：0 post；1 get' ,
`c_interface`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应后端接口' ,
`table`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应数据库表' ,
`def_field1`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field2`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field3`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field4`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field5`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field6`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field7`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field8`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field9`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field10`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field11`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field12`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field13`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field14`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`def_field15`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数名' ,
`del_flag`  int(4) NOT NULL DEFAULT 0 COMMENT '数据删除标记：0有效；1删除' ,
`mtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据时间戳' ,
PRIMARY KEY (`id`),
CONSTRAINT `foreign_key4` FOREIGN KEY (`version_id`) REFERENCES `project_version` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
UNIQUE INDEX `id_index` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;

--用例表
CREATE TABLE `usecase_main` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '用例表id' ,
`interface_id`  int(20) NOT NULL COMMENT '外键：接口主键' ,
`description`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用例描述' ,
`def_value1`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value2`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value3`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value4`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value5`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value6`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value7`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value8`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value9`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value10`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value11`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value12`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value13`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value14`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`def_value15`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口上行参数值' ,
`del_flag`  int(4) NOT NULL DEFAULT 0 COMMENT '数据删除标志：0有效；1删除' ,
`mtime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据时间戳' ,
PRIMARY KEY (`id`),
CONSTRAINT `foreign_key5` FOREIGN KEY (`interface_id`) REFERENCES `interface_main` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
UNIQUE INDEX `id_index` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;

--期望结果表
CREATE TABLE `expect_main` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '用例期望结果主键' ,
`usecase_id`  int(20) NOT NULL COMMENT '外键：用例id' ,
`expect`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '期望结果json串' ,
`del_flag`  int(4) NOT NULL DEFAULT 0 COMMENT '数据删除标记：0有效；1删除' ,
`mtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据时间戳' ,
PRIMARY KEY (`id`),
CONSTRAINT `foreign_key6` FOREIGN KEY (`usecase_id`) REFERENCES `usecase_main` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
UNIQUE INDEX `id_index` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;
