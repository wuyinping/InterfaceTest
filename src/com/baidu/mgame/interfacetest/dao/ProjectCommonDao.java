package com.baidu.mgame.interfacetest.dao;

import java.util.List;

import com.baidu.mgame.interfacetest.entity.ProjectCommon;

/**
 * 项目公共上行操作
 *
 * @author maolei
 * @date 2015年8月30日 上午1:42:45
 * @version V1.0
 */
public interface ProjectCommonDao {

    /**
     * 根据项目id查询对应公共上行
     *
     * @param pids
     * @return
     * @throws Exception
     */
    public List<ProjectCommon> getProjectCommonByProjectId(Integer[] pids) throws Exception;

    /**
     * 新增公共上行
     *
     * @param pc
     * @return
     * @throws Exception
     */
    public int insertProjectCommon(ProjectCommon pc) throws Exception;

    /**
     * 修改公共上行
     *
     * @param pc
     * @return
     * @throws Exception
     */
    public boolean updateProjectCommon(ProjectCommon pc) throws Exception;

    /**
     * 删除公共上行
     *
     * @param pcids
     * @return
     * @throws Exception
     */
    public boolean deleteProjectCommon(Integer[] pcids) throws Exception;

}
