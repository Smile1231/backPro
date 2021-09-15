package com.zys.utils;

import java.util.Date;

/**
 * @author cy
 * @create 2021-03-14-9:24 下午
 * @Description
 */
public class NowTime {

    public static String getNowTime() {
        return DateUtils.Date2String(new Date(), "yyyy-MM-dd HH:mm:ss");
    }
}
