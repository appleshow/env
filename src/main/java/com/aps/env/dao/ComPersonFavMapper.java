package com.aps.env.dao;

import com.aps.env.entity.ComPersonFav;
import com.aps.env.entity.ComPersonFavExample;
import com.aps.env.entity.ComPersonFavKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComPersonFavMapper {
    int countByExample(ComPersonFavExample example);

    int deleteByExample(ComPersonFavExample example);

    int deleteByPrimaryKey(ComPersonFavKey key);

    int insert(ComPersonFav record);

    int insertSelective(ComPersonFav record);

    List<ComPersonFav> selectByExample(ComPersonFavExample example);

    ComPersonFav selectByPrimaryKey(ComPersonFavKey key);

    int updateByExampleSelective(@Param("record") ComPersonFav record, @Param("example") ComPersonFavExample example);

    int updateByExample(@Param("record") ComPersonFav record, @Param("example") ComPersonFavExample example);

    int updateByPrimaryKeySelective(ComPersonFav record);

    int updateByPrimaryKey(ComPersonFav record);
}