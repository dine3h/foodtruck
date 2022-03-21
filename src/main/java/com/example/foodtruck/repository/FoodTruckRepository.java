package com.example.foodtruck.repository;


import com.example.foodtruck.bean.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {

    Optional<Set<FoodTruck>> findByApplicant(String name);

    Optional<Set<FoodTruck>> findByLocationDescription(String location);

    @Query("SELECT f FROM FoodTruck f WHERE f.applicant LIKE %:name% AND f.locationDescription LIKE %:locationDescription%")
    Optional<Set<FoodTruck>> searchByApplicantLikeAndLocationDescriptionLike(@Param("name") String name, @Param("locationDescription") String locationDescription);
}
