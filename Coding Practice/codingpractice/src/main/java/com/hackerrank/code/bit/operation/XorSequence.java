package com.hackerrank.code.bit.operation;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/xor-se/problem
 *
 *
 */
public class XorSequence {

    static List<Long> xor_sequence = new ArrayList<>(100001);
    
    static {
        xor_sequence.add(0,0l);
        for (int i = 1; i < Math.pow(2, 9); i++) {
            xor_sequence.add(i, xor_sequence.get(i - 1) ^ i);
        }
    }

    static long xorSequence(long l, long r) {
        long i = l;
        long result = -1;
        if ( l + 1 < 100001){
            result = xor_sequence.get( (int) l + 1) ^ xor_sequence.get( (int) l);
        }else {
            result = l ^ (l + 1);
        }
        for (i = l+2; i <= r; i++) {
            if ( i < 100001){
                result = result ^ xor_sequence.get((int) i);
            }else {
                result = result ^ i;
            }
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] lr = scanner.nextLine().split(" ");

            long l = Long.parseLong(lr[0].trim());

            long r = Long.parseLong(lr[1].trim());

            long result = xorSequence(l, r);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();
    }

}
