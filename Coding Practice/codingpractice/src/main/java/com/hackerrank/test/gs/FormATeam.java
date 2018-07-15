package com.hackerrank.test.gs;

import java.util.ArrayList;
import java.util.Arrays;

public class FormATeam {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(17, 12, 10, 2, 7, 2, 11, 20, 8));
        int result = formATeamAndGetMaxScore(list, 3, 4);
        System.out.println(result);
    }

    public static int formATeamAndGetMaxScore(ArrayList<Integer> scores, int noOfTeamMemberReq, int sizeOfSegToSelect ){
        int totalScore = 0;
        for (int i = 0; i < noOfTeamMemberReq; i++) {
            boolean isLeft = true;
            int maxScore = Integer.MIN_VALUE;
            for (int j = 0; j < (scores.size() < sizeOfSegToSelect?scores.size(): sizeOfSegToSelect); j++) {
                if (maxScore < scores.get(j)){
                    maxScore = scores.get(j);
                    isLeft = true;
                }
                if (maxScore < scores.get(scores.size() - j - 1)){
                    maxScore = scores.get(scores.size() - j - 1);
                    isLeft = false;
                }
            }
            if (isLeft) {
                int index = scores.indexOf(maxScore);
                scores.remove(index);
            } else {
                int index = scores.lastIndexOf(maxScore);
                scores.remove(index);
            }
            totalScore += maxScore;
        }
        return totalScore;
    }
}
