package com.engeto.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Homework3 {
    // 3. Napište program, který přečte dva soubory (priklad3_1.txt, priklad3_2.txt),
    // vezme všechna čísla a spočítá jejich průměr zaokrouhlený na 2 desetinná místa.
    public static void printHomework() {
        System.out.println("Homework 3");
        try (Scanner scanner1 = new Scanner( new BufferedReader( new FileReader("resources\\priklad3_1.txt")));
             Scanner scanner2 = new Scanner( new BufferedReader( new FileReader("resources\\priklad3_2.txt")));) {
            // all numbers will be saved as doubles in a list
            // 1st file reading
            List<Double> list1 = new ArrayList<>();
            while(scanner1.hasNext()) {
                String num = scanner1.next();
                list1.add(Double.valueOf(num));
            }
            // 2nd file reading
            List<Double> list2 = new ArrayList<>();
            while(scanner2.hasNext()) {
                String num = scanner2.next();
                list2.add(Double.valueOf(num));
            }
            // creating Supplier for the joined streams
            Supplier<Stream<Double>> streamSupplier =
                    () -> Stream.concat( list1.stream(), list2.stream());
            // joining streams together and calculating number of elements
            Stream<Double> joinedStream1 = streamSupplier.get();
            long count = joinedStream1.count();

            // joining streams together + reducing the stream and calculating average
            Stream<Double> joinedStream2 = streamSupplier.get();
            Optional<Double> reducedStream = joinedStream2.reduce((value, combinedValue) -> combinedValue + value);
            Double average = reducedStream.get() / (double) count;

            // printing results
            System.out.println("First file: " + list1.toString());
            System.out.println("Second file: " + list2.toString());
            System.out.println("Number of elements: " + count);
            System.out.println("The average of all the numbers is: " + String.format("%.2f", average));
            System.out.println("-----------------------------------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
