package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Not working
public class permutation {

    /*public static List<List<Integer>> permute(List<Integer> A){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        permuteHelper(result, curr, A);
        return result;

    }

    public static List<List<Integer>> permuteHelper(List<List<Integer>> result,
                                                    int[]  curr,
                                                    List<Integer> A){
        if(A.size() == 0){
            result.add(curr);
            System.out.println("resutl is :" + result);
            return result;
        }

        for (int i = 0; i < A.size(); i++) {
            curr.add(A.get(i));
            List<Integer> prefix = A.subList(0, i);
            List<Integer> suffix = A.subList(i + 1, A.size());
            prefix.addAll( suffix);
            System.out.println(prefix);
            permuteHelper(result, curr, prefix);
        }
        return null;
    }*/

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
//        List<List<Integer>> result = permute(A);
//        System.out.println(result);
    }
}
