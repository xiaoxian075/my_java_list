package com.atencn.netty.codec;

import com.atencn.netty.properties.ConfigProperties;
import com.atencn.netty.proto.PBData;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/8/25.
 */
@Component
public class NettyClientInitializeTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClientInitializeTask.class);

    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private NettyDataHandlerParse nettyDataHandlerParse;
    private long seconds = 3L;
    private EventLoopGroup workGroup;

    public NettyClientInitializeTask() {

    }

    @PostConstruct
    private void init() {
        this.workGroup = new NioEventLoopGroup();
    }

    public void resetConn() {
        LOGGER.info("将在{}s后尝试重新连接服务器...", seconds);
        workGroup.schedule(() -> {
            if (seconds > 60L) seconds = 3L;
            start();
        }, seconds++, TimeUnit.SECONDS);
    }

    public void start() {
        int port = configProperties.getPort();
        String host = configProperties.getHost();
        boolean autoReconnect = configProperties.isAutoReconnect();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //半包处理
                            ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                            //解码目标类
                            ch.pipeline().addLast(new ProtobufDecoder(PBData.Data.getDefaultInstance()));
                            ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                            ch.pipeline().addLast(new ProtobufEncoder());
                            NettyDataHandler nettyDataHandler = new NettyDataHandler();
                            nettyDataHandler.setNettyDataHandlerParse(nettyDataHandlerParse);
                            if (autoReconnect) {
                                nettyDataHandler.setReconnection(ctx -> {
                                    seconds = 3L;
                                    resetConn();
                                });
                            }
                            ch.pipeline().addLast(nettyDataHandler);
                        }
                    });
            //异常连接操作
            ChannelFuture future = bootstrap.connect(host, port).sync().addListener(f -> {
                if (!f.isSuccess()) {
                    resetConn();
                }
            });
            //等待链路关闭
            //future.channel().closeFuture().sync();
        } catch (Exception e) {
            LOGGER.error("连接异常", e);
            resetConn();
        }
    }
}
