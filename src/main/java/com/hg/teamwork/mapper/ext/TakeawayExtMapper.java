package com.hg.teamwork.mapper.ext;

import com.hg.teamwork.model.Takeaway;

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