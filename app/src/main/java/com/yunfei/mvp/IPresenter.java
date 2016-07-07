package com.yunfei.mvp;

/**
 * Created by yunfei on 16/7/5.
 */
public interface IPresenter {
    //开启订阅
    void subscribe();

    //结束订阅
    void unsubscribe();
}
