package com.yunfei.net;

import android.text.TextUtils;

/**
 * Created by yunfei on 16/7/4.
 */
public class Response {
    public String error;

    /**
     * 没有 错误信息为正确
     *
     * @return
     */
    public boolean isSuccess() {
        return TextUtils.isEmpty(error);
    }
}
