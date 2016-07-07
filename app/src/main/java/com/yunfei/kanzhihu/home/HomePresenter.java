package com.yunfei.kanzhihu.home;

import com.yunfei.kanzhihu.bean.Getposts;
import com.yunfei.mvp.BaseLoadingPresenter;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomePresenter extends BaseLoadingPresenter<HomeContract.View> implements HomeContract.Presenter {
    private HomeModel mModel;

    public HomePresenter(HomeContract.View view) {
        super(view);
        mModel = new HomeModel();
    }

    @Override
    public void subscribe() {
        mModel.getPosts("")
                .subscribe(new LoadingSubscriber<Getposts>() {
                    @Override
                    public void onNext(Getposts getposts) {

                    }
                });
    }


}
