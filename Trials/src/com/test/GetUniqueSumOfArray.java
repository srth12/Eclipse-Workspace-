package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUniqueSumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3};
		int res = getMinimumUniqueSum(A);
		System.out.println(res);
	}
	
	/**
	 * make the array elements unique by incrementing the elements that are duplicate and return the unique sum
	 * ex: 1 2 2 -> 1 2 3 ->sum: 6
	 * @param arr
	 * @return
	 */
	static int getMinimumUniqueSum(int[] arr) {
		int minSum =0;
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				List<Integer> tempList = map.get(arr[i]);
				tempList.add(i);
			}else {
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				map.put(arr[i], temp);
			}
		}
		
		for(int key: map.keySet()) {
			if(map.get(key).size() == 1) {
				minSum+=arr[map.get(key).get(0)];
				continue;
			}
				int count =1;int element = arr[map.get(key).get(0)]+1;
				minSum+=arr[map.get(key).get(0)];
				while(count < map.get(key).size()) {
					if(map.containsKey(element)) {
						++element;
					}else {
						minSum+=element;
						++element;
						count++;
					}
				}
		}
		
		
		return minSum;
	}

}
