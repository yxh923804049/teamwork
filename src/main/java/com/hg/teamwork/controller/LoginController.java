package com.hg.teamwork.controller;

import com.hg.teamwork.common.response.AjaxResult;
import com.hg.teamwork.common.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author ding
 * @describe 登录控制器
 * @date 2021/06/02
 */
@Controller
public class LoginController extends BaseController {

    @PostMapping("/UserLogin")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
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


    @GetMapping("/register")
    public String register() {
        return "register";
    }

   /* @PostMapping("/register")
    @ResponseBody
    public AjaxResult ajaxRegister(UserMst user) {

        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }*/
}
