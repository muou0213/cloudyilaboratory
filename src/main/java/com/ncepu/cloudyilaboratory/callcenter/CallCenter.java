package com.ncepu.cloudyilaboratory.callcenter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCenter {
    public  final BlockingQueue<User> jQueue = new LinkedBlockingQueue();
    public  final BlockingQueue<User> zQueue = new LinkedBlockingQueue();
    public  final BlockingQueue<User> jlQueue = new LinkedBlockingQueue();

    private CallCenter() {}

    public static final CallCenter instance = new CallCenter();

    public void dispatchCall() {
        User u;
        if ((u = jQueue.poll()) != null && u.canHandle()) {
            u.handleCall();
        } else if ((u = zQueue.poll()) != null && u.canHandle()) {
            u.handleCall();
        } else if ((u = jlQueue.poll()) != null && u.canHandle()) {
            u.handleCall();
        } else {
            System.out.println("系统繁忙");
        }

    }
}
