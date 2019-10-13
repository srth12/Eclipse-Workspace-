package com.hackerrank.test.alation;

import java.util.HashMap;
import java.util.Map;

public class DnaComplement {

    public static void main(String[] args) {

        dnaComplement("ACCGGGTTTT");
    }

    static String dnaComplement(String s) {
        StringBuffer str = new StringBuffer(s);
        String reverse = str.reverse().toString();
        StringBuffer result = new StringBuffer("");
        Map<String, String> complementMap = new HashMap<>();
        complementMap.put("A","T");
        complementMap.put("T","A");
        complementMap.put("C", "G");
        complementMap.put("G", "C");

        for (int i = 0; i < reverse.length(); i++) {
            String temp = String.valueOf(reverse.charAt(i));
            result.append(complementMap.get(temp));
        }

        return result.toString();

    }
}
