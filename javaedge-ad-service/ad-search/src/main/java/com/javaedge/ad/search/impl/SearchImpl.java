package com.javaedge.ad.search.impl;

import com.javaedge.ad.index.DataTable;
import com.javaedge.ad.index.adunit.AdUnitIndex;
import com.javaedge.ad.search.ISearch;
import com.javaedge.ad.search.vo.SearchRequest;
import com.javaedge.ad.search.vo.SearchResponse;
import com.javaedge.ad.search.vo.feature.DistrictFeature;
import com.javaedge.ad.search.vo.feature.FeatureRelation;
import com.javaedge.ad.search.vo.feature.ItFeature;
import com.javaedge.ad.search.vo.feature.KeywordFeature;
import com.javaedge.ad.search.vo.media.AdSlot;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sss
 * @date 2019-02-26
 */
@Slf4j
@Service
public class SearchImpl implements ISearch {

    public SearchResponse fallback(SearchRequest request, Throwable e) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public SearchResponse fetchAds(SearchRequest request) {

        // 请求的广告位信息
        List<AdSlot> adSlots = request.getRequestInfo().getAdSlots();

        // 三个 Feature
        KeywordFeature keywordFeature =
                request.getFeatureInfo().getKeywordFeature();
        DistrictFeature districtFeature =
                request.getFeatureInfo().getDistrictFeature();
        ItFeature itFeature =
                request.getFeatureInfo().getItFeature();

        FeatureRelation relation = request.getFeatureInfo().getRelation();

        // 构造响应对象
        SearchResponse response = new SearchResponse();
        Map<String, List<SearchResponse.Creative>> adSlot2Ads =
                response.getAdSlot2Ads();

        for (AdSlot adSlot : adSlots) {

            Set<Long> targetUnitIdSet;

            // 根据流量类型获取初始 AdUnit
            Set<Long> adUnitIdSet = DataTable.of(
                    AdUnitIndex.class
            ).match(adSlot.getPositionType());
        }
        return null;
    }
}
