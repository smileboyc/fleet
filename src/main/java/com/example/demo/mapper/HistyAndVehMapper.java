package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HistyAndVehMapper {
    //车队统计
    @Select("SELECT vi.vehicleType, COUNT(*) AS count " +
            "FROM vehicleinformation vi " +
            "JOIN historyrecord hr ON vi.vehicleNum = hr.arrangeVehicleNum " +
            "WHERE MONTH(hr.applyTime) = #{month} " +
            "GROUP BY vi.vehicleType")
    List<Map<Object, Object>> getVehicleTypeCountsByMonth(Integer month);

    //司机统计
    @Select("SELECT hr.arrangeDriverNum AS arrangeDriverNum, COUNT(*) AS count " +
            "FROM historyrecord hr " +
            "WHERE MONTH(hr.applyTime) = #{month} " +
            "GROUP BY hr.arrangeDriverNum")
    List<Map<Object, Object>> getDriverUsageCountsByMonth(Integer month);
}
