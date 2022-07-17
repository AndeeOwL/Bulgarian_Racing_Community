package com.andreanbuhchev.bulgarian_racing_community.model.view;

public class FastestVehiclesView {

    private String photo;

    private String username;

    private float quarterMileStanding;

    public FastestVehiclesView() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getQuarterMileStanding() {
        return quarterMileStanding;
    }

    public void setQuarterMileStanding(float quarterMileStanding) {
        this.quarterMileStanding = quarterMileStanding;
    }
}
