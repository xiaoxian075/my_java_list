package com.atencn.netty.codec;

import com.atencn.netty.beans.ActiveHandler;
import com.atencn.netty.beans.CmdHandler;
import com.atencn.netty.beans.HandlerAop;
import com.atencn.netty.utils.ApplicationContext;
import com.google.protobuf.Any;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/29.
 */
@Component
public class NettyDataHandlerParse {

    @Autowired
    private ProxyFactory proxyFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired(required = false)
    private ActiveHandler activeHandler;

    @PostConstruct
    private void handlerParse() {
        //由代理类解析对应的命令解析类
        org.springframework.context.ApplicationContext application = applicationContext.getApplication();
        Map<String, Object> beansWithAnnotation = application.getBeansWithAnnotation(CmdHandler.class);
        proxyFactory.dataHandlerParse(beansWithAnnotation);
    }

    public void active(ChannelHandlerContext ctx) {
        if (activeHandler != null) {
            activeHandler.active(ctx);
        }
    }

    public void inactive(ChannelHandlerContext ctx) {
        if (activeHandler != null) {
            activeHandler.inactive(ctx);
        }
    }

    public void call(int cmd, int sub, Any any, ChannelHandlerContext ctx) throws Exception {
        proxyFactory.invoke(cmd, sub, any, ctx);
    }
}
