package com.baidu.mgame.interfacetest.dao.impl;

import java.util.List;

import com.baidu.mgame.interfacetest.utils.SqlBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.baidu.mgame.interfacetest.dao.InterfaceDao;
import com.baidu.mgame.interfacetest.entity.InterfaceMain;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

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
        SqlBuilder sql=new SqlBuilder();
        sql.appendStr("select * from interface_main where del_flag=0");
        sql.appendAnd();
        sql.appendIn("version_id",vids);
       // sql的参数，此处没用，为空
        MapSqlParameterSource sps=new MapSqlParameterSource();
        RowMapper<InterfaceMain> rm= ParameterizedBeanPropertyRowMapper.newInstance(InterfaceMain.class);
        // Query given SQL to create a prepared statement from SQL and a list of arguments to bind to the query, mapping each row to a Java object via a RowMapper
        List<InterfaceMain> list=this.interfaceJdbcTemplate.query(sql.toString(),sps,rm);
        return list;
    }

    @Override
    public List<InterfaceMain> getInterfaceByTag(Integer vid, String tag) throws Exception {
        // TODO Auto-generated method stub
//        此处有问题 ，待进一步核实！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        List<InterfaceMain> list;
        if (vid == 0) {
            SqlBuilder sql = new SqlBuilder();
            sql.appendStr("select * from interface_main where de_flag=0");
            sql.appendAnd();
            sql.appendStr("tag=:tag");
            MapSqlParameterSource sps = new MapSqlParameterSource().addValue("tag", tag);
            RowMapper<InterfaceMain> rm = new ParameterizedBeanPropertyRowMapper<InterfaceMain>();
           list=this.interfaceJdbcTemplate.query(sql.toString(), sps, rm);
        } else {
            SqlBuilder sql = new SqlBuilder();
            sql.appendStr("select * from interface_main where de_flag=0");
            sql.appendAnd();
            sql.appendStr("tag=:tag");
            sql.appendStr("version_id=:vid");
            MapSqlParameterSource sps = new MapSqlParameterSource().addValue("tag", tag).addValue("version_id", vid);
            RowMapper<InterfaceMain> rm = new ParameterizedBeanPropertyRowMapper<InterfaceMain>();
            list = this.interfaceJdbcTemplate.query(sql.toString(), sps, rm);
        }

        return list;
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
