package com.phonepe.datastore;

import java.util.HashMap;
import java.util.Map;

public final class RequestTreackerDataStore implements RequestTrackerIDataStore {
	
	Map<Integer, Integer> requestsInSecondMap;
	Map<Integer, Integer> requestsInMinuteMap;
	Map<Integer, Integer> requestsInDayMap;
	
	private boolean isSecondReachedMax = false;
	private boolean isMinuteReachedMax = false;
	private boolean isDayReachedMax = false;
	
	public RequestTreackerDataStore() {
		requestsInSecondMap = new HashMap<>();
		requestsInMinuteMap = new HashMap<>();
		requestsInDayMap    = new HashMap<>();
	}

	@Override
	public void addRequestsInSecondBucket(Integer secondBucketName) {
		if(secondBucketName == 60)
			isSecondReachedMax = true;
		
		if(secondBucketName == 1 && isSecondReachedMax) {
			requestsInSecondMap = new HashMap<>();
			isSecondReachedMax = false;
		}
		if(requestsInSecondMap.containsKey(secondBucketName)) {
			int size = requestsInSecondMap.get(secondBucketName);
			
			requestsInSecondMap.put(secondBucketName, size+1);
		}else {
			requestsInSecondMap.put(secondBucketName, 1);
		}
	}
	
	public void addRequest(DataStore store, Integer size) {
		
	}

	@Override
	public void addRequestsInMinuteBucket(Integer minuteBucketName) {
		if(minuteBucketName == 60)
			isSecondReachedMax = true;
		
		if(minuteBucketName == 1 && isMinuteReachedMax) {
			requestsInMinuteMap = new HashMap<>();
			isMinuteReachedMax = false;
		}
		
		if(requestsInMinuteMap.containsKey(minuteBucketName)) {
			int size = requestsInMinuteMap.get(minuteBucketName);
			requestsInMinuteMap.put(minuteBucketName, size + 1);
		}else {
			requestsInMinuteMap.put(minuteBucketName, 1);
		}
		
	}

	@Override
	public void addRequestsInDayBucket(Integer dayBucketName) {
		if(dayBucketName == 30)
			isSecondReachedMax = true;
		
		if(dayBucketName == 1 && isDayReachedMax) {
			requestsInDayMap = new HashMap<>();
			isDayReachedMax = false;
		}
		
		if(requestsInDayMap.containsKey(dayBucketName)) {
			int size = requestsInDayMap.get(dayBucketName);
			requestsInDayMap.put(dayBucketName, size + 1);
		}else {
			requestsInDayMap.put(dayBucketName, 1);
		}
		
	}

	@Override
	public int getSizeOfSecondBucket(Integer secondVal) {
		return requestsInSecondMap.get(secondVal) == null? 0: requestsInDayMap.get(secondVal);
	}

	@Override
	public int getSizeOfMinuteBucket(Integer minuteVal) {
		return requestsInMinuteMap.get(minuteVal) == null? 0: requestsInDayMap.get(minuteVal);
		
	}

	@Override
	public int getSizeOfDayBucket(Integer dayVal) {
		return requestsInDayMap.get(dayVal) == null? 0: requestsInDayMap.get(dayVal);
	}

	

}
