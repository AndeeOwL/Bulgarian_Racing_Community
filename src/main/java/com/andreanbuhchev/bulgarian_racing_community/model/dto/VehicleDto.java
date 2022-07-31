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

    public VehicleDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public VehicleDto setModel(String model) {
        this.model = model;
        return this;
    }

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public VehicleDto setYearOfProduction(LocalDate yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
        return this;
    }

    public int getHp() {
        return hp;
    }

    public VehicleDto setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public VehicleDto setEngineSize(int engineSize) {
        this.engineSize = engineSize;
        return this;
    }

    public int getNm() {
        return nm;
    }

    public VehicleDto setNm(int nm) {
        this.nm = nm;
        return this;
    }

    public String getEngineType() {
        return engineType;
    }

    public VehicleDto setEngineType(String engineType) {
        this.engineType = engineType;
        return this;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public VehicleDto setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public float getQuarterMileStanding() {
        return quarterMileStanding;
    }

    public VehicleDto setQuarterMileStanding(float quarterMileStanding) {
        this.quarterMileStanding = quarterMileStanding;
        return this;
    }

    public float getMileStanding() {
        return mileStanding;
    }

    public VehicleDto setMileStanding(float mileStanding) {
        this.mileStanding = mileStanding;
        return this;
    }

    public float getZeroToHundred() {
        return zeroToHundred;
    }

    public VehicleDto setZeroToHundred(float zeroToHundred) {
        this.zeroToHundred = zeroToHundred;
        return this;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public VehicleDto setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VehicleDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public VehicleDto setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}
