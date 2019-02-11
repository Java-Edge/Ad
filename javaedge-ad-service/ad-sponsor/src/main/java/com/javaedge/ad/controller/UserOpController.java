package com.javaedge.ad.controller;

import com.alibaba.fastjson.JSON;
import com.javaedge.ad.exception.AdException;
import com.javaedge.ad.service.IUserService;
import com.javaedge.ad.vo.CreateUserRequest;
import com.javaedge.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sss
 * @date 2019-02-11
 */
@RestController
@Slf4j
public class UserOpController {

    private final IUserService userService;

    @Autowired
    public UserOpController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
