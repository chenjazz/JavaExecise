package com.chenjazz;

import java.net.URL;

/**
 * @Author Jiazhi
 * @Date 2017/2/5
 */
public class CommonUtil {

    public static String getFileName(String name) {
        URL url = CommonUtil.class.getClassLoader().getResource(name);
        return url.getFile();
    }
}
