package com.ncepu.cloudyilaboratory.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()-> {
            System.out.println(System.currentTimeMillis() / 1000 );
        }, 5, 5, TimeUnit.SECONDS);
    }
}
