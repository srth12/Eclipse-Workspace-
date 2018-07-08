package com.hackerrank.test.docon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ParseNameAndDepartment {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        IntStream.range(0, n).forEach(x ->
        {
            String line = s.nextLine();
            String[] inputs = line.split(" ");
            System.out.println(inputs[0]);
            System.out.println("Name :"+inputs[1].replaceAll("[^a-z]",""));
        });
    }
}
