package com.aps.env.dao;

import com.aps.env.entity.HbTypeitem;
import com.aps.env.entity.HbTypeitemExample;
import com.aps.env.entity.HbTypeitemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbTypeitemMapper {
    int countByExample(HbTypeitemExample example);

    int deleteByExample(HbTypeitemExample example);

    int deleteByPrimaryKey(HbTypeitemKey key);

    int insert(HbTypeitem record);

    int insertSelective(HbTypeitem record);

    List<HbTypeitem> selectByExample(HbTypeitemExample example);

    HbTypeitem selectByPrimaryKey(HbTypeitemKey key);

    int updateByExampleSelective(@Param("record") HbTypeitem record, @Param("example") HbTypeitemExample example);

    int updateByExample(@Param("record") HbTypeitem record, @Param("example") HbTypeitemExample example);

    int updateByPrimaryKeySelective(HbTypeitem record);

    int updateByPrimaryKey(HbTypeitem record);
}