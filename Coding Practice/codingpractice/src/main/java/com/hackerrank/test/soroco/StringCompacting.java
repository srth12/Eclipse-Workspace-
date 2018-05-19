package com.hackerrank.test.soroco;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringCompacting {

    private static final Scanner scanner = new Scanner(System.in);


    static String solution(int[] array) {
        /*
         * Write your code here.
         */
        String result = "";

        if (array.length < 3){
            for (int i = 0; i < array.length; i++) {
                if (i == array.length -1)
                    result += array[i];
                else result += array[i] + ",";
            }
            return result;
        }

        for (int i = 0; i < array.length; i++) {
            if (i+2 < array.length && (array[i]+1 == array[i+1] && array[i] + 2 == array[i+2])){
                int startIndex = i;
                String appendedString = Integer.toString(array[i]);
                int endIndex = getEndIndex(array, i);
                result = result + array[i] +"-"+ array[endIndex];
                if (endIndex != array.length -1)
                    result +=",";
                i = endIndex;
            }else {
                if (i == array.length -1)
                    result += array[i];
                else result += array[i] + ",";
            }
        }
        return result;
    }

    private static int getEndIndex(int[] array, int i) {
        int endIndex = i;

        while (endIndex < array.length && array.length > i+1){
            if (array[i]+1 == array[i+1]) {
                ++endIndex;++i;
            }
            else break;

        }
        return endIndex;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrayCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int[] array = new int[arrayCount];

        for (int arrayItr = 0; arrayItr < arrayCount; arrayItr++) {
            int arrayItem = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            array[arrayItr] = arrayItem;
        }

        String res = solution(array);

//        bufferedWriter.write(res);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
