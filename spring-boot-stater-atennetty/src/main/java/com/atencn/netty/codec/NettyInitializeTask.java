package com.atencn.netty.codec;

import com.atencn.netty.config.BasicConfig;
import com.atencn.netty.properties.ConfigProperties;
import com.atencn.netty.proto.PBData;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/25.
 */
@Component
public class NettyInitializeTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyInitializeTask.class);
    private static final PBData.Data PING = PBData.Data.newBuilder().setCmd(BasicConfig.PINGPONG_CMD).setSub(BasicConfig.PINGPONG_SUB).build();

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private NettyDataHandlerParse nettyDataHandlerParse;


    public NettyInitializeTask() {

    }


    public void start() {
        int port = configProperties.getPort();
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new IdleStateHandler(20, 30, 10));
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                                    if (evt instanceof IdleStateEvent) {
                                        IdleState state = ((IdleStateEvent) evt).state();
                                        if (state.equals(IdleState.ALL_IDLE)) {
                                            //发送ping
                                            ctx.channel().writeAndFlush(PING);
                                        } else if (state.equals(IdleState.READER_IDLE)) {
                                            //超时读
                                            LOGGER.error("读超时，关闭链路");
                                            ctx.close();
                                        }
                                    }
                                    super.userEventTriggered(ctx, evt);
                                }
                            });
                            //半包处理
                            ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                            //解码目标类
                            ch.pipeline().addLast(new ProtobufDecoder(PBData.Data.getDefaultInstance()));
                            ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                            ch.pipeline().addLast(new ProtobufEncoder());
                            NettyDataHandler nettyDataHandler = new NettyDataHandler();
                            nettyDataHandler.setNettyDataHandlerParse(nettyDataHandlerParse);
                            ch.pipeline().addLast(nettyDataHandler);
                        }
                    });
            ChannelFuture future = serverBootstrap.bind(port).sync();
            LOGGER.info("Netty服务器启动成功，监听端口：{}", port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            LOGGER.error("服务器启动异常", e);
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
