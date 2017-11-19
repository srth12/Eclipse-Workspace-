package com.zolando;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Freihiet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] {1, 8, -3, 0, 1, 3, -2, 4, 5};
		int sol = solution(6, A);
		System.out.println(sol);
	}
	

    public static int solution(int K, int[] A) {
        // write your code in Java SE 8
    		Arrays.sort(A);
    		int matchCount = 0;
    		Map<Integer, Integer> intCountMap = new HashMap<>();
    		int start = 0, end = A.length-1;
    		for(int i =0;i< A.length;i ++) {
    			if(intCountMap.containsKey(A[i])) {
    				int count = intCountMap.get(A[i]);
    				intCountMap.put(A[i], ++count);
    			}else {
    				intCountMap.put(A[i], 1);
    			}
    		}
    		while(start <= end) {
    			if(K == (A[start]+ A[end])) {
    				int countA = intCountMap.get(A[start]);
    				int countB = intCountMap.get(A[end]);
    				matchCount+=(start==end?countA*countB:2*countA*countB);
    				start+=countA;
    				end-=countB;
    			}else if(K > (A[start]+ A[end])) {
    				start++;
    			}else {
    				end --;
    			}
    		}
    		return matchCount;
    }


}
