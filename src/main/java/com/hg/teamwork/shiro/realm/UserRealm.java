package com.hg.teamwork.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * 自定义Realm 处理登录 权限
 *
 * @author ding
 */
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //设置用户名、密码，按理来说应该从数据库中取，但是此时还没有和mybatis整合，所以自己先设置一个
        String name = "root";
        String password = "root";
        //把AuthenticationToken转换成真正的UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        if (!usernamePasswordToken.getUsername().equals(name)) {
            //return null就是自动抛出UnKnownAccount 没有此用户的异常
            return null;
        }

        //密码认证,shiro自己做，直接把用户输入的token信息传递进去，shiro自动使用SimpleAuthenticationInfo类做密码认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, password, this.getName());

        return simpleAuthenticationInfo;

    }
}