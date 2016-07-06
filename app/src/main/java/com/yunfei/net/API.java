package com.yunfei.net;

import com.yunfei.kanzhihu.bean.CheckNew;
import com.yunfei.kanzhihu.bean.Getposts;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yunfei on 16/7/4.
 */
public interface API {

    @GET("getposts/{time}")
    Observable<Getposts> getposts(@Path("time") String time);

    @GET("checknew/{time}")
    Observable<CheckNew> checkNew(@Path("time") String time);

}
