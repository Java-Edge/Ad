package com.javaedge.ad.client;

import com.javaedge.ad.client.vo.AdPlan;
import com.javaedge.ad.client.vo.AdPlanGetRequest;
import com.javaedge.ad.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author sss
 * @date 2019-02-11
 */
@FeignClient(value = "eureka-client-ad-sponsor",
        fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    /**
     * 获取广告计划
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/ad-sponsor/get/adPlan", method = RequestMethod.POST)
    CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request);

}
