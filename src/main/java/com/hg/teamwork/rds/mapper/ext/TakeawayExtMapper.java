package com.hg.teamwork.rds.mapper.ext;

import com.hg.teamwork.rds.model.Takeaway;

import java.util.List;

/**
 * @author ying
 * @describe 手写Mapper解耦
 * @date 2021/05/19
 */
public interface TakeawayExtMapper {

    /**
     * 查询所有数据（例子）
     *
     * @return
     */
    List<Takeaway> select();
}