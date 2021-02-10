package com.engeto.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Homework2 {
    public static void printHomework() {
        // 2. Napište program, který přečte soubor (priklad2.txt) a spočítá počet znaků na každém řádku,
        // který neobsahuje číslici.

        // file loading
        try (BufferedReader inputStream = new BufferedReader( new FileReader("resources\\priklad2.txt"));) {
            System.out.println("Homework 2");
            Stream<String> stream1 = inputStream.lines();
            // filtering out lines with numbers and outputting the size of the string
            stream1
                    .filter((value) -> !value.matches(".*\\d.*"))
                    .forEach((value) -> {
                        System.out.println(value);
                        System.out.println( "This line has " + value.length() + " symbols");
                        System.out.println();
                    });
            System.out.println("-----------------------------------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
