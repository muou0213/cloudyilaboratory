package com.ncepu.cloudyilaboratory.interview;

public class TestIntegerPlusPlus {
    public static void main(String[] args) {
        Integer a = new Integer(100);
        // -127到128范围内的同一个integer，
        // 以外的会调用Integer.valueOf生成一个新对象
        a++;
    }
}
