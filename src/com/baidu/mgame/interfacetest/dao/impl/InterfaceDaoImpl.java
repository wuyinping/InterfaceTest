package com.baidu.mgame.interfacetest.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.baidu.mgame.interfacetest.dao.InterfaceDao;
import com.baidu.mgame.interfacetest.entity.InterfaceMain;

/**
 * 接口数据库操作实现
 *
 * @author maolei
 * @date 2015年8月30日 上午1:41:48
 * @version V1.0
 */
public class InterfaceDaoImpl implements InterfaceDao {

    private NamedParameterJdbcTemplate interfaceJdbcTemplate;

    @Override
    public List<InterfaceMain> getInterfaceByVersionId(Integer[] vids) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InterfaceMain getInterfaceByTag(Integer vid, String tag) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertInterface(InterfaceMain inter) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean updateInterface(InterfaceMain inter) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteInterface(Integer[] interIds) throws Exception {
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
