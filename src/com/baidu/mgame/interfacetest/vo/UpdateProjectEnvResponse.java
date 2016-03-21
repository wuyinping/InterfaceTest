package com.baidu.mgame.interfacetest.vo;

import java.util.List;

import com.baidu.mgame.interfacetest.entity.ProjectMain;
import com.baidu.mgame.interfacetest.entity.ProjectUrl;

/**
 * 维护项目测试环境应答
 *
 * @author maolei
 * @date 2015年9月5日 下午9:20:49
 * @version V1.0
 */
public class UpdateProjectEnvResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    private ProjectMain project;
    private List<ProjectUrl> projectUrlList;

    public ProjectMain getProject() {
        return this.project;
    }

    public void setProject(ProjectMain project) {
        this.project = project;
    }

    public List<ProjectUrl> getProjectUrlList() {
        return this.projectUrlList;
    }

    public void setProjectUrlList(List<ProjectUrl> projectUrlList) {
        this.projectUrlList = projectUrlList;
    }

}
