package com.zolando;

import java.util.HashMap;
import java.util.Map;
/**
 * No of stops required by lift to drop the passengers in queue, with max weight and passengers number
 * @author srth12
 *
 */
public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task3 task = new Task3();

//		int solution = task.solution(new int[] { 40, 40, 100, 80, 20 }, new int[] { 3, 3, 2, 2, 3 }, 3, 5, 200);
		int solution = task.solution(new int[] {1}, new int[] { 1}, 3, 5, 200);
		System.out.println(solution);
	}

	public int solution(int[] A, int[] B, int M, int X, int Y) {

		// write your code in Java SE 8

		int passengersInLift = 0, weightInList = 0, totalTravelled = 0, noOfStops = 0;
		Map<Integer, Integer> map;
		while (totalTravelled < A.length) {
			passengersInLift = 0;
			weightInList = 0;
			map = new HashMap<>();
			while (passengersInLift < X && weightInList < Y && totalTravelled < A.length) {
				passengersInLift += 1;
				weightInList += A[totalTravelled];
				if (passengersInLift > X || weightInList > Y) {
					break;
				}
				if (map.containsKey(B[totalTravelled])) {
					int sameDestnPassengers = map.get(B[totalTravelled]);
					map.put(B[totalTravelled], ++sameDestnPassengers);

				} else {
					map.put(B[totalTravelled], 1);
				}
				totalTravelled++;
			}
			noOfStops += map.size();
			noOfStops += 1;// to count ground floor
		}

		return noOfStops;
	}

}
