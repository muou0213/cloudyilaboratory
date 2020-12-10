package com.ncepu.cloudyilaboratory.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // Listen for TCP links coming in from port 8080
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        // This will block until a connection to a request comes in.
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 只从客户端读取一次消息
        socketChannel.configureBlocking(true);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int num;
        if ((num = socketChannel.read(buffer)) > 0) {
            buffer.flip();

            byte[] re = new byte[num];
            buffer.get(re);

            String result = new String(re, "UTF-8");
            System.out.println("Server request received:" + result);
        }

        System.out.println(num);
        System.out.println("server exit " + System.currentTimeMillis());

        /*int num = socketChannel.read(buffer);
        buffer.flip();

        byte[] bytes = new byte[num];
        buffer.get(bytes);

        String re = new String(bytes, "UTF-8");
        System.out.println("Server request received:" + re);*/

        // Open a new thread to process the request and continue listening on port 8080 in the while loop
//        BIOServerSocketHandler handler = new BIOServerSocketHandler(socketChannel);
//        new Thread(handler).start();
    }




}
