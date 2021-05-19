package com.hg.teamwork.controller;

import com.hg.teamwork.util.DesUtils;
import com.hg.teamwork.util.Instrument;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ying
 * @describe 业务控制器
 * @date 2021/05/19
 */
@RestController
public class businessController {

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

}
