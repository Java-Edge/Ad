package com.javaedge.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sss
 * @date 2019/2/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeUnitRequest {

    private List<CreativeUnitItem> unitItems;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreativeUnitItem {

        private Long creativeId;
        private Long unitId;
    }
}

