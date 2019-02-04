package com.javaedge.ad.constant;

import lombok.Getter;

/**
 * @author sss
 * @date 2019/2/1
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
