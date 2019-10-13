package com.hackerrank.test.alation;

import java.util.List;

public class EvenOddCardGame {

    public static void main(String[] args) {

    }

    // Complete the winner function below.
    static String winner(List<Integer> andrea, List<Integer> maria, String s) {

        int andreaScore = 0, mariaScore = 0;
        if (s.equalsIgnoreCase("odd")){
            andrea.remove(0);
            maria.remove(0);
        }

        for (int i = 0; i < andrea.size(); i+=2) {
            andreaScore += (andrea.get(i) - maria.get(i));
            mariaScore += (maria.get(i) - andrea.get(i));
        }

        if (andreaScore > mariaScore)
            return "Andrea";
        else if (mariaScore > andreaScore)
            return "Maria";
        else return "Tie";

    }
}
