package com.javaedge.ad.controller;

import com.alibaba.fastjson.JSON;
import com.javaedge.ad.annotation.IgnoreResponseAdvice;
import com.javaedge.ad.client.vo.AdPlan;
import com.javaedge.ad.client.vo.AdPlanGetRequest;
import com.javaedge.ad.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author sss
 * @date 2019-02-11
 */
@Slf4j
@RestController
public class SearchController {

    private final RestTemplate restTemplate;

    public SearchController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlanByRibbon")
    public CommonResponse<List<AdPlan>> getAdPlanByRibbon(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlanByRibbon -> {}", JSON.toJSONString(request));
        return restTemplate.postForEntity("http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class).getBody();
    }
}
