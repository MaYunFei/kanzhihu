package com.yunfei.net;

/**
 * 服务器 接口异常 error 不为空时抛出异常
 * Created by yunfei on 16/7/5.
 */
public class APIException extends Exception {
    public APIException(String detailMessage) {
        super(detailMessage);
    }
}
