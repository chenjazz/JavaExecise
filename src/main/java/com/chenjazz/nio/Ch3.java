package com.chenjazz.nio;

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
