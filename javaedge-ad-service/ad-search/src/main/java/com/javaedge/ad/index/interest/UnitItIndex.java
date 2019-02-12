package com.javaedge.ad.index.interest;

import com.javaedge.ad.index.IndexAware;
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

        Set<Long> unitIds = CommonUtils.getorCreate(
                key, itUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIds.addAll(value);

        for (Long unitId : value) {

            Set<String> its = CommonUtils.getorCreate(
                    unitId, unitItMap,
                    ConcurrentSkipListSet::new
            );
            its.add(key);
        }

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
        Set<Long> unitIds = CommonUtils.getorCreate(key, itUnitMap, ConcurrentSkipListSet::new);

        // 再对单元 ids 进行 rm 操作,考虑到部分删除,不是直接对 itunitmap 删除 key 对应值
        // 因为 key 所对应 推广单元的 ids 并不一定全量,我们要实现可删除部分兴趣
        // eg. 一个 ittag 对应到推广单元的1,2,3,我们可以删除1,2 而不是3.所以先取再删.
        unitIds.removeAll(value);

        for (Long unitId : value) {
            Set<String> itTagSet = CommonUtils.getorCreate(unitId, unitItMap, ConcurrentSkipListSet::new);
            itTagSet.remove(key);
        }

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
