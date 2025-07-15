package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LeaderMapper {
    //查询队长任务
    @Select(" SELECT CONVERT(id,CHAR(10)) AS id ,CONVERT(useCarTime,CHAR(10)) AS useCarTime , CONVERT(numOfCar,CHAR(2)) AS numOfCar,fleetType FROM leadertask WHERE id NOT IN(SELECT id FROM arrangetable) ")
    public List<Map<String,String>> selectAll( );
//    查询空余车辆
    @Select("SELECT peopleNum,vehicleType,#{useCarTime} AS useCarTime ,vehicleNum FROM  vehicleinformation  WHERE vehicleNum  NOT IN(  SELECT arrangeVehicleNum FROM applyrecord WHERE useCarTime=#{useCarTime}) AND vehicleType=#{vehicleType}")
    public List<Map<String,String>> selectvehicle( Date useCarTime,String vehicleType);

    //    查询空余司机
    @Select("SELECT driverNum,driverType,#{useCarTime} AS useCarTime FROM  driver  WHERE driverNum  NOT IN(  SELECT arrangeDriverNum FROM applyrecord WHERE useCarTime=#{useCarTime}) AND driverType=#{driverType}")
    public List<Map<String,String>> selectdriver( Date useCarTime,String driverType);

//    队长给司机安排任务
    @Insert("INSERT INTO arrangetable (id,arrangeLeaderNum,arrangeVehicleNum,arrangeDriverNum) VALUES(#{id},#{arrangeLeaderNum},#{arrangeVehicleNum},#{arrangeDriverNum})")
    public int LeaderToDriver( String id,String  arrangeLeaderNum,String  arrangeVehicleNum,String  arrangeDriverNum);
//队长查询申请信息
    @Select("SELECT applyNum,CONVERT(useCarTime,CHAR(10)) AS useCarTime,CONVERT(applyDate,CHAR(10)) AS applyDate FROM applytable WHERE id=#{id}")
    public List<Map<String,String>> selectApply2(String id);
//    队长预约信息插入表中

    @Insert("INSERT INTO applyrecord (id,arrangeVehicleNum,arrangeDriverNum,applyNum,useCarTime,applyTime) VALUES(#{id},#{arrangeVehicleNum},#{arrangeDriverNum},#{applyNum},#{useCarTime},#{applyTime})")
    public  int insertApplyRecord0(String id,String arrangeVehicleNum,String arrangeDriverNum,String applyNum,Date useCarTime,Date applyTime);
}
