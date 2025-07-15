package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface ManageMapper {
//    查询未审核的任务
    @Select("SELECT CONVERT(id,CHAR(4)) AS id, applyNum,CONVERT(applyDate,CHAR(10)) AS applyDate,CONVERT(useCarTime,CHAR(10)) AS useCarTime,CONVERT(peopleNum,CHAR(3)) AS peopleNum ,applyReason,vehicleType FROM applytable WHERE id  NOT IN (SELECT  id FROM approvetable )")
    public List<Map<String,String>> selectAll();

//    管理员派任务给队长
    @Insert(" INSERT INTO leadertask (useCarTime ,fleetType,numOfCar,id) VALUE(#{useCarTime},#{fleetType},#{numOfCar},#{id})")
    public int arrangeLeader(Date useCarTime,String fleetType,int numOfCar,int id);
    //添加新用户
    @Insert("INSERT INTO employee (employeeNum ,employeeName,employeePhone,employeePassword,employeePerm,employeePicture) VALUE(#{employeeNum},#{employeeName},#{employeePhone},#{employeePassword},#{employeePerm},#{employeePicture})")
    public int EmployeeaddAll(Employee employee);
}
