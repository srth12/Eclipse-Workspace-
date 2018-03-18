package com.hackerrank.code;

import java.util.*;

/**
 * Problem url: https://www.hackerrank.com/challenges/journey-to-the-moon/problem
 *
 * The member states of the UN are planning to send  people to the Moon. But there is a problem. In line with their principles of global unity, they want to pair astronauts of  different countries.

 There are  trained astronauts numbered from  to . But those in charge of the mission did not receive information about the citizenship of each astronaut. The only information they have is that some particular pairs of astronauts belong to the same country.

 Your task is to compute in how many ways they can pick a pair of astronauts belonging to different countries. Assume that you are provided enough pairs to let you identify the groups of astronauts even though you might not know their country directly. For instance, if  are astronauts from the same country; it is sufficient to mention that  and  are pairs of astronauts from the same country without providing information about a third pair .


 */
public class JourneyToMoon {


    static int journeyToMoon(int n, int[][] astronaut) {
        // Complete this function
        List<Set<Integer>> bucket = new ArrayList<>();
        int[] allAst = new int[n];
        for (int i = 0; i < astronaut.length; i++) {
            addToBucket(bucket, astronaut[i]);
            allAst[astronaut[i][0]] = -1;
            allAst[astronaut[i][1]] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (allAst[i] == 0){
                Set<Integer> set = new HashSet<>();
                set.add(i);
                bucket.add(set);
            }
        }
        int totalComp = 0;
        for (int i = 0; i < bucket.size(); i++) {
            int temp = bucket.get(i).size();
            for (int j = i+1; j < bucket.size(); j++) {
                totalComp+= temp* bucket.get(j).size();
            }
        }
        return totalComp;
    }

    private static void addToBucket(List<Set<Integer>> bucket, int[] astronauts) {
        boolean found = false;
        Set<Integer> foundSet = null;
        Iterator<Set<Integer>> bucketItr = bucket.iterator();
        while (bucketItr.hasNext()){
            Set<Integer> astraunautBucket = bucketItr.next();
            if (astraunautBucket.contains(astronauts[0])){
                if (!found){
                    foundSet = astraunautBucket;
                    found = true;
                }else {
                    foundSet.addAll(astraunautBucket);
                    bucketItr.remove();
                }
                astraunautBucket.add(astronauts[1]);
            }else if (astraunautBucket.contains(astronauts[1])){
                if (!found){
                    foundSet = astraunautBucket;
                    found = true;
                }else {
                    foundSet.addAll(astraunautBucket);
                    bucketItr.remove();
                }
                astraunautBucket.add(astronauts[0]);
            }
        }
        if (!found){
            Set<Integer> newAstSet = new HashSet<>();
            newAstSet.add(astronauts[0]);
            newAstSet.add(astronauts[1]);
            bucket.add(newAstSet);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] astronaut = new int[p][2];
        for (int astronaut_i = 0; astronaut_i < p; astronaut_i++) {
            for (int astronaut_j = 0; astronaut_j < 2; astronaut_j++) {
                astronaut[astronaut_i][astronaut_j] = in.nextInt();
            }
        }
        int result = journeyToMoon(n, astronaut);
        System.out.println(result);
        in.close();
    }

}
