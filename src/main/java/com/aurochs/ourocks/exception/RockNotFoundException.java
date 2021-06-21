package com.aurochs.ourocks.exception;

public class RockNotFoundException extends RuntimeException{
    public RockNotFoundException(String message) {
        super(message);
    }
}
