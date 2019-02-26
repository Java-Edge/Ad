package com.javaedge.ad.search;

import com.javaedge.ad.search.vo.SearchRequest;
import com.javaedge.ad.search.vo.SearchResponse;

/**
 * @author sss
 * @date 2019-02-26
 */
public interface ISearch {

    /**
     *
     * @param request
     * @return
     */
    SearchResponse fetchAds(SearchRequest request);
}
