package com.zcc.reflect_practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zcc
 * @ClassName Person
 * @description
 * @date 2021/5/18 17:04
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private int age;

    private String gerden;

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

    public String getGerden() {
        return gerden;
    }

    public void setGerden(String gerden) {
        this.gerden = gerden;
    }
}
