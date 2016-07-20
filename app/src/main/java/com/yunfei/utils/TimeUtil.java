package com.yunfei.utils;

import com.socks.library.KLog;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by yunfei on 16/7/9.
 */
public class TimeUtil {

    public static final String TODAY_STRING = "今天";
    public static final String YESTERDAY_STRING = "昨天";
    public static final String THE_DAY_BEFORE_YESTERDAY_STRING = "前天";

    /**
     * 一天内的毫秒数
     */

    public static final String DATE_FORMAT_SHORT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_PAR = "yyyyMMdd";
    private static final String TAG = "TimeUtil";

    public static Date getDateFromServer(String time) {
        SimpleDateFormat shortFormat = new SimpleDateFormat(DATE_FORMAT_SHORT);
        Date date = shortFormat.parse(time, new ParsePosition(0));
        return date;
    }


    /**
     * "yyyy-MM-dd" 转为 "yyyyMMdd"
     *
     * @param time
     * @return
     */
    public static String getDateParm(String time) {

        Date date = getDateFromServer(time);
        SimpleDateFormat parameterFormat = new SimpleDateFormat(DATE_FORMAT_PAR);
        return parameterFormat.format(date);
    }


    /**
     * 解析 时间格式 返回 今天，昨天，前天，x月x日
     *
     * @param time
     * @return
     */
    public static String FriendlyDate(String time) {
        return FriendlyDate(getDateFromServer(time));
    }

    public static String FriendlyDate(Date compareDate) {
        Calendar current = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));

        Calendar today = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));    //今天

        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        //  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        Calendar yesterday = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));    //昨天

        yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        yesterday.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) - 1);
        yesterday.set(Calendar.HOUR_OF_DAY, 0);
        yesterday.set(Calendar.MINUTE, 0);
        yesterday.set(Calendar.SECOND, 0);
        yesterday.set(Calendar.MILLISECOND, 0);


        Calendar before_yesterday = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));    //前天天

        before_yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        before_yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        before_yesterday.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) - 2);
        before_yesterday.set(Calendar.HOUR_OF_DAY, 0);
        before_yesterday.set(Calendar.MINUTE, 0);
        before_yesterday.set(Calendar.SECOND, 0);
        before_yesterday.set(Calendar.MILLISECOND, 0);

        current.setTime(compareDate);

        KLog.i(TAG, "current = " + current.getTimeInMillis());
        KLog.i(TAG, "today = " + today.getTimeInMillis());
        KLog.i(TAG, "yesterday = " + yesterday.getTimeInMillis());
        KLog.i(TAG, "before_yesterday = " + before_yesterday.getTimeInMillis());

        KLog.e("比较 = " + current.compareTo(today));

        if (current.after(today) || current.getTime().compareTo(today.getTime()) == 0) {
            return TODAY_STRING;
        } else if ((current.before(today) && current.after(yesterday)) || current.compareTo(yesterday) == 0) {
            return YESTERDAY_STRING;
        } else {
            return new SimpleDateFormat("M月d日").format(compareDate);
        }
    }
}
