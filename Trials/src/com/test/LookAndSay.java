package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class LookAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LookAndSay("11",2));
	}

	
	static String LookAndSay(String start, int n) {
		String input = start;
		for(int i=0;i<n;i++) {
			input = LookAndSay(input);
		}
		return input;


    }
	
	static String LookAndSay(String start) {
		List<String> list = new ArrayList<>();
		
		for (int j = 0; j < start.length(); j++) {
			int count = 1;
			for (int i = j+1; i < start.length(); i++) {
				if(start.charAt(j) == start.charAt(i)) {
					count++;
				}else {
					break;
				}
				j+=count-1;
			}
			list.add(""+count+start.charAt(j));
		}
		String result ="";
		for( String input : list) {
			result+= input;
		}
		return result;
	}
}
class MetaData{
	Character key;
	Integer count;
	public Character getKey() {
		return key;
	}
	public void setKey(Character key) {
		this.key = key;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
