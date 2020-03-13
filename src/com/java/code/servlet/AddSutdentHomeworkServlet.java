package com.java.code.servlet;

import com.java.code.jdbc.StudentHomeworkJdbc;
import com.java.code.model.Student_Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.sql.Date;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet("/upload_homework")
public class AddSutdentHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student_Homework sh = new Student_Homework();
        sh.setId(Integer.valueOf(req.getParameter("id")));
        sh.setStudentid(Integer.valueOf(req.getParameter("student_id")));
        sh.setHomework(Integer.valueOf(req.getParameter("homework_id")));
        sh.setHomeworkTitle(req.getParameter("homework_title"));
        sh.setHomeworkContent(req.getParameter("homework_content"));
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        sh.setCreateTime(sqlDate);
        StudentHomeworkJdbc.addStudentHomework(sh);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
