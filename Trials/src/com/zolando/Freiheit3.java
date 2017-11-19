package com.zolando;

import java.util.concurrent.CompletableFuture;

public class Freiheit3 {

	public static void mani(String[] args) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(()->System.out.println("Hello"));
//		future.t
//		future.ta
	}
	
	public int getMinSteps(int[] A) {
		float sum = 0;
		int avg = 0, max = Integer.MIN_VALUE;
		for(int element : A) {
			sum += Math.abs(element);
			max = Math.max(max, element);
		}
		avg = Math.round(sum/A.length);
		boolean isOdd = (max - Math.abs(avg))%2 !=0? true: false;
		if(isOdd) {
			for(int i=0;i< A.length;i++) {
				if((A[i]-avg)%2 ==0) {
					return -1;
				}
			}
		}else {
			for(int i=0;i< A.length;i++) {
				if((A[i]-avg)%2 !=0) {
					return -1;
				}
			}
		}
		
		return Math.abs(max) - Math.abs(avg);
	}
	
}
