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
            int count = 0;
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
                count += ( factorial(n - j - 1) * lessThan) / factOfDuplicates;

            }
            results[i] = count;
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

    static int factorial(int n) {
        int result = 1, i;

        for (i=2; i<=n; i++) {
            result *= i;
        }
        return result;
    }
}
