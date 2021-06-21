package com.aurochs.ourocks.exception;

public class BeerNotFoundException extends RuntimeException{
    public BeerNotFoundException(String message) {
        super(message);
    }
}
