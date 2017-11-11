package com.aps.env.dao;

import com.aps.env.entity.ComPersonOrg;
import com.aps.env.entity.ComPersonOrgExample;
import com.aps.env.entity.ComPersonOrgKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComPersonOrgMapper {
    int countByExample(ComPersonOrgExample example);

    int deleteByExample(ComPersonOrgExample example);

    int deleteByPrimaryKey(ComPersonOrgKey key);

    int insert(ComPersonOrg record);

    int insertSelective(ComPersonOrg record);

    List<ComPersonOrg> selectByExample(ComPersonOrgExample example);

    ComPersonOrg selectByPrimaryKey(ComPersonOrgKey key);

    int updateByExampleSelective(@Param("record") ComPersonOrg record, @Param("example") ComPersonOrgExample example);

    int updateByExample(@Param("record") ComPersonOrg record, @Param("example") ComPersonOrgExample example);

    int updateByPrimaryKeySelective(ComPersonOrg record);

    int updateByPrimaryKey(ComPersonOrg record);
}