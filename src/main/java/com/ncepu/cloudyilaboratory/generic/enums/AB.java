package com.ncepu.cloudyilaboratory.generic.enums;

/**
 * @Author: yun
 * @Date: created in 9:50 下午 2020/7/10
 **/
public enum AB {
    A {
        public void print() {
            System.out.println("A");
        }
    },

    B {
        public void print() {
            System.out.println("B");
        }
    },
    C;

    public static void main(String[] args) {
        System.out.println((A.getClass().getSuperclass().getSuperclass().getTypeParameters()).length);
    }
}
