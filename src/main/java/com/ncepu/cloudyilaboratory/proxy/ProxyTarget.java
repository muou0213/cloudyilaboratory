package com.ncepu.cloudyilaboratory.proxy;

public class ProxyTarget implements InterfaceA, InterfaceB{
    @Override
    public void methodA() {
        System.out.println("proxy target method a");
    }

    @Override
    public void methodB() {
        System.out.println("proxy target method b");
    }
}
