package com.zcc.thread_practise.Thread_conflict_demo2;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zcc
 * @ClassName SpinLock
 * @description 创建一个基于CAS算法的自旋锁
 * 所谓自旋锁，是指线程反复检查锁变量是否可用，直到成功为止。由于线程在这一过程中保持执行，
 * 因此是一种忙等待，一旦获取了自旋锁，线程会一直保持该锁，直至显式释放自旋锁。
 *
 * CAS是Compare And Set的一个简称，如下理解：
 * 1，已知当前内存里面的值current和预期要修改成的值new传入
 * 2，内存中AtomicInteger对象地址对应的真实值(因为有可能别修改)real与current对比，
 *       相等表示real未被修改过，是“安全”的，将new赋给real结束然后返回；不相等说明real已经被修改，结束并重新执行1直到修改成功
 *
 *CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。
 * CAS相比Synchronized，避免了锁的使用，总体性能比Synchronized高很多.
 * @date 2021/5/18 19:46
 * @Version 1.0
 */

public class SpinLock {
    /**
     * AtomicReference是对“对象”进行原子操作，用于规范原子变量的性质，可以保证你在修改对象引用时的线程安全性。
     * Atomic家族主要是保证多线程环境下的原子性，相比synchronized而言更加轻量级。
     */
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();
        public void lock() {
            //加锁的过程，就是把当前的thread线程对象，放入atomicReference对象 中

            //step1:获取当前线程
            Thread current = Thread.currentThread();
            System.out.println("当前获取的线程是："+current.getName());
            if (atomicReference.get() == null) {
                System.out.println("----当前原子中没有线程 ----");
            }else {
                System.out.println("----但原子中的线程是：" +atomicReference.get().getName());
            }
            //step2:循环，直到atomicReference 不为空 [解释：最开始atomicReference 为空，后来放入个当前thread 就不为空了。]
            // （compareAndSet ()第一个参数是期望值，第二个参数是更新值。）
            //CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。
            while(! atomicReference.compareAndSet(null, current)) {
                //当前的atomicReference 对象的值与 null 比较，如果相等，则把current放入atomicReference中，并返回true。 while 提交为false 不循环
                //如果不为空，则比较结果为false，不把current放入。 while 判断为true ，继续循环。继续比较
            }
        }

        public void unlock() {
            //获取当前线程
            Thread current = Thread.currentThread();
            System.out.println(current.getName() + " 释放了原子中的空间");
            //设置 atomicReference 为空
            atomicReference.compareAndSet(current, null);
        }
}
