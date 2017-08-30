package com.atencn.netty.codec;

import com.atencn.netty.proto.PBData;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Administrator on 2017/8/30.
 */
public class Request<T> {
    private int cmd;
    private int sub;
    private T data;
    private ChannelHandlerContext channelHandlerContext;


    public static <T extends Message> PBData.Data builderData(int cmd, int sub, T data) {
        PBData.Data.Builder dataBuilder = PBData.Data.newBuilder();
        dataBuilder.setCmd(cmd);
        dataBuilder.setSub(sub);
        if(data != null) dataBuilder.setData(Any.pack(data));
        return dataBuilder.build();
    }

    public <T extends Message> void writeAndFlush(int cmd, int sub, T data) {
        channelHandlerContext.writeAndFlush(builderData(cmd, sub, data));
    }

    public static <T extends Message> void writeAndFlush(ChannelHandlerContext ctx, int cmd, int sub, T data) {
        ctx.writeAndFlush(builderData(cmd, sub, data));
    }

    public static <T extends Message> void write(ChannelHandlerContext ctx, int cmd, int sub, T data) {
        ctx.writeAndFlush(builderData(cmd, sub, data));
    }

    public <T extends Message> void write(int cmd, int sub, T data) {
        channelHandlerContext.write(builderData(cmd, sub, data));
    }

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ChannelHandlerContext getChannelHandlerContext() {
        return channelHandlerContext;
    }

    public void setChannelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }
}
