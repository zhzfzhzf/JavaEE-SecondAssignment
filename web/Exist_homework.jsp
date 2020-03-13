<%@ page import="com.java.code.model.Homework" %>
<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.model.Student_Homework" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/12
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">返回上一页</a>
<br/>
<table align="center" width="960" border="1" bgcolor="#7fffd4"
       cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#faebd7" height="50">
        <td>ID</td>
        <td>标题</td>
        <td>内容</td>
        <td>创建时间</td>
    </tr>
    <%
        List<Homework> list = StudentHomeworkJdbc.Query_homework();
        if(list==null || list.size()<=0){
            out.print("None data");
        }else{
            for(Homework hh:list)
            {

    %>

    <tr align="center">
        <td width="15%"><%=hh.getId()%></td>
        <td width="15%"><%=hh.getTitle()%></td>
        <td width="50%"><%=hh.getContent()%></td>
        <td width="20%"><%=hh.getCreate_time()%></td>
    </tr>
    <% }}%>
</table>
</body>
</html>
