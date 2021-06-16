package com.zcc.others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zcc
 * @ClassName AtomicReferenceTest
 * @description
 * compareAndSet ()第一个参数是期望值，第二个参数是更新值。
 * CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。
 * 当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做
 * @date 2021/5/28 14:46
 * @Version 1.0
 */

public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int expect = 4;
        int updateValue = 310;
        atomicInteger.set(4);
        int i = atomicInteger.get();
        System.out.println("当前内存中的真实值real value:" + i);
        //atomicInteger.set(5);
        boolean b = atomicInteger.compareAndSet(expect, updateValue);
        System.out.println("内存中的值与期望值是否相同："+b);
        System.out.println("交换后的内存中的值：" + atomicInteger.get());
    }
}
