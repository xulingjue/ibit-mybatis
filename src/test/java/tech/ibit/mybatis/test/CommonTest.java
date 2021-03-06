package tech.ibit.mybatis.test;

import org.apache.commons.lang.ArrayUtils;
import tech.ibit.sqlbuilder.KeyValuePair;
import tech.ibit.sqlbuilder.SqlParams;
import tech.ibit.sqlbuilder.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 公共测试类
 *
 * @author IBIT-TECH
 * mailto: ibit_tech@aliyun.com
 */
public class CommonTest {

    /**
     * 断言参数相等
     *
     * @param sql                sql
     * @param paramKeyValuePairs 参数键值对
     * @param sqlParams          sql参数对象
     */
    public void assertParamsEquals(String sql, List<Object> paramKeyValuePairs, SqlParams sqlParams) {
        assertEquals(new SqlParams(sql, getKeyValuePairs(paramKeyValuePairs)).toString(), sqlParams.toString());
    }


    /**
     * 断言参数相等
     *
     * @param sql       sql
     * @param sqlParams sql参数对象
     */
    public void assertParamsEquals(String sql, SqlParams sqlParams) {
        assertEquals(new SqlParams(sql, Collections.emptyList()).toString(), sqlParams.toString());
    }


    /**
     * 构造KeyValuePair列表
     *
     * @param paramKeyValuePairs KeyValue对
     * @return KeyValuePair列表
     */
    public List<KeyValuePair> getKeyValuePairs(Object... paramKeyValuePairs) {
        if (ArrayUtils.isEmpty(paramKeyValuePairs)) {
            return Collections.emptyList();
        }
        List<KeyValuePair> keyValuePairs = new ArrayList<>();
        for (int i = 0; i < paramKeyValuePairs.length; i += 2) {
            keyValuePairs.add(new KeyValuePair((String) paramKeyValuePairs[i], paramKeyValuePairs[i + 1]));
        }
        return keyValuePairs;
    }


    /**
     * 构造KeyValuePair列表
     *
     * @param paramKeyValuePairs KeyValue对列表
     * @return KeyValuePair列表
     */
    public List<KeyValuePair> getKeyValuePairs(List<Object> paramKeyValuePairs) {
        if (CollectionUtils.isEmpty(paramKeyValuePairs)) {
            return Collections.emptyList();
        }
        List<KeyValuePair> keyValuePairs = new ArrayList<>();
        for (int i = 0; i < paramKeyValuePairs.size(); i += 2) {
            keyValuePairs.add(new KeyValuePair((String) paramKeyValuePairs.get(i), paramKeyValuePairs.get(i + 1)));
        }
        return keyValuePairs;
    }

}
