package com.aisino.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = "/main.do")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //传统方式：向当前来访用户索要session，参数是false，如果验证失败，不能为用户创建session
        HttpSession session = request.getSession(false);
        //用户身份判断
        if(null == session){// 恶意登录
            response.setCharacterEncoding("GBK");
            response.getWriter().print("恶意用户，报警了");
            return;
        }
        //下面是提供的服务
        response.setCharacterEncoding("GBK");
        response.getWriter().print("输出商业级机密");
    }
}
