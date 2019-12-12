package com.neo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


import java.io.IOException;

/**
 */
@WebFilter(urlPatterns = "/*", filterName = "myfilter")
public class FileterController implements Filter {
    private final static String INVALID_MULTI_SLASH = "//";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter初始化中");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("开始进行过滤处理");
        //调用该方法后，表示过滤器经过原来的url请求处理方法
        HttpServletRequest request = (HttpServletRequest) servletRequest; 
        String servletPath = request.getServletPath();  //  实际路径
        String requestURI = request.getRequestURI();   // 用户路径


        System.out.println(requestURI);
        if (requestURI.startsWith("/inter/") || requestURI == "/admin/hello") {
            servletRequest.getRequestDispatcher("/failed").forward(servletRequest, servletResponse);

        } 

        // 2.0 修复
        // if (requestURI.contains(INVALID_MULTI_SLASH)){
        //     servletRequest.getRequestDispatcher("/failed").forward(servletRequest, servletResponse);
        // }
        filterChain.doFilter(servletRequest, servletResponse);
        


        // //3.0 修复
        // if (requestURI.contains("./") || requestURI.contains("/.") || requestURI.contains(";")) {
        //     servletRequest.getRequestDispatcher("/failed").forward(servletRequest, servletResponse);
        // }

        // ///   1.0版本
        
    
    }

    @Override
    public void destroy() {
        System.out.println("Filter销毁中");
    }
}
