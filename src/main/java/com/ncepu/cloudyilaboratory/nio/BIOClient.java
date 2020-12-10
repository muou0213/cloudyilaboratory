package com.ncepu.cloudyilaboratory.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class BIOClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
//        Thread.sleep(1000);
//        System.out.println("client exit " + System.currentTimeMillis());

        // Send requests
        ByteBuffer buffer = ByteBuffer.wrap("1234567890".getBytes());
        socketChannel.write(buffer);

        Thread.sleep(1000);
        socketChannel.write(ByteBuffer.wrap("hello".getBytes()));

        System.out.println("client exit " + System.currentTimeMillis());


        /* ByteBuffer readBuffer = ByteBuffer.allocate(1024);

        int num;
        if ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();

            byte[] re = new byte[num];
            readBuffer.get(re);

            String result = new String(re, "UTF-8");
            System.out.println("Return value: " + result);
        }*/
    }
}
