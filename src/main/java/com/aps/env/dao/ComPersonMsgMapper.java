package com.aps.env.dao;

import com.aps.env.entity.ComPersonMsg;
import com.aps.env.entity.ComPersonMsgExample;
import com.aps.env.entity.ComPersonMsgKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComPersonMsgMapper {
    int countByExample(ComPersonMsgExample example);

    int deleteByExample(ComPersonMsgExample example);

    int deleteByPrimaryKey(ComPersonMsgKey key);

    int insert(ComPersonMsg record);

    int insertSelective(ComPersonMsg record);

    List<ComPersonMsg> selectByExample(ComPersonMsgExample example);

    ComPersonMsg selectByPrimaryKey(ComPersonMsgKey key);

    int updateByExampleSelective(@Param("record") ComPersonMsg record, @Param("example") ComPersonMsgExample example);

    int updateByExample(@Param("record") ComPersonMsg record, @Param("example") ComPersonMsgExample example);

    int updateByPrimaryKeySelective(ComPersonMsg record);

    int updateByPrimaryKey(ComPersonMsg record);
}