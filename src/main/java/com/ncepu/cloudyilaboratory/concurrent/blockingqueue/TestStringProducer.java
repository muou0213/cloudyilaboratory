package com.ncepu.cloudyilaboratory.concurrent.blockingqueue;

import java.util.concurrent.CountDownLatch;

public class TestStringProducer {
    public void testStringProducer_OneConsumer() {
        String string = StringProducer.getString();
        System.out.println(string);
    }

    public void testStringProducer_TenConsumer() {
        int parallelism = 10;
        CountDownLatch latch = new CountDownLatch(parallelism);
        for (int i = 0; i < parallelism; i++) {
            new Thread(() -> {
                latch.countDown();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String string = StringProducer.getString();
                System.out.println(string);
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String string = StringProducer.getString();
        System.out.println(string);
    }

    public static void main(String[] args) {
        new TestStringProducer().testStringProducer_TenConsumer();
    }
}
