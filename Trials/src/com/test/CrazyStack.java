package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CrazyStack {

	private static List<Integer> stackList = new ArrayList<>();
	private static int topIndex = -1;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String operation = sc.next().trim();
			if(operation.equals("push") ) {
				crazyStack(sc.nextInt(), operation, -1);
			}else if(operation.equals("pop") ){
				crazyStack(-1, operation, -1);
			}else {
				int x = sc.nextInt();
				int d = sc.nextInt();
				crazyStack(d, operation, x);
			}
			
		}
		
	}
	/**
	 * Stack with extra property 
	 * inc d x -> increament d to every bottome elements till x
	 * @param value
	 * @param operation
	 * @param index
	 */
	public static void crazyStack(int value, String operation, int index) {
		if(operation.equals("push")) {
			stackList.add(++topIndex, value);
			System.out.println(value);
		}else if(operation.equals("pop")) {
			stackList.remove(topIndex--);
			System.out.println(stackList.get(topIndex));
		}else {
			for (int i = 0; i < index; i++) {
				int val = stackList.get(i);
				stackList.remove(i);
				stackList.add(i, val + value);
			}
			System.out.println(stackList.get(topIndex));
		}
			
	}

}
