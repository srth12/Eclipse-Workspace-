package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUniqueSumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int getMinimumUniqueSum(int[] arr) {
		int minSum =0;
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				List<Integer> tempList = map.get(arr[i]);
				tempList.add(i);
			}else {
				map.put(arr[i], Arrays.asList(i));
			}
		}
		
		for(int key: map.keySet()) {
			if(map.get(key).size() == 1) {
				minSum+=map.get(key).get(0);
				continue;
			}
			for(int index = 1; index < map.get(key).size(); index++) {
				for(int i = key+1; ;i++) {
					List<Integer> list = map.get(key);
					if(map.get(i) == null) {
						minSum+= i;
					}
				}
			}
		}
		
		
		return minSum;
	}

}
