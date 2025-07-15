package com.example.demo.entity;

import java.util.Objects;

public class Xs_driver {
    private Integer count;
    private String arrangeDriverNum;

    @Override
    public String toString() {
        return "Xs_driver{" +
                "count=" + count +
                ", arrangeDriverNum='" + arrangeDriverNum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xs_driver xsDriver = (Xs_driver) o;
        return Objects.equals(count, xsDriver.count) && Objects.equals(arrangeDriverNum, xsDriver.arrangeDriverNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, arrangeDriverNum);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getArrangeDriverNum() {
        return arrangeDriverNum;
    }

    public void setArrangeDriverNum(String arrangeDriverNum) {
        this.arrangeDriverNum = arrangeDriverNum;
    }

    public Xs_driver(Integer count, String arrangeDriverNum) {
        this.count = count;
        this.arrangeDriverNum = arrangeDriverNum;
    }

    public Xs_driver() {
    }
}
