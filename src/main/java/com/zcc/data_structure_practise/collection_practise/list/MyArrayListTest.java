package com.zcc.data_structure_practise.collection_practise.list;

/**
 * @author zcc
 * @ClassName MyArrayListTest
 * @description
 * @date 2021/5/31 15:20
 * @Version 1.0
 */

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        System.out.println("-----增加元素测试-----");
        list.add("nike");
        list.add("addids");
        list.add("NB");
        list.add("NB");
        System.out.println(list);
        System.out.println("-----删除元素测试-----");
        list.delete(1);
        System.out.println("删除addids后输出："+list);
        list.delete("NB");
        System.out.println("删除NB后输出："+list);
        System.out.println("-----更改测试-----");
        list.update(1,"syx");
        System.out.println("更改scy为syx"+list);
        System.out.println("-----查找测试-----");
        boolean b=list.contains("nike");
        System.out.println("查找是否有nike  "+b);
        int index=list.indexOf("syx");
        System.out.println("查找syx的位置   "+index);
        Object a=list.at(0);
        System.out.println("查找第一个元素Nike   "+a);
    }
}
