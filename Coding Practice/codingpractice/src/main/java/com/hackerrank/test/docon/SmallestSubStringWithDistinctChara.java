package com.hackerrank.test.docon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SmallestSubStringWithDistinctChara {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String S = br.readLine();

        int out_ = SmallestSubString(S);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static int SmallestSubString(String S){
        // Write your code here˙

        int maxDistinctEle = 1;
        int subStringLength = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < S.length() - 1; i++) {
            for (int j = i; j < S.length(); j++) {
                char[] chars = S.substring(i, j+1).toCharArray();
                set.clear();
                for (int k = 0; k < chars.length; k++) {
                    set.add(chars[k]);
                }
                if (maxDistinctEle < set.size() ){
                    maxDistinctEle = set.size();
                    subStringLength = j - i + 1;
                }else if (maxDistinctEle == set.size() && subStringLength > (j - i + 1)){
                    subStringLength = (j - i + 1);
                }

            }
        }

        return subStringLength;
    }
}
