package com.baidu.mgame.interfacetest.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.baidu.mgame.interfacetest.dao.UsecaseDao;
import com.baidu.mgame.interfacetest.entity.UsecaseMain;

/**
 * 用例数据库操作实现
 *
 * @author maolei
 * @date 2015年8月30日 上午2:18:15
 * @version V1.0
 */
public class UsecaseDaoImpl implements UsecaseDao {

    private NamedParameterJdbcTemplate interfaceJdbcTemplate;

    @Override
    public List<UsecaseMain> getUsecaseByInterfaceId(Integer[] interIds) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertUsecase(UsecaseMain uc) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean updateUsecase(UsecaseMain uc) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUsecase(Integer[] ucids) throws Exception {
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
