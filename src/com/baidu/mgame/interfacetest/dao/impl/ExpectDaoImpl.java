package com.baidu.mgame.interfacetest.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.baidu.mgame.interfacetest.dao.ExpectDao;
import com.baidu.mgame.interfacetest.entity.ExpectMain;

/**
 * 预期结果数据库操作实现
 *
 * @author maolei
 * @date 2015年8月30日 上午1:23:11
 * @version V1.0
 */
public class ExpectDaoImpl implements ExpectDao {

    private NamedParameterJdbcTemplate interfaceJdbcTemplate;

    @Override
    public List<ExpectMain> getExpectByInterfaceId(Integer[] interfaceIds) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertExpect(ExpectMain ep) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean updateExpect(ExpectMain ep) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteExpect(Integer[] eids) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    public NamedParameterJdbcTemplate getInterfaceJdbcTemplate() {
        return this.interfaceJdbcTemplate;
    }

    public void setInterfaceJdbcTemplate(NamedParameterJdbcTemplate interfaceJdbcTemplate) {
        this.interfaceJdbcTemplate = interfaceJdbcTemplate;
    }

}
