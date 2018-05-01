package com.hackerrank.code;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You will be given an array of integers. All of the integers except one occur twice. That one is unique in the array.

 Given an array of integers, find and print the unique element.


 */
public class LonelyInteger {
    static int lonelyinteger(int[] a) {
        int result = 0;
        for (int i: a){
            result = result ^ i; // XOR ing the elements
        }
        return result;
    }

    static long aVeryBigSum(int n, long[] ar) {
        /*
         * Write your code here.
         */

//        LocalDateTime t = new LocalDateTime(1523718907817l);

        return Arrays.stream(ar).sum();

    }

    public static void main(String[] args) {

        Timestamp s = new Timestamp(1523718907817l);
        System.out.println(s.toString());

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = lonelyinteger(a);
        System.out.println(result);
    }
}
