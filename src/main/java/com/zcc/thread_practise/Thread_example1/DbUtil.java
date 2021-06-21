package com.zcc.thread_practise.Thread_example1;

import java.sql.*;

/**
 * @author zcc
 * @ClassName DbUtil
 * @description
 * @date 2021/5/31 18:57
 * @Version 1.0
 */

public class DbUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/sm?useUnicode=true&characterEncoding=UTF8&useSSL=true";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        return conn;
    }

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        //2. 获得数据库连接
        Connection conn = DbUtil.getConnection();
        //3.操作数据库，实现增删改查
//        Statement stmt = conn.createStatement();
        //ResultSet rs = stmt.executeQuery("SELECT * FROM phonebook");
        //如果有数据，rs.next()返回true
        String sql = "insert into phonebook (id,name,phone,address) values(?,?,?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        for (int i = 2; i < 100; i++) {
            ptmt.setString(1, String.valueOf(i));
            ptmt.setString(2,"同学"+ i);
            ptmt.setString(3,"电话"+i);
            ptmt.setString(4,"地址"+i);
            //执行
            ptmt.execute();
        }
       // stmt.executeQuery(sql);
//        while(rs.next()){
//            System.out.println(rs.getString("name")+" 电话："+rs.getString("phone"));
//        }
    }
}
