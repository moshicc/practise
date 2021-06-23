package com.zcc.algorithm_practise.sort;

import java.util.Arrays;

/**
 * @author zcc
 * @ClassName BubbleSort
 * @description 冒泡排序
 * @date 2021/6/21 9:39
 * @Version 1.0
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("排序前：");
        Arrays.stream(arr).forEach(value -> {
            System.out.print(value + ",");
        });

        System.out.println("");
        BubbleSort sort = new BubbleSort();
        int[] arrSort = sort.bubbleSort(arr);
        for (int index = 0; index < arrSort.length; index++) {
            System.out.print(arrSort[index] + ",");
        }
    }


    public int[] bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                //指在什么情况下进行交换，是前大后小（前后交换），还是前小后大（前后交换）
                if (arr[j] > arr[j+1]) {
                    //核心都是 前一个 与后一个交换（把后一个先暂存，把前一个赋值个后一个，再把暂存的后一个赋值个前一个）
                    int temp = arr[j + 1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }
}
