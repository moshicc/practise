package com.zcc.rpc_demo_practise.demo1.rpc_server;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zcc
 * @ClassName User
 * @description
 * @date 2021/6/21 16:35
 * @Version 1.0
 */

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public String getJson(User user) {
        JSONObject json = new JSONObject();
        json.put("user",user);
        return json.toJSONString();
    }
}
