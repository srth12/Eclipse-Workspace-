package com.hackerrank.code.string;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class RobinKarpStringMatching {

    private static int hashCode = 0;
    public static void main(String[] args) {
        String pattern = "abc";
        String input = "abdd";
        int patternHash = hashCode(pattern);
        int textHash = hashCode(input.substring(0, pattern.length()));
        hashCode = textHash;

        if (textHash == patternHash)
            System.out.println("Found Patter");
        IntStream.range(1, input.length() - pattern.length() + 1)
                .forEach(x -> {
                    int nextHash = getNextHash(input, x, pattern.length());
                    if (nextHash == patternHash)
                        System.out.println(" Fount patter at index "+ x);
                });

    }

    //generate the next hashcode, given the input and it's curren index and lenght of patter in O(n) time
    private static int getNextHash(String input, int index, int patternLength){
        hashCode = (hashCode - ((int) Math.pow(10, patternLength - 1))* (input.charAt(index -1) - 'a'+1))*10 + input.charAt(index+ patternLength -1)- 'a'+1;
        return hashCode;
    }


    public static int hashCode(String str) {
        AtomicInteger value = new AtomicInteger(0);
        IntStream.range(0, str.length()).forEach(x ->{
            value.set(value.get()*10 + str.charAt(x) - 'a'+1);
        });
        return value.get();
    }
}
