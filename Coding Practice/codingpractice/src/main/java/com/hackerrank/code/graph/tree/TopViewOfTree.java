package com.hackerrank.code.graph.tree;

import java.util.*;

public class TopViewOfTree {

    /**
     *       1
     *     -1  2
     *        3
     *       4
     * @param args
     */
    int[] nodeElement = new int[1002];
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.setLeft(new Node(-1));
        Node node2 = new Node(2);
        node1.setRight(node2);
        Node node3 = new Node(3);
        node2.setLeft(node3);
        Node node4 = new Node(4);
        node3.setLeft(node4);
        node4.setLeft(new Node(5));
        TopViewOfTree t = new TopViewOfTree();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Node bNode = t.buildBinaryTree(list);
        t.topView(bNode);
        System.out.println();
        t.top_view(bNode);// bad version by hacker rank, won't do it for complex scenario
    }

    void goLeft(Node node) {
        if(node.left != null) {
            goLeft(node.left);
        }
        System.out.print(node.data + " ");
    }

    void goRight(Node node) {
        System.out.print(node.data + " ");

        if(node.right != null) {
            goRight(node.right);
        }
    }

    void top_view(Node root) {
        if(root.left != null) {
            goLeft(root.left);
        }

        System.out.print(root.data + " ");

        if(root.right != null) {
            goRight(root.right);
        }
    }

    public void topView(Node node){
        Node listOfNodes = new Node(node.getData());
        traverseTreeForTopView(node, listOfNodes);
    }

    public Node buildBinaryTree(List<Integer> list){
        Node head = new Node(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            insertNodeToBinarySearchTree(head, list.get(i));
        }
        return head;
    }

    private void insertNodeToBinarySearchTree(Node head, Integer integer) {
        Node newNode = new Node(integer);
        if (head.getData() < integer){
            if (head.getRight() == null){
                head.setRight(newNode);
                return;
            }else {
                insertNodeToBinarySearchTree(head.getRight(), integer);
            }
        }else {
            if (head.getLeft() == null){
                head.setLeft(newNode);
            }else insertNodeToBinarySearchTree(head.getLeft(), integer);
        }
    }

    private void printNodes(Node listOfNodes) {
        while (listOfNodes != null) {
            System.out.print(listOfNodes.getData() + " ");
            listOfNodes = listOfNodes.getRight();
        }
    }

    private Node getHeadOfList(Node listOfNodes) {
        while (listOfNodes.getLeft() != null)
            listOfNodes = listOfNodes.getLeft();
        return listOfNodes;
    }

    private void traverseTreeForTopView(Node node, Node listOfNodes) {
        if (node == null)
            return;
        //
        FlatList flatList = new FlatList(node, 0);
        Queue<FlatList> q = new ArrayDeque<>() ;//ConcurrentLinkedDeque<>();
        q.add(flatList);
        Set<FlatList> flatSet = new TreeSet<>(new Comparator<FlatList>() {
            @Override
            public int compare(FlatList o1, FlatList o2) {
                if (o1 == null || o2 == null)
                    return 0;
                return Integer.compare(o1.index, o2.index);
            }
        });
        flatSet.add(flatList);
        while (!q.isEmpty()){
            FlatList flatNode = q.remove();
            Node node1 = flatNode.getNode();
            FlatList flatLeft = null;
            if (flatNode.node.left != null){
                 flatLeft = new FlatList(node1.left, flatNode.index - 1);
                 q.add(flatLeft);
            }
            FlatList flatRight = null;
            if (flatNode.node.right != null) {
                flatRight = new FlatList(node1.right, flatNode.index + 1);
                q.add(flatRight);
            }
            if (!flatSet.contains(flatLeft)){
                flatSet.add(flatLeft);
            }
            if (!flatSet.contains(flatRight)){
                flatSet.add(flatRight);
            }
        }

        for (FlatList element : flatSet){
            if (element != null)
                System.out.print(element.node.data+" ");
        }

    }

}

class FlatList{

    Node node;
    int index;

    public Node getNode() {
        return node;
    }

    public FlatList(Node node, int index) {
        this.node = node;
        this.index = index;
    }

    public void setNode(Node node) {
        this.node = node;
    }



    @Override
    public int hashCode() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        FlatList flatList = (FlatList) o;
        return index == flatList.index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

