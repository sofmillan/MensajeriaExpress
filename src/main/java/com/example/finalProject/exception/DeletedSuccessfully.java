package com.example.finalProject.exception;

public class DeletedSuccessfully {
    private String message;

    public DeletedSuccessfully(){}
    public DeletedSuccessfully(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
