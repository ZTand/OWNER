package com.teamcp.cleanpos;

public class Restaurant {
    int id;
    int thumbnailId;
    String name;
    String phone;
    String rate;

    public Restaurant(int id, int thumbnailId, String name, String phone, String rate) {
        this.id = id;
        this.thumbnailId = thumbnailId;
        this.name = name;
        this.phone = phone;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(int thumbnailId) {
        this.thumbnailId = thumbnailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Restaurant {" + id + ", " + name + ", " + phone + "," + rate + "}";
    }
}
