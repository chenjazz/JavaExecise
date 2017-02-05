package com.chenjazz.nio;

import static com.chenjazz.CommonUtil.getFileName;

import com.chenjazz.CommonUtil;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通道（Channel）
 */
public class Ch3 {


//    @Test
//    public void channelRead() throws IOException {
//        String fname = CommonUtil.getFileName("nio1.txt");
//
//        RandomAccessFile aFile = new RandomAccessFile(fname, "rw");
//        FileChannel inChannel = aFile.getChannel();
//
//        ByteBuffer buffer = ByteBuffer.allocate(48);
//
//        int byteRead = inChannel.read(buffer);//byteRead ：是否读完， -1表示读完
//
//        while (byteRead != -1) {
//            System.out.println("Read " + byteRead);
//            buffer.flip();
//            while (buffer.hasRemaining()) {
//                System.out.println((char) buffer.get());
//            }
//
//            buffer.clear();
//            byteRead = inChannel.read(buffer);
//        }
//
//        aFile.close();
//
//
//    }


}
