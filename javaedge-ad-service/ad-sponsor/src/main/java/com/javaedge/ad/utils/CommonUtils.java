package com.javaedge.ad.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author sss
 * @date 2019/2/5
 */
public class CommonUtils {

    public static String md5(String value) {
        return DigestUtils.md5Hex(value).toUpperCase();
    }
}
