package com.zcc.algorithm_practise;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zcc
 * @ClassName other22
 * @description
 * @date 2021/6/21 9:36
 * @Version 1.0
 */

public class other22 {
    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), UUID.randomUUID().toString().substring(0,5));
        }

        map.forEach((k, v) -> {
            System.out.println("key:" + k + " ,value:" + v);
        });
    }
}
