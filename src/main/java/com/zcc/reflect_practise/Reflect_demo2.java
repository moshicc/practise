package com.zcc.reflect_practise;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zcc
 * @ClassName Reflect_demo2
 * @description
 * @date 2021/6/29 10:09
 * @Version 1.0
 */

public class Reflect_demo2 {
    //根据类clazz创建对象
    public static <T> T newInstance(Class<T> clazz) {
        T instance = null;

        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public static Method[] getPublicMethods(Class clazz) {
        List<Method> pmethods = new ArrayList<>();
        //返回该类声明的所有方法
        Method[] methods = clazz.getDeclaredMethods();
//        pmethods = Arrays.stream(methods)
//                .filter((method)->{return Modifier.isPublic(method.getModifiers());})
//                .collect(Collectors.toList());
        return pmethods.toArray(new Method[0]);


    }
}
