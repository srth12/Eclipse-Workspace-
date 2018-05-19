package com.hackerrank.test.soroco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDeduplicationn {

    static String dedup(String inputStr, int chunkSize) {
        // Write your code here.
        int strLen = inputStr.length();
        int loopSize = (strLen/ chunkSize) + (strLen%chunkSize==0?0:1);
        String result ="";
        for (int i = 0; i < loopSize; i++) {
            String tempResult ="";
            if (i+1 == loopSize){
                tempResult = compressString(inputStr.substring(i*chunkSize, inputStr.length()));
            }else {
                tempResult = compressString(inputStr.substring(i*chunkSize, (i+1)*chunkSize));
            }
            result+= tempResult;
        }
        return result;
    }

    private static String compressString(String substring) {
        int len = substring.length();
        String result ="";
        for (int i = 0; i < len; i++) {
            if (i+2 < len && (substring.charAt(i) == substring.charAt(i+1) && substring.charAt(i)  == substring.charAt(i+2))){
                int startIndex = i;
                String appendedString = substring.charAt(i)+"";
                int endIndex = getEndIndex(substring, i);
                result = result + substring.charAt(i)+ (endIndex - startIndex +1);
                i = endIndex;
            }else {
                result += substring.charAt(i);
            }
        }
        return result;

    }

    private static int getEndIndex(String string, int i) {
        int endIndex = i;

        while (endIndex < string.length() && string.length() > i+1){
            if (string.charAt(i) == string.charAt(i+1)) {
                ++endIndex;++i;
            }
            else break;

        }
        return endIndex;
    }

    //TODO append the remaining results which are not compressed
    static String redup(String deduplicatedStr, int chunkSize) {
        // Write your code here.

       String result ="";
       int lastAppendedIndex = 0;
        int startIndex, endIndex = 0;
        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile("[a-z][0-9]+")
                .matcher(deduplicatedStr);
        while (m.find()) {
            String encodedString = m.group();
             startIndex = m.start();
             endIndex = m.end();
            String decodedString = decode(encodedString);
            result += deduplicatedStr.substring(lastAppendedIndex, startIndex) + decodedString;
            lastAppendedIndex = endIndex;
        }
        if (lastAppendedIndex ==0 || lastAppendedIndex != deduplicatedStr.length() -1){
            result += deduplicatedStr.substring(lastAppendedIndex);
        }
        return result;
    }

    public static String decode(String input){
        String result = "";
        char charAt = input.charAt(0);
        int count = Integer.valueOf(input.substring(1, input.length()));
        for (int j = 0; j < count; j++) {
            result+= charAt;
        }

        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    static String test(String inputStr, int chunkSize) {
        String deduplicatedStr = dedup(inputStr, chunkSize);
        if (deduplicatedStr.length() >= inputStr.length()) return "Deduplicated string length is greater than the input string length";
        String originalStr = redup(deduplicatedStr, chunkSize);
        return originalStr;
    }


    public static void main(String[] args) throws IOException {

        String inputStr = scan.nextLine();

        int chunkSize = Integer.parseInt(scan.nextLine().trim());

//        String res = test(inputStr, chunkSize);

        String intResult = dedup(inputStr, chunkSize);
        System.out.println(intResult);
        String result = redup(intResult, chunkSize);
        System.out.println(result);


    }
}
