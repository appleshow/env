package com.aps.env.dao;

import com.aps.env.entity.ComPageshow;
import com.aps.env.entity.ComPageshowExample;
import com.aps.env.entity.ComPageshowKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComPageshowMapper {
    int countByExample(ComPageshowExample example);

    int deleteByExample(ComPageshowExample example);

    int deleteByPrimaryKey(ComPageshowKey key);

    int insert(ComPageshow record);

    int insertSelective(ComPageshow record);

    List<ComPageshow> selectByExample(ComPageshowExample example);

    ComPageshow selectByPrimaryKey(ComPageshowKey key);

    int updateByExampleSelective(@Param("record") ComPageshow record, @Param("example") ComPageshowExample example);

    int updateByExample(@Param("record") ComPageshow record, @Param("example") ComPageshowExample example);

    int updateByPrimaryKeySelective(ComPageshow record);

    int updateByPrimaryKey(ComPageshow record);
}