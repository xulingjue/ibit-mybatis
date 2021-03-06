package tech.ibit.mybatis.test.entity.property;

import tech.ibit.sqlbuilder.Column;
import tech.ibit.sqlbuilder.Table;

/**
 * Table for organization
 *
 * @author IBIT TECH
 */
public interface OrganizationProperties {

    /**
     * 
     */
    Table TABLE = new Table("organization", "o");

    /**
     * 城市编码
     */
    Column cityCode = new Column(TABLE, "city_code");

    /**
     * 组织名称
     */
    Column name = new Column(TABLE, "name");

    /**
     * 组织类型
     */
    Column type = new Column(TABLE, "type");

    /**
     * 手机
     */
    Column phone = new Column(TABLE, "phone");


}
