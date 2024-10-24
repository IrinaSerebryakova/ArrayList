package org.example.exception;

public class IntegerAlreadyExist extends RuntimeException{
    public IntegerAlreadyExist(String message) {
        super(message);
    }
}
