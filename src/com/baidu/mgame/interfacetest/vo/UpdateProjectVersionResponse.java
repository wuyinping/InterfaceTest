package com.baidu.mgame.interfacetest.vo;

import java.util.List;

import com.baidu.mgame.interfacetest.entity.ProjectMain;
import com.baidu.mgame.interfacetest.entity.ProjectVersion;

/**
 * 维护项目版本号应答
 *
 * @author maolei
 * @date 2015年9月5日 下午9:20:49
 * @version V1.0
 */
public class UpdateProjectVersionResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    private ProjectMain project;
    private List<ProjectVersion> projectVersionList;

    public ProjectMain getProject() {
        return this.project;
    }

    public void setProject(ProjectMain project) {
        this.project = project;
    }

    public List<ProjectVersion> getProjectVersionList() {
        return this.projectVersionList;
    }

    public void setProjectVersionList(List<ProjectVersion> projectVersionList) {
        this.projectVersionList = projectVersionList;
    }

}
