package com.hackerrank.test.alation;

import java.util.*;


class NextBigNumbers {
    
    public static void main(String[] args){
        //[2,4,5,25] -> [4,5,25,-1]
// [4,8,3,9] -> [8,9,9,-1]
//[3,3] -> [-1,-1]
//[4,3, 2,5] -> [5,5,5, -1]

//[7,4,5,6,8,10]
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(4);
        l1.add(5);
        l1.add(25);
        
        
        List<Integer> l2 = new ArrayList<>();
        l2.add(4);l2.add(8);l2.add(3);l2.add(9);
        
        printList(getNextGreatestElementsOf(l2));
        
    }
    
    public static void printList(List<Integer> list) {
        for(Integer number : list) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
    
    public static List<Integer> getNextGreatestElementsOf(List<Integer> inputList){
        Stack<Integer> stack = new Stack<>();
        List<Integer> resultantList = new ArrayList<>();
        for(Integer input : inputList){
            if(stack.isEmpty()){
                stack.push(input);
            }else{
                if(input <= stack.peek()){
                    stack.push(input);
                }else{
                    while(!stack.isEmpty() && input > stack.peek()){
                        
                     resultantList.add( (stack.size() ==0? 0: stack.size() - 1) + (resultantList.size() ==0? 0: (resultantList.size() -1)), input);
                     stack.pop();
                    }
                    stack.push(input);
                }
                
            }

        }
        int remainingElement = stack.size();
        for(int i = inputList.size() - remainingElement; i < inputList.size(); i++  ){
            resultantList.add(i, -1);
        }
        
        return resultantList;
    }
}
