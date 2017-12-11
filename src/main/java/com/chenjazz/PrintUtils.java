package com.chenjazz;

import java.util.Objects;

public class PrintUtils {

    public static void println() {
        System.out.println();
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void println(String value, Object... params) {
        for (Object p : params) {
            value = value.replaceFirst("\\{}", String.valueOf(p));
        }
        System.out.println(value);
    }

//    public static void println(Object... param) {
//        StringBuilder str = new StringBuilder();
//        for (Object o : param) {
//            str.append(o).append(" ");
//        }
//        System.out.println(str);
//    }
}
