package com.hg.teamwork.common.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;

/**
 * shiro 工具类
 *
 * @author ying
 */
public class ShiroUtils {
    /**
     * 生成随机盐
     */
    public static String randomSalt() {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }

}
