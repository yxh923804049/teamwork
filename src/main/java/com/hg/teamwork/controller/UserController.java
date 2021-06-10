package com.hg.teamwork.controller;

import com.hg.teamwork.common.response.AjaxResult;
import com.hg.teamwork.common.util.ShiroUtils;
import com.hg.teamwork.rds.model.UserMst;
import com.hg.teamwork.service.UserMstService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.UUID;

/**
 * @author ying
 * @describe 用户相关
 * @date 2021/06/04
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    UserMstService userMstService;

    /**
     * 头像上传
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadImg")
    @ResponseBody
    public AjaxResult uploadImg(@RequestParam(value = "file", required = true) MultipartFile file) {
        try {
            //String path = ResourceUtils.getURL("classpath:").getPath() + "img";
            String path = "/home/server/img";
            String fileName = file.getOriginalFilename();
            if (fileName != null) {
                String path2 = UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
                String realPath = path + "/" + path2;
                File img = new File(realPath);

                //判断文件父目录是否存在
                if (!img.getParentFile().exists()) {
                    img.getParentFile().mkdir();
                }
                // 保存文件
                file.transferTo(img);
                return success(path2);
            }
        } catch (Exception e) {

        }
        return error();
    }

    /**
     * 根据用户名来修改用户信息
     *
     * @param userMst
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(UserMst userMst) {
        UserMst userMst1 = userMstService.selectUserByLoginName(userMst.getLoginName());
        if (userMst1 != null) {
            userMst.setUserId(userMst1.getUserId());
            userMstService.userUpdate(userMst);
        }
        return success();
    }

    /**
     * 获取用户信息
     *
     * @param loginName
     * @return
     */
    @PostMapping("/select")
    @ResponseBody
    public UserMst select(String loginName) {
        UserMst userMst = userMstService.selectUserByLoginName(loginName);
        return userMst;
    }

    /**
     * 修改密码
     *
     * @param loginName
     * @return
     */
    @PostMapping("/editPassword")
    @ResponseBody
    public AjaxResult editPassword(String loginName, String password) {
        UserMst userMst = userMstService.selectUserByLoginName(loginName);
        if (userMst != null) {
            String salt = ShiroUtils.randomSalt();
            String pwd = new Md5Hash(loginName + password + salt).toHex();
            userMst.setLoginName(loginName);
            userMst.setPassword(pwd);
            userMst.setSalt(salt);
            userMstService.userUpdate(userMst);
            return success();
        }
        return error();
    }

}
