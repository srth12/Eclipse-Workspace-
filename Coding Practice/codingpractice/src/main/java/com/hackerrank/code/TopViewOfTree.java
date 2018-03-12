package com.hackerrank.code;

import java.util.List;

public class TopViewOfTree {

    /**
     *       1
     *     -1  2
     *        3
     *       4
     * @param args
     */
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
        t.topView(node1);
    }

    public void topView(Node node){
        Node listOfNodes = new Node(node.getData());
        traverseTreeForTopView(node, listOfNodes);
        listOfNodes = getHeadOfList(listOfNodes);
        printNodes(listOfNodes);
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
        if (node.getLeft() != null){
            if (listOfNodes.getLeft() == null){
                Node left = new Node(node.getLeft().getData());
                left.setRight(listOfNodes);
                listOfNodes.setLeft(left);
                traverseTreeForTopView(node.getLeft(), listOfNodes.getLeft());

            }else {
                traverseTreeForTopView(node.getLeft(), listOfNodes.getLeft());
            }
        }
        if (node.getRight() != null){
            if (listOfNodes.getRight() == null){
                Node right = new Node(node.getRight().getData());
                right.setLeft(listOfNodes);
                listOfNodes.setRight(right);
                traverseTreeForTopView(node.getRight(), listOfNodes.getRight());
            }else {
                traverseTreeForTopView(node.getRight(), listOfNodes.getRight());
            }
        }
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

