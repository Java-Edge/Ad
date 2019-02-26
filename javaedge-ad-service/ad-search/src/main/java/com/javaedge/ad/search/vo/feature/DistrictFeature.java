package com.javaedge.ad.search.vo.feature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sss
 * @date 2019-02-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictFeature {

    private List<ProvinceAndCity> districts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProvinceAndCity {

        private String province;
        private String city;
    }
}
