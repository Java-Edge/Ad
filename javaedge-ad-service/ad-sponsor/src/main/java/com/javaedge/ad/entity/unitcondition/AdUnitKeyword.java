package com.javaedge.ad.entity.unitcondition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *
 * @author sss
 * @date 2019/2/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ad_unit_keyword")
public class AdUnitKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 使用应用程序维护外键关系,而不是建立数据库的外键约束!
     */
    @Basic
    @Column(name = "unit_id", nullable = false)
    private Integer unitId;

    @Basic
    @Column(name = "keyword", nullable = false)
    private String keyword;

    public AdUnitKeyword(Integer unitId, String keyword) {
        this.unitId = unitId;
        this.keyword = keyword;
    }
}



