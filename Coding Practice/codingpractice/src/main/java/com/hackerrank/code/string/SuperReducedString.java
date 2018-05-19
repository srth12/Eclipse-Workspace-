package com.hackerrank.code.string;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation,
 * he can delete any pair of adjacent letters with same value. For example, string "aabcc" would become either "aab" or "bcc"
 * after operation.
 * <p>
 * Steve wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed.
 * Help Steve out by finding and printing 's non-reducible form!
 * <p>
 * Note: If the final string is empty, print Empty String
 */
public class SuperReducedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(reduceStringTwoAtATime(input));
    }

    private static String reduceStringTwoAtATime(String input) {
        StringBuilder sb = new StringBuilder(input);
        boolean isFound = false;
        int i = 1;
        while (!isFound && i < sb.length()) {
            i = 1;
            if (sb.length() == 1)
                break;
            while (i < sb.length()) {
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    sb.delete(i - 1, i+1);
                    String str = sb.toString().trim();
                    if (str.length() == 0) {
                        return "Empty String";
                    }
                    i=1;
                    continue;
                }
                ++i;

                if ( sb.length() <= 1)
                    isFound = true;
            }
        }
        return sb.toString().equalsIgnoreCase("")?"Empty String":sb.toString();
    }
}
