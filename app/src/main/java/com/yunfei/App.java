package com.yunfei;

import android.app.Application;

import com.socks.library.KLog;
import com.yunfei.kanzhihu.BuildConfig;

/**
 * Created by yunfei on 16/7/4.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化 log
        KLog.init(BuildConfig.LOG_DEBUG);
    }
}
