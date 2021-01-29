package com.engeto.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Homework1 {

    public static void printHomework() {
        // 1. Napište program, který vezme pole Stringu A, b, C, De, fF, gHiJK, LmN a vrátí počet kapitálek v nejdelším retězci.
        String[] arr = {"A", "b", "C", "De", "fF", "gHiJK", "LmN"};
        Stream<String> stream = Stream.of(arr);
        // Filtering out all except the longest string
        String longestString = stream.max(Comparator.naturalOrder()).get();
        // Transforming String into stream
        Stream<String> stream2 = longestString.chars().mapToObj(c -> String.valueOf((char) c));
        // Filtering out lower case letters and counting the number of remaining letters(capital)
        long countOfCapitalLettersInTheLongestString = stream2
                .filter(value -> value.toUpperCase() == value)
                .count();
        System.out.println("Homework 1 ");
        System.out.println("Input Array: "+Arrays.toString(arr));
        System.out.println("Number of capital letters in the longest string: "+countOfCapitalLettersInTheLongestString);
        System.out.println("-----------------------------------------------");
    }

}
