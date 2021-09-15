package com.zys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cy
 * @create 2021-03-08-4:48 下午
 * @Description 时间格式化类, date 和 String 相互转换
 */
public class DateUtils {
    /**
     * Date类型转换为String类型
     *
     * @param date
     * @param patt
     * @return
     */
    public static String Date2String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    /**
     * String 类型转换为 Date类型
     *
     * @param str
     * @param patt
     * @return
     * @throws
     */
    public static Date String2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = sdf.parse(str);
        return date;
    }
}
