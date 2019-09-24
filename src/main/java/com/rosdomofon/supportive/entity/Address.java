package com.rosdomofon.supportive.entity;

public class Address {
    private String city;
    private String street;
    private String house;
    private String entrance;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    @Override
    public String toString() {
        return "г." +
                city +
                ", ул." +
                street +
                ", д." +
                house +
                ", п." +
                entrance;
    }
}
