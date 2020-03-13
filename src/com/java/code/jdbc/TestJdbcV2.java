package com.java.code.jdbc;

import java.sql.*;

public class TestJdbcV2 {
    public static String getMysql()
    {
        String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from block limit 1";
        System.out.println("hello");
        try{
            Class.forName(driverName);


        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try(   Connection connection = DriverManager.getConnection(url,"root","2019")){
            try(Statement statement = connection.createStatement();){
                try(ResultSet resultset = statement.executeQuery(sqlString);){
                    while (resultset.next()){
                        System.out.println(resultset.getLong(1));
                    }

                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        };

        return "s";
    }

    public static void main(String[] args)
    {
        getMysql();
    }

}
