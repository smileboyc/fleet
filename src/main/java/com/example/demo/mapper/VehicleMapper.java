package com.example.demo.mapper;

import com.example.demo.entity.Vehicle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VehicleMapper {
    @Insert("insert into vehicleinformation(vehicleNum,peopleNum,vehicleType)values (#{vehicleNum},#{peopleNum},#{vehicleType})")
    int addVehicle(Vehicle vehicle);

}
