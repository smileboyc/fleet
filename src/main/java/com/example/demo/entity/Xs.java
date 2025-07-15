package com.example.demo.entity;

import java.util.Objects;

public class Xs {
    private Integer count;
    private String vehicleType;

    @Override
    public String toString() {
        return "Xs{" +
                "count=" + count +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xs xs = (Xs) o;
        return Objects.equals(count, xs.count) && Objects.equals(vehicleType, xs.vehicleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, vehicleType);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Xs() {
    }

    public Xs(Integer count, String vehicleType) {
        this.count = count;
        this.vehicleType = vehicleType;
    }

}
