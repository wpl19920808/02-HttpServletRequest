package com.aisino.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ThreeServlet", urlPatterns = "/myWeb/three")
public class ThreeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.向tomcat索要当前用户的httpsession
        HttpSession session = request.getSession(false);
        //2.针对没有购物的客户处理方案
        if(session == null){
            //通过请求转发，向tomcat申请调用index.jsp
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        //3.针对已经购物的客户处理方案
        Enumeration enu = session.getAttributeNames();//将session所有对象取出来，并放到枚举对象中
        while(enu.hasMoreElements()){
            String goodsName = (String)enu.nextElement();
            int goodsNum = (int)session.getAttribute(goodsName);
            System.out.println("商品名称：" + goodsName + "  商品数量" + goodsNum);
        }
    }
}
