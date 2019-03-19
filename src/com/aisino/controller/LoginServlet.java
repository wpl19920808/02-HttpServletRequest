package com.aisino.controller;

import com.aisino.util.MySqlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过请求对象读取浏览器中发送的请求参数
        String Username = request.getParameter("username");
        String Sex = request.getParameter("sex");
        //2.数据库中检索当前用户是否存在
        int flag = 0;
        try {
            MySqlHelper mySqlHelper = new MySqlHelper();
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            String sql = "select count(*) from person where Name = ? and Sex = ?";
            ps = mySqlHelper.conn.prepareStatement(sql);
            ps.setString(1, Username);
            ps.setString(2, Sex);
            resultSet = ps.executeQuery();
            resultSet.next();
            flag = resultSet.getInt("count(*)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(0 == flag){
            response.encodeRedirectURL("GBK");
            response.getWriter().print("用户信息不存在");
        }else{
            //传统方式：在重定向之前，先向服务端申请session
            request.getSession(true);//参数为无参或者true都可以，因为已经验证通过了，没有session就创建一个
            //通过重定向，访问MainServlet
            response.sendRedirect("/main.do");
        }
    }
}
