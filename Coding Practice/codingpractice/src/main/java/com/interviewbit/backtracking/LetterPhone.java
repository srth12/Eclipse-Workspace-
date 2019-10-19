package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Map;

public class LetterPhone {

//    Input: Digit string "23"
//    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    public static void main(String[] args) {

    LetterPhone l = new LetterPhone();
    ArrayList<String> res = l.letterCombinations("123");
    System.out.println(res);

    }

    public ArrayList<String> letterCombinations(String A) {

        Map<String, String> keypad = Map.of(
                "0", "0",
                "1", "1",
                "2", "abc",
                "3", "def",
                "4", "ghi",
                "5", "jkl",
                "6", "mno",
                "7", "pqrs",
                "8", "tuv",
                "9", "wxyz"
        );
        ArrayList<char[]> rem = new ArrayList<>();
        for (char key: A.toCharArray()) {
            String val = keypad.get(""+key);
            System.out.println("key and val are "+ key + val);
            char[] arr_val = val.toCharArray();
            rem.add(arr_val);
        }
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<>();

        return helper(res, curr, rem);
    }

    public static ArrayList<String> helper(ArrayList<String> res, ArrayList<String> curr, ArrayList<char[]> rem){
        if( rem.size() == 0){
            String tmp = "";
            for (int i = 0; i < curr.size(); i++) {
                tmp += curr.get(i);
            }
            res.add(tmp);
            return res;
        }

        char[] sublist = rem.remove(0);
        for (int i = 0; i < sublist.length; i++) {
            ArrayList<String> new_curr = (ArrayList<String>) curr.clone();
            new_curr.add("" + sublist[i]);
            ArrayList<char[]> new_rem = (ArrayList<char[]>) rem.clone();
            helper(res, new_curr, new_rem);
        }
        return res;
    }
}
