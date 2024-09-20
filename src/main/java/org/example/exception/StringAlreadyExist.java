package org.example.exception;

public class StringAlreadyExist extends RuntimeException{
    public StringAlreadyExist(String message) {
        super(message);
    }
}
