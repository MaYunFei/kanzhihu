package com.yunfei.mvp;

import rx.Subscriber;

/**
 * Created by yunfei on 16/7/7.
 */
public abstract class BaseLoadingPresenter<T extends ILoadingView> extends BasePresenter<T> {
    public BaseLoadingPresenter(T view) {
        super(view);
    }

    /**
     * 方便 loading
     *
     * @param <T>
     */
    public abstract class LoadingSubscriber<T> extends Subscriber<T> {

        @Override
        public void onStart() {
            super.onStart();
            mView.showLoading();
        }

        @Override
        public void onCompleted() {
            mView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoading();
            mView.onError(e);
        }


    }
}
