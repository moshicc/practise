package com.zcc.collection_practise;

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
        demo1.getAllKey(map);

    }
    //循环的方式创建一个map
    public HashMap<Integer, Object> createMap() {
        HashMap<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i,i + "AA");
        }
        return map;
    }
    //遍历一个map
    public void eachMap(HashMap<Integer, Object> map) {
        Collection collection = map.values();
        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    //遍历map的所有的key
    public void getAllKey(HashMap<Integer, Object> map) {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("key:" + key);
        }

        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            System.out.println("key: ---->" + key);
        }
    }



}
