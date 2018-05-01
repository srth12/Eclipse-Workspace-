package com.hackerrank.code.loggingservice;

public final class LogFileDao {

    private final long timestamp;
    private final String exceptionName;
    private final long requestId;

    public LogFileDao(long requestId, long timestamp, String exceptionName){
        this.requestId = requestId;
        this.exceptionName = exceptionName;
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public long getRequestId() {
        return requestId;
    }
}
