package com.zcc.thread_practise.JUC.Free_Lock;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class LockFreeStack<T> {

    static class Node<T>{
        Node<T> next;
        T value;

        public Node(T value){
            this.next = null;
            this.value = value;
        }
    }
    AtomicStampedReference<Node<T>> head;
    public LockFreeStack(){
        Node<T> headNode = new Node<>(null);
        //第一个属性为这个atomic修饰的实际值，第二个属性为每次更新的版本号 防止ABA 问题
        head = new AtomicStampedReference<>(headNode,0);

    }

    public void push(T v){
        //头插法
        //step1:新创建一个node
        Node<T> newNode = new Node<T>(v);
        while (true) {
            //step2:先读取版本号
            int stamp = head.getStamp();
            //step3:用版本号验证现在是否可以更新newNode
                //把head它原来的那个node 取出来
            Node<T> ref = head.getReference();
                //头插法，新节点的 next 是原来的头
            newNode.next = ref;
                //把head 指向这个newNode(newNode就是新插入的头。就是把这个新的头newNode，赋值给head，再把head返回出去就ok了)
            // 需要cas操作。（防止在指向这个newNode，被其他线程抢先，那么这和newNode就不是头的。如果cas能成功，代表当前线程是最新的，没被其他改变）
            if (head.compareAndSet(ref,newNode,stamp,stamp + 1)) {
                return;
            }
        }

    }

    public T pop(){
        while (true) {
            //当前的版本号
            int stamp = head.getStamp();
            //当前head的节点
            Node<T> ref = head.getReference();
            //(并发情况下，可能上面两条执行后，切换到其他线程了)
            if (ref.next == null) {
                return null;
            }
            //head 的next 不为null时
            Node<T> next =  ref.next;
            //cas 成功，说明没有其他线程竞争改变。cas失败，说明有其他线程竞争，其他线程成功了.
            //(cas失败，那么head当前值就不会赋值成next，stamp也不会改变。)
            if(head.compareAndSet(ref,next,stamp,stamp+1)){
                return ref.value;
            }


        }

    }

    @Test
    public void testSingle(){
        LockFreeStack<Integer> stack = new LockFreeStack<>();

        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        Integer j = null;
        Integer i = 99;
        while ((j = stack.pop()) != null) {
            assertEquals(j+"", i-- +"");
        }
    }

    @Test
    public void testMultiThreads() throws InterruptedException {
        LockFreeStack<Integer> stack = new LockFreeStack<>();
        for (int i = 0; i < 16; i++) {
            Thread t = new Thread(() ->{
                for (int j = 0; j < 100; j++) {
                    stack.push(j);
                }
            });
            t.start();
            t.join();

        }
        Integer c = 0;
        while (stack.pop() != null) {
            c ++;
        }
        assertEquals(c + "", "1600");
    }

    @Test
    public void testMultiThreads2() throws InterruptedException {
           LockFreeStack<Integer> stack = new LockFreeStack<Integer>();
          List<Thread> list = IntStream.range(0, 16)
                .mapToObj(i -> {
                    Thread t = new Thread(() -> {
                        System.out.println(Thread.currentThread().getId());
                        for (int j = 0; j < 100; j++) {
                            try {
                                stack.push(j);
                                Thread.sleep(1);
                                stack.push(j);
                                Thread.sleep(1);
                                stack.pop();
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t.start();
                    return t;
                }).collect(Collectors.toList());

        list.forEach(t -> {
            System.out.println("wait join..");
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Integer c = 0;
        while(stack.pop() != null) {
            c ++;
        }
        assertEquals(c+"", "1600");
    }
}
