package com.baidu.mgame.interfacetest.dao;

import java.util.List;

import com.baidu.mgame.interfacetest.entity.ProjectMain;

/**
 * 项目操作DAO
 *
 * @author maolei
 * @date 2015年8月29日 下午9:39:31
 * @version V1.0
 */
public interface ProjectDao {

    /**
     * 查询所有项目列表
     *
     * @return
     * @throws Exception
     */
    public List<ProjectMain> getAllProjects() throws Exception;

    /**
     * 根据id查询项目
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public List<ProjectMain> getProjectsById(Integer[] ids) throws Exception;

    /**
     * 新增项目
     *
     * @param project
     * @return
     * @throws Exception
     */
    public int insertProject(ProjectMain project) throws Exception;

    /**
     * 修改项目
     *
     * @param project
     * @return
     * @throws Exception
     */
    public boolean updateProject(ProjectMain project) throws Exception;

    /**
     * 删除项目
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public boolean deleteProject(Integer[] ids) throws Exception;

}
