package com.yunfei.utils.okhttp;

import com.socks.library.KLog;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 日志拦截器
 * Created by yunfei on 16/7/5.
 */
public class HttpLogInterceptor implements Interceptor {
    private static final String TAG = "HttpLog";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        long startNs = System.nanoTime();
        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            KLog.e(TAG, "<-- HTTP FAILED: " + e);
            throw e;
        }
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
        KLog.i(TAG, "<-- " + request.method() + ' ' + response.code() + ' ' + response.message() + ' '
                + response.request().url() + " (" + tookMs + "ms" + ')');

        MediaType mediaType = null;
        String bodyString = null;
        if (response.body() != null) {
            mediaType = response.body().contentType();
            bodyString = response.body().string();
            KLog.json(TAG, bodyString);
        }

        if (response.body() != null) {
            ResponseBody body = ResponseBody.create(mediaType, bodyString);
            return response.newBuilder().body(body).build();
        } else {
            return response;
        }
    }
}
