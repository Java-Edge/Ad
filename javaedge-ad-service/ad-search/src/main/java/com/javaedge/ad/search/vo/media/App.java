package com.javaedge.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sss
 * @date 2019-02-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class App {

    // 应用编码
    private String appCode;
    // 应用名称
    private String appName;
    // 应用包名
    private String packageName;
    // activity 名称
    private String activityName;
}
