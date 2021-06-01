package com.hg.teamwork.mapper;

import com.hg.teamwork.model.Takeway;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TakewayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Takeway record);

    int insertSelective(Takeway record);

    Takeway selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Takeway record);

    int updateByPrimaryKey(Takeway record);

    Takeway select();

    int selectCount(String name);
}