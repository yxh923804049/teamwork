package com.hg.teamwork.controller;

import com.hg.teamwork.model.Takeaway;
import com.hg.teamwork.service.TakeawayService;
import com.hg.teamwork.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author ying
 * @describe 业务控制器
 * @date 2021/05/19
 */
@RestController
public class BusinessController {

    static String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
    static String accessToken = "";

    @Resource
    TakeawayService takeawayServer;

    /**
     * Crc加密
     *
     * @return
     */
    @PostMapping("/crcEncrypt")
    public String crcEncrypt(String preCrc) {
        String aftCrc;
        try {
            aftCrc = Instrument.crcMac(preCrc);
        } catch (Exception e) {
            aftCrc = "加密前的值不符合规范";
        }
        return aftCrc;
    }

    /**
     * des加密
     *
     * @param preEncryptDes
     * @return
     */
    @PostMapping("/desEncrypt")
    public String desEncrypt(String preEncryptDes) {
        String aftEncryptDes;
        try {
            DesUtils des = new DesUtils();
            aftEncryptDes = des.encrypt(preEncryptDes);
        } catch (Exception e) {
            aftEncryptDes = "加密前的值不符合规范";
        }
        return aftEncryptDes;
    }

    /**
     * des解密
     *
     * @param preDecryptDes
     * @return
     */
    @PostMapping("/desDecrypt")
    public String desDecrypt(String preDecryptDes) {
        String aftDecryptDes;
        try {
            DesUtils des = new DesUtils();
            aftDecryptDes = des.decrypt(preDecryptDes);
        } catch (Exception e) {
            aftDecryptDes = "解密前的值不符合规范";
        }
        return aftDecryptDes;
    }

    /**
     * 百度OCR文字识别
     *
     * @param file
     * @return
     */
    @PostMapping("/ocrSpot")
    @ResponseBody
    public String ocrSpot(@RequestParam(value = "file", required = true) MultipartFile file) {
        String result = "";
        try {
//            String path = ResourceUtils.getURL("classpath:").getPath()+"/img";
            String path = "/home/server/img";
            String fileName = file.getOriginalFilename();
            if (fileName != null) {
                String realPath = path + "/" + UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
                File img = new File(realPath);

                //判断文件父目录是否存在
                if (!img.getParentFile().exists()) {
                    img.getParentFile().mkdir();
                }
                // 保存文件
                file.transferTo(img);

                // 本地文件路径
                String filePath = realPath;
                byte[] imgData = FileUtil.readFileByBytes(filePath);
                String imgStr = Base64Util.encode(imgData);
                String imgParam = URLEncoder.encode(imgStr, "UTF-8");

                String param = "image=" + imgParam;
                accessToken = AuthUtil.getAuth();
                result = HttpUtil.post(url, accessToken, param);
            }
        } catch (Exception e) {
            result = "220";
        }
        return result;
    }

    /**
     * 获取拿外卖的人
     *
     * @return
     */
    @PostMapping("/takeawaySelect")
    public String selectTakeWay() {
        Takeaway takeaway = takeawayServer.takeawaySelect();
        String str = "无";
        if (takeaway != null) {
            str = takeaway.getName();
        }
        return str;
    }

    /**
     * 查询拿的次数
     *
     * @return
     */
    @PostMapping("/takeawayCount")
    public String selectCount() {
        int a = takeawayServer.takeawayCount("应");
        int b = takeawayServer.takeawayCount("张");
        int c = takeawayServer.takeawayCount("丁");
        return a + ":" + b + ":" + c;
    }
}
