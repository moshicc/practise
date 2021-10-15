package com.zcc.reflect_practise.servcie;

/**
 * @author zcc
 * @ClassName Service1
 * @description
 * @date 2021/10/15 15:44
 * @Version 1.0
 */

public class Service1 {
    public void doService1(){
        System.out.println("业务方法1");
    }

    public static void main(String[] args) throws ClassNotFoundException {
       Class clazz = Class.forName("com.zcc.reflect_practise.servcie.Service1");
       System.out.println(clazz.getName());
    }
}
