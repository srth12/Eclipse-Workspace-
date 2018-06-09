package com.hackerrank.test.Zapr;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer sumOfDigits = 0;

        /* Add your Logic Here */

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '.'){
                sumOfDigits += Integer.valueOf(input.charAt(i)+"");
            }
        }
        System.out.println(sumOfDigits);
    }
}
