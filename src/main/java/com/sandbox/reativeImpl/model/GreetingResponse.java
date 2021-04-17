package com.sandbox.reativeImpl.model;

public class GreetingResponse {

    private String name;
    private String greetingMessage;

    public GreetingResponse(String name, String greetingMessage) {
        this.name = name;
        this.greetingMessage = greetingMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public void setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }
}
