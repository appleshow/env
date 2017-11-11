package com.aps.env.dao;

import com.aps.env.entity.ComOrg;
import com.aps.env.entity.ComOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComOrgMapper {
    int countByExample(ComOrgExample example);

    int deleteByExample(ComOrgExample example);

    int deleteByPrimaryKey(Integer orgId);

    int insert(ComOrg record);

    int insertSelective(ComOrg record);

    List<ComOrg> selectByExample(ComOrgExample example);

    ComOrg selectByPrimaryKey(Integer orgId);

    int updateByExampleSelective(@Param("record") ComOrg record, @Param("example") ComOrgExample example);

    int updateByExample(@Param("record") ComOrg record, @Param("example") ComOrgExample example);

    int updateByPrimaryKeySelective(ComOrg record);

    int updateByPrimaryKey(ComOrg record);
}