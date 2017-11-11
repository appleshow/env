package com.aps.env.dao;

import com.aps.env.entity.ComResource;
import com.aps.env.entity.ComResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComResourceMapper {
    int countByExample(ComResourceExample example);

    int deleteByExample(ComResourceExample example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(ComResource record);

    int insertSelective(ComResource record);

    List<ComResource> selectByExample(ComResourceExample example);

    ComResource selectByPrimaryKey(Integer resourceId);

    int updateByExampleSelective(@Param("record") ComResource record, @Param("example") ComResourceExample example);

    int updateByExample(@Param("record") ComResource record, @Param("example") ComResourceExample example);

    int updateByPrimaryKeySelective(ComResource record);

    int updateByPrimaryKey(ComResource record);
}