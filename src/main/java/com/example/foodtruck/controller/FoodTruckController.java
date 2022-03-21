package com.example.foodtruck.controller;

import com.example.foodtruck.bean.FoodTruck;
import com.example.foodtruck.exception.FoodTruckNotFoundException;
import com.example.foodtruck.repository.FoodTruckRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/food-trucks")
public class FoodTruckController {

    FoodTruckRepository foodTruckRepository;

    public FoodTruckController(FoodTruckRepository foodTruckRepository) {
        this.foodTruckRepository = foodTruckRepository;
    }

    @GetMapping
    public ResponseEntity<List<FoodTruck>>  getFoodTrucks(@RequestParam(required = false) String name,
                                                         @RequestParam(required = false) String locationDescription){
        List<FoodTruck> foodTruckList;
        if(name == null && locationDescription == null){
            foodTruckList = foodTruckRepository.findAll();
        }else if(name!=null && locationDescription == null){
            foodTruckList = foodTruckRepository.findByApplicant(name).get()
                                                    .stream().collect(Collectors.toList());
            if(foodTruckList.isEmpty()){
                throw new FoodTruckNotFoundException(name);
            }
        }else if(name == null && locationDescription!=null){
            foodTruckList = foodTruckRepository.findByLocationDescription(locationDescription).get()
                                                    .stream().collect(Collectors.toList());
            if(foodTruckList.isEmpty()){
                throw new FoodTruckNotFoundException("Location Description: " + locationDescription);
            }
        }else {
            foodTruckList = foodTruckRepository.searchByApplicantLikeAndLocationDescriptionLike(name, locationDescription).get()
                                                    .stream().collect(Collectors.toList());
            if (foodTruckList.isEmpty()) {
                throw new FoodTruckNotFoundException("Name: " + name + "LocationDescription: " + locationDescription);
            }
        }
        return ResponseEntity.ok(foodTruckList);
    }

    @GetMapping("/{id}")
    public FoodTruck getById(@PathVariable Long id){
        return foodTruckRepository.findById(id).
                orElseThrow(() -> new FoodTruckNotFoundException(id));
    }
}
