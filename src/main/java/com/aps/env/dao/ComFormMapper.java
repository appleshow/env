package com.aps.env.dao;

import com.aps.env.entity.ComForm;
import com.aps.env.entity.ComFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComFormMapper {
    int countByExample(ComFormExample example);

    int deleteByExample(ComFormExample example);

    int deleteByPrimaryKey(Integer formId);

    int insert(ComForm record);

    int insertSelective(ComForm record);

    List<ComForm> selectByExample(ComFormExample example);

    ComForm selectByPrimaryKey(Integer formId);

    int updateByExampleSelective(@Param("record") ComForm record, @Param("example") ComFormExample example);

    int updateByExample(@Param("record") ComForm record, @Param("example") ComFormExample example);

    int updateByPrimaryKeySelective(ComForm record);

    int updateByPrimaryKey(ComForm record);
}