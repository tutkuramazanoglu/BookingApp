package com.example.finaltesttravel;

import java.io.Serializable;

public class Attraction implements Serializable {
    private String id;
    private String title;
    private String address;
    private String price;
    private String picture;
    private String description;

    public Attraction(String id, String title, String address, String price, String picture, String description) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.price = price;
        this.picture = picture;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
