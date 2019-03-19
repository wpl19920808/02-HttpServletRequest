package com.aisino.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SafeFilter", urlPatterns = "/*")
public class SafeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        //1.从拦截请求中，获得本次用户访问的资源文件地址URI
        String uri = request.getRequestURI();// 网站名/资源文件地址

        //2.本次请求如果包含“login”，无条件放行
        if(uri.indexOf("login") != -1){
            chain.doFilter(req, resp);
            return;
        }

        //3.如果用户请求与登录无关，要求被拦截用户提交httpsession对象
        HttpSession session = request.getSession(false);

        if(null == session){//恶意访问，踢回登录页面
            request.getRequestDispatcher("/Login.jsp").forward(req, resp);
        }
        else{//放行
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
