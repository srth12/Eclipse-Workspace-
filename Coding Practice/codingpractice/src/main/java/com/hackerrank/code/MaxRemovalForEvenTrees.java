package com.hackerrank.code;

import java.util.*;

/**
 * url: https://www.hackerrank.com/challenges/even-tree/problem
 *
 *
 * You are given a tree (a simple connected graph with no cycles).

 Find the maximum number of edges you can remove from the tree to get a forest such that each connected component of the forest contains an even number of nodes.


 */
public class MaxRemovalForEvenTrees {

    private static final Scanner scan = new Scanner(System.in);
    private static int totalEvenTrees = 0;


    public static void main(String[] args) {
        String[] treeNodesEdges = scan.nextLine().split(" ");
        int treeNodes = Integer.parseInt(treeNodesEdges[0].trim());
        int treeEdges = Integer.parseInt(treeNodesEdges[1].trim());

        int[] treeFrom = new int[treeEdges];
        int[] treeTo = new int[treeEdges];

        for (int treeItr = 0; treeItr < treeEdges; treeItr++) {
            String[] treeFromTo = scan.nextLine().split(" ");
            treeFrom[treeItr] = Integer.parseInt(treeFromTo[0].trim());
            treeTo[treeItr] = Integer.parseInt(treeFromTo[1].trim());
        }
        MaxRemovalForEvenTrees m = new MaxRemovalForEvenTrees();
        Node root = m.generateTree(treeFrom, treeTo);
        computeChildren(root);
        System.out.println(totalEvenTrees - 1);
    }

    private static int computeChildren(Node root) {
        if (root == null)
            return 0;
        if (root.children == null || root.children.size() == 0) {
            root.totalChildren = 0;
            return 1;
        }
        for (Node child : root.children) {
            root.totalChildren += computeChildren(child);
        }
        if ((root.totalChildren & 1) == 1)
            ++totalEvenTrees;
        return root.totalChildren + 1;
    }

    public Node generateTree(int[] treeFrom, int[] treeTo) {

        Node[] nodeArr = new Node[101];
        for (int i = 0; i < treeFrom.length; i++) {
            if (nodeArr[treeTo[i]] == null){
                nodeArr[treeTo[i]] = new Node(treeTo[i]);
                Set<Node> children = new HashSet<>();
                Node newChild = new Node(treeFrom[i]);//
                children.add(newChild);
                nodeArr[treeTo[i]].children = children;
                nodeArr[treeFrom[i]] = newChild;//
            }else {
                Node newNode = null;
                if (nodeArr[treeFrom[i]] == null){
                    newNode = new Node(treeFrom[i]);
                    nodeArr[treeFrom[i]] = newNode;
                }else newNode = nodeArr[treeFrom[i]];
                if (nodeArr[treeTo[i]].children == null){
                    Set<Node> children = new HashSet<>();
                    children.add(newNode);
                    nodeArr[treeTo[i]].children = children;

                }else nodeArr[treeTo[i]].children.add(newNode);
            }
        }

        return nodeArr[1];
    }

    class Node {
        int data;
        int totalChildren;
        Set<Node> children;
        Node(int data){
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data ;
        }

        @Override
        public int hashCode() {

            return Objects.hash(data);
        }
    }
}
