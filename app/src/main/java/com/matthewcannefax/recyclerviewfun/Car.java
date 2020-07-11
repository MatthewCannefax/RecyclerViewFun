package com.matthewcannefax.recyclerviewfun;

public class Car {

    private String make;
    private String model;
    private String year;
    private long miles;

    public Car(String make, String model, String year, long miles) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.miles = miles;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getMiles() {
        return miles;
    }

    public void setMiles(long miles) {
        this.miles = miles;
    }
}
