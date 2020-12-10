package com.ncepu.cloudyilaboratory.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import lombok.SneakyThrows;

public class BIOServerSocketHandler implements Runnable {
    private SocketChannel socketChannel;

    public BIOServerSocketHandler() {

    }

    public BIOServerSocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @SneakyThrows
    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int num;
        while ((num = socketChannel.read(buffer)) > 0) {
            // flip before reading Buffer content
            buffer.flip();

            // Extracting data from Buffer
            byte[] bytes = new byte[num];
            buffer.get(bytes);

            String re = new String(bytes, "UTF-8");
            System.out.println("Server request received:" + re);
            buffer.clear();
            System.out.println("num: " + num);
        }

    }
}
