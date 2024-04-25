package com.example.demo.Exceptions;


public class TrainerNotFoundException extends RuntimeException {

    public TrainerNotFoundException(String message) {
        super(message);
    }
}
