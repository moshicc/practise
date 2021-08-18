package com.zcc.others.serializable_practise;

import java.io.*;

/**
 * @author zcc
 * @ClassName SerializableTest
 * @description
 * @date 2021/8/18 19:23
 * @Version 1.0
 */

public class SerializableTest {
    public static void main(String[] args) {
        String FILE_NAME = "E:/javaio/userData.bin";
        User user = new User("张三","男",18);
        //序列化
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
                //把user对象以字节流的形式写入到userData.bin文件中(从内往外写output输出)
                //输入和输出是针对于对象（或者一段数据），如user ，需要将user数据传输到文件中就是输出，需要将文件内的数据传输到user里就是输入。
            oos.writeObject(user);
            oos.close();
            System.out.println("------------序列化，输出完毕-------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //反序列化
        User newUser = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
                //把文件中的字节流读入（从外向内input输入）
            newUser = (User) inputStream.readObject();
            inputStream.close();
            System.out.println("把文件中的数据反序列化成user对象：" + newUser.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class User implements Serializable{
    private String name;
    private transient String gender;
    private int age;

    public User() {}

    public User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
