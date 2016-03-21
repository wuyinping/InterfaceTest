package com.baidu.mgame.interfacetest.dao;

import java.util.List;

import com.baidu.mgame.interfacetest.entity.ProjectUrl;

/**
 * 项目测试地址数据库操作dao
 *
 * @author maolei
 * @date 2015年8月30日 上午1:04:39
 * @version V1.0
 */
public interface ProjectUrlDao {

    /**
     * 根据项目id查询项目测试地址
     *
     * @param pids
     * @return
     * @throws Exception
     */
    public List<ProjectUrl> getProjectUrlByProjectId(Integer[] pids) throws Exception;

    /**
     * 新增项目测试地址
     *
     * @param pUrl
     * @return
     * @throws Exception
     */
    public int insertProjectUrl(ProjectUrl pUrl) throws Exception;

    /**
     * 修改项目测试地址
     *
     * @param pUrl
     * @return
     * @throws Exception
     */
    public boolean updateProjectUrl(ProjectUrl pUrl) throws Exception;

    /**
     * 删除项目测试地址
     *
     * @param puids
     * @return
     * @throws Exception
     */
    public boolean deleteProjectUrl(Integer[] puids) throws Exception;

    /**
     * 批量更新项目地址
     *
     * @param updateList
     * @throws Exception
     */
    public void batchUpdateProjectUrl(List<ProjectUrl> updateList) throws Exception;

    /**
     * 批量新增项目地址
     * 
     * @param insertList
     * @throws Exception
     */
    public void batchInsertProjectUrl(List<ProjectUrl> insertList) throws Exception;

}
