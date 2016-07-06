package com.yunfei.kanzhihu.home;

import com.yunfei.kanzhihu.bean.Getposts;
import com.yunfei.mvp.BasePresenter;
import com.yunfei.mvp.ILoading;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomePresenter extends BasePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private HomeModel mModel;

    public HomePresenter(HomeContract.View mView, HomeModel mModel) {
        this.mView = mView;
        this.mModel = mModel;
        mView.setPresenter(this);

    }

    @Override
    public void subscribe() {
        mModel.getPosts("1411261200")
                .subscribe(new LoadingSubscriber<Getposts>() {
                    @Override
                    public void onNext(Getposts getposts) {

                    }
                });
    }

    @Override
    protected ILoading getLoadingView() {
        return mView;
    }
}
