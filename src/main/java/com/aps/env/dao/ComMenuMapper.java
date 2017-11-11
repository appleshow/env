package com.aps.env.dao;

import com.aps.env.entity.ComMenu;
import com.aps.env.entity.ComMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComMenuMapper {
    int countByExample(ComMenuExample example);

    int deleteByExample(ComMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(ComMenu record);

    int insertSelective(ComMenu record);

    List<ComMenu> selectByExample(ComMenuExample example);

    ComMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") ComMenu record, @Param("example") ComMenuExample example);

    int updateByExample(@Param("record") ComMenu record, @Param("example") ComMenuExample example);

    int updateByPrimaryKeySelective(ComMenu record);

    int updateByPrimaryKey(ComMenu record);

    //----------- additional ---------------
    List<ComMenu> selectPersonMenu(Integer personId);
}