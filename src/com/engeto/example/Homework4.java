package com.engeto.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Homework4 {
    public static void printHomework(int num1, int num2) {
        // 4. Napište program, který vezme 2 čísla (a,b) a spočítá druhou mocninu všech čísel mezi a a b včetně <a,b>.
        System.out.println("Homework4");
        List<Integer> list = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        int num = num1;
        while(num <= num2) {
            list.add(num);
            num++;
        }
        System.out.println("Original list made from numbers <" + num1 + "," + num2 + "> : " + list.toString());

        // Calculating and outputting each number on the power of 2
        Stream<Integer> stream = list.stream();
        stream.forEach((value) -> result.add( (Math.pow(value, 2))));
        System.out.println("Power of 2: " + result.toString());
    }
}
