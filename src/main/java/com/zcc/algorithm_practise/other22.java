package com.zcc.algorithm_practise;

import java.util.*;

/**
 * @author zcc
 * @ClassName other22
 * @description
 * @date 2021/6/21 9:36
 * @Version 1.0
 */

public class other22 {
    public static void main(String[] args) {

        //streamHap();
        sortBull();
    }

    private static void streamHap() {
        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), UUID.randomUUID().toString().substring(0,5));
        }

        map.forEach((k, v) -> {
            System.out.println("key:" + k + " ,value:" + v);
        });
    }

    public static void sortBull(){
        int[] arr = new int[100];
        for (int index = 0; index < 100; index++) {
            arr[index] = (int) (Math.random()*1000);
        }
        Arrays.stream(arr).forEach((v)->{
            System.out.print(v + ",");
        });
        System.out.println("");


        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j <arr.length - i - 1; j++) {
                //指在什么情况下进行交换，是前大后小（前后交换），还是前小后大（前后交换）
                if (arr[j] < arr[j+1]) {
                    //核心都是 前一个 与后一个交换（把后一个先暂存，把前一个赋值个后一个，再把暂存的后一个赋值个前一个）
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(( a )->{
            System.out.print(a + ",");
        });
    }
}
