package com.hackerrank.test.gs;

public class Temp {/*

    static long teamFormation(int[] score, int team, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(score).forEach(ele -> list.add(ele));
        return formATeamAndGetMaxScore(list, team, m);


    }

    public static long formATeamAndGetMaxScore(ArrayList<Integer> scores, int noOfTeamMemberReq, int sizeOfSegToSelect ){
        long totalScore = 0;
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
    }*/
}
