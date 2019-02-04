package com.javaedge.ad.dao;

import com.javaedge.ad.entity.AdPlan;
import com.javaedge.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sss
 * @date 2019/2/4
 */
public interface AdPlanRepository extends JpaRepository<AdPlan, Long> {

    /**
     *
     * @param id
     * @param userId
     * @return
     */
    AdPlan findByIdAndUserId(Long id, Long userId);

    /**
     *
     * @param ids
     * @param userId
     * @return
     */
    List<AdPlan> findAllByIdInAnAndUserId(List<Long> ids, Long userId);

    /**
     *
     * @param userId
     * @param username
     * @return
     */
    AdPlan findByUserIdaAndPlanName(Long userId, String username);

    /**
     *
     * @param status
     * @return
     */
    List<AdPlan> findAllByPlanStatus(Integer status);
}
