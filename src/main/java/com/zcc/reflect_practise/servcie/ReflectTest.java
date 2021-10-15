package com.zcc.reflect_practise.servcie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author zcc
 * @ClassName ReflectTest
 * @description ：
 * 1. 通过加载读取配置文件spring.txt
 * 2. 获取类的全路径名和方法名
 * 3. 通过类的全路径名使用Class.forName() 获得该类的类对象
 * 4. 通过“方法名”获取方法对象
 * 5. 通过类对象得到构造方法，在创建出该对象。
 * 6. 有了“该对象”以及“方法对象”。通过 方法对象.invoke(对象) 调用该方法。
 * @date 2021/10/15 15:51
 * @Version 1.0
 */

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //从Spring.txt文件里获取类名和方法名
        File file = new File("E:\\gitcode\\github\\practise\\src\\spring.txt");
        Properties properties = new Properties();
        //加载配置文件
        properties.load(new FileInputStream(file));

        String className = (String) properties.getProperty("class");
        System.out.println(className);
        String methodName = (String) properties.getProperty("method");
        System.out.println(methodName);

        //step1. 根据类名称获取类对象
        Class<?> clazz = Class.forName(className);
        //根据方法名称 ，获取方法对象
        Method method = clazz.getMethod(methodName);
        //step2. 获取构造器
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        //step3. 根据构造器，实例化该对象
        Object object = constructor.newInstance();
        //invoker调用对象的指定方法
        method.invoke(object);
    }
}
