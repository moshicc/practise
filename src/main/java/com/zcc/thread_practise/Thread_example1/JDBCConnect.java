package com.zcc.thread_practise.Thread_example1;

import java.sql.*;

/**
 * @author zcc
 * @ClassName JDBCConnect
 * @description
 * @date 2021/5/28 19:27
 * @Version 1.0
 */

public class JDBCConnect {
    private static String url ="jdbc:mysql://localhost:3306/sm?useUnicode=true&characterEncoding=UTF8&useSSL=true";
    private static String username = "root";
    private static String password = "123456";

    public static Connection getConnection (){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
         }
        return connection;
    }

    public static void main(String[] args){
        //测试
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from phonebook;";
             rs = statement.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
