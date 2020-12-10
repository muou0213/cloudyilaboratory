package com.ncepu.cloudyilaboratory.spi;

public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miaomiao");
    }
}
