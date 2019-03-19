package com.aisino.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "OneServlet", urlPatterns = "/myWeb/one")
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.向tomcat索要当前用户的【httpsession】
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(120);// 设置一个session空闲时间2mins
        //2.索要当前用户本次选择的商品名称
        String goodsName = request.getParameter("name");
        //3.判断用户之前是否选择过这种商品
        Object goodsNum = session.getAttribute(goodsName);
        if(goodsNum == null){// 没添加过购物车
            session.setAttribute(goodsName, 1);
        }else{
            session.setAttribute(goodsName, (int)goodsNum +1);
        }
    }
}
