package com.atencn.netty.properties;

import com.atencn.netty.config.BasicConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/25.
 */
@Component
@ConfigurationProperties(prefix = BasicConfig.CONFIG_RREFIX)
public class ConfigProperties {

    //Netty监听端口
    private int port = 8888;
    private String host = "127.0.0.1";
    private boolean autoReconnect = true;
    private boolean server = true;

    public boolean isServer() {
        return server;
    }

    public void setServer(boolean server) {
        this.server = server;
    }

    public void setAutoReconnect(boolean autoReconnect) {
        this.autoReconnect = autoReconnect;
    }

    public boolean isAutoReconnect() {
        return autoReconnect;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}
