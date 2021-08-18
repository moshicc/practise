package com.zcc.reflect_practise;

/**
 * @author zcc
 * @ClassName PersonMethod
 * @description
 * @date 2021/6/29 9:53
 * @Version 1.0
 */

public class PersonMethod {

    public String introduct(String name, int age, String gender) {
        String msg = "";
        Person person = new Person(name,age,gender);
        msg = person.toString();
        return msg;
    }
    private String methodA() {
        return "A";
    }
}
