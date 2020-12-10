package com.ncepu.cloudyilaboratory.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    private final ReentrantLock lock = new ReentrantLock();
    public void testTryLockWithTime() {
        System.out.println("test try lock with time in");
        boolean locked = false;
        try {
            locked = lock.tryLock(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        System.out.println("test try lock with time out");
    }

    public void testTryLock() {
        System.out.println("test try lock in");
        boolean locked = false;
        locked = lock.tryLock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        System.out.println("test try lock out");
    }

    public void testLock() {
        lock.lock();
        lock.unlock();
    }

    public void testLockIn() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestReentrantLock testLock = new TestReentrantLock();

        // 带限制时间的tryLock在没有或得到锁的并且时间过期的情况下，依然会执行后面的代码
        new Thread(testLock :: testTryLock).start();
        new Thread(testLock :: testTryLockWithTime).start();
    }
}
