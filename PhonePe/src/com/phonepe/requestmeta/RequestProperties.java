package com.phonepe.requestmeta;

public final class RequestProperties {

	private final int maxRequestInASecondAllowed;
	private final int maxRequestInAMinuteAllowed;
	private final int maxRequestInADayAllowed;
	
	public int getMaxRequestInASecondAllowed() {
		return maxRequestInASecondAllowed;
	}

	public int getMaxRequestInAMinuteAllowed() {
		return maxRequestInAMinuteAllowed;
	}

	public int getMaxRequestInADayAllowed() {
		return maxRequestInADayAllowed;
	}

	public RequestProperties(int secondMax, int minuteMax, int dayMax) {
		this.maxRequestInASecondAllowed = secondMax;
		this.maxRequestInAMinuteAllowed = minuteMax;
		this.maxRequestInADayAllowed = dayMax;
	}
	
}
