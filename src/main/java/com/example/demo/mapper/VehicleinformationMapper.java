package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Mapper
@Repository
public interface VehicleinformationMapper {
    //查空车辆数
    @Select("select COUNT(*) from vehicleinformation where vehicleNum not in (select arrangeVehicleNum from applyrecord where useCarTime=#{useCarTime}) and vehicleType='A'")
    public Integer selectAFreeCar(LocalDate useCarTime);
    @Select("select COUNT(*) from vehicleinformation where vehicleNum not in (select arrangeVehicleNum from applyrecord where useCarTime=#{useCarTime}) and vehicleType='B'")
    public Integer selectBFreeCar(LocalDate useCarTime);
    @Select("select COUNT(*) from vehicleinformation where vehicleNum not in (select arrangeVehicleNum from applyrecord where useCarTime=#{useCarTime}) and vehicleType='C'")
    public Integer selectCFreeCar(LocalDate useCarTime);

}
