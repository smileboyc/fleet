package com.example.demo.entity;

public class Employee {
   String employeeNum ;
   String employeeName ;
   String employeePhone ;
   String employeePassword ;
   String employeePerm ;
   String employeePicture;

   public String getEmployeeNum() {
      return employeeNum;
   }

   public void setEmployeeNum(String employeeNum) {
      this.employeeNum = employeeNum;
   }

   public String getEmployeeName() {
      return employeeName;
   }

   public void setEmployeeName(String employeeName) {
      this.employeeName = employeeName;
   }

   public String getEmployeePhone() {
      return employeePhone;
   }

   public void setEmployeePhone(String employeePhone) {
      this.employeePhone = employeePhone;
   }

   public String getEmployeePassword() {
      return employeePassword;
   }

   public void setEmployeePassword(String employeePassword) {
      this.employeePassword = employeePassword;
   }

   public String getEmployeePerm() {
      return employeePerm;
   }

   public void setEmployeePerm(String employeePerm) {
      this.employeePerm = employeePerm;
   }

   public String getEmployeePicture() {
      return employeePicture;
   }

   public void setEmployeePicture(String employeePicture) {
      this.employeePicture = employeePicture;
   }

   public Employee(String employeeNum, String employeeName, String employeePhone, String employeePassword, String employeePerm, String employeePicture) {
      this.employeeNum = employeeNum;
      this.employeeName = employeeName;
      this.employeePhone = employeePhone;
      this.employeePassword = employeePassword;
      this.employeePerm = employeePerm;
      this.employeePicture = employeePicture;
   }
   public Employee() {
      this.employeeNum = "";
      this.employeeName = "";
      this.employeePhone = "";
      this.employeePassword = "";
      this.employeePerm = "";
      this.employeePicture = "";
   }
}
