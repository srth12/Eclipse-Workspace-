package com.hackerrank.test.docon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class LongestPalandrome {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String s = br.readLine();

            String out_ = solve(s);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static String solve(String s){
        // Write your code here

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char distinctChar = ' ';
        StringBuffer result = new StringBuffer("");
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1]) {
                result.append(chars[i++]);
            }else if (i !=0 && chars[i] == chars[i - 1]){
                if (distinctChar == ' ')
                    distinctChar = chars[i];
            }
            else if (distinctChar == ' '){
                distinctChar = chars[i];
            }
        }
        if (result.length() == 0)
            return s.substring(0, 1);
        if (distinctChar == ' ')
            return result.append(result.reverse()).toString();
        else return result.toString() + distinctChar + result.reverse().toString();
    }
}
