package com.baidu.mgame.interfacetest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.baidu.mgame.interfacetest.entity.ProjectUrl;
import com.baidu.mgame.interfacetest.vo.UpdateProjectEnvResponse;

/**
 * 保存项目环境servlet
 *
 * @author maolei
 * @date 2015年9月5日 下午9:30:38
 * @version V1.0
 */
public class SaveProjectEnvServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException {

        Integer pid = null;
        // 用于记录数据库中该版本所有vid
        List<Integer> uidList = new ArrayList<Integer>();
        // 用于环境名称排重检验
        Set<String> checkSet = new HashSet<String>();
        // list保存所有要更新的环境信息
        List<ProjectUrl> updateList = new ArrayList<ProjectUrl>();
        // list保存所有新增的环境信息
        List<ProjectUrl> insertList = new ArrayList<ProjectUrl>();

        try {
            pid = Integer.valueOf(request.getParameter("post_pId"));
            if (null == pid || pid.intValue() <= 0) {
                throw new IllegalArgumentException("项目主键参数非法！");
            }

            // 先查库里所有的该项目环境
            UpdateProjectEnvResponse resp = this.projectService.getProjectUrlByPid(pid);
            if (null == resp.getProject()) {
                throw new Exception("没有对应项目信息或已被删除！");
            }

            // 解析目前存在的uid
            List<ProjectUrl> puList = resp.getProjectUrlList();
            for (ProjectUrl pu : puList) {
                uidList.add(pu.getId());
            }

            // 从请求中获取所有更新的环境信息
            for (Integer uid : uidList) {
                String uName = request.getParameter("urlName" + uid);
                String url = request.getParameter("baseUrl" + uid);
                if (StringUtils.isBlank(uName) || StringUtils.isBlank(url)) {
                    throw new Exception("环境信息不能输入空值，或者您操作的数据已被他人修改，请刷新！");
                }

                ProjectUrl temp = new ProjectUrl();
                temp.setId(uid);
                temp.setProject_id(pid);
                temp.setBase_url(url);
                temp.setUrl_name(uName);
                updateList.add(temp);
            }

            // 从请求中解析所有新增的环境信息
            String[] insertNames = request.getParameterValues("urlName0");
            String[] insertUrls = request.getParameterValues("baseUrl0");
            if (null != insertNames && insertNames.length > 0) {
                for (int i = 0; i < insertNames.length; i++) {
                    String uName = insertNames[i];
                    String url = insertUrls[i];
                    if (StringUtils.isBlank(uName) || StringUtils.isBlank(url)) {
                        continue;
                    }

                    ProjectUrl temp = new ProjectUrl();
                    temp.setProject_id(pid);
                    temp.setBase_url(url);
                    temp.setUrl_name(uName);
                    insertList.add(temp);
                }
            }

            // 判断是否有名称重复
            for (ProjectUrl pu : updateList) {
                checkSet.add(pu.getUrl_name());
            }
            for (ProjectUrl pu : insertList) {
                checkSet.add(pu.getUrl_name());
            }
            if (checkSet.size() != updateList.size() + insertList.size()) {
                throw new Exception("地址名称不能重复！");
            }

            // 执行批量修改版本号保存
            this.projectService.batchUpdateProjectUrl(updateList);

            // 执行批量新增版本号保存
            this.projectService.batchInsertProjectUrl(insertList);

        } catch (Exception e) {
            // 错误页面
            request.getSession().setAttribute("msg", e.getMessage());
            response.sendRedirect("WebRoot/errorMsg.jsp");
            return;
        }

        // 返回页面
        response.sendRedirect("projectView");
    }

}
