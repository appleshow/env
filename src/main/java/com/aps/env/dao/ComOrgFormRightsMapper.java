package com.aps.env.dao;

import com.aps.env.entity.ComOrgFormRights;
import com.aps.env.entity.ComOrgFormRightsExample;
import com.aps.env.entity.ComOrgFormRightsKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ComOrgFormRightsMapper {
    int countByExample(ComOrgFormRightsExample example);

    int deleteByExample(ComOrgFormRightsExample example);

    int deleteByPrimaryKey(ComOrgFormRightsKey key);

    int insert(ComOrgFormRights record);

    int insertSelective(ComOrgFormRights record);

    List<ComOrgFormRights> selectByExample(ComOrgFormRightsExample example);

    ComOrgFormRights selectByPrimaryKey(ComOrgFormRightsKey key);

    int updateByExampleSelective(@Param("record") ComOrgFormRights record, @Param("example") ComOrgFormRightsExample example);

    int updateByExample(@Param("record") ComOrgFormRights record, @Param("example") ComOrgFormRightsExample example);

    int updateByPrimaryKeySelective(ComOrgFormRights record);

    int updateByPrimaryKey(ComOrgFormRights record);

    //----------- additional ---------------
    List<ComOrgFormRights> selectByPersonId(Integer personId);

    List<ComOrgFormRights> selectAssociation(ComOrgFormRights comOrgFormRights);
}