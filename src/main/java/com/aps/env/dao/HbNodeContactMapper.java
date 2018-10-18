package com.aps.env.dao;

import com.aps.env.entity.HbNodeContact;
import com.aps.env.entity.HbNodeContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbNodeContactMapper {
    int countByExample(HbNodeContactExample example);

    int deleteByExample(HbNodeContactExample example);

    int deleteByPrimaryKey(Integer guid);

    int insert(HbNodeContact record);

    int insertSelective(HbNodeContact record);

    List<HbNodeContact> selectByExample(HbNodeContactExample example);

    HbNodeContact selectByPrimaryKey(Integer guid);

    int updateByExampleSelective(@Param("record") HbNodeContact record, @Param("example") HbNodeContactExample example);

    int updateByExample(@Param("record") HbNodeContact record, @Param("example") HbNodeContactExample example);

    int updateByPrimaryKeySelective(HbNodeContact record);

    int updateByPrimaryKey(HbNodeContact record);
}