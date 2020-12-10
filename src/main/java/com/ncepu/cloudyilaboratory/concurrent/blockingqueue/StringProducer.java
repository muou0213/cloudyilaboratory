package com.ncepu.cloudyilaboratory.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringProducer {

    static {
       /* System.setProperty("log4j.configurationFile", "/Users/huangyunyi/IdeaProjects/cloudyilaboratory/src/main"
                + "/resources/log4j.properties");*/
        System.setProperty("org.apache.logging.log4j.level", "info");

    }

    private static final Logger logger = LoggerFactory.getLogger(StringProducer.class);
    private static final int REMAIN_SIZE = 5;
    private static final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(16);
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    static {
        for(int i = 0; i < REMAIN_SIZE; i++) {
           offerString();
        }
    }

    public static String getString() {

        // 先重队列中拿取，如果没有则直接返回一个
        String poll = blockingQueue.poll();
        logger.info("队列中还剩{}个元素", blockingQueue.size());
        if (poll == null) {
            executorService.submit(StringProducer::offerString);
            return produceString();
        }
        if (blockingQueue.size() < REMAIN_SIZE) {
            executorService.submit(StringProducer::offerString);
        }
        return poll;
    }

    private static void offerString() {
        blockingQueue.add(produceString());
    }

    private static String produceString() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}
