package com.atencn.netty.codec;

import com.atencn.netty.beans.CmdHandler;
import com.atencn.netty.beans.HandlerAop;
import com.atencn.netty.beans.SubHandler;
import com.atencn.netty.beans.SubMethod;
import com.esotericsoftware.reflectasm.MethodAccess;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/8/30.
 * 方法代理工厂
 */
@Component
public final class ProxyFactory {

    private static final Executor EXECUTOR = Executors.newCachedThreadPool();

    @Autowired(required = false)
    private HandlerAop handlerAop;

    //命令处理器
    private HashMap<Integer, HashMap<Integer, SubMethod>> commands = new HashMap<>();

    public void invoke(int cmd, int sub, Any data, ChannelHandlerContext ctx) throws InvalidProtocolBufferException {
        HashMap<Integer, SubMethod> subMethods = commands.get(Integer.valueOf(cmd));
        if (subMethods == null) {
            throw new IllegalArgumentException("不存在的cmd命令:" + cmd);
        }
        final SubMethod method = subMethods.get(Integer.valueOf(sub));
        if (method == null) {
            throw new IllegalArgumentException("不存在的sub命令:" + sub);
        }
        EXECUTOR.execute(() -> {
            Request request = new Request();
            request.setCmd(cmd);
            request.setSub(sub);
            request.setChannelHandlerContext(ctx);
            if (handlerAop != null && !handlerAop.before(request, method)) {
                return;
            }
            if (data.getValue().size() > 0) {
                if (method.getClassType() != Any.class) {
                    try {
                        request.setData(data.unpack(method.getClassType()));
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    request.setData(data);
                }
            }
            method.getMethod().invoke(method.getHandler(), method.getMethodName(), request);
            if (handlerAop != null) {
                handlerAop.after(request, method);
            }
        });
    }

    public void dataHandlerParse(Map<String, Object> handlers) {
        if (handlers == null || handlers.size() < 1) return;
        Object handler;
        Method[] methods; //操作类的方法
        Method method;
        MethodAccess methodAccess; //反射类
        CmdHandler cmd;//操作类的子命令
        SubHandler sub;//操作类的子命令
        SubMethod subMethod;
        HashMap<Integer, SubMethod> subMethods;
        int j, methodSize, cmdOrder;
        Set<String> handlerNames = handlers.keySet();
        for (String handlerName : handlerNames) {
            handler = handlers.get(handlerName);
            cmd = handler.getClass().getAnnotation(CmdHandler.class);
            //对handler进行方法解析
            methodAccess = MethodAccess.get(handler.getClass());
            cmdOrder = cmd.order();
            methods = handler.getClass().getDeclaredMethods();
            if (methods != null && (methodSize = methods.length) > 0) {
                for (j = 0; j < methodSize; j++) {
                    method = methods[j];
                    sub = method.getAnnotation(SubHandler.class);
                    if (sub != null) {
                        subMethods = commands.get(Integer.valueOf(cmdOrder));
                        if (subMethods == null) {
                            subMethods = new HashMap<>();
                            commands.put(Integer.valueOf(cmdOrder), subMethods);
                        }
                        subMethod = new SubMethod();
                        subMethod.setHandler(handler);
                        subMethod.setClassType(sub.type());
                        subMethod.setMethodName(method.getName());
                        subMethod.setMethod(methodAccess);
                        subMethods.put(Integer.valueOf(sub.order()), subMethod);
                    }
                }
            }
        }
    }

}
