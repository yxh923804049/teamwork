package com.hg.teamwork.shiro.realm;

import com.hg.teamwork.rds.model.UserMst;
import com.hg.teamwork.shiro.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 自定义Realm 处理登录 权限
 *
 * @author ding
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //把AuthenticationToken转换成真正的UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        UserMst userMst;
        try {
            userMst = loginService.login(usernamePasswordToken.getUsername(), String.valueOf(usernamePasswordToken.getPassword()));
        } catch (IllegalArgumentException e) {
            throw new AuthenticationException();
        }

        //密码认证,shiro自己做，直接把用户输入的token信息传递进去，shiro自动使用SimpleAuthenticationInfo类做密码认证
        return new SimpleAuthenticationInfo(userMst, String.valueOf(usernamePasswordToken.getPassword()), this.getName());

    }
}