package com.javaedge.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sss
 * @date 2019-02-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdSlot {

    // 广告位编码
    private String adSlotCode;

    // 流量类型
    private Integer positionType;

    // 宽和高
    private Integer width;
    private Integer height;

    // 广告物料类型: 图片, 视频
    private List<Integer> type;

    // 最低出价
    private Integer minCpm;
}
