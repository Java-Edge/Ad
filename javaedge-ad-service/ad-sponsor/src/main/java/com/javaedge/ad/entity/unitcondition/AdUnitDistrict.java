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
@Table(name = "ad_unit_district")
public class AdUnitDistrict {

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
    @Column(name = "city", nullable = false)
    private String province;

    @Basic
    @Column(name = "city", nullable = false)
    private String city;

    public AdUnitDistrict(Integer unitId, String province, String city) {
        this.unitId = unitId;
        this.province = province;
        this.city = city;
    }
}




