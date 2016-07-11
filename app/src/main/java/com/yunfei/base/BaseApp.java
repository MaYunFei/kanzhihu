package com.yunfei.base;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by yunfei on 16/7/8.
 */
public class BaseApp extends Application {
    private static final String PARAM_SCREEN_WIDTH = "PARAM_SCREEN_WIDTH";
    private static final String PARAM_SCREEN_HEIGHT = "PARAM_SCREEN_HEIGHT";

    private SharedPreferences mSp;
    private int mScreenWidth;
    private int mScreenHeight;

    private static BaseApp instance;

    public static BaseApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSp = PreferenceManager.getDefaultSharedPreferences(this);
        mScreenWidth = mSp.getInt(PARAM_SCREEN_WIDTH, 0);
        mScreenHeight = mSp.getInt(PARAM_SCREEN_HEIGHT, 0);
        instance = this;
    }

    public int getScreenWidth() {
        return mScreenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        if (mScreenWidth == screenWidth)
            return;

        mScreenWidth = screenWidth;
        mSp.edit().putInt(PARAM_SCREEN_WIDTH, mScreenWidth).apply();
    }

    public int getScreenHeight() {
        return mScreenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        if (mScreenHeight == screenHeight)
            return;

        mScreenHeight = screenHeight;
        mSp.edit().putInt(PARAM_SCREEN_HEIGHT, mScreenHeight).apply();
    }


}
