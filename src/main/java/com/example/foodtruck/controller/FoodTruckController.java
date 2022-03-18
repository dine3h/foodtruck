package com.example.foodtruck.controller;

import com.example.foodtruck.bean.FoodTruck;
import com.example.foodtruck.exception.ResourceNotFoundException;
import com.example.foodtruck.repository.FoodTruckRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class FoodTruckController {

    FoodTruckRepository foodTruckRepository;

    public FoodTruckController(FoodTruckRepository foodTruckRepository) {
        this.foodTruckRepository = foodTruckRepository;
    }

    @GetMapping("/foodtrucks")
    public List<FoodTruck> findAll(){
        return foodTruckRepository.findAll();
    }

    @GetMapping("/foodtruck/{id}")
    public FoodTruck findById(@PathVariable Long id){
        return foodTruckRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @GetMapping("foodTruck/{name}")
    public Set<FoodTruck> findByName(@PathVariable String name){
        return foodTruckRepository.findByApplicant(name)
                .orElseThrow(() -> new ResourceNotFoundException(name));
    }

    @GetMapping("/foodtruck/{location}")
    public Set<FoodTruck> findByLocation(@PathVariable String name){
        return foodTruckRepository.findByLocationDescription(name)
                .orElseThrow(() -> new ResourceNotFoundException(name));
    }
}
