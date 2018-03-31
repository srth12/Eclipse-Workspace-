package com.hackerrank.code;

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

    public static void main(String[] args) {
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
