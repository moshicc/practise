package com.zcc.thread_practise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Thread_demo5_callable {
    public volatile static int sum;
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        for (int i = 0; i < 10; i++) {
            final int a = i;
//            new Thread(new FutureTask<>(new Callable<Object>() {
////                @Override
////                public Object call() throws Exception {
////                    System.out.println(Thread.currentThread().getName()+ "---->"+ a);
////                    return null;
////                }
////            })).start();


            //既然Callable()是一个函数式接口，那么就可以用lambda表达式简写，再{}重写call方法
//            new Thread(new FutureTask<>(() -> {
//                sum = sum + 1;
//                System.out.println(sum);
//                return null;
//            })).start();

            //把new FutureTask拿出来 不就可以获取返回值了吗
            FutureTask task = new FutureTask(()->{
                sum = sum + 1;
                return sum;
            });
            new Thread(task).start();
            System.out.println(task.get());

            //TimeUnit.SECONDS.sleep(1);
        }

    }
}
