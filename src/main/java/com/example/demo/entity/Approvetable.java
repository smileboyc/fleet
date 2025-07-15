package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Approvetable {
    private Integer num;
    private Integer id;
    private String approveNum;

    @Override
    public String toString() {
        return "Approvetable{" +
                "num=" + num +
                ", id=" + id +
                ", approveNum='" + approveNum + '\'' +
                ", approveDate=" + approveDate +
                ", pass='" + pass + '\'' +
                ", approveReason='" + approveReason + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Approvetable that = (Approvetable) o;
        return Objects.equals(num, that.num) && Objects.equals(id, that.id) && Objects.equals(approveNum, that.approveNum) && Objects.equals(approveDate, that.approveDate) && Objects.equals(pass, that.pass) && Objects.equals(approveReason, that.approveReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, id, approveNum, approveDate, pass, approveReason);
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApproveNum() {
        return approveNum;
    }

    public void setApproveNum(String approveNum) {
        this.approveNum = approveNum;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getApproveReason() {
        return approveReason;
    }

    public void setApproveReason(String approveReason) {
        this.approveReason = approveReason;
    }

    public Approvetable() {
    }

    public Approvetable(Integer num, Integer id, String approveNum, Date approveDate, String pass, String approveReason) {
        this.num = num;
        this.id = id;
        this.approveNum = approveNum;
        this.approveDate = approveDate;
        this.pass = pass;
        this.approveReason = approveReason;
    }

    private Date approveDate;
    private String pass;
    private String approveReason;
}


