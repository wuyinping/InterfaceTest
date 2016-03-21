package com.baidu.mgame.interfacetest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除项目环境servlet
 *
 * @author maolei
 * @date 2015年9月6日 下午8:39:44
 * @version V1.0
 */
public class DeleteProjectEnvServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException {

        Integer uid = null;
        Integer pid = null;

        try {
            uid = Integer.valueOf(request.getParameter("uid"));
            pid = Integer.valueOf(request.getParameter("pid"));
            if (null == uid || uid.intValue() <= 0) {
                throw new IllegalArgumentException("测试环境主键参数非法！");
            }
            if (null == pid || pid.intValue() <= 0) {
                throw new IllegalArgumentException("项目主键参数非法！");
            }
            this.projectService.deleteProjectUrl(uid);
        } catch (Exception e) {
            // 错误页面
            request.getSession().setAttribute("msg", e.getMessage());
            response.sendRedirect("WebRoot/errorMsg.jsp");
            return;
        }

        // 设置返回值
        request.setAttribute("pid", pid);

        // 返回页面
        request.getRequestDispatcher("updateProjectEnv").forward(request, response);
    }

}
