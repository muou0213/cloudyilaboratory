package com.ncepu.cloudyilaboratory.integertest;

public class IntegerTest {
    public static void main(String[] args) {
        Integer integer = new Integer(1000);

        Integer integer1 = integer++;

        System.out.println("integer1: " + integer1);
        System.out.println("integer: " + integer);

        System.out.println(integer1 == integer);
    }
}
