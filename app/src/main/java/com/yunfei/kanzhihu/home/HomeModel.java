package com.yunfei.kanzhihu.home;

import com.yunfei.kanzhihu.bean.CheckNew;
import com.yunfei.kanzhihu.bean.Getposts;
import com.yunfei.net.RetrofitUtil;

import rx.Observable;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomeModel extends RetrofitUtil {


    public Observable<CheckNew> checkNew(String time) {
        return getApi().checkNew(time)
                .compose(applySchedulers());
    }


    public Observable<Getposts> getPosts(String time) {
        return getApi().getposts(time)
                .compose(applySchedulers());
    }


}
