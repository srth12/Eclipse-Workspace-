package com.hackerrank.test.redlock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConnectedZombies {

    /*
     * Complete the zombieCluster function below.
     */
    private static List<Boolean> visited = new ArrayList<>();

    static int zombieCluster(String[] zombies) {
        /*
         * Write your code here.
         */
        int n = zombies.length;
        Set<Integer>[] zombiePartner = new HashSet[n];
        for (int i = 0; i < n; i++) {
            zombiePartner[i] = new HashSet<>();
            visited.add(i, false);
        }

        for (int i = 0; i < n; i++) {
            char[] friends = zombies[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (friends[j] == '1' && j != i)
                    zombiePartner[i].add(j);
            }
        }

        int group =0;
        for (int i = 0; i < n; i++) {
            if (!visited.get(i)) {
                group++;
                visited.set(i, true);
                 getTotalConnectedComponentDFS(i, zombiePartner);
            }
        }

        /*List<Integer> result = IntStream.range(0, n).mapToObj(zombie -> {
            if (!visited.get(zombie)) {
                visited.set(zombie, true);
                return getTotalConnectedComponentDFS(zombie, zombiePartner) + 1;
            } else return 0;
        }).collect(Collectors.toList());*/

        return group;
    }

    static int getTotalConnectedComponentDFS(int u, Set[] zombiePartner){
        int sum = zombiePartner[u].stream().mapToInt(x -> (int)x).filter(x -> !visited.get(x))
                .map(v -> {
                    visited.set(v, true);
                    return 1+getTotalConnectedComponentDFS(v, zombiePartner);
                }).sum();

        return sum;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int zombiesCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] zombies = new String[zombiesCount];

        for (int zombiesItr = 0; zombiesItr < zombiesCount; zombiesItr++) {
            String zombiesItem = scanner.nextLine();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            zombies[zombiesItr] = zombiesItem;
        }

        int res = zombieCluster(zombies);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
