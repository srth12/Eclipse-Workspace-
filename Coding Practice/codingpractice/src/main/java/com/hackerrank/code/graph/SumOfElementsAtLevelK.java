package com.hackerrank.code.graph;

public class SumOfElementsAtLevelK {

    public static void main(String[] args) {
        String input = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
        int result = getSumOfLevel(input, 2);
        System.out.println(result);
    }

    public static int getSumOfLevel(String input, int k){
        int sum = 0;
        int level = -1;
        for (char c: input.toCharArray()){
            if (c == '(') level++;
            else if (c == ')') level--;
            else {
                if (level == k){
                    sum += Character.getNumericValue(c);
                }
            }
        }

        return sum;
    }

}
