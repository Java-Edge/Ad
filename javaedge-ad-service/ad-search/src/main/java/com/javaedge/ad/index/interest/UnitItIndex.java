package com.javaedge.ad.index.interest;

import com.javaedge.ad.index.IndexAware;
import com.javaedge.ad.index.district.UnitDistrictIndex;
import com.javaedge.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author sss
 * @date 2019-02-12
 */
@Slf4j
@Component
public class UnitItIndex implements IndexAware<String, Set<Long>> {

    /**
     * <itTag, adUnitId set> 反向索引
     */
    private static Map<String, Set<Long>> itUnitMap;

    /**
     * <unitId, itTag set> 正向索引
     */
    private static Map<Long, Set<String>> unitItMap;

    static {
        itUnitMap = new ConcurrentHashMap<>();
        unitItMap = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {
        return itUnitMap.get(key);
    }

    @Override
    public void add(String key, Set<Long> value) {

        log.info("UnitItIndex, before add: {}", unitItMap);

        UnitDistrictIndex.changeADD(key, value, itUnitMap, unitItMap);

        log.info("UnitItIndex, after add: {}", unitItMap);
    }

    @Override
    public void update(String key, Set<Long> value) {

        log.error("it index can not support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {

        log.info("UnitItIndex, before delete: {}", unitItMap);

        // 先取出对应的推广 单元id
        UnitDistrictIndex.changeRM(key, value, itUnitMap, unitItMap);

        log.info("UnitItIndex, after delete: {}", unitItMap);
    }

    /**
     * 检索服务时会用到
     *
     * @param unitId
     * @param itTags
     * @return
     */
    public boolean match(Long unitId, List<String> itTags) {

        if (unitItMap.containsKey(unitId) && CollectionUtils.isNotEmpty(unitItMap.get(unitId))) {
            Set<String> unitKeywords = unitItMap.get(unitId);

            return CollectionUtils.isSubCollection(itTags, unitKeywords);
        }

        return false;
    }
}
