package com.zcc.reflect_practise.servcie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * @author zcc
 * @ClassName PropertiesTest
 * @description
 * @date 2021/10/15 17:15
 * @Version 1.0
 */

public class PropertiesTest {
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
        System.out.println("--------------------------------------------");

        //获取所有的key
        Enumeration<?> names = properties.propertyNames();
        //遍历得到所有key ，再用key 得到value
        while (names.hasMoreElements()) {
            Object o = names.nextElement();
            System.out.println(o.toString()+"="+properties.getProperty(o.toString()));
        }
        System.out.println("----------------------------------------------");
        //获取所有的key
        Set<String> set = properties.stringPropertyNames();
        //用iterator包装set,遍历iterator
        Iterator<String> iterator = set.iterator();
        String key;
        while (iterator.hasNext()) {
            key = iterator.next();
            System.out.println(key+"="+properties.getProperty(key));
        }

    }

}
