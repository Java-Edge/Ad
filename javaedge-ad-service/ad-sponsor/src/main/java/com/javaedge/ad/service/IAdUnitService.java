package com.javaedge.ad.service;

import com.javaedge.ad.exception.AdException;
import com.javaedge.ad.vo.*;

/**
 * @fun 推广单元接口
 *
 * @author sss
 * @date 2019/2/6
 */
public interface IAdUnitService {

    /**
     *
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    /**
     *
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request)
            throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request)
            throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request)
            throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request)
            throws AdException;

}
