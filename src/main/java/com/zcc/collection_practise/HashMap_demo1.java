package com.zcc.collection_practise;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * @author zcc
 * @ClassName HashMap_demo1
 * @description
 * @date 2021/5/13 9:45
 * @Version 1.0
 */

public class HashMap_demo1 {
    public static void main(String[] args) {
        HashMap_demo1 demo1 = new HashMap_demo1();
        HashMap<Integer, Object> map = demo1.createMap();
        demo1.getKeyValueStream(map);

    }
    //循环的方式创建一个map
    public HashMap<Integer, Object> createMap() {
        HashMap<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i,i + "AA");
        }
        return map;
    }
    //遍历map的所有的value
    public void eachMap(HashMap<Integer, Object> map) {
        Collection collection = map.values();
        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    //遍历map所有的value
    public void getAllValue(HashMap<Integer, Object> map) {
        Iterator<Object> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println("value:" + value.toString());
        }
    }
    //遍历map的所有的key
    public void getAllKey(HashMap<Integer, Object> map) {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("key:" + key);
        }
    }
    //遍历map的所有的key
    public void getAllKey2(HashMap<Integer, Object> map) {
        Set<Integer> set = map.keySet();
        for (int key : set) {
            System.out.println("key:" + key);
        }
    }

    //遍历map的所有 键值对 entity 实体
    public void getAllValue2(HashMap<Integer, Object> map) {
        Iterator iterator =  map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("map:" + iterator.next());
        }
    }
    //遍历map的所有 键值对 entity 实体
    public void getAllValue3(HashMap<Integer, Object> map) {
        Set set = map.entrySet();
        for (Object value : set) {
            System.out.println("map:" + value);
        }
    }


    //遍历map中所有的key 和value (用先遍历得到所有的key ，再用key得到value)
    public void getAllKeyAndValue(HashMap<Integer, Object> map){
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = (int) iterator.next();
            System.out.println("key:" + key + " ---- value:" +map.get(key));

            //每当使用一次iterator.next() 后，iterator.next()指向 向下移动一位,所以下面这个写法有问题。 key;0  ---map.get(1)
           // System.out.println("key:" + iterator.next() + " ----- value:" + map.get(iterator.next()));
        }
    }
    //遍历map中所有的key  value  （使用EntitySet的方法）
    public void getAllKeyAndValue2(HashMap<Integer, Object> map) {
        //map.entitySet() 相当于取map中所有的entity键值对 放到一个Set集合中
        Set<Map.Entry<Integer, Object>> set = map.entrySet();
        for (Map.Entry<Integer, Object> entry : set) {
            System.out.println("key:" + entry.getKey() + " ---- value:" +entry.getValue());
        }
    }
    //使用Lambda表达式 得到map的所有key 和value
    public void getKeyAndValueLam(HashMap<Integer, Object> map) {
        map.forEach((key, value) -> {
            System.out.println("key:" + key + " ---- value:" +value);
        });
    }
    //Streams API 单线程 遍历
    public void getKeyValueStream(HashMap<Integer, Object> map) {
        map.entrySet().stream().forEach((entity) -> {
            System.out.println("key:" + entity.getKey() + " ---- value:" + entity.getValue());

        });
    }




}
