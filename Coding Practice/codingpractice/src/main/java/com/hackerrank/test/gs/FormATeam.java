package com.hackerrank.test.gs;

import java.util.*;

public class FormATeam {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(17, 12, 10, 2, 7, 2, 11, 20, 8));
        long result = formATeamAndGetMaxScore(list, 3, 4);
        System.out.println(result);
    }

    // Complete the teamFormation function below.
    static long teamFormation(int[] score, int team, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(score).forEach(ele -> list.add(ele));
        return formATeamAndGetMaxScore(list, team, m);

    }

    public static long formATeamAndGetMaxScore(ArrayList<Integer> scores, int noOfTeamMemberReq, int sizeOfSegToSelect ){
        long totalScore = 0;
        PriorityQueue<Integer> rigthQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Comparator.reverseOrder());
        int n = scores.size();
        boolean isLess = false;

        int actualSizeOfSegmentToSelect = 0;
        if (sizeOfSegToSelect > n){
            isLess = true;
            actualSizeOfSegmentToSelect = n;
        }else actualSizeOfSegmentToSelect = sizeOfSegToSelect;

        leftQ.addAll(scores.subList(0, actualSizeOfSegmentToSelect ));
        if (isLess){
            rigthQ.addAll(scores.subList(0, actualSizeOfSegmentToSelect));
        }else rigthQ.addAll(scores.subList(n - actualSizeOfSegmentToSelect + 1, n));

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
