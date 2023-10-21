package com.example.demo.mapper;

import javafx.scene.chart.PieChart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface EmployeeMapper {
    //员工登录
        @Select("SELECT employeeNum,employeePassword,employeePerm FROM employee where employeeNum=#{employeeNum}")
        List<Map<String,String>> Login(String employeeNum, String employeePassword, HttpServletRequest request, HttpServletResponse response);

       @Insert("insert into applytable(applyNum,useCarTime,peopleNum,applyReason,vehicleType)values (#{applyNum},#{useCarTime},#{peopleNum},#{applyReason},#{vehicleType})")
       public int apply(Date useCarTime, int  peopleNum, String  applyReason, String  vehicleType, String applyNum, HttpServletRequest request, HttpServletResponse response);

       //查询待审核记录
       @Select("SELECT  applyNum,CONVERT(applyDate,CHAR(10)) AS applyDate,CONVERT(useCarTime,CHAR(10)) AS useCarTime,CONVERT(peopleNum,CHAR(3)) AS peopleNum ,applyReason,vehicleType FROM applytable WHERE id  NOT IN (SELECT  id FROM approvetable ) AND applyNum=#{applyNum}")
        public  List<Map<String,String>> selectApply1(String applyNum);

       //查询已通过记录
       @Select("SELECT CONVERT(id,CHAR(4)) as id,applyNum,CONVERT(applyDate,CHAR(10)) AS applyDate,CONVERT(useCarTime,CHAR(10)) AS useCarTime,CONVERT(peopleNum,CHAR(3)) AS peopleNum ,applyReason,vehicleType FROM applytable WHERE id  IN (SELECT  id FROM applyrecord  )  AND applyNum=#{applyNum}")
       public  List<Map<String,String>> selectApply2(String applyNum);

    //    未通过的预约记录
    @Select("SELECT CONVERT(applyDate,CHAR(10)) AS applyDate ,vehicleType,CONVERT(useCarTime,CHAR(10))   AS useCarTime,CONVERT(peopleNum,CHAR(10))   AS peopleNum ,applytable.applyReason AS applyReason,approvetable.approveReason AS approveReason FROM applytable LEFT JOIN approvetable ON applytable.id=approvetable.id  WHERE  pass='否' AND applyNum=#{applyNum}")
    public  List<Map<String,String>> selectApply3(String applyNum);
       //查询空闲车辆
        @Select("SELECT peopleNum,vehicleType,#{useCarTime} AS useCarTime ,CONVERT(COUNT(*),CHAR(2)) AS Num FROM  vehicleinformation  WHERE vehicleNum  NOT IN(  SELECT arrangeVehicleNum FROM applyrecord WHERE useCarTime=#{useCarTime}) AND vehicleType=#{vehicleType}")
        public  List<Map<String,String>> selectVehicle(String useCarTime,String vehicleType);

    //查询预约车辆信息
    @Select("SELECT   arrangeVehicleNum,employeeName,employeePhone,employeePicture FROM arrangetable LEFT JOIN employee ON arrangetable.arrangeDriverNum=employee.employeeNum WHERE id=#{id}")
    public  List<Map<String,String>> selectVehicle2(String id);
}
