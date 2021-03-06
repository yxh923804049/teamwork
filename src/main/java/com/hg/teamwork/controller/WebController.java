package com.hg.teamwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ying
 * @describe Web控制器
 * @date 2021/05/19
 */
@Controller
public class WebController {

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "/index2";
    }

    @RequestMapping("/crc")
    public String crc() {
        return "/tool/crc";
    }

    @RequestMapping("/des")
    public String des() {
        return "/tool/des";
    }

    @RequestMapping("/space")
    public String space() {
        return "/tool/space";
    }

    @RequestMapping("/timestamp")
    public String timestamp() {
        return "/tool/timestamp";
    }

    @RequestMapping("/jsonTrans")
    public String jsonTrans() {
        return "/tool/jsonTrans";
    }

    @RequestMapping("/baseConversion")
    public String baseConversion() {
        return "/tool/baseConversion";
    }

    @RequestMapping("/ocr")
    public String ocr() {
        return "/tool/ocr";
    }

    @RequestMapping("/lottery")
    public String lottery() {
        return "/recreation/lottery";
    }

    @RequestMapping("/humpConversion")
    public String humpConversion() {
        return "/tool/humpConversion";
    }

    @RequestMapping("/takeaway")
    public String takeaway() {
        return "/recreation/takeaway";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "/register";
    }

    @RequestMapping("/personalCenter")
    public String personalCenter() {
        return "/user/personalCenter";
    }

    @RequestMapping("/passwordView")
    public String passwordView() {
        return "/user/passwordView";
    }

    @RequestMapping("/twoZeroFourEight")
    public String twoZeroFourEight() {
        return "/recreation/twoZeroFourEight";
    }

    @RequestMapping("/studyDocument")
    public String studyDocument() {
        return "/document/studyDocument";
    }

    @RequestMapping("/studyDocumentAdd")
    public String studyDocumentAdd() {
        return "/document/studyDocumentAdd";
    }

    @RequestMapping("/studyDocumentEdit")
    public String studyDocumentEdit() {
        return "/document/studyDocumentEdit";
    }
}
