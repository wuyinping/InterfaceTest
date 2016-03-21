package com.baidu.mgame.interfacetest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除项目版本号servlet
 *
 * @author maolei
 * @date 2015年9月6日 下午8:39:44
 * @version V1.0
 */
public class DeleteProjectVersionServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException {

        Integer vid = null;
        Integer pid = null;

        try {
            vid = Integer.valueOf(request.getParameter("vid"));
            pid = Integer.valueOf(request.getParameter("pid"));
            if (null == vid || vid.intValue() <= 0) {
                throw new IllegalArgumentException("版本号主键参数非法！");
            }
            if (null == pid || pid.intValue() <= 0) {
                throw new IllegalArgumentException("项目主键参数非法！");
            }
            this.projectService.deleteProjectVersion(vid);
        } catch (Exception e) {
            // 错误页面
            request.getSession().setAttribute("msg", e.getMessage());
            response.sendRedirect("WebRoot/errorMsg.jsp");
            return;
        }

        // 设置返回值
        request.setAttribute("pid", pid);

        // 返回页面
        request.getRequestDispatcher("updateProjectVersion").forward(request, response);
    }

}
