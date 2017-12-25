package com.aps.env.dao;

import com.aps.env.entity.HbPark;
import com.aps.env.entity.HbParkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbParkMapper {
    int countByExample(HbParkExample example);

    int deleteByExample(HbParkExample example);

    int deleteByPrimaryKey(String parkGuid);

    int insert(HbPark record);

    int insertSelective(HbPark record);

    List<HbPark> selectByExample(HbParkExample example);

    HbPark selectByPrimaryKey(String parkGuid);

    int updateByExampleSelective(@Param("record") HbPark record, @Param("example") HbParkExample example);

    int updateByExample(@Param("record") HbPark record, @Param("example") HbParkExample example);

    int updateByPrimaryKeySelective(HbPark record);

    int updateByPrimaryKey(HbPark record);
}