package com.javaedge.ad.service.impl;

import com.javaedge.ad.dao.CreativeRepository;
import com.javaedge.ad.entity.Creative;
import com.javaedge.ad.service.ICreativeService;
import com.javaedge.ad.vo.CreativeRequest;
import com.javaedge.ad.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sss
 * @date 2019/2/10
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}

