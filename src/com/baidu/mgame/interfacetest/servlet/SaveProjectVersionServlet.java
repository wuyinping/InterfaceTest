package com.baidu.mgame.interfacetest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.baidu.mgame.interfacetest.entity.ProjectVersion;
import com.baidu.mgame.interfacetest.vo.UpdateProjectVersionResponse;

/**
 * 保存项目版本号servlet
 *
 * @author maolei
 * @date 2015年9月5日 下午9:30:38
 * @version V1.0
 */
public class SaveProjectVersionServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException {

        Integer pid = null;
        // 用于记录数据库中该版本所有vid
        List<Integer> vidList = new ArrayList<Integer>();
        // 用于版本号排重检验
        Set<String> checkSet = new HashSet<String>();
        // map保存所有要更新的版本号
        Map<Integer, String> updateMap = new HashMap<Integer, String>();
        // list保存所有新增的版本号
        List<String> insertList = new ArrayList<String>();

        try {
            pid = Integer.valueOf(request.getParameter("post_pId"));
            if (null == pid || pid.intValue() <= 0) {
                throw new IllegalArgumentException("项目主键参数非法！");
            }

            // 先查库里所有的该项目版本，已过滤默认版本0
            UpdateProjectVersionResponse resp = this.projectService.getProjectVersionByPid(pid);
            if (null == resp.getProject()) {
                throw new Exception("没有对应项目信息或已被删除！");
            }

            // 解析目前存在的vid
            List<ProjectVersion> pvList = resp.getProjectVersionList();
            for (ProjectVersion pv : pvList) {
                vidList.add(pv.getId());
            }

            // 从请求中获取所有更新的版本信息
            for (Integer vid : vidList) {
                String vc = request.getParameter("versionCode" + vid);
                if (StringUtils.isBlank(vc)) {
                    throw new Exception("版本号不能输入空值，或者您操作的数据已被他人修改，请刷新！");
                }
                updateMap.put(vid, vc);
            }

            // 从请求中解析所有新增的版本信息
            String[] inserts = request.getParameterValues("versionCode0");
            if (null != inserts && inserts.length > 0) {
                for (String newVc : inserts) {
                    if (StringUtils.isBlank(newVc)) {
                        continue;
                    }
                    insertList.add(newVc);
                }
            }

            // 判断是否有重复版本号
            for (String vctmp : updateMap.values()) {
                checkSet.add(vctmp);
            }
            for (String vctmp : insertList) {
                checkSet.add(vctmp);
            }
            if (checkSet.size() != updateMap.size() + insertList.size()) {
                throw new Exception("版本号不能重复！");
            }

            // 执行批量修改版本号保存
            this.projectService.batchUpdateProjectVersion(updateMap);

            // 执行批量新增版本号保存
            this.projectService.batchInsertProjectVersion(pid, insertList);

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
