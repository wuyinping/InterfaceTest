package com.baidu.mgame.interfacetest.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除项目servlet
 *
 * @author maolei
 * @date 2015年8月30日 下午10:02:23
 * @version V1.0
 */
public class DeleteProjectServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        Integer pid = null;

        try {
            pid = Integer.valueOf(request.getParameter("pid"));
            if (null == pid || pid.intValue() <= 0) {
                throw new IllegalArgumentException("项目主键参数非法！");
            }
            this.projectService.deleteProject(pid);

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
