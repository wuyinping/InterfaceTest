package com.baidu.mgame.interfacetest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * 新增项目servlet
 *
 * @author maolei
 * @date 2015年8月30日 下午2:16:11
 * @version V1.0
 */
public class SaveProjectServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        Integer pid = null;
        String pName = null;
        String pKey = null;

        try {
            String pid_str = request.getParameter("post_pId");
            if (StringUtils.isNotBlank(pid_str)) {
                pid = Integer.valueOf(pid_str);
            }
            pName = request.getParameter("post_pName");
            pKey = request.getParameter("post_pKey");
            if (StringUtils.isBlank(pName) || StringUtils.isBlank(pKey)) {
                throw new IllegalArgumentException("参数不能为空！");
            }

            if (null == pid || pid <= 0) {
                this.projectService.insertProject(pName, pKey);
            } else {
                this.projectService.updateProject(pid, pName, pKey);
            }
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
