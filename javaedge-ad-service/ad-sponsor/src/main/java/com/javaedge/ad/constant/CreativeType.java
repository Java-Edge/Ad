package com.javaedge.ad.constant;

import com.javaedge.ad.entity.Creative;

/**
 * @author sss
 * @date 2019/2/4
 */
public enum CreativeType {

    IMAGE(1, "图片"),
    VIDEO(2, "视频"),
    TEXT(3, "文本");

    private int type;
    private String desc;

    CreativeType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
