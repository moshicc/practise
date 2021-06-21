package com.zcc.thread_practise.Thread_example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcc
 * @ClassName PhoneBook
 * @description
 * @date 2021/5/28 18:28
 * @Version 1.0
 */

public class PhoneBook {
    private String name;
    private String phone;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void  initPhoneBook(ArrayList<PhoneBook> inArray) {
        for (int i = 0; i < 1000; i++) {
            PhoneBook book = new PhoneBook();
            book.setName("同学" + String.valueOf(i));
            book.setPhone("电话" + String.valueOf(i));
            book.setAddress("地址" + String.valueOf(i));
            inArray.add(book);
        }
    }
}
