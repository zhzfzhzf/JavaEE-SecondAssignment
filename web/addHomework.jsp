<%@ page import="java.util.Date" %>
<%@ page import="com.java.code.model.Student" %>
<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %>
<%@ page import="com.java.code.model.Homework" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/11
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加作业</title>
</head>
<body>
<form action="/Project_war_exploded/add_homework" method="POST">
    作业编号: <input type="text" name="id" width="20%">
    <br />
    题目: <input type="text" name="title" width="20%"/>
    <br/>
    内容: <textarea rows="10" cols="30" name="content" width="20%"></textarea>
    <br/>
    <input type="submit" value="提交" />
</form>


</body>
</html>
