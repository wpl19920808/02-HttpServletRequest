<%--
  Created by IntelliJ IDEA.
  User: Anthony
  Date: 2019-3-6
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <center>
      <form action="/myWeb/person/add.do">
        姓名：<input type="text" name="name"/><br/>
        性别：<input type="text" name="sex"/><br/>
        年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="添加人员"/>
      </form>
    </center>

  <form action="/myWeb/one">
      <table border="2">
          <tr>
              <td>商品价格</td>
              <td>商品单价</td>
              <td>添加到购物车</td>
          </tr>
          <tr>
              <td>Servlet项目集合</td>
              <td>30.00</td>
              <td><a href="/myWeb/one?name=Servlet项目集合">添加购物车</a> </td>
          </tr>

          <tr>
              <td>牛栏山二锅头</td>
              <td>10.00</td>
              <td><a href="/myWeb/one?name=牛栏山二锅头">添加购物车</a> </td>
          </tr>

          <tr>
              <td>IBM笔记本</td>
              <td>10000.00</td>
              <td><a href="/myWeb/one?name=IBM笔记本">添加购物车</a> </td>
          </tr>

          <tr>
              <td colspan="2">
                  <a href="/myWeb/three">
                      查看购物车
                  </a>
              </td>
          </tr>
      </table>
  </form>
  </body>
</html>
