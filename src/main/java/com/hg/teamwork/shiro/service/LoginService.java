package com.hg.teamwork.shiro.service;

import com.hg.teamwork.rds.model.UserMst;
import com.hg.teamwork.service.UserMstService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

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
    public UserMst login(String loginName, String password) {

        // 查询用户信息
        UserMst userMst = userMstService.selectUserByLoginName(loginName);

        if (userMst == null) {
            throw new IllegalArgumentException();
        }

        passwordService.validate(userMst, password);

        userMst.setLoginDate(new Date());
        userMstService.userUpdate(userMst);

        return userMst;
    }
}
