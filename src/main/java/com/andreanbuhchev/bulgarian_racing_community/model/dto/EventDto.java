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

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
