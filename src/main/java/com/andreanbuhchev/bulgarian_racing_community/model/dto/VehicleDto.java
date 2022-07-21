package com.andreanbuhchev.bulgarian_racing_community.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class VehicleDto {

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate yearOfProduction;

    private int hp;

    private int engineSize;

    private int nm;

    @NotBlank
    private String engineType;

    @NotBlank
    private String vehicleType;

    private float quarterMileStanding;

    private float mileStanding;

    private float zeroToHundred;

    private int topSpeed;

    private String description;

    private String photo;

    public VehicleDto() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(LocalDate yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public int getNm() {
        return nm;
    }

    public void setNm(int nm) {
        this.nm = nm;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public float getQuarterMileStanding() {
        return quarterMileStanding;
    }

    public void setQuarterMileStanding(float quarterMileStanding) {
        this.quarterMileStanding = quarterMileStanding;
    }

    public float getMileStanding() {
        return mileStanding;
    }

    public void setMileStanding(float mileStanding) {
        this.mileStanding = mileStanding;
    }

    public float getZeroToHundred() {
        return zeroToHundred;
    }

    public void setZeroToHundred(float zeroToHundred) {
        this.zeroToHundred = zeroToHundred;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
