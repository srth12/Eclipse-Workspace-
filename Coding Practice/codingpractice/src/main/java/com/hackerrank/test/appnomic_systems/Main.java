package com.hackerrank.test.appnomic_systems;/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* You may add any imports here, if you wish, but only from the 
   standard library */

public class Main {
    public static int processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the appropriate value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        Map<String, Map<String, Integer>> mapOfServerVersions = new ConcurrentHashMap<>();
        array.stream().forEach(line -> {
            String[] tokens = line.split(", ");
            String server = tokens[2].trim();
            String version = tokens[3].trim();
            Map<String, Integer> versionMaps = new TreeMap<>(versionComparator.reversed());
            if (mapOfServerVersions.containsKey(server)) {
                Map<String, Integer> versionMap = mapOfServerVersions.get(server);
                if (versionMap.containsKey(version)){
                    versionMap.put(version, versionMap.get(version)+1);
                }else versionMap.put(version, 1);
                mapOfServerVersions.put(server, versionMap);
            }else {
                versionMaps.put(version, 1);
                mapOfServerVersions.put(server, versionMaps);
            }
        });
        AtomicInteger noOfOlderVersions = new AtomicInteger(0);

        mapOfServerVersions.entrySet().stream().filter(serverMapEntry -> serverMapEntry.getValue().size() > 1)
                .forEach(serverEntry -> {
                    TreeMap<String, Integer> versionMap = (TreeMap<String, Integer>) serverEntry.getValue();
                    int oldVersions = versionMap.values().stream().mapToInt(i -> i).sum() - versionMap.firstEntry().getValue();
                    noOfOlderVersions.addAndGet(oldVersions);
                });
        return noOfOlderVersions.get();
    }

    static Comparator<String> versionComparator = (version1, version2) -> {
        if(version2 == null)
            return 1;
        String[] thisParts = version1.split("\\.");
        String[] thatParts = version2.split("\\.");
        int length = Math.max(version1.length(), version2.length());
        for(int i = 0; i < length; i++) {
            int thisPart = i < thisParts.length ?
                    Integer.parseInt(thisParts[i]) : 0;
            int thatPart = i < thatParts.length ?
                    Integer.parseInt(thatParts[i]) : 0;
            if(thisPart < thatPart)
                return -1;
            if(thisPart > thatPart)
                return 1;
        }
        return 0;
    };

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                    inputData.add(line);
            }
            int retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
