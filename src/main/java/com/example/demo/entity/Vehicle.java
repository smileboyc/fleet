package com.example.demo.entity;

public class Vehicle {
    private String vehicleNum;
    private int peopleNum;
    private  String vehicleType;

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle(String vehicleNum, int peopleNum, String vehicleType) {
        this.vehicleNum = vehicleNum;
        this.peopleNum = peopleNum;
        this.vehicleType = vehicleType;
    }
    public Vehicle() {
        this.vehicleNum = "";
        this.peopleNum = 0;
        this.vehicleType = "";
    }
}
