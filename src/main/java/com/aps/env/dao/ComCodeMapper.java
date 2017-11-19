package com.aps.env.dao;

import com.aps.env.entity.ComCode;
import com.aps.env.entity.ComCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComCodeMapper {
    int countByExample(ComCodeExample example);

    int deleteByExample(ComCodeExample example);

    int deleteByPrimaryKey(Integer codeId);

    int insert(ComCode record);

    int insertSelective(ComCode record);

    List<ComCode> selectByExample(ComCodeExample example);

    ComCode selectByPrimaryKey(Integer codeId);

    int updateByExampleSelective(@Param("record") ComCode record, @Param("example") ComCodeExample example);

    int updateByExample(@Param("record") ComCode record, @Param("example") ComCodeExample example);

    int updateByPrimaryKeySelective(ComCode record);

    int updateByPrimaryKey(ComCode record);
}