package com.ncepu.cloudyilaboratory.concurrent;

public class TestSynchronized {

    public void test() {
        synchronized(TestSynchronized.class) {
            System.out.println("test in");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test out");
        }
    }

    public static synchronized void testStatic() {
        System.out.println("test static in");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test static out");
    }

    public synchronized void testMemberMethod() {
        System.out.println("test member method in");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test member method out");
    }

    public void testWait(String index) {
        synchronized(this) {
            System.out.println("test wait in " + index);
            try {
                this.wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test wait out " + index);
        }
    }

    public void testNotifyAll() {
        synchronized(this) {
            System.out.println("notify all");
            this.notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify all out");
        }
    }

    public static void main(String[] args) {
        TestSynchronized testSynchronized1 = new TestSynchronized();
        TestSynchronized testSynchronized2 = new TestSynchronized();

//        new Thread(TestSynchronized :: testStatic).start();
        new Thread(() -> testSynchronized1.testWait("wait1")).start();
        new Thread(() -> testSynchronized1.testWait("wait2")).start();
        new Thread(testSynchronized1 :: testNotifyAll).start();
    }
}
