package com.hg.teamwork.controller;

import com.hg.teamwork.common.response.AjaxResult;
import com.hg.teamwork.common.util.ShiroUtils;
import com.hg.teamwork.common.util.StringUtils;
import com.hg.teamwork.rds.model.UserMst;
import com.hg.teamwork.service.InvitationCodeService;
import com.hg.teamwork.service.UserMstService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @author ding
 * @describe 登录控制器
 * @date 2021/06/02
 */
@Controller
public class LoginController extends BaseController {

    @Resource
    InvitationCodeService invitationCodeService;

    @Resource
    UserMstService userMstService;

    @PostMapping("/UserLogin")
    @ResponseBody
    public AjaxResult ajaxLogin(String loginName, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return success();
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @PostMapping("/userRegister")
    @ResponseBody
    public AjaxResult UserRegister(String loginName, String password, String code) {
        String invitationCode = invitationCodeService.invitationCodeSelect();
        if (invitationCode.equals(code)) {
            UserMst userMst = userMstService.selectUserByLoginName(loginName);
            if (userMst != null) {
                return error("该用户名已存在");
            }
            String salt = ShiroUtils.randomSalt();
            String pwd = new Md5Hash(loginName + password + salt).toHex();

            UserMst user = new UserMst();
            user.setLoginName(loginName);
            user.setPassword(pwd);
            user.setSalt(salt);
            user.setCreateTime(new Date());
            userMstService.userInsert(user);
            return success("注册成功,返回登录页面");
        } else {
            return error("邀请码错误");
        }
    }
}
