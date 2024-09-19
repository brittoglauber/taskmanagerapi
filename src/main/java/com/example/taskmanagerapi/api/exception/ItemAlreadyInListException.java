package com.example.taskmanagerapi.api.exception;

public class ItemAlreadyInListException extends RuntimeException {
    public ItemAlreadyInListException(String message) {
        super(message);
    }
}
