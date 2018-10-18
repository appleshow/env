package com.aps.env.dao;

import com.aps.env.entity.HbEnforce;
import com.aps.env.entity.HbEnforceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbEnforceMapper {
    int countByExample(HbEnforceExample example);

    int deleteByExample(HbEnforceExample example);

    int deleteByPrimaryKey(String guid);

    int insert(HbEnforce record);

    int insertSelective(HbEnforce record);

    List<HbEnforce> selectByExample(HbEnforceExample example);

    HbEnforce selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") HbEnforce record, @Param("example") HbEnforceExample example);

    int updateByExample(@Param("record") HbEnforce record, @Param("example") HbEnforceExample example);

    int updateByPrimaryKeySelective(HbEnforce record);

    int updateByPrimaryKey(HbEnforce record);
}