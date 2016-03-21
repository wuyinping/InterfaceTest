package com.baidu.mgame.interfacetest.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.baidu.mgame.interfacetest.service.IProjectService;

/**
 * 公共servlet
 *
 * @author maolei
 * @date 2015年8月30日 下午2:09:43
 * @version V1.0
 */
public class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected IProjectService projectService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 初始化引用的服务
        ServletContext servletContext = config.getServletContext();
        WebApplicationContext webApplicationContext =
                WebApplicationContextUtils.getWebApplicationContext(servletContext);

        this.projectService = webApplicationContext.getBean("projectService", IProjectService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
