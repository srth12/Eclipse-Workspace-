package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class StringBattle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        char[] str1 = sc.next().toCharArray();
        char[] str2 = sc.next().toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        boolean ifLeftGreater = str1[0] > str2[0]?true:false;
        int i = 1;
        for (; i < str2.length; i++) {
			if(ifLeftGreater) {
				if(str1[i] >= str2[i])
					continue;
				break;
			}else {
				if(str1[i] <= str2[i])
					continue;
				break;
			}
		}
        
        if(i == str2.length)
        	  System.out.println("true");
        else
        	  System.out.println("false");
	}

}
