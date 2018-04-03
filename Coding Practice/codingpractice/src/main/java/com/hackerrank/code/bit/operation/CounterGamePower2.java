package com.hackerrank.code.bit.operation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/counter-game/problem
 *
 * Louise and Richard play a game. They have a counter set to .In every game, Louise gets the first turn and the turns alternate thereafter. In the game, they perform the following operations.

 If N is not a power of 2, reduce the counter by the largest power of 2 less than N.
 If N is a power of 2, reduce the counter by half of N.
 The resultant value is the new N which is again used for subsequent operations.

 */
public class CounterGamePower2 {

    static String counterGame(long n) {
        // Complete this function
        boolean louiseTurn = true;

        while (n > 1){
            if (isPowerOf2(n)){
                n = n >> 1;
                louiseTurn = !louiseTurn;
            }else {
                long indexOfMaxDigit = getIndexOfGreatestBit(n);
                if (indexOfMaxDigit == -1)
                    return "Error";
                n = n - ( 1l << indexOfMaxDigit);
                louiseTurn = !louiseTurn;
            }
        }

        if (!louiseTurn)
            return "Louise";
        else return "Richard";

    }

     static boolean  isPowerOf2(long a){
        int noOfTwo = 0;
        for (int i = 63; i >= 0; i--) {
            if ( (a & (1l << i)) != 0){
                noOfTwo++;
            }
            if (noOfTwo >1)
                return false;
        }
        return true;
    }

    static long getIndexOfGreatestBit(long a){
        long index = -1;
        for (int i = 62; i >= 0; i--) {
            long shiftedVar = 1l << i;
            if ((a & (shiftedVar)) > 0) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            String result = counterGame(n);
            System.out.println(result);
        }
        in.close();
    }

}
