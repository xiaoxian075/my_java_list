package com.atencn.netty.codec;

import com.atencn.netty.config.BasicConfig;
import com.atencn.netty.proto.PBData;
import com.google.protobuf.Any;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

/**
 * Created by Administrator on 2017/8/28.
 */
public class NettyDataHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyDataHandler.class);
    private static final PBData.Data PONG = PBData.Data.newBuilder().setCmd(BasicConfig.PINGPONG_CMD).setSub(BasicConfig.PINGPONG_SUB).build();

    private NettyDataHandlerParse nettyDataHandlerParse;
    private Consumer<ChannelHandlerContext> reconnection;

    public void setReconnection(Consumer<ChannelHandlerContext> reconnection) {
        this.reconnection = reconnection;
    }

    public void setNettyDataHandlerParse(NettyDataHandlerParse nettyDataHandlerParse) {
        this.nettyDataHandlerParse = nettyDataHandlerParse;
    }

    /**
     * 连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        nettyDataHandlerParse.active(ctx);
    }

    /**
     * 失去连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        nettyDataHandlerParse.inactive(ctx);
        if (reconnection != null) {
            reconnection.accept(ctx);
        }
    }

    /**
     * 数据到达
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        PBData.Data data = (PBData.Data) msg;
        final int cmd = data.getCmd();
        final int sub = data.getSub();
        final Any any = data.getData();
        if (cmd == BasicConfig.PINGPONG_CMD && sub == BasicConfig.PINGPONG_SUB) {
            ctx.writeAndFlush(PONG);
            return;
        }
        nettyDataHandlerParse.call(cmd, sub, any, ctx);
    }

    /**
     * 链路异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("链路异常", cause);
        ctx.close();
    }
}
