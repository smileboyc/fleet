package com.example.demo.mapper;

import com.example.demo.entity.Applytable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 用车申请表
 */
@Mapper
@Repository
public interface ApplytableMapper {
    @Select("select * from applytable where id =#{id}")
    Applytable selectFromId(Integer id);
}
