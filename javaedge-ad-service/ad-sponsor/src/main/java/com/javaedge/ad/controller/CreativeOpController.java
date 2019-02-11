package com.javaedge.ad.controller;

import com.alibaba.fastjson.JSON;
import com.javaedge.ad.service.ICreativeService;
import com.javaedge.ad.vo.CreativeRequest;
import com.javaedge.ad.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sss
 * @date 2019-02-11
 */
@Slf4j
@RestController
public class CreativeOpController {

    private final ICreativeService creativeService;

    @Autowired
    public CreativeOpController(ICreativeService creativeService) {
        this.creativeService = creativeService;
    }

    @PostMapping("/create/creative")
    public CreativeResponse createCreative(@RequestBody CreativeRequest request) {
        log.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}

