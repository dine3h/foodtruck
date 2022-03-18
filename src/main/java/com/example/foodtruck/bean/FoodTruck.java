package com.example.foodtruck.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="FoodTrucks")
public class FoodTruck {

    @Id
    @Column(name="LocationId")
    private Long locationId;
    @Column(name="Applicant")
    private String applicant;
    @Column(name="FacilityType")
    private String facilityType;
    @Column(name="Cnn")
    private Integer cnn;
    @Column(name="LocationDescription")
    private String locationDescription;

    public FoodTruck(){}

    public FoodTruck(Long locationId, String applicant, String facilityType, Integer cnn, String locationDescription) {
        this.locationId = locationId;
        this.applicant = applicant;
        this.facilityType = facilityType;
        this.cnn = cnn;
        this.locationDescription = locationDescription;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public Integer getCnn() {
        return cnn;
    }

    public void setCnn(Integer cnn) {
        this.cnn = cnn;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodTruck that = (FoodTruck) o;
        return Objects.equals(getLocationId(), that.getLocationId()) && Objects.equals(getApplicant(), that.getApplicant()) && Objects.equals(getFacilityType(), that.getFacilityType()) && Objects.equals(getCnn(), that.getCnn()) && Objects.equals(getLocationDescription(), that.getLocationDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocationId(), getApplicant(), getFacilityType(), getCnn(), getLocationDescription());
    }

    @Override
    public String toString() {
        return "MobileTruck{" +
                "locationId=" + locationId +
                ", applicant='" + applicant + '\'' +
                ", facilityType='" + facilityType + '\'' +
                ", cnn=" + cnn +
                ", locationDescription='" + locationDescription + '\'' +
                '}';
    }
}

