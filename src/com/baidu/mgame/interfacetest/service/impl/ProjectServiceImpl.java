package com.baidu.mgame.interfacetest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baidu.mgame.interfacetest.consts.CommonConsts;
import com.baidu.mgame.interfacetest.dao.ProjectDao;
import com.baidu.mgame.interfacetest.dao.ProjectUrlDao;
import com.baidu.mgame.interfacetest.dao.ProjectVersionDao;
import com.baidu.mgame.interfacetest.entity.ProjectMain;
import com.baidu.mgame.interfacetest.entity.ProjectUrl;
import com.baidu.mgame.interfacetest.entity.ProjectVersion;
import com.baidu.mgame.interfacetest.service.IProjectService;
import com.baidu.mgame.interfacetest.vo.ProjectViewResponse;
import com.baidu.mgame.interfacetest.vo.UpdateProjectEnvResponse;
import com.baidu.mgame.interfacetest.vo.UpdateProjectVersionResponse;

/**
 * 项目接口实现类
 *
 * @author maolei
 * @date 2015年8月30日 下午2:51:04
 * @version V1.0
 */
public class ProjectServiceImpl implements IProjectService {

    private ProjectDao projectDao;
    private ProjectUrlDao projectUrlDao;
    private ProjectVersionDao projectVersionDao;

    @Override
    public ProjectViewResponse getAllProjectView() throws Exception {

        ProjectViewResponse resp = new ProjectViewResponse();
        resp.setErrorcode(CommonConsts.ERROR_CODE_SUCCESS);
        resp.setErrormsg(CommonConsts.ERROR_MSG_SUCCESS);

        // 加载所有项目
        List<ProjectMain> projectList = this.projectDao.getAllProjects();
        if (null == projectList || projectList.size() == 0) {
            return resp;
        }

        // 获得所有项目id
        Set<Integer> idSet = new HashSet<Integer>();
        for (ProjectMain pm : projectList) {
            idSet.add(pm.getId());
        }

        // 查询项目测试地址信息
        List<ProjectUrl> puList = this.projectUrlDao.getProjectUrlByProjectId(idSet.toArray(new Integer[0]));
        Map<Integer, List<ProjectUrl>> urlMap = new HashMap<Integer, List<ProjectUrl>>();
        if (null != puList && puList.size() > 0) {
            for (ProjectUrl pu : puList) {
                Integer pid = pu.getProject_id();
                if (urlMap.containsKey(pid)) {
                    List<ProjectUrl> list = urlMap.get(pid);
                    list.add(pu);
                } else {
                    List<ProjectUrl> list = new ArrayList<ProjectUrl>();
                    list.add(pu);
                    urlMap.put(pid, list);
                }
            }
        }

        // 查询项目版本信息
        List<ProjectVersion> pvList =
                this.projectVersionDao.getProjectVersionByProjectId(idSet.toArray(new Integer[0]));
        Map<Integer, List<ProjectVersion>> versionMap = new HashMap<Integer, List<ProjectVersion>>();
        if (null != pvList && pvList.size() > 0) {
            for (ProjectVersion pv : pvList) {
                if ("0（通用）".equals(pv.getVersion_code())) {
                    continue;
                }

                Integer pid = pv.getProject_id();
                if (versionMap.containsKey(pid)) {
                    List<ProjectVersion> list = versionMap.get(pid);
                    list.add(pv);
                } else {
                    List<ProjectVersion> list = new ArrayList<ProjectVersion>();
                    list.add(pv);
                    versionMap.put(pid, list);
                }
            }
        }

        resp.setProjects(projectList);
        resp.setProjectUrls(urlMap);
        resp.setProjectVersions(versionMap);
        return resp;
    }

    @Override
    public void insertProject(String pName, String pKey) throws Exception {

        // 新建项目
        ProjectMain project = new ProjectMain();
        project.setP_name(pName);
        project.setP_key(pKey);
        int pid = this.projectDao.insertProject(project);
        if (pid <= 0) {
            throw new Exception("项目新增失败，请检查数据！");
        }

        // 新建通用版本
        ProjectVersion pv = new ProjectVersion();
        pv.setProject_id(pid);
        pv.setVersion_code("0（通用）");
        int pvid = this.projectVersionDao.insertProjectVersion(pv);
        if (pvid <= 0) {
            throw new Exception("项目通用版本新增失败，请检查数据！");
        }
    }

    @Override
    public void updateProject(Integer pid, String pName, String pKey) throws Exception {

        // 新建项目
        ProjectMain project = new ProjectMain();
        project.setId(pid);
        project.setP_name(pName);
        project.setP_key(pKey);
        boolean isSuccess = this.projectDao.updateProject(project);
        if (!isSuccess) {
            throw new Exception("项目修改失败，请检查数据！");
        }
    }

    @Override
    public void deleteProject(Integer pid) throws Exception {

        boolean isSuccess = this.projectDao.deleteProject(new Integer[] { pid });
        if (!isSuccess) {
            throw new Exception("删除项目失败，pid=" + pid);
        }
    }

    @Override
    public UpdateProjectVersionResponse getProjectVersionByPid(Integer pid) throws Exception {

        UpdateProjectVersionResponse resp = new UpdateProjectVersionResponse();
        resp.setErrorcode(CommonConsts.ERROR_CODE_SUCCESS);
        resp.setErrormsg(CommonConsts.ERROR_MSG_SUCCESS);

        // 加载所有项目
        List<ProjectMain> projectList = this.projectDao.getProjectsById(new Integer[] { pid });
        if (null == projectList || projectList.size() == 0) {
            return resp;
        }

        // 设置项目
        resp.setProject(projectList.get(0));

        // 加载项目下版本号
        List<ProjectVersion> pvList = new ArrayList<ProjectVersion>();
        List<ProjectVersion> tempList = this.projectVersionDao.getProjectVersionByProjectId(new Integer[] { pid });
        for (ProjectVersion pv : tempList) {
            if ("0（通用）".equals(pv.getVersion_code())) {
                continue;
            }
            pvList.add(pv);
        }

        // 设置版本
        resp.setProjectVersionList(pvList);

        return resp;
    }

    @Override
    public void batchUpdateProjectVersion(Map<Integer, String> updateMap) throws Exception {

        if (null == updateMap || updateMap.size() == 0) {
            return;
        }

        // 组装批量map
        Map<String, Object>[] maps = new HashMap[updateMap.size()];
        int i = 0;
        for (Integer key : updateMap.keySet()) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("id", key);
            tempMap.put("versionCode", updateMap.get(key));
            maps[i++] = tempMap;
        }

        this.projectVersionDao.batchUpdateProjectVersion(maps);
    }

    @Override
    public void batchInsertProjectVersion(Integer pid, List<String> insertList) throws Exception {

        if (null == insertList || insertList.size() == 0) {
            return;
        }

        // 组装批量map
        Map<String, Object>[] maps = new HashMap[insertList.size()];
        for (int i = 0; i < insertList.size(); i++) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("pid", pid);
            tempMap.put("versionCode", insertList.get(i));
            maps[i] = tempMap;
        }

        this.projectVersionDao.batchInsertProjectVersion(maps);
    }

    @Override
    public void deleteProjectVersion(Integer vid) throws Exception {

        boolean isSuccess = this.projectVersionDao.deleteProjectVersion(new Integer[] { vid });
        if (!isSuccess) {
            throw new Exception("删除项目版本号失败，vid=" + vid);
        }
    }

    @Override
    public UpdateProjectEnvResponse getProjectUrlByPid(Integer pid) throws Exception {

        UpdateProjectEnvResponse resp = new UpdateProjectEnvResponse();
        resp.setErrorcode(CommonConsts.ERROR_CODE_SUCCESS);
        resp.setErrormsg(CommonConsts.ERROR_MSG_SUCCESS);

        // 加载所有项目
        List<ProjectMain> projectList = this.projectDao.getProjectsById(new Integer[] { pid });
        if (null == projectList || projectList.size() == 0) {
            return resp;
        }

        // 设置项目
        resp.setProject(projectList.get(0));

        // 加载项目环境信息
        List<ProjectUrl> puList = this.projectUrlDao.getProjectUrlByProjectId(new Integer[] { pid });

        // 设置环境
        resp.setProjectUrlList(puList);

        return resp;
    }

    @Override
    public void batchUpdateProjectUrl(List<ProjectUrl> updateList) throws Exception {

        if (null == updateList || updateList.size() == 0) {
            return;
        }

        this.projectUrlDao.batchUpdateProjectUrl(updateList);
    }

    @Override
    public void batchInsertProjectUrl(List<ProjectUrl> insertList) throws Exception {

        if (null == insertList || insertList.size() == 0) {
            return;
        }

        this.projectUrlDao.batchInsertProjectUrl(insertList);
    }

    @Override
    public void deleteProjectUrl(Integer uid) throws Exception {

        boolean isSuccess = this.projectUrlDao.deleteProjectUrl(new Integer[] { uid });
        if (!isSuccess) {
            throw new Exception("删除项目环境失败，uid=" + uid);
        }
    }

    public ProjectDao getProjectDao() {
        return this.projectDao;
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public ProjectUrlDao getProjectUrlDao() {
        return this.projectUrlDao;
    }

    public void setProjectUrlDao(ProjectUrlDao projectUrlDao) {
        this.projectUrlDao = projectUrlDao;
    }

    public ProjectVersionDao getProjectVersionDao() {
        return this.projectVersionDao;
    }

    public void setProjectVersionDao(ProjectVersionDao projectVersionDao) {
        this.projectVersionDao = projectVersionDao;
    }

}
