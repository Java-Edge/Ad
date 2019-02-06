package com.javaedge.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @author sss
 * @date 2019/2/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanResponse {

    private Long id;
    private String planName;
}
