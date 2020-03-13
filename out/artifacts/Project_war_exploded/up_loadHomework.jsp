<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/13
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>
<form action="/Project_war_exploded/upload_homework" method="POST">
    编号: <input type="text" name="id" width="20%">
    <br/>
    学号：<input type="text" name="student_id" width="20%">
    <br/>
    作业编号：<input type="text" name="homework_id" width="20%">
    <br />
    题目: <input type="text" name="homework_title" width="20%"/>
    <br/>
    内容: <textarea rows="10" cols="30" name="homework_content" width="20%"></textarea>
    <br/>
    <input type="submit" value="提交" />
</form>
</body>
</html>
