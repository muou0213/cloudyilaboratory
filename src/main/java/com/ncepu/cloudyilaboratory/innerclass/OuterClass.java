package com.ncepu.cloudyilaboratory.innerclass;

public class OuterClass {
    private static class StaticInnerClass {
        private static final String s = "hello world";
    }

    private class InnerClass {
        private String s1;

        public InnerClass() {
            this.s1 = "hanmeimei";
        }
    }

    public static void main(String[] args) {
        System.out.println(StaticInnerClass.s);
        InnerClass innerClass = new OuterClass().new InnerClass();
    }
}
