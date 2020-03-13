package com.java.code.servlet;

import com.java.code.jdbc.StudentHomeworkJdbc;
import com.java.code.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/add_homework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Homework hw = new Homework();
        hw.setId(Integer.valueOf(req.getParameter("id")));
        hw.setTitle(req.getParameter("title"));
        hw.setContent(req.getParameter("content"));
        hw.setCreate_time(sqlDate);
        StudentHomeworkJdbc.addHomework(hw);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
