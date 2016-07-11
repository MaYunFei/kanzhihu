package com.yunfei;

import com.socks.library.KLog;
import com.yunfei.base.BaseApp;
import com.yunfei.kanzhihu.BuildConfig;

/**
 * Created by yunfei on 16/7/4.
 */
public class App extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化 log
        KLog.init(BuildConfig.LOG_DEBUG);
    }
}
