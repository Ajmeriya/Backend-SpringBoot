package com.example.demo.rest;

public class StudentErrorRespons {
    private int status;
    private String message;
    private long timeStamp;


    public StudentErrorRespons() {
    }

    public StudentErrorRespons(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
//    public StudentErrorRespons(String message)
//    {
//        this.message = message;
//        this.timeStamp = System.currentTimeMillis();
//        this.status = 404;
//    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
