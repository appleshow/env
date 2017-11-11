package com.aps.env.dao;

import com.aps.env.entity.ComFormRights;
import com.aps.env.entity.ComFormRightsExample;
import com.aps.env.entity.ComFormRightsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComFormRightsMapper {
    int countByExample(ComFormRightsExample example);

    int deleteByExample(ComFormRightsExample example);

    int deleteByPrimaryKey(ComFormRightsKey key);

    int insert(ComFormRights record);

    int insertSelective(ComFormRights record);

    List<ComFormRights> selectByExample(ComFormRightsExample example);

    ComFormRights selectByPrimaryKey(ComFormRightsKey key);

    int updateByExampleSelective(@Param("record") ComFormRights record, @Param("example") ComFormRightsExample example);

    int updateByExample(@Param("record") ComFormRights record, @Param("example") ComFormRightsExample example);

    int updateByPrimaryKeySelective(ComFormRights record);

    int updateByPrimaryKey(ComFormRights record);
}