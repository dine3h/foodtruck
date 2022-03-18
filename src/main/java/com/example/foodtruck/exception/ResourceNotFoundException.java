package com.example.foodtruck.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id){
        super("Could not find Resource: " + id);
    }

    public ResourceNotFoundException(String message){
        super("Could not find Resource: " + message);
    }
}
