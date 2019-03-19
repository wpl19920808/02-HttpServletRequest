package com.aisino.controller;

import com.aisino.util.MySqlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "PersonAddServlet", urlPatterns = "/myWeb/person/add.do")
public class PersonAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name, age, sex;
        Connection con = null;
        PreparedStatement ps = null;
        //1.读取浏览器发送的请求参数
        name = request.getParameter("name");
        sex = request.getParameter("sex");
        age = request.getParameter("age");
        System.out.println(name + " " + sex + " " + age);

        //2.对数据进行操作
        MySqlHelper mySqlHelper = new MySqlHelper();
        String sqlStr = String.format("insert into person(Name, Age, Sex) values('%s', %s, '%S')", name, age, sex);
        try{
            if(mySqlHelper.ExecuteNonquery(sqlStr)){
                System.out.println("插入成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //3.查询操作
        /*String sqlQueryStr = "select * from person";
        ResultSet resultSet = null;
        try{
            resultSet = mySqlHelper.Query(sqlQueryStr);
            while (resultSet.next()){
                System.out.println(resultSet.getString("Name") + " " +
                        resultSet.getString("Age") + " " +
                        resultSet.getString("Sex"));
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/



        mySqlHelper.Close();
    }
}
