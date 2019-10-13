package com.hackerrank.test.gs;


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class RankOfAString {

    /*
     * Complete the get_ranks function below.
     */
    static int[] get_ranks(String[] words) {
        /*
         * Write your code here.
         */

        int[] results = new int[words.length];


        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            long count = 0;
            for (int j = 0; j < n; j++) {
                int lessThan = 0;
                String word = words[i];
                int[] freqOfDuplicates = new int[26];
                for (int k = j + 1; k < n; k++) {
                    if (word.charAt(j) > word.charAt(k)) {
                        lessThan += 1;
                    }
                }
                for (int p = j ; p < word.length(); p++) {
                    freqOfDuplicates[word.charAt(p) - 'a']++;
                }

                int factOfDuplicates = 1;
                for (int dup: freqOfDuplicates){
                    factOfDuplicates *= factorial(dup);
                }
                count += ( factorial(n - j - 1) * lessThan ) / factOfDuplicates;

            }
            int module = 1000000007;
            results[i] = (int) count % module;
            System.out.println(count);
        }

        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wordsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] words = new String[wordsCount];

        for (int wordsItr = 0; wordsItr < wordsCount; wordsItr++) {
            String wordsItem = scanner.nextLine();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            words[wordsItr] = wordsItem;
        }

        int[] res = get_ranks(words);

        /*for (int resItr = 0; resItr < res.length; resItr++) {
            bufferedWriter.write(String.valueOf(res[resItr]));

            if (resItr != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }

    static long factorial(int n) {
        long result = 1, i;

        int module = 1000000007;
        for (i=2; i<=n; i++) {
            result = (result * i) % module;;
            result = result;
        }
        return result;
    }

    static int modInverse(int a, int n)
    {
        int t =0, newt = 1, r = n, newr = a;
        int quotient = 0;
        while (newr != 0) {
            quotient = r / newr;
            t = newr;
            newt = t - quotient * newt;
            r = newr;
            newr = r - quotient * newr;
        }
        if (r > 1)  return -1;
        if (t < 0)  t = t + n;
        return t;
    }
}
