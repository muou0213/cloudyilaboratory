package com.ncepu.cloudyilaboratory.gcfinalize;

import java.util.ArrayList;
import java.util.List;

public class User {

    // 这是个类变量，会被分配到方法区中，跟着类元信息一起被回收
    private static final List<User> userList = new ArrayList<>();


    private byte[] userBytes = new byte[1024 * 1024];

    public void finalize() {
        userList.add(this);
        System.out.println("我被gc回收了");
    }
}
