package com.zcc.thread_practise.JUC.AQS.MyLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *类说明：实现一个自己的类ReentrantLock
 * 基于AQS自实现的锁(独占式)
 */
public class SelfLock implements Lock {

    //state 表示获取到锁 state=1 获取到了锁，state=0，表示这个锁当前没有线程拿到
    private static class Sync extends AbstractQueuedSynchronizer {

        //是否占用
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        //通过state维护当前是否有线程拿到锁，获取锁也就是通过CAS的方式将state从0设置为1,成功后将独占锁设置为自己
        protected boolean tryAcquire(int tag) {
            if (compareAndSetState(0,1)) {
                //if成功,说明state为0，没有线程持有这个锁，设置拥有独占访问权（独占锁）
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //这地方不用使用CAS的原因是释放锁只有当前拿到锁的一个线程可以释放，所以不存在竞争条件
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new UnsupportedOperationException();
            }
            //state 不为0 ，当前线程持有这个锁。把当前线程持有的这个锁设置为null，即释放锁
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }

    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);

    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
