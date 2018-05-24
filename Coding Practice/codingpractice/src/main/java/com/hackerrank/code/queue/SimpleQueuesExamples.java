package com.hackerrank.code.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SimpleQueuesExamples {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        maxQueue.offer(2);
    }
}
