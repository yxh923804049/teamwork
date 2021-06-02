package com.hg.teamwork.service;

import com.hg.teamwork.model.Takeaway;

/**
 * @author ying
 * @date 2021/05/19
 */
public interface TakeawayService {
    /**
     * 插入takeaway表
     *
     * @param takeaway
     */
    void takeawayInsert(Takeaway takeaway);

    /**
     * 查询最新takeaway表数据
     *
     * @return
     */
    Takeaway takeawaySelect();

    /**
     * 查询数量
     *
     * @param name
     * @return
     */
    int takeawayCount(String name);
}
