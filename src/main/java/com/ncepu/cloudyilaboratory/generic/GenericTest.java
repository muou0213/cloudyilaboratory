package com.ncepu.cloudyilaboratory.generic;

import java.lang.reflect.TypeVariable;
import java.util.List;

public class GenericTest {

    private static void display(Object o) {
        System.out.println(o.getClass().getName());
    }

    public static void main(String[] args) {
       /* Apple apple0 = new Apple();
        RedApple redApple0 = new RedApple();
        Food food0 = new Food();
        // compile error
//        List<? extends Fruit> flist = Arrays.asList(apple0, redApple0, food0);
        List<? extends Fruit> flist = new ArrayList<>();

        Food food = new Food();
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        RedApple redApple = new RedApple();

        // compile error
//        flist.add(apple);
        // compile error
//        flist.add(fruit);

        Fruit fruit1 = flist.get(1);
        System.out.println(fruit1.getClass().getName());

//        GenericTest.display(11);

        GenericTest test = new GenericTest();
        test.eatFruits(Arrays.asList(apple0, apple));
        test.eatFruits(Arrays.asList(redApple0, redApple));
        List<? super Fruit> fruits = Arrays.asList(apple0, apple);
        fruits.add(redApple);
        // compile error
//        Fruit fruit2 = fruits.get(0);
        test.getClass().getGenericInterfaces();*/


       /* Map<String, String> strings = new HashMap<>();
        Set<Map.Entry<String, String>> entries = strings.entrySet();*/

        GenericClass<Integer> genericClass = new GenericClass<>();
        TypeVariable<? extends Class<? extends GenericClass>>[] typeParameters =
                genericClass.getClass().getTypeParameters();

        System.out.println(typeParameters[0].getName());

    }

    private void eatFruits(List<? extends Fruit> fruits) {
        for(Fruit fruit : fruits) {
            fruit.eat();
        }
    }
}
