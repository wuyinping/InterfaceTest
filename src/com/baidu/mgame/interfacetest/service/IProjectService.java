package com.baidu.mgame.interfacetest.service;

import java.util.List;
import java.util.Map;

import com.baidu.mgame.interfacetest.entity.ProjectUrl;
import com.baidu.mgame.interfacetest.vo.ProjectViewResponse;
import com.baidu.mgame.interfacetest.vo.UpdateProjectEnvResponse;
import com.baidu.mgame.interfacetest.vo.UpdateProjectVersionResponse;

/**
 * 项目相关服务
 *
 * @author maolei
 * @date 2015年8月30日 上午2:26:21
 * @version V1.0
 */
public interface IProjectService {

    public ProjectViewResponse getAllProjectView() throws Exception;

    public void insertProject(String pName, String pKey) throws Exception;

    public void deleteProject(Integer pid) throws Exception;

    public void updateProject(Integer pid, String pName, String pKey) throws Exception;

    public UpdateProjectVersionResponse getProjectVersionByPid(Integer pid) throws Exception;

    public void batchUpdateProjectVersion(Map<Integer, String> updateMap) throws Exception;

    public void batchInsertProjectVersion(Integer pid, List<String> insertList) throws Exception;

    public void deleteProjectVersion(Integer vid) throws Exception;

    public UpdateProjectEnvResponse getProjectUrlByPid(Integer pid) throws Exception;

    public void batchUpdateProjectUrl(List<ProjectUrl> updateList) throws Exception;

    public void batchInsertProjectUrl(List<ProjectUrl> insertList) throws Exception;

    public void deleteProjectUrl(Integer uid) throws Exception;

}
