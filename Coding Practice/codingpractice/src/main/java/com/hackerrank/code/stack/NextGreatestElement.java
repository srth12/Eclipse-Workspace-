package com.hackerrank.code.stack;

import java.util.List;
import java.util.Stack;

public class NextGreatestElement {

    public static void main(String[] args) {

        List<Integer> inputs = List.of(4,3,2,3,5,4,3,25,30);

        printNextGreatestElement(inputs);
    }

    public static void printNextGreatestElement(List<Integer> inputs){
        Stack<Integer> stack = new Stack<>();

        for (Integer input : inputs){
            if (stack.empty() || stack.peek() >= input){
                stack.push(input);
            }else {
                while (!stack.isEmpty() && input > stack.peek()){
                    System.out.println("Greatest element of "+ stack.pop() + " is "+ input);
                }
                stack.push(input);
            }
        }

        while (!stack.empty()){
            System.out.println("No next greatest element for  "+ stack.pop() );
        }
    }


}
