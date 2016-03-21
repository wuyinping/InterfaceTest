package com.baidu.mgame.interfacetest.dao;

import java.util.List;
import java.util.Map;

import com.baidu.mgame.interfacetest.entity.ProjectVersion;

/**
 * 项目版本数据库操作
 *
 * @author maolei
 * @date 2015年8月30日 上午1:50:25
 * @version V1.0
 */
public interface ProjectVersionDao {

    /**
     * 根据项目id查询项目版本
     *
     * @param pids
     * @return
     * @throws Exception
     */
    public List<ProjectVersion> getProjectVersionByProjectId(Integer[] pids) throws Exception;

    /**
     * 新增项目版本
     *
     * @param pv
     * @return
     * @throws Exception
     */
    public int insertProjectVersion(ProjectVersion pv) throws Exception;

    /**
     * 修改项目版本
     *
     * @param pv
     * @return
     * @throws Exception
     */
    public boolean updateProjectVersion(ProjectVersion pv) throws Exception;

    /**
     * 删除项目版本
     *
     * @param pvids
     * @return
     * @throws Exception
     */
    public boolean deleteProjectVersion(Integer[] pvids) throws Exception;

    /**
     * 批量更新项目版本号
     *
     * @param updateMap
     * @throws Exception
     */
    public void batchUpdateProjectVersion(Map<String, Object>[] maps) throws Exception;

    /**
     * 批量新增版本号
     *
     * @param maps
     * @throws Exception
     */
    public void batchInsertProjectVersion(Map<String, Object>[] maps) throws Exception;

}
