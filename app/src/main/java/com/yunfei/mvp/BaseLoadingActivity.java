package com.yunfei.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.socks.library.KLog;

/**
 * Created by yunfei on 16/7/4.
 */
public abstract class BaseLoadingActivity<T extends IPresenter> extends BaseActivity<T> implements ILoadingView {

    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog.show(mContext, "", "loading ...");
        } else {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onError(Throwable e) {
        KLog.e(e.getMessage());
    }


}
