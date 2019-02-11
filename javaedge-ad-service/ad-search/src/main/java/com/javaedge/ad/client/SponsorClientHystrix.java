package com.javaedge.ad.client;

import com.javaedge.ad.client.vo.AdPlan;
import com.javaedge.ad.client.vo.AdPlanGetRequest;
import com.javaedge.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sss
 * @date 2019-02-11
 */
@Component
public class SponsorClientHystrix implements SponsorClient{

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-ad-sponsor error");
    }
}
