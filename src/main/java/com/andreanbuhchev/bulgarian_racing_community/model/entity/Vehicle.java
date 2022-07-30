package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.enums.EngineType;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.enums.VehicleType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(name = "year_of_production",nullable = false)
    private LocalDate yearOfProduction;

    @Column(nullable = false)
    private int hp;

    @Column(nullable = false)
    private int engineSize;

    @Column(nullable = false)
    private int nm;

    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type",nullable = false)
    private EngineType engineType;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type",nullable = false)
    private VehicleType vehicleType;

    @Column(name = "quarter_mile_standing")
    private float quarterMileStanding;

    @Column(name = "mile_standing")
    private float mileStanding;

    @Column(name = "zero_to_hundred")
    private float zeroToHundred;

    @Column(name = "top_speed")
    private int topSpeed;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    private String photo;

    @ManyToOne
    private UserEntity userEntity;

    public Vehicle() {
    }

    public String getBrand() {
        return brand;
    }

    public Vehicle setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public Vehicle setYearOfProduction(LocalDate yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
        return this;
    }

    public int getHp() {
        return hp;
    }

    public Vehicle setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public Vehicle setEngineSize(int engineSize) {
        this.engineSize = engineSize;
        return this;
    }

    public int getNm() {
        return nm;
    }

    public Vehicle setNm(int nm) {
        this.nm = nm;
        return this;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public Vehicle setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public float getQuarterMileStanding() {
        return quarterMileStanding;
    }

    public Vehicle setQuarterMileStanding(float quarterMileStanding) {
        this.quarterMileStanding = quarterMileStanding;
        return this;
    }

    public float getMileStanding() {
        return mileStanding;
    }

    public Vehicle setMileStanding(float mileStanding) {
        this.mileStanding = mileStanding;
        return this;
    }

    public float getZeroToHundred() {
        return zeroToHundred;
    }

    public Vehicle setZeroToHundred(float zeroToHundred) {
        this.zeroToHundred = zeroToHundred;
        return this;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public Vehicle setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Vehicle setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Vehicle setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Vehicle setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
