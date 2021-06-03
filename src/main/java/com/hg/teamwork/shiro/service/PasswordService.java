package com.hg.teamwork.shiro.service;

import com.hg.teamwork.rds.model.UserMst;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Component;

/**
 * 登录密码方法
 *
 * @author ding
 */
@Component
public class PasswordService {

    public void validate(UserMst user, String password) {
        if (!matches(user, password)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean matches(UserMst user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
    }


    public String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex();
    }


}
