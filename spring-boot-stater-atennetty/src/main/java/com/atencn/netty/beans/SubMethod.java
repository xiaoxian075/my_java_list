package com.atencn.netty.beans;

import com.esotericsoftware.reflectasm.MethodAccess;

public class SubMethod {
    private Object handler;
    private Class classType;
    private String methodName;
    private MethodAccess method;

    public Object getHandler() {
        return handler;
    }

    public void setHandler(Object handler) {
        this.handler = handler;
    }

    public Class getClassType() {
        return classType;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodAccess getMethod() {
        return method;
    }

    public void setMethod(MethodAccess method) {
        this.method = method;
    }
}