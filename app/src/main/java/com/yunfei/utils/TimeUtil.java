package com.yunfei.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yunfei on 16/7/9.
 */
public class TimeUtil {
    public static final String DATE_FORMAT_SHORT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_PAR = "yyyyMMdd";

    /**
     * "yyyy-MM-dd" 转为 "yyyyMMdd"
     *
     * @param time
     * @return
     */
    public static String getDateParm(String time) {
        SimpleDateFormat shortFormat = new SimpleDateFormat(DATE_FORMAT_SHORT);
        Date date = shortFormat.parse(time, new ParsePosition(0));
        SimpleDateFormat parameterFormat = new SimpleDateFormat(DATE_FORMAT_PAR);
        return parameterFormat.format(date);
    }

}
