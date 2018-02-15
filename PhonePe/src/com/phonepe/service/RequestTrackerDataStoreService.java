package com.phonepe.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.phonepe.datastore.RequestTrackerIDataStore;
import com.phonepe.requestmeta.RequestProperties;

public class RequestTrackerDataStoreService {
	
	private RequestTrackerIDataStore requestTrackerDataStore;
	private Map<String, RequestProperties> mapOfRequestsProperties;
	
	public RequestTrackerDataStoreService(RequestTrackerIDataStore requestTrackerDataStore) {
		this.requestTrackerDataStore = requestTrackerDataStore;
		mapOfRequestsProperties = new HashMap<>();
	}
	
	public boolean checkIfLimitExceeded(String requestName, LocalDateTime currentTime) {
		RequestProperties requestMeta = mapOfRequestsProperties.get(requestName);
		//LocalDateTime currentTime = LocalDateTime.now();
		
		if(requestMeta != null) {
			int maxRequestInDay = requestMeta.getMaxRequestInADayAllowed();
			int maxRequestInMinute = requestMeta.getMaxRequestInAMinuteAllowed();
			int maxRequestInSecond = requestMeta.getMaxRequestInASecondAllowed();
			
			if(requestTrackerDataStore.getSizeOfSecondBucket(currentTime.getSecond()) <= maxRequestInSecond 
			    && requestTrackerDataStore.getSizeOfMinuteBucket(currentTime.getMinute()) <= maxRequestInMinute
			    && requestTrackerDataStore.getSizeOfDayBucket(currentTime.getDayOfMonth()) <= maxRequestInDay) {
				return false;
			}else {
				return true;
			}
			
		}else {
			return true;
		}
	}
	
	public void addNewRequest(String requestName, RequestProperties requestProperties) {
		mapOfRequestsProperties.put(requestName, requestProperties);
	}
	
	public boolean updateRequestCount(String requestName) {
		LocalDateTime currentTime = LocalDateTime.now();
		if(checkIfLimitExceeded(requestName, currentTime)) {
			return false;
		}else {
			addNewRequestToDataStore(currentTime);
		}
		return true;
	}
	
	public void addNewRequestToDataStore(LocalDateTime currentTime) {
		//requestTrackerDataStore.addRequestsInSecondBucket()
		requestTrackerDataStore.addRequestsInDayBucket(currentTime.getDayOfMonth());
		requestTrackerDataStore.addRequestsInMinuteBucket(currentTime.getMinute());
		requestTrackerDataStore.addRequestsInSecondBucket(currentTime.getSecond());
	}
	
	
}
