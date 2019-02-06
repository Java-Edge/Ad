package com.javaedge.ad.service.impl;

import com.javaedge.ad.constant.CommonStatus;
import com.javaedge.ad.constant.Constants;
import com.javaedge.ad.dao.AdPlanRepository;
import com.javaedge.ad.dao.AdUserRepository;
import com.javaedge.ad.entity.AdPlan;
import com.javaedge.ad.entity.AdUser;
import com.javaedge.ad.exception.AdException;
import com.javaedge.ad.service.IAdPlanService;
import com.javaedge.ad.utils.CommonUtils;
import com.javaedge.ad.vo.AdPlanGetRequest;
import com.javaedge.ad.vo.AdPlanRequest;
import com.javaedge.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @fun 推广计划服务接口
 *
 * @author sss
 * @date 2019/2/6
 */
@Service
public class IAdPlanServiceImpl implements IAdPlanService {

    private final AdUserRepository userRepository;

    private final AdPlanRepository planRepository;

    @Autowired
    public IAdPlanServiceImpl(AdUserRepository userRepository, AdPlanRepository planRepository) {
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    /**
     * 创建推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    @Override
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {
        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        //确保关联的 User 是否存在
        Optional<AdUser> adUser = userRepository.findById(request.getUserId());

        if (!adUser.isPresent()) {
            throw new AdException(Constants.ErrorMsg.RECORD_NOT_FOUND);
        }

        AdPlan oldPlan = planRepository.findByUserIdaAndPlanName(
                request.getUserId(), request.getPlanName()
        );
        if (oldPlan != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME__PLAN_ERROR);
        }
        AdPlan newAdPlan = planRepository.save(
                new AdPlan(
                        request.getUserId(),
                        request.getPlanName(),
                        CommonUtils.parseStringDate(request.getStartDate()),
                        CommonUtils.parseStringDate(request.getEndDate())
                )
        );

        return new AdPlanResponse(newAdPlan.getId(),
                newAdPlan.getPlanName());
    }

    /**
     * 获取推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        return planRepository.findAllByIdInAnAndUserId(
                request.getIds(), request.getUserId()
        );
    }

    /**
     * 更新推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {
        if (!request.updateValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);

        }

        AdPlan plan = planRepository.findByIdAndUserId(
                request.getId(), request.getUserId()
        );

        if (request.getPlanName() != null) {
            plan.setPlanName(request.getPlanName());
        }

        if (request.getStartDate() != null) {
            plan.setStartDate(CommonUtils.parseStringDate(request.getStartDate()));
        }

        if (request.getEndDate() != null) {
            plan.setEndDate(CommonUtils.parseStringDate(request.getEndDate()));
        }

        plan.setUpdateTime(new Date());
        plan = planRepository.save(plan);

        return new AdPlanResponse(plan.getId(), plan.getPlanName());
    }
    /**
     * 删除推广计划
     *
     * @param request
     * @throws AdException
     */
    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {
        if (!request.deleteValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdPlan plan = planRepository.findByIdAndUserId(request.getId(), request.getUserId());
        if (plan == null) {
            throw new AdException(Constants.ErrorMsg.RECORD_NOT_FOUND);
        }

        plan.setPlanStatus(CommonStatus.INVALID.getStatus());
        plan.setUpdateTime(new Date());
        planRepository.save(plan);

    }

}
