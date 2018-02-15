package com.phonepe.datastore;

public enum DataStore {

	DAYS(30) {
		@Override
		public int getSizeOfBucket(Integer secondVal) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void addRequestsInDayBucket(Integer dayBucketName) {
			// TODO Auto-generated method stub
			
		}
	}, SECONDS(60) {
		@Override
		public int getSizeOfBucket(Integer secondVal) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void addRequestsInDayBucket(Integer dayBucketName) {
			// TODO Auto-generated method stub
			
		}
	}, MINUTES(60) {
		@Override
		public int getSizeOfBucket(Integer secondVal) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void addRequestsInDayBucket(Integer dayBucketName) {
			// TODO Auto-generated method stub
			
		}
	};
	private final int total;
	
	DataStore(int i){
		this.total = i;
	}
	
	abstract public int getSizeOfBucket(Integer secondVal);
	abstract public void addRequestsInDayBucket(Integer dayBucketName) ;
}
