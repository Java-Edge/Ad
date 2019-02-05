package com.javaedge.ad.service;

import com.javaedge.ad.exception.AdException;
import com.javaedge.ad.vo.CreateUserRequest;
import com.javaedge.ad.vo.CreateUserResponse;

/**
 * @author sss
 * @date 2019/2/5
 */
public interface IUserService {

    /**
     * 创建用户
     *
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;



}
