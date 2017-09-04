package com.at.systemconfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by Administrator on 2017/5/15.
 * Swagger2的配置文件
 */
@Component
@Configurable
public class Swagger2Config {

    @Bean
    public Docket swagger2ApiAdmin(){
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("")
                .groupName("admin")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.at.controller.admin"))
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    public Docket swagger2ApiApp(){
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("")
                .groupName("app")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.at.controller.app"))
                .paths(PathSelectors.any())
                .build();
    }

}
