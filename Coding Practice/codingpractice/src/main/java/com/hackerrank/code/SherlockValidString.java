package com.hackerrank.code;

import java.util.Scanner;

/**
 * qn: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 *
 * Sherlock considers a string, , to be valid if either of the following conditions are satisfied:

 All characters in  have the same exact frequency (i.e., occur the same number of times). For example,  is valid, but  is not valid.
 Deleting exactly  character from  will result in all its characters having the same frequency. For example,  and  are valid because all their letters will have the same frequency if we remove occurrence of c, but  is not valid because we'd need to remove  characters.
 Given , can you determine if it's valid or not? If it's valid, print YES on a new line; otherwise, print NO instead.


 */
public class SherlockValidString {

    static int[] str = new int['z'-'a'+1];
    static String isValid(String s){
        if (s.length() == 1 || s.length() == 2)
            return "YES";
        for (int i = 0; i < s.length(); i++){
            str[s.charAt(i) - 'a']++;
        }
        int constant = 0;
        if (str[0] == str[1]) {
            constant = str[0];
        }else if (str[0] == str[2]){
            constant = str[0];
        }else if (str[1] == str[2]){
            constant = str[1];
        }else {
            return "NO";
        }
        int foundDiff = 0;
        for (int i = 0; i < 26; i++){
            if (str[i] != 0 && str[i] != constant) {
                foundDiff++;
                if ((str[i]  > 1) && (Math.abs( str[i] - constant) > 1))
                    return "NO";
            }
        }
        if (foundDiff > 1)
            return "NO";
        else return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }

}
