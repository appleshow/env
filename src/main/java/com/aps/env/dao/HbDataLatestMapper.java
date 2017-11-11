package com.aps.env.dao;

import com.aps.env.entity.HbDataLatest;
import com.aps.env.entity.HbDataLatestExample;
import com.aps.env.entity.HbDataLatestKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbDataLatestMapper {
    int countByExample(HbDataLatestExample example);

    int deleteByExample(HbDataLatestExample example);

    int deleteByPrimaryKey(HbDataLatestKey key);

    int insert(HbDataLatest record);

    int insertSelective(HbDataLatest record);

    List<HbDataLatest> selectByExample(HbDataLatestExample example);

    HbDataLatest selectByPrimaryKey(HbDataLatestKey key);

    int updateByExampleSelective(@Param("record") HbDataLatest record, @Param("example") HbDataLatestExample example);

    int updateByExample(@Param("record") HbDataLatest record, @Param("example") HbDataLatestExample example);

    int updateByPrimaryKeySelective(HbDataLatest record);

    int updateByPrimaryKey(HbDataLatest record);
}