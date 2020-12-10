package com.ncepu.cloudyilaboratory.proxy;

import java.lang.reflect.Proxy;

public class ProxyDemoStarter {
    public static void main(String[] args) {
        ProxyTarget target = new ProxyTarget();
        LogInvocationHandler handler = new LogInvocationHandler(target);
        InterfaceA a = (InterfaceA) Proxy.newProxyInstance(ProxyTarget.class.getClassLoader(),
                new Class<?>[] {InterfaceA.class, InterfaceB.class},
                handler);
        a.methodA();
        InterfaceB b = (InterfaceB) a;
        b.methodB();
    }
}
