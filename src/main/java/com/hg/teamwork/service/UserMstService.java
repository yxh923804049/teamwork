package com.hg.teamwork.service;

import com.hg.teamwork.rds.model.UserMst;

/**
 * @author ying
 * @date 2021/06/03
 */
public interface UserMstService {
    /**
     * 根据用户名查询
     *
     * @return
     */
    UserMst selectUserByLoginName(String loginName);
}
