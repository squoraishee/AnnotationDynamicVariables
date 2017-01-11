package com.example;

import java.lang.reflect.Method;

public class PrimaryRunner {

    public static void main(String [] args) {

        try {

            /* Test method before incrementing the counter by Instantiating Counter Object*/
            testMethod();

            for(int i = 0; i < 10; i++) {
                new CounterObject();
            }

            /* Test method after incrementing the counter by Instantiating Counter Object*/
            testMethod();

            new CounterObject();

            testMethod();


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @TestAnnotation(xpath = "Value of counter in xpath = [x]", counter = CounterObject.Counter.VALUE)
    public static void testMethod() throws NoSuchMethodException {
        Method command = PrimaryRunner.class.getDeclaredMethod("testMethod");
        TestAnnotation annotation = command.getAnnotation(TestAnnotation.class);
        print(annotation.xpath().replace("[x]", annotation.counter().toString()));
    }

    public static void print(String value) {
        System.out.println(value);
    }
}
