package com.baidu.mgame.interfacetest.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.baidu.mgame.interfacetest.dao.ProjectDao;
import com.baidu.mgame.interfacetest.entity.ProjectMain;
import com.baidu.mgame.interfacetest.utils.SqlBuilder;

/**
 * 项目数据库操作实现类
 *
 * @author maolei
 * @date 2015年8月30日 上午12:58:45
 * @version V1.0
 */
public class ProjectDaoImpl implements ProjectDao {

    private NamedParameterJdbcTemplate interfaceJdbcTemplate;

    @Override
    public List<ProjectMain> getAllProjects() throws Exception {

        String sql = "select * from project_main where del_flag = 0";

        MapSqlParameterSource sps = new MapSqlParameterSource();

        RowMapper<ProjectMain> rm = ParameterizedBeanPropertyRowMapper.newInstance(ProjectMain.class);

        List<ProjectMain> l = this.interfaceJdbcTemplate.query(sql, sps, rm);

        return l;
    }

    @Override
    public List<ProjectMain> getProjectsById(Integer[] ids) throws Exception {

        SqlBuilder sb = new SqlBuilder();
        sb.appendStr("select * from project_main where del_flag = 0");
        sb.appendAnd();
        sb.appendIn("id", ids);

        MapSqlParameterSource sps = new MapSqlParameterSource();

        RowMapper<ProjectMain> rm = ParameterizedBeanPropertyRowMapper.newInstance(ProjectMain.class);

        List<ProjectMain> l = this.interfaceJdbcTemplate.query(sb.toString(), sps, rm);

        return l;
    }

    @Override
    public int insertProject(ProjectMain project) throws Exception {

        final String sql = "insert into project_main(p_name,p_key) values(:name,:key)";

        MapSqlParameterSource sps =
                new MapSqlParameterSource().addValue("name", project.getP_name()).addValue("key", project.getP_key());

        // 返回自增主键
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.interfaceJdbcTemplate.update(sql, sps, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public boolean updateProject(ProjectMain project) throws Exception {

        String sql = "update project_main set p_name=:name,p_key=:key where id=:id";

        MapSqlParameterSource sps =
                new MapSqlParameterSource().addValue("id", project.getId()).addValue("name", project.getP_name())
                .addValue("key", project.getP_key());

        int count = this.interfaceJdbcTemplate.update(sql, sps);

        return count > 0 ? true : false;
    }

    @Override
    public boolean deleteProject(Integer[] ids) throws Exception {

        SqlBuilder sb = new SqlBuilder();
        sb.appendStr("update project_main set del_flag = 1 where");
        sb.appendIn("id", ids);

        MapSqlParameterSource sps = new MapSqlParameterSource();

        int count = this.interfaceJdbcTemplate.update(sb.toString(), sps);

        return count > 0 ? true : false;
    }

    public NamedParameterJdbcTemplate getInterfaceJdbcTemplate() {
        return this.interfaceJdbcTemplate;
    }

    public void setInterfaceJdbcTemplate(NamedParameterJdbcTemplate interfaceJdbcTemplate) {
        this.interfaceJdbcTemplate = interfaceJdbcTemplate;
    }

}
