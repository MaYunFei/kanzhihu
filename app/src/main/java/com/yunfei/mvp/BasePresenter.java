package com.yunfei.mvp;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by yunfei on 16/7/5.
 */
public abstract class BasePresenter implements IBasePresenter {
    protected CompositeSubscription mCompositeSubscription;

    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }

        mCompositeSubscription.add(s);
    }

    public void unSubscription() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void unsubscribe() {
        unSubscription();
    }

    protected abstract ILoading getLoadingView();

    public abstract class LoadingSubscriber<T> extends Subscriber<T> {

        @Override
        public void onStart() {
            super.onStart();
            getLoadingView().showLoading();
        }

        @Override
        public void onCompleted() {
            getLoadingView().hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            getLoadingView().hideLoading();
            getLoadingView().onError(e);
        }


    }


}
