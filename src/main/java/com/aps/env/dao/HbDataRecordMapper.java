package com.aps.env.dao;

import com.aps.env.entity.HbDataRecord;
import com.aps.env.entity.HbDataRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbDataRecordMapper {
    int countByExample(HbDataRecordExample example);

    int deleteByExample(HbDataRecordExample example);

    int deleteByPrimaryKey(String guid);

    int insert(HbDataRecord record);

    int insertSelective(HbDataRecord record);

    List<HbDataRecord> selectByExample(HbDataRecordExample example);

    HbDataRecord selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") HbDataRecord record, @Param("example") HbDataRecordExample example);

    int updateByExample(@Param("record") HbDataRecord record, @Param("example") HbDataRecordExample example);

    int updateByPrimaryKeySelective(HbDataRecord record);

    int updateByPrimaryKey(HbDataRecord record);
}