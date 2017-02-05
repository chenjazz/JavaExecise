package com.chenjazz.nio;

import org.junit.Test;

import java.io.*;

import static com.chenjazz.CommonUtil.getFileName;

/**
 * @Author Jiazhi
 * @Date 2017/2/5
 * NIO vs IO
 */
public class Ch2 {
    @Test
    public void ioRead() throws IOException {
        InputStream stream = new FileInputStream(getFileName("nio1.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

        String name = bufferedReader.readLine();
        String age = bufferedReader.readLine();
        String emailLine = bufferedReader.readLine();
        String phoneLine = bufferedReader.readLine();

        System.out.println(name);
        System.out.println(age);
        System.out.println(emailLine);
        System.out.println(phoneLine);

        bufferedReader.close();
        stream.close();


    }
}
