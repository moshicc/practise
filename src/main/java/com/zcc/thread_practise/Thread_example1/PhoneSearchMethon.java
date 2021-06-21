package com.zcc.thread_practise.Thread_example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcc
 * @ClassName PhoneSearchMethon
 * @description
 * @date 2021/5/31 19:49
 * @Version 1.0
 */

public class PhoneSearchMethon {
        Connection connection = null;

        public void search(int num) throws SQLException, ClassNotFoundException {
            connection = DbUtil.getConnection();
            PhoneBook phoneBook = new PhoneBook();
            List<PhoneBook> list = new ArrayList<>();
            String sql = "select * from phonebook where name =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < num; i++) {
                preparedStatement.setString(1,"同学" + String.valueOf(i));
                ResultSet set = preparedStatement.executeQuery();
                while (set.next()) {
                    phoneBook.setName(set.getString("name"));
                    phoneBook.setPhone(set.getString("phone"));
                    phoneBook.setAddress(set.getString("address"));
                }
                if (phoneBook != null) {
                    list.add(phoneBook);
                }
            }
            list.forEach((item) ->{
                System.out.println("姓名："+item.getName()+",电话："+item.getPhone() +",地址："+item.getAddress());
            });
        }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PhoneSearchMethon p = new PhoneSearchMethon();
        p.search(50);
    }

}
