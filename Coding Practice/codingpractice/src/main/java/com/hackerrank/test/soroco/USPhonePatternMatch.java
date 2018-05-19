package com.hackerrank.test.soroco;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class USPhonePatternMatch {

    /*
     * Complete the find_phone_number function below.
     */
    static String find_phone_number(String text) {
        /*
         * Write your code here.
         */

        Pattern pattern1 = Pattern.compile("\\([0-9]{3}\\) [0-9]{3}\\-[0-9]{4}");
        Pattern pattern2 = Pattern.compile("[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}");
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        if (matcher1.find()){
            int startIndex = matcher1.start();
            int endIndex = matcher1.end();
            return text.substring(startIndex, endIndex);
        }else if (matcher2.find()){
            int startIndex = matcher2.start();
            int endIndex = matcher2.end();
            return text.substring(startIndex, endIndex);
        }else return "NONE";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String text = scanner.nextLine();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String res = find_phone_number(text);

//        bufferedWriter.write(res);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
