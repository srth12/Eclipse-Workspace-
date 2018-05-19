package com.hackerrank.test.nira;

import java.util.Stack;

/**
 * Substrings in Substring
 * You are given a string  of length n having only lowercase English letters.
 * You are also given q queries, each having two space-separated integers l and r.
 * For each query, you need to print the number of substrings of the string  which starts and end with the same character.
 */
public class SubStringWithSameStartAndEnd {
    static int count = 0;
    public static void main(String[] args) {
//        find("", "abcaab");
        findMatch("abcaab");
        System.out.println(count);
    }


    public static void findMatch(String str){
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if ( i == j){
                    count++;
                    System.out.println(str.substring(i,j+1));
                    continue;
                }
                String temp = str.substring(i, j+1);
                if (temp.charAt(0)  == temp.charAt(temp.length() - 1)) {
                    count++;
                    System.out.println(temp);
                }
            }
        }
    }
}
