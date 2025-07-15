package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Applytable {
    private Integer id;
    private  String applyNum;
    private LocalDateTime applyDate;
    private LocalDate useCarTime;
    private Integer peopleNum;
    private String applyReason;
    private String vehicleType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applytable that = (Applytable) o;
        return Objects.equals(id, that.id) && Objects.equals(applyNum, that.applyNum) && Objects.equals(applyDate, that.applyDate) && Objects.equals(useCarTime, that.useCarTime) && Objects.equals(peopleNum, that.peopleNum) && Objects.equals(applyReason, that.applyReason) && Objects.equals(vehicleType, that.vehicleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applyNum, applyDate, useCarTime, peopleNum, applyReason, vehicleType);
    }

    @Override
    public String toString() {
        return "Appaytable{" +
                "id=" + id +
                ", applyNum='" + applyNum + '\'' +
                ", applyDate=" + applyDate +
                ", useCarTime=" + useCarTime +
                ", peopleNum=" + peopleNum +
                ", applyReason='" + applyReason + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(String applyNum) {
        this.applyNum = applyNum;
    }

    public LocalDateTime getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDateTime applyDate) {
        this.applyDate = applyDate;
    }

    public LocalDate getUseCarTime() {
        return useCarTime;
    }

    public void setUseCarTime(LocalDate useCarTime) {
        this.useCarTime = useCarTime;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Applytable(Integer id, String applyNum, LocalDateTime applyDate, LocalDate useCarTime, Integer peopleNum, String applyReason, String vehicleType) {
        this.id = id;
        this.applyNum = applyNum;
        this.applyDate = applyDate;
        this.useCarTime = useCarTime;
        this.peopleNum = peopleNum;
        this.applyReason = applyReason;
        this.vehicleType = vehicleType;
    }

    public Applytable() {
    }
}
