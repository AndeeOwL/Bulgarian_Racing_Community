package com.andreanbuhchev.bulgarian_racing_community.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class EventDto {

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    private String description;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate time;

    private float price;

    public EventDto() {
    }

    public String getName() {
        return name;
    }

    public EventDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public EventDto setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EventDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getTime() {
        return time;
    }

    public EventDto setTime(LocalDate time) {
        this.time = time;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public EventDto setPrice(float price) {
        this.price = price;
        return this;
    }
}
