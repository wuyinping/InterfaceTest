package com.baidu.mgame.interfacetest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.mgame.interfacetest.vo.UpdateProjectVersionResponse;

/**
 * 维护项目版本号servlet
 *
 * @author maolei
 * @date 2015年9月5日 下午9:30:38
 * @version V1.0
 */
public class UpdateProjectVersionServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException {

        UpdateProjectVersionResponse resp = null;
        Integer pid = null;

        try {
            pid = Integer.valueOf(request.getParameter("pid"));
            if (null == pid || pid.intValue() <= 0) {
                throw new IllegalArgumentException("项目主键参数非法！");
            }
            resp = this.projectService.getProjectVersionByPid(pid);
            if (null == resp.getProject()) {
                throw new Exception("没有对应项目信息或已被删除！");
            }
        } catch (Exception e) {
            // 错误页面
            request.getSession().setAttribute("msg", e.getMessage());
            response.sendRedirect("WebRoot/errorMsg.jsp");
            return;
        }

        // 设置返回值
        request.setAttribute("response", resp);

        // 返回页面
        request.getRequestDispatcher("WebRoot/projectVersion.jsp").forward(request, response);
    }

}
