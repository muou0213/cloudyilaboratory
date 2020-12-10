package com.ncepu.cloudyilaboratory.generic.enums;

import java.lang.reflect.ParameterizedType;

public abstract class MyEnum<E extends MyEnum<E>> implements Comparable<E>{
    public void test() {
        E a = null, b = null;
        a.compareTo(b);
    }


    private int ordinal;

    @Override
    public int compareTo(E o) {
        MyEnum<?> other = o;
        MyEnum<E> self = this;
        return self.ordinal - other.ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }



    abstract E getSelf();

    public static void main(String[] args) {
        Color color = new Color();
        Color.BlackWhiteColor blackWhiteColor = color.new BlackWhiteColor();

       /* Animal animal = new Animal();

        System.out.println(animal.compareTo(blackWhiteColor));*/

        System.out.println(((ParameterizedType)color.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}

class Color extends MyEnum<Color> {
    public Color() {
        setOrdinal(1);
    }

    @Override
    Color getSelf() {
        return this;
    }

    class BlackWhiteColor extends Color {
        public BlackWhiteColor() {
            Color.this.setOrdinal(0);
        }
    }
}

/*class Animal extends MyEnum<Color> {
    public Animal() {
        setOrdinal(-1);
    }

    @Override
    Color getSelf() {
        return this.getClass().getGenericSuperclass();
    }
}*/


