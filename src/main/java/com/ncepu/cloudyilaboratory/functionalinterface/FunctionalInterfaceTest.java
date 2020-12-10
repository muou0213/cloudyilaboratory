package com.ncepu.cloudyilaboratory.functionalinterface;

import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceTest {

    private static final String stringToPrint = "good work";

    public void testStringPrint(PrintStringFunctionalInterface printString) {
        printString.printString(stringToPrint);
    }

    public void printString(String a) {
        System.out.println(a);
    }

    public static void staticPrintString(String a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        FunctionalInterfaceTest test = new FunctionalInterfaceTest();
        // lambda express method reference
        test.testStringPrint(a -> System.out.println(a));
        // instance :: methodName method reference
        test.testStringPrint(test :: printString);
//        test.testStringPrint(FunctionalInterfaceTest :: printString);
        // Class :: methodName method reference
        test.testStringPrint(FunctionalInterfaceTest::staticPrintString);


        List<String> strings = Arrays.asList("a", "c");

//        strings.forEach();


        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

    }

}
