package com.example.demo.mapper;

import com.example.demo.entity.Xs;
import com.example.demo.entity.Xs_driver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface XsMapper {
    @Select("SELECT vi.vehicleType AS vehicleType, COUNT(*) AS count " +
            "FROM vehicleinformation vi " +
            "JOIN historyrecord hr ON vi.vehicleNum = hr.arrangeVehicleNum " +
            "WHERE MONTH(hr.applyTime) = #{month} " +
            "GROUP BY vi.vehicleType")
    public List<Xs> findAllXs(@Param("month") Integer month);

    //司机统计
    @Select("SELECT hr.arrangeDriverNum AS arrangeDriverNum, COUNT(*) AS count " +
            "FROM historyrecord hr " +
            "WHERE MONTH(hr.applyTime) = #{month} " +
            "GROUP BY hr.arrangeDriverNum")
    List<Xs_driver> findAllXs_driver(@Param("month") Integer month);
}
