package com.hg.teamwork.shiro.service;

import com.hg.teamwork.rds.model.UserMst;
import com.hg.teamwork.service.UserMstService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author ding
 */
@Component
public class LoginService {

    @Resource
    private PasswordService passwordService;

    @Resource
    private UserMstService userMstService;

    /**
     * 登录
     */
    public UserMst login(String username, String password) {

        // 查询用户信息
        UserMst userMst = userMstService.selectUserByLoginName(username);

        if (userMst == null) {
            throw new IllegalArgumentException();
        }

        passwordService.validate(userMst, password);

        return userMst;
    }
}
