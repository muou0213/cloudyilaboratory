package com.ncepu.cloudyilaboratory.callcenter;

/**
 * @Author: yun
 * @Date: created in 11:28 上午 2020/12/8
 **/
public interface CallHandler {
    void handleCall();
    boolean canHandle();
}
