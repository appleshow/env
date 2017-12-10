package com.aps.env.dao;

import com.aps.env.entity.HbDataLatest;
import com.aps.env.entity.HbDataLatestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbDataLatestMapper {
    int countByExample(HbDataLatestExample example);

    int deleteByExample(HbDataLatestExample example);

    int deleteByPrimaryKey(String dataGuid);

    int insert(HbDataLatest record);

    int insertSelective(HbDataLatest record);

    List<HbDataLatest> selectByExample(HbDataLatestExample example);

    HbDataLatest selectByPrimaryKey(String dataGuid);

    int updateByExampleSelective(@Param("record") HbDataLatest record, @Param("example") HbDataLatestExample example);

    int updateByExample(@Param("record") HbDataLatest record, @Param("example") HbDataLatestExample example);

    int updateByPrimaryKeySelective(HbDataLatest record);

    int updateByPrimaryKey(HbDataLatest record);
}