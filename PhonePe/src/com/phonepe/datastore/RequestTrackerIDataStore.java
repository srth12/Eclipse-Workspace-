package com.phonepe.datastore;

public interface RequestTrackerIDataStore {

	public void addRequestsInSecondBucket(Integer secondBucketName);
	public void addRequestsInMinuteBucket(Integer minuteBucketName);
	public void addRequestsInDayBucket(Integer dayBucketName);
	
	public int getSizeOfSecondBucket(Integer secondVal);
	public int getSizeOfMinuteBucket(Integer minuteVal);
	public int getSizeOfDayBucket(Integer dayVal);
}
