package com.chenjazz.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author Jiazhi
 * @Date 2017/2/5
 * 选择器（Selector）
 */
public class Ch7 {
//    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//
//serverSocketChannel.socket().bind(new InetSocketAddress(9999));

    @Test
    public void test1() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();

        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(9999));


        Selector selector = Selector.open();

        //TODO  EXCEPTION
        channel.register(selector, SelectionKey.OP_READ);


        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }
    }

}
