package com.example.demo.entity;

import java.sql.Date;
import java.util.Objects;

public class Xs_record {
    private Long id;
    private String arrangeVehicleNum;
    private String arrangeDriverName;
    private String applyName;
    private Date useCarTime;
    private Date applyTime;

    @Override
    public String toString() {
        return "Xs_record{" +
                "id=" + id +
                ", arrangeVehicleNum='" + arrangeVehicleNum + '\'' +
                ", arrangeDriverName='" + arrangeDriverName + '\'' +
                ", applyName='" + applyName + '\'' +
                ", useCarTime=" + useCarTime +
                ", applyTime=" + applyTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xs_record xsRecord = (Xs_record) o;
        return Objects.equals(id, xsRecord.id) && Objects.equals(arrangeVehicleNum, xsRecord.arrangeVehicleNum) && Objects.equals(arrangeDriverName, xsRecord.arrangeDriverName) && Objects.equals(applyName, xsRecord.applyName) && Objects.equals(useCarTime, xsRecord.useCarTime) && Objects.equals(applyTime, xsRecord.applyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, arrangeVehicleNum, arrangeDriverName, applyName, useCarTime, applyTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArrangeVehicleNum() {
        return arrangeVehicleNum;
    }

    public void setArrangeVehicleNum(String arrangeVehicleNum) {
        this.arrangeVehicleNum = arrangeVehicleNum;
    }

    public String getArrangeDriverName() {
        return arrangeDriverName;
    }

    public void setArrangeDriverName(String arrangeDriverName) {
        this.arrangeDriverName = arrangeDriverName;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Date getUseCarTime() {
        return useCarTime;
    }

    public void setUseCarTime(Date useCarTime) {
        this.useCarTime = useCarTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Xs_record(Long id, String arrangeVehicleNum, String arrangeDriverName, String applyName, Date useCarTime, Date applyTime) {
        this.id = id;
        this.arrangeVehicleNum = arrangeVehicleNum;
        this.arrangeDriverName = arrangeDriverName;
        this.applyName = applyName;
        this.useCarTime = useCarTime;
        this.applyTime = applyTime;
    }

    public Xs_record() {
    }
}
