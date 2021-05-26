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
    public String jsonTrans() { return "/tool/jsonTrans"; }

    @RequestMapping("/baseConversion")
    public String baseConversion() {
        return "/tool/baseConversion";
    }
}
