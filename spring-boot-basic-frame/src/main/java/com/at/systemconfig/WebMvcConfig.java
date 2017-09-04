package com.at.systemconfig;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by Administrator on 2017/4/20.
 */
@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    /**
     * 静态资源目录配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
