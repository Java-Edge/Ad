package com.javaedge.ad.search.vo;

import com.javaedge.ad.search.vo.feature.DistrictFeature;
import com.javaedge.ad.search.vo.feature.FeatureRelation;
import com.javaedge.ad.search.vo.feature.ItFeature;
import com.javaedge.ad.search.vo.feature.KeywordFeature;
import com.javaedge.ad.search.vo.media.AdSlot;
import com.javaedge.ad.search.vo.media.App;
import com.javaedge.ad.search.vo.media.Device;
import com.javaedge.ad.search.vo.media.Geo;
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
public class SearchRequest {

    /**
     * 媒体方的请求标识
     */
    private String mediaId;
    /**
     * 请求基本信息
     */
    private RequestInfo requestInfo;
    /**
     * 匹配信息
     */
    private FeatureInfo featureInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestInfo {

        private String requestId;

        private List<AdSlot> adSlots;
        private App app;
        private Geo geo;
        private Device device;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureInfo {

        private KeywordFeature keywordFeature;
        private DistrictFeature districtFeature;
        private ItFeature itFeature;

        private FeatureRelation relation = FeatureRelation.AND;
    }
}

