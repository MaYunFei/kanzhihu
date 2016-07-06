package com.yunfei.net;

import com.yunfei.utils.Constant;
import com.yunfei.utils.JacksonUtil;
import com.yunfei.utils.okhttp.HttpLogInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yunfei on 16/7/4.
 */
public class RetrofitUtil {
    public static final String TAG = "RetrofitUtil";
    private static Retrofit retrofit;
    private static API api;

    protected static API getApi() {
        if (api == null) {
            api = getRetrofit().create(API.class);
        }
        return api;
    }

    protected static Retrofit getRetrofit() {
        if (retrofit == null) {


            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLogInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create(JacksonUtil.getObjectMapper()))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

        }
        return retrofit;
    }

    protected <T> Observable.Transformer<T, T> applySchedulers() {
        return transformer;
    }

    private Observable.Transformer transformer = new Observable.Transformer() {
        @Override
        public Object call(Object observable) {
            return ((Observable) observable)
                    //网络请求使用 io 线程
                    .subscribeOn(Schedulers.io())
                    //切换到主线程
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(new Func1() {
                        @Override
                        public Object call(Object response) {
                            return flatResponse((Response) response);
                        }
                    });
        }
    };


    /**
     * 处理服务器端异常
     *
     * @param response
     * @param <T>
     * @return
     */
    protected <T extends Response> Observable<T> flatResponse(T response) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response);
                        subscriber.onCompleted();
                    } else {
                        //当服务器 异常 抛出异常
                        subscriber.onError(new APIException(response.error));
                    }
                }
            }
        });
    }


}



