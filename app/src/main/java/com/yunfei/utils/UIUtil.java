package com.yunfei.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by yunfei on 16/7/8.
 */
public class UIUtil {
    private static float scale = -1.0f;
    private static float fontScale = -1.0f;
    private static int width;
    private static int height;

    /**
     * 初始化工具类
     * <p/>
     * activity
     */
    public static void init(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        scale = dm.density;
        fontScale = dm.scaledDensity;
        width = dm.widthPixels;
        height = dm.heightPixels;
    }

    public static int getSreenWidth() {
        return width;
    }

    public static int getSreenHeight() {
        return height;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        return (int) (dpValue * scale + 0.5f);
    }

    public static int dip2px(double dpValue) {
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(float pxValue) {
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(float spValue) {
        return (int) (spValue * fontScale + 0.5f);
    }

}
