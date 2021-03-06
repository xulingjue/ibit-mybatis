package tech.ibit.mybatis.test.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.ibit.mybatis.MapperDaoUtils;
import tech.ibit.mybatis.template.dao.impl.SingleIdDaoImpl;
import tech.ibit.mybatis.template.mapper.Mapper;
import tech.ibit.mybatis.test.dao.UserDao;
import tech.ibit.mybatis.test.entity.User;
import tech.ibit.mybatis.test.entity.UserPo;
import tech.ibit.mybatis.test.entity.UserTypeTotal;
import tech.ibit.mybatis.test.entity.property.UserProperties;
import tech.ibit.mybatis.test.mapper.UserMapper;
import tech.ibit.sqlbuilder.OrderBy;
import tech.ibit.sqlbuilder.Sql;
import tech.ibit.sqlbuilder.aggregate.CountColumn;

import java.util.List;

/**
 * Dao for user
 *
 * @author IBIT TECH
 */
@Repository
public class UserDaoImpl extends SingleIdDaoImpl<User, Integer> implements UserDao {

    @Autowired
    private UserMapper mapper;

    @Override
    public Mapper<User> getMapper() {
        return mapper;
    }

    @Override
    public Class<User> getPoClazz() {
        return User.class;
    }

    private static final String TYPE_TOTAL_RESULT_MAP = "typeTotalResultMap";

    /**
     * 列举用户id
     *
     * @return 用户id列表
     */
    @Override
    public List<Integer> listUserIds() {
        Sql sql = new Sql()
                .select(UserProperties.userId)
                .from(UserProperties.TABLE)
                .orderBy(new OrderBy(UserProperties.userId));
        return mapper.selectDefault(sql.getSqlParams());
    }

    /**
     * 通过用id获取用户po
     *
     * @param userId 用户id
     * @return 用户po
     */
    @Override
    public UserPo getPoById(Integer userId) {
        return MapperDaoUtils.getPoById(mapper, UserPo.class, userId);
    }

    /**
     * 按照用户类型统计数量
     *
     * @return 用户类型统计
     */
    @Override
    public List<UserTypeTotal> listTypeTotals() {
        Sql sql = new Sql()
                .select(UserProperties.type)
                .select(new CountColumn(null, "total"))
                .from(UserProperties.TABLE)
                .groupBy(UserProperties.type)
                .orderBy(new OrderBy(UserProperties.type));
        return mapper.selectWithResultMap(sql.getSqlParams(), TYPE_TOTAL_RESULT_MAP);
    }


}
