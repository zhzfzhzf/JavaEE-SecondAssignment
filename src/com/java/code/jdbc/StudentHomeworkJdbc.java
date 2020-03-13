package com.java.code.jdbc;

import com.java.code.model.Homework;
import com.java.code.model.Student;
import com.java.code.model.Student_Homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    public static void main(String[] args)
    {
        List<Student_Homework> worklist = selectAll();
        for(Student_Homework hh:worklist)
        {
            System.out.println(hh.getCreateTime());
            System.out.println(hh.getHomework());
            System.out.println(hh.getHomeworkContent());
            System.out.println(hh.getHomeworkTitle());
            System.out.println(hh.getId());
            System.out.println(hh.getStudentid());
            System.out.println(hh.getUpdateTime());
        }
    }

    public static void addStudentHomework(Student_Homework sh)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/name?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "insert into s_student_homework(id,student_id,homework_id,homework_title,homework_content,create_time) values(?,?,?,?,?,?)";

        try{
            Class.forName(driverName);

        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try(   Connection connection = DriverManager.getConnection(url,"root","2019")){
                try(PreparedStatement ps = connection.prepareStatement(sqlString)){
                    ps.setInt(1,sh.getId());
                    ps.setInt(2,sh.getStudentid());
                    ps.setInt(3,sh.getHomework());
                    ps.setString(4,sh.getHomeworkTitle());
                    ps.setString(5,sh.getHomeworkContent());
                    ps.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
                    System.out.println(sh.getId()+","+sh.getStudentid()+","+sh.getHomework()+","+sh.getHomeworkTitle()+","+sh.getHomeworkContent());
                    ps.execute();
                    }
                }

        catch(SQLException e){
            e.printStackTrace();
        };


    }
    public static List<Student_Homework> selectAll()
    {  String url = "jdbc:mysql://127.0.0.1:3306/name?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from s_student_homework";

        try{
            Class.forName(driverName);

        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        List<Student_Homework> listsh = new ArrayList<>();
        try(   Connection connection = DriverManager.getConnection(url,"root","2019")){
            try(Statement statement = connection.createStatement();){
                try(ResultSet resultset = statement.executeQuery(sqlString);){
                    while (resultset.next()){
                        Student_Homework sh = new Student_Homework();
                        sh.setId(resultset.getInt("id"));
                        sh.setStudentid(resultset.getInt("student_id"));
                        sh.setHomework(resultset.getInt("homework_id"));
                        sh.setHomeworkTitle(resultset.getString("homework_title"));
                        sh.setHomeworkContent(resultset.getString("homework_content"));
                        sh.setCreateTime(resultset.getTimestamp("create_time"));
                        listsh.add(sh);
                    }

                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        };
        return listsh;}

    public static void addStudent(Student st)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/name?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "insert into s_student(id,name,create_time) values(?,?,?)";
        try{
            Class.forName(driverName);

        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try(   Connection connection = DriverManager.getConnection(url,"root","2019")){
            try(PreparedStatement ps = connection.prepareStatement(sqlString)){
                ps.setInt(1,st.getId());
                ps.setString(2,st.getName());
                ps.setDate(3,st.getCreate_time());
                ps.execute();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        };
    }

    public static void addHomework(Homework hw)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/name?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "insert into s_homework(id,title,content,create_time) values(?,?,?,?)";
        try{
            Class.forName(driverName);

        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try(   Connection connection = DriverManager.getConnection(url,"root","2019")){
            try(PreparedStatement ps = connection.prepareStatement(sqlString)){
                ps.setInt(1,hw.getId());
                ps.setString(2,hw.getTitle());
                ps.setString(3,hw.getContent());
                ps.setDate(4,hw.getCreate_time());
                ps.execute();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        };
    }

    public static List<Homework> Query_homework()
    {
        String url = "jdbc:mysql://127.0.0.1:3306/name?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from s_homework";

        try{
            Class.forName(driverName);
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        List<Homework> listhw = new ArrayList<>();
        try(   Connection connection = DriverManager.getConnection(url,"root","2019")){
            try(Statement statement = connection.createStatement();){
                try(ResultSet resultset = statement.executeQuery(sqlString);){
                    while (resultset.next()){
                        Homework sh = new Homework();
                        sh.setId(resultset.getInt("id"));
                        sh.setTitle(resultset.getString("title"));
                        sh.setContent(resultset.getString("content"));
                        sh.setCreate_time(resultset.getDate("create_time"));
                        listhw.add(sh);
                    }

                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        };
        return listhw;
    }

}
