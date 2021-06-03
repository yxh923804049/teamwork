package com.hg.teamwork.shiro.service;

import com.hg.teamwork.rds.model.UserMst;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 登录
     */
    public UserMst login(String username, String password) {

        // 查询用户信息
        UserMst user = userService.selectUserByLoginName(username);

        if (user == null) {
            throw new IllegalArgumentException();
        }

        passwordService.validate(user, password);

        return user;
    }
}
