package com.ncepu.cloudyilaboratory.defaultmethod;

/**
 * @Author: yun
 * @Date: created in 7:07 下午 2020/7/11
 **/
public interface InterfaceWithDefaultMethod {
    default void printString(String s) {
        System.out.println(s);
    }

    void test();
}
