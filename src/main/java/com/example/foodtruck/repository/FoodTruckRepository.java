package com.example.foodtruck.repository;


import com.example.foodtruck.bean.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {

    Optional<Set<FoodTruck>> findByApplicant(String name);

    Optional<Set<FoodTruck>> findByLocationDescription(String location);

}
