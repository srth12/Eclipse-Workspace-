package com.hackerrank.test.redlock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SumOfElementEqualsK {

    static int numberOfPairs(int[] a, long k) {
        /*
         * Write your code here.
         */

        Map<Integer, Integer> map = new HashMap<>();
        Set<Pair> pairsSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])){
                int count = map.get(a[i]);
                map.put(a[i], ++count);
            }else {
                map.put(a[i], 1);
            }
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            long key = (long)entry.getKey().intValue();
            int val =(int) (k - key);
            if (key == val && map.get(val) == 1)
                continue;
            if (map.containsKey(val)){
                int element = (int) entry.getKey();
                pairsSet.add(new Pair(element, (int) k - element));
            }
        }

        return pairsSet.size();



    }
    static class Pair{
        int smallest, largest;
        Pair(int a, int b){
            this.smallest = a < b?a:b;
            this.largest = this.smallest == a? b: a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return smallest == pair.smallest &&
                    largest == pair.largest;
        }

        @Override
        public int hashCode() {

            return Objects.hash(smallest, largest);
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            a[aItr] = aItem;
        }

        long k = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int res = numberOfPairs(a, k);
        System.out.println(res);
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
