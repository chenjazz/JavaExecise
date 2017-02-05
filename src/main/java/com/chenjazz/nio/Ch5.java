package com.chenjazz.nio;

import com.chenjazz.CommonUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * @Author Jiazhi
 * @Date 2017/2/5
 * 分散（Scatter）/聚集（Gather）
 */
public class Ch5 {

    FileChannel channel;

    @Before
    public void setChannel() throws FileNotFoundException {
        String fname = CommonUtil.getFileName("nio2.txt");

        RandomAccessFile aFile = new RandomAccessFile(fname, "rw");
        this.channel = aFile.getChannel();
        System.out.println("Ch5.setChannel");

    }


    @Test
    public void testScatter() throws IOException {


        ByteBuffer header = ByteBuffer.allocate(6);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};

        channel.read(bufferArray);

        header.flip();
        body.flip();
        System.out.println((char) header.get());
        System.out.println((char) body.get());
    }

    @Test
    public void testGathering() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(6);
        ByteBuffer body = ByteBuffer.allocate(1024);
        byte b = 97;
        header.put(b);
        body.put(b);

        ByteBuffer[] bufferArray = {header, body};

        channel.write(bufferArray);


    }


    @After
    public void after() throws IOException {
        channel.close();
    }
}
