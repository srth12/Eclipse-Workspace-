package com.hackerrank.code.graph;

import java.util.*;

public class DijkstrasShortestPath {

    public static void main(String[] args) {

    }

    public void findShortestDistance(List<Node> nodes, int[][] weight){
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(x -> x.distance));
        nodes.get(0).distance = 0;
        for (Node node: nodes){
            node.distance = -1;
        }
        nodes.get(0).distance = 0;
        queue.add(nodes.get(0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (Node w: node.adjNodes){
                int dist = weight[node.value][w.value] + node.distance;
                if (w.distance == -1){
                    w.distance = dist;
                    w.path = node.value;
                    queue.add(w);
                }else if (w.distance > dist){
                    w.distance = dist;
                    w.path = node.value;
                    queue.remove(w);
                    queue.add(w);
                }
            }
        }

    }
}

class Node{
    int value;
    int path;
    int distance;
    List<Node> adjNodes;
    Node(int value){
        this.value = value;
        path = -1;
        distance = -1;
        adjNodes = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        Node n1 = (Node) obj;
        return this.value == n1.value;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
