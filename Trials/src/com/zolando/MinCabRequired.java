package com.zolando;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MinCabRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BookingDetails> test = new ArrayList<>();
		BookingDetails cab1 = new BookingDetails();
		BookingDetails cab2 = new BookingDetails();
		BookingDetails cab3 = new BookingDetails();
		BookingDetails cab4 = new BookingDetails();
		BookingDetails cab5 = new BookingDetails();
		cab1.setStartTime("12:00");
		cab1.setEndTime("24:00");
		cab2.setStartTime("12:30");
		cab2.setEndTime("13:00");
		cab3.setStartTime("13:00");
		cab3.setEndTime("14:00");
		cab4.setStartTime("13:30");
		cab4.setEndTime("16:00");
		cab5.setStartTime("13:00");
		cab5.setEndTime("13:30");
		 test.addAll(Arrays.asList(cab1,cab2,cab3,cab4,cab5));
		 int res = requiredCab(test);
		System.out.println(res);
	}
	
	public static int requiredCab(List<BookingDetails> bookedTimings) {
		
		Comparator<BookingDetails> cmp = new Comparator<BookingDetails>() {

			@Override
			public int compare(BookingDetails x, BookingDetails y) {
				String[] startTimeX = x.getStartTime().split(":");
				String[] startTimeY = y.getStartTime().split(":");
				String[] endTimeX = x.getEndTime().split(":");
				String[] endTimeY = y.getEndTime().split(":");
				if(startTimeX[0].equals(startTimeY[0])) {
					if(startTimeX[1].equals(startTimeY[1])) {
						if(endTimeX[0].equals(endTimeY[0])) {
							return endTimeX[1].compareTo(endTimeY[1]);
						}else {
							return endTimeX[0].compareTo(endTimeY[0]);
						}
					}else {
						return startTimeX[1].compareTo(startTimeY[1]);
					}
				}else {
					return startTimeX[0].compareTo(startTimeY[0]);
				}
			}
		};
		
		bookedTimings.sort(cmp);
		int totalCabsReq=1;
		for(int i =0;i<bookedTimings.size();i++) {
			int cabsOverlappedForI = 1;
			Stack<String> stack = new Stack<>();
			stack.push(bookedTimings.get(i).getEndTime());
			for(int j = i+1; j< bookedTimings.size(); j++) {
				if(bookedTimings.get(j).getEndTime().compareTo(bookedTimings.get(j).getStartTime()) > 0) {
						cabsOverlappedForI++;
				}else {
					break;
				}
			}
			totalCabsReq = Math.max(totalCabsReq, cabsOverlappedForI);
		}
		return totalCabsReq;
	}

}

class BookingDetails{
	private String startTime;
	private String endTime;
	
	
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
