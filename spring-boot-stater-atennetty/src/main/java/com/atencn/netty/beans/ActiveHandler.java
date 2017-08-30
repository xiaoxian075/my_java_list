package com.atencn.netty.beans;

import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Administrator on 2017/8/25.
 */
public interface ActiveHandler {

    /**
     * 连接成功
     */
    void active(ChannelHandlerContext ctx);

    /**
     * 丢失连接
     */
    void inactive(ChannelHandlerContext ctx);

}
