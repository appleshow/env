package com.aps.env.dao;

import com.aps.env.entity.HbNode;
import com.aps.env.entity.HbNodeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HbNodeMapper {
    int countByExample(HbNodeExample example);

    int deleteByExample(HbNodeExample example);

    int deleteByPrimaryKey(HbNode hbNode);

    int insert(HbNode record);

    int insertSelective(HbNode record);

    List<HbNode> selectByExample(HbNodeExample example);

    HbNode selectByPrimaryKey(Integer nodeId);

    int updateByExampleSelective(@Param("record") HbNode record, @Param("example") HbNodeExample example);

    int updateByExample(@Param("record") HbNode record, @Param("example") HbNodeExample example);

    int updateByPrimaryKeySelective(HbNode record);

    int updateByPrimaryKey(HbNode record);

    //----------- additional ---------------
    List<HbNode> selectAssociation(HbNode record);

    List<HbNode> selectByPerson(HbNode record);

    List<HbNode> selectAssociationByPerson(HbNode record);
}