package com.rest.webservices.restwebservices.helloWorld;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }


}
