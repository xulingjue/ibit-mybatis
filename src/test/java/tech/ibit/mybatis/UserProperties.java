package tech.ibit.mybatis;


import tech.ibit.sqlbuilder.Column;
import tech.ibit.sqlbuilder.Table;

/**
 * Table for sz_user
 * @author IBIT TECH
 */
public interface UserProperties {

    Table TABLE = new Table("user", "u");

    Column userId = new Column(TABLE, "user_id");
    Column loginId = new Column(TABLE, "login_id");
    Column email = new Column(TABLE, "email");
    Column password = new Column(TABLE, "password");
    Column mobilePhone = new Column(TABLE, "mobile_phone");
    Column type = new Column(TABLE, "type");
    Column name = new Column(TABLE, "name");
    Column avatarId = new Column(TABLE, "avatar_id");
    Column currentProjectId = new Column(TABLE, "current_project_id");
    Column loginTimes = new Column(TABLE, "login_times");

}
