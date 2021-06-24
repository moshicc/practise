package com.zcc.thread_practise.JUC.Function_Inface4.stream;

import lombok.Data;

/**
 * @author zcc
 * @ClassName User
 * @description
 * @date 2021/6/24 20:05
 * @Version 1.0
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
