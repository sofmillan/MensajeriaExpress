package com.example.finalProject.exception;

public class DeletedSuccessfully extends RuntimeException {
    public DeletedSuccessfully() {
    }

    public DeletedSuccessfully(String message) {
        super(message);
    }
}
