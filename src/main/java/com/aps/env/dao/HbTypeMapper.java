package com.aps.env.dao;

import com.aps.env.entity.HbType;
import com.aps.env.entity.HbTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbTypeMapper {
    int countByExample(HbTypeExample example);

    int deleteByExample(HbTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(HbType record);

    int insertSelective(HbType record);

    List<HbType> selectByExample(HbTypeExample example);

    HbType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") HbType record, @Param("example") HbTypeExample example);

    int updateByExample(@Param("record") HbType record, @Param("example") HbTypeExample example);

    int updateByPrimaryKeySelective(HbType record);

    int updateByPrimaryKey(HbType record);
}