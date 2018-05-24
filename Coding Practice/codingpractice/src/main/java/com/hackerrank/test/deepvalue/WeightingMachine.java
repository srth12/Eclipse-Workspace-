package com.hackerrank.test.deepvalue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;


/**
 *
 *
 * Assumptions:
 * 1. Inputs are given in order( left node details is given before the right side data)
 */
public class WeightingMachine {


    private static Scanner scanner = new Scanner(System.in);
    private static List<String> results = new ArrayList<>();
    public static void main(String[] args) {

        balanceWeight(getTheInputs());

        System.out.println("--------------- Results --------------");
        IntStream.iterate(results.size() -1, i -> i -1).limit(results.size())
        .forEach(x -> System.out.println(results.get(x)));
    }

    public static WeightBalancer getTheInputs(){
        WeightBalancer head = new WeightBalancer();

        String[] tokens = getNextValidLine().split(",");
        head.balancerName = tokens[0];
        head.left = getTheNode(tokens[1]);
        head.right = getTheNode(tokens[2]);
        return head;
    }

    public static String getNextValidLine(){
        String line = scanner.nextLine();
        while (line.startsWith("#")){
            line = scanner.nextLine();
        }
        return line;
    }

    /**
     * Given the token lets say Number -> The Node; if another string return its Object with its childs
     * @param input
     * @return
     */
    public static WeightBalancer getTheNode(String input){
        if (input == null || input.equals("") )
            return null;
        if (input.matches("[a-zA-Z]\\d")){
            String[] nextTokens = getNextValidLine().split(",");
            WeightBalancer left = getTheNode(nextTokens[1]);
            WeightBalancer right = getTheNode(nextTokens[2]);
            return new WeightBalancer(0, input, left, right);
        }else {
            return new WeightBalancer(Integer.valueOf(input.trim()));
        }
    }

    public static int balanceWeight(WeightBalancer balancer){
        if (balancer.left == null && balancer.right == null)
            return balancer.value;

        int delta = 0;
        int bLeft = balanceWeight(balancer.left);
        int bRight = balanceWeight(balancer.right);

        if (bLeft < bRight){
            delta = bRight - bLeft;
            results.add(balancer.balancerName+"," +delta+",0");
        }else {
            delta = bLeft - bRight;
            results.add(balancer.balancerName+",0," + delta );
        }
        return bLeft + bRight + delta;
    }
}

class WeightBalancer{
    int value;
    String balancerName;
    WeightBalancer left;
    WeightBalancer right;

    public WeightBalancer(int value){
        this.value = value;
        balancerName ="";
        left = null;
        right = null;
    }

    public WeightBalancer(){
        balancerName ="";
        left = null;
        right = null;
    }
    public WeightBalancer(int value, String balancerName, WeightBalancer left, WeightBalancer right) {
        this.value = value;
        this.balancerName = balancerName;
        this.left = left;
        this.right = right;
    }
}

