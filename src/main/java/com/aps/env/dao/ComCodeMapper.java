package com.aps.env.dao;

import com.aps.env.entity.ComCode;
import com.aps.env.entity.ComCodeExample;
import com.aps.env.entity.ComCodeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComCodeMapper {
    int countByExample(ComCodeExample example);

    int deleteByExample(ComCodeExample example);

    int deleteByPrimaryKey(ComCodeKey key);

    int insert(ComCode record);

    int insertSelective(ComCode record);

    List<ComCode> selectByExample(ComCodeExample example);

    ComCode selectByPrimaryKey(ComCodeKey key);

    int updateByExampleSelective(@Param("record") ComCode record, @Param("example") ComCodeExample example);

    int updateByExample(@Param("record") ComCode record, @Param("example") ComCodeExample example);

    int updateByPrimaryKeySelective(ComCode record);

    int updateByPrimaryKey(ComCode record);
}