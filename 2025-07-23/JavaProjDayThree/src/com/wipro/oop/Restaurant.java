package com.wipro.oop;

public class Restaurant {
    private String name;
    private String location;
    private int capacity;
    private String cuisine;

    public Restaurant() {
    }

    public Restaurant(String name, String location, int capacity, String cuisine) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.cuisine = cuisine;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public String toString() {
        return "Restaurant [name=" + name + ", location=" + location + ", capacity=" + capacity + ", cuisine=" + cuisine + "]";
    }
}
