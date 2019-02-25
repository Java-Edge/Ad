package com.javaedge.ad.mysql.dto;

import com.javaedge.ad.mysql.constant.OpType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表达模板文件中的 表&层级
 *
 * @author sss
 * @date 2019-02-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableTemplate {

    private String tableName;
    private String level;

    private Map<OpType, List<String>> opTypeFieldSetMap = new HashMap<>();

    /**
     * 字段索引 -> 字段名 的映射关系
     * */
    private Map<Integer, String> posMap = new HashMap<>();
}
