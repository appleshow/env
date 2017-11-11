package com.aps.env.dao;

import com.aps.env.entity.ComOrgForm;
import com.aps.env.entity.ComOrgFormExample;
import com.aps.env.entity.ComOrgFormKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComOrgFormMapper {
    int countByExample(ComOrgFormExample example);

    int deleteByExample(ComOrgFormExample example);

    int deleteByPrimaryKey(ComOrgFormKey key);

    int insert(ComOrgForm record);

    int insertSelective(ComOrgForm record);

    List<ComOrgForm> selectByExample(ComOrgFormExample example);

    ComOrgForm selectByPrimaryKey(ComOrgFormKey key);

    int updateByExampleSelective(@Param("record") ComOrgForm record, @Param("example") ComOrgFormExample example);

    int updateByExample(@Param("record") ComOrgForm record, @Param("example") ComOrgFormExample example);

    int updateByPrimaryKeySelective(ComOrgForm record);

    int updateByPrimaryKey(ComOrgForm record);
}