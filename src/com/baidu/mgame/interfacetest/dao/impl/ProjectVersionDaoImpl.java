package com.baidu.mgame.interfacetest.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.baidu.mgame.interfacetest.dao.ProjectVersionDao;
import com.baidu.mgame.interfacetest.entity.ProjectVersion;
import com.baidu.mgame.interfacetest.utils.SqlBuilder;

/**
 * 项目版本数据库操作实现
 *
 * @author maolei
 * @date 2015年8月30日 上午2:12:26
 * @version V1.0
 */
public class ProjectVersionDaoImpl implements ProjectVersionDao {

    private NamedParameterJdbcTemplate interfaceJdbcTemplate;

    @Override
    public List<ProjectVersion> getProjectVersionByProjectId(Integer[] pids) throws Exception {

        SqlBuilder sb = new SqlBuilder();
        sb.appendStr("select * from project_version where del_flag = 0");
        sb.appendAnd();
        sb.appendIn("project_id", pids);

        MapSqlParameterSource sps = new MapSqlParameterSource();

        RowMapper<ProjectVersion> rm = ParameterizedBeanPropertyRowMapper.newInstance(ProjectVersion.class);

        List<ProjectVersion> l = this.interfaceJdbcTemplate.query(sb.toString(), sps, rm);

        return l;
    }

    @Override
    public int insertProjectVersion(ProjectVersion pv) throws Exception {

        final String sql = "insert into project_version(project_id,version_code) values(:project_id,:version_code)";

        MapSqlParameterSource sps =
                new MapSqlParameterSource().addValue("project_id", pv.getProject_id()).addValue("version_code",
                        pv.getVersion_code());

        // 返回自增主键
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.interfaceJdbcTemplate.update(sql, sps, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public boolean updateProjectVersion(ProjectVersion pv) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteProjectVersion(Integer[] pvids) throws Exception {

        SqlBuilder sb = new SqlBuilder();
        sb.appendStr("update project_version set del_flag = 1 where");
        sb.appendIn("id", pvids);

        MapSqlParameterSource sps = new MapSqlParameterSource();

        int count = this.interfaceJdbcTemplate.update(sb.toString(), sps);

        return count > 0 ? true : false;
    }

    @Override
    public void batchUpdateProjectVersion(Map<String, Object>[] maps) throws Exception {

        String sql =
                "update project_version set version_code=:versionCode where id=:id and version_code <> :versionCode";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(maps);
        this.interfaceJdbcTemplate.batchUpdate(sql, batch);
    }

    @Override
    public void batchInsertProjectVersion(Map<String, Object>[] maps) throws Exception {

        String sql = "insert into project_version(project_id,version_code) values(:pid,:versionCode)";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(maps);
        this.interfaceJdbcTemplate.batchUpdate(sql, batch);
    }

    public NamedParameterJdbcTemplate getInterfaceJdbcTemplate() {
        return this.interfaceJdbcTemplate;
    }

    public void setInterfaceJdbcTemplate(NamedParameterJdbcTemplate interfaceJdbcTemplate) {
        this.interfaceJdbcTemplate = interfaceJdbcTemplate;
    }

}
