package com.hackerrank.test.kickdrum;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solutions {

    class Node{
        int start, end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static void findMaximumEvents(List<String> eventDetails) {

        Solutions s = new Solutions();
        s.getSortedNodes(eventDetails);

    }

    public void getSortedNodes(List<String> eventDetails){
        int count = 1;
        List<Node> sortedEvents = eventDetails.stream().map(event -> {
            String[] str = event.split(" ");
            Node n = new Node(Integer.valueOf(str[0]), Integer.valueOf(str[1]));
            return n;
        }).sorted(comparator).collect(Collectors.toList());


        for (int i = 0, j=1; j < eventDetails.size();j++) {
            if (sortedEvents.get(i).end < sortedEvents.get(j).start){
                count++; i = j;
            }

        }
        System.out.println(count);
    }
    Comparator<Node> comparator = (node1, node2) -> {
        return Integer.compare(node1.end, node2.end);
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int eventDetailsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> eventDetails = new ArrayList<>();

        IntStream.range(0, eventDetailsCount).forEach(i -> {
            try {
                eventDetails.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        findMaximumEvents(eventDetails);

        bufferedReader.close();
    }
}
