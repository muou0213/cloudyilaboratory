package com.ncepu.cloudyilaboratory.spi;

public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wangwang");
    }
}
