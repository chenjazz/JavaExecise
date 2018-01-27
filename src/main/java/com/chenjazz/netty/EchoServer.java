package com.chenjazz.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Chenjiazhi
 * 2018-01-27
 */
public class EchoServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        serverBootstrap.group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .localAddress(9899)
                .childHandler()
    }
}
