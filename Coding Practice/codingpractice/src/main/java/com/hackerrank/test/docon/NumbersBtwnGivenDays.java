package com.hackerrank.test.docon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NumbersBtwnGivenDays {

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        IntStream.range(0,  n).forEach(x -> {
            int price = s.nextInt();
            array[x] = price;
        });
        int q = s.nextInt(); s.nextLine();
        Arrays.sort(array);
        IntStream.range(0, q).forEach(x ->{
            String lines = s.nextLine();
            String[] line = lines.split(" ");
            if (line.length != 2) return;
            int l = findLeft(array, Integer.valueOf(line[0]));
            int r = findRight(array, Integer.valueOf(line[1]), l);
            System.out.println(r - l + 1);
        });

    }

    public static int findLeft(int[] array, int key){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key || array[i] > key)
                return i;
        }
        return array.length -1;
    }

    public static int findRight(int[] array, int key, int startIndex){
        if (array[0] > key) return -1;
        for (int i = startIndex; i < array.length; i++) {
            if ( array[i] > key) {
                if (i > 0) return i - 1;
                else return 0;
            }
        }
        return array.length -1;
    }
}
