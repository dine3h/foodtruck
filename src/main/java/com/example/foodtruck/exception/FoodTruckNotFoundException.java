package com.example.foodtruck.exception;

public class FoodTruckNotFoundException extends RuntimeException{

    public FoodTruckNotFoundException(Long id){
        super("Could not find Resource: " + id);
    }

    public FoodTruckNotFoundException(String message){
        super("Could not find Resource: " + message);
    }
}
