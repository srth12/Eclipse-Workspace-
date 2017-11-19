package com.zolando;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int solution(String S, int K) {
	        // write your code in Java SE 8
		 
		 String words[] = S.split(" ");
		 int smsLength = 0;
		 int count = 0;
		 int i = 0;
		 
		 while ( i < words.length) {
			 if(smsLength == 0) {
				 if(words[i].length() > K) {
					 return -1;
				 }else {
					 smsLength = words[i].length();
					 i++;
					 if(i==words.length) {
						 count++;
					 }
				 }
			 }else {
				 if(smsLength + words[i].length() + 1 > K) {
					 smsLength = 0;
					 count ++;
				 }else {
					 smsLength = smsLength + words[i].length() + 1;
					 i++;
					 if(i==words.length) {
						 count++;
					 }
				 }
			 }
		 }
		 return count;
	    }

}
