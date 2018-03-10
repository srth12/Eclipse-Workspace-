package com.hackerrank.code;

import java.util.Scanner;

/**
 * Qn:(https://www.hackerrank.com/challenges/maximum-palindromes/problem)
 * Madam Hannah Otto, the CEO of Reviver Corp., is fond of palindromes, or words that read the same forwards or backwards. She thinks palindromic brand names are appealing to millennials.
 * <p>
 * As part of the marketing campaign for the company's new juicer called the Rotator™, Hannah decided to push the marketing team's palindrome-searching skills to a new level with a new challenge.
 * <p>
 * In this challenge, Hannah provides a string  consisting of lowercase English letters. Every day, for  days, she would select two integers  and ,
 * take the substring  (the substring of  from index  to index ), and ask the following question:
 * <p>
 * Consider all the palindromes that can be constructed from some of the letters from . You can reorder the letters as you need.
 * Some of these palindromes have the maximum length among all these palindromes. How many maximum-length palindromes are there?
 * <p>
 * <p>
 * <p>
 * Ans:
 * Suppose we want to answer a query . For each letter, we need to know the number of its occurrences.
 * We can calculate it in  time using prefix sums.
 * <p>
 * We can bisect every palindrome. If its length is odd, we have "remainder" — the middle letter.
 * <p>
 * We want to know the number of pairs of strings , where  is half of some maximum palindrome, and  is the palindrome remainder.
 * Note that  is an empty string if the maximum palindromes length is even. The number of these pairs will be the answer because we can build palindrome  and, vice versa, we can build such pair by the maximum palindrome.
 * <p>
 * Let  be the number of occurences of letter . Consider the following cases:
 * <p>
 * is even. Then a half of every maximum palindrome will contain exactly  letters .
 * is odd. Then a half of every maximum palindrome will contain exactly  letters . Also this means that we can set this letter to the middle of palindrome ( can be ).
 * Let  be the number of odd . If , the maximum palindromes length will be even; otherwise it will be odd and there will be exactly  possible middle letters.
 * <p>
 * Now it's obvious that the answer is . (The latter represents a multinomial coefficient[https://en.wikipedia.org/wiki/Multinomial_theorem].) So, we need to precompute factorials and inverses of factorials modulo . This can be done in  or .
 */
public class MaximumPalindromes {

    static final long MOD = (long) (Math.pow(10,9)+7);
    static int sMaxLen = 100001;
    static int sArr[][] = new int[sMaxLen][27];
    static long fact[] = new long[sMaxLen];

    static void initialize(String s) {
        // This function is called once before all queries.
        int sLen = s.length();
        for (int i = 1; i <= sLen; i++){
            sArr[i][s.charAt(i-1)-96]++;
        }
        for (int i = 2; i <= sLen; i++){
            for (int j = 1; j < 27; j++){
                sArr[i][j] += sArr[i - 1][j];
            }
        }

    }

    static long power(int x, int y){
        if (y == 0)
            return 1;
        byte t = 1;
        if ((y & 1) == 1 ){
            return x * power(x, y-1);
        }else {
            long temp = power(x, y/2);
            return temp * temp;
        }
    }

    static long answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        int letterCount[] = new int[27];
        for (int i = 1; i < 27; i++){
            letterCount[i] = sArr[r][i] - sArr[l-1][i];
        }
        int oddCount = 0;
        for (int i = 1; i < 27; i++){
            if ((letterCount[i] & 1) == 1){
                oddCount++;
            }
        }
        int numerator = 0;
        long denomerator = 1;
        for (int i = 1; i < 27; i++){
            numerator += letterCount[i]/2;
            denomerator *= fact(letterCount[i]/2) % MOD;
        }
        denomerator = denomerator == 0? 1: denomerator;
        return Math.max(1,oddCount)*fact(numerator)/denomerator;
    }

    static long fact(int i){
        if (i==0)
            return 1;
        long fact = 1;
        for (int j = 1; j <= i; j++){
            fact=(fact*j)%MOD;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        initialize(s);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int l = in.nextInt();
            int r = in.nextInt();
            long result = answerQuery(l, r);
            System.out.println(result);
        }
        in.close();
    }
}
