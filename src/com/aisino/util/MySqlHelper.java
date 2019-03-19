package com.aisino.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlHelper {
    public static final String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC ";// 设置时区
    public static final String name = "com.mysql.cj.jdbc.Driver";// 需要用新版本驱动，加上cj
    public static final String user = "root";
    public static final String password = "123456";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public MySqlHelper(){
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Close(){
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet Query(String sql){
        ResultSet resultset = null;
        try{
            pst = conn.prepareStatement(sql);
            resultset = pst.executeQuery();
        }catch (Exception ex){
            System.out.println("查询错误");
        }
        return resultset;
    }

    public boolean ExecuteNonquery(String sql){
        boolean flag = false;
        try{
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            flag = true;
        }catch (Exception e){
            System.out.println("操作数据失败");
            e.printStackTrace();
        }
        return flag;
    }

    public int getCount(String sql){
        int count = 0;
        try{
            pst = conn.prepareStatement(sql);
            ResultSet resultset = pst.executeQuery();
            resultset.last();
            count = resultset.getRow();
            resultset.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
