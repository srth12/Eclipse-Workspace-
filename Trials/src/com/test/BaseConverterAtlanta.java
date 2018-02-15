package com.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseConverterAtlanta {

	/*
	 * Complete the function below.
	 */

	static String convert(long input) {
		String inputInBase7 = Long.toString(input, 7);
		String result ="";
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', 'a');
		map.put('2', 't');
		map.put('3', 'l');
		map.put('4', 's');
		map.put('5', 'i');
		map.put('6', 'n');
		for(char c : inputInBase7.toCharArray()) {
			result+= map.get(c);
		}
		
		return result;

	}

	public static void main(String[] args) throws IOException {
//		Scanner in = new Scanner(System.in);
//		final String fileName = System.getenv("OUTPUT_PATH");
//		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//		String res;
//		long _in;
//		_in = Long.parseLong(in.nextLine());
//
//		res = convert(_in);
//		bw.write(res);
//		bw.newLine();
//
//		bw.close();
		System.out.println(convert(7));
	}
}
