package com.javaedge.ad.dao;

import com.javaedge.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sss
 * @date 2019/2/4
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {

    /**
     * 根据用户名查找用户记录
     *
     * @param username
     * @return
     */
    AdUser findByUsername(String username);





}
