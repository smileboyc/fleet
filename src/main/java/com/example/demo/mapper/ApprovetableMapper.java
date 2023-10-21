package com.example.demo.mapper;

import com.example.demo.entity.Approvetable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ApprovetableMapper {
    @Insert("insert into approvetable(id,approveNum,approveDate,pass,approveReason) values(#{id},#{approveNum},#{approveDate},#{pass},#{approveReason})")
    public int insert(Approvetable approvetable);
}
