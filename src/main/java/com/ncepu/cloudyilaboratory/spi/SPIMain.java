package com.ncepu.cloudyilaboratory.spi;

import java.util.ServiceLoader;

public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        // 使用for循环拿取实现类的实例
        for (IShout s : shouts) {
            s.shout();
        }
        // 使用while拿取实现类的实例
       /* Iterator<IShout> shoutIterator = shouts.iterator();
        while(shoutIterator.hasNext()) {
            IShout s = shoutIterator.next();
            s.shout();
        }*/
    }
}
