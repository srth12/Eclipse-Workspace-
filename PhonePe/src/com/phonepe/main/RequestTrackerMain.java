package com.phonepe.main;

import com.phonepe.datastore.RequestTrackerIDataStore;
import com.phonepe.datastore.RequestTreackerDataStore;
import com.phonepe.requestmeta.RequestProperties;
import com.phonepe.service.RequestTrackerDataStoreService;

public class RequestTrackerMain {

	public static void main(String[] args) {
		RequestTrackerIDataStore requestTrackerDataStore = new RequestTreackerDataStore();
		RequestProperties property = new RequestProperties(2, 2, 2);
		RequestTrackerDataStoreService requesTrackerService = new RequestTrackerDataStoreService(requestTrackerDataStore);
		requesTrackerService.addNewRequest("test", property);
		requesTrackerService.updateRequestCount("test");
		
	}

}
