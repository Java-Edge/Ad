package com.javaedge.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author sss
 * @date 2019-02-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanTable {

    private Long id;
    private Long userId;
    private Integer planStatus;

    /**
     * 对于 Date 类型,由于将 binlog 转化为了字符串,需搞清楚 Date 的字符串表达形式
     */
    private Date startDate;
    private Date endDate;
}

