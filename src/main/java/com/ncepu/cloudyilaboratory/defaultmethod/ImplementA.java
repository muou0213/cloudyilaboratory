package com.ncepu.cloudyilaboratory.defaultmethod;

import java.util.Arrays;
import java.util.List;

public class ImplementA implements InterfaceWithDefaultMethod {

    @Override
    public void printString(String s) {

    }

    public void test() {
        List<String> stringList = Arrays.asList("a", "b", "c");

        stringList.forEach(s -> System.out.println(s));
    }
}
