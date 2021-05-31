package com.zcc.data_structure_practise.collection_practise.list;

/**
 * @author zcc
 * @ClassName MyList
 * @description
 * @date 2021/5/31 15:15
 * @Version 1.0
 */

public interface MyList {
    //新增一个元素
    void add(Object element);
    //删除相同元素
    void delete(Object element);
    //根据索引删除元素
    void delete(int index);
    //将指定索引位置的元素替换成新元素
    void update(int index, Object newElement);
    //当前列表中是否含有target这个元素
    boolean contains(Object target);
    //返回指定索引出的元素
    Object at(int index);
    //查找element的索引，如果没有返回-1
    int indexOf(Object e);

    int size();
}
