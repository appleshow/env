package com.aps.env.dao;

import com.aps.env.entity.HbEnterprise;
import com.aps.env.entity.HbEnterpriseExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HbEnterpriseMapper {
    int countByExample(HbEnterpriseExample example);

    int deleteByExample(HbEnterpriseExample example);

    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(HbEnterprise record);

    int insertSelective(HbEnterprise record);

    List<HbEnterprise> selectByExample(HbEnterpriseExample example);

    HbEnterprise selectByPrimaryKey(Integer enterpriseId);

    int updateByExampleSelective(@Param("record") HbEnterprise record, @Param("example") HbEnterpriseExample example);

    int updateByExample(@Param("record") HbEnterprise record, @Param("example") HbEnterpriseExample example);

    int updateByPrimaryKeySelective(HbEnterprise record);

    int updateByPrimaryKey(HbEnterprise record);

    //----------- additional ---------------
    List<HbEnterprise> selectByPerson(HbEnterprise record);
}