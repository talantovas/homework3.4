package com.geeks.homework34;

import java.io.Serializable;
import java.util.ArrayList;

public class Continent implements Serializable {
    private String name;
    private String imageUrl;
    private ArrayList<String> cities;

    public Continent(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.cities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void setCities(ArrayList<String> cities) {
        this.cities = cities;
    }
}



