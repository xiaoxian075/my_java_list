package com.at;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * 默认使用tomcat启动
 */
@SpringBootApplication
@MapperScan("com.at.entity.mapper")//配置数据库印射类包
@ComponentScan({
        "com.at",//配置项目的控制器，服务等目录扫描
        "com.at.frame.*"//自动化框架初始的包配置，如果要使用自动化功能，该配置为必须
})
public class SprintBootBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootBasicApplication.class, args);
	}
}
