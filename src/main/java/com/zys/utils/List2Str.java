package com.zys.utils;

import java.util.List;

/**
 * @author cy
 * @create 2021-03-16-2:31 下午
 * @Description 将list转化为字符串工具类
 */
public class List2Str {

    public static String list2Str(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return list.isEmpty() ? "" : sb.toString().substring(0, sb.toString().length() - 1);
    }

    public static String Array2Str(String[] array) {
        if (array == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(",");
        }

        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
