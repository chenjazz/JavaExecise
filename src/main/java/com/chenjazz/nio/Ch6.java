package com.chenjazz.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import static com.chenjazz.CommonUtil.getFileName;

/**
 * @Author Jiazhi
 * @Date 2017/2/5
 * 通道之间的数据传输
 */
public class Ch6 {

    /**
     * transferFrom()
     */
    @Test
    public void tf() throws IOException {

        RandomAccessFile fromFile = new RandomAccessFile(getFileName("nio-from.txt"), "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile(getFileName("nio-to.txt"), "rw");
        FileChannel toChannel = toFile.getChannel();

        toChannel.transferFrom(fromChannel, 0, fromChannel.size());

        fromChannel.close();
        toChannel.close();
    }

    /**
     * transferTo()
     */
    @Test
    public void tt() {
        //
    }
}
