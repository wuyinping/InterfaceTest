package com.baidu.mgame.interfacetest.vo;

import java.util.List;
import java.util.Map;

import com.baidu.mgame.interfacetest.entity.ProjectMain;
import com.baidu.mgame.interfacetest.entity.ProjectUrl;
import com.baidu.mgame.interfacetest.entity.ProjectVersion;

/**
 * 项目初始化请求应答
 *
 * @author maolei
 * @date 2015年8月30日 下午2:39:48
 * @version V1.0
 */
public class ProjectViewResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    private List<ProjectMain> projects;
    private Map<Integer, List<ProjectUrl>> projectUrls;
    private Map<Integer, List<ProjectVersion>> projectVersions;

    public List<ProjectMain> getProjects() {
        return this.projects;
    }

    public void setProjects(List<ProjectMain> projects) {
        this.projects = projects;
    }

    public Map<Integer, List<ProjectUrl>> getProjectUrls() {
        return this.projectUrls;
    }

    public void setProjectUrls(Map<Integer, List<ProjectUrl>> projectUrls) {
        this.projectUrls = projectUrls;
    }

    public Map<Integer, List<ProjectVersion>> getProjectVersions() {
        return this.projectVersions;
    }

    public void setProjectVersions(Map<Integer, List<ProjectVersion>> projectVersions) {
        this.projectVersions = projectVersions;
    }

}
