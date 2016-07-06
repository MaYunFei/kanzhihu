package com.yunfei.mvp;

/**
 * Created by yunfei on 16/7/4.
 */
public interface ILoading {
    void showLoading();
    void hideLoading();
    void onError(Throwable e);
}
