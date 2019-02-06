package com.javaedge.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @author sss
 * @date 2019/2/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanGetRequest {

    private Long userId;
    private List<Long> ids;

    public boolean validate() {
        return userId != null
                && CollectionUtils.isEmpty(ids);
    }
}
