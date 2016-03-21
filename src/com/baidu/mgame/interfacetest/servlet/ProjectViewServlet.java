package com.baidu.mgame.interfacetest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.mgame.interfacetest.vo.ProjectViewResponse;

/**
 * 项目初始化servlet
 *
 * @author maolei
 * @date 2015年8月30日 下午2:16:11
 * @version V1.0
 */
public class ProjectViewServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        ProjectViewResponse resp = null;
        try {
            resp = this.projectService.getAllProjectView();
        } catch (Exception e) {
            // 错误页面
            request.getSession().setAttribute("msg", e.getMessage());
            response.sendRedirect("WebRoot/errorMsg.jsp");
            return;
        }

        // 设置返回值
        request.setAttribute("response", resp);

        // 返回页面
        request.getRequestDispatcher("WebRoot/projectView.jsp").forward(request, response);
    }

}
