package com.interviewbit;

public class factorial {

    public static int factorial(int x){
        if( x == 1)
            return 1;

        return x * factorial(x - 1);
    }

    public static Node reverse_list(Node n){
        if(n.getNext_node() == null){
            return n;
        }
        Node new_parent_node = reverse_list(n.getNext_node());
        new_parent_node.setNext_node(n);
        n.setNext_node(null);
        return n;
    }

    public static void print_list(Node n){
        if(n == null)
            return;
        System.out.println(n.getX());
        print_list(n.getNext_node());
    }

    public static void main(String args[]){
        System.out.println(factorial(10));
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.setNext_node(n2);
        n2.setNext_node(n3);
        n3.setNext_node(n4);
        n4.setNext_node(n5);
        reverse_list(n1);
        print_list(n5);

    }
}

class Node{
    public Node(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int x;
    private Node next_node = null;

    public void setNext_node(Node nn){
        this.next_node = nn;
    }
    public Node getNext_node(){
        return this.next_node;
    }
}