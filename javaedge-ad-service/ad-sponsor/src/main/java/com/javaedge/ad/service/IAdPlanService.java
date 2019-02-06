package com.javaedge.ad.service;

import com.javaedge.ad.entity.AdPlan;
import com.javaedge.ad.exception.AdException;
import com.javaedge.ad.vo.AdPlanGetRequest;
import com.javaedge.ad.vo.AdPlanRequest;
import com.javaedge.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * @fun 推广计划服务接口
 *
 * @author sss
 * @date 2019/2/6
 */
public interface IAdPlanService {

    /**
     * 创建推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     *
     * @param request
     * @throws AdException
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;

}
