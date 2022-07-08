package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.enums.EngineType;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.enums.VehicleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
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

    public float getTopSpeed() {
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
