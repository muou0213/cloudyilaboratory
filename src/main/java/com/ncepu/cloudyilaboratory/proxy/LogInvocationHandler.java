package com.ncepu.cloudyilaboratory.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {
    private Object proxyTarget;

    public LogInvocationHandler(Object proxyTarget) {
        this.proxyTarget = proxyTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理方法");
        method.invoke(proxyTarget, args);
        return null;
    }
}
