package tech.ibit.mybatis.test.entity.property;


import tech.ibit.sqlbuilder.Column;
import tech.ibit.sqlbuilder.Table;

/**
 * Table for user_login_record
 *
 * @author IBIT TECH
 */
public interface UserLoginRecordProperties {

    /**
     * 表对象
     */
    Table TABLE = new Table("user_login_record", "ulr");

    /**
     * 用户id
     */
    Column userId = new Column(TABLE, "user_id");

    /**
     * 组织名称
     */
    Column loginTime = new Column(TABLE, "login_time");


}
