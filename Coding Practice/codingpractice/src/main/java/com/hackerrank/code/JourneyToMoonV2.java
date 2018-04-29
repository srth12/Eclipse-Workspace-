package com.hackerrank.code;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Problem url: https://www.hackerrank.com/challenges/journey-to-the-moon/problem
 *
 * The member states of the UN are planning to send  people to the Moon. But there is a problem. In line with their principles of global unity, they want to pair astronauts of  different countries.

 There are  trained astronauts numbered from  to . But those in charge of the mission did not receive information about the citizenship of each astronaut. The only information they have is that some particular pairs of astronauts belong to the same country.

 Your task is to compute in how many ways they can pick a pair of astronauts belonging to different countries. Assume that you are provided enough pairs to let you identify the groups of astronauts even though you might not know their country directly. For instance, if  are astronauts from the same country; it is sufficient to mention that  and  are pairs of astronauts from the same country without providing information about a third pair .


 */
public class JourneyToMoonV2 {




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        Set<Integer>[] astronauts = new HashSet[n];
        IntStream.range(0, n).forEach(x -> {
            astronauts[x] = new HashSet<>();
            visited.add(x, false);
        });
        for (int astronaut_i = 0; astronaut_i < p; astronaut_i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            astronauts[u ].add(v);
            astronauts[v].add(u);
        }
        int result = journeyToMoon(n, astronauts);
        System.out.println(result);
        in.close();
    }

    private static List<Boolean> visited = new ArrayList<>();

    private static int journeyToMoon(int n, Set[] astronauts){
        List<Integer> connectedComponents = new ArrayList<>();
        List<Integer> results = IntStream.range(0, n).map(astronaut -> {
            if (!visited.get(astronaut)) {
                visited.set(astronaut, true);
                return getTotalConnectedComponentDFS(astronaut, astronauts)+1;
            } else return 0;
        }).mapToObj(element ->{
            return (element*(element-1)/2);
        }).collect(Collectors.toList());
        int result = n * (n-1)/2;
        for (int i = 0; i < results.size(); i++) {
            int x = results.get(i);
            result-= x ;
        }
        return result;
    }

    static int getTotalConnectedComponentDFS(int u, Set[] astronauts){
        int sum = astronauts[u].stream().mapToInt(x -> (int)x).filter(x -> !visited.get(x))
                .map(v -> {
                    visited.set(v, true);
                    return 1+getTotalConnectedComponentDFS(v, astronauts);
                }).sum();

        return sum;
    }

}