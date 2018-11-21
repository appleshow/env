package com.aps.env.dao;

import com.aps.env.entity.HbNodeAlarm;
import com.aps.env.entity.HbNodeAlarmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbNodeAlarmMapper {
    int countByExample(HbNodeAlarmExample example);

    int deleteByExample(HbNodeAlarmExample example);

    int deleteByPrimaryKey(String guid);

    int insert(HbNodeAlarm record);

    int insertSelective(HbNodeAlarm record);

    List<HbNodeAlarm> selectByExample(HbNodeAlarmExample example);

    HbNodeAlarm selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") HbNodeAlarm record, @Param("example") HbNodeAlarmExample example);

    int updateByExample(@Param("record") HbNodeAlarm record, @Param("example") HbNodeAlarmExample example);

    int updateByPrimaryKeySelective(HbNodeAlarm record);

    int updateByPrimaryKey(HbNodeAlarm record);
}