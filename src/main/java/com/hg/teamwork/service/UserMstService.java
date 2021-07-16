package com.hg.teamwork.service;

import com.hg.teamwork.rds.model.UserMst;

import java.util.List;

/**
 * @author ying
 * @date 2021/06/03
 */
public interface UserMstService {
    /**
     * 根据用户名查询
     *
     * @param loginName
     * @return
     */
    UserMst selectUserByLoginName(String loginName);

    /**
     * 插入用户
     *
     * @param userMst
     */
    void userInsert(UserMst userMst);


    /**
     * 修改用户
     *
     * @param userMst
     */
    void userUpdate(UserMst userMst);

    /**
     * 查询所有用户
     * @return
     */
    List<UserMst> selectUsers();
}
