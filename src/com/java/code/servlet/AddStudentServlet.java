package com.java.code.servlet;

import com.java.code.jdbc.StudentHomeworkJdbc;
import com.java.code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/add_student")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Student st = new Student();
        st.setId(Integer.valueOf(req.getParameter("id")));
        st.setName(req.getParameter("name"));
        st.setCreate_time(sqlDate);
        System.out.println(st.getId()+","+st.getName()+","+st.getCreate_time());
        StudentHomeworkJdbc.addStudent(st);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
