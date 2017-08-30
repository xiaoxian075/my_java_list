package com.atencn.netty;

import com.atencn.netty.codec.NettyClientInitializeTask;
import com.atencn.netty.codec.NettyInitializeTask;
import com.atencn.netty.config.BasicConfig;
import com.atencn.netty.properties.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/8/25.
 */
@AutoConfigureAfter
@EnableConfigurationProperties(value = ConfigProperties.class)
@ConditionalOnProperty(prefix = BasicConfig.CONFIG_RREFIX, value = "enable", matchIfMissing = true)
@ComponentScan("com.atencn.netty")
public class NettyStarter {

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private NettyInitializeTask nettyInitializeTask;
    @Autowired
    private NettyClientInitializeTask nettyClientInitializeTask;

    public NettyStarter() {

    }

    @PostConstruct
    public void start() {
        if (configProperties.isServer()) {
            nettyInitializeTask.start();
        } else {
            nettyClientInitializeTask.start();
        }
    }
}
