package com.zcc.data_structure_practise.collection_practise.list;

/**
 * @author zcc
 * @ClassName MyArrayList
 * @description 用顺序存储（数组）方式来实现列表
 * @date 2021/5/31 15:19
 * @Version 1.0
 */

public class MyArrayList implements MyList {
    private Object[] elements; //真正储存元素的底层结构
    private int size = 0;  //元素的个数 //也可以指向空的位置
    private int capacity = 10; //容量
    //用户来指定容量
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    //可以使用默认值容量
    public MyArrayList() {
        elements = new Object[capacity];
    }

    @Override
    public void add(Object element) {
        if (size == capacity) { //扩容
            capacity *= 2; //扩容一倍
            Object[] newArray = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
        elements[size] = element;
        size ++;
    }

    @Override
    public void delete(Object element) {
        int index = indexOf(element);
        if (index >= 0) {
            delete(index);
        }else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void delete(int index) {
        for (int i = index; index < size; index++) {
            elements[index] = elements[index + 1];
        }
        elements[elements.length -1] = null;
        size --;
    }

    @Override
    public void update(int index, Object newElement) {
        elements[index] = newElement;
    }

    @Override
    public boolean contains(Object target) {

        return indexOf(target) >= 0;
    }

    @Override
    public Object at(int index) {

        return elements[index];
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i] + (i == size -1 ? "" : ","));
        }
        sb.append("]");
        return sb.toString();
    }
}
