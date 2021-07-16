package com.hg.teamwork.controller;

import com.hg.teamwork.common.response.AjaxResult;
import com.hg.teamwork.common.response.DataView;
import com.hg.teamwork.controller.form.PageLimit;
import com.hg.teamwork.rds.model.LearningMaterials;
import com.hg.teamwork.rds.model.UserMst;
import com.hg.teamwork.service.MaterialsService;
import com.hg.teamwork.service.UserMstService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

/**
 * @author ying
 * @describe 资料相关
 * @date 2021/06/22
 */
@Controller
@RequestMapping("materials")
public class MaterialsController extends BaseController {

    @Resource
    MaterialsService materialsService;

    @Resource
    UserMstService userMstService;

    @GetMapping("/getMaterialsList")
    @ResponseBody
    public DataView getMaterialsList(LearningMaterials learningMaterials, PageLimit pageLimit) {
        return materialsService.getMaterialsList(learningMaterials, pageLimit);
    }

    /**
     * 资料上传
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadProfile")
    @ResponseBody
    public AjaxResult uploadProfile(@RequestParam(value = "file", required = true) MultipartFile file) {
        try {
            //String path = ResourceUtils.getURL("classpath:").getPath() + "img";
            String path = "/home/server/profile";
            String fileName = file.getOriginalFilename();
            if (fileName != null) {
                String realPath = path + "/" + fileName;
                File profile = new File(realPath);

                //判断文件父目录是否存在
                if (!profile.getParentFile().exists()) {
                    profile.getParentFile().mkdir();
                }
                // 保存文件
                file.transferTo(profile);
                return success(fileName);
            }
        } catch (Exception e) {

        }
        return error();
    }

    @PostMapping("/saveMaterialsList")
    @ResponseBody
    public DataView saveMaterialsList(String profileName, String loginName, String path) {
        UserMst userMst = userMstService.selectUserByLoginName(loginName);
        LearningMaterials learningMaterials = new LearningMaterials();
        learningMaterials.setProfileName(profileName);
        learningMaterials.setPath(path);
        learningMaterials.setUserId(userMst.getUserId().intValue());
        learningMaterials.setCreateTime(new Date());
        int i = materialsService.materialsInsert(learningMaterials);
        DataView dataView = new DataView();
        dataView.setCode(0);
        dataView.setMsg("成功");
        return dataView;
    }

    @PostMapping("/getMaterials")
    @ResponseBody
    public LearningMaterials getMaterials(Integer id) {
        return materialsService.getMaterials(id);
    }
}
