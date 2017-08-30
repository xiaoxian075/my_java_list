package com.atencn.netty.beans;

import com.atencn.netty.codec.Request;

/**
 * Created by Administrator on 2017/8/30.
 */
public abstract class HandlerAop {

    public abstract boolean before(Request request, SubMethod method);

    public abstract void after(Request request, SubMethod method);
}
