package tech.ibit.mybatis.test.entity;

import lombok.Data;
import tech.ibit.sqlbuilder.annotation.DbColumn;
import tech.ibit.sqlbuilder.annotation.DbId;
import tech.ibit.sqlbuilder.annotation.DbTable;

/**
 * Entity for organization
 *
 * @author IBIT TECH
 */
@Data
@DbTable(name = "organization", alias = "o")
public class Organization {

    /**
     * 城市编码
     * VARCHAR(16)
     */
    @DbId(name = "city_code")
    private String cityCode;

    /**
     * 组织名称
     * VARCHAR(32)
     */
    @DbId(name = "name")
    private String name;

    /**
     * 组织类型
     * INT(10, 0)
     */
    @DbColumn(name = "type")
    private Integer type;

    /**
     * 手机
     * VARCHAR(16)
     */
    @DbColumn(name = "phone", nullable = true)
    private String phone;

}
