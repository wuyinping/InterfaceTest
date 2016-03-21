package com.baidu.mgame.interfacetest.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.baidu.mgame.interfacetest.dao.ProjectUrlDao;
import com.baidu.mgame.interfacetest.entity.ProjectUrl;
import com.baidu.mgame.interfacetest.utils.SqlBuilder;

/**
 * 项目测试地址数据库操作实现
 *
 * @author maolei
 * @date 2015年8月30日 上午1:13:16
 * @version V1.0
 */
public class ProjectUrlDaoImpl implements ProjectUrlDao {

    private NamedParameterJdbcTemplate interfaceJdbcTemplate;

    @Override
    public List<ProjectUrl> getProjectUrlByProjectId(Integer[] pids) throws Exception {

        SqlBuilder sb = new SqlBuilder();
        sb.appendStr("select * from project_url where del_flag = 0");
        sb.appendAnd();
        sb.appendIn("project_id", pids);

        MapSqlParameterSource sps = new MapSqlParameterSource();

        RowMapper<ProjectUrl> rm = ParameterizedBeanPropertyRowMapper.newInstance(ProjectUrl.class);

        List<ProjectUrl> l = this.interfaceJdbcTemplate.query(sb.toString(), sps, rm);

        return l;
    }

    @Override
    public int insertProjectUrl(ProjectUrl pUrl) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean updateProjectUrl(ProjectUrl pUrl) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteProjectUrl(Integer[] puids) throws Exception {

        SqlBuilder sb = new SqlBuilder();
        sb.appendStr("update project_url set del_flag = 1 where");
        sb.appendIn("id", puids);

        MapSqlParameterSource sps = new MapSqlParameterSource();

        int count = this.interfaceJdbcTemplate.update(sb.toString(), sps);

        return count > 0 ? true : false;
    }

    @Override
    public void batchUpdateProjectUrl(List<ProjectUrl> updateList) throws Exception {

        String sql =
                "update project_url set base_url=:base_url,url_name=:url_name where id=:id and (base_url <> :base_url or url_name <> :url_name)";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(updateList.toArray());
        this.interfaceJdbcTemplate.batchUpdate(sql, batch);
    }

    @Override
    public void batchInsertProjectUrl(List<ProjectUrl> insertList) throws Exception {

        String sql = "insert into project_url(project_id,base_url,url_name) values(:project_id,:base_url,:url_name)";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(insertList.toArray());
        this.interfaceJdbcTemplate.batchUpdate(sql, batch);
    }

    public NamedParameterJdbcTemplate getInterfaceJdbcTemplate() {
        return this.interfaceJdbcTemplate;
    }

    public void setInterfaceJdbcTemplate(NamedParameterJdbcTemplate interfaceJdbcTemplate) {
        this.interfaceJdbcTemplate = interfaceJdbcTemplate;
    }

}
