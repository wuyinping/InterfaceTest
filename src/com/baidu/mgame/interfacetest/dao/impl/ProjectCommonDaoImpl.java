package com.baidu.mgame.interfacetest.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.baidu.mgame.interfacetest.dao.ProjectCommonDao;
import com.baidu.mgame.interfacetest.entity.ProjectCommon;

/**
 * 项目公共上行操作实现
 *
 * @author maolei
 * @date 2015年8月30日 上午1:48:59
 * @version V1.0
 */
public class ProjectCommonDaoImpl implements ProjectCommonDao {

    private NamedParameterJdbcTemplate interfaceJdbcTemplate;

    @Override
    public List<ProjectCommon> getProjectCommonByProjectId(Integer[] pids) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertProjectCommon(ProjectCommon pc) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean updateProjectCommon(ProjectCommon pc) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteProjectCommon(Integer[] pcids) throws Exception {
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
