package com.aps.env.dao;

import com.aps.env.entity.HbTypeItem;
import com.aps.env.entity.HbTypeItemExample;
import com.aps.env.entity.HbTypeItemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbTypeItemMapper {
    int countByExample(HbTypeItemExample example);

    int deleteByExample(HbTypeItemExample example);

    int deleteByPrimaryKey(HbTypeItemKey key);

    int insert(HbTypeItem record);

    int insertSelective(HbTypeItem record);

    List<HbTypeItem> selectByExample(HbTypeItemExample example);

    HbTypeItem selectByPrimaryKey(HbTypeItemKey key);

    int updateByExampleSelective(@Param("record") HbTypeItem record, @Param("example") HbTypeItemExample example);

    int updateByExample(@Param("record") HbTypeItem record, @Param("example") HbTypeItemExample example);

    int updateByPrimaryKeySelective(HbTypeItem record);

    int updateByPrimaryKey(HbTypeItem record);
}