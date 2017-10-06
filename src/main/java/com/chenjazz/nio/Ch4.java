package com.chenjazz.nio;

import com.chenjazz.CommonUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Jiazhi
 * @Date 2017/2/5
 * 缓冲区（Buffer）
 */
public class Ch4 {


    /**
     * 使用Buffer读写数据一般遵循以下四个步骤：
     * 1 写入数据到Buffer
     * 2 调用flip()方法 ---flip()方法将Buffer从写模式切换到读模式。
     * 3 从Buffer中读取数据
     * 4 调用clear()方法或者compact()方法 ---clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据
     */
    public void channelRead() throws IOException {
        String fname = CommonUtil.getFileName("nio1.txt");

        RandomAccessFile aFile = new RandomAccessFile(fname, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);

        int byteRead = inChannel.read(buffer);//byteRead ：是否读完， -1表示读完

        while (byteRead != -1) {
            System.out.println("Read " + byteRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }

            buffer.clear();
            byteRead = inChannel.read(buffer);
        }

        aFile.close();


    }


    @Test
    public void bufferProperties() {
        ByteBuffer buffer = ByteBuffer.allocate(48);

        //----------------capacity-------------------------------
        //固定的大小值,你只能往里写capacity个byte、long，char等
        int capacity = buffer.capacity();
        System.out.println("capacity " + capacity);

        //----------------position-------------------------------

        //写数据到Buffer中时，position表示当前的位置
        System.out.println("position(start write) " + buffer.position());//0
        byte b = 1;
        buffer.put(new byte[]{b, b, b});//写入
        System.out.println("position(start write byte[] ) " + buffer.position());//3

        // 当从Buffer的position处读取数据时，position向前移动到下一个可读的位置(初始为0)。
        buffer.flip();
        System.out.println("position(start read) " + buffer.position());//0
        buffer.get();
        System.out.println("position(read 1) " + buffer.position());


        //----------------limit -------------------------------
        //在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据
        buffer.clear();
        buffer.put(new byte[]{b, b, b});
        System.out.println(buffer.limit());//48

        //当切换Buffer到读模式时， limit表示你最多能读到多少数据,你能读到之前写入的所有数据
        buffer.flip();
        System.out.println(buffer.limit());//3

    }

    /**
     * Buffer的分配
     */
    @Test
    public void bufferAllocate() {

        ByteBuffer buf = ByteBuffer.allocate(48);
        byte[] bytes = new byte[]{1, 3, 5};
        // CharBuffer charBuffer=CharBuffer.allocate(1024);

        //rewind
        buf.put(bytes);
        System.out.println(buf.position());
        buf.rewind();
        System.out.println(buf.position());


        //mark()与reset()方法
        buf.mark();
        System.out.println("mark " + buf.position());
        buf.put(bytes);
        System.out.println("write " + buf.position());
        buf.reset();
        System.out.println("reset " + buf.position());

        //equals()与compareTo()方法
    }


}
