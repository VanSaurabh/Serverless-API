package com.serverless.commons.error;

public class AppError {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppError(String message) {
        this.message = message;
    }
}
