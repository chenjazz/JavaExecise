package com.chenjazz.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author Jiazhi
 * @Date 2017/2/5
 * Socket 通道
 */
public class Ch9 {

    @Test
    public void test1() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress("www.iteye.com", 80));

        ByteBuffer buf = ByteBuffer.allocate(1024);

        socketChannel.read(buf);

        socketChannel.close();

        buf.flip();
        System.out.println(buf.getChar());


    }

}
