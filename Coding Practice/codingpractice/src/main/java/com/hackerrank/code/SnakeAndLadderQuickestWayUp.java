package com.hackerrank.code;

import java.io.IOException;
import java.util.Scanner;

public class SnakeAndLadderQuickestWayUp {

    // Complete the quickestWayUp function below.
    static int quickestWayUp(int[][] ladders, int[][] snakes) {
        int count = 0;
        int noOfLadders = ladders.length;
        int noOfSnakes = snakes.length;
        for (int i = 0; i < 101;) {
            int maxLadder = -1;
            int minSnake = Integer.MAX_VALUE;
            for (int k = i+6; k > (i) ; k--) {
                for (int j = 0; j < noOfLadders; j++) {
                    if (ladders[j][0] == (k)){
                        maxLadder = Math.max(maxLadder, ladders[j][1]);
                    }
                }
                if (maxLadder != -1) {
                    i = maxLadder;count++;
                    continue;
                }
                boolean isSnake = false;
                for (int j = 0; j < noOfSnakes; j++) {
                    if (snakes[j][0] == k) {
                        minSnake = Math.min(snakes[j][1], k);
                        isSnake = true;
                    }
                }

                if (!isSnake)
                    i = k;
                else i = minSnake;
                count++;
            }

        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] ladders = new int[n][2];

            for (int i = 0; i < n; i++) {
//                String[] laddersRowItems = scanner.nextLine().split(" ");
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                /*for (int j = 0; j < 2; j++) {
                    int laddersItem = scanner.nextInt();//Integer.parseInt(laddersRowItems[j]);
                    ladders[i][j] = laddersItem;
                }*/
                ladders[i][0] = scanner.nextInt();
                ladders[i][1] = scanner.nextInt();
            }

            int m = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] snakes = new int[m][2];

            for (int i = 0; i < m; i++) {
//                String[] snakesRowItems = scanner.nextLine().split(" ");
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//                for (int j = 0; j < 2; j++) {
                    snakes[i][0] = scanner.nextInt();
                snakes[i][1] = scanner.nextInt();
//                }
            }

            int result = quickestWayUp(ladders, snakes);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }

}
